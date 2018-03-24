package com.jagex.runescape.util;
import java.applet.Applet;
import java.io.*;
import java.net.*;
import javax.sound.midi.*;
import javax.sound.sampled.*;

public final class SignLink implements Runnable {
	
	public static final int CLIENT_REVISION = 377;
	
	public static int uid;
	public static int storeId = 32;
	public static RandomAccessFile cacheData = null;
	public static final RandomAccessFile[] cacheIndex = new RandomAccessFile[5];
	public static Applet applet = null;
	private static boolean active;
	private static int threadLiveId;
	private static InetAddress inetAddress;
	private static int socketRequest;
	private static Socket socket = null;
	private static int threadRequestPriority = 1;
	private static Runnable threadRequest = null;
	private static String dnsRequest = null;
	public static String dns = null;
	private static String urlRequest = null;
	private static DataInputStream urlStream = null;
	private static int savelen;
	private static String saveRequest = null;
	private static byte[] savebuf = null;
	private static boolean play;
	private static int midipos;
	public static String midi = null;
	public static int midiVolume;
	public static int fadeMidi;
	private static boolean midiplay;
	private static int wavepos;
	public static int wavevol;
	public static boolean reporterror = true;
	public static String errorname = "";
	public static boolean musicEnable = true;


	public static final void initialize(InetAddress inetaddress) {
		threadLiveId = (int) (Math.random() * 99999999D);
		if (active) {
			try {
				Thread.sleep(500L);
			} catch (Exception _ex) {
			}
			active = false;
		}
		socketRequest = 0;
		threadRequest = null;
		dnsRequest = null;
		saveRequest = null;
		urlRequest = null;
		inetAddress = inetaddress;
		Thread thread = new Thread(new SignLink());
		thread.setDaemon(true);
		thread.start();
		while (!active)
			try {
				Thread.sleep(50L);
			} catch (Exception _ex) {
			}
	}

	enum Position {
		LEFT, RIGHT, NORMAL
	};

	private final int EXTERNAL_BUFFER_SIZE = 524288; // 128Kb
	private Position curPosition;

	public void run() {
		active = true;
		String directory = cacheLocation();
		uid = getUID(directory);
		try {
			cacheData = new RandomAccessFile(directory + "main_file_cache.dat", "rw");
			for (int idx = 0; idx < 5; idx++)
				cacheIndex[idx] = new RandomAccessFile(directory + "main_file_cache.idx" + idx, "rw");
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		for (int i = threadLiveId; threadLiveId == i;) {
			if (socketRequest != 0) {
				try {
					socket = new Socket(inetAddress, socketRequest);
				} catch (Exception _ex) {
					socket = null;
				}
				socketRequest = 0;
			} else if (threadRequest != null) {
				Thread thread = new Thread(threadRequest);
				thread.setDaemon(true);
				thread.start();
				thread.setPriority(threadRequestPriority);
				threadRequest = null;
			} else if (dnsRequest != null) {
				try {
					dns = InetAddress.getByName(dnsRequest).getHostName();
				} catch (Exception _ex) {
					dns = "unknown";
				}
				dnsRequest = null;
			} else if (saveRequest != null) {
				if (savebuf != null)
					try {
						FileOutputStream fileoutputstream = new FileOutputStream(directory + saveRequest);
						fileoutputstream.write(savebuf, 0, savelen);
						fileoutputstream.close();
					} catch (Exception _ex) {
					}
				if (midiplay) {
					String wave = directory + saveRequest;
					midiplay = false;
					AudioInputStream audioInputStream = null;
					try {
						audioInputStream = AudioSystem.getAudioInputStream(new File(wave));
					} catch (UnsupportedAudioFileException e1) {
						e1.printStackTrace();
						return;
					} catch (IOException e1) {
						e1.printStackTrace();
						return;
					}
					AudioFormat format = audioInputStream.getFormat();
					SourceDataLine auline = null;
					DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
					try {
						auline = (SourceDataLine) AudioSystem.getLine(info);
						auline.open(format);
					} catch (LineUnavailableException e) {
						e.printStackTrace();
						return;
					} catch (Exception e) {
						e.printStackTrace();
						return;
					}
					if (auline.isControlSupported(FloatControl.Type.PAN)) {
						FloatControl pan = (FloatControl) auline.getControl(FloatControl.Type.PAN);
						if (curPosition == Position.RIGHT)
							pan.setValue(1.0f);
						else if (curPosition == Position.LEFT)
							pan.setValue(-1.0f);
					}
					auline.start();
					int nBytesRead = 0;
					byte[] abData = new byte[EXTERNAL_BUFFER_SIZE];
					try {
						while (nBytesRead != -1) {
							nBytesRead = audioInputStream.read(abData, 0,
									abData.length);
							if (nBytesRead >= 0)
								auline.write(abData, 0, nBytesRead);
						}
					} catch (IOException e) {
						e.printStackTrace();
						return;
					} finally {
						auline.drain();
						auline.close();
					}
				}
				if (play) {
					midi = directory + saveRequest;
					try {
						if (music != null) {
							music.stop();
							music.close();
						}
						playMidi(midi);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
					play = false;
				}
				saveRequest = null;
			} else if (urlRequest != null) {
				try {
					System.out.println("urlStream");
					urlStream = new DataInputStream((new URL(applet.getCodeBase(), urlRequest)).openStream());
				} catch (Exception _ex) {
					urlStream = null;
				}
				urlRequest = null;
			}
			try {
				Thread.sleep(50L);
			} catch (Exception _ex) {
			}
		}
	}

	/**
	 * Plays the specified midi sequence.
	 * @param location
	 */
	private void playMidi(String location) {
		music = null;
		synthesizer = null;
		sequence = null;
		File midiFile = new File(location);
		try {
			if (musicEnable) {
				sequence = MidiSystem.getSequence(midiFile);
				music = MidiSystem.getSequencer();
				music.open();
				music.setSequence(sequence);
			}
		} catch (Exception e) {
			System.err.println("Problem loading MIDI file.");
			e.printStackTrace();
			return;
		}
		if (music instanceof Synthesizer) {
			synthesizer = (Synthesizer) music;
		} else {
			try {
				synthesizer = MidiSystem.getSynthesizer();
				synthesizer.open();
				if (synthesizer.getDefaultSoundbank() == null) {
					music.getTransmitter().setReceiver(MidiSystem.getReceiver());
				} else {
					music.getTransmitter().setReceiver(synthesizer.getReceiver());
				}
			} catch (Exception e) {
				e.printStackTrace();
				return;
			}
		}
		music.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
		music.start();
	}

	/**
	 * Sets the volume for the midi synthesizer.
	 * @param value
	 */
	public static void setVolume(int value) {
		int CHANGE_VOLUME = 7;
		midiVolume = value;
		if (synthesizer.getDefaultSoundbank() == null) {
			try {
				ShortMessage volumeMessage = new ShortMessage();
				for (int i = 0; i < 16; i++) {
					volumeMessage.setMessage(ShortMessage.CONTROL_CHANGE, i, CHANGE_VOLUME, midiVolume);
					volumeMessage.setMessage(ShortMessage.CONTROL_CHANGE, i, 39, midiVolume);
					MidiSystem.getReceiver().send(volumeMessage, -1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			MidiChannel[] channels = synthesizer.getChannels();
			for (int c = 0; channels != null && c < channels.length; c++) {
				channels[c].controlChange(CHANGE_VOLUME, midiVolume);
				channels[c].controlChange(39, midiVolume);
			}
		}
	}

	public static Sequencer music = null;
	public static Sequence sequence = null;
	public static Synthesizer synthesizer = null;

	public static String cacheLocationOrig() {
		String locations[] = { "c:/windows/", "c:/WINDOWS/", "c:/winnt/",
				"d:/windows/", "d:/winnt/", "e:/windows/", "e:/winnt/",
				"f:/windows/", "f:/winnt/", "c:/", "~/", "/tmp/", "",
				"c:/rscache", "/rscache" };
		String cacheFolder = ".377galkon";
		for (int i = 0; i < locations.length; i++) {
			try {
				String location = locations[i];
				if (location.length() > 0) {
					File file = new File(location);
					if (!file.exists())
						continue;
				}
				File finalDirectory = new File(location + cacheFolder);
				if (finalDirectory.exists() || finalDirectory.mkdir())
					return location + cacheFolder
							+ System.getProperty("file.separator");
			} catch (Exception _ex) {
			}
		}
		return System.getProperty("user.home")
				+ System.getProperty("file.separator") + cacheFolder
				+ System.getProperty("file.separator");
	}

	public static String cacheLocation() {
		String name = ".377cache";
		File file = new File(System.getProperty("user.home") + System.getProperty("file.separator") + name + System.getProperty("file.separator"));
		if (!file.exists()) {
			if (!file.mkdir()) {
				return secondaryLocation();
			}
		}
		return System.getProperty("user.home") + System.getProperty("file.separator") + name + System.getProperty("file.separator");
	}

	public static String secondaryLocation() {
		File file = new File("c:/.377cache/");
		if (!file.exists())
			file.mkdir();
		return file.toString();
	}

	private static int getUID(String name) {
		try {
			File file = new File(name + "uid.dat");
			if (!file.exists() || file.length() < 4L) {
				DataOutputStream dataoutputstream = new DataOutputStream(new FileOutputStream(name + "uid.dat"));
				dataoutputstream.writeInt((int) (Math.random() * 99999999D));
				dataoutputstream.close();
			}
		} catch (Exception _ex) {
		}
		try {
			DataInputStream datainputstream = new DataInputStream(new FileInputStream(name + "uid.dat"));
			int i = datainputstream.readInt();
			datainputstream.close();
			return i + 1;
		} catch (Exception _ex) {
			return 0;
		}
	}

	public static synchronized Socket openSocket(int i) throws IOException {
		for (socketRequest = i; socketRequest != 0;)
			try {
				Thread.sleep(50L);
			} catch (Exception _ex) {
			}
		if (socket == null)
			throw new IOException("could not open socket");
		else
			return socket;
	}

	public static synchronized DataInputStream openURL(String s) throws IOException {
		for (urlRequest = s; urlRequest != null;)
			try {
				Thread.sleep(50L);
			} catch (Exception _ex) {
			}
		if (urlStream == null)
			throw new IOException("could not open: " + s);
		else
			return urlStream;
	}

	public static synchronized void dnslookup(String s) {
		dns = s;
		dnsRequest = s;
	}

	public static synchronized void startThread(Runnable runnable, int i) {
		threadRequestPriority = i;
		threadRequest = runnable;
	}

	public static synchronized boolean saveWave(byte abyte0[], int i) {
		if (i > 0x1e8480)
			return false;
		if (saveRequest != null) {
			return false;
		} else {
			wavepos = (wavepos + 1) % 5;
			savelen = i;
			savebuf = abyte0;
			midiplay = true;
			saveRequest = "sound" + wavepos + ".wav";
			return true;
		}
	}

	public static synchronized boolean replayWave() {
		if (saveRequest != null) {
			return false;
		} else {
			savebuf = null;
			midiplay = true;
			saveRequest = "sound" + wavepos + ".wav";
			return true;
		}
	}

	public static synchronized void saveMidi(byte abyte0[], int i) {
		if (i > 0x1e8480)
			return;
		if (saveRequest != null) {
		} else {
			midipos = (midipos + 1) % 5;
			savelen = i;
			savebuf = abyte0;
			play = true;
			saveRequest = "jingle" + midipos + ".mid";
		}
	}

	public static void reporterror(String s) {
		System.out.println("Error: " + s);
	}

	private SignLink() {
	}


}
package com.jagex.runescape.cache.media;

import com.jagex.runescape.Archive;
import com.jagex.runescape.Buffer;
import com.jagex.runescape.media.Animation;

public class AnimationSequence {

	public static int count;
	public static AnimationSequence cache[];
	public int frameCount;
	public int frame2Ids[];
	public int frame1Ids[];
	public int frameLenghts[];
	public int frameStep = -1;
	public int flowControl[];
	public boolean aBoolean300 = false;
	public int anInt301 = 5;
	public int anInt302 = -1;
	public int anInt303 = -1;
	public int anInt304 = 99;
	public int anInt305 = -1;
	public int priority = -1;
	public int anInt307 = 2;
	public int anInt308;

	public static void load(Archive archive) {
		Buffer buffer = new Buffer(archive.getFile("seq.dat"));
		AnimationSequence.count = buffer.getUnsignedLEShort();
		if (AnimationSequence.cache == null)
			AnimationSequence.cache = new AnimationSequence[AnimationSequence.count];
		for (int animation = 0; animation < count; animation++) {
			if (AnimationSequence.cache[animation] == null)
				AnimationSequence.cache[animation] = new AnimationSequence();
			AnimationSequence.cache[animation].loadDefinition(buffer);
		}
	}

	public int getFrameLength(int animationId) {
		int frameLength = frameLenghts[animationId];
		if (frameLength == 0) {
			Animation animation = Animation.getAnimation(frame2Ids[animationId]);
			if (animation != null)
				frameLength = frameLenghts[animationId] = animation.anInt431;
		}
		if (frameLength == 0)
			frameLength = 1;
		return frameLength;
	}

	public void loadDefinition(Buffer buf) {
		while (true) {
			int attributeId = buf.getUnsignedByte();
			if (attributeId == 0)
				break;
			if (attributeId == 1) {
				frameCount = buf.getUnsignedByte();
				frame2Ids = new int[frameCount];
				frame1Ids = new int[frameCount];
				frameLenghts = new int[frameCount];
				for (int frame = 0; frame < frameCount; frame++) {
					frame2Ids[frame] = buf.getUnsignedLEShort();
					frame1Ids[frame] = buf.getUnsignedLEShort();
					if (frame1Ids[frame] == 65535)
						frame1Ids[frame] = -1;
					frameLenghts[frame] = buf.getUnsignedLEShort();
				}

			} else if (attributeId == 2)
				frameStep = buf.getUnsignedLEShort();
			else if (attributeId == 3) {
				int flowCount = buf.getUnsignedByte();
				flowControl = new int[flowCount + 1];
				for (int flow = 0; flow < flowCount; flow++)
					flowControl[flow] = buf.getUnsignedByte();

				flowControl[flowCount] = 0x98967f;
			} else if (attributeId == 4)
				aBoolean300 = true;
			else if (attributeId == 5)
				anInt301 = buf.getUnsignedByte();
			else if (attributeId == 6)
				anInt302 = buf.getUnsignedLEShort();
			else if (attributeId == 7)
				anInt303 = buf.getUnsignedLEShort();
			else if (attributeId == 8)
				anInt304 = buf.getUnsignedByte();
			else if (attributeId == 9)
				anInt305 = buf.getUnsignedByte();
			else if (attributeId == 10)
				priority = buf.getUnsignedByte();
			else if (attributeId == 11)
				anInt307 = buf.getUnsignedByte();
			else if (attributeId == 12)
				anInt308 = buf.getInt();
			else
				System.out.println("Error unrecognised seq config code: " + attributeId);
		}
		if (frameCount == 0) {
			frameCount = 1;
			frame2Ids = new int[1];
			frame2Ids[0] = -1;
			frame1Ids = new int[1];
			frame1Ids[0] = -1;
			frameLenghts = new int[1];
			frameLenghts[0] = -1;
		}
		if (anInt305 == -1)
			if (flowControl != null)
				anInt305 = 2;
			else
				anInt305 = 0;
		if (priority == -1) {
			if (flowControl != null) {
				priority = 2;
				return;
			}
			priority = 0;
		}
	}



}

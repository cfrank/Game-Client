package com.jagex.runescape;// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import com.jagex.runescape.collection.CacheableNode;
import com.jagex.runescape.util.LinkedList;

import java.math.BigInteger;

public class Buffer extends CacheableNode {

	public static Buffer allocate(int type) {
		synchronized (mediumBuffers) {
			Buffer buf = null;
			if (type == 0 && smallBufferCount > 0) {
				smallBufferCount--;
				buf = (Buffer) smallBuffers.removeFirst();
			} else if (type == 1 && mediumBufferCount > 0) {
				mediumBufferCount--;
				buf = (Buffer) mediumBuffers.removeFirst();
			} else if (type == 2 && largeBufferCount > 0) {
				largeBufferCount--;
				buf = (Buffer) largeBuffers.removeFirst();
			}
			if (buf != null) {
				buf.currentPosition = 0;
				return buf;
			}
		}
		Buffer vector = new Buffer();
		vector.currentPosition = 0;
		if (type == 0)
			vector.buffer = new byte[100];
		else if (type == 1)
			vector.buffer = new byte[5000];
		else
			vector.buffer = new byte[30000];
		return vector;
	}

	public Buffer() {
		// aBoolean1435 = false;
		// anInt1436 = 8;
		// aBoolean1437 = false;
		// aBoolean1438 = true;
		// aByte1439 = 5;
		// anInt1440 = -29290;
		// aBoolean1441 = false;
		// anInt1442 = 217;
		// anInt1443 = 236;
		// aBoolean1444 = false;
		// aByte1447 = 17;
		// aByte1448 = 89;
		// aByte1449 = -16;
		// aBoolean1450 = false;
	}

	public Buffer(byte abyte0[]) {
		// aBoolean1435 = false;
		// anInt1436 = 8;
		// aBoolean1437 = false;
		// aBoolean1438 = true;
		// aByte1439 = 5;
		// anInt1440 = -29290;
		// aBoolean1441 = false;
		// anInt1442 = 217;
		// anInt1443 = 236;
		// aBoolean1444 = false;
		// aByte1447 = 17;
		// aByte1448 = 89;
		// aByte1449 = -16;
		// aBoolean1450 = false;
		// anInt1452 = 1;
		buffer = abyte0;
		currentPosition = 0;
	}

	public void putOpcode(int opcode) {
		buffer[currentPosition++] = (byte) (opcode + random.nextInt());
	}

	public void putByte(int value) {
		buffer[currentPosition++] = (byte) value;
	}

	public void putShort(int value) {
		buffer[currentPosition++] = (byte) (value >> 8);
		buffer[currentPosition++] = (byte) value;
	}

	public void putLEShort(int value) {
		buffer[currentPosition++] = (byte) value;
		buffer[currentPosition++] = (byte) (value >> 8);
	}

	public void putTriByte(int value) {
		buffer[currentPosition++] = (byte) (value >> 16);
		buffer[currentPosition++] = (byte) (value >> 8);
		buffer[currentPosition++] = (byte) value;
	}

	public void putInt(int value) {
		buffer[currentPosition++] = (byte) (value >> 24);
		buffer[currentPosition++] = (byte) (value >> 16);
		buffer[currentPosition++] = (byte) (value >> 8);
		buffer[currentPosition++] = (byte) value;
	}

	public void putLEInt(int value) {
		buffer[currentPosition++] = (byte) value;
		buffer[currentPosition++] = (byte) (value >> 8);
		buffer[currentPosition++] = (byte) (value >> 16);
		buffer[currentPosition++] = (byte) (value >> 24);
	}

	public void putLong(long value) {
		buffer[currentPosition++] = (byte) (int) (value >> 56);
		buffer[currentPosition++] = (byte) (int) (value >> 48);
		buffer[currentPosition++] = (byte) (int) (value >> 40);
		buffer[currentPosition++] = (byte) (int) (value >> 32);
		buffer[currentPosition++] = (byte) (int) (value >> 24);
		buffer[currentPosition++] = (byte) (int) (value >> 16);
		buffer[currentPosition++] = (byte) (int) (value >> 8);
		buffer[currentPosition++] = (byte) (int) value;
	}

	public void putString(String str) {
		byte[] bytes = new byte[str.length()];
		for (int i = 0; i < bytes.length; i++) {
			bytes[i] = (byte) str.charAt(i);
		}
		System.arraycopy(bytes, 0, buffer, currentPosition, bytes.length);
		currentPosition += str.length();
		buffer[currentPosition++] = 10;
	}

	public void putBytes(byte bytes[], int start, int length) {
		for (int pos = start; pos < start + length; pos++)
			buffer[currentPosition++] = bytes[pos];
	}

	public void putLength(int length) {
		buffer[currentPosition - length - 1] = (byte) length;
	}

	public int getUnsignedByte() {
		return buffer[currentPosition++] & 0xff;
	}

	public byte getSignedByte() {
		return buffer[currentPosition++];
	}

	public int getUnsignedLEShort() {
		currentPosition += 2;
		return ((buffer[currentPosition - 2] & 0xff) << 8) + (buffer[currentPosition - 1] & 0xff);
	}

	public int getSignedShort() {
		currentPosition += 2;
		int i = ((buffer[currentPosition - 2] & 0xff) << 8) + (buffer[currentPosition - 1] & 0xff);
		if (i > 32767)
			i -= 0x10000;
		return i;
	}

	public int get24BitInt() {
		currentPosition += 3;
		return ((buffer[currentPosition - 3] & 0xff) << 16) + ((buffer[currentPosition - 2] & 0xff) << 8)
				+ (buffer[currentPosition - 1] & 0xff);
	}

	public int getInt() {
		currentPosition += 4;
		return ((buffer[currentPosition - 4] & 0xff) << 24) + ((buffer[currentPosition - 3] & 0xff) << 16)
				+ ((buffer[currentPosition - 2] & 0xff) << 8) + (buffer[currentPosition - 1] & 0xff);
	}

	public long getLong() {
		long l = getInt() & 0xffffffffL;
		long l1 = getInt() & 0xffffffffL;
		return (l << 32) + l1;
	}

	public String getString() {
		int start = currentPosition;
		while (buffer[currentPosition++] != 10);
		return new String(buffer, start, currentPosition - start - 1);
	}

	public byte[] getStringBytes() {
		int start = currentPosition;
		while (buffer[currentPosition++] != 10);
		byte bytes[] = new byte[currentPosition - start - 1];
		for (int pos = start; pos < currentPosition - 1; pos++)
			bytes[pos - start] = buffer[pos];
		return bytes;
	}

	public void getBytes(byte bytes[], int start, int len) {
		for (int pos = start; pos < start + len; pos++)
			bytes[pos] = buffer[currentPosition++];
	}

	public void initBitAccess() {
		bitPosition = currentPosition * 8;
	}

	public int getBits(int numBits) {
		int k = bitPosition >> 3;
		int l = 8 - (bitPosition & 7);
		int value = 0;
		bitPosition += numBits;
		for (; numBits > l; l = 8) {
			value += (buffer[k++] & BIT_MASKS[l]) << numBits - l;
			numBits -= l;
		}

		if (numBits == l)
			value += buffer[k] & BIT_MASKS[l];
		else
			value += buffer[k] >> l - numBits & BIT_MASKS[numBits];
		return value;
	}

	public void finishBitAccess() {
		currentPosition = (bitPosition + 7) / 8;
	}

	public int getSignedSmart() {
		int peek = buffer[currentPosition] & 0xff;
		if (peek < 128)
			return getUnsignedByte() - 64;
		else
			return getUnsignedLEShort() - 49152;
	}

	public int getSmart() {
		int peek = buffer[currentPosition] & 0xff;
		if (peek < 128)
			return getUnsignedByte();
		else
			return getUnsignedLEShort() - 32768;
	}

	public void rsa(BigInteger modulus, BigInteger key) {
		int len = currentPosition;
		currentPosition = 0;
		byte rawBytes[] = new byte[len];
		getBytes(rawBytes, 0, len);
		BigInteger rawInteger = new BigInteger(rawBytes);
		BigInteger encryptedInteger = rawInteger.modPow(key, modulus);
		byte encryptedBytes[] = encryptedInteger.toByteArray();
		currentPosition = 0;
		putByte(encryptedBytes.length);
		putBytes(encryptedBytes, 0, encryptedBytes.length);
	}

	public void putByteAdded(int value) {
		buffer[currentPosition++] = (byte) (value + 128);
	}

	public void putByteNegated(int value) {
		buffer[currentPosition++] = (byte) (-value);
	}

	public void putByteSubtracted(int value) {
		buffer[currentPosition++] = (byte) (128 - value);
	}

	public int getByteAdded() {
		return buffer[currentPosition++] - 128 & 0xff;
	}

	public int getByteNegated() {
		return -buffer[currentPosition++] & 0xff;
	}

	public int getByteSubtracted() {
		return 128 - buffer[currentPosition++] & 0xff;
	}

	public byte getSignedByteAdded() {
		return (byte) (buffer[currentPosition++] - 128);
	}

	public byte getSignedByteNegated() {
		return (byte) (-buffer[currentPosition++]);
	}

	public byte getSignedByteSubtracted() {
		return (byte) (128 - buffer[currentPosition++]);
	}

	// TODO should we remove the duplication?
	public void putLEShortDup(int value) {
		buffer[currentPosition++] = (byte) value;
		buffer[currentPosition++] = (byte) (value >> 8);
	}

	public void putShortAdded(int value) {
		buffer[currentPosition++] = (byte) (value >> 8);
		buffer[currentPosition++] = (byte) (value + 128);
	}

	public void putLEShortAdded(int value) {
		buffer[currentPosition++] = (byte) (value + 128);
		buffer[currentPosition++] = (byte) (value >> 8);
	}

	public int method549() {
		currentPosition += 2;
		return ((buffer[currentPosition - 1] & 0xff) << 8) + (buffer[currentPosition - 2] & 0xff);
	}

	public int method550() {
		currentPosition += 2;
		return ((buffer[currentPosition - 2] & 0xff) << 8) + (buffer[currentPosition - 1] - 128 & 0xff);
	}

	public int getLittleShortA() {
		currentPosition += 2;
		return ((buffer[currentPosition - 1] & 0xff) << 8) + (buffer[currentPosition - 2] - 128 & 0xff);
	}

	public int method552() {
		currentPosition += 2;
		int j = ((buffer[currentPosition - 1] & 0xff) << 8) + (buffer[currentPosition - 2] & 0xff);
		if (j > 0x7fff)
			j -= 0x10000;
		return j;
	}

	public int method553() {
		currentPosition += 2;
		int i = ((buffer[currentPosition - 2] & 0xff) << 8) + (buffer[currentPosition - 1] - 128 & 0xff);
		if (i > 32767)
			i -= 0x10000;
		return i;
	}

	public int method554() {
		currentPosition += 3;
		return ((buffer[currentPosition - 2] & 0xff) << 16) + ((buffer[currentPosition - 3] & 0xff) << 8)
				+ (buffer[currentPosition - 1] & 0xff);
	}

	public int method555() {
		currentPosition += 4;
		return ((buffer[currentPosition - 1] & 0xff) << 24) + ((buffer[currentPosition - 2] & 0xff) << 16)
				+ ((buffer[currentPosition - 3] & 0xff) << 8) + (buffer[currentPosition - 4] & 0xff);
	}

	public int method556() {
		currentPosition += 4;
		return ((buffer[currentPosition - 2] & 0xff) << 24) + ((buffer[currentPosition - 1] & 0xff) << 16)
				+ ((buffer[currentPosition - 4] & 0xff) << 8) + (buffer[currentPosition - 3] & 0xff);
	}

	public int method557() {
		currentPosition += 4;
		return ((buffer[currentPosition - 3] & 0xff) << 24) + ((buffer[currentPosition - 4] & 0xff) << 16)
				+ ((buffer[currentPosition - 1] & 0xff) << 8) + (buffer[currentPosition - 2] & 0xff);
	}

	public void getBytesReverse(byte bytes[], int start, int len) {
		for (int pos = (start + len) - 1; pos >= start; pos--)
			bytes[pos] = buffer[currentPosition++];
	}

	public void getBytesAdded(byte bytes[], int start, int len) {
		for (int pos = start; pos < start + len; pos++)
			bytes[pos] = (byte) (buffer[currentPosition++] - 128);
	}

	// public boolean aBoolean1435;
	// public int anInt1436;
	// public boolean aBoolean1437;
	// public boolean aBoolean1438;
	// public byte aByte1439;
	// public int anInt1440;
	// public boolean aBoolean1441;
	// public int anInt1442;
	// public int anInt1443;
	// public boolean aBoolean1444;
	// public int anInt1445;
	// public int anInt1446;
	// public byte aByte1447;
	// public byte aByte1448;
	// public byte aByte1449;
	// public boolean aBoolean1450;
	// public static boolean aBoolean1451 = true;
	// public int anInt1452;
	public byte buffer[];
	public int currentPosition;
	public int bitPosition;
	public static int CRC32_TABLE[];
	public static final int BIT_MASKS[] = { 0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383,
			32767, 65535, 0x1ffff, 0x3ffff, 0x7ffff, 0xfffff, 0x1fffff, 0x3fffff, 0x7fffff, 0xffffff, 0x1ffffff,
			0x3ffffff, 0x7ffffff, 0xfffffff, 0x1fffffff, 0x3fffffff, 0x7fffffff, -1 };
	public IsaacRandom random;
	public static int smallBufferCount;
	public static int mediumBufferCount;
	public static int largeBufferCount;
	public static LinkedList smallBuffers = new LinkedList();
	public static LinkedList mediumBuffers = new LinkedList();
	public static LinkedList largeBuffers = new LinkedList();
	// public static char aCharArray1465[] = {
	// 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
	// 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
	// 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd',
	// 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
	// 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
	// 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7',
	// '8', '9', '+', '/'
	// };
	// public static boolean aBoolean1466;

	static {
		CRC32_TABLE = new int[256];
		for (int pos = 0; pos < 256; pos++) {
			int value = pos;
			for (int pass = 0; pass < 8; pass++)
				if ((value & 1) == 1)
					value = value >>> 1 ^ 0xedb88320;
				else
					value >>>= 1;
			CRC32_TABLE[pos] = value;
		}

	}
}

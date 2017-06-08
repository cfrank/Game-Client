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
				buf.offset = 0;
				return buf;
			}
		}
		Buffer vector = new Buffer();
		vector.offset = 0;
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
		offset = 0;
	}

	public void putOpcode(int opcode) {
		buffer[offset++] = (byte) (opcode + random.nextInt());
	}

	public void putByte(int value) {
		buffer[offset++] = (byte) value;
	}

	public void putShort(int value) {
		buffer[offset++] = (byte) (value >> 8);
		buffer[offset++] = (byte) value;
	}

	public void putLEShort(int value) {
		buffer[offset++] = (byte) value;
		buffer[offset++] = (byte) (value >> 8);
	}

	public void putTriByte(int value) {
		buffer[offset++] = (byte) (value >> 16);
		buffer[offset++] = (byte) (value >> 8);
		buffer[offset++] = (byte) value;
	}

	public void putInt(int value) {
		buffer[offset++] = (byte) (value >> 24);
		buffer[offset++] = (byte) (value >> 16);
		buffer[offset++] = (byte) (value >> 8);
		buffer[offset++] = (byte) value;
	}

	public void putLEInt(int value) {
		buffer[offset++] = (byte) value;
		buffer[offset++] = (byte) (value >> 8);
		buffer[offset++] = (byte) (value >> 16);
		buffer[offset++] = (byte) (value >> 24);
	}

	public void putLong(long value) {
		buffer[offset++] = (byte) (int) (value >> 56);
		buffer[offset++] = (byte) (int) (value >> 48);
		buffer[offset++] = (byte) (int) (value >> 40);
		buffer[offset++] = (byte) (int) (value >> 32);
		buffer[offset++] = (byte) (int) (value >> 24);
		buffer[offset++] = (byte) (int) (value >> 16);
		buffer[offset++] = (byte) (int) (value >> 8);
		buffer[offset++] = (byte) (int) value;
	}

	public void putString(String str) {
		byte[] bytes = new byte[str.length()];
		for (int i = 0; i < bytes.length; i++) {
			bytes[i] = (byte) str.charAt(i);
		}
		System.arraycopy(bytes, 0, buffer, offset, bytes.length);
		offset += str.length();
		buffer[offset++] = 10;
	}

	public void putBytes(byte bytes[], int start, int length) {
		for (int pos = start; pos < start + length; pos++)
			buffer[offset++] = bytes[pos];
	}

	public void putLength(int length) {
		buffer[offset - length - 1] = (byte) length;
	}

	public int getUnsignedByte() {
		return buffer[offset++] & 0xff;
	}

	public byte getSignedByte() {
		return buffer[offset++];
	}

	public int getUnsignedLEShort() {
		offset += 2;
		return ((buffer[offset - 2] & 0xff) << 8) + (buffer[offset - 1] & 0xff);
	}

	public int getSignedShort() {
		offset += 2;
		int i = ((buffer[offset - 2] & 0xff) << 8) + (buffer[offset - 1] & 0xff);
		if (i > 32767)
			i -= 0x10000;
		return i;
	}

	public int get24BitInt() {
		offset += 3;
		return ((buffer[offset - 3] & 0xff) << 16) + ((buffer[offset - 2] & 0xff) << 8)
				+ (buffer[offset - 1] & 0xff);
	}

	public int getInt() {
		offset += 4;
		return ((buffer[offset - 4] & 0xff) << 24) + ((buffer[offset - 3] & 0xff) << 16)
				+ ((buffer[offset - 2] & 0xff) << 8) + (buffer[offset - 1] & 0xff);
	}

	public long getLong() {
		long l = getInt() & 0xffffffffL;
		long l1 = getInt() & 0xffffffffL;
		return (l << 32) + l1;
	}

	public String getString() {
		int start = offset;
		while (buffer[offset++] != 10);
		return new String(buffer, start, offset - start - 1);
	}

	public byte[] getStringBytes() {
		int start = offset;
		while (buffer[offset++] != 10);
		byte bytes[] = new byte[offset - start - 1];
		for (int pos = start; pos < offset - 1; pos++)
			bytes[pos - start] = buffer[pos];
		return bytes;
	}

	public void getBytes(byte bytes[], int start, int len) {
		for (int pos = start; pos < start + len; pos++)
			bytes[pos] = buffer[offset++];
	}

	public void initBitAccess() {
		bitPosition = offset * 8;
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
		offset = (bitPosition + 7) / 8;
	}

	public int getSignedSmart() {
		int peek = buffer[offset] & 0xff;
		if (peek < 128)
			return getUnsignedByte() - 64;
		else
			return getUnsignedLEShort() - 49152;
	}

	public int getSmart() {
		int peek = buffer[offset] & 0xff;
		if (peek < 128)
			return getUnsignedByte();
		else
			return getUnsignedLEShort() - 32768;
	}

	public void rsa(BigInteger modulus, BigInteger key) {
		int len = offset;
		offset = 0;
		byte rawBytes[] = new byte[len];
		getBytes(rawBytes, 0, len);
		BigInteger rawInteger = new BigInteger(rawBytes);
		BigInteger encryptedInteger = rawInteger.modPow(key, modulus);
		byte encryptedBytes[] = encryptedInteger.toByteArray();
		offset = 0;
		putByte(encryptedBytes.length);
		putBytes(encryptedBytes, 0, encryptedBytes.length);
	}

	public void putByteAdded(int value) {
		buffer[offset++] = (byte) (value + 128);
	}

	public void putByteNegated(int value) {
		buffer[offset++] = (byte) (-value);
	}

	public void putByteSubtracted(int value) {
		buffer[offset++] = (byte) (128 - value);
	}

	public int getByteAdded() {
		return buffer[offset++] - 128 & 0xff;
	}

	public int getByteNegated() {
		return -buffer[offset++] & 0xff;
	}

	public int getByteSubtracted() {
		return 128 - buffer[offset++] & 0xff;
	}

	public byte getSignedByteAdded() {
		return (byte) (buffer[offset++] - 128);
	}

	public byte getSignedByteNegated() {
		return (byte) (-buffer[offset++]);
	}

	public byte getSignedByteSubtracted() {
		return (byte) (128 - buffer[offset++]);
	}

	// TODO should we remove the duplication?
	public void putLEShortDup(int value) {
		buffer[offset++] = (byte) value;
		buffer[offset++] = (byte) (value >> 8);
	}

	public void putShortAdded(int value) {
		buffer[offset++] = (byte) (value >> 8);
		buffer[offset++] = (byte) (value + 128);
	}

	public void putLEShortAdded(int value) {
		buffer[offset++] = (byte) (value + 128);
		buffer[offset++] = (byte) (value >> 8);
	}

	public int method549() {
		offset += 2;
		return ((buffer[offset - 1] & 0xff) << 8) + (buffer[offset - 2] & 0xff);
	}

	public int method550() {
		offset += 2;
		return ((buffer[offset - 2] & 0xff) << 8) + (buffer[offset - 1] - 128 & 0xff);
	}

	public int getLittleShortA() {
		offset += 2;
		return ((buffer[offset - 1] & 0xff) << 8) + (buffer[offset - 2] - 128 & 0xff);
	}

	public int method552() {
		offset += 2;
		int j = ((buffer[offset - 1] & 0xff) << 8) + (buffer[offset - 2] & 0xff);
		if (j > 0x7fff)
			j -= 0x10000;
		return j;
	}

	public int method553() {
		offset += 2;
		int i = ((buffer[offset - 2] & 0xff) << 8) + (buffer[offset - 1] - 128 & 0xff);
		if (i > 32767)
			i -= 0x10000;
		return i;
	}

	public int method554() {
		offset += 3;
		return ((buffer[offset - 2] & 0xff) << 16) + ((buffer[offset - 3] & 0xff) << 8)
				+ (buffer[offset - 1] & 0xff);
	}

	public int method555() {
		offset += 4;
		return ((buffer[offset - 1] & 0xff) << 24) + ((buffer[offset - 2] & 0xff) << 16)
				+ ((buffer[offset - 3] & 0xff) << 8) + (buffer[offset - 4] & 0xff);
	}

	public int method556() {
		offset += 4;
		return ((buffer[offset - 2] & 0xff) << 24) + ((buffer[offset - 1] & 0xff) << 16)
				+ ((buffer[offset - 4] & 0xff) << 8) + (buffer[offset - 3] & 0xff);
	}

	public int method557() {
		offset += 4;
		return ((buffer[offset - 3] & 0xff) << 24) + ((buffer[offset - 4] & 0xff) << 16)
				+ ((buffer[offset - 1] & 0xff) << 8) + (buffer[offset - 2] & 0xff);
	}

	public void getBytesReverse(byte bytes[], int start, int len) {
		for (int pos = (start + len) - 1; pos >= start; pos--)
			bytes[pos] = buffer[offset++];
	}

	public void getBytesAdded(byte bytes[], int start, int len) {
		for (int pos = start; pos < start + len; pos++)
			bytes[pos] = (byte) (buffer[offset++] - 128);
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
	public int offset;
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

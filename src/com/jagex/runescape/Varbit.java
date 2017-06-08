package com.jagex.runescape;// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

public class Varbit {

	public static void load(Archive archive) {
		Buffer buf = new Buffer(archive.get("varbit.dat"));
		count = buf.getShort();

		if (cache == null)
			cache = new Varbit[count];

		for (int id = 0; id < count; id++) {
			if (cache[id] == null)
				cache[id] = new Varbit();
			cache[id].init(id, buf);
			if (cache[id].aBoolean829)
				Varp.aClass43Array704[cache[id].varpId].aBoolean716 = true;
		}

		if (buf.offset != buf.buffer.length)
			System.out.println("varbit load mismatch");
	}

	public void init(int j, Buffer buf) {
		do {
			int attribute = buf.getUnsignedByte();
			if (attribute == 0)
				return;
			if (attribute == 1) {
				varpId = buf.getShort();
				leastSignificantBit = buf.getUnsignedByte();
				mostSignificantBit = buf.getUnsignedByte();
			} else if (attribute == 10)
				aString825 = buf.getString();
			else if (attribute == 2)
				aBoolean829 = true;
			else if (attribute == 3)
				anInt830 = buf.getInt();
			else if (attribute == 4)
				anInt831 = buf.getInt();
			else if (attribute == 5)
				aBoolean832 = false;
			else
				System.out.println("Error unrecognised config code: " + attribute);
		} while (true);
	}

	public Varbit() {
		aBoolean829 = false;
		anInt830 = -1;
		aBoolean832 = true;
	}

	public int anInt822;
	public static int count;
	public static Varbit cache[];
	public String aString825;
	public int varpId;
	public int leastSignificantBit;
	public int mostSignificantBit;
	public boolean aBoolean829;
	public int anInt830;
	public int anInt831;
	public boolean aBoolean832;
}

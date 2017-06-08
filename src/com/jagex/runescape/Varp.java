package com.jagex.runescape;// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

public class Varp {

	public static void load(Archive archive) {
		Buffer buf = new Buffer(archive.get("varp.dat"));
		anInt705 = 0;
		count = buf.getShort();

		if (aClass43Array704 == null)
			aClass43Array704 = new Varp[count];

		if (anIntArray706 == null)
			anIntArray706 = new int[count];

		for (int j = 0; j < count; j++) {
			if (aClass43Array704[j] == null)
				aClass43Array704[j] = new Varp();
			aClass43Array704[j].init(j, buf);
		}

		if (buf.offset != buf.buffer.length)
			System.out.println("varptype load mismatch");
	}

	public void init(int j, Buffer buf) {
		do {
			int attribute = buf.getUnsignedByte();
			if (attribute == 0)
				return;
			if (attribute == 1)
				anInt708 = buf.getUnsignedByte();
			else if (attribute == 2)
				anInt709 = buf.getUnsignedByte();
			else if (attribute == 3) {
				aBoolean710 = true;
				anIntArray706[anInt705++] = j;
			} else if (attribute == 4)
				aBoolean711 = false;
			else if (attribute == 5)
				anInt712 = buf.getShort();
			else if (attribute == 6)
				aBoolean713 = true;
			else if (attribute == 7)
				anInt714 = buf.getInt();
			else if (attribute == 8) {
				anInt715 = 1;
				aBoolean716 = true;
			} else if (attribute == 10)
				aString707 = buf.getString();
			else if (attribute == 11)
				aBoolean716 = true;
			else if (attribute == 12)
				anInt717 = buf.getInt();
			else if (attribute == 13) {
				anInt715 = 2;
				aBoolean716 = true;
			} else if (attribute == 14)
				aBoolean718 = false;
			else
				System.out.println("Error unrecognised config code: " + attribute);
		} while (true);
	}

	public Varp() {
		aBoolean710 = false;
		aBoolean711 = true;
		aBoolean713 = false;
		aBoolean716 = false;
		anInt717 = -1;
		aBoolean718 = true;
	}

	public static int count;
	public static Varp aClass43Array704[];
	public static int anInt705;
	public static int anIntArray706[];
	public String aString707;
	public int anInt708;
	public int anInt709;
	public boolean aBoolean710;
	public boolean aBoolean711;
	public int anInt712;
	public boolean aBoolean713;
	public int anInt714;
	public int anInt715;
	public boolean aBoolean716;
	public int anInt717;
	public boolean aBoolean718;
}

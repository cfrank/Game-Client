package com.jagex.runescape;// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import com.jagex.runescape.collection.Cache;
import com.jagex.runescape.media.Animation;
import com.jagex.runescape.media.renderable.Model;

public class ActorDefinition {

	public void init(byte byte0, Buffer class50_sub1_sub2) {
		if (byte0 == 6)
			byte0 = 0;
		else
			throw new NullPointerException();
		do {
			int i = class50_sub1_sub2.getUnsignedByte();
			if (i == 0)
				return;
			if (i == 1) {
				int j = class50_sub1_sub2.getUnsignedByte();
				anIntArray626 = new int[j];
				for (int j1 = 0; j1 < j; j1++)
					anIntArray626[j1] = class50_sub1_sub2.getShort();

			} else if (i == 2)
				aString652 = class50_sub1_sub2.getString();
			else if (i == 3)
				aByteArray660 = class50_sub1_sub2.getStringBytes();
			else if (i == 12)
				boundaryDimension = class50_sub1_sub2.getSignedByte();
			else if (i == 13)
				anInt621 = class50_sub1_sub2.getShort();
			else if (i == 14)
				anInt645 = class50_sub1_sub2.getShort();
			else if (i == 17) {
				anInt645 = class50_sub1_sub2.getShort();
				anInt643 = class50_sub1_sub2.getShort();
				anInt641 = class50_sub1_sub2.getShort();
				anInt633 = class50_sub1_sub2.getShort();
			} else if (i >= 30 && i < 40) {
				if (aStringArray646 == null)
					aStringArray646 = new String[5];
				aStringArray646[i - 30] = class50_sub1_sub2.getString();
				if (aStringArray646[i - 30].equalsIgnoreCase("hidden"))
					aStringArray646[i - 30] = null;
			} else if (i == 40) {
				int k = class50_sub1_sub2.getUnsignedByte();
				anIntArray634 = new int[k];
				anIntArray656 = new int[k];
				for (int k1 = 0; k1 < k; k1++) {
					anIntArray634[k1] = class50_sub1_sub2.getShort();
					anIntArray656[k1] = class50_sub1_sub2.getShort();
				}

			} else if (i == 60) {
				int l = class50_sub1_sub2.getUnsignedByte();
				anIntArray625 = new int[l];
				for (int l1 = 0; l1 < l; l1++)
					anIntArray625[l1] = class50_sub1_sub2.getShort();

			} else if (i == 90)
				anInt648 = class50_sub1_sub2.getShort();
			else if (i == 91)
				anInt627 = class50_sub1_sub2.getShort();
			else if (i == 92)
				anInt637 = class50_sub1_sub2.getShort();
			else if (i == 93)
				aBoolean636 = false;
			else if (i == 95)
				anInt639 = class50_sub1_sub2.getShort();
			else if (i == 97)
				anInt632 = class50_sub1_sub2.getShort();
			else if (i == 98)
				anInt630 = class50_sub1_sub2.getShort();
			else if (i == 99)
				aBoolean644 = true;
			else if (i == 100)
				anInt663 = class50_sub1_sub2.getSignedByte();
			else if (i == 101)
				anInt658 = class50_sub1_sub2.getSignedByte() * 5;
			else if (i == 102)
				anInt638 = class50_sub1_sub2.getShort();
			else if (i == 103)
				anInt651 = class50_sub1_sub2.getShort();
			else if (i == 106) {
				anInt654 = class50_sub1_sub2.getShort();
				if (anInt654 == 65535)
					anInt654 = -1;
				anInt659 = class50_sub1_sub2.getShort();
				if (anInt659 == 65535)
					anInt659 = -1;
				int i1 = class50_sub1_sub2.getUnsignedByte();
				anIntArray622 = new int[i1 + 1];
				for (int i2 = 0; i2 <= i1; i2++) {
					anIntArray622[i2] = class50_sub1_sub2.getShort();
					if (anIntArray622[i2] == 65535)
						anIntArray622[i2] = -1;
				}

			} else if (i == 107)
				aBoolean631 = false;
		} while (true);
	}

	public static void method358(boolean flag) {
		modelCache = null;
		anIntArray650 = null;
		aClass37Array655 = null;
		aClass50_Sub1_Sub2_657 = null;
		if (flag) {
			for (int i = 1; i > 0; i++);
		}
	}

	public Model getHeadModel() {
		if (anIntArray622 != null) {
			ActorDefinition class37 = method363(false);
			if (class37 == null)
				return null;
			else
				return class37.getHeadModel();
		}
		if (anIntArray625 == null)
			return null;
		boolean flag = false;
		for (int k = 0; k < anIntArray625.length; k++)
			if (!Model.isCached(anIntArray625[k]))
				flag = true;

		if (flag)
			return null;
		Model aclass50_sub1_sub4_sub4[] = new Model[anIntArray625.length];
		for (int l = 0; l < anIntArray625.length; l++)
			aclass50_sub1_sub4_sub4[l] = Model.getModel(anIntArray625[l]);

		Model class50_sub1_sub4_sub4;
		if (aclass50_sub1_sub4_sub4.length == 1)
			class50_sub1_sub4_sub4 = aclass50_sub1_sub4_sub4[0];
		else
			class50_sub1_sub4_sub4 = new Model(aclass50_sub1_sub4_sub4.length,
					aclass50_sub1_sub4_sub4);
		if (anIntArray634 != null) {
			for (int i1 = 0; i1 < anIntArray634.length; i1++)
				class50_sub1_sub4_sub4.replaceColor(anIntArray634[i1], anIntArray656[i1]);

		}
		return class50_sub1_sub4_sub4;
	}

	public boolean method360(int i) {
		while (i >= 0)
			aBoolean662 = !aBoolean662;
		if (anIntArray622 == null)
			return true;
		int j = -1;
		if (anInt654 != -1) {
			Varbit class49 = Varbit.cache[anInt654];
			int k = class49.varpId;
			int l = class49.leastSignificantBit;
			int i1 = class49.mostSignificantBit;
			int j1 = client.BITFIELD_MAX_VALUE[i1 - l];
			j = client.widgetSettings[k] >> l & j1;
		} else if (anInt659 != -1)
			j = client.widgetSettings[anInt659];
		return j >= 0 && j < anIntArray622.length && anIntArray622[j] != -1;
	}

	public static void load(Archive class2) {
		aClass50_Sub1_Sub2_657 = new Buffer(class2.get("npc.dat"));
		Buffer class50_sub1_sub2 = new Buffer(class2.get("npc.idx"));
		anInt649 = class50_sub1_sub2.getShort();
		anIntArray650 = new int[anInt649];
		int i = 2;
		for (int j = 0; j < anInt649; j++) {
			anIntArray650[j] = i;
			i += class50_sub1_sub2.getShort();
		}

		aClass37Array655 = new ActorDefinition[20];
		for (int k = 0; k < 20; k++)
			aClass37Array655[k] = new ActorDefinition();

	}

	public Model getChildModel(int i, int j, int k, int ai[]) {
		if (anIntArray622 != null) {
			ActorDefinition class37 = method363(false);
			if (class37 == null)
				return null;
			else
				return class37.getChildModel(i, j, 0, ai);
		}
		Model class50_sub1_sub4_sub4 = (Model) modelCache.get(id);
		if (class50_sub1_sub4_sub4 == null) {
			boolean flag = false;
			for (int l = 0; l < anIntArray626.length; l++)
				if (!Model.isCached(anIntArray626[l]))
					flag = true;

			if (flag)
				return null;
			Model aclass50_sub1_sub4_sub4[] = new Model[anIntArray626.length];
			for (int i1 = 0; i1 < anIntArray626.length; i1++)
				aclass50_sub1_sub4_sub4[i1] = Model.getModel(anIntArray626[i1]);

			if (aclass50_sub1_sub4_sub4.length == 1)
				class50_sub1_sub4_sub4 = aclass50_sub1_sub4_sub4[0];
			else
				class50_sub1_sub4_sub4 = new Model(aclass50_sub1_sub4_sub4.length,
						aclass50_sub1_sub4_sub4);
			if (anIntArray634 != null) {
				for (int j1 = 0; j1 < anIntArray634.length; j1++)
					class50_sub1_sub4_sub4.replaceColor(anIntArray634[j1], anIntArray656[j1]);

			}
			class50_sub1_sub4_sub4.createBones();
			class50_sub1_sub4_sub4.applyLighting(64 + anInt663, 850 + anInt658, -30, -50, -30, true);
			modelCache.put(class50_sub1_sub4_sub4, id);
		}
		Model class50_sub1_sub4_sub4_1 = Model.aClass50_Sub1_Sub4_Sub4_1643;
		if (k != 0)
			aBoolean647 = !aBoolean647;
		class50_sub1_sub4_sub4_1.replaceWithModel(class50_sub1_sub4_sub4, Animation.exists(i) & Animation.exists(j)
		);
		if (i != -1 && j != -1)
			class50_sub1_sub4_sub4_1.mixAnimationFrames(j, 0, i, ai);
		else if (i != -1)
			class50_sub1_sub4_sub4_1.applyTransform(i);
		if (anInt632 != 128 || anInt630 != 128)
			class50_sub1_sub4_sub4_1.scaleT(anInt630, anInt632, 9, anInt632);
		class50_sub1_sub4_sub4_1.calculateDiagonals();
		class50_sub1_sub4_sub4_1.triangleSkin = null;
		class50_sub1_sub4_sub4_1.vectorSkin = null;
		if (boundaryDimension == 1)
			class50_sub1_sub4_sub4_1.oneSquareModel = true;
		return class50_sub1_sub4_sub4_1;
	}

	public ActorDefinition method363(boolean flag) {
		if (flag)
			anInt640 = -212;
		int i = -1;
		if (anInt654 != -1) {
			Varbit class49 = Varbit.cache[anInt654];
			int j = class49.varpId;
			int k = class49.leastSignificantBit;
			int l = class49.mostSignificantBit;
			int i1 = client.BITFIELD_MAX_VALUE[l - k];
			i = client.widgetSettings[j] >> k & i1;
		} else if (anInt659 != -1)
			i = client.widgetSettings[anInt659];
		if (i < 0 || i >= anIntArray622.length || anIntArray622[i] == -1)
			return null;
		else
			return forId(anIntArray622[i]);
	}

	public static ActorDefinition forId(int id) {
		for (int j = 0; j < 20; j++)
			if (aClass37Array655[j].id == id)
				return aClass37Array655[j];

		anInt661 = (anInt661 + 1) % 20;
		ActorDefinition def = aClass37Array655[anInt661] = new ActorDefinition();
		aClass50_Sub1_Sub2_657.offset = anIntArray650[id];
		def.id = id;
		def.init(aByte653, aClass50_Sub1_Sub2_657);
		return def;
	}

	public ActorDefinition() {
		anInt621 = -1;
		aBoolean623 = true;
		anInt624 = 932;
		anInt627 = -1;
		id = -1L;
		anInt630 = 128;
		aBoolean631 = true;
		anInt632 = 128;
		anInt633 = -1;
		aBoolean636 = true;
		anInt637 = -1;
		anInt638 = -1;
		anInt639 = -1;
		anInt640 = 7;
		anInt641 = -1;
		boundaryDimension = 1;
		anInt643 = -1;
		aBoolean644 = false;
		anInt645 = -1;
		aBoolean647 = false;
		anInt648 = -1;
		anInt651 = 32;
		aString652 = "null";
		anInt654 = -1;
		anInt659 = -1;
		aBoolean662 = false;
	}

	public int anInt621;
	public int anIntArray622[];
	public boolean aBoolean623;
	public int anInt624;
	public int anIntArray625[];
	public int anIntArray626[];
	public int anInt627;
	public long id;
	public static Game client;
	public int anInt630;
	public boolean aBoolean631;
	public int anInt632;
	public int anInt633;
	public int anIntArray634[];
	public static Cache modelCache = new Cache(30);
	public boolean aBoolean636;
	public int anInt637;
	public int anInt638;
	public int anInt639;
	public int anInt640;
	public int anInt641;
	public byte boundaryDimension;
	public int anInt643;
	public boolean aBoolean644;
	public int anInt645;
	public String aStringArray646[];
	public boolean aBoolean647;
	public int anInt648;
	public static int anInt649;
	public static int anIntArray650[];
	public int anInt651;
	public String aString652;
	public static byte aByte653 = 6;
	public int anInt654;
	public static ActorDefinition aClass37Array655[];
	public int anIntArray656[];
	public static Buffer aClass50_Sub1_Sub2_657;
	public int anInt658;
	public int anInt659;
	public byte aByteArray660[];
	public static int anInt661;
	public boolean aBoolean662;
	public int anInt663;

}

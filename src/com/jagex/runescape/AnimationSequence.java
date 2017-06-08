package com.jagex.runescape;// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import com.jagex.runescape.media.Animation;

public class AnimationSequence {

	public static void load(Archive archive) {
		Buffer buf = new Buffer(archive.get("seq.dat"));
		count = buf.getShort();
		if (animations == null)
			animations = new AnimationSequence[count];
		for (int id = 0; id < count; id++) {
			if (animations[id] == null)
				animations[id] = new AnimationSequence();
			animations[id].init(buf);
		}
	}

	public int getFrameLength(int j) {
		int k = anIntArray297[j];
		if (k == 0) {
			Animation animation = Animation.getAnimation(frame2Ids[j]);
			if (animation != null)
				k = anIntArray297[j] = animation.anInt431;
		}
		if (k == 0)
			k = 1;
		return k;
	}

	public void init(Buffer buf) {
		do {
			int attribute = buf.getUnsignedByte();
			if (attribute == 0)
				break;
			if (attribute == 1) {
				frameCount = buf.getUnsignedByte();
				frame2Ids = new int[frameCount];
				anIntArray296 = new int[frameCount];
				anIntArray297 = new int[frameCount];
				for (int j = 0; j < frameCount; j++) {
					frame2Ids[j] = buf.getShort();
					anIntArray296[j] = buf.getShort();
					if (anIntArray296[j] == 65535)
						anIntArray296[j] = -1;
					anIntArray297[j] = buf.getShort();
				}

			} else if (attribute == 2)
				frameStep = buf.getShort();
			else if (attribute == 3) {
				int k = buf.getUnsignedByte();
				flowControl = new int[k + 1];
				for (int l = 0; l < k; l++)
					flowControl[l] = buf.getUnsignedByte();

				flowControl[k] = 0x98967f;
			} else if (attribute == 4)
				aBoolean300 = true;
			else if (attribute == 5)
				anInt301 = buf.getUnsignedByte();
			else if (attribute == 6)
				anInt302 = buf.getShort();
			else if (attribute == 7)
				anInt303 = buf.getShort();
			else if (attribute == 8)
				anInt304 = buf.getUnsignedByte();
			else if (attribute == 9)
				anInt305 = buf.getUnsignedByte();
			else if (attribute == 10)
				priority = buf.getUnsignedByte();
			else if (attribute == 11)
				anInt307 = buf.getUnsignedByte();
			else if (attribute == 12)
				anInt308 = buf.getInt();
			else
				System.out.println("Error unrecognised seq config code: " + attribute);
		} while (true);
		if (frameCount == 0) {
			frameCount = 1;
			frame2Ids = new int[1];
			frame2Ids[0] = -1;
			anIntArray296 = new int[1];
			anIntArray296[0] = -1;
			anIntArray297 = new int[1];
			anIntArray297[0] = -1;
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

	public AnimationSequence() {
		frameStep = -1;
		aBoolean300 = false;
		anInt301 = 5;
		anInt302 = -1;
		anInt303 = -1;
		anInt304 = 99;
		anInt305 = -1;
		priority = -1;
		anInt307 = 2;
	}

	public static int count;
	public static AnimationSequence animations[];
	public int frameCount;
	public int frame2Ids[];
	public int anIntArray296[];
	public int anIntArray297[];
	public int frameStep;
	public int flowControl[];
	public boolean aBoolean300;
	public int anInt301;
	public int anInt302;
	public int anInt303;
	public int anInt304;
	public int anInt305;
	public int priority;
	public int anInt307;
	public int anInt308;
	public static int anInt309;

}

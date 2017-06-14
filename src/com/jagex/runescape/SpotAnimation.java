package com.jagex.runescape;// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import com.jagex.runescape.cache.Archive;
import com.jagex.runescape.cache.media.AnimationSequence;
import com.jagex.runescape.collection.Cache;
import com.jagex.runescape.media.renderable.Model;
import com.jagex.runescape.net.Buffer;

public class SpotAnimation {

	public static void load(Archive archive) {
		Buffer buf = new Buffer(archive.getFile("spotanim.dat"));
		count = buf.getUnsignedLEShort();
		if (cache == null)
			cache = new SpotAnimation[count];
		for (int id = 0; id < count; id++) {
			if (cache[id] == null)
				cache[id] = new SpotAnimation();
			cache[id].id = id;
			cache[id].init(buf);
		}

	}

	public void init(Buffer buf) {
		do {
			int attribute = buf.getUnsignedByte();
			if (attribute == 0)
				return;
			if (attribute == 1)
				modelId = buf.getUnsignedLEShort();
			else if (attribute == 2) {
				animId = buf.getUnsignedLEShort();
				if (AnimationSequence.cache != null)
					sequences = AnimationSequence.cache[animId];
			} else if (attribute == 4)
				resizeXY = buf.getUnsignedLEShort();
			else if (attribute == 5)
				resizeZ = buf.getUnsignedLEShort();
			else if (attribute == 6)
				rotation = buf.getUnsignedLEShort();
			else if (attribute == 7)
				modelLightFalloff = buf.getUnsignedByte();
			else if (attribute == 8)
				modelLightAmbient = buf.getUnsignedByte();
			else if (attribute >= 40 && attribute < 50)
				srcColors[attribute - 40] = buf.getUnsignedLEShort();
			else if (attribute >= 50 && attribute < 60)
				destColors[attribute - 50] = buf.getUnsignedLEShort();
			else
				System.out.println("Error unrecognised spotanim config code: " + attribute);
		} while (true);
	}

	public Model getModel() {
		Model model = (Model) models.get(id);
		if (model != null)
			return model;

		model = Model.getModel(modelId);
		if (model == null)
			return null;

		for (int i = 0; i < 6; i++)
			if (srcColors[0] != 0)
				model.replaceColor(srcColors[i], destColors[i]);

		models.put(model, id);
		return model;
	}

	public SpotAnimation() {
		animId = -1;
		srcColors = new int[6];
		destColors = new int[6];
		resizeXY = 128; // TODO: maybe width and height in units? or model scale?
		resizeZ = 128;
	}

	public static int count;
	public static SpotAnimation cache[];
	public int id;
	public int modelId;
	public int animId;
	public AnimationSequence sequences;
	public int srcColors[];
	public int destColors[];
	public int resizeXY;
	public int resizeZ;
	public int rotation;
	public int modelLightFalloff;
	public int modelLightAmbient;
	public static Cache models = new Cache(30);

}

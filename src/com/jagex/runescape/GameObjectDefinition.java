package com.jagex.runescape;// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import com.jagex.runescape.cache.cfg.Varbit;
import com.jagex.runescape.collection.Cache;
import com.jagex.runescape.media.Animation;
import com.jagex.runescape.media.renderable.Model;
import com.jagex.runescape.media.renderable.Renderable;

public class GameObjectDefinition {

	public static GameObjectDefinition getDefinition(int id) {
		for (int j = 0; j < 20; j++)
			if (cache[j].id == id)
				return cache[j];

		cachePos = (cachePos + 1) % 20;
		GameObjectDefinition def = cache[cachePos];
		buf.offset = indices[id];
		def.id = id;
		def.reset();
		def.init(buf);
		return def;
	}

	public GameObjectDefinition method424(int i) {
		if (i != 0)
			anInt788 = 445;
		int j = -1;
		if (varbitId != -1) {
			Varbit class49 = Varbit.cache[varbitId];
			int k = class49.configId;
			int l = class49.leastSignificantBit;
			int i1 = class49.mostSignificantBit;
			int j1 = client.BITFIELD_MAX_VALUE[i1 - l];
			j = client.widgetSettings[k] >> l & j1;
		} else if (configId != -1)
			j = client.widgetSettings[configId];
		if (j < 0 || j >= childrenIds.length || childrenIds[j] == -1)
			return null;
		else
			return getDefinition(childrenIds[j]);
	}

	public void method425(OnDemandFetcher class32_sub1, int i) {
		if (modelIds == null)
			return;
		for (int j = 0; j < modelIds.length; j++)
			class32_sub1.method337(modelIds[j] & 0xffff, 0, aByte793);

		if (i >= 0) {
			for (int k = 1; k > 0; k++);
		}
	}

	public static void load(Archive archive) {
		buf = new Buffer(archive.getFile("loc.dat"));
		Buffer buf = new Buffer(archive.getFile("loc.idx"));
		count = buf.getUnsignedLEShort();
		indices = new int[count];
		int pos = 2;
		for (int id = 0; id < count; id++) {
			indices[id] = pos;
			pos += buf.getUnsignedLEShort();
		}

		cache = new GameObjectDefinition[20];
		for (int k = 0; k < 20; k++)
			cache[k] = new GameObjectDefinition();

	}

	public Model getGameObjectAnimatedModel(int type, int animationId, int face) {
		Model subModel = null;
		long hash;
		if (modelTypes == null) {
			if (type != 10)
				return null;
			hash = ((id << 6) + face) + ((long) (animationId + 1) << 32);
			Model cachedModel = (Model) animatedModelCache.get(hash);
			if (cachedModel != null)
				return cachedModel;
			if (modelIds == null)
				return null;
			boolean mirror = unknown3 ^ (face > 3);
			int modelCount = modelIds.length;
			for (int modelId = 0; modelId < modelCount; modelId++) {
				int subModelId = modelIds[modelId];
				if (mirror)
					subModelId += 0x10000;
				subModel = (Model) modelCache.get(subModelId);
				if (subModel == null) {
					subModel = Model.getModel(subModelId & 0xffff);
					if (subModel == null)
						return null;
					if (mirror)
						subModel.mirror(0);
					modelCache.put(subModel, subModelId);
				}
				if (modelCount > 1)
					models[modelId] = subModel;
			}

			if (modelCount > 1)
				subModel = new Model(modelCount, models);
		} else {
			int modelType = -1;
			for (int index = 0; index < modelTypes.length; index++) {
				if (modelTypes[index] != type)
					continue;
				modelType = index;
				break;
			}

			if (modelType == -1)
				return null;
			hash = ((id << 6) + (modelType << 3) + face) + ((long) (animationId + 1) << 32);
			Model model = (Model) animatedModelCache.get(hash);
			if (model != null)
				return model;
			int j2 = modelIds[modelType];
			boolean mirror = unknown3 ^ (face > 3);
			if (mirror)
				j2 += 0x10000;
			subModel = (Model) modelCache.get(j2);
			if (subModel == null) {
				subModel = Model.getModel(j2 & 0xffff);
				if (subModel == null)
					return null;
				if (mirror)
					subModel.mirror(0);
				modelCache.put(subModel, j2);
			}
		}
		boolean scale;
		if (modelSizeX != 128 || modelSizeY != 128 || modelSizeZ != 128)
			scale = true;
		else
			scale = false;
		boolean needsTranslation;
		if (translateX != 0 || translateY != 0 || translateZ != 0)
			needsTranslation = true;
		else
			needsTranslation = false;
		Model animtedModel = new Model(anIntArray799 == null, subModel, Animation.exists(animationId));
		if (animationId != -1) {
			animtedModel.createBones();
			animtedModel.applyTransform(animationId);
			animtedModel.triangleSkin = null;
			animtedModel.vectorSkin = null;
		}
		while (face-- > 0)
			animtedModel.rotate90Degrees();
		if (anIntArray799 != null) {
			for (int k2 = 0; k2 < anIntArray799.length; k2++)
				animtedModel.replaceColor(anIntArray799[k2], anIntArray792[k2]);

		}
		if (scale)
			animtedModel.scaleT(modelSizeY, modelSizeZ, 9, modelSizeX);
		if (needsTranslation)
			animtedModel.translate(translateX, translateZ, translateY);
		animtedModel.applyLighting(64 + aByte784, 768 + aByte787 * 5, -50, -10, -50, !aBoolean804);
		if (anInt794 == 1)
			animtedModel.anInt1675 = ((Renderable) (animtedModel)).height;
		animatedModelCache.put(animtedModel, hash);
		return animtedModel;
	}

	public boolean method428(int i) {
		if (modelIds == null)
			return true;
		boolean flag = true;
		while (i >= 0)
			anInt768 = 347;
		for (int j = 0; j < modelIds.length; j++)
			flag &= Model.isCached(modelIds[j] & 0xffff);

		return flag;
	}

	public void reset() {
		modelIds = null;
		modelTypes = null;
		name = "null";
		description = null;
		anIntArray799 = null;
		anIntArray792 = null;
		anInt801 = 1;
		anInt775 = 1;
		aBoolean810 = true;
		aBoolean809 = true;
		aBoolean759 = false;
		aBoolean769 = false;
		aBoolean804 = false;
		aBoolean797 = false;
		anInt803 = -1;
		anInt802 = 16;
		aByte784 = 0;
		aByte787 = 0;
		options = null;
		icon = -1;
		anInt795 = -1;
		unknown3 = false;
		aBoolean807 = true;
		modelSizeX = 128;
		modelSizeY = 128;
		modelSizeZ = 128;
		anInt764 = 0;
		translateX = 0;
		translateY = 0;
		translateZ = 0;
		aBoolean765 = false;
		aBoolean791 = false;
		anInt794 = -1;
		varbitId = -1;
		configId = -1;
		childrenIds = null;
	}

	public void init(Buffer buf) {
		int i = -1;
		label0: do {
			int attribute;
			do {
				attribute = buf.getUnsignedByte();
				if (attribute == 0)
					break label0;
				if (attribute == 1) {
					int k = buf.getUnsignedByte();
					if (k > 0)
						if (modelIds == null || lowMemory) {
							modelTypes = new int[k];
							modelIds = new int[k];
							for (int k1 = 0; k1 < k; k1++) {
								modelIds[k1] = buf.getUnsignedLEShort();
								modelTypes[k1] = buf.getUnsignedByte();
							}

						} else {
							buf.offset += k * 3;
						}
				} else if (attribute == 2)
					name = buf.getString();
				else if (attribute == 3)
					description = buf.getStringBytes();
				else if (attribute == 5) {
					int l = buf.getUnsignedByte();
					if (l > 0)
						if (modelIds == null || lowMemory) {
							modelTypes = null;
							modelIds = new int[l];
							for (int l1 = 0; l1 < l; l1++)
								modelIds[l1] = buf.getUnsignedLEShort();

						} else {
							buf.offset += l * 2;
						}
				} else if (attribute == 14)
					anInt801 = buf.getUnsignedByte();
				else if (attribute == 15)
					anInt775 = buf.getUnsignedByte();
				else if (attribute == 17)
					aBoolean810 = false;
				else if (attribute == 18)
					aBoolean809 = false;
				else if (attribute == 19) {
					i = buf.getUnsignedByte();
					if (i == 1)
						aBoolean759 = true;
				} else if (attribute == 21)
					aBoolean769 = true;
				else if (attribute == 22)
					aBoolean804 = true;
				else if (attribute == 23)
					aBoolean797 = true;
				else if (attribute == 24) {
					anInt803 = buf.getUnsignedLEShort();
					if (anInt803 == 65535)
						anInt803 = -1;
				} else if (attribute == 28)
					anInt802 = buf.getUnsignedByte();
				else if (attribute == 29)
					aByte784 = buf.getSignedByte();
				else if (attribute == 39)
					aByte787 = buf.getSignedByte();
				else if (attribute >= 30 && attribute < 39) {
					if (options == null)
						options = new String[5];
					options[attribute - 30] = buf.getString();
					if (options[attribute - 30].equalsIgnoreCase("hidden"))
						options[attribute - 30] = null;
				} else if (attribute == 40) {
					int i1 = buf.getUnsignedByte();
					anIntArray799 = new int[i1];
					anIntArray792 = new int[i1];
					for (int i2 = 0; i2 < i1; i2++) {
						anIntArray799[i2] = buf.getUnsignedLEShort();
						anIntArray792[i2] = buf.getUnsignedLEShort();
					}

				} else if (attribute == 60)
					icon = buf.getUnsignedLEShort();
				else if (attribute == 62)
					unknown3 = true;
				else if (attribute == 64)
					aBoolean807 = false;
				else if (attribute == 65)
					modelSizeX = buf.getUnsignedLEShort();
				else if (attribute == 66)
					modelSizeY = buf.getUnsignedLEShort();
				else if (attribute == 67)
					modelSizeZ = buf.getUnsignedLEShort();
				else if (attribute == 68)
					anInt795 = buf.getUnsignedLEShort();
				else if (attribute == 69)
					anInt764 = buf.getUnsignedByte();
				else if (attribute == 70)
					translateX = buf.getSignedShort();
				else if (attribute == 71)
					translateY = buf.getSignedShort();
				else if (attribute == 72)
					translateZ = buf.getSignedShort();
				else if (attribute == 73)
					aBoolean765 = true;
				else if (attribute == 74) {
					aBoolean791 = true;
				} else {
					if (attribute != 75)
						continue;
					anInt794 = buf.getUnsignedByte();
				}
				continue label0;
			} while (attribute != 77);
			varbitId = buf.getUnsignedLEShort();
			if (varbitId == 65535)
				varbitId = -1;
			configId = buf.getUnsignedLEShort();
			if (configId == 65535)
				configId = -1;
			int j1 = buf.getUnsignedByte();
			childrenIds = new int[j1 + 1];
			for (int j2 = 0; j2 <= j1; j2++) {
				childrenIds[j2] = buf.getUnsignedLEShort();
				if (childrenIds[j2] == 65535)
					childrenIds[j2] = -1;
			}

		} while (true);
		if (i == -1) {
			aBoolean759 = false;
			if (modelIds != null && (modelTypes == null || modelTypes[0] == 10))
				aBoolean759 = true;
			if (options != null)
				aBoolean759 = true;
		}
		if (aBoolean791) {
			aBoolean810 = false;
			aBoolean809 = false;
		}
		if (anInt794 == -1)
			anInt794 = aBoolean810 ? 1 : 0;
	}

	public Model getGameObjectModel(int type, int face, int vertexHeight, int vertexHeightRight, int vertexHeightTopRight, int vertexHeightTop, int animationId) {
		Model model = getGameObjectAnimatedModel(type, animationId, face);
		if (model == null)
			return null;
		if (aBoolean769 || aBoolean804)
			model = new Model(aBoolean769, aBoolean804, 0, model);
		if (aBoolean769) {
			int l1 = (vertexHeight + vertexHeightRight + vertexHeightTopRight + vertexHeightTop) / 4;
			for (int i2 = 0; i2 < model.vertexCount; i2++) {
				int j2 = model.verticesX[i2];
				int k2 = model.verticesZ[i2];
				int l2 = vertexHeight + ((vertexHeightRight - vertexHeight) * (j2 + 64)) / 128;
				int i3 = vertexHeightTop + ((vertexHeightTopRight - vertexHeightTop) * (j2 + 64)) / 128;
				int j3 = l2 + ((i3 - l2) * (k2 + 64)) / 128;
				model.verticesY[i2] += j3 - l1;
			}

			model.normalise();
		}
		return model;
	}

	public boolean method432(int i, int j) {
		if (i != 26261)
			aBoolean786 = !aBoolean786;
		if (modelTypes == null) {
			if (modelIds == null)
				return true;
			if (j != 10)
				return true;
			boolean flag = true;
			for (int l = 0; l < modelIds.length; l++)
				flag &= Model.isCached(modelIds[l] & 0xffff);

			return flag;
		}
		for (int k = 0; k < modelTypes.length; k++)
			if (modelTypes[k] == j)
				return Model.isCached(modelIds[k] & 0xffff);

		return true;
	}

	public static void method433(boolean flag) {
		modelCache = null;
		animatedModelCache = null;
		indices = null;
		if (flag) {
			for (int i = 1; i > 0; i++);
		}
		cache = null;
		buf = null;
	}

	public GameObjectDefinition() {
		anInt768 = -992;
		id = -1;
		aBoolean774 = true;
		name = "null";
		aBoolean786 = true;
		aByte793 = -113;
	}

	public static int indices[];
	public boolean aBoolean759;
	public int modelSizeY;
	public int translateX;
	public static Cache animatedModelCache = new Cache(40);
	public int modelIds[];
	public int anInt764;
	public boolean aBoolean765;
	public int translateZ;
	public static Buffer buf;
	public int anInt768;
	public boolean aBoolean769;
	public static Game client;
	public static Model models[] = new Model[4];
	public static boolean lowMemory;
	public int id;
	public boolean aBoolean774;
	public int anInt775;
	public String name;
	public static int cachePos;
	public int varbitId;
	public static Cache modelCache = new Cache(500);
	public int modelSizeX;
	public int configId;
	public static GameObjectDefinition cache[];
	public byte description[];
	public byte aByte784;
	public int translateY;
	public boolean aBoolean786;
	public byte aByte787;
	public int anInt788;
	public int modelTypes[];
	public String options[];
	public boolean aBoolean791;
	public int anIntArray792[];
	public byte aByte793;
	public int anInt794;
	public int anInt795;
	public int modelSizeZ;
	public boolean aBoolean797;
	public boolean unknown3;
	public int anIntArray799[];
	public int anInt801;
	public int anInt802;
	public int anInt803;
	public boolean aBoolean804;
	public int childrenIds[];
	public int icon;
	public boolean aBoolean807;
	public static int count;
	public boolean aBoolean809;
	public boolean aBoolean810;

}

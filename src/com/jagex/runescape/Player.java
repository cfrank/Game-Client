package com.jagex.runescape;

import com.jagex.runescape.cache.def.ActorDefinition;
import com.jagex.runescape.cache.media.AnimationSequence;
import com.jagex.runescape.cache.media.IdentityKit;
import com.jagex.runescape.collection.Cache;
import com.jagex.runescape.media.Animation;
import com.jagex.runescape.media.renderable.Model;
import com.jagex.runescape.media.renderable.Renderable;
import com.jagex.runescape.media.renderable.actor.Actor;
import com.jagex.runescape.net.Buffer;
import com.jagex.runescape.util.TextUtils;

public class Player extends Actor {

	public int anInt1743;
	public int anInt1744;
	public int anInt1745;
	public Model aClass50_Sub1_Sub4_Sub4_1746;
	public int anInt1748 = -1;
	public long aLong1749 = -1L;
	public int anInt1750;
	public String username;
	public int equipment[] = new int[12];
	public int anInt1753;
	public long appearanceHash;
	public int gender;
	public int anInt1756 = -1;
	public ActorDefinition npc;
	public boolean visible = false;
	public int anInt1759;
	public int colors[] = new int[5];
	public static Cache modelCache = new Cache(260);
	public boolean aBoolean1762 = true;
	public boolean aBoolean1763 = false;
	public int anInt1764;
	public int anInt1765;
	public int team;
	public boolean aBoolean1767 = false;
	public int anInt1768;
	public int anInt1769;
	public int anInt1770;
	public int anInt1771;
	public int anInt1772 = 932;


	public Model getHeadModel() {
		if (!visible)
			return null;
		if (npc != null)
			return npc.getHeadModel();
		boolean flag1 = false;
		for (int i = 0; i < 12; i++) {
			int j = equipment[i];
			if (j >= 256 && j < 512 && !IdentityKit.cache[j - 256].isHeadModelCached())
				flag1 = true;
			if (j >= 512 && !ItemDefinition.forId(j - 512).method211(gender))
				flag1 = true;
		}

		if (flag1)
			return null;
		Model subModels[] = new Model[12];
		int k = 0;
		for (int l = 0; l < 12; l++) {
			int i1 = equipment[l];
			if (i1 >= 256 && i1 < 512) {
				Model model = IdentityKit.cache[i1 - 256].getHeadModel();
				if (model != null)
					subModels[k++] = model;
			}
			if (i1 >= 512) {
				Model model = ItemDefinition.forId(i1 - 512).getGenderModel(gender);
				if (model != null)
					subModels[k++] = model;
			}
		}

		Model model = new Model(k, subModels);
		for (int j1 = 0; j1 < 5; j1++)
			if (colors[j1] != 0) {
				model.replaceColor(Game.playerColours[j1][0],
						Game.playerColours[j1][colors[j1]]);
				if (j1 == 1)
					model.replaceColor(Game.anIntArray1268[0], Game.anIntArray1268[colors[j1]]);
			}

		return model;
	}

	public Model method571(byte byte0) {
		if (npc != null) {
			int i = -1;
			if (super.animation >= 0 && super.animationDelay == 0)
				i = AnimationSequence.cache[super.animation].frame2Ids[super.anInt1625];
			else if (super.anInt1588 >= 0)
				i = AnimationSequence.cache[super.anInt1588].frame2Ids[super.anInt1589];
			Model class50_sub1_sub4_sub4 = npc.getChildModel(i, -1, null);
			return class50_sub1_sub4_sub4;
		}
		long l = appearanceHash;
		int j = -1;
		int k = -1;
		int i1 = -1;
		int j1 = -1;
		if (byte0 != 122)
			aBoolean1767 = !aBoolean1767;
		if (super.animation >= 0 && super.animationDelay == 0) {
			AnimationSequence class14 = AnimationSequence.cache[super.animation];
			j = class14.frame2Ids[super.anInt1625];
			if (super.anInt1588 >= 0 && super.anInt1588 != super.standAnimationId)
				k = AnimationSequence.cache[super.anInt1588].frame2Ids[super.anInt1589];
			if (class14.anInt302 >= 0) {
				i1 = class14.anInt302;
				l += i1 - equipment[5] << 40;
			}
			if (class14.anInt303 >= 0) {
				j1 = class14.anInt303;
				l += j1 - equipment[3] << 48;
			}
		} else if (super.anInt1588 >= 0)
			j = AnimationSequence.cache[super.anInt1588].frame2Ids[super.anInt1589];
		Model class50_sub1_sub4_sub4_1 = (Model) modelCache.get(l);
		if (class50_sub1_sub4_sub4_1 == null) {
			boolean flag = false;
			for (int k1 = 0; k1 < 12; k1++) {
				int i2 = equipment[k1];
				if (j1 >= 0 && k1 == 3)
					i2 = j1;
				if (i1 >= 0 && k1 == 5)
					i2 = i1;
				if (i2 >= 256 && i2 < 512 && !IdentityKit.cache[i2 - 256].isBodyModelCached())
					flag = true;
				if (i2 >= 512 && !ItemDefinition.forId(i2 - 512).method216(-861, gender))
					flag = true;
			}

			if (flag) {
				if (aLong1749 != -1L)
					class50_sub1_sub4_sub4_1 = (Model) modelCache.get(aLong1749);
				if (class50_sub1_sub4_sub4_1 == null)
					return null;
			}
		}
		if (class50_sub1_sub4_sub4_1 == null) {
			Model aclass50_sub1_sub4_sub4[] = new Model[12];
			int l1 = 0;
			for (int j2 = 0; j2 < 12; j2++) {
				int k2 = equipment[j2];
				if (j1 >= 0 && j2 == 3)
					k2 = j1;
				if (i1 >= 0 && j2 == 5)
					k2 = i1;
				if (k2 >= 256 && k2 < 512) {
					Model class50_sub1_sub4_sub4_3 = IdentityKit.cache[k2 - 256]
							.getBodyModel();
					if (class50_sub1_sub4_sub4_3 != null)
						aclass50_sub1_sub4_sub4[l1++] = class50_sub1_sub4_sub4_3;
				}
				if (k2 >= 512) {
					Model class50_sub1_sub4_sub4_4 = ItemDefinition.forId(k2 - 512).method213(
							(byte) -98, gender);
					if (class50_sub1_sub4_sub4_4 != null)
						aclass50_sub1_sub4_sub4[l1++] = class50_sub1_sub4_sub4_4;
				}
			}

			class50_sub1_sub4_sub4_1 = new Model(l1, aclass50_sub1_sub4_sub4);
			for (int l2 = 0; l2 < 5; l2++)
				if (colors[l2] != 0) {
					class50_sub1_sub4_sub4_1.replaceColor(Game.playerColours[l2][0],
							Game.playerColours[l2][colors[l2]]);
					if (l2 == 1)
						class50_sub1_sub4_sub4_1.replaceColor(Game.anIntArray1268[0], Game.anIntArray1268[colors[l2]]);
				}

			class50_sub1_sub4_sub4_1.createBones();
			class50_sub1_sub4_sub4_1.applyLighting(64, 850, -30, -50, -30, true);
			modelCache.put(class50_sub1_sub4_sub4_1, l);
			aLong1749 = l;
		}
		if (aBoolean1763)
			return class50_sub1_sub4_sub4_1;
		Model class50_sub1_sub4_sub4_2 = Model.aModel1614;
		class50_sub1_sub4_sub4_2.replaceWithModel(class50_sub1_sub4_sub4_1, Animation.exists(j) & Animation.exists(k)
		);
		if (j != -1 && k != -1)
			class50_sub1_sub4_sub4_2.mixAnimationFrames(k, 0, j, AnimationSequence.cache[super.animation].flowControl);
		else if (j != -1)
			class50_sub1_sub4_sub4_2.applyTransform(j);
		class50_sub1_sub4_sub4_2.calculateDiagonals();
		class50_sub1_sub4_sub4_2.triangleSkin = null;
		class50_sub1_sub4_sub4_2.vectorSkin = null;
		return class50_sub1_sub4_sub4_2;
	}

	@Override
	public boolean isVisible() {
		return visible;
	}

	@Override
	public Model getRotatedModel() {
		if (!visible)
			return null;
		Model class50_sub1_sub4_sub4 = method571((byte) 122);
		if (class50_sub1_sub4_sub4 == null)
			return null;
		super.modelHeight = ((Renderable) (class50_sub1_sub4_sub4)).height;
		class50_sub1_sub4_sub4.oneSquareModel = true;
		if (aBoolean1763)
			return class50_sub1_sub4_sub4;
		if (super.spotAnimationId != -1 && super.currentAnimationFrame != -1) {
			SpotAnimation class27 = SpotAnimation.cache[super.spotAnimationId];
			Model class50_sub1_sub4_sub4_2 = class27.getModel();
			if (class50_sub1_sub4_sub4_2 != null) {
				Model class50_sub1_sub4_sub4_3 = new Model(true,
						class50_sub1_sub4_sub4_2, Animation.exists(super.currentAnimationFrame));
				class50_sub1_sub4_sub4_3.translate(0, 0, -super.anInt1618);
				class50_sub1_sub4_sub4_3.createBones();
				class50_sub1_sub4_sub4_3.applyTransform(class27.sequences.frame2Ids[super.currentAnimationFrame]);
				class50_sub1_sub4_sub4_3.triangleSkin = null;
				class50_sub1_sub4_sub4_3.vectorSkin = null;
				if (class27.resizeXY != 128 || class27.resizeZ != 128)
					class50_sub1_sub4_sub4_3.scaleT(class27.resizeZ, class27.resizeXY, 9, class27.resizeXY);
				class50_sub1_sub4_sub4_3.applyLighting(64 + class27.modelLightFalloff, 850 + class27.modelLightAmbient, -30, -50, -30, true);
				Model aclass50_sub1_sub4_sub4_1[] = { class50_sub1_sub4_sub4, class50_sub1_sub4_sub4_3 };
				class50_sub1_sub4_sub4 = new Model(2, 0, aclass50_sub1_sub4_sub4_1);
			}
		}
		if (aClass50_Sub1_Sub4_Sub4_1746 != null) {
			if (Game.pulseCycle >= anInt1765)
				aClass50_Sub1_Sub4_Sub4_1746 = null;
			if (Game.pulseCycle >= anInt1764 && Game.pulseCycle < anInt1765) {
				Model class50_sub1_sub4_sub4_1 = aClass50_Sub1_Sub4_Sub4_1746;
				class50_sub1_sub4_sub4_1.translate(anInt1743 - super.unitX, anInt1745 - super.unitY,
						anInt1744 - anInt1750);
				if (super.anInt1584 == 512) {
					class50_sub1_sub4_sub4_1.rotate90Degrees();
					class50_sub1_sub4_sub4_1.rotate90Degrees();
					class50_sub1_sub4_sub4_1.rotate90Degrees();
				} else if (super.anInt1584 == 1024) {
					class50_sub1_sub4_sub4_1.rotate90Degrees();
					class50_sub1_sub4_sub4_1.rotate90Degrees();
				} else if (super.anInt1584 == 1536)
					class50_sub1_sub4_sub4_1.rotate90Degrees();
				Model aclass50_sub1_sub4_sub4[] = { class50_sub1_sub4_sub4, class50_sub1_sub4_sub4_1 };
				class50_sub1_sub4_sub4 = new Model(2, 0, aclass50_sub1_sub4_sub4);
				if (super.anInt1584 == 512)
					class50_sub1_sub4_sub4_1.rotate90Degrees();
				else if (super.anInt1584 == 1024) {
					class50_sub1_sub4_sub4_1.rotate90Degrees();
					class50_sub1_sub4_sub4_1.rotate90Degrees();
				} else if (super.anInt1584 == 1536) {
					class50_sub1_sub4_sub4_1.rotate90Degrees();
					class50_sub1_sub4_sub4_1.rotate90Degrees();
					class50_sub1_sub4_sub4_1.rotate90Degrees();
				}
				class50_sub1_sub4_sub4_1.translate(super.unitX - anInt1743, super.unitY - anInt1745,
						anInt1750 - anInt1744);
			}
		}
		class50_sub1_sub4_sub4.oneSquareModel = true;
		return class50_sub1_sub4_sub4;
	}

	public void updateAppearance(Buffer buf, int i) {
		buf.currentPosition = 0;
		gender = buf.getUnsignedByte();
		anInt1756 = buf.getSignedByte();
		anInt1748 = buf.getSignedByte();
		npc = null;
		team = 0;
		for (int slot = 0; slot < 12; slot++) {
			int upperByte = buf.getUnsignedByte();
			if (upperByte == 0) {
				equipment[slot] = 0;
				continue;
			}
			int lowerByte = buf.getUnsignedByte();
			equipment[slot] = (upperByte << 8) + lowerByte;
			if (slot == 0 && equipment[0] == 65535) {
				npc = ActorDefinition.getDefinition(buf.getUnsignedLEShort());
				break;
			}
			if (equipment[slot] >= 512 && equipment[slot] - 512 < ItemDefinition.count) {
				int itemTeam = ItemDefinition.forId(equipment[slot] - 512).team;
				if (itemTeam != 0)
					team = itemTeam;
			}
		}

		for (int l = 0; l < 5; l++) {
			int j1 = buf.getUnsignedByte();
			if (j1 < 0 || j1 >= Game.playerColours[l].length)
				j1 = 0;
			colors[l] = j1;
		}

		super.standAnimationId = buf.getUnsignedLEShort();
		if (super.standAnimationId == 65535)
			super.standAnimationId = -1;
		super.anInt1635 = buf.getUnsignedLEShort();
		if (super.anInt1635 == 65535)
			super.anInt1635 = -1;
		super.anInt1619 = buf.getUnsignedLEShort();
		if (super.anInt1619 == 65535)
			super.anInt1619 = -1;
		super.anInt1620 = buf.getUnsignedLEShort();
		if (super.anInt1620 == 65535)
			super.anInt1620 = -1;
		super.anInt1621 = buf.getUnsignedLEShort();
		if (super.anInt1621 == 65535)
			super.anInt1621 = -1;
		super.anInt1622 = buf.getUnsignedLEShort();
		if (super.anInt1622 == 65535)
			super.anInt1622 = -1;
		super.anInt1629 = buf.getUnsignedLEShort();
		if (super.anInt1629 == 65535)
			super.anInt1629 = -1;
		username = TextUtils.formatName(TextUtils.longToName(buf.getLong()));
		anInt1753 = buf.getUnsignedByte();
		anInt1759 = buf.getUnsignedLEShort();
		visible = true;
		appearanceHash = 0L;
		int k1 = equipment[5];
		int i2 = equipment[9];
		if (i != 0)
			return;
		equipment[5] = i2;
		equipment[9] = k1;
		for (int j2 = 0; j2 < 12; j2++) {
			appearanceHash <<= 4;
			if (equipment[j2] >= 256)
				appearanceHash += equipment[j2] - 256;
		}

		if (equipment[0] >= 256)
			appearanceHash += equipment[0] - 256 >> 4;
		if (equipment[1] >= 256)
			appearanceHash += equipment[1] - 256 >> 8;
		equipment[5] = k1;
		equipment[9] = i2;
		for (int k2 = 0; k2 < 5; k2++) {
			appearanceHash <<= 3;
			appearanceHash += colors[k2];
		}

		appearanceHash <<= 1;
		appearanceHash += gender;
	}


}

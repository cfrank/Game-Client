package com.jagex.runescape;

import com.jagex.runescape.cache.Archive;
import com.jagex.runescape.cache.def.ActorDefinition;
import com.jagex.runescape.collection.Cache;
import com.jagex.runescape.media.Animation;
import com.jagex.runescape.media.renderable.Model;
import com.jagex.runescape.net.Buffer;
import com.jagex.runescape.util.TextUtils;

public class Widget {

	public static ImageRGB method194(int i, String s, int j) {
		long l = (TextUtils.spriteToHash(s) << 8) + i;
		if (j <= 0)
			anInt275 = -317;
		ImageRGB class50_sub1_sub1_sub1 = (ImageRGB) aClass33_250.get(l);
		if (class50_sub1_sub1_sub1 != null)
			return class50_sub1_sub1_sub1;
		if (aClass2_214 == null)
			return null;
		try {
			class50_sub1_sub1_sub1 = new ImageRGB(aClass2_214, s, i);
			aClass33_250.put(class50_sub1_sub1_sub1, l);
		} catch (Exception _ex) {
			return null;
		}
		return class50_sub1_sub1_sub1;
	}

	public static Widget forId(int id) {
		if (interfaces[id] == null) {
			Buffer buf = new Buffer(data[id]);
			int j = buf.getUnsignedLEShort();
			interfaces[id] = parse(j, buf, id);
		}
		return interfaces[id];
	}

	public void swapItems(int slot2, int slot1) {
		int temp = inventoryItemId[slot2];
		inventoryItemId[slot2] = inventoryItemId[slot1];
		inventoryItemId[slot1] = temp;
		temp = itemAmounts[slot2];
		itemAmounts[slot2] = itemAmounts[slot1];
		itemAmounts[slot1] = temp;
	}

	public Model method197(int type, int id) {
		ItemDefinition item = null;
		if (type == 4) {
			item = ItemDefinition.forId(id);
			anInt280 += item.anInt354;
			anInt243 += item.anInt358;
		}
		Model model = (Model) lruModelTable.get((type << 16) + id);
		if (model != null)
			return model;
		if (type == 1)
			model = Model.getModel(id);
		if (type == 2)
			model = ActorDefinition.getDefinition(id).getHeadModel();
		if (type == 3)
			model = Game.thisPlayer.getHeadModel();
		if (type == 4)
			model = item.getUncachedModel(50);
		if (type == 5)
			model = null;
		if (model != null)
			lruModelTable.put(model, (type << 16) + id);
		return model;
	}

	public static Widget parse(int i, Buffer buf, int id) {
		Widget inter = new Widget();
		inter.id = id;
		inter.anInt248 = i;
		inter.anInt236 = buf.getUnsignedByte();
		inter.anInt289 = buf.getUnsignedByte();
		inter.contentType = buf.getUnsignedLEShort();
		inter.anInt241 = buf.getUnsignedLEShort();
		inter.anInt238 = buf.getUnsignedLEShort();
		inter.aByte220 = (byte) buf.getUnsignedByte();
		inter.anInt254 = buf.getUnsignedByte();
		if (inter.anInt254 != 0)
			inter.anInt254 = (inter.anInt254 - 1 << 8) + buf.getUnsignedByte();
		else
			inter.anInt254 = -1;
		if (inter.contentType == 600)
			anInt246 = i;
		if (inter.contentType == 650)
			anInt255 = i;
		if (inter.contentType == 655)
			anInt277 = i;
		int l = buf.getUnsignedByte();
		if (l > 0) {
			inter.anIntArray273 = new int[l];
			inter.anIntArray256 = new int[l];
			for (int i1 = 0; i1 < l; i1++) {
				inter.anIntArray273[i1] = buf.getUnsignedByte();
				inter.anIntArray256[i1] = buf.getUnsignedLEShort();
			}

		}
		int j1 = buf.getUnsignedByte();
		if (j1 > 0) {
			inter.anIntArrayArray234 = new int[j1][];
			for (int k1 = 0; k1 < j1; k1++) {
				int l2 = buf.getUnsignedLEShort();
				inter.anIntArrayArray234[k1] = new int[l2];
				for (int k4 = 0; k4 < l2; k4++)
					inter.anIntArrayArray234[k1][k4] = buf.getUnsignedLEShort();

			}

		}
		if (inter.anInt236 == 0) {
			inter.anInt285 = buf.getUnsignedLEShort();
			inter.aBoolean219 = buf.getUnsignedByte() == 1;
			int l1 = buf.getUnsignedLEShort();
			inter.anIntArray258 = new int[l1];
			inter.anIntArray232 = new int[l1];
			inter.anIntArray276 = new int[l1];
			for (int i3 = 0; i3 < l1; i3++) {
				inter.anIntArray258[i3] = buf.getUnsignedLEShort();
				inter.anIntArray232[i3] = buf.getSignedShort();
				inter.anIntArray276[i3] = buf.getSignedShort();
			}

		}
		if (inter.anInt236 == 1) {
			inter.anInt225 = buf.getUnsignedLEShort();
			inter.aBoolean233 = buf.getUnsignedByte() == 1;
		}
		if (inter.anInt236 == 2) {
			inter.inventoryItemId = new int[inter.anInt241 * inter.anInt238];
			inter.itemAmounts = new int[inter.anInt241 * inter.anInt238];
			inter.aBoolean274 = buf.getUnsignedByte() == 1;
			inter.aBoolean229 = buf.getUnsignedByte() == 1;
			inter.aBoolean288 = buf.getUnsignedByte() == 1;
			inter.replaceItems = buf.getUnsignedByte() == 1;
			inter.anInt263 = buf.getUnsignedByte();
			inter.anInt244 = buf.getUnsignedByte();
			inter.anIntArray221 = new int[20];
			inter.anIntArray213 = new int[20];
			inter.aClass50_Sub1_Sub1_Sub1Array265 = new ImageRGB[20];
			for (int i2 = 0; i2 < 20; i2++) {
				int j3 = buf.getUnsignedByte();
				if (j3 == 1) {
					inter.anIntArray221[i2] = buf.getSignedShort();
					inter.anIntArray213[i2] = buf.getSignedShort();
					String s1 = buf.getString();
					if (s1.length() > 0) {
						int l4 = s1.lastIndexOf(",");
						inter.aClass50_Sub1_Sub1_Sub1Array265[i2] = method194(Integer.parseInt(s1.substring(l4 + 1)),
								s1.substring(0, l4), 373);
					}
				}
			}

			inter.options = new String[5];
			for (int optionId = 0; optionId < 5; optionId++) {
				inter.options[optionId] = buf.getString();
				if (inter.options[optionId].length() == 0)
					inter.options[optionId] = null;
			}

		}
		if (inter.anInt236 == 3)
			inter.aBoolean239 = buf.getUnsignedByte() == 1;
		if (inter.anInt236 == 4 || inter.anInt236 == 1) {
			inter.aBoolean272 = buf.getUnsignedByte() == 1;
			int j2 = buf.getUnsignedByte();
			if (aClass50_Sub1_Sub1_Sub2Array223 != null)
				inter.aClass50_Sub1_Sub1_Sub2_237 = aClass50_Sub1_Sub1_Sub2Array223[j2];
			inter.aBoolean247 = buf.getUnsignedByte() == 1;
		}
		if (inter.anInt236 == 4) {
			inter.aString230 = buf.getString();
			inter.aString249 = buf.getString();
		}
		if (inter.anInt236 == 1 || inter.anInt236 == 3 || inter.anInt236 == 4)
			inter.anInt240 = buf.getInt();
		if (inter.anInt236 == 3 || inter.anInt236 == 4) {
			inter.anInt260 = buf.getInt();
			inter.anInt261 = buf.getInt();
			inter.anInt226 = buf.getInt();
		}
		if (inter.anInt236 == 5) {
			String s = buf.getString();
			if (s.length() > 0) {
				int l3 = s.lastIndexOf(",");
				inter.aClass50_Sub1_Sub1_Sub1_212 = method194(Integer.parseInt(s.substring(l3 + 1)), s.substring(0,
						l3), 373);
			}
			s = buf.getString();
			if (s.length() > 0) {
				int i4 = s.lastIndexOf(",");
				inter.aClass50_Sub1_Sub1_Sub1_245 = method194(Integer.parseInt(s.substring(i4 + 1)), s.substring(0,
						i4), 373);
			}
		}
		if (inter.anInt236 == 6) {
			id = buf.getUnsignedByte();
			if (id != 0) {
				inter.anInt283 = 1;
				inter.anInt284 = (id - 1 << 8) + buf.getUnsignedByte();
			}
			id = buf.getUnsignedByte();
			if (id != 0) {
				inter.anInt266 = 1;
				inter.anInt267 = (id - 1 << 8) + buf.getUnsignedByte();
			}
			id = buf.getUnsignedByte();
			if (id != 0)
				inter.anInt286 = (id - 1 << 8) + buf.getUnsignedByte();
			else
				inter.anInt286 = -1;
			id = buf.getUnsignedByte();
			if (id != 0)
				inter.anInt287 = (id - 1 << 8) + buf.getUnsignedByte();
			else
				inter.anInt287 = -1;
			inter.anInt251 = buf.getUnsignedLEShort();
			inter.anInt252 = buf.getUnsignedLEShort();
			inter.anInt253 = buf.getUnsignedLEShort();
		}
		if (inter.anInt236 == 7) {
			inter.inventoryItemId = new int[inter.anInt241 * inter.anInt238];
			inter.itemAmounts = new int[inter.anInt241 * inter.anInt238];
			inter.aBoolean272 = buf.getUnsignedByte() == 1;
			int k2 = buf.getUnsignedByte();
			if (aClass50_Sub1_Sub1_Sub2Array223 != null)
				inter.aClass50_Sub1_Sub1_Sub2_237 = aClass50_Sub1_Sub1_Sub2Array223[k2];
			inter.aBoolean247 = buf.getUnsignedByte() == 1;
			inter.anInt240 = buf.getInt();
			inter.anInt263 = buf.getSignedShort();
			inter.anInt244 = buf.getSignedShort();
			inter.aBoolean229 = buf.getUnsignedByte() == 1;
			inter.options = new String[5];
			for (int optionId = 0; optionId < 5; optionId++) {
				inter.options[optionId] = buf.getString();
				if (inter.options[optionId].length() == 0)
					inter.options[optionId] = null;
			}

		}
		if (inter.anInt236 == 8)
			inter.aString230 = buf.getString();
		if (inter.anInt289 == 2 || inter.anInt236 == 2) {
			inter.aString281 = buf.getString();
			inter.aString211 = buf.getString();
			inter.anInt222 = buf.getUnsignedLEShort();
		}
		if (inter.anInt289 == 1 || inter.anInt289 == 4 || inter.anInt289 == 5 || inter.anInt289 == 6) {
			inter.tooltip = buf.getString();
			if (inter.tooltip.length() == 0) {
				if (inter.anInt289 == 1)
					inter.tooltip = "Ok";
				if (inter.anInt289 == 4)
					inter.tooltip = "Select";
				if (inter.anInt289 == 5)
					inter.tooltip = "Select";
				if (inter.anInt289 == 6)
					inter.tooltip = "Continue";
			}
		}
		return inter;
	}

	public static void load(Archive archive, TypeFace[] aclass50_sub1_sub1_sub2, Archive class2_1) {
		aClass33_250 = new Cache(50000);
		aClass2_214 = class2_1;
		aClass50_Sub1_Sub1_Sub2Array223 = aclass50_sub1_sub1_sub2;
		int j = -1;
		Buffer buf = new Buffer(archive.getFile("data"));
		int count = buf.getUnsignedLEShort();
		interfaces = new Widget[count];
		data = new byte[count][];
		while (buf.currentPosition < buf.buffer.length) {
			int l = buf.getUnsignedLEShort();
			if (l == 65535) {
				j = buf.getUnsignedLEShort();
				l = buf.getUnsignedLEShort();
			}
			int i1 = buf.currentPosition;
			Widget inter = parse(j, buf, l);
			byte temp[] = data[inter.id] = new byte[(buf.currentPosition - i1) + 2];
			for (int j1 = i1; j1 < buf.currentPosition; j1++)
				temp[(j1 - i1) + 2] = buf.buffer[j1];

			temp[0] = (byte) (j >> 8);
			temp[1] = (byte) j;
		}
		aClass2_214 = null;
	}

	public static void method200(boolean flag, int i) {
		if (!flag)
			aBoolean257 = !aBoolean257;
		if (i == -1)
			return;
		for (int j = 0; j < interfaces.length; j++)
			if (interfaces[j] != null && interfaces[j].anInt248 == i && interfaces[j].anInt236 != 2)
				interfaces[j] = null;

	}

	public static void method201(int i, Model class50_sub1_sub4_sub4, int j, int k) {
		lruModelTable.removeAll();
		if (k != 6) {
			for (int l = 1; l > 0; l++);
		}
		if (class50_sub1_sub4_sub4 != null && i != 4)
			lruModelTable.put(class50_sub1_sub4_sub4, (i << 16) + j);
	}

	public static void method202(boolean flag) {
		interfaces = null;
		aClass2_214 = null;
		if (flag)
			aBoolean257 = !aBoolean257;
		aClass33_250 = null;
		aClass50_Sub1_Sub1_Sub2Array223 = null;
		data = null;
	}

	public Model method203(int i, int j, int k, boolean flag) {
		anInt280 = 64;
		anInt243 = 768;
		Model model;
		if (flag)
			model = method197(anInt266, anInt267);
		else
			model = method197(anInt283, anInt284);
		if (model == null)
			return null;
		if (i == -1 && j == -1 && model.triangleColorValues == null)
			return model;
		Model class50_sub1_sub4_sub4_1 = new Model(true,
				model, Animation.exists(i) & Animation.exists(j));
		if (k != 0)
			aBoolean271 = !aBoolean271;
		if (i != -1 || j != -1)
			class50_sub1_sub4_sub4_1.createBones();
		if (i != -1)
			class50_sub1_sub4_sub4_1.applyTransform(i);
		if (j != -1)
			class50_sub1_sub4_sub4_1.applyTransform(j);
		class50_sub1_sub4_sub4_1.applyLighting(anInt280, anInt243, -50, -10, -50, true);
		return class50_sub1_sub4_sub4_1;
	}

	public Widget() {
		anInt270 = -68;
		aBoolean271 = true;
	}

	public static int anInt210;
	public String aString211;
	public ImageRGB aClass50_Sub1_Sub1_Sub1_212;
	public int anIntArray213[];
	public static Archive aClass2_214;
	public int id;
	public static Widget interfaces[];
	public boolean replaceItems;
	public int anInt218;
	public boolean aBoolean219;
	public byte aByte220;
	public int anIntArray221[];
	public int anInt222;
	public static TypeFace aClass50_Sub1_Sub1_Sub2Array223[];
	public int itemAmounts[];
	public int anInt225;
	public int anInt226;
	public int anInt227;
	public int anInt228;
	public boolean aBoolean229;
	public String aString230;
	public int anInt231;
	public int anIntArray232[];
	public boolean aBoolean233;
	public int anIntArrayArray234[][];
	public int anInt235;
	public int anInt236;
	public TypeFace aClass50_Sub1_Sub1_Sub2_237;
	public int anInt238;
	public boolean aBoolean239;
	public int anInt240;
	public int anInt241;
	public int contentType;
	public static int anInt243;
	public int anInt244;
	public ImageRGB aClass50_Sub1_Sub1_Sub1_245;
	public static int anInt246 = -1;
	public boolean aBoolean247;
	public int anInt248;
	public String aString249;
	public static Cache aClass33_250;
	public int anInt251;
	public int anInt252;
	public int anInt253;
	public int anInt254;
	public static int anInt255 = -1;
	public int anIntArray256[];
	public static boolean aBoolean257;
	public int anIntArray258[];
	public int anInt259;
	public int anInt260;
	public int anInt261;
	public String options[];
	public int anInt263;
	public static Cache lruModelTable = new Cache(30);
	public ImageRGB aClass50_Sub1_Sub1_Sub1Array265[];
	public int anInt266;
	public int anInt267;
	public String tooltip;
	public int inventoryItemId[];
	public int anInt270;
	public boolean aBoolean271;
	public boolean aBoolean272;
	public int anIntArray273[];
	public boolean aBoolean274;
	public static int anInt275 = -291;
	public int anIntArray276[];
	public static int anInt277 = -1;
	public static boolean aBoolean278 = true;
	public static int anInt279 = 373;
	public static int anInt280;
	public String aString281;
	public static byte data[][];
	public int anInt283;
	public int anInt284;
	public int anInt285;
	public int anInt286;
	public int anInt287;
	public boolean aBoolean288;
	public int anInt289;

}

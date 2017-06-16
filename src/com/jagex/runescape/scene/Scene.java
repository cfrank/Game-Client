package com.jagex.runescape.scene;

import com.jagex.runescape.media.Rasterizer;
import com.jagex.runescape.media.Rasterizer3D;
import com.jagex.runescape.media.VertexNormal;
import com.jagex.runescape.media.renderable.Model;
import com.jagex.runescape.media.renderable.Renderable;
import com.jagex.runescape.scene.tile.*;
import com.jagex.runescape.util.LinkedList;

public class Scene {

	public static int anInt444;
	public int anInt450;
	public static boolean lowMemory = true;
	public int anInt452;
	public int anInt453;
	public int anInt454;
	public int anIntArrayArrayArray455[][][];
	public SceneTile tiles[][][];
	public int anInt457;
	public int anInt458;
	public SceneSpawnRequest aSceneSpawnRequestArray459[];
	public int anIntArrayArrayArray460[][][];
	public static int anInt461;
	public static int anInt462;
	public static int anInt463;
	public static int anInt464;
	public static int anInt465;
	public static int anInt466;
	public static int anInt467;
	public static int anInt468;
	public static int anInt469;
	public static int anInt470;
	public static int anInt471;
	public static int anInt472;
	public static int anInt473;
	public static int anInt474;
	public static int anInt475;
	public static int anInt476;
	public static SceneSpawnRequest aSceneSpawnRequestArray477[] = new SceneSpawnRequest[100];
	public static final int anIntArray478[] = { 53, -53, -53, 53 };
	public static final int anIntArray479[] = { -53, -53, 53, 53 };
	public static final int anIntArray480[] = { -45, 45, 45, -45 };
	public static final int anIntArray481[] = { 45, 45, -45, -45 };
	public static boolean aBoolean482;
	public static int anInt483;
	public static int anInt484;
	public static int clickedTileX = -1;
	public static int anInt486 = -1;
	public static int anInt487 = 4;
	public static int anIntArray488[] = new int[anInt487];
	public static SceneCluster aSceneClusterArrayArray554[][] = new SceneCluster[anInt487][500];
	public static int anInt490;
	public static SceneCluster aClass39Array491[] = new SceneCluster[500];
	public static LinkedList aClass6_492 = new LinkedList();
	public static final int anIntArray493[] = { 19, 55, 38, 155, 255, 110, 137, 205, 76 };
	public static final int anIntArray494[] = { 160, 192, 80, 96, 0, 144, 80, 48, 160 };
	public static final int anIntArray495[] = { 76, 8, 137, 4, 0, 1, 38, 2, 19 };
	public static final int anIntArray496[] = { 0, 0, 2, 0, 0, 2, 1, 1, 0 };
	public static final int anIntArray497[] = { 2, 0, 0, 2, 0, 0, 0, 4, 4 };
	public static final int anIntArray498[] = { 0, 4, 4, 8, 0, 0, 8, 0, 0 };
	public static final int anIntArray499[] = { 1, 1, 0, 0, 0, 8, 0, 0, 8 };
	public static final int anIntArray500[] = { 41, 39248, 41, 4643, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 43086,
			41, 41, 41, 41, 41, 41, 41, 8602, 41, 28992, 41, 41, 41, 41, 41, 5056, 41, 41, 41, 7079, 41, 41, 41, 41,
			41, 41, 41, 41, 41, 41, 3131, 41, 41, 41 };
	public int anIntArray501[];
	public int anIntArray502[];
	public int anInt503;
	public int anIntArrayArray504[][] = { new int[16], { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1 }, { 1, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0 },
			{ 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1 }, { 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0 }, { 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1 } };
	public int anIntArrayArray505[][] = { { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 },
			{ 12, 8, 4, 0, 13, 9, 5, 1, 14, 10, 6, 2, 15, 11, 7, 3 },
			{ 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 },
			{ 3, 7, 11, 15, 2, 6, 10, 14, 1, 5, 9, 13, 0, 4, 8, 12 } };
	public static boolean aBooleanArrayArrayArrayArray506[][][][] = new boolean[8][32][51][51];
	public static boolean aBooleanArrayArray507[][];
	public static int anInt508;
	public static int anInt509;
	public static int anInt510;
	public static int anInt511;
	public static int anInt512;
	public static int anInt513;

	public Scene(int ai[][][], int i, int j, int k, byte byte0) {
		aSceneSpawnRequestArray459 = new SceneSpawnRequest[5000];
		anIntArray501 = new int[10000];
		anIntArray502 = new int[10000];
		anInt452 = j;
		anInt453 = k;
		anInt454 = i;
		tiles = new SceneTile[j][k][i];
		anIntArrayArrayArray460 = new int[j][k + 1][i + 1];
		anIntArrayArrayArray455 = ai;
		method241();
	}

	public static void method240() {
		aSceneSpawnRequestArray477 = null;
		anIntArray488 = null;
		aSceneClusterArrayArray554 = null;
		aClass6_492 = null;
		aBooleanArrayArrayArrayArray506 = null;
		aBooleanArrayArray507 = null;

	}

	public void method241() {
		for (int i = 0; i < anInt452; i++) {
			for (int j = 0; j < anInt453; j++) {
				for (int i1 = 0; i1 < anInt454; i1++)
					tiles[i][j][i1] = null;

			}

		}

		for (int l = 0; l < anInt487; l++) {
			for (int j1 = 0; j1 < anIntArray488[l]; j1++)
				aSceneClusterArrayArray554[l][j1] = null;

			anIntArray488[l] = 0;
		}

		for (int k1 = 0; k1 < anInt458; k1++)
			aSceneSpawnRequestArray459[k1] = null;

		anInt458 = 0;
		for (int l1 = 0; l1 < aSceneSpawnRequestArray477.length; l1++)
			aSceneSpawnRequestArray477[l1] = null;

	}

	public void method242(int i) {
		anInt457 = i;
		for (int j = 0; j < anInt453; j++) {
			for (int k = 0; k < anInt454; k++)
				if (tiles[i][j][k] == null)
					tiles[i][j][k] = new SceneTile(i, j, k);

		}

	}

	public void setBridgeMode(int i, int j) {
		SceneTile scenetile = tiles[0][i][j];
		for (int k = 0; k < 3; k++) {
			SceneTile scenetile_15_ = tiles[k][i][j] = tiles[k + 1][i][j];
			if (scenetile_15_ != null) {
				scenetile_15_.anInt1397--;
				for (int i1 = 0; i1 < scenetile_15_.sceneSpawnRequestCount; i1++) {
					SceneSpawnRequest sceneSpawnRequest = scenetile_15_.sceneSpawnRequests[i1];
					if ((sceneSpawnRequest.anInt125 >> 29 & 3) == 2 && sceneSpawnRequest.x == i && sceneSpawnRequest.y == j)
						sceneSpawnRequest.anInt113--;
				}

			}
		}

		if (tiles[0][i][j] == null)
			tiles[0][i][j] = new SceneTile(0, i, j);
		tiles[0][i][j].aClass50_Sub3_1419 = scenetile;
		tiles[3][i][j] = null;
	}

	public static void createCullingOcclussionBox(int j, int k, int l, int i1, int j1, int k1, int l1, int i2) {
		SceneCluster scenecluster = new SceneCluster();
		scenecluster.anInt675 = j / 128;
		scenecluster.anInt676 = l / 128;
		scenecluster.anInt677 = k1 / 128;
		scenecluster.anInt678 = i1 / 128;
		scenecluster.anInt679 = i2;
		scenecluster.anInt680 = j;
		scenecluster.anInt681 = l;
		scenecluster.anInt682 = k1;
		scenecluster.anInt683 = i1;
		scenecluster.anInt684 = l1;
		scenecluster.anInt685 = k;
		aSceneClusterArrayArray554[j1][anIntArray488[j1]++] = scenecluster;
	}

	public void method245(int i, int j, int k, int l) {
		SceneTile sceneTile = tiles[i][j][k];
		if (sceneTile != null) {
			sceneTile.anInt1411 = l;
		}
	}

	public void method246(int i, int j, int k, int l, int i1, int j1, int k1, int l1, int i2, int j2, int k2, int l2,
			int i3, int j3, int k3, int l3, int i4, int j4, int k4, int l4) {
		if (l == 0) {
			GenericTile genericTile = new GenericTile(k2, l2, i3, j3, -1, k4, false);
			for (int i5 = i; i5 >= 0; i5--)
				if (tiles[i5][j][k] == null)
					tiles[i5][j][k] = new SceneTile(i5, j, k);

			tiles[i][j][k].genericTile = genericTile;
			return;
		}
		if (l == 1) {
			GenericTile genericTile_1 = new GenericTile(k3, l3, i4, j4, j1, l4, k1 == l1 && k1 == i2 && k1 == j2);
			for (int j5 = i; j5 >= 0; j5--)
				if (tiles[j5][j][k] == null)
					tiles[j5][j][k] = new SceneTile(j5, j, k);

			tiles[i][j][k].genericTile = genericTile_1;
			return;
		}
		ComplexTile complexTile = new ComplexTile(j2, k3, i2, k1, j, i3, j3, l4, l2, i4, 0, k2, l, l1, j4, j1, k4, l3, k, i1);
		for (int k5 = i; k5 >= 0; k5--)
			if (tiles[k5][j][k] == null)
				tiles[k5][j][k] = new SceneTile(k5, j, k);

		tiles[i][j][k].complexTile = complexTile;
	}

	public void addGroundDecoration(int i, int j, int k, byte byte0, int l, int i1, int j1, Renderable renderable) {
		if (k <= 0)
			return;
		if (renderable == null)
			return;
		FloorDecoration floorDecoration = new FloorDecoration();
		floorDecoration.renderable = renderable;
		floorDecoration.y = i * 128 + 64;
		floorDecoration.z = j * 128 + 64;
		floorDecoration.x = i1;
		floorDecoration.hash = l;
		floorDecoration.config = byte0;
		if (tiles[j1][i][j] == null)
			tiles[j1][i][j] = new SceneTile(j1, i, j);
		tiles[j1][i][j].floorDecoration = floorDecoration;
	}

	public void method248(int i, int plane, Renderable renderable_59_, Renderable renderable,
                          int k, Renderable renderable_58_, int l, int y, int x) {
		CameraAngle cameraAngle = new CameraAngle();
		cameraAngle.aRenderable150 = renderable_59_;
		cameraAngle.y = x * 128 + 64;
		cameraAngle.z = y * 128 + 64;
		cameraAngle.x = i;
		cameraAngle.anInt179 = k;
		cameraAngle.aRenderable151 = renderable;
		cameraAngle.aRenderable152 = renderable_58_;
		int k1 = 0;
		SceneTile sceneTile = tiles[plane][x][y];
		if (sceneTile != null) {
			for (int l1 = 0; l1 < sceneTile.sceneSpawnRequestCount; l1++)
				if (sceneTile.sceneSpawnRequests[l1].aRenderable601 instanceof Model) {
					int i2 = ((Model) sceneTile.sceneSpawnRequests[l1].aRenderable601).anInt1675;
					if (i2 > k1)
						k1 = i2;
				}

		}
		cameraAngle.anInt180 = k1;
		if (tiles[plane][x][y] == null)
			tiles[plane][x][y] = new SceneTile(plane, x, y);
		tiles[plane][x][y].cameraAngle = cameraAngle;
	}

	public void method249(int faceUnknown, Renderable renderable, int hash, int y, byte config, int x, Renderable renderable_68_, int plane, int face,
						  int l1) {
		if (renderable != null || renderable_68_ != null) {
			Wall wall = new Wall();
			wall.hash = hash;
			wall.config = config;
			wall.x = x * 128 + 64;
			wall.y = y * 128 + 64;
			wall.plane = plane;
			wall.aRenderable769 = renderable;
			wall.aRenderable770 = renderable_68_;
			wall.faceUnknown = faceUnknown;
			wall.face = face;
			for (int j2 = l1; j2 >= 0; j2--)
				if (tiles[j2][x][y] == null)
					tiles[j2][x][y] = new SceneTile(j2, x, y);

			tiles[l1][x][y].wall = wall;
		}
	}

	public void addWallDecoration(int plane, int faceUnknown, int face, int hash, byte config, int x, int j1, int y, int l1, int z,
								  Renderable renderable, int j2) {
		if (renderable != null) {
			WallDecoration wallDecoration = new WallDecoration();
			wallDecoration.hash = hash;
			wallDecoration.config = config;
			wallDecoration.y = x * 128 + 64 + l1;
			wallDecoration.x = y * 128 + 64 + j1;
			wallDecoration.plane = z;
			wallDecoration.renderable = renderable;
			wallDecoration.faceUnknown = faceUnknown;
			wallDecoration.face = face;
			for (int planeCounter = plane; planeCounter >= 0; planeCounter--)
				if (tiles[planeCounter][x][y] == null)
					tiles[planeCounter][x][y] = new SceneTile(planeCounter, x, y);

			tiles[plane][x][y].wallDecoration = wallDecoration;
		}
	}

	public boolean method251(int i, int j, int k, Renderable class50_sub1_sub4, byte byte0, int l, int i1,
                             int j1, int k1, int l1, int i2) {
		while (j1 >= 0)
			throw new NullPointerException();
		if (class50_sub1_sub4 == null) {
			return true;
		} else {
			int j2 = i1 * 128 + 64 * j;
			int k2 = k * 128 + 64 * k1;
			return method254(i, i1, k, j, k1, j2, k2, l1, class50_sub1_sub4, l, false, i2, byte0);
		}
	}

	public boolean addEntity(int i, Renderable class50_sub1_sub4, int j, int k, boolean flag, int l, int i1,
							 int j1, int k1, int l1) {
		if (class50_sub1_sub4 == null)
			return true;
		int i2 = j - j1;
		int j2 = k1 - j1;
		int k2 = j + j1;
		int l2 = k1 + j1;
		if (flag) {
			if (l1 > 640 && l1 < 1408)
				l2 += 128;
			if (l1 > 1152 && l1 < 1920)
				k2 += 128;
			if (l1 > 1664 || l1 < 384)
				j2 -= 128;
			if (l1 > 128 && l1 < 896)
				i2 -= 128;
		}
		i2 /= 128;
		j2 /= 128;
		k2 /= 128;
		l2 /= 128;
		return method254(i1, i2, j2, (k2 - i2) + 1, (l2 - j2) + 1, j, k1, k, class50_sub1_sub4, l1, true, i, (byte) 0);
	}

	public boolean addRenderable(int i, int j, int k, int l, Renderable class50_sub1_sub4, int i1, int j1, int k1,
                                 int l1, int i2, int j2, int k2, int l2) {
		if (class50_sub1_sub4 == null)
			return true;
		else
			return method254(k2, i1, j, (j2 - i1) + 1, (k1 - j) + 1, l1, j1, i, class50_sub1_sub4, i2, true, l2,
					(byte) 0);
	}

	public boolean method254(int i, int j, int k, int l, int i1, int j1, int k1, int l1,
                             Renderable renderable, int i2, boolean flag, int j2, byte byte0) {
		for (int k2 = j; k2 < j + l; k2++) {
			for (int l2 = k; l2 < k + i1; l2++) {
				if (k2 < 0 || l2 < 0 || k2 >= anInt453 || l2 >= anInt454)
					return false;
				SceneTile class50_sub3 = tiles[i][k2][l2];
				if (class50_sub3 != null && class50_sub3.sceneSpawnRequestCount >= 5)
					return false;
			}

		}

		SceneSpawnRequest sceneSpawnRequest = new SceneSpawnRequest();
		sceneSpawnRequest.anInt125 = j2;
		sceneSpawnRequest.config = byte0;
		sceneSpawnRequest.anInt113 = i;
		sceneSpawnRequest.anInt115 = j1;
		sceneSpawnRequest.anInt116 = k1;
		sceneSpawnRequest.anInt114 = l1;
		sceneSpawnRequest.aRenderable601 = renderable;
		sceneSpawnRequest.anInt118 = i2;
		sceneSpawnRequest.x = j;
		sceneSpawnRequest.y = k;
		sceneSpawnRequest.anInt120 = (j + l) - 1;
		sceneSpawnRequest.anInt122 = (k + i1) - 1;
		for (int i3 = j; i3 < j + l; i3++) {
			for (int j3 = k; j3 < k + i1; j3++) {
				int k3 = 0;
				if (i3 > j)
					k3++;
				if (i3 < (j + l) - 1)
					k3 += 4;
				if (j3 > k)
					k3 += 8;
				if (j3 < (k + i1) - 1)
					k3 += 2;
				for (int l3 = i; l3 >= 0; l3--)
					if (tiles[l3][i3][j3] == null)
						tiles[l3][i3][j3] = new SceneTile(l3, i3, j3);

				SceneTile sceneTile = tiles[i][i3][j3];
				sceneTile.sceneSpawnRequests[sceneTile.sceneSpawnRequestCount] = sceneSpawnRequest;
				sceneTile.anIntArray1409[sceneTile.sceneSpawnRequestCount] = k3;
				sceneTile.anInt1410 |= k3;
				sceneTile.sceneSpawnRequestCount++;
			}

		}

		if (flag)
			aSceneSpawnRequestArray459[anInt458++] = sceneSpawnRequest;
		return true;
	}

	public void method255() {
		for (int j = 0; j < anInt458; j++) {
			SceneSpawnRequest sceneSpawnRequest = aSceneSpawnRequestArray459[j];
			method256(sceneSpawnRequest);
			aSceneSpawnRequestArray459[j] = null;
		}

		anInt458 = 0;
	}

	public void method256(SceneSpawnRequest sceneSpawnRequest) {
		for (int j = sceneSpawnRequest.x; j <= sceneSpawnRequest.anInt120; j++) {
			for (int k = sceneSpawnRequest.y; k <= sceneSpawnRequest.anInt122; k++) {
				SceneTile class50_sub3 = tiles[sceneSpawnRequest.anInt113][j][k];
				if (class50_sub3 != null) {
					for (int l = 0; l < class50_sub3.sceneSpawnRequestCount; l++) {
						if (class50_sub3.sceneSpawnRequests[l] != sceneSpawnRequest)
							continue;
						class50_sub3.sceneSpawnRequestCount--;
						for (int i1 = l; i1 < class50_sub3.sceneSpawnRequestCount; i1++) {
							class50_sub3.sceneSpawnRequests[i1] = class50_sub3.sceneSpawnRequests[i1 + 1];
							class50_sub3.anIntArray1409[i1] = class50_sub3.anIntArray1409[i1 + 1];
						}

						class50_sub3.sceneSpawnRequests[class50_sub3.sceneSpawnRequestCount] = null;
						break;
					}

					class50_sub3.anInt1410 = 0;
					for (int j1 = 0; j1 < class50_sub3.sceneSpawnRequestCount; j1++)
						class50_sub3.anInt1410 |= class50_sub3.anIntArray1409[j1];

				}
			}

		}

	}

	public void method257(int i, int j, int k, int l) {
		SceneTile sceneTile = tiles[k][l][i];
		if (sceneTile == null)
			return;
		WallDecoration wallDecoration = sceneTile.wallDecoration;
		if (wallDecoration == null)
			return;
		int j1 = l * 128 + 64;
		int k1 = i * 128 + 64;
		wallDecoration.y = j1 + ((wallDecoration.y - j1) * j) / 16;
		wallDecoration.x = k1 + ((wallDecoration.x - k1) * j) / 16;

	}

	public void method258(int i, int j, int k, boolean flag) {
		SceneTile class50_sub3 = tiles[j][k][i];
		if (class50_sub3 == null)
			return;
		class50_sub3.wall = null;
	}

	public void method259(boolean flag, int i, int j, int k) {
		SceneTile class50_sub3 = tiles[k][i][j];
		if (flag)
			return;
		if (class50_sub3 == null) {
			return;
		} else {
			class50_sub3.wallDecoration = null;
			return;
		}
	}

	public void method260(int i, int j, int k, int l) {
		if (k >= 0)
			return;
		SceneTile class50_sub3 = tiles[j][l][i];
		if (class50_sub3 == null)
			return;
		for (int i1 = 0; i1 < class50_sub3.sceneSpawnRequestCount; i1++) {
			SceneSpawnRequest sceneSpawnRequest = class50_sub3.sceneSpawnRequests[i1];
			if ((sceneSpawnRequest.anInt125 >> 29 & 3) == 2 && sceneSpawnRequest.x == l && sceneSpawnRequest.y == i) {
				method256(sceneSpawnRequest);
				return;
			}
		}

	}

	public void method261(int i, int j, boolean flag, int k) {
		SceneTile class50_sub3 = tiles[k][i][j];
		if (class50_sub3 == null)
			return;
		class50_sub3.floorDecoration = null;
		if (!flag) {
			for (int l = 1; l > 0; l++);
		}
	}

	public void clearGroundItem(int i, int j, int k) {
		SceneTile class50_sub3 = tiles[i][j][k];
		if (class50_sub3 == null) {
			return;
		} else {
			class50_sub3.cameraAngle = null;
			return;
		}
	}

	public Wall method263(int i, int j, int k, int l) {
		SceneTile class50_sub3 = tiles[i][k][l];
		if (j != 17734)
			throw new NullPointerException();
		if (class50_sub3 == null)
			return null;
		else
			return class50_sub3.wall;
	}

	public WallDecoration method264(int i, int j, int k, boolean flag) {
		SceneTile class50_sub3 = tiles[i][k][j];
		if (flag)
			throw new NullPointerException();
		if (class50_sub3 == null)
			return null;
		else
			return class50_sub3.wallDecoration;
	}

	public SceneSpawnRequest method265(int i, byte byte0, int j, int k) {
		if (byte0 != 32) {
			for (int l = 1; l > 0; l++);
		}
		SceneTile class50_sub3 = tiles[k][i][j];
		if (class50_sub3 == null)
			return null;
		for (int i1 = 0; i1 < class50_sub3.sceneSpawnRequestCount; i1++) {
			SceneSpawnRequest sceneSpawnRequest = class50_sub3.sceneSpawnRequests[i1];
			if ((sceneSpawnRequest.anInt125 >> 29 & 3) == 2 && sceneSpawnRequest.x == i && sceneSpawnRequest.y == j)
				return sceneSpawnRequest;
		}

		return null;
	}

	public FloorDecoration method266(int i, int j, int k, int l) {
		if (k != 0)
			throw new NullPointerException();
		SceneTile class50_sub3 = tiles[i][l][j];
		if (class50_sub3 == null || class50_sub3.floorDecoration == null)
			return null;
		else
			return class50_sub3.floorDecoration;
	}

	public int method267(int i, int j, int k) {
		SceneTile class50_sub3 = tiles[i][j][k];
		if (class50_sub3 == null || class50_sub3.wall == null)
			return 0;
		else
			return class50_sub3.wall.hash;
	}

	public int method268(int i, byte byte0, int j, int k) {
		SceneTile class50_sub3 = tiles[j][i][k];
		if (class50_sub3 == null || class50_sub3.wallDecoration == null)
			return 0;
		else
			return class50_sub3.wallDecoration.hash;
	}

	public int method269(int i, int j, int k) {
		SceneTile class50_sub3 = tiles[i][j][k];
		if (class50_sub3 == null)
			return 0;
		for (int l = 0; l < class50_sub3.sceneSpawnRequestCount; l++) {
			SceneSpawnRequest sceneSpawnRequest = class50_sub3.sceneSpawnRequests[l];
			if ((sceneSpawnRequest.anInt125 >> 29 & 3) == 2 && sceneSpawnRequest.x == j && sceneSpawnRequest.y == k)
				return sceneSpawnRequest.anInt125;
		}

		return 0;
	}

	public int getFloorDecorationHash(int i, int j, int k) {
		SceneTile class50_sub3 = tiles[i][j][k];
		if (class50_sub3 == null || class50_sub3.floorDecoration == null)
			return 0;
		else
			return class50_sub3.floorDecoration.hash;
	}

	public int method271(int i, int j, int k, int l) {
		SceneTile class50_sub3 = tiles[i][j][k];
		if (class50_sub3 == null)
			return -1;
		if (class50_sub3.wall != null && class50_sub3.wall.hash == l)
			return class50_sub3.wall.config & 0xff;
		if (class50_sub3.wallDecoration != null && class50_sub3.wallDecoration.hash == l)
			return class50_sub3.wallDecoration.config & 0xff;
		if (class50_sub3.floorDecoration != null && class50_sub3.floorDecoration.hash == l)
			return class50_sub3.floorDecoration.config & 0xff;
		for (int i1 = 0; i1 < class50_sub3.sceneSpawnRequestCount; i1++)
			if (class50_sub3.sceneSpawnRequests[i1].anInt125 == l)
				return class50_sub3.sceneSpawnRequests[i1].config & 0xff;

		return -1;
	}

	public void method272(byte byte0, int i, int j, int k) {
		for (int l = 0; l < anInt452; l++) {
			for (int i1 = 0; i1 < anInt453; i1++) {
				for (int j1 = 0; j1 < anInt454; j1++) {
					SceneTile class50_sub3 = tiles[l][i1][j1];
					if (class50_sub3 != null) {
						Wall wall = class50_sub3.wall;
						if (wall != null && wall.aRenderable769 != null
								&& wall.aRenderable769.verticesNormal != null) {
							method274(j1, l, 0, 1, (Model) wall.aRenderable769, i1, 1);
							if (wall.aRenderable770 != null
									&& wall.aRenderable770.verticesNormal != null) {
								method274(j1, l, 0, 1, (Model) wall.aRenderable770, i1, 1);
								method275((Model) wall.aRenderable769,
										(Model) wall.aRenderable770, 0, 0, 0, false);
								((Model) wall.aRenderable770).method595(i, j, 0, k);
							}
							((Model) wall.aRenderable769).method595(i, j, 0, k);
						}
						for (int k1 = 0; k1 < class50_sub3.sceneSpawnRequestCount; k1++) {
							SceneSpawnRequest sceneSpawnRequest = class50_sub3.sceneSpawnRequests[k1];
							if (sceneSpawnRequest != null && sceneSpawnRequest.aRenderable601 != null
									&& sceneSpawnRequest.aRenderable601.verticesNormal != null) {
								method274(j1, l, 0, (sceneSpawnRequest.anInt120 - sceneSpawnRequest.x) + 1,
										(Model) sceneSpawnRequest.aRenderable601, i1,
										(sceneSpawnRequest.anInt122 - sceneSpawnRequest.y) + 1);
								((Model) sceneSpawnRequest.aRenderable601).method595(i, j, 0, k);
							}
						}

						FloorDecoration floorDecoration = class50_sub3.floorDecoration;
						if (floorDecoration != null && floorDecoration.renderable.verticesNormal != null) {
							method273(i1, (Model) floorDecoration.renderable, j1, l, 0);
							((Model) floorDecoration.renderable).method595(i, j, 0, k);
						}
					}
				}

			}

		}

		if (byte0 == 2)
			byte0 = 0;
	}

	public void method273(int i, Model class50_sub1_sub4_sub4, int j, int k, int l) {
		if (l != 0)
			return;
		if (i < anInt453) {
			SceneTile class50_sub3 = tiles[k][i + 1][j];
			if (class50_sub3 != null && class50_sub3.floorDecoration != null
					&& class50_sub3.floorDecoration.renderable.verticesNormal != null)
				method275(class50_sub1_sub4_sub4,
						(Model) class50_sub3.floorDecoration.renderable, 128, 0, 0, true);
		}
		if (j < anInt453) {
			SceneTile class50_sub3_1 = tiles[k][i][j + 1];
			if (class50_sub3_1 != null && class50_sub3_1.floorDecoration != null
					&& class50_sub3_1.floorDecoration.renderable.verticesNormal != null)
				method275(class50_sub1_sub4_sub4,
						(Model) class50_sub3_1.floorDecoration.renderable, 0, 0, 128, true);
		}
		if (i < anInt453 && j < anInt454) {
			SceneTile class50_sub3_2 = tiles[k][i + 1][j + 1];
			if (class50_sub3_2 != null && class50_sub3_2.floorDecoration != null
					&& class50_sub3_2.floorDecoration.renderable.verticesNormal != null)
				method275(class50_sub1_sub4_sub4,
						(Model) class50_sub3_2.floorDecoration.renderable, 128, 0, 128, true);
		}
		if (i < anInt453 && j > 0) {
			SceneTile class50_sub3_3 = tiles[k][i + 1][j - 1];
			if (class50_sub3_3 != null && class50_sub3_3.floorDecoration != null
					&& class50_sub3_3.floorDecoration.renderable.verticesNormal != null)
				method275(class50_sub1_sub4_sub4,
						(Model) class50_sub3_3.floorDecoration.renderable, 128, 0, -128,
						true);
		}
	}

	public void method274(int i, int j, int k, int l, Model class50_sub1_sub4_sub4, int i1, int j1) {
		boolean flag = true;
		int k1 = i1;
		int l1 = i1 + l;
		int i2 = i - 1;
		int j2 = i + j1;
		for (int k2 = j; k2 <= j + 1; k2++)
			if (k2 != anInt452) {
				for (int l2 = k1; l2 <= l1; l2++)
					if (l2 >= 0 && l2 < anInt453) {
						for (int i3 = i2; i3 <= j2; i3++)
							if (i3 >= 0 && i3 < anInt454 && (!flag || l2 >= l1 || i3 >= j2 || i3 < i && l2 != i1)) {
								SceneTile class50_sub3 = tiles[k2][l2][i3];
								if (class50_sub3 != null) {
									int j3 = (anIntArrayArrayArray455[k2][l2][i3]
											+ anIntArrayArrayArray455[k2][l2 + 1][i3]
											+ anIntArrayArrayArray455[k2][l2][i3 + 1] + anIntArrayArrayArray455[k2][l2 + 1][i3 + 1])
											/ 4
											- (anIntArrayArrayArray455[j][i1][i]
													+ anIntArrayArrayArray455[j][i1 + 1][i]
													+ anIntArrayArrayArray455[j][i1][i + 1] + anIntArrayArrayArray455[j][i1 + 1][i + 1])
											/ 4;
									Wall wall = class50_sub3.wall;
									if (wall != null && wall.aRenderable769 != null
											&& wall.aRenderable769.verticesNormal != null)
										method275(class50_sub1_sub4_sub4,
												(Model) wall.aRenderable769, (l2 - i1)
														* 128 + (1 - l) * 64, j3, (i3 - i) * 128 + (1 - j1) * 64, flag);
									if (wall != null && wall.aRenderable770 != null
											&& wall.aRenderable770.verticesNormal != null)
										method275(class50_sub1_sub4_sub4,
												(Model) wall.aRenderable770, (l2 - i1)
														* 128 + (1 - l) * 64, j3, (i3 - i) * 128 + (1 - j1) * 64, flag);
									for (int k3 = 0; k3 < class50_sub3.sceneSpawnRequestCount; k3++) {
										SceneSpawnRequest sceneSpawnRequest = class50_sub3.sceneSpawnRequests[k3];
										if (sceneSpawnRequest != null && sceneSpawnRequest.aRenderable601 != null
												&& sceneSpawnRequest.aRenderable601.verticesNormal != null) {
											int l3 = (sceneSpawnRequest.anInt120 - sceneSpawnRequest.x) + 1;
											int i4 = (sceneSpawnRequest.anInt122 - sceneSpawnRequest.y) + 1;
											method275(class50_sub1_sub4_sub4,
													(Model) sceneSpawnRequest.aRenderable601,
													(sceneSpawnRequest.x - i1) * 128 + (l3 - l) * 64, j3,
													(sceneSpawnRequest.y - i) * 128 + (i4 - j1) * 64, flag);
										}
									}

								}
							}

					}

				k1--;
				flag = false;
			}

		if (k == 0)
			;
	}

	public void method275(Model class50_sub1_sub4_sub4,
			Model class50_sub1_sub4_sub4_1, int i, int j, int k, boolean flag) {
		anInt503++;
		int l = 0;
		int ai[] = class50_sub1_sub4_sub4_1.verticesX;
		int i1 = class50_sub1_sub4_sub4_1.vertexCount;
		int j1 = class50_sub1_sub4_sub4_1.anInt1669 >> 16;
		int k1 = (class50_sub1_sub4_sub4_1.anInt1669 << 16) >> 16;
		int l1 = class50_sub1_sub4_sub4_1.anInt1670 >> 16;
		int i2 = (class50_sub1_sub4_sub4_1.anInt1670 << 16) >> 16;
		for (int j2 = 0; j2 < class50_sub1_sub4_sub4.vertexCount; j2++) {
			VertexNormal class40 = ((Renderable) (class50_sub1_sub4_sub4)).verticesNormal[j2];
			VertexNormal class40_1 = class50_sub1_sub4_sub4.aClass40Array1681[j2];
			if (class40_1.magnitude != 0) {
				int i3 = class50_sub1_sub4_sub4.verticesY[j2] - j;
				if (i3 <= class50_sub1_sub4_sub4_1.maxY) {
					int j3 = class50_sub1_sub4_sub4.verticesX[j2] - i;
					if (j3 >= j1 && j3 <= k1) {
						int k3 = class50_sub1_sub4_sub4.verticesZ[j2] - k;
						if (k3 >= i2 && k3 <= l1) {
							for (int l3 = 0; l3 < i1; l3++) {
								VertexNormal class40_2 = ((Renderable) (class50_sub1_sub4_sub4_1)).verticesNormal[l3];
								VertexNormal class40_3 = class50_sub1_sub4_sub4_1.aClass40Array1681[l3];
								if (j3 == ai[l3] && k3 == class50_sub1_sub4_sub4_1.verticesZ[l3]
										&& i3 == class50_sub1_sub4_sub4_1.verticesY[l3] && class40_3.magnitude != 0) {
									class40.x += class40_3.x;
									class40.y += class40_3.y;
									class40.z += class40_3.z;
									class40.magnitude += class40_3.magnitude;
									class40_2.x += class40_1.x;
									class40_2.y += class40_1.y;
									class40_2.z += class40_1.z;
									class40_2.magnitude += class40_1.magnitude;
									l++;
									anIntArray501[j2] = anInt503;
									anIntArray502[l3] = anInt503;
								}
							}

						}
					}
				}
			}
		}

		if (l < 3 || !flag)
			return;
		for (int k2 = 0; k2 < class50_sub1_sub4_sub4.triangleCount; k2++)
			if (anIntArray501[class50_sub1_sub4_sub4.trianglePointsX[k2]] == anInt503
					&& anIntArray501[class50_sub1_sub4_sub4.trianglePointsY[k2]] == anInt503
					&& anIntArray501[class50_sub1_sub4_sub4.trianglePointsZ[k2]] == anInt503)
				class50_sub1_sub4_sub4.texturePoints[k2] = -1;

		for (int l2 = 0; l2 < class50_sub1_sub4_sub4_1.triangleCount; l2++)
			if (anIntArray502[class50_sub1_sub4_sub4_1.trianglePointsX[l2]] == anInt503
					&& anIntArray502[class50_sub1_sub4_sub4_1.trianglePointsY[l2]] == anInt503
					&& anIntArray502[class50_sub1_sub4_sub4_1.trianglePointsZ[l2]] == anInt503)
				class50_sub1_sub4_sub4_1.texturePoints[l2] = -1;

	}

	public void renderMinimapDot(int ai[], int i, int j, int k, int l, int i1) {
		SceneTile class50_sub3 = tiles[k][l][i1];
		if (class50_sub3 == null)
			return;
		GenericTile genericTile = class50_sub3.genericTile;
		if (genericTile != null) {
			int j1 = genericTile.rgbColor;
			if (j1 == 0)
				return;
			for (int k1 = 0; k1 < 4; k1++) {
				ai[i] = j1;
				ai[i + 1] = j1;
				ai[i + 2] = j1;
				ai[i + 3] = j1;
				i += j;
			}

			return;
		}
		ComplexTile complexTile = class50_sub3.complexTile;
		if (complexTile == null)
			return;
		int l1 = complexTile.anInt414;
		int i2 = complexTile.anInt415;
		int j2 = complexTile.anInt416;
		int k2 = complexTile.anInt417;
		int ai1[] = anIntArrayArray504[l1];
		int ai2[] = anIntArrayArray505[i2];
		int l2 = 0;
		if (j2 != 0) {
			for (int i3 = 0; i3 < 4; i3++) {
				ai[i] = ai1[ai2[l2++]] != 0 ? k2 : j2;
				ai[i + 1] = ai1[ai2[l2++]] != 0 ? k2 : j2;
				ai[i + 2] = ai1[ai2[l2++]] != 0 ? k2 : j2;
				ai[i + 3] = ai1[ai2[l2++]] != 0 ? k2 : j2;
				i += j;
			}

			return;
		}
		for (int j3 = 0; j3 < 4; j3++) {
			if (ai1[ai2[l2++]] != 0)
				ai[i] = k2;
			if (ai1[ai2[l2++]] != 0)
				ai[i + 1] = k2;
			if (ai1[ai2[l2++]] != 0)
				ai[i + 2] = k2;
			if (ai1[ai2[l2++]] != 0)
				ai[i + 3] = k2;
			i += j;
		}

	}

	public static void method277(int l, int k, int i1, int i, int[] ai) {
		anInt510 = 0;
		anInt511 = 0;
		anInt512 = i1;
		anInt513 = i;
		anInt508 = i1 / 2;
		anInt509 = i / 2;
		boolean aflag[][][][] = new boolean[9][32][53][53];
		for (int j1 = 128; j1 <= 384; j1 += 32) {
			for (int k1 = 0; k1 < 2048; k1 += 64) {
				anInt473 = Model.SINE[j1];
				anInt474 = Model.COSINE[j1];
				anInt475 = Model.SINE[k1];
				anInt476 = Model.COSINE[k1];
				int i2 = (j1 - 128) / 32;
				int k2 = k1 / 64;
				for (int i3 = -26; i3 <= 26; i3++) {
					for (int k3 = -26; k3 <= 26; k3++) {
						int l3 = i3 * 128;
						int j4 = k3 * 128;
						boolean flag1 = false;
						for (int l4 = -l; l4 <= k; l4 += 128) {
							if (!method278(j4, l3, anInt444, ai[i2] + l4))
								continue;
							flag1 = true;
							break;
						}

						aflag[i2][k2][i3 + 25 + 1][k3 + 25 + 1] = flag1;
					}

				}

			}

		}

		for (int l1 = 0; l1 < 8; l1++) {
			for (int j2 = 0; j2 < 32; j2++) {
				for (int l2 = -25; l2 < 25; l2++) {
					for (int j3 = -25; j3 < 25; j3++) {
						boolean flag = false;
						label0: for (int i4 = -1; i4 <= 1; i4++) {
							for (int k4 = -1; k4 <= 1; k4++) {
								if (aflag[l1][j2][l2 + i4 + 25 + 1][j3 + k4 + 25 + 1])
									flag = true;
								else if (aflag[l1][(j2 + 1) % 31][l2 + i4 + 25 + 1][j3 + k4 + 25 + 1])
									flag = true;
								else if (aflag[l1 + 1][j2][l2 + i4 + 25 + 1][j3 + k4 + 25 + 1]) {
									flag = true;
								} else {
									if (!aflag[l1 + 1][(j2 + 1) % 31][l2 + i4 + 25 + 1][j3 + k4 + 25 + 1])
										continue;
									flag = true;
								}
								break label0;
							}

						}

						aBooleanArrayArrayArrayArray506[l1][j2][l2 + 25][j3 + 25] = flag;
					}

				}

			}

		}
	}

	public static boolean method278(int i, int j, int k, int l) {
		int i1 = i * anInt475 + j * anInt476 >> 16;
		int j1 = i * anInt476 - j * anInt475 >> 16;
		int k1 = l * anInt473 + j1 * anInt474 >> 16;
		int l1 = l * anInt474 - j1 * anInt473 >> 16;
		if (k1 < 50 || k1 > 3500)
			return false;
		int i2 = anInt508 + (i1 << 9) / k1;
		int j2 = anInt509 + (l1 << 9) / k1;
		return i2 >= anInt510 && i2 <= anInt512 && j2 >= anInt511 && j2 <= anInt513;
	}

	public void method279(int i, int j, int k) {
		aBoolean482 = true;
		anInt483 = j;
		anInt484 = k;
		clickedTileX = -1;
		if (i != 0) {
			return;
		} else {
			anInt486 = -1;
			return;
		}
	}

	public void method280(int i, int j, int k, int l, int i1, int j1, int k1) {
		if (i < 0)
			i = 0;
		else if (i >= anInt453 * 128)
			i = anInt453 * 128 - 1;
		if (i1 < 0)
			i1 = 0;
		else if (i1 >= anInt454 * 128)
			i1 = anInt454 * 128 - 1;
		anInt463++;
		anInt473 = Model.SINE[k1];
		anInt474 = Model.COSINE[k1];
		anInt475 = Model.SINE[j1];
		anInt476 = Model.COSINE[j1];
		aBooleanArrayArray507 = aBooleanArrayArrayArrayArray506[(k1 - 128) / 32][j1 / 64];
		anInt470 = i;
		anInt471 = l;
		anInt472 = i1;
		anInt468 = i / 128;
		anInt469 = i1 / 128;
		anInt462 = j;
		anInt464 = anInt468 - 25;
		if (k != 0)
			return;
		if (anInt464 < 0)
			anInt464 = 0;
		anInt466 = anInt469 - 25;
		if (anInt466 < 0)
			anInt466 = 0;
		anInt465 = anInt468 + 25;
		if (anInt465 > anInt453)
			anInt465 = anInt453;
		anInt467 = anInt469 + 25;
		if (anInt467 > anInt454)
			anInt467 = anInt454;
		method286();
		anInt461 = 0;
		for (int l1 = anInt457; l1 < anInt452; l1++) {
			SceneTile aclass50_sub3[][] = tiles[l1];
			for (int j2 = anInt464; j2 < anInt465; j2++) {
				for (int l2 = anInt466; l2 < anInt467; l2++) {
					SceneTile class50_sub3 = aclass50_sub3[j2][l2];
					if (class50_sub3 != null)
						if (class50_sub3.anInt1411 > j
								|| !aBooleanArrayArray507[(j2 - anInt468) + 25][(l2 - anInt469) + 25]
								&& anIntArrayArrayArray455[l1][j2][l2] - l < 2000) {
							class50_sub3.aBoolean1412 = false;
							class50_sub3.aBoolean1413 = false;
							class50_sub3.anInt1415 = 0;
						} else {
							class50_sub3.aBoolean1412 = true;
							class50_sub3.aBoolean1413 = true;
							if (class50_sub3.sceneSpawnRequestCount > 0)
								class50_sub3.aBoolean1414 = true;
							else
								class50_sub3.aBoolean1414 = false;
							anInt461++;
						}
				}

			}

		}

		for (int i2 = anInt457; i2 < anInt452; i2++) {
			SceneTile aclass50_sub3_1[][] = tiles[i2];
			for (int i3 = -25; i3 <= 0; i3++) {
				int j3 = anInt468 + i3;
				int l3 = anInt468 - i3;
				if (j3 >= anInt464 || l3 < anInt465) {
					for (int j4 = -25; j4 <= 0; j4++) {
						int l4 = anInt469 + j4;
						int j5 = anInt469 - j4;
						if (j3 >= anInt464) {
							if (l4 >= anInt466) {
								SceneTile class50_sub3_1 = aclass50_sub3_1[j3][l4];
								if (class50_sub3_1 != null && class50_sub3_1.aBoolean1412)
									method281(class50_sub3_1, true);
							}
							if (j5 < anInt467) {
								SceneTile class50_sub3_2 = aclass50_sub3_1[j3][j5];
								if (class50_sub3_2 != null && class50_sub3_2.aBoolean1412)
									method281(class50_sub3_2, true);
							}
						}
						if (l3 < anInt465) {
							if (l4 >= anInt466) {
								SceneTile class50_sub3_3 = aclass50_sub3_1[l3][l4];
								if (class50_sub3_3 != null && class50_sub3_3.aBoolean1412)
									method281(class50_sub3_3, true);
							}
							if (j5 < anInt467) {
								SceneTile class50_sub3_4 = aclass50_sub3_1[l3][j5];
								if (class50_sub3_4 != null && class50_sub3_4.aBoolean1412)
									method281(class50_sub3_4, true);
							}
						}
						if (anInt461 == 0) {
							aBoolean482 = false;
							return;
						}
					}

				}
			}

		}

		for (int k2 = anInt457; k2 < anInt452; k2++) {
			SceneTile aclass50_sub3_2[][] = tiles[k2];
			for (int k3 = -25; k3 <= 0; k3++) {
				int i4 = anInt468 + k3;
				int k4 = anInt468 - k3;
				if (i4 >= anInt464 || k4 < anInt465) {
					for (int i5 = -25; i5 <= 0; i5++) {
						int k5 = anInt469 + i5;
						int l5 = anInt469 - i5;
						if (i4 >= anInt464) {
							if (k5 >= anInt466) {
								SceneTile class50_sub3_5 = aclass50_sub3_2[i4][k5];
								if (class50_sub3_5 != null && class50_sub3_5.aBoolean1412)
									method281(class50_sub3_5, false);
							}
							if (l5 < anInt467) {
								SceneTile class50_sub3_6 = aclass50_sub3_2[i4][l5];
								if (class50_sub3_6 != null && class50_sub3_6.aBoolean1412)
									method281(class50_sub3_6, false);
							}
						}
						if (k4 < anInt465) {
							if (k5 >= anInt466) {
								SceneTile class50_sub3_7 = aclass50_sub3_2[k4][k5];
								if (class50_sub3_7 != null && class50_sub3_7.aBoolean1412)
									method281(class50_sub3_7, false);
							}
							if (l5 < anInt467) {
								SceneTile class50_sub3_8 = aclass50_sub3_2[k4][l5];
								if (class50_sub3_8 != null && class50_sub3_8.aBoolean1412)
									method281(class50_sub3_8, false);
							}
						}
						if (anInt461 == 0) {
							aBoolean482 = false;
							return;
						}
					}

				}
			}

		}

		aBoolean482 = false;
	}

	public void method281(SceneTile class50_sub3, boolean flag) {
		aClass6_492.insertBack(class50_sub3);
		do {
			SceneTile class50_sub3_1;
			do {
				class50_sub3_1 = (SceneTile) aClass6_492.removeFirst();
				if (class50_sub3_1 == null)
					return;
			} while (!class50_sub3_1.aBoolean1413);
			int i = class50_sub3_1.anInt1398;
			int j = class50_sub3_1.anInt1399;
			int k = class50_sub3_1.anInt1397;
			int l = class50_sub3_1.anInt1400;
			SceneTile aclass50_sub3[][] = tiles[k];
			if (class50_sub3_1.aBoolean1412) {
				if (flag) {
					if (k > 0) {
						SceneTile class50_sub3_2 = tiles[k - 1][i][j];
						if (class50_sub3_2 != null && class50_sub3_2.aBoolean1413)
							continue;
					}
					if (i <= anInt468 && i > anInt464) {
						SceneTile class50_sub3_3 = aclass50_sub3[i - 1][j];
						if (class50_sub3_3 != null && class50_sub3_3.aBoolean1413
								&& (class50_sub3_3.aBoolean1412 || (class50_sub3_1.anInt1410 & 1) == 0))
							continue;
					}
					if (i >= anInt468 && i < anInt465 - 1) {
						SceneTile class50_sub3_4 = aclass50_sub3[i + 1][j];
						if (class50_sub3_4 != null && class50_sub3_4.aBoolean1413
								&& (class50_sub3_4.aBoolean1412 || (class50_sub3_1.anInt1410 & 4) == 0))
							continue;
					}
					if (j <= anInt469 && j > anInt466) {
						SceneTile class50_sub3_5 = aclass50_sub3[i][j - 1];
						if (class50_sub3_5 != null && class50_sub3_5.aBoolean1413
								&& (class50_sub3_5.aBoolean1412 || (class50_sub3_1.anInt1410 & 8) == 0))
							continue;
					}
					if (j >= anInt469 && j < anInt467 - 1) {
						SceneTile class50_sub3_6 = aclass50_sub3[i][j + 1];
						if (class50_sub3_6 != null && class50_sub3_6.aBoolean1413
								&& (class50_sub3_6.aBoolean1412 || (class50_sub3_1.anInt1410 & 2) == 0))
							continue;
					}
				} else {
					flag = true;
				}
				class50_sub3_1.aBoolean1412 = false;
				if (class50_sub3_1.aClass50_Sub3_1419 != null) {
					SceneTile class50_sub3_7 = class50_sub3_1.aClass50_Sub3_1419;
					if (class50_sub3_7.genericTile != null) {
						if (!method287(0, i, j))
							method282(class50_sub3_7.genericTile, 0, anInt473, anInt474, anInt475, anInt476, i, j);
					} else if (class50_sub3_7.complexTile != null && !method287(0, i, j))
						method283(anInt474, anInt476, class50_sub3_7.complexTile, anInt473, j, i, anInt475, (byte) 3);
					Wall wall = class50_sub3_7.wall;
					if (wall != null)
						wall.aRenderable769.renderAtPoint(0, anInt473, anInt474, anInt475, anInt476,
								wall.x - anInt470, wall.plane - anInt471, wall.y - anInt472,
								wall.hash);
					for (int i2 = 0; i2 < class50_sub3_7.sceneSpawnRequestCount; i2++) {
						SceneSpawnRequest sceneSpawnRequest = class50_sub3_7.sceneSpawnRequests[i2];
						if (sceneSpawnRequest != null)
							sceneSpawnRequest.aRenderable601.renderAtPoint(sceneSpawnRequest.anInt118, anInt473, anInt474, anInt475,
									anInt476, sceneSpawnRequest.anInt115 - anInt470, sceneSpawnRequest.anInt114 - anInt471, sceneSpawnRequest.anInt116
											- anInt472, sceneSpawnRequest.anInt125);
					}

				}
				boolean flag1 = false;
				if (class50_sub3_1.genericTile != null) {
					if (!method287(l, i, j)) {
						flag1 = true;
						method282(class50_sub3_1.genericTile, l, anInt473, anInt474, anInt475, anInt476, i, j);
					}
				} else if (class50_sub3_1.complexTile != null && !method287(l, i, j)) {
					flag1 = true;
					method283(anInt474, anInt476, class50_sub3_1.complexTile, anInt473, j, i, anInt475, (byte) 3);
				}
				int j1 = 0;
				int j2 = 0;
				Wall wall_3 = class50_sub3_1.wall;
				WallDecoration wallDecoration_1 = class50_sub3_1.wallDecoration;
				if (wall_3 != null || wallDecoration_1 != null) {
					if (anInt468 == i)
						j1++;
					else if (anInt468 < i)
						j1 += 2;
					if (anInt469 == j)
						j1 += 3;
					else if (anInt469 > j)
						j1 += 6;
					j2 = anIntArray493[j1];
					class50_sub3_1.anInt1418 = anIntArray495[j1];
				}
				if (wall_3 != null) {
					if ((wall_3.faceUnknown & anIntArray494[j1]) != 0) {
						if (wall_3.faceUnknown == 16) {
							class50_sub3_1.anInt1415 = 3;
							class50_sub3_1.anInt1416 = anIntArray496[j1];
							class50_sub3_1.anInt1417 = 3 - class50_sub3_1.anInt1416;
						} else if (wall_3.faceUnknown == 32) {
							class50_sub3_1.anInt1415 = 6;
							class50_sub3_1.anInt1416 = anIntArray497[j1];
							class50_sub3_1.anInt1417 = 6 - class50_sub3_1.anInt1416;
						} else if (wall_3.faceUnknown == 64) {
							class50_sub3_1.anInt1415 = 12;
							class50_sub3_1.anInt1416 = anIntArray498[j1];
							class50_sub3_1.anInt1417 = 12 - class50_sub3_1.anInt1416;
						} else {
							class50_sub3_1.anInt1415 = 9;
							class50_sub3_1.anInt1416 = anIntArray499[j1];
							class50_sub3_1.anInt1417 = 9 - class50_sub3_1.anInt1416;
						}
					} else {
						class50_sub3_1.anInt1415 = 0;
					}
					if ((wall_3.faceUnknown & j2) != 0 && !method288(l, i, j, wall_3.faceUnknown))
						wall_3.aRenderable769.renderAtPoint(0, anInt473, anInt474, anInt475, anInt476,
								wall_3.x - anInt470, wall_3.plane - anInt471, wall_3.y
										- anInt472, wall_3.hash);
					if ((wall_3.face & j2) != 0 && !method288(l, i, j, wall_3.face))
						wall_3.aRenderable770.renderAtPoint(0, anInt473, anInt474, anInt475, anInt476,
								wall_3.x - anInt470, wall_3.plane - anInt471, wall_3.y
										- anInt472, wall_3.hash);
				}
				if (wallDecoration_1 != null && !method289(l, i, j, wallDecoration_1.renderable.modelHeight))
					if ((wallDecoration_1.faceUnknown & j2) != 0)
						wallDecoration_1.renderable.renderAtPoint(wallDecoration_1.face, anInt473, anInt474, anInt475,
								anInt476, wallDecoration_1.y - anInt470, wallDecoration_1.plane - anInt471,
								wallDecoration_1.x - anInt472, wallDecoration_1.hash);
					else if ((wallDecoration_1.faceUnknown & 0x300) != 0) {
						int j4 = wallDecoration_1.y - anInt470;
						int l5 = wallDecoration_1.plane - anInt471;
						int k6 = wallDecoration_1.x - anInt472;
						int i8 = wallDecoration_1.face;
						int k9;
						if (i8 == 1 || i8 == 2)
							k9 = -j4;
						else
							k9 = j4;
						int k10;
						if (i8 == 2 || i8 == 3)
							k10 = -k6;
						else
							k10 = k6;
						if ((wallDecoration_1.faceUnknown & 0x100) != 0 && k10 < k9) {
							int i11 = j4 + anIntArray478[i8];
							int k11 = k6 + anIntArray479[i8];
							wallDecoration_1.renderable.renderAtPoint(i8 * 512 + 256, anInt473, anInt474, anInt475,
									anInt476, i11, l5, k11, wallDecoration_1.hash);
						}
						if ((wallDecoration_1.faceUnknown & 0x200) != 0 && k10 > k9) {
							int j11 = j4 + anIntArray480[i8];
							int l11 = k6 + anIntArray481[i8];
							wallDecoration_1.renderable.renderAtPoint(i8 * 512 + 1280 & 0x7ff, anInt473, anInt474,
									anInt475, anInt476, j11, l5, l11, wallDecoration_1.hash);
						}
					}
				if (flag1) {
					FloorDecoration floorDecoration = class50_sub3_1.floorDecoration;
					if (floorDecoration != null)
						floorDecoration.renderable.renderAtPoint(0, anInt473, anInt474, anInt475, anInt476,
								floorDecoration.y - anInt470, floorDecoration.x - anInt471, floorDecoration.z - anInt472,
								floorDecoration.hash);
					CameraAngle cameraAngle_1 = class50_sub3_1.cameraAngle;
					if (cameraAngle_1 != null && cameraAngle_1.anInt180 == 0) {
						if (cameraAngle_1.aRenderable151 != null)
							cameraAngle_1.aRenderable151.renderAtPoint(0, anInt473, anInt474, anInt475, anInt476,
									cameraAngle_1.y - anInt470, cameraAngle_1.x - anInt471, cameraAngle_1.z
											- anInt472, cameraAngle_1.anInt179);
						if (cameraAngle_1.aRenderable152 != null)
							cameraAngle_1.aRenderable152.renderAtPoint(0, anInt473, anInt474, anInt475, anInt476,
									cameraAngle_1.y - anInt470, cameraAngle_1.x - anInt471, cameraAngle_1.z
											- anInt472, cameraAngle_1.anInt179);
						if (cameraAngle_1.aRenderable150 != null)
							cameraAngle_1.aRenderable150.renderAtPoint(0, anInt473, anInt474, anInt475, anInt476,
									cameraAngle_1.y - anInt470, cameraAngle_1.x - anInt471, cameraAngle_1.z
											- anInt472, cameraAngle_1.anInt179);
					}
				}
				int k4 = class50_sub3_1.anInt1410;
				if (k4 != 0) {
					if (i < anInt468 && (k4 & 4) != 0) {
						SceneTile class50_sub3_17 = aclass50_sub3[i + 1][j];
						if (class50_sub3_17 != null && class50_sub3_17.aBoolean1413)
							aClass6_492.insertBack(class50_sub3_17);
					}
					if (j < anInt469 && (k4 & 2) != 0) {
						SceneTile class50_sub3_18 = aclass50_sub3[i][j + 1];
						if (class50_sub3_18 != null && class50_sub3_18.aBoolean1413)
							aClass6_492.insertBack(class50_sub3_18);
					}
					if (i > anInt468 && (k4 & 1) != 0) {
						SceneTile class50_sub3_19 = aclass50_sub3[i - 1][j];
						if (class50_sub3_19 != null && class50_sub3_19.aBoolean1413)
							aClass6_492.insertBack(class50_sub3_19);
					}
					if (j > anInt469 && (k4 & 8) != 0) {
						SceneTile class50_sub3_20 = aclass50_sub3[i][j - 1];
						if (class50_sub3_20 != null && class50_sub3_20.aBoolean1413)
							aClass6_492.insertBack(class50_sub3_20);
					}
				}
			}
			if (class50_sub3_1.anInt1415 != 0) {
				boolean flag2 = true;
				for (int k1 = 0; k1 < class50_sub3_1.sceneSpawnRequestCount; k1++) {
					if (class50_sub3_1.sceneSpawnRequests[k1].anInt124 == anInt463
							|| (class50_sub3_1.anIntArray1409[k1] & class50_sub3_1.anInt1415) != class50_sub3_1.anInt1416)
						continue;
					flag2 = false;
					break;
				}

				if (flag2) {
					Wall wall_1 = class50_sub3_1.wall;
					if (!method288(l, i, j, wall_1.faceUnknown))
						wall_1.aRenderable769.renderAtPoint(0, anInt473, anInt474, anInt475, anInt476,
								wall_1.x - anInt470, wall_1.plane - anInt471, wall_1.y
										- anInt472, wall_1.hash);
					class50_sub3_1.anInt1415 = 0;
				}
			}
			if (class50_sub3_1.aBoolean1414)
				try {
					int i1 = class50_sub3_1.sceneSpawnRequestCount;
					class50_sub3_1.aBoolean1414 = false;
					int l1 = 0;
					label0: for (int k2 = 0; k2 < i1; k2++) {
						SceneSpawnRequest sceneSpawnRequest_1 = class50_sub3_1.sceneSpawnRequests[k2];
						if (sceneSpawnRequest_1.anInt124 == anInt463)
							continue;
						for (int k3 = sceneSpawnRequest_1.x; k3 <= sceneSpawnRequest_1.anInt120; k3++) {
							for (int l4 = sceneSpawnRequest_1.y; l4 <= sceneSpawnRequest_1.anInt122; l4++) {
								SceneTile class50_sub3_21 = aclass50_sub3[k3][l4];
								if (class50_sub3_21.aBoolean1412) {
									class50_sub3_1.aBoolean1414 = true;
								} else {
									if (class50_sub3_21.anInt1415 == 0)
										continue;
									int l6 = 0;
									if (k3 > sceneSpawnRequest_1.x)
										l6++;
									if (k3 < sceneSpawnRequest_1.anInt120)
										l6 += 4;
									if (l4 > sceneSpawnRequest_1.y)
										l6 += 8;
									if (l4 < sceneSpawnRequest_1.anInt122)
										l6 += 2;
									if ((l6 & class50_sub3_21.anInt1415) != class50_sub3_1.anInt1417)
										continue;
									class50_sub3_1.aBoolean1414 = true;
								}
								continue label0;
							}

						}

						aSceneSpawnRequestArray477[l1++] = sceneSpawnRequest_1;
						int i5 = anInt468 - sceneSpawnRequest_1.x;
						int i6 = sceneSpawnRequest_1.anInt120 - anInt468;
						if (i6 > i5)
							i5 = i6;
						int i7 = anInt469 - sceneSpawnRequest_1.y;
						int j8 = sceneSpawnRequest_1.anInt122 - anInt469;
						if (j8 > i7)
							sceneSpawnRequest_1.anInt123 = i5 + j8;
						else
							sceneSpawnRequest_1.anInt123 = i5 + i7;
					}

					while (l1 > 0) {
						int i3 = -50;
						int l3 = -1;
						for (int j5 = 0; j5 < l1; j5++) {
							SceneSpawnRequest sceneSpawnRequest_2 = aSceneSpawnRequestArray477[j5];
							if (sceneSpawnRequest_2.anInt124 != anInt463)
								if (sceneSpawnRequest_2.anInt123 > i3) {
									i3 = sceneSpawnRequest_2.anInt123;
									l3 = j5;
								} else if (sceneSpawnRequest_2.anInt123 == i3) {
									int j7 = sceneSpawnRequest_2.anInt115 - anInt470;
									int k8 = sceneSpawnRequest_2.anInt116 - anInt472;
									int l9 = aSceneSpawnRequestArray477[l3].anInt115 - anInt470;
									int l10 = aSceneSpawnRequestArray477[l3].anInt116 - anInt472;
									if (j7 * j7 + k8 * k8 > l9 * l9 + l10 * l10)
										l3 = j5;
								}
						}

						if (l3 == -1)
							break;
						SceneSpawnRequest sceneSpawnRequest_3 = aSceneSpawnRequestArray477[l3];
						sceneSpawnRequest_3.anInt124 = anInt463;
						if (!method290(l, sceneSpawnRequest_3.x, sceneSpawnRequest_3.anInt120, sceneSpawnRequest_3.y, sceneSpawnRequest_3.anInt122,
								sceneSpawnRequest_3.aRenderable601.modelHeight))
							sceneSpawnRequest_3.aRenderable601.renderAtPoint(sceneSpawnRequest_3.anInt118, anInt473, anInt474, anInt475,
									anInt476, sceneSpawnRequest_3.anInt115 - anInt470, sceneSpawnRequest_3.anInt114 - anInt471,
									sceneSpawnRequest_3.anInt116 - anInt472, sceneSpawnRequest_3.anInt125);
						for (int k7 = sceneSpawnRequest_3.x; k7 <= sceneSpawnRequest_3.anInt120; k7++) {
							for (int l8 = sceneSpawnRequest_3.y; l8 <= sceneSpawnRequest_3.anInt122; l8++) {
								SceneTile class50_sub3_22 = aclass50_sub3[k7][l8];
								if (class50_sub3_22.anInt1415 != 0)
									aClass6_492.insertBack(class50_sub3_22);
								else if ((k7 != i || l8 != j) && class50_sub3_22.aBoolean1413)
									aClass6_492.insertBack(class50_sub3_22);
							}

						}

					}
					if (class50_sub3_1.aBoolean1414)
						continue;
				} catch (Exception _ex) {
					class50_sub3_1.aBoolean1414 = false;
				}
			if (!class50_sub3_1.aBoolean1413 || class50_sub3_1.anInt1415 != 0)
				continue;
			if (i <= anInt468 && i > anInt464) {
				SceneTile class50_sub3_8 = aclass50_sub3[i - 1][j];
				if (class50_sub3_8 != null && class50_sub3_8.aBoolean1413)
					continue;
			}
			if (i >= anInt468 && i < anInt465 - 1) {
				SceneTile class50_sub3_9 = aclass50_sub3[i + 1][j];
				if (class50_sub3_9 != null && class50_sub3_9.aBoolean1413)
					continue;
			}
			if (j <= anInt469 && j > anInt466) {
				SceneTile class50_sub3_10 = aclass50_sub3[i][j - 1];
				if (class50_sub3_10 != null && class50_sub3_10.aBoolean1413)
					continue;
			}
			if (j >= anInt469 && j < anInt467 - 1) {
				SceneTile class50_sub3_11 = aclass50_sub3[i][j + 1];
				if (class50_sub3_11 != null && class50_sub3_11.aBoolean1413)
					continue;
			}
			class50_sub3_1.aBoolean1413 = false;
			anInt461--;
			CameraAngle cameraAngle = class50_sub3_1.cameraAngle;
			if (cameraAngle != null && cameraAngle.anInt180 != 0) {
				if (cameraAngle.aRenderable151 != null)
					cameraAngle.aRenderable151.renderAtPoint(0, anInt473, anInt474, anInt475, anInt476,
							cameraAngle.y - anInt470, cameraAngle.x - anInt471 - cameraAngle.anInt180,
							cameraAngle.z - anInt472, cameraAngle.anInt179);
				if (cameraAngle.aRenderable152 != null)
					cameraAngle.aRenderable152.renderAtPoint(0, anInt473, anInt474, anInt475, anInt476,
							cameraAngle.y - anInt470, cameraAngle.x - anInt471 - cameraAngle.anInt180,
							cameraAngle.z - anInt472, cameraAngle.anInt179);
				if (cameraAngle.aRenderable150 != null)
					cameraAngle.aRenderable150.renderAtPoint(0, anInt473, anInt474, anInt475, anInt476,
							cameraAngle.y - anInt470, cameraAngle.x - anInt471 - cameraAngle.anInt180,
							cameraAngle.z - anInt472, cameraAngle.anInt179);
			}
			if (class50_sub3_1.anInt1418 != 0) {
				WallDecoration wallDecoration = class50_sub3_1.wallDecoration;
				if (wallDecoration != null && !method289(l, i, j, wallDecoration.renderable.modelHeight))
					if ((wallDecoration.faceUnknown & class50_sub3_1.anInt1418) != 0)
						wallDecoration.renderable.renderAtPoint(wallDecoration.face, anInt473, anInt474, anInt475,
								anInt476, wallDecoration.y - anInt470, wallDecoration.plane - anInt471, wallDecoration.x
										- anInt472, wallDecoration.hash);
					else if ((wallDecoration.faceUnknown & 0x300) != 0) {
						int l2 = wallDecoration.y - anInt470;
						int j3 = wallDecoration.plane - anInt471;
						int i4 = wallDecoration.x - anInt472;
						int k5 = wallDecoration.face;
						int j6;
						if (k5 == 1 || k5 == 2)
							j6 = -l2;
						else
							j6 = l2;
						int l7;
						if (k5 == 2 || k5 == 3)
							l7 = -i4;
						else
							l7 = i4;
						if ((wallDecoration.faceUnknown & 0x100) != 0 && l7 >= j6) {
							int i9 = l2 + anIntArray478[k5];
							int i10 = i4 + anIntArray479[k5];
							wallDecoration.renderable.renderAtPoint(k5 * 512 + 256, anInt473, anInt474, anInt475,
									anInt476, i9, j3, i10, wallDecoration.hash);
						}
						if ((wallDecoration.faceUnknown & 0x200) != 0 && l7 <= j6) {
							int j9 = l2 + anIntArray480[k5];
							int j10 = i4 + anIntArray481[k5];
							wallDecoration.renderable.renderAtPoint(k5 * 512 + 1280 & 0x7ff, anInt473, anInt474,
									anInt475, anInt476, j9, j3, j10, wallDecoration.hash);
						}
					}
				Wall wall_2 = class50_sub3_1.wall;
				if (wall_2 != null) {
					if ((wall_2.face & class50_sub3_1.anInt1418) != 0 && !method288(l, i, j, wall_2.face))
						wall_2.aRenderable770.renderAtPoint(0, anInt473, anInt474, anInt475, anInt476,
								wall_2.x - anInt470, wall_2.plane - anInt471, wall_2.y
										- anInt472, wall_2.hash);
					if ((wall_2.faceUnknown & class50_sub3_1.anInt1418) != 0 && !method288(l, i, j, wall_2.faceUnknown))
						wall_2.aRenderable769.renderAtPoint(0, anInt473, anInt474, anInt475, anInt476,
								wall_2.x - anInt470, wall_2.plane - anInt471, wall_2.y
										- anInt472, wall_2.hash);
				}
			}
			if (k < anInt452 - 1) {
				SceneTile class50_sub3_12 = tiles[k + 1][i][j];
				if (class50_sub3_12 != null && class50_sub3_12.aBoolean1413)
					aClass6_492.insertBack(class50_sub3_12);
			}
			if (i < anInt468) {
				SceneTile class50_sub3_13 = aclass50_sub3[i + 1][j];
				if (class50_sub3_13 != null && class50_sub3_13.aBoolean1413)
					aClass6_492.insertBack(class50_sub3_13);
			}
			if (j < anInt469) {
				SceneTile class50_sub3_14 = aclass50_sub3[i][j + 1];
				if (class50_sub3_14 != null && class50_sub3_14.aBoolean1413)
					aClass6_492.insertBack(class50_sub3_14);
			}
			if (i > anInt468) {
				SceneTile class50_sub3_15 = aclass50_sub3[i - 1][j];
				if (class50_sub3_15 != null && class50_sub3_15.aBoolean1413)
					aClass6_492.insertBack(class50_sub3_15);
			}
			if (j > anInt469) {
				SceneTile class50_sub3_16 = aclass50_sub3[i][j - 1];
				if (class50_sub3_16 != null && class50_sub3_16.aBoolean1413)
					aClass6_492.insertBack(class50_sub3_16);
			}
		} while (true);
	}

	public void method282(GenericTile genericTile, int i, int j, int k, int l, int i1, int j1, int k1) {
		int l1;
		int i2 = l1 = (j1 << 7) - anInt470;
		int j2;
		int k2 = j2 = (k1 << 7) - anInt472;
		int l2;
		int i3 = l2 = i2 + 128;
		int j3;
		int k3 = j3 = k2 + 128;
		int l3 = anIntArrayArrayArray455[i][j1][k1] - anInt471;
		int i4 = anIntArrayArrayArray455[i][j1 + 1][k1] - anInt471;
		int j4 = anIntArrayArrayArray455[i][j1 + 1][k1 + 1] - anInt471;
		int k4 = anIntArrayArrayArray455[i][j1][k1 + 1] - anInt471;
		int l4 = k2 * l + i2 * i1 >> 16;
		k2 = k2 * i1 - i2 * l >> 16;
		i2 = l4;
		l4 = l3 * k - k2 * j >> 16;
		k2 = l3 * j + k2 * k >> 16;
		l3 = l4;
		if (k2 < 50)
			return;
		l4 = j2 * l + i3 * i1 >> 16;
		j2 = j2 * i1 - i3 * l >> 16;
		i3 = l4;
		l4 = i4 * k - j2 * j >> 16;
		j2 = i4 * j + j2 * k >> 16;
		i4 = l4;
		if (j2 < 50)
			return;
		l4 = k3 * l + l2 * i1 >> 16;
		k3 = k3 * i1 - l2 * l >> 16;
		l2 = l4;
		l4 = j4 * k - k3 * j >> 16;
		k3 = j4 * j + k3 * k >> 16;
		j4 = l4;
		if (k3 < 50)
			return;
		l4 = j3 * l + l1 * i1 >> 16;
		j3 = j3 * i1 - l1 * l >> 16;
		l1 = l4;
		l4 = k4 * k - j3 * j >> 16;
		j3 = k4 * j + j3 * k >> 16;
		k4 = l4;
		if (j3 < 50)
			return;
		int i5 = Rasterizer3D.centerX + (i2 << 9) / k2;
		int j5 = Rasterizer3D.centerY + (l3 << 9) / k2;
		int k5 = Rasterizer3D.centerX + (i3 << 9) / j2;
		int l5 = Rasterizer3D.centerY + (i4 << 9) / j2;
		int i6 = Rasterizer3D.centerX + (l2 << 9) / k3;
		int j6 = Rasterizer3D.centerY + (j4 << 9) / k3;
		int k6 = Rasterizer3D.centerX + (l1 << 9) / j3;
		int l6 = Rasterizer3D.centerY + (k4 << 9) / j3;
		Rasterizer3D.anInt1531 = 0;
		if ((i6 - k6) * (l5 - l6) - (j6 - l6) * (k5 - k6) > 0) {
			Rasterizer3D.aBoolean1528 = false;
			if (i6 < 0 || k6 < 0 || k5 < 0 || i6 > Rasterizer.virtualBottomX || k6 > Rasterizer.virtualBottomX
					|| k5 > Rasterizer.virtualBottomX)
				Rasterizer3D.aBoolean1528 = true;
			if (aBoolean482 && method285(anInt483, anInt484, j6, l6, l5, i6, k6, k5)) {
				clickedTileX = j1;
				anInt486 = k1;
			}
			if (genericTile.texture == -1) {
				if (genericTile.anInt97 != 0xbc614e)
					Rasterizer3D.method503(j6, l6, l5, i6, k6, k5, genericTile.anInt97, genericTile.anInt98,
							genericTile.anInt96);
			} else if (!lowMemory) {
				if (genericTile.flat)
					Rasterizer3D.method507(j6, l6, l5, i6, k6, k5, genericTile.anInt97, genericTile.anInt98,
							genericTile.anInt96, i2, i3, l1, l3, i4, k4, k2, j2, j3, genericTile.texture);
				else
					Rasterizer3D.method507(j6, l6, l5, i6, k6, k5, genericTile.anInt97, genericTile.anInt98,
							genericTile.anInt96, l2, l1, i3, j4, k4, i4, k3, j3, j2, genericTile.texture);
			} else {
				int i7 = anIntArray500[genericTile.texture];
				Rasterizer3D.method503(j6, l6, l5, i6, k6, k5, method284(genericTile.anInt97, i7, 0), method284(
						genericTile.anInt98, i7, 0), method284(genericTile.anInt96, i7, 0));
			}
		}
		if ((i5 - k5) * (l6 - l5) - (j5 - l5) * (k6 - k5) > 0) {
			Rasterizer3D.aBoolean1528 = false;
			if (i5 < 0 || k5 < 0 || k6 < 0 || i5 > Rasterizer.virtualBottomX || k5 > Rasterizer.virtualBottomX
					|| k6 > Rasterizer.virtualBottomX)
				Rasterizer3D.aBoolean1528 = true;
			if (aBoolean482 && method285(anInt483, anInt484, j5, l5, l6, i5, k5, k6)) {
				clickedTileX = j1;
				anInt486 = k1;
			}
			if (genericTile.texture == -1) {
				if (genericTile.anInt95 != 0xbc614e) {
					Rasterizer3D.method503(j5, l5, l6, i5, k5, k6, genericTile.anInt95, genericTile.anInt96,
							genericTile.anInt98);
					return;
				}
			} else {
				if (!lowMemory) {
					Rasterizer3D.method507(j5, l5, l6, i5, k5, k6, genericTile.anInt95, genericTile.anInt96,
							genericTile.anInt98, i2, i3, l1, l3, i4, k4, k2, j2, j3, genericTile.texture);
					return;
				}
				int j7 = anIntArray500[genericTile.texture];
				Rasterizer3D.method503(j5, l5, l6, i5, k5, k6, method284(genericTile.anInt95, j7, 0), method284(
						genericTile.anInt96, j7, 0), method284(genericTile.anInt98, j7, 0));
			}
		}
	}

	public void method283(int i, int j, ComplexTile complexTile, int k, int l, int i1, int j1, byte byte0) {
		int k1 = complexTile.anIntArray403.length;
		for (int l1 = 0; l1 < k1; l1++) {
			int i2 = complexTile.anIntArray403[l1] - anInt470;
			int k2 = complexTile.anIntArray404[l1] - anInt471;
			int i3 = complexTile.anIntArray405[l1] - anInt472;
			int k3 = i3 * j1 + i2 * j >> 16;
			i3 = i3 * j - i2 * j1 >> 16;
			i2 = k3;
			k3 = k2 * i - i3 * k >> 16;
			i3 = k2 * k + i3 * i >> 16;
			k2 = k3;
			if (i3 < 50)
				return;
			if (complexTile.anIntArray412 != null) {
				ComplexTile.anIntArray420[l1] = i2;
				ComplexTile.anIntArray421[l1] = k2;
				ComplexTile.anIntArray422[l1] = i3;
			}
			ComplexTile.anIntArray418[l1] = Rasterizer3D.centerX + (i2 << 9) / i3;
			ComplexTile.anIntArray419[l1] = Rasterizer3D.centerY + (k2 << 9) / i3;
		}

		Rasterizer3D.anInt1531 = 0;
		k1 = complexTile.anIntArray409.length;
		if (byte0 != 3)
			return;
		for (int j2 = 0; j2 < k1; j2++) {
			int l2 = complexTile.anIntArray409[j2];
			int j3 = complexTile.anIntArray410[j2];
			int l3 = complexTile.anIntArray411[j2];
			int i4 = ComplexTile.anIntArray418[l2];
			int j4 = ComplexTile.anIntArray418[j3];
			int k4 = ComplexTile.anIntArray418[l3];
			int l4 = ComplexTile.anIntArray419[l2];
			int i5 = ComplexTile.anIntArray419[j3];
			int j5 = ComplexTile.anIntArray419[l3];
			if ((i4 - j4) * (j5 - i5) - (l4 - i5) * (k4 - j4) > 0) {
				Rasterizer3D.aBoolean1528 = false;
				if (i4 < 0 || j4 < 0 || k4 < 0 || i4 > Rasterizer.virtualBottomX || j4 > Rasterizer.virtualBottomX
						|| k4 > Rasterizer.virtualBottomX)
					Rasterizer3D.aBoolean1528 = true;
				if (aBoolean482 && method285(anInt483, anInt484, l4, i5, j5, i4, j4, k4)) {
					clickedTileX = i1;
					anInt486 = l;
				}
				if (complexTile.anIntArray412 == null || complexTile.anIntArray412[j2] == -1) {
					if (complexTile.anIntArray406[j2] != 0xbc614e)
						Rasterizer3D.method503(l4, i5, j5, i4, j4, k4, complexTile.anIntArray406[j2],
								complexTile.anIntArray407[j2], complexTile.anIntArray408[j2]);
				} else if (!lowMemory) {
					if (complexTile.aBoolean413)
						Rasterizer3D.method507(l4, i5, j5, i4, j4, k4, complexTile.anIntArray406[j2],
								complexTile.anIntArray407[j2], complexTile.anIntArray408[j2], ComplexTile.anIntArray420[0],
								ComplexTile.anIntArray420[1], ComplexTile.anIntArray420[3], ComplexTile.anIntArray421[0],
								ComplexTile.anIntArray421[1], ComplexTile.anIntArray421[3], ComplexTile.anIntArray422[0],
								ComplexTile.anIntArray422[1], ComplexTile.anIntArray422[3], complexTile.anIntArray412[j2]);
					else
						Rasterizer3D.method507(l4, i5, j5, i4, j4, k4, complexTile.anIntArray406[j2],
								complexTile.anIntArray407[j2], complexTile.anIntArray408[j2], ComplexTile.anIntArray420[l2],
								ComplexTile.anIntArray420[j3], ComplexTile.anIntArray420[l3], ComplexTile.anIntArray421[l2],
								ComplexTile.anIntArray421[j3], ComplexTile.anIntArray421[l3], ComplexTile.anIntArray422[l2],
								ComplexTile.anIntArray422[j3], ComplexTile.anIntArray422[l3], complexTile.anIntArray412[j2]);
				} else {
					int k5 = anIntArray500[complexTile.anIntArray412[j2]];
					Rasterizer3D.method503(l4, i5, j5, i4, j4, k4,
							method284(complexTile.anIntArray406[j2], k5, 0), method284(complexTile.anIntArray407[j2], k5, 0),
							method284(complexTile.anIntArray408[j2], k5, 0));
				}
			}
		}

	}

	public int method284(int i, int j, int k) {
		i = 127 - i;
		i = (i * (j & 0x7f)) / 160;
		if (i < 2)
			i = 2;
		else if (i > 126)
			i = 126;
		return (j & 0xff80) + i;
	}

	public boolean method285(int i, int j, int k, int l, int i1, int j1, int k1, int l1) {
		if (j < k && j < l && j < i1)
			return false;
		if (j > k && j > l && j > i1)
			return false;
		if (i < j1 && i < k1 && i < l1)
			return false;
		if (i > j1 && i > k1 && i > l1)
			return false;
		int i2 = (j - k) * (k1 - j1) - (i - j1) * (l - k);
		int j2 = (j - i1) * (j1 - l1) - (i - l1) * (k - i1);
		int k2 = (j - l) * (l1 - k1) - (i - k1) * (i1 - l);
		return i2 * k2 > 0 && k2 * j2 > 0;
	}

	public void method286() {
		int j = anIntArray488[anInt462];
		SceneCluster aclass39[] = aSceneClusterArrayArray554[anInt462];
		anInt490 = 0;
		for (int k = 0; k < j; k++) {
			SceneCluster class39 = aclass39[k];
			if (class39.anInt679 == 1) {
				int l = (class39.anInt675 - anInt468) + 25;
				if (l < 0 || l > 50)
					continue;
				int k1 = (class39.anInt677 - anInt469) + 25;
				if (k1 < 0)
					k1 = 0;
				int j2 = (class39.anInt678 - anInt469) + 25;
				if (j2 > 50)
					j2 = 50;
				boolean flag = false;
				while (k1 <= j2)
					if (aBooleanArrayArray507[l][k1++]) {
						flag = true;
						break;
					}
				if (!flag)
					continue;
				int j3 = anInt470 - class39.anInt680;
				if (j3 > 32) {
					class39.anInt686 = 1;
				} else {
					if (j3 >= -32)
						continue;
					class39.anInt686 = 2;
					j3 = -j3;
				}
				class39.anInt689 = (class39.anInt682 - anInt472 << 8) / j3;
				class39.anInt690 = (class39.anInt683 - anInt472 << 8) / j3;
				class39.anInt691 = (class39.anInt684 - anInt471 << 8) / j3;
				class39.anInt692 = (class39.anInt685 - anInt471 << 8) / j3;
				aClass39Array491[anInt490++] = class39;
				continue;
			}
			if (class39.anInt679 == 2) {
				int i1 = (class39.anInt677 - anInt469) + 25;
				if (i1 < 0 || i1 > 50)
					continue;
				int l1 = (class39.anInt675 - anInt468) + 25;
				if (l1 < 0)
					l1 = 0;
				int k2 = (class39.anInt676 - anInt468) + 25;
				if (k2 > 50)
					k2 = 50;
				boolean flag1 = false;
				while (l1 <= k2)
					if (aBooleanArrayArray507[l1++][i1]) {
						flag1 = true;
						break;
					}
				if (!flag1)
					continue;
				int k3 = anInt472 - class39.anInt682;
				if (k3 > 32) {
					class39.anInt686 = 3;
				} else {
					if (k3 >= -32)
						continue;
					class39.anInt686 = 4;
					k3 = -k3;
				}
				class39.anInt687 = (class39.anInt680 - anInt470 << 8) / k3;
				class39.anInt688 = (class39.anInt681 - anInt470 << 8) / k3;
				class39.anInt691 = (class39.anInt684 - anInt471 << 8) / k3;
				class39.anInt692 = (class39.anInt685 - anInt471 << 8) / k3;
				aClass39Array491[anInt490++] = class39;
			} else if (class39.anInt679 == 4) {
				int j1 = class39.anInt684 - anInt471;
				if (j1 > 128) {
					int i2 = (class39.anInt677 - anInt469) + 25;
					if (i2 < 0)
						i2 = 0;
					int l2 = (class39.anInt678 - anInt469) + 25;
					if (l2 > 50)
						l2 = 50;
					if (i2 <= l2) {
						int i3 = (class39.anInt675 - anInt468) + 25;
						if (i3 < 0)
							i3 = 0;
						int l3 = (class39.anInt676 - anInt468) + 25;
						if (l3 > 50)
							l3 = 50;
						boolean flag2 = false;
						label0: for (int i4 = i3; i4 <= l3; i4++) {
							for (int j4 = i2; j4 <= l2; j4++) {
								if (!aBooleanArrayArray507[i4][j4])
									continue;
								flag2 = true;
								break label0;
							}

						}

						if (flag2) {
							class39.anInt686 = 5;
							class39.anInt687 = (class39.anInt680 - anInt470 << 8) / j1;
							class39.anInt688 = (class39.anInt681 - anInt470 << 8) / j1;
							class39.anInt689 = (class39.anInt682 - anInt472 << 8) / j1;
							class39.anInt690 = (class39.anInt683 - anInt472 << 8) / j1;
							aClass39Array491[anInt490++] = class39;
						}
					}
				}
			}
		}

	}

	public boolean method287(int i, int j, int k) {
		int l = anIntArrayArrayArray460[i][j][k];
		if (l == -anInt463)
			return false;
		if (l == anInt463)
			return true;
		int i1 = j << 7;
		int j1 = k << 7;
		if (method291(i1 + 1, anIntArrayArrayArray455[i][j][k], j1 + 1)
				&& method291((i1 + 128) - 1, anIntArrayArrayArray455[i][j + 1][k], j1 + 1)
				&& method291((i1 + 128) - 1, anIntArrayArrayArray455[i][j + 1][k + 1], (j1 + 128) - 1)
				&& method291(i1 + 1, anIntArrayArrayArray455[i][j][k + 1], (j1 + 128) - 1)) {
			anIntArrayArrayArray460[i][j][k] = anInt463;
			return true;
		} else {
			anIntArrayArrayArray460[i][j][k] = -anInt463;
			return false;
		}
	}

	public boolean method288(int i, int j, int k, int l) {
		if (!method287(i, j, k))
			return false;
		int i1 = j << 7;
		int j1 = k << 7;
		int k1 = anIntArrayArrayArray455[i][j][k] - 1;
		int l1 = k1 - 120;
		int i2 = k1 - 230;
		int j2 = k1 - 238;
		if (l < 16) {
			if (l == 1) {
				if (i1 > anInt470) {
					if (!method291(i1, k1, j1))
						return false;
					if (!method291(i1, k1, j1 + 128))
						return false;
				}
				if (i > 0) {
					if (!method291(i1, l1, j1))
						return false;
					if (!method291(i1, l1, j1 + 128))
						return false;
				}
				if (!method291(i1, i2, j1))
					return false;
				return method291(i1, i2, j1 + 128);
			}
			if (l == 2) {
				if (j1 < anInt472) {
					if (!method291(i1, k1, j1 + 128))
						return false;
					if (!method291(i1 + 128, k1, j1 + 128))
						return false;
				}
				if (i > 0) {
					if (!method291(i1, l1, j1 + 128))
						return false;
					if (!method291(i1 + 128, l1, j1 + 128))
						return false;
				}
				if (!method291(i1, i2, j1 + 128))
					return false;
				return method291(i1 + 128, i2, j1 + 128);
			}
			if (l == 4) {
				if (i1 < anInt470) {
					if (!method291(i1 + 128, k1, j1))
						return false;
					if (!method291(i1 + 128, k1, j1 + 128))
						return false;
				}
				if (i > 0) {
					if (!method291(i1 + 128, l1, j1))
						return false;
					if (!method291(i1 + 128, l1, j1 + 128))
						return false;
				}
				if (!method291(i1 + 128, i2, j1))
					return false;
				return method291(i1 + 128, i2, j1 + 128);
			}
			if (l == 8) {
				if (j1 > anInt472) {
					if (!method291(i1, k1, j1))
						return false;
					if (!method291(i1 + 128, k1, j1))
						return false;
				}
				if (i > 0) {
					if (!method291(i1, l1, j1))
						return false;
					if (!method291(i1 + 128, l1, j1))
						return false;
				}
				if (!method291(i1, i2, j1))
					return false;
				return method291(i1 + 128, i2, j1);
			}
		}
		if (!method291(i1 + 64, j2, j1 + 64))
			return false;
		if (l == 16)
			return method291(i1, i2, j1 + 128);
		if (l == 32)
			return method291(i1 + 128, i2, j1 + 128);
		if (l == 64)
			return method291(i1 + 128, i2, j1);
		if (l == 128) {
			return method291(i1, i2, j1);
		} else {
			System.out.println("Warning unsupported wall type");
			return true;
		}
	}

	public boolean method289(int i, int j, int k, int l) {
		if (!method287(i, j, k))
			return false;
		int i1 = j << 7;
		int j1 = k << 7;
		return method291(i1 + 1, anIntArrayArrayArray455[i][j][k] - l, j1 + 1)
				&& method291((i1 + 128) - 1, anIntArrayArrayArray455[i][j + 1][k] - l, j1 + 1)
				&& method291((i1 + 128) - 1, anIntArrayArrayArray455[i][j + 1][k + 1] - l, (j1 + 128) - 1)
				&& method291(i1 + 1, anIntArrayArrayArray455[i][j][k + 1] - l, (j1 + 128) - 1);
	}

	public boolean method290(int i, int j, int k, int l, int i1, int j1) {
		if (j == k && l == i1) {
			if (!method287(i, j, l))
				return false;
			int k1 = j << 7;
			int i2 = l << 7;
			return method291(k1 + 1, anIntArrayArrayArray455[i][j][l] - j1, i2 + 1)
					&& method291((k1 + 128) - 1, anIntArrayArrayArray455[i][j + 1][l] - j1, i2 + 1)
					&& method291((k1 + 128) - 1, anIntArrayArrayArray455[i][j + 1][l + 1] - j1, (i2 + 128) - 1)
					&& method291(k1 + 1, anIntArrayArrayArray455[i][j][l + 1] - j1, (i2 + 128) - 1);
		}
		for (int l1 = j; l1 <= k; l1++) {
			for (int j2 = l; j2 <= i1; j2++)
				if (anIntArrayArrayArray460[i][l1][j2] == -anInt463)
					return false;

		}

		int k2 = (j << 7) + 1;
		int l2 = (l << 7) + 2;
		int i3 = anIntArrayArrayArray455[i][j][l] - j1;
		if (!method291(k2, i3, l2))
			return false;
		int j3 = (k << 7) - 1;
		if (!method291(j3, i3, l2))
			return false;
		int k3 = (i1 << 7) - 1;
		if (!method291(k2, i3, k3))
			return false;
		return method291(j3, i3, k3);
	}

	public boolean method291(int i, int j, int k) {
		for (int l = 0; l < anInt490; l++) {
			SceneCluster class39 = aClass39Array491[l];
			if (class39.anInt686 == 1) {
				int i1 = class39.anInt680 - i;
				if (i1 > 0) {
					int j2 = class39.anInt682 + (class39.anInt689 * i1 >> 8);
					int k3 = class39.anInt683 + (class39.anInt690 * i1 >> 8);
					int l4 = class39.anInt684 + (class39.anInt691 * i1 >> 8);
					int i6 = class39.anInt685 + (class39.anInt692 * i1 >> 8);
					if (k >= j2 && k <= k3 && j >= l4 && j <= i6)
						return true;
				}
			} else if (class39.anInt686 == 2) {
				int j1 = i - class39.anInt680;
				if (j1 > 0) {
					int k2 = class39.anInt682 + (class39.anInt689 * j1 >> 8);
					int l3 = class39.anInt683 + (class39.anInt690 * j1 >> 8);
					int i5 = class39.anInt684 + (class39.anInt691 * j1 >> 8);
					int j6 = class39.anInt685 + (class39.anInt692 * j1 >> 8);
					if (k >= k2 && k <= l3 && j >= i5 && j <= j6)
						return true;
				}
			} else if (class39.anInt686 == 3) {
				int k1 = class39.anInt682 - k;
				if (k1 > 0) {
					int l2 = class39.anInt680 + (class39.anInt687 * k1 >> 8);
					int i4 = class39.anInt681 + (class39.anInt688 * k1 >> 8);
					int j5 = class39.anInt684 + (class39.anInt691 * k1 >> 8);
					int k6 = class39.anInt685 + (class39.anInt692 * k1 >> 8);
					if (i >= l2 && i <= i4 && j >= j5 && j <= k6)
						return true;
				}
			} else if (class39.anInt686 == 4) {
				int l1 = k - class39.anInt682;
				if (l1 > 0) {
					int i3 = class39.anInt680 + (class39.anInt687 * l1 >> 8);
					int j4 = class39.anInt681 + (class39.anInt688 * l1 >> 8);
					int k5 = class39.anInt684 + (class39.anInt691 * l1 >> 8);
					int l6 = class39.anInt685 + (class39.anInt692 * l1 >> 8);
					if (i >= i3 && i <= j4 && j >= k5 && j <= l6)
						return true;
				}
			} else if (class39.anInt686 == 5) {
				int i2 = j - class39.anInt684;
				if (i2 > 0) {
					int j3 = class39.anInt680 + (class39.anInt687 * i2 >> 8);
					int k4 = class39.anInt681 + (class39.anInt688 * i2 >> 8);
					int l5 = class39.anInt682 + (class39.anInt689 * i2 >> 8);
					int i7 = class39.anInt683 + (class39.anInt690 * i2 >> 8);
					if (i >= j3 && i <= k4 && k >= l5 && k <= i7)
						return true;
				}
			}
		}

		return false;
	}

}
//TODO:Needs more refactoring
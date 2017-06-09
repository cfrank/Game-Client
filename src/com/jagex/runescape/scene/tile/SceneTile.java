package com.jagex.runescape.scene.tile;
import com.jagex.runescape.scene.CameraAngle;
import com.jagex.runescape.scene.SceneSpawnRequest;
import com.jagex.runescape.collection.Node;

public class SceneTile extends Node {

	public SceneTile(int i, int j, int k) {
		anInt1400 = anInt1397 = i;
		anInt1398 = j;
		anInt1399 = k;
	}

	public int anInt1397;
	public int anInt1398;
	public int anInt1399;
	public int anInt1400;
	public GenericTile genericTile;
	public ComplexTile complexTile;
	public Wall wall;
	public WallDecoration wallDecoration;
	public FloorDecoration floorDecoration;
	public CameraAngle cameraAngle;
	public int sceneSpawnRequestCount;
	public SceneSpawnRequest[] sceneSpawnRequests = new SceneSpawnRequest[5];
	public int[] anIntArray1409 = new int[5];
	public int anInt1410;
	public int anInt1411;
	public boolean aBoolean1412;
	public boolean aBoolean1413;
	public boolean aBoolean1414;
	public int anInt1415;
	public int anInt1416;
	public int anInt1417;
	public int anInt1418;
	public SceneTile aClass50_Sub3_1419;
}

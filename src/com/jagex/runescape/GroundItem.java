package com.jagex.runescape;// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import com.jagex.runescape.media.renderable.Model;
import com.jagex.runescape.media.renderable.Renderable;

public class GroundItem extends Renderable {

	@Override
	public Model getRotatedModel() {
		ItemDefinition def = ItemDefinition.forId(id);
		return def.getModel(amount);
	}

	public GroundItem() {
	}

	public int id;
	public int amount;
}

package com.jagex.runescape;

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

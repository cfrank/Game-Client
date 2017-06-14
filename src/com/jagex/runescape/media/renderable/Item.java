package com.jagex.runescape.media.renderable;

import com.jagex.runescape.ItemDefinition;
import com.jagex.runescape.media.renderable.Model;
import com.jagex.runescape.media.renderable.Renderable;

public class Item extends Renderable {
	public int itemId;
	public int itemCount;

	@Override
	public Model getRotatedModel() {
		ItemDefinition itemDefinition = ItemDefinition.forId(itemId);
		return itemDefinition.getModel(itemCount);
	}

}

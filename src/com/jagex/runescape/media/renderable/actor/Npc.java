package com.jagex.runescape.media.renderable.actor;// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

import com.jagex.runescape.ActorDefinition;
import com.jagex.runescape.AnimationSequence;
import com.jagex.runescape.SpotAnimation;
import com.jagex.runescape.media.Animation;
import com.jagex.runescape.media.renderable.Model;
import com.jagex.runescape.media.renderable.actor.Actor;

public class Npc extends Actor {
	public ActorDefinition npcDefinition;

	public Model getChildModel() {
		if (super.animation >= 0 && super.animationDelay == 0) {
			int frameId = AnimationSequence.animations[super.animation].frame2Ids[super.anInt1625];
			int frameId2 = -1;
			if (super.anInt1588 >= 0 && super.anInt1588 != super.standAnimationId)
				frameId2 = AnimationSequence.animations[super.anInt1588].frame2Ids[super.anInt1589];
			return npcDefinition.getChildModel(frameId, frameId2, 0, AnimationSequence.animations[super.animation].flowControl);
		}
		int j = -1;
		if (super.anInt1588 >= 0)
			j = AnimationSequence.animations[super.anInt1588].frame2Ids[super.anInt1589];
		return npcDefinition.getChildModel(j, -1, 0, null);
	}

	@Override
	public Model getRotatedModel() {
		if (npcDefinition == null)
			return null;
		Model model = getChildModel();
		if (model == null)
			return null;
		super.modelHeight = model.height;
		if (super.spotAnimationId != -1 && super.currentAnimationFrame != -1) {
			SpotAnimation spotanimation = SpotAnimation.cache[super.spotAnimationId];
			Model model_4_ = spotanimation.getModel();
			if (model_4_ != null) {
				int animationId = spotanimation.sequences.frame2Ids[super.currentAnimationFrame];
				Model animationModel = new Model(true,
						model_4_, Animation.exists(animationId));
				animationModel.translate(0, 0, -super.anInt1618);
				animationModel.createBones();
				animationModel.applyTransform(animationId);
				animationModel.triangleSkin = null;
				animationModel.vectorSkin = null;
				if (spotanimation.resizeXY != 128 || spotanimation.resizeZ != 128)
					animationModel.scaleT(spotanimation.resizeZ, spotanimation.resizeXY, 9, spotanimation.resizeXY);
				animationModel.applyLighting(64 + spotanimation.modelLightFalloff, 850 + spotanimation.modelLightAmbient, -30, -50, -30, true);
				Model[] models = { model, animationModel };
				model = new Model(2, true, 0, models);
			}
		}
		if (npcDefinition.boundaryDimension == 1)
			model.oneSquareModel = true;
		return model;
	}

	@Override
	public boolean isVisible() {
		return npcDefinition != null;
	}
}

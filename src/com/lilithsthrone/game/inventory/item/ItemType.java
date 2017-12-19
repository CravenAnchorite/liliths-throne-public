package com.lilithsthrone.game.inventory.item;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lilithsthrone.game.character.GameCharacter;
import com.lilithsthrone.game.character.QuestLine;
import com.lilithsthrone.game.character.attributes.CorruptionLevel;
import com.lilithsthrone.game.character.race.Race;
import com.lilithsthrone.game.dialogue.DialogueFlagValue;
import com.lilithsthrone.game.dialogue.utils.UtilText;
import com.lilithsthrone.game.inventory.Rarity;
import com.lilithsthrone.game.inventory.enchanting.TFEssence;
import com.lilithsthrone.main.Main;
import com.lilithsthrone.utils.Colour;
import com.lilithsthrone.utils.Util;
import com.lilithsthrone.utils.Util.ListValue;

/**
 * @since 0.1.84
 * @version 0.1.97
 * @author Innoxia
 */
public class ItemType {

	/*
	 * Common: Restore resources Rare: Apply status effect Epic: Transformation
	 * Legendary: Uniques
	 */

	// EPIC:

	// Lilith's consumables:
	// LILITHS_DESIRE("a bottle of", "it", "Lilith's Desire",
	// "A glass bottle, filled with bubbling pink liquid."
	// + " On the bottle's label, there is an image of Lilith's
	// perfectly-formed, heart-shaped ass."
	// + " Her thin, demonic tail twists round to playfully cover her asshole
	// and pussy.",
	// "potion", Colour.PINK,
	// true, 25, Rarity.EPIC,
	// TransformationEffect.SEXUAL_BOON_AVERAGE.getDescription()) {
	// @Override
	// protected String extraEffects(GameCharacter user, GameCharacter
	// target) {
	// return applyLilithsTransformation(user, target, this,
	// TransformationEffect.SEXUAL_BOON_AVERAGE);
	// }
	//
	// @Override
	// public int chanceToSucceedOnTargetUse(GameCharacter target) {
	// return 50;
	// }
	//
	// @Override
	// public String getUseDescription(GameCharacter user, GameCharacter target){
	// return "drink";
	// }
	//
	// @Override
	// public boolean isAbleToBeUsedInCombat() {
	// return false;
	// }
	//
	// @Override
	// public boolean isAbleToBeUsedInSex() {
	// return false;
	// }
	// },
	// LILITHS_OFFERING("a bottle of", "it", "Lilith's Offering",
	// "A glass bottle, filled with bubbling pink liquid."
	// + " On the bottle's label, there is an image of Lilith's
	// perfectly-formed, heart-shaped ass."
	// + " Her delicate hands are reaching down to pull apart her soft ass
	// cheeks, although her asshole and pussy are covered by her thin, demonic
	// tail.",
	// "potion", Colour.PINK,
	// true, 25, Rarity.EPIC,
	// TransformationEffect.SEXUAL_BOON_STRONG.getDescription()) {
	// @Override
	// protected String extraEffects(GameCharacter user, GameCharacter
	// target) {
	// return applyLilithsTransformation(user, target, this,
	// TransformationEffect.SEXUAL_BOON_STRONG);
	// }
	//
	// @Override
	// public int chanceToSucceedOnTargetUse(GameCharacter target) {
	// return 10;
	// }
	//
	// @Override
	// public String getUseDescription(GameCharacter user, GameCharacter target){
	// return "drink";
	// }
	//
	// @Override
	// public boolean isAbleToBeUsedInCombat() {
	// return false;
	// }
	//
	// @Override
	// public boolean isAbleToBeUsedInSex() {
	// return false;
	// }
	// },
	
	//
	// // Lilin's consumables:
	// // Lyxias' dream: Increases breast size and lactation, cum production
	// LYXIAS_DREAM("a vial of", "it", "Lyxias' dream", "A small glass vial,
	// filled with a thick, cream-coloured liquid. Engraved into the glass,
	// there is a finely-detailed image of the"
	// + " scantily-clad tentacle-girl, Lyxia. She is stuffing her tentacles
	// into the orifices of a group of cow-girls, violently milking their
	// swollen breasts while she fucks them.",
	// "potion", Colour.WHITE,
	// true, 25, Rarity.EPIC,
	// TransformationEffect.LYXIAS_DREAM.getDescription()) {
	// @Override
	// protected String extraEffects(GameCharacter user, GameCharacter
	// target) {
	// return applyLilithsTransformation(user, target, this,
	// TransformationEffect.LYXIAS_DREAM);
	// }
	//
	// @Override
	// public int chanceToSucceedOnTargetUse(GameCharacter target) {
	// return 10;
	// }
	//
	// @Override
	// public String getUseDescription(GameCharacter user, GameCharacter target){
	// return "drink";
	// }
	//
	// @Override
	// public boolean isAbleToBeUsedInCombat() {
	// return false;
	// }
	//
	// @Override
	// public boolean isAbleToBeUsedInSex() {
	// return false;
	// }
	// },
	// // Lunette's need: Increases capacity & wetness of everything, making
	// breasts & cock fuckable.
	// LUNETTES_NEED("a vial of", "it", "Lunette's need", "A small glass vial,
	// filled with an oily liquid. Engraved into the glass is an image of
	// Lunette; a muscular futa pegataur. She's"
	// + " laughing as she aggressively mounts a busty horse-girl. Lunette's
	// latest conquest is being pushed into the ground, her stomach visibly
	// distending from Lunette's gigantic horse-cock.",
	// "potion", Colour.WHITE,
	// true, 25, Rarity.EPIC,
	// TransformationEffect.LUNETTES_NEED.getDescription()) {
	// @Override
	// protected String extraEffects(GameCharacter user, GameCharacter
	// target) {
	// return applyLilithsTransformation(user, target, this,
	// TransformationEffect.LUNETTES_NEED);
	// }
	//
	// @Override
	// public int chanceToSucceedOnTargetUse(GameCharacter target) {
	// return 10;
	// }
	//
	// @Override
	// public String getUseDescription(GameCharacter user, GameCharacter target){
	// return "drink";
	// }
	//
	// @Override
	// public boolean isAbleToBeUsedInCombat() {
	// return false;
	// }
	//
	// @Override
	// public boolean isAbleToBeUsedInSex() {
	// return false;
	// }
	// },
	// // Lisophia's desire: Increases cock & ball size. Grows second cock.
	// Increases cum production.
	// LISOPHIAS_DESIRE("a vial of", "it", "Lisophia's desire", "A small glass
	// vial, filled with a bubbling blue liquid. Engraved into the glass, there
	// is an image of Lisophia; an exotic-looking"
	// + " Lamia. She's forcing a pair of stallion-sized reptilian cocks deep
	// into the pussy and asshole within her slit-like cloaca, her hands choking
	// her unfortunate partner as she aggressively rides him.",
	// "potion", Colour.BLUE,
	// true, 25, Rarity.EPIC,
	// TransformationEffect.LISOPHIAS_DESIRE.getDescription()) {
	// @Override
	// protected String extraEffects(GameCharacter user, GameCharacter
	// target) {
	// return applyLilithsTransformation(user, target, this,
	// TransformationEffect.LISOPHIAS_DESIRE);
	// }
	//
	// @Override
	// public int chanceToSucceedOnTargetUse(GameCharacter target) {
	// return 10;
	// }
	//
	// @Override
	// public String getUseDescription(GameCharacter user, GameCharacter target){
	// return "drink";
	// }
	//
	// @Override
	// public boolean isAbleToBeUsedInCombat() {
	// return false;
	// }
	//
	// @Override
	// public boolean isAbleToBeUsedInSex() {
	// return false;
	// }
	// },
	// // Lirecea's demand: Hyper-feminine, growing hips, breasts, tightens
	// pussy, makes wet, shrinks cocks.
	// LIRECEAS_DEMAND("a vial of", "it", "Lirecea's demand", "A small glass
	// vial, filled with a bubbling pink liquid. Engraved into the glass, the
	// gigantic octopus-girl, Lirecea,"
	// + " is looking down with a sinister smile on her face. Her tentacles are
	// violently penetrating the seven beautiful mermaids beneath her, while her
	// free tentacle is slipping inside her own needy pussy.",
	// "potion", Colour.PINK,
	// true, 25, Rarity.EPIC,
	// TransformationEffect.LIRECEAS_DEMAND.getDescription()) {
	// @Override
	// protected String extraEffects(GameCharacter user, GameCharacter
	// target) {
	// return applyLilithsTransformation(user, target, this,
	// TransformationEffect.LIRECEAS_DEMAND);
	// }
	//
	// @Override
	// public int chanceToSucceedOnTargetUse(GameCharacter target) {
	// return 10;
	// }
	//
	// @Override
	// public String getUseDescription(GameCharacter user, GameCharacter target){
	// return "drink";
	// }
	//
	// @Override
	// public boolean isAbleToBeUsedInCombat() {
	// return false;
	// }
	//
	// @Override
	// public boolean isAbleToBeUsedInSex() {
	// return false;
	// }
	// },
	
//	public static AbstractItemType TEST_ITEM = new AbstractItemType(
//			"a bottle of",
//			false,
//			"testing fluids",
//			"You shouldn't be able to find this. x_x",
//			"attributeHorseMorphDrink",
//			Colour.ATTRIBUTE_STRENGTH,
//			25,
//			Rarity.UNCOMMON,
//			TFEssence.HORSE_MORPH,
//			Util.newArrayListOfValues(new ListValue<>(new ItemEffect(ItemEffectType.TESTING, null, null, null, 0)))) {
//
//		/**
//				 * 
//				 */
//				private static final long serialVersionUID = 1L;
//
//		@Override
//		public String getUseName() {
//			return "drink";
//		}
//
//		@Override
//		public String getUseDescription(GameCharacter user, GameCharacter target) {
//			if (user!=null && user.isPlayer())
//				return "<p>"
//							+ "You drink the testing fluid."
//						+ "</p>";
//			else
//				return UtilText.parse(user,
//						"<p>"
//								+ "[npc.Name] drinks the testing fluid."
//						+ "</p>");
//		}
//	};
	
	private static String getGenericUseDescription(GameCharacter user, GameCharacter target, String playerUseSelf, String playerUsePartner, String partnerUseSelf, String partnerUsePlayer) {
		if (user!=null && user.isPlayer()) {
			if(target!=null) {
				if(target.isPlayer()) {
					return "<p>"+playerUseSelf+"</p>";
					
				} else {
					return UtilText.parse(target, "<p>"+playerUsePartner+"</p>");
				}
			} else {
				return "";
			}
			
		} else {
			if(target!=null) {
				if(target.isPlayer()) {
					return UtilText.parse(user, "<p>"+partnerUsePlayer+"</p>");
					
				} else {
					return UtilText.parse(user, "<p>"+partnerUseSelf+"</p>");
				}
			} else {
				return "";
			}
		}
	}
	
	// Crafting:
	
	// Strength ingredients are beer-type alcohol:
	
	public static AbstractItemType STR_INGREDIENT_EQUINE_CIDER = new AbstractItemType(
			"a bottle of",
			false,
			"Equine Cider",
			"Equine Ciders",
			"The thick glass bottle of 'Equine Cider' appears to contain, much as its name would suggest, a generous helping of some sort of alcoholic cider."
				+ " On the label, there's an incredibly lewd illustration of a horse-boy slamming his massive cock deep into a girl's eager pussy.",
			"attributeHorseMorphDrink",
			Colour.ATTRIBUTE_STRENGTH,
			30,
			Rarity.UNCOMMON,
			TFEssence.ARCANE,
			Util.newArrayListOfValues(new ListValue<>(new ItemEffect(ItemEffectType.STR_EQUINE_CIDER, null, null, null, 0)))) {

		private static final long serialVersionUID = 1L;

		@Override
		public ItemEffectType getEnchantmentEffect() {
			return ItemEffectType.ATTRIBUTE_STRENGTH;
		}

		@Override
		public AbstractItemType getEnchantmentItemType(List<ItemEffect> effects) {
			return ItemType.POTION;
		}

		@Override
		public String getUseName() {
			return "drink";
		}

		@Override
		public String getUseDescription(GameCharacter user, GameCharacter target) {
<<<<<<< Upstream, based on upstream/master
			return getGenericUseDescription(user, target,
					"Unscrewing the lid, you bring the bottle of 'Equine Cider' to your lips before tilting your head back and quickly gulping down the golden liquid."
						+ " As the last few drops slide down your throat, you notice a faint, musky dryness permeating through the sweet liquid, which lingers for some time as a slightly unpleasant aftertaste.",
					"Unscrewing the lid, you bring the bottle of 'Equine Cider' to [npc.name]'s lips, before tilting [npc.her] head back and forcing [npc.herHim] to quickly gulp down the golden liquid.",
					"[npc.Name] pulls out a bottle of 'Equine Cider', and, after quickly unscrewing the cap, [npc.she] promptly downs the entire bottle.",
					"[npc.Name] pulls out a bottle of 'Equine Cider', and, after quickly unscrewing the cap, [npc.she] brings it to your lips before tilting your head back and forcing you to quickly gulp down the golden liquid."
						+ " As the last few drops slide down your throat, you notice a faint, musky dryness permeating through the sweet liquid, which lingers for some time as a slightly unpleasant aftertaste.");
		}

		@Override
		public boolean isCommonItem() {
			return true;
=======
			if (user!=null && user.isPlayer())
				return "<p>"
							+ "Unscrewing the lid, you bring the bottle of 'Equine Cider' to your lips before tilting your head back and quickly gulping down the golden liquid."
							+ " As the last few drops slide down your throat, you notice a faint, musky dryness permeating through the sweet liquid, which lingers for some time as a slightly unpleasant aftertaste."
						+ "</p>";
			else
				return UtilText.parse(user,
						"<p>"
								+ "[npc.Name] pulls out a bottle of 'Equine Cider', and, after quickly unscrewing the cap, [npc.she] promptly downs the entire bottle."
						+ "</p>");
>>>>>>> 78d186e upstream
		}
	};
	
	public static AbstractItemType STR_INGREDIENT_BUBBLE_MILK = new AbstractItemType("a bottle of",
			false,
			"Bubble Milk",
			"Bubble Milks",
			"The thick glass bottle of 'Bubble Milk' appears to contain, much as its name would suggest, a generous helping of milk."
				+ " Looking through the glass, you see that there are little bubbles fizzing up in the liquid within, making this milk appear to be carbonated.",
			"attributeCowMorphDrink",
			Colour.ATTRIBUTE_STRENGTH,
			30,
			Rarity.UNCOMMON,
			TFEssence.ARCANE,
			Util.newArrayListOfValues(new ListValue<>(new ItemEffect(ItemEffectType.STR_BUBBLE_MILK, null, null, null, 0)))) {

		private static final long serialVersionUID = 1L;

		@Override
		public ItemEffectType getEnchantmentEffect() {
			return ItemEffectType.ATTRIBUTE_STRENGTH;
		}

		@Override
		public AbstractItemType getEnchantmentItemType(List<ItemEffect> effects) {
			return POTION;
		}

		@Override
		public String getUseName() {
			return "drink";
		}

		@Override
		public String getUseDescription(GameCharacter user, GameCharacter target) {
<<<<<<< Upstream, based on upstream/master
			return getGenericUseDescription(user, target,
					"Unscrewing the cap, you bring the bottle of Bubble Milk up to your [pc.lips+], before tilting your head back and quickly gulping down the creamy liquid."
						+ " Despite its name and the appearance of being carbonated, the mellow taste lacks any sort of fizz, and, after draining the entire bottle, a soft, pleasant aftertaste lingers in your mouth.",
					"Unscrewing the cap, you bring the bottle of 'Bubble Milk' to [npc.name]'s lips, before tilting [npc.her] head back and forcing [npc.herHim] to quickly gulp down the creamy liquid.",
					"[npc.Name] pulls out a bottle of 'Bubble Milk', and, after quickly unscrewing the cap, [npc.she] promptly downs the entire bottle.",
					"[npc.Name] pulls out a bottle of 'Bubble Milk', and, after quickly unscrewing the cap, [npc.she] brings it to your lips before tilting your head back and forcing you to quickly gulp down the creamy liquid."
						+ " Despite its name and the appearance of being carbonated, the mellow taste lacks any sort of fizz, and, after draining the entire bottle, a soft, pleasant aftertaste lingers in your mouth.");
		}

		@Override
		public boolean isCommonItem() {
			return true;
=======
			if (user!=null && user.isPlayer()) {
				return "<p>"
							+ "Unscrewing the cap, you bring the bottle of Bubble Milk up to your [pc.lips+], before tilting your head back and quickly gulping down the creamy liquid."
							+ " Despite its name and the appearance of being carbonated, the mellow taste lacks any sort of fizz, and, after draining the entire bottle, a soft, pleasant aftertaste lingers in your mouth."
						+ "</p>";
			} else {
				return UtilText.parse(user,
						"<p>"
							+ "[npc.Name] pulls out a bottle of 'Bubble Milk', and, after quickly unscrewing the cap, [npc.she] promptly downs the entire bottle."
						+ "</p>");
			}
>>>>>>> 78d186e upstream
		}
	};
	
	public static AbstractItemType STR_INGREDIENT_WOLF_WHISKEY = new AbstractItemType("a bottle of",
			false,
			"Wolf Whiskey",
			"Wolf Whiskeys",
			"Although labelled as a whiskey, the liquid inside the glass bottle looks more like a thick cream."
					+ " The label on the front shows a greater wolf-boy ejaculating into a bottle just like this one, making it quite clear what this 'whiskey' really is.",
			"attributeWolfMorphDrink",
			Colour.ATTRIBUTE_STRENGTH,
			30,
			Rarity.UNCOMMON,
			TFEssence.ARCANE,
			Util.newArrayListOfValues(new ListValue<>(new ItemEffect(ItemEffectType.STR_WOLF_WHISKEY, null, null, null, 0)))) {

		private static final long serialVersionUID = 1L;

		@Override
		public ItemEffectType getEnchantmentEffect() {
			return ItemEffectType.ATTRIBUTE_STRENGTH;
		}

		@Override
		public AbstractItemType getEnchantmentItemType(List<ItemEffect> effects) {
			return POTION;
		}

		@Override
		public String getUseName() {
			return "drink";
		}

		@Override
		public String getUseDescription(GameCharacter user, GameCharacter target) {
<<<<<<< Upstream, based on upstream/master
			return getGenericUseDescription(user, target,
					"Popping off the cap, you bring the bottle of 'Wolf Whiskey' up to your lips."
						+ " A thick, musky scent rises from the opening, and with a gulp, you start downing the liquid, discovering that the liquid's taste is almost identical to its pungent aroma.",
					"Popping off the cap, you bring the bottle of 'Wolf Whiskey' to [npc.name]'s lips, before tilting [npc.her] head back and forcing [npc.herHim] to quickly gulp down the thick liquid.",
					"[npc.Name] pulls out a bottle of 'Wolf Whiskey', and, after quickly popping off the cap, [npc.she] promptly downs the entire bottle.",
					"[npc.Name] pulls out a bottle of 'Wolf Whiskey', and, after quickly unscrewing the cap, [npc.she] brings it to your lips before tilting your head back and forcing you to quickly gulp down the thick liquid."
						+ " You soon discover that the musky, pungent aroma rising from the bottle's opening is almost identical to the whiskey's rather unpleasant taste.");
		}

		@Override
		public boolean isCommonItem() {
			return true;
=======
			if (user!=null && user.isPlayer())
				return "<p>"
							+ "Popping off the cap, you bring the bottle of 'Wolf Whiskey' up to your lips."
							+ " A thick, musky scent rises from the opening, and with a gulp, you start downing the liquid, discovering that the liquid's taste is almost identical to its pungent aroma."
						+ "</p>";
			else
				return UtilText.parse(user,
						"<p>"
								+ "[npc.Name] pulls out a bottle of 'Wolf Whiskey', and, after quickly popping off the cap, [npc.she] promptly downs the entire bottle."
						+ "</p>");
>>>>>>> 78d186e upstream
		}
	};
	
	public static AbstractItemType STR_INGREDIENT_SWAMP_WATER = new AbstractItemType(
			"a bottle of",
			false,
			"Swamp Water",
			"Swamp Waters",
			"A glass bottle of what appears to be some kind of moonshine."
				+ " A label on the front shows an alligator-boy biting the top off a bottle just like this one.",
			"attributeGatorMorphDrink",
			Colour.ATTRIBUTE_STRENGTH,
			30,
			Rarity.UNCOMMON,
			TFEssence.ARCANE,
			Util.newArrayListOfValues(new ListValue<>(new ItemEffect(ItemEffectType.STR_SWAMP_WATER, null, null, null, 0)))) {

		private static final long serialVersionUID = 1L;

		@Override
		public ItemEffectType getEnchantmentEffect() {
			return ItemEffectType.ATTRIBUTE_STRENGTH;
		}

		@Override
		public AbstractItemType getEnchantmentItemType(List<ItemEffect> effects) {
			return POTION;
		}

		@Override
		public String getUseName() {
			return "drink";
		}

		@Override
		public String getUseDescription(GameCharacter user, GameCharacter target) {
<<<<<<< Upstream, based on upstream/master
			return getGenericUseDescription(user, target,
					"Pulling out the stopper, you take a large swig of 'Swamp Water'."
						+ " Thankfully, the liquid within isn't a literal version of its label, and turns out to be a strong liquor, which burns your throat a little as you gulp it down."
						+ " The intense alcoholic taste is very different to anything you've ever tried before, and you can't help but greedily gulp down the entire bottle, leaving a strange, tangy aftertaste lingering on your tongue.",
					"Pulling out the stopper, you bring the bottle of 'Swamp Water' to [npc.name]'s lips, before tilting [npc.her] head back and forcing [npc.herHim] to quickly gulp down the alcoholic liquid.",
					"[npc.Name] pulls out a bottle of 'Swamp Water', and, after quickly pulling out the stopper, [npc.she] promptly gulps downs the entire bottle.",
					"[npc.Name] pulls out a bottle of 'Swamp Water', and, after quickly pulling out the stopper, [npc.she] brings it to your lips before tilting your head back and forcing you to quickly gulp down the contents."
						+ " Thankfully, the liquid within isn't a literal version of its label, and turns out to be a strong liquor, which burns your throat a little as you gulp it down."
						+ " The intense alcoholic taste is very different to anything you've ever tried before, and you can't help but greedily gulp down the entire bottle, leaving a strange, tangy aftertaste lingering on your tongue.");
		}

		@Override
		public boolean isCommonItem() {
			return true;
=======
			if (user!=null && user.isPlayer() && target.isPlayer()) {
				return "<p>"
							+ "You pull out the stopper and take a large swig of the 'Swamp Water'."
							+ " Thankfully, the liquid within isn't a literal version of its label, and turns out to be a strong liquor, which burns your throat a little as you gulp it down."
							+ " Despite its intense potency, you find that the alcoholic taste is very different to anything you've tried before, and can't help but greedily finish the entire bottle, leaving a strange, tangy aftertaste lingering on your tongue."
						+ "</p>";
				
			} else {
				return UtilText.parse(target,
						"<p>"
							+ "[npc.Name] pulls out a bottle of 'Swamp Water', and, after quickly pulling out the stopper, [npc.she] promptly gulps downs the entire bottle."
						+ "</p>");
			}
>>>>>>> 78d186e upstream
		}
	};
	
	// Intelligence ingredients are cold non-alcoholic drinks:
	
	public static AbstractItemType INT_INGREDIENT_FELINE_FANCY = new AbstractItemType(
			"a bottle of",
			false,
			"Feline's Fancy",
			"Feline's Fancies",
			"A delicate glass bottle filled with a thick, cream-like liquid."
				+ " A label on the front shows a pair of cat-girls lovingly kissing one another, with the dominant partner slipping a hand down between her partner's thighs.",
			"attributeCatMorphDrink",
			Colour.ATTRIBUTE_INTELLIGENCE,
			30,
			Rarity.UNCOMMON,
			TFEssence.ARCANE,
			Util.newArrayListOfValues(new ListValue<>(new ItemEffect(ItemEffectType.INT_FELINE_FANCY, null, null, null, 0)))) {

		private static final long serialVersionUID = 1L;

		@Override
		public ItemEffectType getEnchantmentEffect() {
			return ItemEffectType.ATTRIBUTE_INTELLIGENCE;
		}

		@Override
		public AbstractItemType getEnchantmentItemType(List<ItemEffect> effects) {
			return POTION;
		}

		@Override
		public String getUseName() {
			return "drink";
		}

		@Override
		public String getUseDescription(GameCharacter user, GameCharacter target) {
<<<<<<< Upstream, based on upstream/master
			return getGenericUseDescription(user, target,
					"Opening the bottle of 'Feline's Fancy', you eagerly bring it up to your waiting lips."
						+ " A rich, creamy smell rises from the opening, and as you greedily drink down the cool liquid, you're delighted to discover that it tastes every bit as good as its delicious aroma suggested it would.",
					"Unscrewing the cap, you bring the bottle of 'Feline's Fancy' to [npc.name]'s lips, before tilting [npc.her] head back and forcing [npc.herHim] to quickly gulp down the creamy liquid.",
					"[npc.Name] pulls out a bottle of 'Feline's Fancy', and, after quickly unscrewing the cap, [npc.she] promptly downs the entire bottle.",
					"[npc.Name] pulls out a bottle of 'Feline's Fancy', and, after quickly unscrewing the cap, [npc.she] brings it to your lips before tilting your head back and forcing you to quickly gulp down the contents."
						+ " A rich, creamy smell rises from the opening, and as you greedily drink down the cool liquid, you're delighted to discover that it tastes every bit as good as its delicious aroma suggested it would.");
		}

		@Override
		public boolean isCommonItem() {
			return true;
=======
			if (user!=null && user.isPlayer() && target.isPlayer()) {
				return "<p>"
							+ "Opening the bottle, you eagerly bring it up to your waiting lips."
							+ " A rich, creamy smell rises from the opening, and as you greedily drink down the cool liquid, you're delighted to discover that it tastes every bit as good as its delicious aroma suggested it would."
						+ "</p>";
				
			} else {
				return UtilText.parse(user,
						"<p>"
							+ "[npc.Name] pulls out a bottle of 'Feline's Fancy', and, after quickly unscrewing the cap, [npc.she] promptly downs the entire bottle."
						+ "</p>");
			}
>>>>>>> 78d186e upstream
		}
	};
	
	public static AbstractItemType INT_INGREDIENT_VANILLA_WATER = new AbstractItemType(
			"a bottle of",
			false,
			"Vanilla Water",
			"Vanilla Waters",
			"A plastic bottle filled with what appears to be nothing but water."
				+ " While there's no label on the bottle, there is a slight indentation in its surface, and, holding it up to the light to get a better look, you see that the impression spells the words 'Vanilla Water'.",
			"attributeHumanDrink",
			Colour.ATTRIBUTE_INTELLIGENCE,
			30,
			Rarity.UNCOMMON,
			TFEssence.ARCANE,
			Util.newArrayListOfValues(new ListValue<>(new ItemEffect(ItemEffectType.INT_VANILLA_WATER, null, null, null, 0)))) {

		private static final long serialVersionUID = 1L;

		@Override
		public ItemEffectType getEnchantmentEffect() {
			return ItemEffectType.ATTRIBUTE_INTELLIGENCE;
		}

		@Override
		public AbstractItemType getEnchantmentItemType(List<ItemEffect> effects) {
			return POTION;
		}

		@Override
		public String getUseName() {
			return "drink";
		}

		@Override
		public String getUseDescription(GameCharacter user, GameCharacter target) {
<<<<<<< Upstream, based on upstream/master
			return getGenericUseDescription(user, target,
					"After first unscrewing the cap, you bring the plastic bottle of 'Vanilla Water' up to your [pc.mouth]."
						+ " A faint smell of vanilla informs you that this isn't any ordinary water, and as you tilt your head back and start drinking the cool liquid, the taste of vanilla overwhelms your senses.",
					"Unscrewing the cap, you bring the bottle of 'Vanilla Water' to [npc.name]'s lips, before tilting [npc.her] head back and forcing [npc.herHim] to quickly gulp down the liquid.",
					"[npc.Name] pulls out a bottle of 'Vanilla Water', and, after quickly unscrewing the cap, [npc.she] promptly downs the entire bottle.",
					"[npc.Name] pulls out a bottle of 'Vanilla Water', and, after quickly unscrewing the cap, [npc.she] brings it to your lips before tilting your head back and forcing you to quickly gulp down the contents."
						+ " A faint smell of vanilla informs you that this isn't any ordinary water, and as you tilt your head back and start drinking the cool liquid, the taste of vanilla overwhelms your senses.");
		}

		@Override
		public boolean isCommonItem() {
			return true;
=======
			if (user!=null && user.isPlayer() && target.isPlayer()) {
				return "<p>"
							+ "After first unscrewing the cap, you bring the plastic bottle up to your mouth."
							+ " A faint smell of vanilla informs you that this isn't any ordinary water, and as you tilt your head back and start drinking the cool liquid, the taste of vanilla overwhelms your senses."
						+ "</p>";
				
			} else {
				return UtilText.parse(user,
						"<p>"
							+ "[npc.Name] pulls out a bottle of 'Vanilla Water', and, after quickly unscrewing the cap, [npc.she] promptly downs the entire bottle."
						+ "</p>");
			}
>>>>>>> 78d186e upstream
		}
	};
	
	// Fitness ingredients are energy drinks and coffee:
	
	public static AbstractItemType FIT_INGREDIENT_CANINE_CRUSH = new AbstractItemType(
			"a bottle of",
			false,
			"Canine Crush",
			"Canine Crushes",
			"A glass bottle of what looks to be some kind of beer."
				+ " A label on the front shows a dog-boy lining himself up behind a beautiful girl, who's down on all fours, presenting her naked, dripping pussy to the throbbing dog-cock behind her.",
			"attributeDogMorphDrink",
			Colour.ATTRIBUTE_FITNESS,
			30,
			Rarity.UNCOMMON,
			TFEssence.ARCANE,
			Util.newArrayListOfValues(new ListValue<>(new ItemEffect(ItemEffectType.FIT_CANINE_CRUSH, null, null, null, 0)))) {

		private static final long serialVersionUID = 1L;

		@Override
		public ItemEffectType getEnchantmentEffect() {
			return ItemEffectType.ATTRIBUTE_FITNESS;
		}

		@Override
		public AbstractItemType getEnchantmentItemType(List<ItemEffect> effects) {
			return POTION;
		}

		@Override
		public String getUseName() {
			return "drink";
		}

		@Override
		public String getUseDescription(GameCharacter user, GameCharacter target) {
<<<<<<< Upstream, based on upstream/master
			return getGenericUseDescription(user, target,
					"You pop off the cap and start drinking the bottle of 'Canine Crush'."
						+ " It doesn't taste anything like any other beer you've ever drank, and it reminds you more of a sugary energy drink rather than any alcoholic beverage."
						+ " As the last few drops slide down your throat, a strange, musky aftertaste lingers on your tongue.",
					"Popping off the cap, you bring the bottle of 'Canine Crush' to [npc.name]'s lips, before tilting [npc.her] head back and forcing [npc.herHim] to quickly gulp down the liquid.",
					"[npc.Name] pulls out a bottle of 'Canine Crush', and, after quickly popping off the cap, [npc.she] promptly downs the entire bottle.",
					"[npc.Name] pulls out a bottle of 'Canine Crush', and, after quickly popping off the cap, [npc.she] brings it to your lips before tilting your head back and forcing you to quickly gulp down the contents."
						+ " It doesn't taste anything like any other beer you've ever drank, and it reminds you more of a sugary energy drink rather than any alcoholic beverage."
							+ " As the last few drops slide down your throat, a strange, musky aftertaste lingers on your tongue.");
		}

		@Override
		public boolean isCommonItem() {
			return true;
=======
			if (user!=null && user.isPlayer() && target.isPlayer()) {
				return "<p>"
							+ "You pop off the cap and start drinking the bottle of 'Canine Crush'."
							+ " It doesn't taste anything like any other beer you've ever drank, and it reminds you more of a sugary energy drink rather than any alcoholic beverage."
							+ " As the last few drops slide down your throat, a strange, musky aftertaste lingers on your tongue."
						+ "</p>";
				
			} else {
				return UtilText.parse(target,
						"<p>"
							+ "[npc.Name] pulls out a bottle of 'Canine Crush', and, after quickly popping off the cap, [npc.she] promptly downs the entire bottle."
						+ "</p>");
			}
>>>>>>> 78d186e upstream
		}
	};
	
	public static AbstractItemType FIT_INGREDIENT_SQUIRREL_JAVA = new AbstractItemType(
			"a bottle of",
			false,
			"Squirrel Java",
			"Squirrel Javas",
			"A glass bottle of what looks to be some kind of coffee."
				+ " A label on the front shows a squirrel-girl fingering herself over the top of a bottle just like this one; her juices dripping down into the coffee to provide some extra cream.",
			"attributeSquirrelMorphDrink",
			Colour.ATTRIBUTE_FITNESS,
			30,
			Rarity.UNCOMMON,
			TFEssence.ARCANE,
			Util.newArrayListOfValues(new ListValue<>(new ItemEffect(ItemEffectType.FIT_SQUIRREL_JAVA, null, null, null, 0)))) {

		private static final long serialVersionUID = 1L;

		@Override
		public ItemEffectType getEnchantmentEffect() {
			return ItemEffectType.ATTRIBUTE_FITNESS;
		}

		@Override
		public AbstractItemType getEnchantmentItemType(List<ItemEffect> effects) {
			return POTION;
		}

		@Override
		public String getUseName() {
			return "drink";
		}

		@Override
		public String getUseDescription(GameCharacter user, GameCharacter target) {
<<<<<<< Upstream, based on upstream/master
			return getGenericUseDescription(user, target,
					"You unscrew the cap and start drinking the bottle of 'Squirrel Java'."
						+ " The taste is quite unlike that of any other coffee you've ever drunk, and it reminds you more of a sugary energy drink rather than any caffeinated beverage."
						+ " As the last few drops slide down your throat, a strange, sweet aftertaste lingers on your tongue.",
					"Unscrewing the cap, you bring the bottle of 'Squirrel Java' to [npc.name]'s lips, before tilting [npc.her] head back and forcing [npc.herHim] to quickly gulp down the liquid.",
					"[npc.Name] pulls out a bottle of 'Squirrel Java', and, after quickly unscrewing the cap, [npc.she] promptly downs the entire bottle.",
					"[npc.Name] pulls out a bottle of 'Squirrel Java', and, after quickly unscrewing the cap, [npc.she] brings it to your lips before tilting your head back and forcing you to quickly gulp down the contents."
						+ " The taste is quite unlike that of any other coffee you've ever drunk, and it reminds you more of a sugary energy drink rather than any caffeinated beverage."
						+ " As the last few drops slide down your throat, a strange, sweet aftertaste lingers on your tongue.");
		}

		@Override
		public boolean isCommonItem() {
			return true;
		}
	};
	
	public static AbstractItemType FIT_INGREDIENT_EGG_NOG = new AbstractItemType(
			"a bottle of",
			false,
			"Rudolph's Egg nog",
			"Rudolph's Egg nogs",
			"A carton of 'Rudolph's Egg Nog'."
				+ " A label on the front shows the drink's namesake, a buff, stark-naked reindeer-boy, drinking a glass of this carton's contents while receiving oral sex from three enraptured reindeer-girls.",
			"attributeReindeerMorphDrink",
			Colour.ATTRIBUTE_FITNESS,
			30,
			Rarity.UNCOMMON,
			TFEssence.ARCANE,
			Util.newArrayListOfValues(new ListValue<>(new ItemEffect(ItemEffectType.FIT_EGG_NOG, null, null, null, 0)))) {

		private static final long serialVersionUID = 1L;

		@Override
		public ItemEffectType getEnchantmentEffect() {
			return ItemEffectType.ATTRIBUTE_FITNESS;
		}

		@Override
		public AbstractItemType getEnchantmentItemType(List<ItemEffect> effects) {
			return POTION;
		}

		@Override
		public String getUseName() {
			return "drink";
		}

		@Override
		public String getUseDescription(GameCharacter user, GameCharacter target) {
			return getGenericUseDescription(user, target,
					"You open the carton and start drinking the bottle of 'Rudolph's Egg Nog'."
						+ " Although the creamy, sweet taste is similar to that of the egg nog you remember drinking in your old world,"
						+ " as you finish gulping down the last of the carton's contents, you find that a strange, slightly salty aftertaste lingers on your tongue.",
					"Opening the carton, you bring the bottle of 'Rudolph's Egg Nog' to [npc.name]'s lips, before tilting [npc.her] head back and forcing [npc.herHim] to quickly gulp down the liquid.",
					"[npc.Name] pulls out a carton of 'Rudolph's Egg Nog', and, after quickly opening it, [npc.she] promptly downs the entire bottle.",
					"[npc.Name] pulls out a carton of 'Rudolph's Egg Nog', and, after quickly opening it, [npc.she] brings it to your lips before tilting your head back and forcing you to quickly gulp down the contents."
						+ " Although the creamy, sweet taste is similar to that of the egg nog you remember drinking in your old world,"
						+ " as you finish gulping down the last of the carton's contents, you find that a strange, slightly salty aftertaste lingers on your tongue.");
		}

		@Override
		public boolean isCommonItem() {
			return false; // Seasonal item
=======
			if (user!=null && user.isPlayer() && target.isPlayer()) {
				return "<p>"
							+ "You unscrew the cap and start drinking the bottle of 'Squirrel Java'."
							+ " Its taste is quite unlike that of any other coffee you've ever drunk, and it reminds you more of a sugary energy drink rather than any caffeinated beverage."
							+ " As the last few drops slide down your throat, a strange, sweet aftertaste lingers on your tongue."
						+ "</p>";
				
			} else {
				return UtilText.parse(target,
						"<p>"
							+ "[npc.Name] pulls out a bottle of 'Squirrel Java', and, after quickly popping off the cap, [npc.she] promptly downs the entire bottle."
						+ "</p>");
			}
		}
	};
	
	public static AbstractItemType FIT_INGREDIENT_EGG_NOG = new AbstractItemType(
			"a bottle of",
			false,
			"Rudolph's Egg nog",
			"Rudolph's Egg nogs",
			"A carton of 'Rudolph's Egg Nog'."
				+ " A label on the front shows the drink's namesake, a buff, stark-naked reindeer-boy, drinking a glass of this carton's contents while receiving oral sex from three enraptured reindeer-girls.",
			"attributeReindeerMorphDrink",
			Colour.ATTRIBUTE_FITNESS,
			25,
			Rarity.UNCOMMON,
			TFEssence.ARCANE,
			Util.newArrayListOfValues(new ListValue<>(new ItemEffect(ItemEffectType.FIT_EGG_NOG, null, null, null, 0)))) {

		private static final long serialVersionUID = 1L;

		@Override
		public ItemEffectType getEnchantmentEffect() {
			return ItemEffectType.ATTRIBUTE_FITNESS;
		}

		@Override
		public AbstractItemType getEnchantmentItemType() {
			return POTION;
		}

		@Override
		public String getUseName() {
			return "drink";
		}

		@Override
		public String getUseDescription(GameCharacter user, GameCharacter target) {
			if (user!=null && user.isPlayer() && target.isPlayer()) {
				return "<p>"
							+ "You open the carton and start drinking the bottle of 'Rudolph's Egg Nog'."
							+ " Although the creamy, sweet taste is similar to that of the egg nog you remember drinking in your old world,"
								+ " as you finish gulping down the last of the carton's contents, you find that a strange, slightly salty aftertaste lingers on your tongue."
						+ "</p>";
				
			} else {
				return UtilText.parse(target,
						"<p>"
							+ "[npc.Name] pulls out a carton of 'Rudolph's Egg Nog', and, after quickly opening the top, [npc.she] promptly gulps down all of the contents."
						+ "</p>");
			}
>>>>>>> 78d186e upstream
		}
	};
	
	public static AbstractItemType SEX_INGREDIENT_HARPY_PERFUME = new AbstractItemType(
			"a bottle of",
			false,
			"Harpy Perfume",
			"Harpy Perfumes",
			"A glass bottle of what looks to be a kind of feminine perfume."
				+ " There's a stylised image of a harpy's wings on the front of the bottle.",
			"attributeHarpyPerfume",
			Colour.GENERIC_SEX,
			30,
			Rarity.UNCOMMON,
			TFEssence.ARCANE,
			Util.newArrayListOfValues(new ListValue<>(new ItemEffect(ItemEffectType.SEX_HARPY_PERFUME, null, null, null, 0)))) {

		private static final long serialVersionUID = 1L;

		@Override
		public ItemEffectType getEnchantmentEffect() {
			return ItemEffectType.ATTRIBUTE_SEXUAL;
		}

		@Override
		public AbstractItemType getEnchantmentItemType(List<ItemEffect> effects) {
			return POTION;
		}

		@Override
		public String getUseName() {
			return "spray";
		}

		@Override
		public String getUseDescription(GameCharacter user, GameCharacter target) {
<<<<<<< Upstream, based on upstream/master
			return getGenericUseDescription(user, target,
					"You take in a deep breath of an intoxicating feminine scent as you spray a little squirt of the 'Harpy Perfume' onto your neck."
						+ " Looking down at the curiously now-empty bottle of perfume, you feel a bubbly wave of excitement running through you, and without thinking, you find yourself letting out a very girly giggle.",
					"You spray a little squirt of the 'Harpy Perfume' onto [npc.name]'s neck.",
					"[npc.Name] pulls out a bottle of 'Harpy Perfume', and, after quickly popping off the cap, [npc.she] promptly sprays a little squirt onto [npc.her] neck.",
					"[npc.Name] pulls out a bottle of 'Harpy Perfume', and, after quickly popping off the cap, [npc.she] sprays a little squirt onto your neck."
						+ " You instantly feel a bubbly wave of excitement running through you, and without thinking, you find yourself letting out a very girly giggle.");
		}

		@Override
		public boolean isCommonItem() {
			return true;
		}
	};
	
	public static AbstractItemType SEX_INGREDIENT_MINCE_PIE = new AbstractItemType(
			"a",
			false,
			"mince pie",
			"mince pies",
			"A sweet pie, filled with a mixture of dried fruits and spices."
					+ " Curiously, the pie seems to remain permanently warm to the touch, revealing that an enchantment of some sort must have been placed on it...",
			"attributeNoRaceMincePie",
			Colour.GENERIC_SEX,
			30,
			Rarity.UNCOMMON,
			TFEssence.ARCANE,
			Util.newArrayListOfValues(new ListValue<>(new ItemEffect(ItemEffectType.SEX_MINCE_PIE, null, null, null, 0)))) {

		private static final long serialVersionUID = 1L;

		@Override
		public ItemEffectType getEnchantmentEffect() {
			return ItemEffectType.ATTRIBUTE_SEXUAL;
		}

		@Override
		public AbstractItemType getEnchantmentItemType(List<ItemEffect> effects) {
			return POTION;
		}

		@Override
		public String getUseName() {
			return "eat";
		}

		@Override
		public String getUseDescription(GameCharacter user, GameCharacter target) {
			return getGenericUseDescription(user, target,
					"You bring the enchanted mince pie up to your mouth, before taking an experimental bite."
						+ " The warm, spiced fruit filling is absolutely delicious, leading you to greedily wolf down the entire pie.",
					"You bring the enchanted mince pie up to [npc.name]'s mouth, before feeding it to [npc.herHim].",
					"[npc.Name] pulls out a mince pie, and promptly wolfs it down.",
					"[npc.Name] brings an enchanted mince pie up to your mouth, before starting to feed it to you."
						+ " The warm, spiced fruit filling is absolutely delicious, and you greedily wolf down the entire pie.");
		}

		@Override
		public boolean isCommonItem() {
			return false; // Seasonal item
=======
			if (user!=null && user.isPlayer() && target.isPlayer()) {
				return "<p>"
							+ "You take in a deep breath of an intoxicating feminine scent as you spray a little squirt of the 'Harpy Perfume' onto your neck."
							+ " Looking down at the curiously now-empty bottle of perfume, you feel a bubbly wave of excitement running through you, and without thinking, you find yourself letting out a very girly giggle."
						+ "</p>";
				
			} else {
				return UtilText.parse(target,
						"<p>"
							+ "[npc.Name] pulls out a bottle of 'Harpy Perfume', and, after quickly popping off the cap, [npc.she] promptly sprays a little squirt onto [npc.her] neck."
						+ "</p>");
			}
>>>>>>> 78d186e upstream
		}
	};
	
	// Corruption ingredients are "mysterious liquids" (cum and milk...):
	
	public static AbstractItemType COR_INGREDIENT_LILITHS_GIFT = new AbstractItemType("a bottle of",
			false,
			"Lilith's Gift",
			"Lilith's Gifts",
			"A glass bottle, filled with bubbling pink liquid."
					+ " On the bottle's label, there is an image of Lilith's perfectly-formed, heart-shaped ass."
					+ " Her delicate hands are reaching down to pull apart her soft ass cheeks, fully exposing her asshole and pussy, both of which are dripping wet from excitement.",
			"attributeDemonDrink",
			Colour.ATTRIBUTE_CORRUPTION,
			50,
			Rarity.UNCOMMON,
			TFEssence.ARCANE,
			Util.newArrayListOfValues(new ListValue<>(new ItemEffect(ItemEffectType.COR_LILITHS_GIFT, null, null, null, 0)))) {

		private static final long serialVersionUID = 1L;

		@Override
		public ItemEffectType getEnchantmentEffect() {
			return ItemEffectType.ATTRIBUTE_CORRUPTION;
		}

		@Override
		public AbstractItemType getEnchantmentItemType(List<ItemEffect> effects) {
			return POTION;
		}

		@Override
		public String getUseName() {
			return "drink";
		}

		@Override
		public String getUseDescription(GameCharacter user, GameCharacter target) {
<<<<<<< Upstream, based on upstream/master
			return getGenericUseDescription(user, target,
					"The moment you pull the stopper out from the top of the bottle of 'Lilith's Gift', you're filled with a desperate need to drink the bubbling pink liquid contained within."
							+ " Instantly, you bring the bottle to your lips and gulp it all down, suppressing your gag reflex as your senses are overwhelmed by how sickeningly sweet it is.",
					"You pull the stopper out from the top of the bottle of 'Lilith's Gift', before bringing it to [npc.name]'s lips and forcing [npc.herHim] to drink down the liquid within.",
					"[npc.Name] pulls out a bottle of 'Lilith's Gift', and, after quickly pulling out the stopper, [npc.she] promptly downs the entire bottle.",
					"[npc.Name] pulls out a bottle of 'Lilith's Gift', and, after quickly pulling out the stopper, [npc.she] brings it to your lips before tilting your head back and forcing you to quickly gulp down the contents."
						+ " You suppress your gag reflex as your senses are suddenly overwhelmed by the sickeningly-sweet liquid.");
		}

		@Override
		public boolean isCommonItem() {
			return true;
=======
			if (user!=null && user.isPlayer())
				return "<p>"
							+ "The moment you pull the stopper out from the top of the bottle of 'Lilith's Gift', you're filled with a desperate need to drink the bubbling pink liquid contained within."
							+ " Instantly, you bring the bottle to your lips and gulp it all down, suppressing your gag reflex as your senses are overwhelmed by how sickeningly sweet it is."
						+ "</p>";
			else
				return UtilText.parse(user,
						"<p>"
								+ "[npc.Name] pulls out a bottle of 'Lilith's Gift', and, after quickly pulling out the stopper, [npc.she] promptly downs the entire bottle."
						+ "</p>");
>>>>>>> 78d186e upstream
		}
	};
	
	public static AbstractItemType FETISH_UNREFINED = new AbstractItemType("a vial of",
			false,
			"Mystery Kink",
			"Mystery Kinks",
			"A delicate glass bottle, filled with a viscous, glowing-pink liquid."
					+ " It's quite clear just from its appearance that it carries a potent enchantment, and from the label on one side reading 'Mystery Kink', it's quite safe to assume that it somehow influences the drinker's fetishes.",
			"fetishDrink",
			Colour.GENERIC_SEX,
			500,
			Rarity.EPIC,
			TFEssence.ARCANE,
			Util.newArrayListOfValues(new ListValue<>(new ItemEffect(ItemEffectType.MYSTERY_KINK, null, null, null, 0)))) {

		private static final long serialVersionUID = 1L;

		@Override
		public ItemEffectType getEnchantmentEffect() {
			return ItemEffectType.FETISH_ENHANCEMENT;
		}

		@Override
		public AbstractItemType getEnchantmentItemType(List<ItemEffect> effects) {
			return FETISH_REFINED;
		}

		@Override
		public String getUseName() {
			return "drink";
		}

		@Override
		public String getUseDescription(GameCharacter user, GameCharacter target) {
<<<<<<< Upstream, based on upstream/master
			return getGenericUseDescription(user, target,
					"You pull the stopper out from the top of the bottle of 'Mystery Kink', before bringing it to your lips and gulping down the thick pink liquid that's contained within.",
					"You pull the stopper out from the top of the bottle of 'Mystery Kink', before bringing it to [npc.name]'s lips and forcing [npc.herHim] to drink down the liquid within.",
					"[npc.Name] pulls out a bottle of 'Mystery Kink', and, after quickly pulling out the stopper, [npc.she] promptly downs the entire bottle.",
					"[npc.Name] pulls out a bottle of 'Mystery Kink', and, after quickly pulling out the stopper,"
							+ " [npc.she] brings it to your lips before tilting your head back and forcing you to quickly gulp down the thick pink liquid that's contained within.");
		}

		@Override
		public boolean isCommonItem() {
			return true;
=======
			if (user!=null && user.isPlayer()) {
				if(target.isPlayer()) {
					return "<p>"
								+ "You unscrew the bottle's cap, before lifting it to your lips and gulping down the thick pink liquid that's contained within..."
							+ "</p>";
				} else {
					return UtilText.parse(target,"<p>"
							+ "You unscrew the bottle's cap, before lifting it to [npc.name]'s [npc.lips] and making [npc.herHim] drink down all of the thick pink liquid that's contained within..."
						+ "</p>");
				}
			} else {
				return UtilText.parse(user,
						"<p>"
								+ "[npc.Name] pulls out a bottle of 'Lilith's Gift', and, after quickly pulling out the stopper, [npc.she] promptly downs the entire bottle."
						+ "</p>");
			}
>>>>>>> 78d186e upstream
		}
	};
	
	public static AbstractItemType FETISH_REFINED = new AbstractItemType("a vial of",
			false,
			"Fetish Endowment",
			"Fetish Endowments",
			"A vial of bubbling pink liquid, which was refined from a bottle of 'Mystery Kink'."
					+ " Its potent enchantment is far more refined than that of the liquid it was distilled from, and is able to add or remove specific fetishes.",
			"fetishDrinkRefined",
			Colour.FETISH,
			750,
			Rarity.LEGENDARY,
			null,
			null) {

		private static final long serialVersionUID = 1L;

		@Override
		public boolean isTransformative() {
			return true;
		}
		
		@Override
		public boolean isAbleToBeUsedInSex() {
			return true;
		}

		@Override
		public boolean isAbleToBeUsedInCombat() {
			return true;
		}

		@Override
		public String getUseName() {
			return "drink";
		}

		@Override
		public String getUseDescription(GameCharacter user, GameCharacter target) {
<<<<<<< Upstream, based on upstream/master
			return getGenericUseDescription(user, target,
					"You pull the stopper out from the top of the glass vial of 'Fetish Endowment', before bringing it to your lips and gulping down the sickly sweet liquid that's contained within.",
					"You pull the stopper out from the top of the glass vial of 'Fetish Endowment', before bringing it to [npc.name]'s lips and forcing [npc.herHim] to drink down the liquid within.",
					"[npc.Name] pulls out a glass vial of 'Fetish Endowment', and, after quickly pulling out the stopper, [npc.she] promptly downs the entire bottle.",
					"[npc.Name] pulls out a glass vial of 'Fetish Endowment', and, after quickly pulling out the stopper,"
							+ " [npc.she] brings it to your lips before tilting your head back and forcing you to quickly gulp down the sickly sweet liquid that's contained within.");
		}

		@Override
		public boolean isCommonItem() {
			return false;
=======
			if (target.isPlayer()) {
				return "<p>"
							+ "You pull out the little stopper from the top of the glass vial, and quickly gulp down the sickly sweet liquid contained within..."
						+ "</p>";
				
			} else {
				return UtilText.parse(target,
						"<p>"
							+ "You pull out the little stopper from the top of the glass vial, and make [npc.name] gulp down the sickly sweet liquid contained within..."
						+ "</p>");
			}
>>>>>>> 78d186e upstream
		}
	};
	
	public static AbstractItemType ADDICTION_REMOVAL = new AbstractItemType("a bottle of",
			false,
			"Angel's Nectar",
			"Angel's Nectars",
			"A delicate crystal bottle, filled with a cool, blue liquid."
					+ " Engraved into one side are the words 'Angel's Nectar', although you're unsure if this fluid really does have anything to do with them...",
			"addictionRemoval",
			Colour.BASE_BLUE_LIGHT,
			750,
			Rarity.LEGENDARY,
			null,
			Util.newArrayListOfValues(new ListValue<>(new ItemEffect(ItemEffectType.ADDICTION_REMOVAL, null, null, null, 0)))) {

		private static final long serialVersionUID = 1L;

		@Override
		public boolean isAbleToBeUsedInSex() {
			return true;
		}

		@Override
		public boolean isAbleToBeUsedInCombat() {
			return true;
		}

		@Override
		public String getUseName() {
			return "drink";
		}

		@Override
		public String getUseDescription(GameCharacter user, GameCharacter target) {
<<<<<<< Upstream, based on upstream/master
			return getGenericUseDescription(user, target,
					"You pull the crystal stopper out from the top of the bottle of 'Angel's Nectar', before bringing it to your lips and gulping down the tasteless liquid that's contained within.",
					"You pull the crystal stopper out from the top of the bottle of 'Angel's Nectar', before bringing it to [npc.name]'s lips and forcing [npc.herHim] to drink down the liquid within.",
					"[npc.Name] pulls out a bottle of 'Angel's Nectar', and, after quickly pulling out the crystal stopper, [npc.she] promptly downs the entire bottle.",
					"[npc.Name] pulls out a bottle of 'Angel's Nectar', and, after quickly pulling out the crystal stopper,"
							+ " [npc.she] brings it to your lips before tilting your head back and forcing you to quickly gulp down the tasteless liquid that's contained within.");
		}

		@Override
		public boolean isCommonItem() {
			return true;
=======
			if (target.isPlayer()) {
				return "<p>"
							+ "You pull out the crystal stopper from the top of the bottle, before quickly gulping down the tasteless liquid contained within..."
						+ "</p>";
				
			} else {
				return UtilText.parse(target,
						"<p>"
							+ "You pull out the little stopper from the top of the glass vial, and make [npc.name] gulp down the tasteless liquid contained within..."
						+ "</p>");
			}
>>>>>>> 78d186e upstream
		}
	};
	
	// Racial ingredients:
	
	public static AbstractItemType RACE_INGREDIENT_DEMON = new AbstractItemType(
			"a bottle of",
			false,
			"Innoxia's Gift",
			"Innoxia's Gifts",
			"A glass bottle, filled with bubbling golden liquid."
					+ " Someone's stuck a crude little sticker to one side of the bottle, and as you look closer, you see that it reads: 'Temporary item! Demon TFs don't work like this!'",
			"raceDemonInnoxiasGift",
			Colour.ATTRIBUTE_CORRUPTION,
			500,
			Rarity.LEGENDARY,
			TFEssence.ARCANE,
			Util.newArrayListOfValues(new ListValue<>(new ItemEffect(ItemEffectType.RACE_INNOXIAS_GIFT, null, null, null, 0)))) {

		private static final long serialVersionUID = 1L;

		@Override
		public ItemEffectType getEnchantmentEffect() {
			return ItemEffectType.RACE_DEMON;
		}

		@Override
		public AbstractItemType getEnchantmentItemType(List<ItemEffect> effects) {
			return ELIXIR;
		}

		@Override
		public String getUseName() {
			return "drink";
		}

		@Override
		public String getUseDescription(GameCharacter user, GameCharacter target) {
<<<<<<< Upstream, based on upstream/master
			return getGenericUseDescription(user, target,
					"The moment you pull the stopper out from the top of the bottle of 'Innoxia's Gift', you're filled with a desperate need to drink the bubbling pink liquid contained within."
							+ " Instantly, you bring the bottle to your lips and gulp it all down, suppressing your gag reflex as your senses are overwhelmed by how sickeningly sweet it is.",
					"You pull the stopper out from the top of the bottle of 'Innoxia's Gift', before bringing it to [npc.name]'s lips and forcing [npc.herHim] to drink down the liquid within.",
					"[npc.Name] pulls out a bottle of 'Innoxia's Gift', and, after quickly pulling out the stopper, [npc.she] promptly downs the entire bottle.",
					"[npc.Name] pulls out a bottle of 'Innoxia's Gift', and, after quickly pulling out the stopper, [npc.she] brings it to your lips before tilting your head back and forcing you to quickly gulp down the contents."
						+ " You suppress your gag reflex as your senses are suddenly overwhelmed by the sickeningly-sweet liquid.");
		}

		@Override
		public boolean isCommonItem() {
			return true;
=======
			if (user!=null && user.isPlayer()) {
				return "<p>"
							+ "The moment you pull the stopper out from the top of the bottle of 'Innoxia's Gift', you're filled with a desperate need to drink the bubbling golden liquid contained within."
							+ " Instantly, you bring the bottle to your lips and gulp it all down, suppressing your gag reflex as your senses are overwhelmed by how sickeningly sweet it is."
						+ "</p>";
			} else {
				return UtilText.parse(user,
						"<p>"
							+ "[npc.Name] pulls out a bottle of 'Innoxia's Gift', and, after quickly pulling out the stopper, [npc.she] promptly downs the entire bottle."
							+ " <i>How did [npc.she] get this?!</i>"
						+ "</p>");
			}
>>>>>>> 78d186e upstream
		}
	};
	
	public static AbstractItemType RACE_INGREDIENT_HUMAN = new AbstractItemType(
			"a vial of",
			false,
			"Angel's Tears",
			"Angel's Tears",
			"A delicate glass vial full of a light turquoise liquid."
					+ " There's an image of a weeping angel engraved into the glass, and you see that her tears are falling into a vial just like this one.",
			"raceHumanAngelsTears",
			Colour.RACE_HUMAN,
			75,
			Rarity.RARE,
			TFEssence.ARCANE,
			Util.newArrayListOfValues(new ListValue<>(new ItemEffect(ItemEffectType.RACE_ANGELS_TEARS, null, null, null, 0)))) {

		private static final long serialVersionUID = 1L;

		@Override
		public ItemEffectType getEnchantmentEffect() {
			return ItemEffectType.RACE_HUMAN;
		}

		@Override
		public AbstractItemType getEnchantmentItemType(List<ItemEffect> effects) {
			return ELIXIR;
		}

		@Override
		public String getUseName() {
			return "drink";
		}

		@Override
		public String getUseDescription(GameCharacter user, GameCharacter target) {
<<<<<<< Upstream, based on upstream/master
			return getGenericUseDescription(user, target,
					"You pull out the little glass stopper and bring the vial of 'Angel's Tears' to your lips."
							+ " The faint scent of roses rises up from the opening, and you find yourself letting out a gentle sigh as you tilt back your head before drinking down the cool liquid.",
					"You pull out the little glass stopper and bring the vial of 'Angel's Tears' to [npc.name]'s lips, before forcing [npc.herHim] to drink down the liquid within.",
					"[npc.Name] pulls out a bottle of 'Angel's Tears', and, after quickly pulling out the stopper, [npc.she] promptly downs the entire bottle.",
					"[npc.Name] pulls out a bottle of 'Angel's Tears', and, after quickly pulling out the stopper, [npc.she] brings it to your lips before tilting your head back and forcing you to quickly gulp down the contents."
						+ " The faint scent of roses rises up from the opening, and you find yourself letting out a gentle sigh as you drink down the cool liquid.");
		}

		@Override
		public boolean isCommonItem() {
			return true;
=======
			if (user!=null && user.isPlayer() && target.isPlayer()) {
				return "<p>"
							+ "You pull out the little glass stopper and bring the vial to your lips."
							+ " The faint scent of roses rises up from the opening, and you find yourself letting out a gentle sigh as you tilt back your head before drinking down the cool liquid."
						+ "</p>";
				
			} else {
				return UtilText.parse(target,
						"<p>"
						+ "[npc.Name] pulls out a vial of 'Angel's Tears', and, pulling out the little glass stopper, quickly gulps down the pale turquoise liquid contained within."
						+ "</p>");
			}
>>>>>>> 78d186e upstream
		}
	};
	
	public static AbstractItemType RACE_INGREDIENT_CAT_MORPH = new AbstractItemType(
			"a",
			false,
			"Kitty's Reward",
			"Kitty's Rewards",
			"A small, square food tin with a ring-pull lid."
					+ " A label on the side shows a greater cat-girl devouring a plate of what looks to be this can's contents; some sort of tinned salmon.",
			"raceCatMorphKittysReward",
			Colour.RACE_CAT_MORPH,
			60,
			Rarity.RARE,
			TFEssence.ARCANE,
			Util.newArrayListOfValues(new ListValue<>(new ItemEffect(ItemEffectType.RACE_KITTYS_REWARD, null, null, null, 0)))) {

		private static final long serialVersionUID = 1L;

		@Override
		public ItemEffectType getEnchantmentEffect() {
			return ItemEffectType.RACE_CAT_MORPH;
		}

		@Override
		public AbstractItemType getEnchantmentItemType(List<ItemEffect> effects) {
			return ELIXIR;
		}

		@Override
		public String getUseName() {
			return "eat";
		}

		@Override
		public String getUseDescription(GameCharacter user, GameCharacter target) {
<<<<<<< Upstream, based on upstream/master
			return getGenericUseDescription(user, target,
					"You pull back the ring-pull and peel off the lid to the can of 'Kitty's Reward'."
						+ " A rich, fishy smell accompanies the sight of what looks to be tinned salmon, and you find yourself unable to resist the delicious-looking meat."
						+ " You quickly wolf down the can's contents, finding that it was as delicious as it looked.",
					"You pull out the can of 'Kitty's Reward', and, after pulling off the lid, force [npc.name] to eat the fishy contents.",
					"[npc.Name] pulls out a can of 'Kitty's Reward', and, after peeling off the lid, quickly devours the contents.",
					"[npc.Name] pulls out a can of 'Kitty's Reward', and, after peeling off the lid, [npc.she] forces you to eat the contents."
						+ " A rich, fishy smell accompanies the sight of what looks to be tinned salmon, and you soon find yourself greedily gulping down the delicious meat.");
		}

		@Override
		public boolean isCommonItem() {
			return true;
=======
			if (user!=null && user.isPlayer() && target.isPlayer()) {
				return "<p>"
							+ "You pull back the ring-pull and peel off the can's lid."
							+ " A rich, fishy smell accompanies the sight of what looks to be tinned salmon, and you find yourself unable to resist the delicious-looking meat."
							+ " You quickly wolf down the can's contents, finding that it was as delicious as it looked."
						+ "</p>";
				
			} else {
				return UtilText.parse(target,
						"<p>"
						+ "[npc.Name] pulls out a can of 'Kitty's Reward', and, peeling off the lid, quickly devours the contents."
						+ "</p>");
			}
>>>>>>> 78d186e upstream
		}
	};
	

	public static AbstractItemType RACE_INGREDIENT_COW_MORPH  = new AbstractItemType(
			"a pot of",
			false,
			"Bubble Cream",
			"Bubble Creams",
			"A small pot of yoghurt, with a black-and-white cow-pattern styled onto the lid."
					+ " A label on the side declares it to be 'Bubble Cream', which seems to be a little misleading, as there isn't any sort of bubbling going on in the creamy mixture contained within.",
			"raceCowMorphBubbleCream",
			Colour.RACE_COW_MORPH,
			60,
			Rarity.RARE,
			TFEssence.ARCANE,
			Util.newArrayListOfValues(new ListValue<>(new ItemEffect(ItemEffectType.RACE_BUBBLE_CREAM, null, null, null, 0)))) {

		private static final long serialVersionUID = 1L;

		@Override
		public ItemEffectType getEnchantmentEffect() {
			return ItemEffectType.RACE_COW_MORPH;
		}

		@Override
		public AbstractItemType getEnchantmentItemType(List<ItemEffect> effects) {
			return ELIXIR;
		}

		@Override
		public String getUseName() {
			return "eat";
		}

		@Override
		public String getUseDescription(GameCharacter user, GameCharacter target) {
<<<<<<< Upstream, based on upstream/master
			return getGenericUseDescription(user, target,
					"You peel back the foil lid to reveal the pot's contents."
						+ " Despite this product being called 'Cream', it's actually a thick yoghurt that's contained within."
						+ " Detaching the tiny wooden spoon that was stuck to one side, you eagerly dig in to the creamy mixture,"
							+ " letting out satisfied little humming noises as you discover that it's quite possibly the most delicious yoghurt that you've ever tasted.",
					"You pull out the pot of 'Bubble Cream', and, after pulling off the lid, force [npc.name] to eat the contents.",
					"[npc.Name] pulls out a pot of 'Bubble Cream', and, after peeling off the lid, quickly devours the contents.",
					"[npc.Name] pulls out a pot of 'Bubble Cream', and, after peeling off the lid, [npc.she] forces you to eat the contents."
						+ " Despite this product being called 'Cream', it's actually a thick yoghurt that's contained within."
						+ " Detaching the tiny wooden spoon that was stuck to one side, you eagerly dig in to the creamy mixture,"
							+ " letting out satisfied little humming noises as you discover that it's quite possibly the most delicious yoghurt that you've ever tasted.");
		}

		@Override
		public boolean isCommonItem() {
			return true;
=======
			if (user!=null && user.isPlayer() && target.isPlayer()) {
				return "<p>"
							+ "You peel back the foil lid to reveal the pot's contents."
							+ " Despite this product being called 'Cream', it's actually a thick yoghurt that's contained within."
							+ " Detaching the tiny wooden spoon that was stuck to one side, you eagerly dig in to the creamy mixture,"
								+ " letting out satisfied little humming noises as you discover that it's quite possibly the most delicious yoghurt that you've ever tasted."
						+ "</p>";
				
			} else {
				return UtilText.parse(target,
						"<p>"
							+ "[npc.Name] pulls out a pot of Bubble Cream, and, after tearing off the foil lid, [npc.she] quickly wolfs down the thick yoghurt contained within."
						+ "</p>");
			}
>>>>>>> 78d186e upstream
		}
	};
	

	public static AbstractItemType RACE_INGREDIENT_SQUIRREL_MORPH = new AbstractItemType(
			"a bag of",
			false,
			"Round Nuts",
			"Round Nuts",
			"A small bag of round nuts. A label on one side shows a greater squirrel-girl stuffing a handful of nuts into her mouth.",
			"raceSquirrelMorphRoundNuts",
			Colour.RACE_SQUIRREL_MORPH,
			60,
			Rarity.RARE,
			TFEssence.ARCANE,
			Util.newArrayListOfValues(new ListValue<>(new ItemEffect(ItemEffectType.RACE_ROUND_NUTS, null, null, null, 0)))) {

		private static final long serialVersionUID = 1L;

		@Override
		public ItemEffectType getEnchantmentEffect() {
			return ItemEffectType.RACE_SQUIRREL_MORPH;
		}

		@Override
		public AbstractItemType getEnchantmentItemType(List<ItemEffect> effects) {
			return ELIXIR;
		}

		@Override
		public String getUseName() {
			return "eat";
		}

		@Override
		public String getUseDescription(GameCharacter user, GameCharacter target) {
<<<<<<< Upstream, based on upstream/master
			return getGenericUseDescription(user, target,
					"You pull at the sides of one end of the bag, and open the package."
						+ " A rich, earthy smell accompanies the sight of the nuts inside, and you find yourself unable to resist the delicious-looking display."
						+ " You quickly wolf down the bag's contents, finding that the nuts are as delicious as they look.",
					"You pull out the bag of 'Round Nuts', and, after tearing it open, force [npc.name] to eat the contents.",
					"[npc.Name] pulls out a bag of 'Round Nuts', and, after tearing it open, quickly devours the contents.",
					"[npc.Name] pulls out a bag of 'Round Nuts', and, after tearing it open, [npc.she] forces you to eat the contents."
						+ " A rich, earthy smell accompanies the sight of the nuts inside, and you find yourself unable to resist the delicious-looking display."
						+ " You quickly wolf down the bag's contents, finding that the nuts are as delicious as they look.");
		}

		@Override
		public boolean isCommonItem() {
			return true;
=======
			if (user!=null && user.isPlayer() && target.isPlayer()) {
				return "<p>"
							+ "You pull at the sides of one end of the bag, and open the package."
							+ " A rich, earthy smell accompanies the sight of the round nights inside, and you find yourself unable to resist the delicious-looking display."
							+ " You quickly wolf down the bag's contents, finding that the nuts are as delicious as they look."
						+ "</p>";
				
			} else {
				return UtilText.parse(target,
						"<p>"
								+ "[npc.Name] pulls out a bag of 'Round Nuts', and, opening the bag, quickly devours the contents."
						+ "</p>");
			}
>>>>>>> 78d186e upstream
		}
	};
	
	public static AbstractItemType RACE_INGREDIENT_DOG_MORPH = new AbstractItemType(
			"a",
			false,
			"Canine Crunch",
			"Canine Crunches",
			"An individually-wrapped biscuit in the shape of a bone.",
			"raceDogMorphCanineCrunch",
			Colour.RACE_DOG_MORPH,
			60,
			Rarity.RARE,
			TFEssence.ARCANE,
			Util.newArrayListOfValues(new ListValue<>(new ItemEffect(ItemEffectType.RACE_CANINE_CRUNCH, null, null, null, 0)))) {

		private static final long serialVersionUID = 1L;

		@Override
		public ItemEffectType getEnchantmentEffect() {
			return ItemEffectType.RACE_DOG_MORPH;
		}

		@Override
		public AbstractItemType getEnchantmentItemType(List<ItemEffect> effects) {
			return ELIXIR;
		}

		@Override
		public String getUseName() {
			return "eat";
		}

		@Override
		public String getUseDescription(GameCharacter user, GameCharacter target) {
<<<<<<< Upstream, based on upstream/master
			return getGenericUseDescription(user, target,
					"You peel back the paper packaging and pop the 'Canine Crunch' into your mouth."
						+ " As you crunch down on the dry biscuit, you find that it's quite bland and salty.",
					"You pull out the 'Canine Crunch', and, after tearing off the packaging, force [npc.name] to eat it.",
					"[npc.Name] pulls out a 'Canine Crunch', and, quickly unwrapping the paper packaging, proceeds to wolf down the bone-shaped biscuit.",
					"[npc.Name] pulls out a 'Canine Crunch', and, after tearing off the paper packaging, [npc.she] forces you to eat it."
						+ " As you crunch down on the dry biscuit, you find that it's quite bland and salty.");
		}

		@Override
		public boolean isCommonItem() {
			return true;
=======
			if (user!=null && user.isPlayer() && target.isPlayer()) {
				return "<p>"
						+ "You peel back the paper packaging and pop the Canine Crunch into your mouth."
						+ " As you crunch down on the dry biscuit, you find that it's quite bland and salty."
						+ "</p>";
				
			} else {
				return UtilText.parse(target,
						"<p>"
						+ "[npc.Name] pulls out a Canine Crunch, and, quickly unwrapping the paper packaging, proceeds to wolf down the bone-shaped biscuit."
						+ "</p>");
			}
>>>>>>> 78d186e upstream
		}
	};

	public static AbstractItemType RACE_INGREDIENT_HORSE_MORPH = new AbstractItemType(
			"a",
			false,
			"Sugar Carrot Cube",
			"Sugar Carrot Cubes",
			"An individually-wrapped sugar cube, which, except for the fact that it's bright orange and smells of carrots, appears to be identical to every other sugar cube you've seen.",
			"raceHorseMorphSugarCarrotCube",
			Colour.RACE_HORSE_MORPH,
			60,
			Rarity.RARE,
			TFEssence.ARCANE,
			Util.newArrayListOfValues(new ListValue<>(new ItemEffect(ItemEffectType.RACE_SUGAR_CARROT_CUBE, null, null, null, 0)))) {

		private static final long serialVersionUID = 1L;

		@Override
		public ItemEffectType getEnchantmentEffect() {
			return ItemEffectType.RACE_HORSE_MORPH;
		}

		@Override
		public AbstractItemType getEnchantmentItemType(List<ItemEffect> effects) {
			return ELIXIR;
		}

		@Override
		public String getUseName() {
			return "eat";
		}

		@Override
		public String getUseDescription(GameCharacter user, GameCharacter target) {
<<<<<<< Upstream, based on upstream/master
			return getGenericUseDescription(user, target,
					"You peel off the paper packaging and pop the 'Sugar Carrot Cube' into your mouth."
							+ " The strong taste of carrots instantly fills your mouth, but before you have any time to relish the flavour, you find that it's dissolved in your saliva, and you've gulped down the sugary mess.",
					"You pull out the 'Sugar Carrot Cube', and, after tearing off the packaging, force [npc.name] to eat it.",
					"[npc.Name] pulls out a 'Sugar Carrot Cube', and, quickly unwrapping the paper packaging, pops it into [npc.her] mouth and swallows it down.",
					"[npc.Name] pulls out a 'Sugar Carrot Cube', and, after tearing off the paper packaging, [npc.she] forces you to eat it."
						+ " The strong taste of carrots instantly fills your mouth, but before you have any time to relish the flavour, you find that it's dissolved in your saliva, and you've gulped down the sugary mess.");
		}

		@Override
		public boolean isCommonItem() {
			return true;
		}
	};
	
	public static AbstractItemType RACE_INGREDIENT_REINDEER_MORPH = new AbstractItemType(
			"a",
			false,
			"Sugar Cookie",
			"Sugar Cookies",
			"An individually-wrapped, icing-and-sprinkles-topped sugar cookie, which looks, rather surprisingly, extremely normal.",
			"raceReindeerMorphSugarCookie",
			Colour.RACE_REINDEER_MORPH,
			60,
			Rarity.RARE,
			TFEssence.ARCANE,
			Util.newArrayListOfValues(new ListValue<>(new ItemEffect(ItemEffectType.RACE_SUGAR_COOKIE, null, null, null, 0)))) {

		private static final long serialVersionUID = 1L;

		@Override
		public ItemEffectType getEnchantmentEffect() {
			return ItemEffectType.RACE_REINDEER_MORPH;
		}

		@Override
		public AbstractItemType getEnchantmentItemType(List<ItemEffect> effects) {
			return ELIXIR;
		}

		@Override
		public String getUseName() {
			return "eat";
		}

		@Override
		public String getUseDescription(GameCharacter user, GameCharacter target) {
			return getGenericUseDescription(user, target,
					"You unwrap the 'Sugar Cookie' from its protective packaging and pop it into your mouth."
						+ " Although it looked normal enough, you soon discover that the taste is anything but, being both extremely sweet and salty at the same time."
						+ " Despite the unusual combination of flavours, it's tasty enough, and you soon find yourself having eaten the whole cookie.",
					"You pull out the 'Sugar Cookie', and, after tearing off the packaging, force [npc.name] to eat it.",
					"[npc.Name] pulls out a 'Sugar Cookie', and, quickly unwrapping the paper packaging, pops it into [npc.her] mouth and swallows it down.",
					"[npc.Name] pulls out a 'Sugar Cookie', and, after tearing off the paper packaging, [npc.she] forces you to eat it."
						+ " Although it looked normal enough, you soon discover that the taste is anything but, being both extremely sweet and salty at the same time."
						+ " Despite the unusual combination of flavours, it's tasty enough, and you soon find yourself having eaten the whole cookie.");
		}

		@Override
		public boolean isCommonItem() {
			return false; // Seasonal item
=======
			if (user!=null && user.isPlayer() && target.isPlayer()) {
				return "<p>"
							+ "You peel off the paper packaging and pop the Sugar Carrot Cube into your mouth."
							+ " The strong taste of carrots instantly fills your mouth, but before you have any time to relish the flavour, you find that it's dissolved in your saliva, and you've gulped down the sugary mess."
						+ "</p>";
				
			} else {
				return UtilText.parse(target,
						"<p>"
						+ "[npc.Name] pulls out a Sugar Carrot Cube, and, quickly peeling off the paper packaging, pops it into [npc.her] mouth and swallows it down."
						+ "</p>");
			}
		}
	};
	
	public static AbstractItemType RACE_INGREDIENT_REINDEER_MORPH = new AbstractItemType(
			"a",
			false,
			"Sugar Cookie",
			"Sugar Cookies",
			"An individually-wrapped, icing-and-sprinkles-topped sugar cookie, which looks, rather surprisingly, extremely normal.",
			"raceReindeerMorphSugarCookie",
			Colour.RACE_REINDEER_MORPH,
			40,
			Rarity.RARE,
			TFEssence.ARCANE,
			Util.newArrayListOfValues(new ListValue<>(new ItemEffect(ItemEffectType.RACE_SUGAR_COOKIE, null, null, null, 0)))) {

		private static final long serialVersionUID = 1L;

		@Override
		public ItemEffectType getEnchantmentEffect() {
			return ItemEffectType.RACE_REINDEER_MORPH;
		}

		@Override
		public AbstractItemType getEnchantmentItemType() {
			return ELIXIR;
		}

		@Override
		public String getUseName() {
			return "eat";
		}

		@Override
		public String getUseDescription(GameCharacter user, GameCharacter target) {
			if (user!=null && user.isPlayer() && target.isPlayer()) {
				return "<p>"
							+ "You unwrap the Sugar Cookie from its protective packaging and pop it into your mouth."
							+ " Although it looked normal enough, you soon discover that the taste is anything but, being both extremely sweet and salty at the same time."
							+ " Despite the unusual combination of flavours, it's tasty enough, and you soon find yourself having eaten the whole cookie."
						+ "</p>";
				
			} else {
				return UtilText.parse(target,
						"<p>"
								+ "[npc.Name] pulls out a Sugar Cookie, and, quickly unwrapping it from its protective packaging, pops it into [npc.her] mouth and swallows it down."
						+ "</p>");
			}
>>>>>>> 78d186e upstream
		}
	};
	
	public static AbstractItemType RACE_INGREDIENT_ALLIGATOR_MORPH = new AbstractItemType(
			"a",
			false,
			"Gator's Gumbo",
			"Gator's Gumbo",
			"An iron bowl, complete with a sealable lid."
				+ " The contents take the form of a delicious-smelling variety of gumbo, containing meat, okra, and a variety of other mysterious vegetables.",
			"raceGatorMorphGatorsGumbo",
			Colour.RACE_ALLIGATOR_MORPH,
			60,
			Rarity.RARE,
			TFEssence.ARCANE,
			Util.newArrayListOfValues(new ListValue<>(new ItemEffect(ItemEffectType.RACE_ALLIGATORS_GUMBO, null, null, null, 0)))) {

		private static final long serialVersionUID = 1L;

		@Override
		public ItemEffectType getEnchantmentEffect() {
			return ItemEffectType.RACE_ALLIGATOR_MORPH;
		}

		@Override
		public AbstractItemType getEnchantmentItemType(List<ItemEffect> effects) {
			return ELIXIR;
		}

		@Override
		public String getUseName() {
			return "eat";
		}

		@Override
		public String getUseDescription(GameCharacter user, GameCharacter target) {
<<<<<<< Upstream, based on upstream/master
			return getGenericUseDescription(user, target,
					"You remove the lid from the bowl of 'Gator's Gumbo' and start eating the rich meal contained within."
							+ " The delicious, slightly spicy taste of seafood instantly fills your mouth, but you don't take any time to really relish the flavour,"
							+ " as you can't help but greedily gulp down the tangy mess and move on to your next mouthful.",
					"You pull out the bowl of 'Gator's Gumbo', and, after removing the lid, force [npc.name] to eat the contents.",
					"[npc.Name] pulls out a bowl of 'Gator's Gumbo', and, quickly removing the lid, wolfs down the rich meal contained within.",
					"[npc.Name] pulls out a bowl of 'Gator's Gumbo', and, after quickly removing the lid, [npc.she] forces you to eat it."
						+ " The delicious, slightly spicy taste of seafood instantly fills your mouth, but you don't take any time to really relish the flavour,"
							+ " as you can't help but greedily gulp down the tangy mess and move on to your next mouthful.");
		}

		@Override
		public boolean isCommonItem() {
			return true;
=======
			if (user!=null && user.isPlayer() && target.isPlayer()) {
				return "<p>"
							+ "You remove the bowl's lid and start eating the rich gumbo contained within."
							+ " The delicious, slightly spicy taste of seafood instantly fills your mouth, but you don't take any time to really relish the flavour, as you can't help but greedily gulp down the tangy mess and move on to your next mouthful."
						+ "</p>";
				
			} else {
				return UtilText.parse(target,
						"<p>"
						+ "[npc.Name] pulls out a bowl of Gator's Gumbo, and, quickly removing the lid, shovels it onto [npc.her] mouth and swallows it down."
						+ "</p>");
			}
>>>>>>> 78d186e upstream
		}
	};
	
	public static AbstractItemType RACE_INGREDIENT_WOLF_MORPH = new AbstractItemType(
			"a package of",
			false,
			"Meat and Marrow",
			"Meat and Marrows",
			"A package of 'Meat and Marrow', which consists of a slab of some sort of raw meat, wrapped in grease-proof paper and tied up with brown string.",
			"raceWolfMorphMeatAndMarrow",
			Colour.RACE_WOLF_MORPH,
			60,
			Rarity.RARE,
			TFEssence.ARCANE,
			Util.newArrayListOfValues(new ListValue<>(new ItemEffect(ItemEffectType.RACE_MEAT_AND_MARROW, null, null, null, 0)))) {

		private static final long serialVersionUID = 1L;

		@Override
		public ItemEffectType getEnchantmentEffect() {
			return ItemEffectType.RACE_WOLF_MORPH;
		}

		@Override
		public AbstractItemType getEnchantmentItemType(List<ItemEffect> effects) {
			return ELIXIR;
		}

		@Override
		public String getUseName() {
			return "eat";
		}

		@Override
		public String getUseDescription(GameCharacter user, GameCharacter target) {
<<<<<<< Upstream, based on upstream/master
			return getGenericUseDescription(user, target,
					"You untie the brown string, and, peeling back the grease-proof paper, bring the now-exposed slab of meat to your mouth."
						+ " A rich, bloody smell rises to fill your nostrils, but instead of repulsing you, you find yourself drooling at the thought of eating the raw meat."
						+ " Without further thought, you greedily devour the dripping flesh, licking your fingers clean after rapidly finishing your impromptu meal.",
					"You pull out the package of 'Meat and Marrow', and, after peeling back the grease-proof paper, force [npc.name] to eat the contents.",
					"[npc.Name] pulls out a package of 'Meat and Marrow', and, tearing off the paper packaging, [npc.she] quickly devours the slab of raw meat that was stored within.",
					"[npc.Name] pulls out a package of 'Meat and Marrow', and, after quickly tearing off the paper packaging, [npc.she] forces you to eat it."
						+ " A rich, bloody smell rises to fill your nostrils, but instead of repulsing you, you find yourself drooling at the thought of eating the raw meat."
						+ " Without further thought, you greedily devour the dripping flesh, licking your fingers clean after rapidly finishing your impromptu meal.");
		}

		@Override
		public boolean isCommonItem() {
			return true;
=======
			if (user!=null && user.isPlayer() && target.isPlayer()) {
				return "<p>"
							+ "You untie the brown string, and, peeling back the grease-proof paper, bring the now-exposed slab of meat to your mouth."
							+ " A rich, bloody smell rises to fill your nostrils, but instead of repulsing you, you find yourself drooling at the thought of eating the raw meat."
							+ " Without further thought, you greedily devour the dripping flesh, licking your fingers clean after rapidly finishing your impromptu meal."
						+ "</p>";
				
			} else {
				return UtilText.parse(target,
						"<p>"
								+ "[npc.Name] pulls out a package of 'Meat & Marrow', and, tearing off the paper packaging, quickly devours the slab of raw meat that was stored within."
						+ "</p>");
			}
>>>>>>> 78d186e upstream
		}
	};
	
	public static AbstractItemType RACE_INGREDIENT_HARPY = new AbstractItemType(
			"a",
			false,
			"Bubblegum Lollipop",
			"Bubblegum Lollipops",
			"A bright pink lollipop, with a little ball of gum at its core."
				+ " Although it doesn't look out of the ordinary, it's somewhat unusual in the fact that it has an incredibly strong smell of bubblegum.",
			"raceHarpyLollipop",
			Colour.RACE_HARPY,
			60,
			Rarity.RARE,
			TFEssence.ARCANE,
			Util.newArrayListOfValues(new ListValue<>(new ItemEffect(ItemEffectType.RACE_LOLLIPOP, null, null, null, 0)))) {

		private static final long serialVersionUID = 1L;

		@Override
		public ItemEffectType getEnchantmentEffect() {
			return ItemEffectType.RACE_HARPY;
		}

		@Override
		public AbstractItemType getEnchantmentItemType(List<ItemEffect> effects) {
			return ELIXIR;
		}

		@Override
		public String getUseName() {
			return "suck";
		}

		@Override
		public String getUseDescription(GameCharacter user, GameCharacter target) {
<<<<<<< Upstream, based on upstream/master
			return getGenericUseDescription(user, target,
					"The moment you push the bright pink lollipop past your lips, your taste buds are overwhelmed by the sweet, sugary flavour of bubblegum."
						+ " Before you know what you're doing, you're letting out soft little feminine moans,"
							+ " which soon turn into desperate whines as you find yourself unable to think about anything other than wildly sucking on the object in your mouth.",
					"You pull out the 'Bubblegum Lollipop', and force [npc.name] to suck on it.",
					"[npc.Name] pulls out a 'Bubblegum Lollipop', and quickly shoves it into [npc.her] mouth.",
					"[npc.Name] pulls out a 'Bubblegum Lollipop', and, after quickly tearing off the plastic wrapper, [npc.she] forces it past your lips."
						+ " Before you know what you're doing, you're letting out soft little feminine moans,"
							+ " which soon turn into desperate whines as you find yourself unable to think about anything other than wildly sucking on the object in your mouth.");
		}

		@Override
		public boolean isCommonItem() {
			return true;
=======
			if (user!=null && user.isPlayer() && target.isPlayer()) {
				return "<p>"
						+ "The moment you push the bright pink lollipop past your lips, your taste buds are overwhelmed by the sweet, sugary flavour of bubblegum."
						+ " Before you know what you're doing, you're letting out soft little feminine moans, which soon turn into desperate whines as you find yourself unable to think about anything other than wildly sucking on the object in your mouth."
						+ "</p>";
				
			} else {
				return UtilText.parse(target,
						"<p>"
						+ "[npc.Name] pulls out a bright pink lollipop, and quickly shoves it into [npc.her] mouth."
						+ "</p>");
			}
>>>>>>> 78d186e upstream
		}
	};
	
	// Essence bottles:
	
//	BOTTLED_ESSENCE_ANGEL(
//			null,
//			false,
//			"Bottled Angel's Essence",
//			"A small glass bottle, with a little cork stopper wedged firmly in the top."
//					+ " Inside, there's a swirling  ",
//			"bottledEssenceAngel",
//			Colour.RARITY_LEGENDARY,
//			50,
//			Rarity.LEGENDARY,
//			null,
//			Util.newArrayListOfValues(new ListValue<>(new ItemEffect(ItemEffectType.BOTTLED_ESSENCE_ANGEL, null, null, null, 0)))) {
//
//		@Override
//		public String getUseName() {
//			return "suck";
//		}
//
//		@Override
//		public String getUseDescription(GameCharacter user, GameCharacter target) {
//			if (target.isPlayer()) {
//				return "<p>"
//							+ ""
//						+ "</p>";
//				
//			} else {
//				return "<p>"
//						+ "(You shouldn't be seeing this. x_x)"
//					+ "</p>";
//			}
//		}
//	};
	
	private static String getEssenceAbsorbtionText(Colour essenceColour, GameCharacter user, GameCharacter target) {
			if (user!=null && user.isPlayer()) {
				if(target!=null) {
					if(target.isPlayer()) {
						if(!Main.game.getDialogueFlags().values.contains(DialogueFlagValue.essenceBottledDiscovered)) {
							Main.game.getDialogueFlags().values.add(DialogueFlagValue.essenceBottledDiscovered);

							if(!Main.game.getPlayer().isQuestCompleted(QuestLine.SIDE_ENCHANTMENT_DISCOVERY)) {
								return "<p>"
											+ "Pulling the cork stopper out from the top of the little bottle, you let out a gasp as the swirling light instantly darts out of its glass prison."
											+ " Giving you no time to react, the essence immediately shoots straight towards you, and with a little "+essenceColour.getName()+" flash, it hits your chest and disappears from sight."
											+ " You think that it would probably be best to go and ask Lilaya about what just happened..."
										+ "</p>"
										+(!Main.game.getPlayer().hasQuest(QuestLine.SIDE_ENCHANTMENT_DISCOVERY)?Main.game.getPlayer().incrementQuest(QuestLine.SIDE_ENCHANTMENT_DISCOVERY):"");
							} else {
								return "<p>"
										+ "Pulling the cork stopper out from the top of the little bottle, you let out a gasp as the swirling light instantly darts out of its glass prison."
										+ " Giving you no time to react, the essence immediately shoots straight towards you, and with a little "+essenceColour.getName()+" flash, it hits your chest and disappears from sight."
										+ " You suddenly remember what Lilaya told you about absorbing essences, and breathe a sigh of relief..."
									+ "</p>";
							}
						}

						if(!Main.game.getPlayer().isQuestCompleted(QuestLine.SIDE_ENCHANTMENT_DISCOVERY)) {
							return "<p>"
										+ "Pulling the cork stopper out from the top of the little bottle, you release the arcane essence from its glass prison."
										+ " Drawn towards your powerful arcane aura, the essence immediately darts towards you, and with a little "+essenceColour.getName()+" flash, it disappears from sight."
										+ " You think that it would probably be best to go and ask Lilaya about what just happened..."
									+ "</p>";
						} else {
							return "<p>"
									+ "Pulling the cork stopper out from the top of the little bottle, you release the arcane essence from its glass prison."
									+ " Drawn towards your powerful arcane aura, the essence immediately darts towards you, and with a little "+essenceColour.getName()+" flash, it disappears from sight."
									+ " You feel a subtle change in your aura, letting you know that you've successfully absorbed the essence."
								+ "</p>";
						}
						
					} else {
						return UtilText.parse(target,
								"<p>"
									+ "Pulling the cork stopper out from the top of the little bottle, you release the arcane essence from its glass prison."
									+ " Drawn towards [npc.name]'s powerful arcane aura, the essence immediately darts towards [npc.herHim], and with a little "
										+essenceColour.getName()+" flash, it disappears from sight as it's absorbed into [npc.her] aura."
								+ "</p>");
					}
				} else {
					return "";
				}
				
			} else {
				if(target!=null) {
					if(target.isPlayer()) {
						if(!Main.game.getDialogueFlags().values.contains(DialogueFlagValue.essenceBottledDiscovered)) {
							Main.game.getDialogueFlags().values.add(DialogueFlagValue.essenceBottledDiscovered);

							if(!Main.game.getPlayer().isQuestCompleted(QuestLine.SIDE_ENCHANTMENT_DISCOVERY)) {
								return UtilText.parse(user,
										"<p>"
											+ "Pulling the cork stopper out from the top of the little bottle, [npc.name] releases an arcane essence from its glass prison."
											+ " Giving you no time to react, the essence immediately shoots straight towards you, and with a little "+essenceColour.getName()+" flash, it hits your chest and disappears from sight."
											+ " You think that it would probably be best to go and ask Lilaya about what just happened..."
										+ "</p>"
										+(!Main.game.getPlayer().hasQuest(QuestLine.SIDE_ENCHANTMENT_DISCOVERY)?Main.game.getPlayer().incrementQuest(QuestLine.SIDE_ENCHANTMENT_DISCOVERY):""));
							} else {
								return UtilText.parse(user,
										"<p>"
											+ "Pulling the cork stopper out from the top of the little bottle, [npc.name] releases an arcane essence from its glass prison."
											+ " Giving you no time to react, the essence immediately shoots straight towards you, and with a little "+essenceColour.getName()+" flash, it hits your chest and disappears from sight."
											+ " You suddenly remember what Lilaya told you about absorbing essences, and breathe a sigh of relief..."
										+ "</p>");
							}
						}

						if(!Main.game.getPlayer().isQuestCompleted(QuestLine.SIDE_ENCHANTMENT_DISCOVERY)) {
							return UtilText.parse(user,
									"<p>"
										+ "Pulling the cork stopper out from the top of the little bottle, [npc.name] releases an arcane essence from its glass prison."
										+ " Drawn towards your powerful arcane aura, the essence immediately darts towards you, and with a little "+essenceColour.getName()+" flash, it disappears from sight."
										+ " You think that it would probably be best to go and ask Lilaya about what just happened..."
									+ "</p>");
						} else {
							return UtilText.parse(user,
									"<p>"
										+ "Pulling the cork stopper out from the top of the little bottle, [npc.name] releases an arcane essence from its glass prison."
									+ " Drawn towards your powerful arcane aura, the essence immediately darts towards you, and with a little "+essenceColour.getName()+" flash, it disappears from sight."
									+ " You feel a subtle change in your aura, letting you know that you've successfully absorbed the essence."
								+ "</p>");
						}
						
					} else {
						return UtilText.parse(user, 
								"<p>"
									+ "Pulling the cork stopper out from the top of the little bottle, [npc.name] releases an arcane essence from its glass prison."
									+ " Drawn towards [npc.her] powerful arcane aura, the essence immediately darts towards [npc.name], and with a little "
										+essenceColour.getName()+" flash, it disappears from sight as it's absorbed into [npc.her] aura."
								+"</p>");
					}
				} else {
					return "";
				}
			}
		
		
	}
	
	public static AbstractItemType BOTTLED_ESSENCE_ARCANE = new AbstractItemType(
			null,
			false,
			"Bottled Arcane Essence",
			"Bottled Arcane Essences",
			"A small glass bottle, with a little cork stopper wedged firmly in the top."
					+ " Inside, the swirling "+Colour.GENERIC_ARCANE.getName()+" glow of an arcane essence flickers and swirls about in a mesmerising, cyclical pattern.",
			"bottledEssenceArcane",
			Colour.GENERIC_ARCANE,
			25,
			Rarity.EPIC,
			null,
			Util.newArrayListOfValues(new ListValue<>(new ItemEffect(ItemEffectType.BOTTLED_ESSENCE_ARCANE, null, null, null, 0)))) {

		private static final long serialVersionUID = 1L;

		@Override
		public String getUseName() {
			return "absorb";
		}

		@Override
		public String getUseDescription(GameCharacter user, GameCharacter target) {
			return getEssenceAbsorbtionText(Colour.GENERIC_ARCANE, user, target);
		}
		
		public boolean isAbleToBeUsed(GameCharacter target) {
			return target.getRace()==Race.DEMON || target.isPlayer();
		}
		
		public String getUnableToBeUsedDescription(GameCharacter target) {
			return "Only people with a demonic-strength aura are able to absorb arcane essences!";
		}

		@Override
		public boolean isCommonItem() {
			return false;
		}
	};
	
	public static AbstractItemType BOTTLED_ESSENCE_CAT_MORPH = new AbstractItemType(
			null,
			false,
			"Bottled Cat-morph Essence",
			"Bottled Cat-morph Essences",
			"A small glass bottle, with a little cork stopper wedged firmly in the top."
					+ " Inside, the swirling "+Colour.RACE_CAT_MORPH.getName()+" glow of an arcane essence, imbued with the energy of a cat-morph, flickers and swirls about in a mesmerising, cyclical pattern.",
			"bottledEssenceCatMorph",
			Colour.RACE_CAT_MORPH,
			50,
			Rarity.EPIC,
			null,
			Util.newArrayListOfValues(new ListValue<>(new ItemEffect(ItemEffectType.BOTTLED_ESSENCE_CAT_MORPH, null, null, null, 0)))) {

		private static final long serialVersionUID = 1L;

		@Override
		public String getUseName() {
			return "absorb";
		}

		@Override
		public String getUseDescription(GameCharacter user, GameCharacter target) {
			return getEssenceAbsorbtionText(Colour.RACE_CAT_MORPH, user, target);
		}
		
		public boolean isAbleToBeUsed(GameCharacter target) {
			return target.getRace()==Race.DEMON || target.isPlayer();
		}
		
		public String getUnableToBeUsedDescription(GameCharacter target) {
			return "Only people with a demonic-strength aura are able to absorb arcane essences!";
		}

		@Override
		public boolean isCommonItem() {
			return false;
		}
	};
	

	public static AbstractItemType BOTTLED_ESSENCE_COW_MORPH = new AbstractItemType(
			null,
			false,
			"Bottled Cow-morph Essence",
			"Bottled Cow-morph Essences",
			"A small glass bottle, with a little cork stopper wedged firmly in the top."
					+ " Inside, the swirling "+Colour.RACE_COW_MORPH.getName()+" glow of an arcane essence, imbued with the energy of a cow-morph, flickers and swirls about in a mesmerising, cyclical pattern.",
			"bottledEssenceCowMorph",
			Colour.RACE_COW_MORPH,
			50,
			Rarity.EPIC,
			null,
			Util.newArrayListOfValues(new ListValue<>(new ItemEffect(ItemEffectType.BOTTLED_ESSENCE_COW_MORPH, null, null, null, 0)))) {

		private static final long serialVersionUID = 1L;

		@Override
		public String getUseName() {
			return "absorb";
		}

		@Override
		public String getUseDescription(GameCharacter user, GameCharacter target) {
			return getEssenceAbsorbtionText(Colour.RACE_COW_MORPH, user, target);
		}
		
		public boolean isAbleToBeUsed(GameCharacter target) {
			return target.getRace()==Race.DEMON || target.isPlayer();
		}
		
		public String getUnableToBeUsedDescription(GameCharacter target) {
			return "Only people with a demonic-strength aura are able to absorb arcane essences!";
		}

		@Override
		public boolean isCommonItem() {
			return false;
		}
	};
	
	public static AbstractItemType BOTTLED_ESSENCE_DEMON = new AbstractItemType(

			null,
			false,
			"Bottled Demon Essence",
			"Bottled Demon Essences",
			"A small glass bottle, with a little cork stopper wedged firmly in the top."
					+ " Inside, the swirling "+Colour.RACE_DEMON.getName()+" glow of an arcane essence, imbued with the energy of a demon, flickers and swirls about in a mesmerising, cyclical pattern.",
			"bottledEssenceDemon",
			Colour.RACE_DEMON,
			40,
			Rarity.EPIC,
			null,
			Util.newArrayListOfValues(new ListValue<>(new ItemEffect(ItemEffectType.BOTTLED_ESSENCE_DEMON, null, null, null, 0)))) {

		private static final long serialVersionUID = 1L;

		@Override
		public String getUseName() {
			return "absorb";
		}

		@Override
		public String getUseDescription(GameCharacter user, GameCharacter target) {
			return getEssenceAbsorbtionText(Colour.RACE_DEMON, user, target);
		}
		
		public boolean isAbleToBeUsed(GameCharacter target) {
			return target.getRace()==Race.DEMON || target.isPlayer();
		}
		
		public String getUnableToBeUsedDescription(GameCharacter target) {
			return "Only people with a demonic-strength aura are able to absorb arcane essences!";
		}

		@Override
		public boolean isCommonItem() {
			return false;
		}
	};
	
	public static AbstractItemType BOTTLED_ESSENCE_ALLIGATOR_MORPH = new AbstractItemType(
			null,
			false,
			"Bottled Alligator-morph Essence",
			"Bottled Alligator-morph Essences",
			"A small glass bottle, with a little cork stopper wedged firmly in the top."
					+ " Inside, the swirling "+Colour.RACE_ALLIGATOR_MORPH.getName()+" glow of an alligator-morph essence flickers and swirls about in a mesmerising, cyclical pattern.",
			"bottledEssenceGatorMorph",
			Colour.RACE_ALLIGATOR_MORPH,
			50,
			Rarity.EPIC,
			null,
			Util.newArrayListOfValues(new ListValue<>(new ItemEffect(ItemEffectType.BOTTLED_ESSENCE_ALLIGATOR_MORPH, null, null, null, 0)))) {

		private static final long serialVersionUID = 1L;

		@Override
		public String getUseName() {
			return "absorb";
		}

		@Override
		public String getUseDescription(GameCharacter user, GameCharacter target) {
			return getEssenceAbsorbtionText(Colour.RACE_ALLIGATOR_MORPH, user, target);
		}

		@Override
		public boolean isCommonItem() {
			return false;
		}
	};
	

	public static AbstractItemType BOTTLED_ESSENCE_SQUIRREL_MORPH = new AbstractItemType(
			null,
			false,
			"Bottled Squirrel-morph Essence",
			"Bottled Squirrel-morph Essences",
			"A small glass bottle, with a little cork stopper wedged firmly in the top."
					+ " Inside, the swirling "+Colour.RACE_SQUIRREL_MORPH.getName()+" glow of an arcane essence, imbued with the energy of a squirrel-morph, flickers and swirls about in a mesmerising, cyclical pattern.",
			"bottledEssenceSquirrelMorph",
			Colour.RACE_SQUIRREL_MORPH,
			50,
			Rarity.EPIC,
			null,
			Util.newArrayListOfValues(new ListValue<>(new ItemEffect(ItemEffectType.BOTTLED_ESSENCE_SQUIRREL_MORPH, null, null, null, 0)))) {

		private static final long serialVersionUID = 1L;

		@Override
		public String getUseName() {
			return "absorb";
		}

		@Override
		public String getUseDescription(GameCharacter user, GameCharacter target) {
			return getEssenceAbsorbtionText(Colour.RACE_SQUIRREL_MORPH, user, target);
		}
		
		public boolean isAbleToBeUsed(GameCharacter target) {
			return target.getRace()==Race.DEMON || target.isPlayer();
		}
		
		public String getUnableToBeUsedDescription(GameCharacter target) {
			return "Only people with a demonic-strength aura are able to absorb arcane essences!";
		}

		@Override
		public boolean isCommonItem() {
			return false;
		}
	};
	
	public static AbstractItemType BOTTLED_ESSENCE_DOG_MORPH = new AbstractItemType(
			null,
			false,
			"Bottled Dog-morph Essence",
			"Bottled Dog-morph Essences",
			"A small glass bottle, with a little cork stopper wedged firmly in the top."
					+ " Inside, the swirling "+Colour.RACE_DOG_MORPH.getName()+" glow of an arcane essence, imbued with the energy of a dog-morph, flickers and swirls about in a mesmerising, cyclical pattern.",
			"bottledEssenceDogMorph",
			Colour.RACE_DOG_MORPH,
			50,
			Rarity.EPIC,
			null,
			Util.newArrayListOfValues(new ListValue<>(new ItemEffect(ItemEffectType.BOTTLED_ESSENCE_DOG_MORPH, null, null, null, 0)))) {

		private static final long serialVersionUID = 1L;

		@Override
		public String getUseName() {
			return "absorb";
		}

		@Override
		public String getUseDescription(GameCharacter user, GameCharacter target) {
			return getEssenceAbsorbtionText(Colour.RACE_DOG_MORPH, user, target);
		}
		
		public boolean isAbleToBeUsed(GameCharacter target) {
			return target.getRace()==Race.DEMON || target.isPlayer();
		}
		
		public String getUnableToBeUsedDescription(GameCharacter target) {
			return "Only people with a demonic-strength aura are able to absorb arcane essences!";
		}

		@Override
		public boolean isCommonItem() {
			return false;
		}
	};
	
	public static AbstractItemType BOTTLED_ESSENCE_HARPY = new AbstractItemType(
			null,
			false,
			"Bottled Harpy Essence",
			"Bottled Harpy Essences",
			"A small glass bottle, with a little cork stopper wedged firmly in the top."
					+ " Inside, the swirling "+Colour.RACE_HARPY.getName()+" glow of an arcane essence, imbued with the energy of a harpy, flickers and swirls about in a mesmerising, cyclical pattern.",
			"bottledEssenceHarpy",
			Colour.RACE_HARPY,
			20,
			Rarity.EPIC,
			null,
			Util.newArrayListOfValues(new ListValue<>(new ItemEffect(ItemEffectType.BOTTLED_ESSENCE_HARPY, null, null, null, 0)))) {

		private static final long serialVersionUID = 1L;

		@Override
		public String getUseName() {
			return "absorb";
		}

		@Override
		public String getUseDescription(GameCharacter user, GameCharacter target) {
			return getEssenceAbsorbtionText(Colour.RACE_HARPY, user, target);
		}
		
		public boolean isAbleToBeUsed(GameCharacter target) {
			return target.getRace()==Race.DEMON || target.isPlayer();
		}
		
		public String getUnableToBeUsedDescription(GameCharacter target) {
			return "Only people with a demonic-strength aura are able to absorb arcane essences!";
		}

		@Override
		public boolean isCommonItem() {
			return false;
		}
	};
	
	public static AbstractItemType BOTTLED_ESSENCE_HORSE_MORPH = new AbstractItemType(
			null,
			false,
			"Bottled Horse-morph Essence",
			"Bottled Horse-morph Essences",
			"A small glass bottle, with a little cork stopper wedged firmly in the top."
					+ " Inside, the swirling "+Colour.RACE_HORSE_MORPH.getName()+" glow of an arcane essence, imbued with the energy of a horse-morph, flickers and swirls about in a mesmerising, cyclical pattern.",
			"bottledEssenceHorseMorph",
			Colour.RACE_HORSE_MORPH,
			50,
			Rarity.EPIC,
			null,
			Util.newArrayListOfValues(new ListValue<>(new ItemEffect(ItemEffectType.BOTTLED_ESSENCE_HORSE_MORPH, null, null, null, 0)))) {

		private static final long serialVersionUID = 1L;

		@Override
		public String getUseName() {
			return "absorb";
		}

		@Override
		public String getUseDescription(GameCharacter user, GameCharacter target) {
<<<<<<< Upstream, based on upstream/master
			return getEssenceAbsorbtionText(Colour.RACE_HORSE_MORPH, user, target);
=======
			if (target.isPlayer()) {
				return getEssenceAbsorbtionText(Colour.RACE_HORSE_MORPH);
				
			} else {
				return UtilText.parse(target,
						"<p>"
							+ "Pulling the cork stopper out from the top of the little bottle, you release the arcane essence from its glass prison."
							+ " Drawn towards [npc.name]'s powerful arcane aura, the essence immediately darts towards [npc.herHim], and with a little "
								+Colour.RACE_HORSE_MORPH.getName()+" flash, it disappears from sight as it's absorbed into [npc.her] aura."
						+ "</p>");
			}
		}
		
		public boolean isAbleToBeUsed(GameCharacter target) {
			return target.getRace()==Race.DEMON || target.isPlayer();
		}
		
		public String getUnableToBeUsedDescription(GameCharacter target) {
			return "Only people with a demonic-strength aura are able to absorb arcane essences!";
		}
	};
	
	public static AbstractItemType BOTTLED_ESSENCE_REINDEER_MORPH = new AbstractItemType(
			null,
			false,
			"Bottled Reindeer-morph Essence",
			"Bottled Reindeer-morph Essences",
			"A small glass bottle, with a little cork stopper wedged firmly in the top."
					+ " Inside, the swirling "+Colour.RACE_REINDEER_MORPH.getName()+" glow of an arcane essence, imbued with the energy of a reindeer-morph, flickers and swirls about in a mesmerising, cyclical pattern.",
			"bottledEssenceReindeerMorph",
			Colour.RACE_REINDEER_MORPH,
			50,
			Rarity.EPIC,
			null,
			Util.newArrayListOfValues(new ListValue<>(new ItemEffect(ItemEffectType.BOTTLED_ESSENCE_REINDEER_MORPH, null, null, null, 0)))) {

		private static final long serialVersionUID = 1L;

		@Override
		public String getUseName() {
			return "absorb";
		}

		@Override
		public String getUseDescription(GameCharacter user, GameCharacter target) {
			if (target.isPlayer()) {
				return getEssenceAbsorbtionText(Colour.RACE_REINDEER_MORPH);
				
			} else {
				return UtilText.parse(target,
						"<p>"
							+ "Pulling the cork stopper out from the top of the little bottle, you release the arcane essence from its glass prison."
							+ " Drawn towards [npc.name]'s powerful arcane aura, the essence immediately darts towards [npc.herHim], and with a little "
								+Colour.RACE_REINDEER_MORPH.getName()+" flash, it disappears from sight as it's absorbed into [npc.her] aura."
						+ "</p>");
			}
>>>>>>> 78d186e upstream
		}
		
		public boolean isAbleToBeUsed(GameCharacter target) {
			return target.getRace()==Race.DEMON || target.isPlayer();
		}
		
		public String getUnableToBeUsedDescription(GameCharacter target) {
			return "Only people with a demonic-strength aura are able to absorb arcane essences!";
		}

		@Override
		public boolean isCommonItem() {
			return false;
		}
	};
	
	public static AbstractItemType BOTTLED_ESSENCE_REINDEER_MORPH = new AbstractItemType(
			null,
			false,
			"Bottled Reindeer-morph Essence",
			"Bottled Reindeer-morph Essences",
			"A small glass bottle, with a little cork stopper wedged firmly in the top."
					+ " Inside, the swirling "+Colour.RACE_REINDEER_MORPH.getName()+" glow of an arcane essence, imbued with the energy of a reindeer-morph, flickers and swirls about in a mesmerising, cyclical pattern.",
			"bottledEssenceReindeerMorph",
			Colour.RACE_REINDEER_MORPH,
			50,
			Rarity.EPIC,
			null,
			Util.newArrayListOfValues(new ListValue<>(new ItemEffect(ItemEffectType.BOTTLED_ESSENCE_REINDEER_MORPH, null, null, null, 0)))) {

		private static final long serialVersionUID = 1L;

		@Override
		public String getUseName() {
			return "absorb";
		}

		@Override
		public String getUseDescription(GameCharacter user, GameCharacter target) {
			return getEssenceAbsorbtionText(Colour.RACE_REINDEER_MORPH, user, target);
		}
		
		public boolean isAbleToBeUsed(GameCharacter target) {
			return target.getRace()==Race.DEMON || target.isPlayer();
		}
		
		public String getUnableToBeUsedDescription(GameCharacter target) {
			return "Only people with a demonic-strength aura are able to absorb arcane essences!";
		}

		@Override
		public boolean isCommonItem() {
			return false;
		}
	};
	
	public static AbstractItemType BOTTLED_ESSENCE_HUMAN = new AbstractItemType(
			null,
			false,
			"Bottled Human Essence",
			"Bottled Human Essences",
			"A small glass bottle, with a little cork stopper wedged firmly in the top."
					+ " Inside, the swirling "+Colour.RACE_HUMAN.getName()+" glow of an arcane essence, imbued with the energy of a human, flickers and swirls about in a mesmerising, cyclical pattern.",
			"bottledEssenceHuman",
			Colour.RACE_HUMAN,
			50,
			Rarity.EPIC,
			null,
			Util.newArrayListOfValues(new ListValue<>(new ItemEffect(ItemEffectType.BOTTLED_ESSENCE_HUMAN, null, null, null, 0)))) {

		private static final long serialVersionUID = 1L;

		@Override
		public String getUseName() {
			return "absorb";
		}

		@Override
		public String getUseDescription(GameCharacter user, GameCharacter target) {
			return getEssenceAbsorbtionText(Colour.RACE_HUMAN, user, target);
		}
		
		public boolean isAbleToBeUsed(GameCharacter target) {
			return target.getRace()==Race.DEMON || target.isPlayer();
		}
		
		public String getUnableToBeUsedDescription(GameCharacter target) {
			return "Only people with a demonic-strength aura are able to absorb arcane essences!";
		}

		@Override
		public boolean isCommonItem() {
			return false;
		}
	};
	
	public static AbstractItemType BOTTLED_ESSENCE_WOLF_MORPH = new AbstractItemType(
			null,
			false,
			"Bottled Wolf-morph Essence",
			"Bottled Wolf-morph Essences",
			"A small glass bottle, with a little cork stopper wedged firmly in the top."
					+ " Inside, the swirling "+Colour.RACE_WOLF_MORPH.getName()+" glow of an arcane essence, imbued with the energy of a wolf-morph, flickers and swirls about in a mesmerising, cyclical pattern.",
			"bottledEssenceWolfMorph",
			Colour.RACE_WOLF_MORPH,
			50,
			Rarity.EPIC,
			null,
			Util.newArrayListOfValues(new ListValue<>(new ItemEffect(ItemEffectType.BOTTLED_ESSENCE_WOLF_MORPH, null, null, null, 0)))) {

		private static final long serialVersionUID = 1L;

		@Override
		public String getUseName() {
			return "absorb";
		}

		@Override
		public String getUseDescription(GameCharacter user, GameCharacter target) {
			return getEssenceAbsorbtionText(Colour.RACE_WOLF_MORPH, user, target);
		}
		
		public boolean isAbleToBeUsed(GameCharacter target) {
			return target.getRace()==Race.DEMON || target.isPlayer();
		}
		
		public String getUnableToBeUsedDescription(GameCharacter target) {
			return "Only people with a demonic-strength aura are able to absorb arcane essences!";
		}

		@Override
		public boolean isCommonItem() {
			return false;
		}
	};
	
	
	
	// Specials:
	
	public static AbstractItemType HARPY_MATRIARCH_BIMBO_LOLLIPOP = new AbstractItemType(
			null,
			false,
			"[bimboHarpy.name]'s lollipop",
			"[bimboHarpy.name]'s lollipops",
			"A swirly lollipop that you got from the harpy matriarch [bimboHarpy.name]."
				+ " Although it doesn't look out of the ordinary, you're pretty sure that eating it would result in a potent transformation...",
			"bimboLollipop",
			Colour.RARITY_LEGENDARY,
			500,
			Rarity.LEGENDARY,
			null,
			Util.newArrayListOfValues(new ListValue<>(new ItemEffect(ItemEffectType.BIMBO_LOLLIPOP, null, null, null, 0)))) {

		private static final long serialVersionUID = 1L;
		
		@Override
		public boolean isTransformative() {
			return true;
		}

		@Override
		public String getUseName() {
			return "suck";
		}

		@Override
		public String getUseDescription(GameCharacter user, GameCharacter target) {
			return getGenericUseDescription(user, target,
					"Bringing the lollipop up to your [pc.lips+], you dart out your [pc.tongue] and give it a long, wet lick."
						+ " An intense, sweet flavour fills your mouth, quite unlike anything you've ever tasted before."
						+ " Before you know what you're doing, you're pressing your [pc.lips] up against the delicious candy, letting out little whining noises as you find yourself unable to stop sucking and licking it...",
					"Bringing the lollipop up to [npc.name]'s [npc.lips+], you smile as [npc.she] darts out [npc.her] [npc.tongue] to give it a long, wet lick."
						+ " The intoxicating taste quickly overwhelms [npc.her] senses, and [npc.she] eagerly presses [npc.her] [npc.lips] up against the delicious candy,"
						+ " letting out little whining noises as [npc.she] finds [npc.herself] unable to stop sucking and licking it...",
					"[npc.Name] produces a swirly lollipop and, after quickly pulling off the wrapper, starts licking and sucking it...",
					"[npc.Name] produces a swirly lollipop and, after quickly pulling off the wrapper, forces it against your [pc.lips] and into your mouth."
						+ " An intense, sweet flavour fills hits your tongue, quite unlike anything you've ever tasted before."
						+ " Before you know what you're doing, you're pressing your [pc.lips] up against the delicious candy, letting out little whining noises as you find yourself unable to stop sucking and licking it...");

		}

		@Override
		public boolean isCommonItem() {
			return false;
		}
	};
	
	public static AbstractItemType HARPY_MATRIARCH_NYMPHO_LOLLIPOP = new AbstractItemType(
			null,
			false,
			"[nymphoHarpy.name]'s lollipop",
			"[nymphoHarpy.name]'s lollipops",
			"A cock-shaped lollipop that you got from the harpy matriarch [nymphoHarpy.name]."
				+ " Although it looks to be made from regular candy, you're pretty sure that eating it would result in a potent transformation...",
			"nymphoLollipop",
			Colour.RARITY_LEGENDARY,
			500,
			Rarity.LEGENDARY,
			null,
			Util.newArrayListOfValues(new ListValue<>(new ItemEffect(ItemEffectType.NYMPHO_LOLLIPOP, null, null, null, 0)))) {

		private static final long serialVersionUID = 1L;
		
		@Override
		public boolean isTransformative() {
			return true;
		}

		@Override
		public String getUseName() {
			return "suck";
		}

		@Override
		public String getUseDescription(GameCharacter user, GameCharacter target) {
			return getGenericUseDescription(user, target,
					"Bringing the lollipop up to your [pc.lips+], you dart out your [pc.tongue] and give it a long, wet lick."
						+ " An intense, sweet flavour fills your mouth, quite unlike anything you've ever tasted before."
						+ " Before you know what you're doing, you're pushing the delicious, cock-shaped candy into your mouth, letting out lewd moans as you find yourself unable to stop sucking and licking it...",
					"Bringing the lollipop up to [npc.name]'s [npc.lips+], you smile as [npc.she] darts out [npc.her] [npc.tongue] to give it a long, wet lick."
						+ " The intoxicating taste quickly overwhelms [npc.her] senses, and [npc.she] eagerly wraps [npc.her] [npc.lips] around the delicious, cock-shaped candy,"
							+ " letting out lewd moans as [npc.she] finds [npc.herself] unable to stop sucking and licking it...",
					"[npc.Name] produces a cock-shaped lollipop and, after quickly pulling off the wrapper, starts licking and sucking it...",
					"[npc.Name] produces a cock-shaped lollipop and, after quickly pulling off the wrapper, forces it against your [pc.lips] and into your mouth."
							+ " An intense, sweet flavour fills your mouth, quite unlike anything you've ever tasted before."
							+ " Before you know what you're doing, you're pushing the delicious, cock-shaped candy into your mouth, letting out lewd moans as you find yourself unable to stop sucking and licking it...");
		}

		@Override
		public boolean isCommonItem() {
			return false;
		}
	};
	
	public static AbstractItemType HARPY_MATRIARCH_DOMINANT_PERFUME = new AbstractItemType(
			null,
			false,
			"[dominantHarpy.name]'s perfume",
			"[dominantHarpy.name]'s perfumes",
			"A bottle of perfume that you got from the harpy matriarch [dominantHarpy.name]."
				+ " Although it looks to contain normal perfume, you're pretty sure that using it would result in a potent transformation...",
			"dominantPerfume",
			Colour.RARITY_LEGENDARY,
			500,
			Rarity.LEGENDARY,
			null,
			Util.newArrayListOfValues(new ListValue<>(new ItemEffect(ItemEffectType.DOMINANT_PERFUME, null, null, null, 0)))) {

		private static final long serialVersionUID = 1L;
		
		@Override
		public boolean isTransformative() {
			return true;
		}
		
		@Override
		public String getUseName() {
			return "spray";
		}

		@Override
		public String getUseDescription(GameCharacter user, GameCharacter target) {
			return getGenericUseDescription(user, target,
					"Bringing the bottle of perfume up to your neck, you give it a little squirt."
							+ " Although only a small amount of liquid shoots out, the entire bottle's contents are instantly drained, leaving you holding an empty vessel."
							+ " As you look down at it in surprise, the strong, feminine scent rises up to overpower your senses,"
							+ " and you find yourself letting out a desperate moan as the nature of the perfume's powerful enchantment starts to make itself known...",
					"Bringing the bottle of perfume up to [npc.name]'s neck, you give it a little squirt."
							+ " Although only a small amount of liquid shoots out, the entire bottle's contents are instantly drained, leaving you holding an empty vessel."
							+ " As you look down at it in surprise, the strong, feminine scent rises up to overpower [npc.name]'s senses,"
							+ " and [npc.she] finds [npc.herself] letting out a desperate moan as the nature of the perfume's powerful enchantment starts to make itself known...",
					"[npc.Name] produces a bottle of perfume and, after quickly pulling off the cap, squirts some onto [npc.her] neck...",
					"[npc.Name] produces a bottle of perfume and, after quickly pulling off the cap, squirts some onto your neck."
						+ " Although only a small amount of liquid shoots out, the entire bottle's contents are instantly drained, leaving [npc.name] holding an empty vessel."
						+ " As you look down at it in surprise, the strong, feminine scent rises up to overpower your senses,"
							+ " and you find yourself letting out a desperate moan as the nature of the perfume's powerful enchantment starts to make itself known...");
			
		}

		@Override
		public boolean isCommonItem() {
			return false;
		}
	};
	
	
	// Crafting outputs:
	
	public static AbstractItemType POTION = new AbstractItemType("",
			false,
			"potion",
			"potions",
			"Refined potion.",
			"refined_potion_container",
			Colour.CLOTHING_PINK,
			25,
			Rarity.RARE,
			null,
			null) {

		private static final long serialVersionUID = 1L;

		@Override
		public boolean isTransformative() {
			return false;
		}
		
		@Override
		public boolean isAbleToBeUsedInSex() {
			return true;
		}

		@Override
		public boolean isAbleToBeUsedInCombat() {
			return true;
		}
		
		@Override
		public String getUseName() {
			return "drink";
		}

		@Override
		public String getUseDescription(GameCharacter user, GameCharacter target) {
<<<<<<< Upstream, based on upstream/master
			return getGenericUseDescription(user, target,
					"First removing the bottle's stopper, you then bring the potion up to your waiting lips."
						+ " A sweet smell rises from the opening, and, after gulping down the delicious liquid, you feel a strange tingling feeling spreading throughout your body as the potion's effects start to make themselves known...",
					"First removing the bottle's stopper, you then bring the potion up to [npc.name]'s waiting lips, before forcing [npc.herHim] to drink it all down.",
					"[npc.Name] pulls out a potion of some sort, and, after quickly removing the bottle's stopper, [npc.she] promptly gulps downs the contents.",
					"[npc.Name] brings the potion to your lips, before tilting your head back and forcing you to quickly gulp down the contents."
						+ " You feel a strange tingling feeling spreading throughout your body as the potion's effects start to make themselves known...");
		}

		@Override
		public boolean isCommonItem() {
			return false;
=======
			if (target.isPlayer()) {
				return "<p>"
							+ "After gulping down the sweet liquid, you feel a strange tingling feeling spreading throughout your body as the potion's effects start to make themselves known..."
						+ "</p>";
				
			} else {
				return UtilText.parse(target,
						"<p>"
							+ "After gulping down the sweet liquid, a strange tingling feeling spreads throughout [npc.name]'s body as the potion's effects start to make themselves known..."
						+ "</p>");
			}
>>>>>>> 78d186e upstream
		}
	};
	
	public static AbstractItemType ELIXIR = new AbstractItemType("",
			false,
			"elixir",
			"elixirs",
			"Refined elixir.",
			"refined_elixir_container",
			Colour.CLOTHING_PINK,
			25,
			Rarity.EPIC,
			null,
			null) {

		private static final long serialVersionUID = 1L;
		
		@Override
		public boolean isTransformative() {
			return true;
		}
		
		@Override
		public boolean isAbleToBeUsedInSex() {
			return true;
		}

		@Override
		public boolean isAbleToBeUsedInCombat() {
			return true;
		}

		@Override
		public String getUseName() {
			return "drink";
		}

		@Override
		public String getUseDescription(GameCharacter user, GameCharacter target) {
<<<<<<< Upstream, based on upstream/master
			return getGenericUseDescription(user, target,
					"First removing the bottle's stopper, you then bring the elixir up to your waiting lips."
						+ " A sweet smell rises from the opening, and, after gulping down the delicious liquid, you feel a strange tingling feeling spreading throughout your body as the elixir's effects start to make themselves known...",
					"First removing the bottle's stopper, you then bring the elixir up to [npc.name]'s waiting lips, before forcing [npc.herHim] to drink it all down.",
					"[npc.Name] pulls out an elixir of some sort, and, after quickly removing the stopper, [npc.she] promptly gulps downs the contents.",
					"[npc.Name] brings the elixir to your lips, before tilting your head back and forcing you to quickly gulp down the contents."
						+ " You feel a strange tingling feeling spreading throughout your body as the elixir's effects start to make themselves known...");
		}

		@Override
		public boolean isCommonItem() {
			return false;
=======
			if (target.isPlayer()) {
				return "<p>"
							+ "After gulping down the sweet liquid, you feel a strange tingling feeling spreading throughout your body as the elixir's effects start to make themselves known..."
						+ "</p>";
				
			} else {
				return UtilText.parse(target,
						"<p>"
							+ "After gulping down the sweet liquid, a strange tingling feeling spreads throughout [npc.name]'s body as the elixir's effects start to make themselves known..."
						+ "</p>");
			}
>>>>>>> 78d186e upstream
		}
	};
	
	
	// Non-TF:

	public static AbstractItemType DYE_BRUSH = new AbstractItemType("a",
			false,
			"dye-brush",
			"dye-brushes",
			"A small, very ordinary-looking brush, of the sort used for fine detailing on canvas or models."
					+ " On closer inspection, you notice a very faint purple glow emanating from the brush's tip, revealing its true nature as an arcane-enchanted dye-brush.",
			"dyeBrush",
			Colour.CLOTHING_WHITE,
			50,
			Rarity.EPIC,
			null,
			Util.newArrayListOfValues(new ListValue<>(new ItemEffect(ItemEffectType.DYE_BRUSH, null, null, null, 0)))) {

		private static final long serialVersionUID = 1L;

		@Override
		public String getUseName() {
			return "use";
		}
		
		@Override
		public boolean isAbleToBeUsedInSex() {
			return false;
		}

		@Override
		public boolean isAbleToBeUsedInCombat() {
			return false;
		}
		
		@Override
		public String getUseDescription(GameCharacter user, GameCharacter target) {
			return "<p>"
						+ "As you take hold of the Dye-brush, you see the purple glow around the tip growing in strength."
						+ " The closer you move it to a piece of clothing, the brighter the glow becomes, until suddenly, images of different colours start flashing through your mind."
						+ " As you touch the bristles to the piece of clothing, the Dye-brush instantly evaporates!"
						+ " You see that the arcane enchantment has dyed your piece of clothing the colour you wanted."
					+ "</p>";
		}

		@Override
		public boolean isAbleToBeUsedFromInventory() {
			return false;
		}

		@Override
		public boolean isCommonItem() {
			return true;
		}
	};

	public static AbstractItemType CONDOM_USED = new AbstractItemType("a",
			false,
			"used condom",
			"used condoms",
			"A used condom, tied at the top and filled with someone's cum. You'd have to be pretty dirty-minded to think of a use for this... <b>(Currently not implemented...)</b>",
			"condomUsed",
			Colour.CLOTHING_WHITE,
			0,
			Rarity.COMMON,
			null,
			Util.newArrayListOfValues(new ListValue<>(new ItemEffect(ItemEffectType.USED_CONDOM_DRINK, null, null, null, 0)))) {
		
		private static final long serialVersionUID = 1L;

		@Override
		public String getUseName() {
			return "drink";
		}

		@Override
		public String getUseDescription(GameCharacter user, GameCharacter target) {
<<<<<<< Upstream, based on upstream/master
			return getGenericUseDescription(user, target,
					"Untying the top of the used condom, you bring it up to your lips and swallow the slimy contents.",
					"Untying the top of the used condom, you bring it up to [npc.name]'s [npc.lips], and force [npc.her] to swallow the slimy contents.",
					"Untying the top of the used condom, [npc.name] brings it up to [npc.her] [npc.lips], and swallows the slimy contents.",
					"Untying the top of the used condom, [npc.name] brings it up to your [pc.lips], and forces you to swallow the slimy contents.");
=======
			if(user!=null && user.isPlayer()) {
				if(target.isPlayer()) {
					return "Untying the top of the used condom, you bring it up to your lips and swallow the slimy contents.";
				} else {
					return UtilText.parse(target, "Untying the top of the used condom, you bring it up to [npc.name]'s [npc.lips], and force [npc.her] to swallow the slimy contents.");
				}
			} else {
				if(target.isPlayer()) {
					return UtilText.parse(target, "Untying the top of the used condom, [npc.name] brings it up to your [pc.lips], and forces you to swallow the slimy contents.");
				} else {
					return UtilText.parse(target, "Untying the top of the used condom, [npc.name] brings it up to [npc.her] [npc.lips], and swallows the slimy contents.");
				}
			}
>>>>>>> 78d186e upstream
		}

		@Override
		public boolean isAbleToBeUsed(GameCharacter target) {
			return true;
		}

		@Override
		public String getUnableToBeUsedDescription(GameCharacter target) {
			return "You can't think of a use for this. Maybe it's best to throw it away...</br>"
					+ "(You need have at least a <b style='color:"+CorruptionLevel.THREE_DIRTY.getColour().toWebHexString()+";'>"+CorruptionLevel.THREE_DIRTY.getName()+"</b> level of corruption to know how to use this!)";
		}

		@Override
		public boolean isAbleToBeUsedInCombat() {
			return false;
		}

		@Override
		public boolean isAbleToBeUsedInSex() {
			return false;
		}

		@Override
		public boolean isCommonItem() {
			return false;
		}
	};

	public static AbstractItemType ARTHURS_PACKAGE = new AbstractItemType("",
			false,
			"Arthur's Package",
			"Arthur's Packages",
			"A package that you collected from Arcane Arts. You need to deliver this to Arthur.",
			"arthursPackage",
			Colour.ANDROGYNOUS,
			0,
			Rarity.LEGENDARY,
			null,
			null) {

		private static final long serialVersionUID = 1L;

		@Override
		public String getUseName() {
			return "inspect";
		}
		
		@Override
		public String getUseDescription(GameCharacter user, GameCharacter target) {
			return getGenericUseDescription(user, target,
					"The package is quite small, measuring roughly 20cm along each edge. It's constructed of brown cardboard, and sealed with packaging tape.",
					"The package is quite small, measuring roughly 20cm along each edge. It's constructed of brown cardboard, and sealed with packaging tape.",
					"The package is quite small, measuring roughly 20cm along each edge. It's constructed of brown cardboard, and sealed with packaging tape.",
					"The package is quite small, measuring roughly 20cm along each edge. It's constructed of brown cardboard, and sealed with packaging tape.");
		}
		
		@Override
		public boolean isConsumedOnUse() {
			return false;
		}
		
		@Override
		public boolean canBeSold() {
			return false;
		}

		@Override
		public boolean isCommonItem() {
			return false;
		}

	};
	
	public static AbstractItemType ORIENTATION_HYPNO_WATCH = new AbstractItemType("a",
			false,
			"Hypno-Watch",
			"Hypno-Watches",
			"A unique, incredibly-powerful arcane instrument. When enchanted, this Hypno-Watch has the ability to change a person's sexual orientation, at the cost of giving them a huge increase in corruption.",
			"hypnoClockBase",
			Colour.ANDROGYNOUS,
			50000,
			Rarity.LEGENDARY,
			TFEssence.ARCANE,
			Util.newArrayListOfValues(new ListValue<>(new ItemEffect(ItemEffectType.ORIENTATION_CHANGE, null, null, null, 0)))) {

		private static final long serialVersionUID = 1L;

		@Override
		public String getDeterminer() {
			return UtilText.generateSingularDeterminer(this.getName(false));
		}
		
		@Override
		public int getEnchantmentLimit() {
			return 1;
		}
		
		@Override
		public ItemEffectType getEnchantmentEffect() {
			return ItemEffectType.ORIENTATION_CHANGE;
		}

		@Override
		public AbstractItemType getEnchantmentItemType(List<ItemEffect> effects) {
			return ORIENTATION_HYPNO_WATCH;
		}
		
		@Override
		public String getUseName() {
			return "hypnotise";
		}
		
		@Override
		public String getUseDescription(GameCharacter user, GameCharacter target) {
			return getGenericUseDescription(user, target,
					"Taking hold of the delicate chain, you start slowly swinging the Hypno-Watch back and forth, fixating your gaze on the swirling face as you allow the item's arcane power to seep into your mind...",
					"Taking hold of the delicate chain, you start slowly swinging the Hypno-Watch back and forth in front of [npc.name]'s face, and,"
							+ " just as you'd hoped, [npc.she] fixates [npc.her] gaze on the swirling face, allowing the item's arcane power to seep into [npc.her] mind...",
					"Taking hold of the delicate chain, [npc.name] starts slowly swinging the Hypno-Watch back and forth, fixating [npc.her] gaze on the swirling face as [npc.she] allows the item's arcane power to seep into [npc.her] mind...",
					"Taking hold of the delicate chain, [npc.name] starts slowly swinging the Hypno-Watch back and forth in front of your face,"
							+ " and you find yourself unable to do anything but fixate your gaze on the swirling face as the item's arcane power seeps into your mind...");
		}
		
		@Override
		public boolean isConsumedOnUse() {
			return false;
		}

		@Override
		public boolean isCommonItem() {
			return false;
		}

	};
	
	public static AbstractItemType VIXENS_VIRILITY = new AbstractItemType("a",
			false,
			"Vixen's Virility",
			"Vixen's Virilities",
			"A small pill, packaged in a little foil and plastic wrapper. On the front of the foil, there's a small stylised picture of a heavily pregnant girl, lying back and smiling as she strokes her swollen belly.",
			"vixensVirility",
			Colour.CLOTHING_PINK,
			5,
			Rarity.COMMON,
			null,
			Util.newArrayListOfValues(new ListValue<>(new ItemEffect(ItemEffectType.VIXENS_VIRILITY, null, null, null, 0)))) {

		private static final long serialVersionUID = 1L;

		@Override
		public String getUseName() {
			return "swallow";
		}
		
		@Override
		public String getUseDescription(GameCharacter user, GameCharacter target) {
<<<<<<< Upstream, based on upstream/master
			return getGenericUseDescription(user, target,
					"Popping the little pink pill out of its foil wrapper, you quickly put it in your mouth and swallow it down.",
					"Popping the little pink pill out of its foil wrapper, you bring it up to [npc.name]'s [npc.lips], before forcing it into [npc.her] mouth and making sure that [npc.she] swallows it down.",
					"[npc.Name] pops a Vixen's Virility pill out of its little foil wrapper, before quickly placing it in [npc.her] mouth and swallowing it down.",
					"[npc.Name] pops a Vixen's Virility pill out of its little foil wrapper, before bringing it up to your [pc.lips], forcing it into your mouth, and making sure that you swallow it down.");
		}

		@Override
		public boolean isCommonItem() {
			return true;
=======
			if (user!=null && user.isPlayer())
				return "<p>"
							+ "Popping the little pink pill out of its foil wrapper, you quickly put it in your mouth and swallow it down."
						+ "</p>";
			else
				return UtilText.parse(user,
						"<p>"
							+ "[npc.Name] pops a <i>Vixen's Virility</i> pill out of its little foil wrapper, before quickly placing it in [npc.her] mouth and swallowing it down."
						+ "</p>");
>>>>>>> 78d186e upstream
		}

	};
	
	public static AbstractItemType PROMISCUITY_PILL = new AbstractItemType("a",
			false,
			"Promiscuity Pill",
			"Promiscuity Pills",
			"Commonly referred to as 'slut pills', this promiscuity pill is packaged in a foil and plastic wrapper."
					+ " On the front of the foil, there's a before-and-after picture of a girl's hungry pussy overflowing with cum."
					+ " The after image is of the girl showing off her flat stomach as she gives a thumbs up.",
			"vixensVirility",
			Colour.CLOTHING_BLUE,
			5,
			Rarity.COMMON,
			null,
			Util.newArrayListOfValues(new ListValue<>(new ItemEffect(ItemEffectType.PROMISCUITY_PILL, null, null, null, 0)))) {

		private static final long serialVersionUID = 1L;

		@Override
		public String getUseName() {
			return "swallow";
		}
		
		@Override
		public String getUseDescription(GameCharacter user, GameCharacter target) {
<<<<<<< Upstream, based on upstream/master
			return getGenericUseDescription(user, target,
					"Popping the little blue pill out of its foil wrapper, you quickly put it in your mouth and swallow it down.",
					"Popping the little blue pill out of its foil wrapper, you bring it up to [npc.name]'s [npc.lips], before forcing it into [npc.her] mouth and making sure that [npc.she] swallows it down.",
					"[npc.Name] pops a Promiscuity pill out of its little foil wrapper, before quickly placing it in [npc.her] mouth and swallowing it down.",
					"[npc.Name] pops a Promiscuity pill out of its little foil wrapper, before bringing it up to your [pc.lips], forcing it into your mouth, and making sure that you swallow it down.");
		}

		@Override
		public boolean isCommonItem() {
			return true;
=======
			if (user!=null && user.isPlayer())
				return "<p>"
							+ "Popping the little blue pill out of its foil wrapper, you quickly put it in your mouth and swallow it down."
						+ "</p>";
			else
				return UtilText.parse(user,
						"<p>"
							+ "[npc.Name] pops a <i>Promiscuity Pill</i> pill out of its little foil wrapper, before quickly placing it in [npc.her] mouth and swallowing it down."
						+ "</p>");
>>>>>>> 78d186e upstream
		}
	};
	
	public static AbstractItemType MOTHERS_MILK = new AbstractItemType("a bottle of",
			false,
			"Mother's Milk",
			"Mother's Milks",
			"A baby bottle filled with a rich, creamy milk."
			+ " On the side, a little sticker declares that this drink is able to speed up your pregnancy.",
			"mothers_milk",
			Colour.CLOTHING_WHITE,
			5,
			Rarity.COMMON,
			null,
			Util.newArrayListOfValues(new ListValue<>(new ItemEffect(ItemEffectType.MOTHERS_MILK, null, null, null, 0)))) {

		private static final long serialVersionUID = 1L;

		@Override
		public String getUseName() {
			return "drink";
		}
		
		@Override
		public String getUseDescription(GameCharacter user, GameCharacter target) {
<<<<<<< Upstream, based on upstream/master
			return getGenericUseDescription(user, target,
					"Bringing the bottle up to your [pc.lips], you take the teat-like opening into your mouth, before greedily starting to suckle down the creamy liquid within.",
					"Bringing the bottle up to [npc.name]'s [npc.lips], you push the teat-like opening into [npc.her] mouth, before forcing [npc.herHim] to suckle down the creamy liquid within.",
					"[npc.Name] produces a bottle of 'Mother's Milk', and, taking the teat-like opening into [npc.her] mouth, [npc.she] greedily starts to suckle down the creamy liquid within.",
					"[npc.Name] produces a bottle of 'Mother's Milk', and, pushing the teat-like opening into your mouth, [npc.she] forces you to suckle down the creamy liquid within.");
		}

		@Override
		public boolean isCommonItem() {
			return true;
=======
			if (user!=null && user.isPlayer())
				return "<p>"
							+ "Bringing the bottle up to your [pc.lips], you take the teat-like opening into your mouth, before greedily starting to suckle down the creamy liquid within."
						+ "</p>";
			else
				return UtilText.parse(user,
						"<p>"
							+ "[npc.Name] produces a bottle of <i>Mother's Milk</i>, and, taking the teat-like opening into [npc.her] mouth, [npc.she] greedily starts to suckle down the creamy liquid within."
						+ "</p>");
>>>>>>> 78d186e upstream
		}
	};
	
	public static AbstractItemType BOOK_CAT_MORPH = new AbstractItemType(
			null,
			false,
			"Curious Kitties",
			"Curious Kitties'",
			"A book that details cat-morph society.",
			"book_race_cat_morph",
			Colour.RACE_CAT_MORPH,
			10,
			Rarity.LEGENDARY,
			null,
			Util.newArrayListOfValues(new ListValue<>(new ItemEffect(ItemEffectType.BOOK_READ_CAT_MORPH, null, null, null, 0)))) {

		private static final long serialVersionUID = 1L;

		@Override
		public boolean isAbleToBeUsed(GameCharacter target) {
			return !Main.getProperties().isAdvancedRaceKnowledgeDiscovered(Race.CAT_MORPH);
		}

		@Override
		public String getUnableToBeUsedDescription(GameCharacter target) {
			return "You've already added this book to Lilaya's library! It would be best to just sell it...";
		}
		
		@Override
		public String getUseName() {
			return "read";
		}
		
		@Override
		public String getUseDescription(GameCharacter user, GameCharacter target) {
			return getGenericUseDescription(user, target,
					"Opening the book, you read its contents...",
					"Opening the book, you force [npc.name] to read its contents...",
					"[npc.Name] produces a book, titled 'Curious Kitties', which [npc.she] then starts to read...",
					"[npc.Name] produces a book, titled 'Curious Kitties', which [npc.she] then forces you to read...");
		}

		@Override
		public boolean isCommonItem() {
			return false;
		}
	};
	

	public static AbstractItemType BOOK_COW_MORPH = new AbstractItemType(
			null,
			false,
			"Milking Cows",
			"Milking Cows'",
			"A book that details cow-morph society.",
			"book_race_cow_morph",
			Colour.RACE_COW_MORPH,
			10,
			Rarity.LEGENDARY,
			null,
			Util.newArrayListOfValues(new ListValue<>(new ItemEffect(ItemEffectType.BOOK_READ_COW_MORPH, null, null, null, 0)))) {

		private static final long serialVersionUID = 1L;

		@Override
		public boolean isAbleToBeUsed(GameCharacter target) {
			return !Main.getProperties().isAdvancedRaceKnowledgeDiscovered(Race.COW_MORPH);
		}

		@Override
		public String getUnableToBeUsedDescription(GameCharacter target) {
			return "You've already added this book to Lilaya's library! It would be best to just sell it...";
		}
		
		@Override
		public String getUseName() {
			return "read";
		}
		
		@Override
		public String getUseDescription(GameCharacter user, GameCharacter target) {
			return getGenericUseDescription(user, target,
					"Opening the book, you read its contents...",
					"Opening the book, you force [npc.name] to read its contents...",
					"[npc.Name] produces a book, titled 'Milking Cows', which [npc.she] then starts to read...",
					"[npc.Name] produces a book, titled 'Milking Cows', which [npc.she] then forces you to read...");
		}

		@Override
		public boolean isCommonItem() {
			return false;
		}
	};
	

	public static AbstractItemType BOOK_DEMON = new AbstractItemType(
			null,
			false,
			"Demonic Origins",
			"Demonic Origins'",
			"A book about demons and where they come from.",
			"book_race_demon",
			Colour.RACE_DEMON,
			10,
			Rarity.LEGENDARY,
			null,
			Util.newArrayListOfValues(new ListValue<>(new ItemEffect(ItemEffectType.BOOK_READ_DEMON, null, null, null, 0)))) {

		private static final long serialVersionUID = 1L;

		@Override
		public boolean isAbleToBeUsed(GameCharacter target) {
			return !Main.getProperties().isAdvancedRaceKnowledgeDiscovered(Race.DEMON);
		}

		@Override
		public String getUnableToBeUsedDescription(GameCharacter target) {
			return "You've already added this book to Lilaya's library! It would be best to just sell it...";
		}
		
		@Override
		public String getUseName() {
			return "read";
		}
		
		@Override
		public String getUseDescription(GameCharacter user, GameCharacter target) {
			return getGenericUseDescription(user, target,
					"Opening the book, you read its contents...",
					"Opening the book, you force [npc.name] to read its contents...",
					"[npc.Name] produces a book, titled 'Demonic Origins', which [npc.she] then starts to read...",
					"[npc.Name] produces a book, titled 'Demonic Origins', which [npc.she] then forces you to read...");
		}

		@Override
		public boolean isCommonItem() {
			return false;
		}
	};
	
	public static AbstractItemType BOOK_DOG_MORPH = new AbstractItemType(
			null,
			false,
			"Canine Culture",
			"Canine Cultures",
			"A book about dog-morphs and their culture.",
			"book_race_dog_morph",
			Colour.RACE_DOG_MORPH,
			10,
			Rarity.LEGENDARY,
			null,
			Util.newArrayListOfValues(new ListValue<>(new ItemEffect(ItemEffectType.BOOK_READ_DOG_MORPH, null, null, null, 0)))) {

		private static final long serialVersionUID = 1L;

		@Override
		public boolean isAbleToBeUsed(GameCharacter target) {
			return !Main.getProperties().isAdvancedRaceKnowledgeDiscovered(Race.DOG_MORPH);
		}

		@Override
		public String getUnableToBeUsedDescription(GameCharacter target) {
			return "You've already added this book to Lilaya's library! It would be best to just sell it...";
		}
		
		@Override
		public String getUseName() {
			return "read";
		}
		
		@Override
		public String getUseDescription(GameCharacter user, GameCharacter target) {
			return getGenericUseDescription(user, target,
					"Opening the book, you read its contents...",
					"Opening the book, you force [npc.name] to read its contents...",
					"[npc.Name] produces a book, titled 'Canine Culture', which [npc.she] then starts to read...",
					"[npc.Name] produces a book, titled 'Canine Culture', which [npc.she] then forces you to read...");
		}

		@Override
		public boolean isCommonItem() {
			return false;
		}
	};
	
	public static AbstractItemType BOOK_ALLIGATOR_MORPH = new AbstractItemType(
			null,
			false,
			"Rasselin' Gators",
			"Rasselin' Gators",
			"A book all about alligator-morphs, detailing their society and place within Dominion.",
			"book_race_gator_morph",
			Colour.RACE_ALLIGATOR_MORPH,
			10,
			Rarity.LEGENDARY,
			null,
			Util.newArrayListOfValues(new ListValue<>(new ItemEffect(ItemEffectType.BOOK_READ_ALLIGATOR_MORPH, null, null, null, 0)))) {
		
		private static final long serialVersionUID = 1L;

		@Override
		public boolean isAbleToBeUsed(GameCharacter target) {
			return !Main.getProperties().isAdvancedRaceKnowledgeDiscovered(Race.ALLIGATOR_MORPH);
		}

		@Override
		public String getUnableToBeUsedDescription(GameCharacter target) {
			return "You've already added this book to Lilaya's library! It would be best to just sell it...";
		}
		
		@Override
		public String getUseName() {
			return "read";
		}
		
		@Override
		public String getUseDescription(GameCharacter user, GameCharacter target) {
			return getGenericUseDescription(user, target,
					"Opening the book, you read its contents...",
					"Opening the book, you force [npc.name] to read its contents...",
					"[npc.Name] produces a book, titled 'Rasselin' Gators', which [npc.she] then starts to read...",
					"[npc.Name] produces a book, titled 'Rasselin' Gators', which [npc.she] then forces you to read...");
		}

		@Override
		public boolean isCommonItem() {
			return false;
		}
	};
	
	public static AbstractItemType BOOK_HARPY = new AbstractItemType(
			null,
			false,
			"All About Harpies",
			"All About Harpies'",
			"A book all about harpies, detailing their society and place within Dominion.",
			"book_race_harpy",
			Colour.RACE_HARPY,
			10,
			Rarity.LEGENDARY,
			null,
			Util.newArrayListOfValues(new ListValue<>(new ItemEffect(ItemEffectType.BOOK_READ_HARPY, null, null, null, 0)))) {
		
		private static final long serialVersionUID = 1L;

		@Override
		public boolean isAbleToBeUsed(GameCharacter target) {
			return !Main.getProperties().isAdvancedRaceKnowledgeDiscovered(Race.HARPY);
		}

		@Override
		public String getUnableToBeUsedDescription(GameCharacter target) {
			return "You've already added this book to Lilaya's library! It would be best to just sell it...";
		}
		
		@Override
		public String getUseName() {
			return "read";
		}
		
		@Override
		public String getUseDescription(GameCharacter user, GameCharacter target) {
			return getGenericUseDescription(user, target,
					"Opening the book, you read its contents...",
					"Opening the book, you force [npc.name] to read its contents...",
					"[npc.Name] produces a book, titled 'All About Harpies', which [npc.she] then starts to read...",
					"[npc.Name] produces a book, titled 'All About Harpies', which [npc.she] then forces you to read...");
		}

		@Override
		public boolean isCommonItem() {
			return false;
		}
	};
	
	public static AbstractItemType BOOK_HORSE_MORPH = new AbstractItemType(
			null,
			false,
			"Equine Encyclopedia",
			"Equine Encyclopedias",
			"A book all about horse-morphs.",
			"book_race_horse_morph",
			Colour.RACE_HORSE_MORPH,
			10,
			Rarity.LEGENDARY,
			null,
			Util.newArrayListOfValues(new ListValue<>(new ItemEffect(ItemEffectType.BOOK_READ_HORSE_MORPH, null, null, null, 0)))) {
		
		private static final long serialVersionUID = 1L;

		@Override
		public boolean isAbleToBeUsed(GameCharacter target) {
			return !Main.getProperties().isAdvancedRaceKnowledgeDiscovered(Race.HORSE_MORPH);
		}

		@Override
		public String getUnableToBeUsedDescription(GameCharacter target) {
			return "You've already added this book to Lilaya's library! It would be best to just sell it...";
		}
		
		@Override
		public String getUseName() {
			return "read";
		}
		
		@Override
		public String getUseDescription(GameCharacter user, GameCharacter target) {
			return getGenericUseDescription(user, target,
					"Opening the book, you read its contents...",
					"Opening the book, you force [npc.name] to read its contents...",
					"[npc.Name] produces a book, titled 'Equine Encyclopedia', which [npc.she] then starts to read...",
					"[npc.Name] produces a book, titled 'Equine Encyclopedia', which [npc.she] then forces you to read...");
		}

		@Override
		public boolean isCommonItem() {
			return false;
		}
	};
	
	public static AbstractItemType BOOK_REINDEER_MORPH = new AbstractItemType(
			null,
			false,
			"The Eight",
			"The Eight",
			"A book all about reindeer-morphs.",
			"book_race_reindeer_morph",
			Colour.RACE_REINDEER_MORPH,
			10,
			Rarity.LEGENDARY,
			null,
			Util.newArrayListOfValues(new ListValue<>(new ItemEffect(ItemEffectType.BOOK_READ_REINDEER_MORPH, null, null, null, 0)))) {
		
		private static final long serialVersionUID = 1L;

		@Override
		public boolean isAbleToBeUsed(GameCharacter target) {
			return !Main.getProperties().isAdvancedRaceKnowledgeDiscovered(Race.REINDEER_MORPH);
		}

		@Override
		public String getUnableToBeUsedDescription(GameCharacter target) {
			return "You've already added this book to Lilaya's library! It would be best to just sell it...";
		}
		
		@Override
		public String getUseName() {
			return "read";
		}
		
		@Override
		public String getUseDescription(GameCharacter user, GameCharacter target) {
			return getGenericUseDescription(user, target,
					"Opening the book, you read its contents...",
					"Opening the book, you force [npc.name] to read its contents...",
					"[npc.Name] produces a book, titled 'The Eight', which [npc.she] then starts to read...",
					"[npc.Name] produces a book, titled 'The Eight', which [npc.she] then forces you to read...");
		}

		@Override
		public boolean isCommonItem() {
			return false;
		}
	};
	
	public static AbstractItemType BOOK_REINDEER_MORPH = new AbstractItemType(
			null,
			false,
			"The Eight",
			"The Eight",
			"A book all about reindeer-morphs.",
			"book_race_reindeer_morph",
			Colour.RACE_REINDEER_MORPH,
			10,
			Rarity.LEGENDARY,
			null,
			Util.newArrayListOfValues(new ListValue<>(new ItemEffect(ItemEffectType.BOOK_READ_REINDEER_MORPH, null, null, null, 0)))) {
		
		private static final long serialVersionUID = 1L;

		@Override
		public boolean isAbleToBeUsed(GameCharacter target) {
			return !Main.getProperties().isAdvancedRaceKnowledgeDiscovered(Race.REINDEER_MORPH);
		}

		@Override
		public String getUnableToBeUsedDescription(GameCharacter target) {
			return "You've already added this book to Lilaya's library! It would be best to just sell it...";
		}
		
		@Override
		public String getUseName() {
			return "read";
		}
		
		@Override
		public String getUseDescription(GameCharacter user, GameCharacter target) {
			return "<p>"
						+ "Opening the book, you read its contents..."
					+ "</p>";
		}
	};
	
	public static AbstractItemType BOOK_HUMAN = new AbstractItemType(
			null,
			false,
			"Concerning Humans",
			"Concerning Humans'",
			"A book about humans and their place within Dominion society.",
			"book_race_human",
			Colour.RACE_HUMAN,
			10,
			Rarity.LEGENDARY,
			null,
			Util.newArrayListOfValues(new ListValue<>(new ItemEffect(ItemEffectType.BOOK_READ_HUMAN, null, null, null, 0)))) {

		private static final long serialVersionUID = 1L;

		@Override
		public boolean isAbleToBeUsed(GameCharacter target) {
			return !Main.getProperties().isAdvancedRaceKnowledgeDiscovered(Race.HUMAN);
		}

		@Override
		public String getUnableToBeUsedDescription(GameCharacter target) {
			return "You've already added this book to Lilaya's library! It would be best to just sell it...";
		}
		
		@Override
		public String getUseName() {
			return "read";
		}
		
		@Override
		public String getUseDescription(GameCharacter user, GameCharacter target) {
			return getGenericUseDescription(user, target,
					"Opening the book, you read its contents...",
					"Opening the book, you force [npc.name] to read its contents...",
					"[npc.Name] produces a book, titled 'Concerning Humans', which [npc.she] then starts to read...",
					"[npc.Name] produces a book, titled 'Concerning Humans', which [npc.she] then forces you to read...");
		}

		@Override
		public boolean isCommonItem() {
			return false;
		}
	};
	
	public static AbstractItemType BOOK_SQUIRREL_MORPH = new AbstractItemType(
			null,
			false,
			"Chasing Squirrels",
			"Chasing Squirrels'",
			"A book that details squirrel-morph society.",
			"book_race_squirrel_morph",
			Colour.RACE_SQUIRREL_MORPH,
			10,
			Rarity.LEGENDARY,
			null,
			Util.newArrayListOfValues(new ListValue<>(new ItemEffect(ItemEffectType.BOOK_READ_SQUIRREL_MORPH, null, null, null, 0)))) {

		private static final long serialVersionUID = 1L;

		@Override
		public boolean isAbleToBeUsed(GameCharacter target) {
			return !Main.getProperties().isAdvancedRaceKnowledgeDiscovered(Race.SQUIRREL_MORPH);
		}

		@Override
		public String getUnableToBeUsedDescription(GameCharacter target) {
			return "You've already added this book to Lilaya's library! It would be best to just sell it...";
		}
		
		@Override
		public String getUseName() {
			return "read";
		}
		
		@Override
		public String getUseDescription(GameCharacter user, GameCharacter target) {
			return getGenericUseDescription(user, target,
					"Opening the book, you read its contents...",
					"Opening the book, you force [npc.name] to read its contents...",
					"[npc.Name] produces a book, titled 'Chasing Squirrels', which [npc.she] then starts to read...",
					"[npc.Name] produces a book, titled 'Chasing Squirrels', which [npc.she] then forces you to read...");
		}

		@Override
		public boolean isCommonItem() {
			return false;
		}
	};
	
	public static AbstractItemType BOOK_WOLF_MORPH = new AbstractItemType(
			null,
			false,
			"Prowling Lupines",
			"Prowling Lupines'",
			"A book all about wolf-morphs.",
			"book_race_wolf_morph",
			Colour.RACE_WOLF_MORPH,
			10,
			Rarity.LEGENDARY,
			null,
			Util.newArrayListOfValues(new ListValue<>(new ItemEffect(ItemEffectType.BOOK_READ_WOLF_MORPH, null, null, null, 0)))) {

		private static final long serialVersionUID = 1L;

		@Override
		public boolean isAbleToBeUsed(GameCharacter target) {
			return !Main.getProperties().isAdvancedRaceKnowledgeDiscovered(Race.WOLF_MORPH);
		}

		@Override
		public String getUnableToBeUsedDescription(GameCharacter target) {
			return "You've already added this book to Lilaya's library! It would be best to just sell it...";
		}
		
		@Override
		public String getUseName() {
			return "read";
		}
		
		@Override
		public String getUseDescription(GameCharacter user, GameCharacter target) {
			return getGenericUseDescription(user, target,
					"Opening the book, you read its contents...",
					"Opening the book, you force [npc.name] to read its contents...",
					"[npc.Name] produces a book, titled 'Prowling Lupines', which [npc.she] then starts to read...",
					"[npc.Name] produces a book, titled 'Prowling Lupines', which [npc.she] then forces you to read...");
		}

		@Override
		public boolean isCommonItem() {
			return false;
		}
	};
	
	public static AbstractItemType PRESENT = new AbstractItemType(
			"a",
			false,
			"Yuletide Gift",
			"Yuletide Gift",
			"A wrapped present, sold by one of the reindeer-morph overseers in Dominion. It contains a random item from their store, and can also be given as a gift to your offspring, slaves, or Lilaya.",
			"present",
			Colour.GENERIC_ARCANE,
			10,
			Rarity.RARE,
			null,
			Util.newArrayListOfValues(new ListValue<>(new ItemEffect(ItemEffectType.PRESENT, null, null, null, 0)))) {

		private static final long serialVersionUID = 1L;
		
		@Override
		public boolean isAbleToBeUsed(GameCharacter target) {
			return !(target.isInventoryFull() && Main.game.getPlayerCell().getInventory().isInventoryFull());
		}

		@Override
		public String getUnableToBeUsedDescription(GameCharacter target) {
			return "There's no space in your inventory or on the ground for whatever item is contained within!";
		}
		
		@Override
		public String getUseName() {
			return "open";
		}
		
		@Override
		public String getUseDescription(GameCharacter user, GameCharacter target) {
			return getGenericUseDescription(user, target,
					"You untie the ribbon and peel off the wrapping paper, before opening the box to discover what's inside...",
					"You force [npc.name] to untie the ribbon and peel off the wrapping paper, before getting [npc.herHim] to open the box to discover what's inside...",
					"[npc.Name] produces a present, and then proceeds to untie the ribbon and peel off the wrapping paper, before opening the box to discover what's inside...",
					"[npc.Name] produces a present, and then proceeds to make you untie the ribbon and peel off the wrapping paper, before getting you to open the box to discover what's inside...");
		}

		@Override
		public boolean isCommonItem() {
			return false;
		}
	};
	
	// Why did I make this?
	public static AbstractItemType EGGPLANT = new AbstractItemType(
			null,
			false,
			"Eggplant",
			"Eggplants",
			"A delicate, tropical perennial often cultivated as a tender or half-hardy annual in temperate climates. Also it kind of looks like a penis if you squint.",
			"eggplant",
			Colour.GENERIC_ARCANE,
			10,
			Rarity.LEGENDARY,
			null,
			Util.newArrayListOfValues(new ListValue<>(new ItemEffect(ItemEffectType.EGGPLANT, null, null, null, 0)))) {

		private static final long serialVersionUID = 1L;

		@Override
		public boolean canBeSold() {
			return false;
		}
		
		@Override
		public String getUseName() {
			return "eat";
		}
		
		@Override
		public String getUseDescription(GameCharacter user, GameCharacter target) {
<<<<<<< Upstream, based on upstream/master
			return getGenericUseDescription(user, target,
					"You eat the eggplant. The bitter taste of disappointment overwhelmes you.",
					"You force [npc.name] to eat the eggplant. The bitter taste of disappointment overwhelmes you both.",
					"[npc.Name] produces an eggplant, and then proceeds to eat it. The bitter taste of disappointment overwhelmes you both.",
					"[npc.Name] produces an eggplant, and then proceeds to force you to eat it. The bitter taste of disappointment overwhelmes you both.");
		}

		@Override
		public boolean isCommonItem() {
			return false;
=======
			if (user!=null && user.isPlayer() && target.isPlayer()) {
				return "<p>"
							+ "You eat the eggplant."
						+ "</p>";
				
			} else {
				return UtilText.parse(user,
						"<p>"
							+ "[npc.Name] eats an eggplant."
						+ "</p>");
			}
>>>>>>> 78d186e upstream
		}
	};
	
	
	// Standard non-racial transformatives:
	
//	MASOCHISTS_HEAVEN("a bottle of", "it", "Masochist's Heaven",
//			"A clear plastic bottle of Masochist's Heaven. A girl, lying back in the missionary position, is prominently featured on the label, screaming in delight as a huge cock painfully stretches out her tight, dry pussy.",
//			"potion", Colour.CLOTHING_WHITE, true, 25, Rarity.RARE, "Decreases orifice capacity, elasticity, and wetness.") {
//		
//		@Override
//		protected String extraEffects(GameCharacter user, GameCharacter target) {
//			if (user!=null && user.isPlayer() && target.isPlayer())
//				effectStringBuilder = new StringBuilder("<p>You unscrew the plastic cap and gulp down the bottle of <i>Masochist's Heaven</i>. The drink is quite bland, but a slight"
//						+ " citrus aftertaste lingers in your mouth as you swallow the last few drops. As you lower the empty bottle, your mouth and throat suddenly feel incredibly"
//						+ " dry, as though you haven't drunk anything for hours. Before you can think about getting another drink, the feeling quickly fades away, spreading a dry warmth throughout your entire body.</p>");
//			else if (user != Main.game.getPlayer() && target != Main.game.getPlayer())
//				effectStringBuilder = new StringBuilder("<p>" + target.getName("The") + " pulls out a bottle of <i>Masochist's Heaven</i>, unscrews the cap," + " and gulps it all down.</p>");
//
//			effectStringBuilder.append("<p>" + TransformationEffect.MASOCHISTS_HEAVEN.applyEffect(target) + "</p>");
//
//			return effectStringBuilder.toString();
//		}
//
//		@Override
//		public String getUseDescription(GameCharacter user, GameCharacter target) {
//			return "drink";
//		}
//
//		@Override
//		public boolean isAbleToBeUsedInCombat() {
//			return false;
//		}
//
//		@Override
//		public boolean isAbleToBeUsedInSex() {
//			return false;
//		}
//	};
//	GOING_BIG("a bottle of", "it", "Going Big",
//			"A clear plastic bottle of a drink branded as 'Going Big'. A girl, presenting herself doggy-style, is prominently featured on the label, crying out in delight as a gigantic cock easily stretches out her tight, wet pussy.",
//			"potion", Colour.CLOTHING_WHITE, true, 25, Rarity.RARE, "Decreases orifice capacity. Increases elasticity and wetness.") {
//		
//		@Override
//		protected String extraEffects(GameCharacter user, GameCharacter target) {
//			if (user!=null && user.isPlayer() && target.isPlayer())
//				effectStringBuilder = new StringBuilder("<p>You unscrew the plastic cap and gulp down the bottle of <i>Going Big</i>."
//						+ " Despite the fact that the liquid is clear, it has a very strong taste of apples, and after only a moment, you're licking the last few drops from your lips.</p>");
//			else if (user != Main.game.getPlayer() && target != Main.game.getPlayer())
//				effectStringBuilder = new StringBuilder("<p>" + target.getName("The") + " pulls out a bottle of <i>Going Big</i>, unscrews the cap, and gulps it all down.</p>");
//
//			effectStringBuilder.append("<p>" + TransformationEffect.GOING_BIG.applyEffect(target) + "</p>");
//
//			return effectStringBuilder.toString();
//		}
//
//		@Override
//		public String getUseDescription(GameCharacter user, GameCharacter target) {
//			return "drink";
//		}
//
//		@Override
//		public boolean isAbleToBeUsedInCombat() {
//			return false;
//		}
//
//		@Override
//		public boolean isAbleToBeUsedInSex() {
//			return false;
//		}
//	};
//	WET_KISS("a bottle of", "it", "Wet Kiss",
//			"A clear plastic bottle of the branded drink <i>Wet Kiss</i>, filled with a rose-coloured liquid. The label on the front is devoid"
//					+ " of any images, and instead simply displays the name <i>Wet Kiss</i>, along with some incomprehensible technical details of the drink's manufacturing process.",
//			"potion", Colour.CLOTHING_PINK_LIGHT, true, 25, Rarity.RARE, "Increases orifice wetness and capacity.") {
//		@Override
//		protected String extraEffects(GameCharacter user, GameCharacter target) {
//			if (user!=null && user.isPlayer() && target.isPlayer())
//				effectStringBuilder = new StringBuilder("<p>You unscrew the plastic cap and gulp down the bottle of <i>Wet Kiss</i>. The drink is quite bland, but a slight"
//						+ " aftertaste of cranberries lingers in your mouth as you swallow the last few drops. Within seconds, you feel a slimy wetness squirming in your stomach,"
//						+ " but before you have any time to worry, it quickly dissipates throughout your body.</p>");
//			else if (user != Main.game.getPlayer() && target != Main.game.getPlayer())
//				effectStringBuilder = new StringBuilder("<p>" + target.getName("The") + " pulls out a bottle of <i>Wet Kiss</i>, unscrews the cap," + " and gulps it all down.</p>");
//
//			effectStringBuilder.append("<p>" + TransformationEffect.WET_KISS.applyEffect(target) + "</p>");
//
//			return effectStringBuilder.toString();
//		}
//
//		@Override
//		public String getUseDescription(GameCharacter user, GameCharacter target) {
//			return "drink";
//		}
//
//		@Override
//		public boolean isAbleToBeUsedInCombat() {
//			return false;
//		}
//
//		@Override
//		public boolean isAbleToBeUsedInSex() {
//			return false;
//		}
//	};
//	
//	
//
//	BUBBLE_MILK("a bottle of", "it", "bubble-milk",
//			"A clear plastic bottle of bubble-milk. Despite its name, the milk doesn't physically bubble, but instead refers to the feeling"
//					+ " you get after drinking it. A busty greater cow-girl is prominently featured on the label, smiling as she milks her gigantic udder-tits into a metal bucket.",
//			"potion", Colour.CLOTHING_WHITE, true, 25, Rarity.RARE, "Increases breast size and lactation.") {
//		
//		@Override
//		protected String extraEffects(GameCharacter user, GameCharacter target) {
//			if (user!=null && user.isPlayer() && target.isPlayer())
//				effectStringBuilder = new StringBuilder("<p>You unscrew the plastic cap and gulp down the bottle of bubble-milk. It tastes just like regular milk, but as you"
//						+ " swallow the last few drops, a funny bubbling sensation starts to spread throughout your torso before settling in your chest.</p>");
//			else if (user != Main.game.getPlayer() && target != Main.game.getPlayer())
//				effectStringBuilder = new StringBuilder("<p>" + target.getName("The") + " pulls out a bottle of bubble-milk, unscrews the cap, and gulps it all down.</p>");
//
//			effectStringBuilder.append("<p>" + TransformationEffect.BUBBLE_MILK.applyEffect(target) + "</p>");
//
//			return effectStringBuilder.toString();
//		}
//
//		@Override
//		public String getUseDescription(GameCharacter user, GameCharacter target) {
//			return "drink";
//		}
//
//		@Override
//		public boolean isAbleToBeUsedInCombat() {
//			return false;
//		}
//
//		@Override
//		public boolean isAbleToBeUsedInSex() {
//			return false;
//		}
//	};
//	BUBBLE_CREAM("a bottle of", "it", "bubble-cream",
//			"A clear plastic bottle of bubble-cream. Just like bubble-milk, the cream doesn't physically bubble, but instead refers"
//					+ " to the feeling you get after drinking it. A greater cow-girl with three pairs of gigantic breasts is prominently featured on the label, smiling as she" + " milks her gigantic udder-tits into a metal bucket.",
//			"potion", Colour.CLOTHING_WHITE, true, 100, Rarity.EPIC, "Increases breast size, count, and lactation.") {
//		@Override
//		protected String extraEffects(GameCharacter user, GameCharacter target) {
//			if (user!=null && user.isPlayer() && target.isPlayer())
//				effectStringBuilder = new StringBuilder("<p>You unscrew the plastic cap and gulp down the bottle of bubble-cream. Its rich taste is exactly like that of regular"
//						+ " cream, but as you swallow the last few drops, a strong bubbling sensation starts to spread throughout your torso before settling in your chest.</p>");
//			else if (user != Main.game.getPlayer() && target != Main.game.getPlayer())
//				effectStringBuilder = new StringBuilder("<p>" + target.getName("The") + " pulls out a bottle of bubble-cream, unscrews the cap, and gulps it all down.</p>");
//
//			effectStringBuilder.append("<p>" + TransformationEffect.BUBBLE_CREAM.applyEffect(target) + "</p>");
//
//			return effectStringBuilder.toString();
//		}
//
//		@Override
//		public String getUseDescription(GameCharacter user, GameCharacter target) {
//			return "drink";
//		}
//
//		@Override
//		public boolean isAbleToBeUsedInCombat() {
//			return false;
//		}
//
//		@Override
//		public boolean isAbleToBeUsedInSex() {
//			return false;
//		}
//	};
//
//	THROBBING_GLOW("a bottle of", "it", "Throbbing Glow",
//			"A clear plastic bottle of the energy drink <i>Throbbing Glow</i>, filled with a bright blue liquid. A"
//					+ " well-endowed greater horse-boy is prominently featured on the label, stroking his gigantic member with one hand, while bringing a bottle of <i>Throbbing Glow</i>" + " to his lips with the other.",
//			"potion", Colour.CLOTHING_BLUE_LIGHT, true, 25, Rarity.RARE, "Increases penis and testicle size. Increases cum production.") {
//		@Override
//		protected String extraEffects(GameCharacter user, GameCharacter target) {
//			if (user!=null && user.isPlayer() && target.isPlayer())
//				effectStringBuilder = new StringBuilder("<p>You unscrew the plastic cap and gulp down the bottle of <i>Throbbing Glow</i>. It tastes a little sour, sort of like"
//						+ " a cheap, sugary energy drink. As the last few drops slide down your throat, you feel a throbbing, deep-seated heat take root in your groin.</p>");
//			else if (user != Main.game.getPlayer() && target != Main.game.getPlayer())
//				effectStringBuilder = new StringBuilder("<p>" + target.getName("The") + " pulls out a bottle of <i>Throbbing Glow</i>, unscrews the cap," + " and gulps it all down.</p>");
//
//			effectStringBuilder.append("<p>" + TransformationEffect.THROBBING_GLOW.applyEffect(target) + "</p>");
//
//			return effectStringBuilder.toString();
//		}
//
//		@Override
//		public String getUseDescription(GameCharacter user, GameCharacter target) {
//			return "drink";
//		}
//
//		@Override
//		public boolean isAbleToBeUsedInCombat() {
//			return false;
//		}
//
//		@Override
//		public boolean isAbleToBeUsedInSex() {
//			return false;
//		}
//	};
//
//	FLOWERS_WARMTH("a bottle of", "it", "Flower's Warmth",
//			"A clear plastic bottle of the energy drink <i>Flower's Warmth</i>, filled with a pale pink liquid. A"
//					+ " greater cat-girl is featured prominently on the label, leaning back in a chair as another greater cat-girl laps hungrily at her exposed pussy.",
//			"potion", Colour.CLOTHING_PINK_LIGHT, true, 25, Rarity.RARE, "Increases the body's feminine characteristics.") {
//		@Override
//		protected String extraEffects(GameCharacter user, GameCharacter target) {
//			if (user!=null && user.isPlayer() && target.isPlayer())
//				effectStringBuilder = new StringBuilder("<p>You unscrew the plastic cap and gulp down the bottle of <i>Flower's Warmth</i>. It tastes a little sour, sort of like"
//						+ " a cheap, sugary energy drink. As the last few drops slide down your throat, you feel a deep-seated heat start to spread through in your groin.</p>");
//			else if (user != Main.game.getPlayer() && target != Main.game.getPlayer())
//				effectStringBuilder = new StringBuilder("<p>" + target.getName("The") + " pulls out a bottle of <i>Flower's Warmth</i>, unscrews the cap," + " and gulps it all down.</p>");
//
//			effectStringBuilder.append("<p>" + TransformationEffect.FLOWERS_WARMTH.applyEffect(target) + "</p>");
//
//			return effectStringBuilder.toString();
//		}
//
//		@Override
//		public String getUseDescription(GameCharacter user, GameCharacter target) {
//			return "drink";
//		}
//
//		@Override
//		public boolean isAbleToBeUsedInCombat() {
//			return false;
//		}
//
//		@Override
//		public boolean isAbleToBeUsedInSex() {
//			return false;
//		}
//	};
//
//	
//
//	SCARLET_WHISPER("a bottle of", "it", "Scarlet Whisper",
//			"A delicate glass bottle of <i>Scarlet Whisper</i>, filled with a bright pink liquid. The label on the front displays"
//					+ " the name <i>Scarlet Whisper</i> in a delicate, feminine font. The rest of the label is covered in simple images of pale pink flowers and looping linework.",
//			"potion", Colour.CLOTHING_PINK, true, 25, Rarity.RARE, "Increases all feminine aspects.") {
//		@Override
//		protected String extraEffects(GameCharacter user, GameCharacter target) {
//			if (user!=null && user.isPlayer() && target.isPlayer())
//				effectStringBuilder = new StringBuilder("<p>You unscrew the metal cap and gulp down the bottle of <i>Scarlet Whisper</i>. The liquid has a delicate, sweet flavour,"
//						+ " which reminds you of strawberries and cream. As you finish the bottle, a wave of dizziness washes over you, filling your mind with a soft pink haze. Shaking"
//						+ " your head, the feeling somehow seems to sink down into your body, leaving you tingling all over.</p>");
//			else if (user != Main.game.getPlayer() && target != Main.game.getPlayer())
//				effectStringBuilder = new StringBuilder("<p>" + target.getName("The") + " pulls out a bottle of <i>Scarlet Whisper</i>, unscrews the cap," + " and gulps it all down.</p>");
//
//			effectStringBuilder.append("<p>" + TransformationEffect.SCARLET_WHISPER.applyEffect(target) + "</p>");
//
//			return effectStringBuilder.toString();
//		}
//
//		@Override
//		public String getUseDescription(GameCharacter user, GameCharacter target) {
//			return "drink";
//		}
//
//		@Override
//		public boolean isAbleToBeUsedInCombat() {
//			return false;
//		}
//
//		@Override
//		public boolean isAbleToBeUsedInSex() {
//			return false;
//		}
//	};
//	FLAMING_THUNDER("a bottle of", "it", "Flaming Thunder",
//			"A thick glass bottle of <i>Flaming Thunder</i>, filled with a deep blue liquid. The label on the front displays"
//					+ " the name <i>Flaming Thunder</i> in a bold, striking font. The rest of the label is covered in simple images of lightning and bold linework.",
//			"potion", Colour.CLOTHING_BLUE, true, 25, Rarity.RARE, "Increases all masculine aspects.") {
//		@Override
//		protected String extraEffects(GameCharacter user, GameCharacter target) {
//			if (user!=null && user.isPlayer() && target.isPlayer())
//				effectStringBuilder = new StringBuilder("<p>You unscrew the metal cap and gulp down the bottle of <i>Flaming Thunder</i>. The liquid has a strong flavour, and despite"
//						+ " its blue colouring, tastes very similar to lemonade. As you finish the bottle, a wave of dizziness washes over you, filling your mind with a strange blue haze."
//						+ " Shaking your head, the feeling somehow seems to sink down into your body, leaving you tingling all over.</p>");
//			else if (user != Main.game.getPlayer() && target != Main.game.getPlayer())
//				effectStringBuilder = new StringBuilder("<p>" + target.getName("The") + " pulls out a bottle of <i>Flaming Thunder</i>, unscrews the cap," + " and gulps it all down.</p>");
//
//			effectStringBuilder.append("<p>" + TransformationEffect.FLAMING_THUNDER.applyEffect(target) + "</p>");
//
//			return effectStringBuilder.toString();
//		}
//
//		@Override
//		public String getUseDescription(GameCharacter user, GameCharacter target) {
//			return "drink";
//		}
//
//		@Override
//		public boolean isAbleToBeUsedInCombat() {
//			return false;
//		}
//
//		@Override
//		public boolean isAbleToBeUsedInSex() {
//			return false;
//		}
//	};
//
	
	public static List<AbstractItemType>
			commonItems = new ArrayList<>(),
			essences = new ArrayList<>(),
			allItems = new ArrayList<>();
	
	public static Map<AbstractItemType, String> itemToIdMap = new HashMap<>();
	public static Map<String, AbstractItemType> idToItemMap = new HashMap<>();
	
	static{
		
		Field[] fields = ItemType.class.getFields();
		
		for(Field f : fields){
			
			if (AbstractItemType.class.isAssignableFrom(f.getType())) {
				
				AbstractItemType item;
				try {
					item = ((AbstractItemType) f.get(null));
					
					// I feel like this is stupid :thinking:
					itemToIdMap.put(item, f.getName());
					idToItemMap.put(f.getName(), item);
					
					allItems.add(item);
					
<<<<<<< Upstream, based on upstream/master
					if(item.isCommonItem()) {
=======
					if(item!=ItemType.POTION && item!=ItemType.ELIXIR && item!=ItemType.FETISH_REFINED
							&& item!=ItemType.HARPY_MATRIARCH_BIMBO_LOLLIPOP && item!=ItemType.HARPY_MATRIARCH_DOMINANT_PERFUME && item!=ItemType.HARPY_MATRIARCH_NYMPHO_LOLLIPOP
							&& item!=ItemType.BOOK_CAT_MORPH && item!=ItemType.BOOK_DEMON && item!=ItemType.BOOK_DOG_MORPH
							&& item!=ItemType.BOOK_HARPY && item!=ItemType.BOOK_HORSE_MORPH && item!=ItemType.BOOK_HUMAN && item!=ItemType.BOOK_WOLF_MORPH && item!=ItemType.BOOK_REINDEER_MORPH && item!=ItemType.BOOK_ALLIGATOR_MORPH
							&& item!=ItemType.BOTTLED_ESSENCE_ARCANE && item!=ItemType.BOTTLED_ESSENCE_CAT_MORPH && item!=ItemType.BOTTLED_ESSENCE_DEMON && item!=ItemType.BOTTLED_ESSENCE_REINDEER_MORPH
							&& item!=ItemType.BOTTLED_ESSENCE_DOG_MORPH && item!=ItemType.BOTTLED_ESSENCE_HARPY && item!=ItemType.BOTTLED_ESSENCE_HORSE_MORPH && item!=ItemType.BOTTLED_ESSENCE_ALLIGATOR_MORPH
							&& item!=ItemType.BOTTLED_ESSENCE_HUMAN && item!=ItemType.BOTTLED_ESSENCE_WOLF_MORPH && item!=ItemType.BOTTLED_ESSENCE_COW_MORPH && item!=ItemType.BOTTLED_ESSENCE_SQUIRREL_MORPH
							&& item!=ItemType.EGGPLANT
							) {
>>>>>>> 600d4dc merge and chair update
						commonItems.add(item);
						
					} else if(item==ItemType.BOTTLED_ESSENCE_ARCANE
							|| item==ItemType.BOTTLED_ESSENCE_CAT_MORPH
							|| item==ItemType.BOTTLED_ESSENCE_DEMON
							|| item==ItemType.BOTTLED_ESSENCE_DOG_MORPH
							|| item==ItemType.BOTTLED_ESSENCE_HARPY
							|| item==ItemType.BOTTLED_ESSENCE_HORSE_MORPH
							|| item==ItemType.BOTTLED_ESSENCE_HUMAN
							|| item==ItemType.BOTTLED_ESSENCE_WOLF_MORPH
							|| item==ItemType.BOTTLED_ESSENCE_COW_MORPH
							|| item==ItemType.BOTTLED_ESSENCE_ALLIGATOR_MORPH
						  	|| item==ItemType.BOTTLED_ESSENCE_REINDEER_MORPH
						  	|| item==ItemType.BOTTLED_ESSENCE_SQUIRREL_MORPH) {
						essences.add(item);
					}
					
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
	}

}

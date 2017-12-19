package com.lilithsthrone.game.sex.sexActions.universal.consensual;

import com.lilithsthrone.game.character.attributes.CorruptionLevel;
import com.lilithsthrone.game.dialogue.utils.UtilText;
import com.lilithsthrone.game.sex.ArousalIncrease;
import com.lilithsthrone.game.sex.Sex;
import com.lilithsthrone.game.sex.managers.universal.consensual.SMChairBottom;
import com.lilithsthrone.game.sex.managers.universal.consensual.SMChairKneeling;
import com.lilithsthrone.game.sex.sexActions.SexAction;
import com.lilithsthrone.game.sex.sexActions.SexActionType;

/**
 * @since 0.1.69.9
 * @version 0.1.69.9
 * @author Innoxia
 */
public class ConChairTopPositions {

	public static final SexAction PLAYER_SWITCH_CHAIR_POSITIONS = new SexAction(
			SexActionType.PLAYER_POSITIONING,
			ArousalIncrease.ZERO_NONE,
			ArousalIncrease.ZERO_NONE,
			CorruptionLevel.ZERO_PURE,
			null,
			null) {

		@Override
		public boolean isBaseRequirementsMet() {
			return !Sex.isAnyNonSelfPenetrationHappening();
		}
		
		@Override
		public String getActionTitle() {
			return "Switch positions";
		}

		@Override
		public String getActionDescription() {
			return UtilText.genderParsing(Sex.getPartner(),
					"Switch positions with "+Sex.getPartner().getName("the")+", so that you're the one sitting down.");
		}

		@Override
		public String getDescription() {
			return UtilText.genderParsing(Sex.getPartner(),
					"You reach down and grab "+Sex.getPartner().getName("the")+"'s "+Sex.getPartner().getHipSize().getDescriptor()+" hips, and with a determined pull, you cause <herPro> to stand up."
					+ " Still holding <her> hips, you move <herPro> to one side, sitting down in the space that <she> just vacated before pulling <herPro> forwards into your crotch."
					+ " Looking down at you, <she> smiles, "
					+ UtilText.parseSpeech("You want a go on the bottom, huh?", Sex.getPartner()));
		}

		@Override
		public void applyEffects() {
			Sex.setSexManager(new SMChairBottom()); // TODO May need override in some sex scenes
		}
	};
	
	public static final SexAction PLAYER_KNEEL = new SexAction(
			SexActionType.PLAYER_POSITIONING,
			ArousalIncrease.ZERO_NONE,
			ArousalIncrease.ZERO_NONE,
			CorruptionLevel.ZERO_PURE,
			null,
			null) {

		@Override
		public boolean isBaseRequirementsMet() {
			return !Sex.isAnyNonSelfPenetrationHappening();
		}
		
		@Override
		public String getActionTitle() {
			return "Kneel on Floor";
		}

		@Override
		public String getActionDescription() {
			return UtilText.genderParsing(Sex.getPartner(),
					"Kneel down on the floor in front of "+Sex.getPartner().getName("the")+".");
		}

		@Override
		public String getDescription() {
			return UtilText.genderParsing(Sex.getPartner(),
					"You slide of of "+Sex.getPartner().getName("the")+"'s lap, and with a playful little grin you get to your knees in front of <herPro>."
					+ " You lick your lips and gaze up at <her> eyes while your hands spread her legs apart."
					+ " Looking down at you, <she> smiles, "
					+ UtilText.parseSpeech("You're looking to lick some pussy, sweetie, huh?", Sex.getPartner()));
		}

		@Override
		public void applyEffects() {
			Sex.setSexManager(new SMChairKneeling());
		}
	};
	
}

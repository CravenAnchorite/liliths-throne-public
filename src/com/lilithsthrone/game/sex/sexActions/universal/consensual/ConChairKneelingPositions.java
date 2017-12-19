package com.lilithsthrone.game.sex.sexActions.universal.consensual;

import com.lilithsthrone.game.character.attributes.CorruptionLevel;
import com.lilithsthrone.game.dialogue.utils.UtilText;
import com.lilithsthrone.game.sex.ArousalIncrease;
import com.lilithsthrone.game.sex.Sex;
import com.lilithsthrone.game.sex.managers.dominion.lilaya.SMChairTopLilaya;
import com.lilithsthrone.game.sex.sexActions.SexAction;
import com.lilithsthrone.game.sex.sexActions.SexActionType;

public class ConChairKneelingPositions {
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
			return "Climb Up Again";
		}

		@Override
		public String getActionDescription() {
			return UtilText.genderParsing(Sex.getPartner(),
					"Climb up to straddle "+Sex.getPartner().getName("the")+".");
		}

		@Override
		public String getDescription() {
			return UtilText.genderParsing(Sex.getPartner(),
					"You stand up in front of "+Sex.getPartner().getName("the")+"'s."
					+ " <She> smiles up at you as you step forwards between <her> legs, "
					+ UtilText.parseSpeech("You want this, huh?", Sex.getPartner()));
		}

		@Override
		public void applyEffects() {
			Sex.setSexManager(new SMChairTopLilaya());
		}
	};
}

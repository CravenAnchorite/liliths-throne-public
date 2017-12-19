<<<<<<< Upstream, based on upstream/master
<<<<<<< Upstream, based on upstream/master
package com.lilithsthrone.main;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.lilithsthrone.controller.MainController;
import com.lilithsthrone.game.Game;
import com.lilithsthrone.game.Properties;
import com.lilithsthrone.game.character.CharacterImportSetting;
import com.lilithsthrone.game.character.CharacterUtils;
import com.lilithsthrone.game.character.NameTriplet;
import com.lilithsthrone.game.character.PlayerCharacter;
import com.lilithsthrone.game.character.QuestLine;
import com.lilithsthrone.game.character.body.valueEnums.Femininity;
import com.lilithsthrone.game.character.gender.Gender;
import com.lilithsthrone.game.character.race.RaceStage;
import com.lilithsthrone.game.character.race.RacialBody;
import com.lilithsthrone.game.dialogue.DebugDialogue;
import com.lilithsthrone.game.dialogue.DialogueNodeOld;
import com.lilithsthrone.game.dialogue.MapDisplay;
import com.lilithsthrone.game.dialogue.responses.Response;
import com.lilithsthrone.game.dialogue.story.CharacterCreation;
import com.lilithsthrone.game.dialogue.utils.OptionsDialogue;
import com.lilithsthrone.game.inventory.enchanting.TFEssence;
import com.lilithsthrone.utils.Colour;
import com.lilithsthrone.utils.CreditsSlot;
import com.lilithsthrone.world.Generation;
import com.lilithsthrone.world.WorldType;
import com.lilithsthrone.world.places.PlaceType;

import javafx.application.Application;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * @since 0.1.0
 * @version 0.1.98
 * @author Innoxia
 */
public class Main extends Application {

	public static Game game;

	public static MainController mainController;

	public static Scene mainScene;

	public static Stage primaryStage;
	public static String author = "Innoxia";

	public static final String VERSION_NUMBER = "0.1.98.1",
			VERSION_DESCRIPTION = "Early Alpha";

	public static final Image WINDOW_IMAGE = new Image("/com/lilithsthrone/res/images/windowIcon32.png");

	private static Properties properties;
	
	public static String patchNotes =
			
//		"<h1 style='text-align:center;'>Version " + Main.VERSION_NUMBER + "</h1>"
//		+ "<h6 style='text-align:center;'><b style='color:" + Colour.GENERIC_TERRIBLE.toWebHexString() + ";'>Buggy Preview!</b></h6>"
//		+ "<h6 style='text-align:center;'><b style='color:" + Colour.GENERIC_BAD.toWebHexString() + ";'>Early Alpha!</b></h6>"
		
		"<p>"
			+ "Hello everyone! :3"
		+ "</p>"
			
		+ "<p>"
			+ "I've got everything but the stamina/lust sex mechanics and the addictive/alcoholic/psychoactive fluids work done now, so once I've finished those (which will take just one day), I'll be ready to move on to the very final stage of engine work,"
				+ " which will be the combat rework/improvements."
			+ " I'll also use the multiple-partner sex framework to polish and fully complete the slave's 'Spitroast' test scene for the next version, so you'll be able to really see the new system in action. :3"
		+ "</p>"
		
		+ "<p>"
			+ "Thank you all for playing Lilith's Throne! And a very big thank you to all the people supporting me on Patreon!"
			+ " If you wanted to ask me any specific questions about the game, you can either find me on my blog, or on the Lilith's Throne Discord. You can find a link to the discord on my blog. ^^"
		+ "</p>"
			
		+ "</br>"

		+ "<list>"
			+ "<h6>v0.1.97.5</h6>"
			+"<li>Engine:</li>"
			+"<ul>Finished converting the save system to .xml. All saves now use the new .xml system, so you won't need to export/import between versions anymore.</ul>"
			+"<ul>Optimised NPC load method, so loading a game should now be faster.</ul>"
			+"<ul>Added support for conditional parsing commands to the parsing engine. I'll add documentation for this soon.</ul>"
			+"<ul>Finished refactor of all sex engine code to properly support multiple-partner sex scenes.</ul>"

			+"<li>UI:</li>"
			+"<ul>Updated Save/Load UI, and changed Export/Import to exported character management screen.</ul>"
			+"<ul>Updated inventory slot positions. (This should now be the final layout.)</ul>"

			+"<li>Sex:</li>"
			+"<ul>NPCs should no longer switch positions just before they orgasm.</ul>"
			+"<ul>NPCs will no longer instantly re-penetrate themselves on the same turn that you forbid or stop all self-penetrative actions.</ul>"
			+"<ul>Reworked all back-end code for generic orgasms, ready to write in more detailed content for the full release.</ul>"
			+"<ul>Added 'cum on area' orgasm options, to allow you to cum on a specific area of your partner's body. (Not completely finished yet.)</ul>"

			+"<li>Other:</li>"
			+"<ul>Demons now only have 1 pair of breasts by default. (I originally intended this to be the case, but I ended up giving them 3 a long time ago to test multiple-breast rows, and forgot to change it back.)</ul>"
			+"<ul>Improved corruption descriptions to reflect the fact that corruption is a measure of perversion.</ul>"
			+"<ul>Offspring are now permanently removed from the encounterable NPC list when you tell them to leave. (I'll add a way to manually find them again in the future.)</ul>"
			+"<ul>Penis, anus, nipple, and vagina sex actions (such as 'Finger him/her' and 'Stroke his/her cock') are now completely hidden until you discover if the NPC has the correct genitals/nipples/anus to perform those actions on.</ul>"
			+"<ul>Removed old lore reference to the arcane making everyone bi-sexual (this was the case before I added sexual orientations to the game).</ul>"
			+"<ul>Moved pregnancy lore information out of the phone's 'Pregnancy stats' page and into a book in Lilaya's library.</ul>"
			+"<ul>Forced TFs will now increase your cum production, where appropriate.</ul>"
			+"<ul>Gynephilic NPCs will now prefer to forcibly TF you into a female, unless they have the 'pregnancy' or 'broodmother' fetishes, in which case they will prefer to TF you into a futanari, shemale, or trap.</ul>"
			+"<ul>Added a masochistic/cum addict variation of the 'dirty clothes' status effect.</ul>"
			+"<ul>Added a 'dirty body' status effect (with matching masochistic/cum addict variation), which is applied if any of your body parts are covered in cum. (Can be removed by washing in your room.)</ul>"

			+"<li>Contributors:</li>"
			+"<ul>Added Linux font compatibility (added Carlito as an alternative font for Calibri). (by PyrophoricPlumage)</ul>"
			+"<ul>Fixed incorrect colour reference. (by CognitiveMist)</ul>"
			+"<ul>Numerous performance improvements. (by CognitiveMist)</ul>"
			+"<ul>Addressed some control flow & code style items. (by CognitiveMist)</ul>"
			+"<ul>Fixed striped leggings, panties, and bra using incorrect colour variables. (by Tukaima)</ul>"

			+"<li>Bugs:</li>"
			+"<ul>NPC orgasms should now function correctly (that is, they should now cum inside when they're supposed to).</ul>"
			+"<ul>Typo fixes (some minor ones in tooltips, changing 'reindeer morph' to be hyphenated like other races, and several other small fixes).</ul>"
			+"<ul>Imported slaves at the auction block no longer spawn in as being pregnant.</ul>"
			+"<ul>Fixed bugs related to Finch's ownership of slaves. (He should now correctly lose ownership of slaves you purchase from the auction block.)</ul>"
			+"<ul>Fixed incorrect penis reveal dialogue (where the NPC would compare your penis size to their own, non-existent penis).</ul>"
			+"<ul>Fixed enchanting bug where crafting a potion to change a certain body type (primarily horns) would then lock out transformation options for other racial potions.</ul>"
			+"<ul>Fixed hypno-watch effect description returning 'command_unknown'.</ul>"
			+"<ul>Slightly changed piercing slot descriptions to reflect whether or not your character knows what the NPC's genitals/nipples look like.</ul>"
			+"<ul>Nyan's inventory is now correctly saved/loaded.</ul>"
			+"<ul>Multiple partner sex scenes should no loner suddenly lose one of the NPC partners.</ul>"
			+"<ul>Fixed major game-freezing bug where if you were on the receiving end of penetrative non-consensual sex, and your partner reached orgasm but you did not, you would get stuck on the 'receive creampie' and 'request pullout' options.</ul>"
			+"<ul>Fixed duplicate actions showing up in Kate's and Lilaya's sex scenes.</ul>"
			+"<ul>When starting from a character import, the flag that sets your having met Brax is now correctly reset.</ul>"
			+"<ul>Fixed minor bug in gender appearance method (masculine characters with no genitals are no assumed to be male if their groin is concealed).</ul>"
			+"<ul>Added correct description variants for NPCs when consuming the harpy matriarchs' special items.</ul>"
			+"<ul>Fixed bug where you could perform anilingus and cunnilingus at the same time. (Also fixed a related bug where multiple penis-related sex actions could be performed.)</ul>"
			+"<ul>Fixed four and five rows of breasts always being described as three.</ul>"
			+"<ul>Fixed issue where in some screens/dialogue/tooltips, incorrect NPC names or stats would be displayed.</ul>"
			+"<ul>Can no longer pull up T-shirt from under concealing/blocking clothing.</ul>"
			+"<ul>NPCs will no longer be stuck at having a fraction of their health, willpower, and stamina.</ul>"
			+"<ul>Vicky's post-sex scene will now correctly no longer reference Arthur's package after you've completed that section of the side-quest.</ul>"
			+"<ul>Importing a game that was exported while the difficulty was set to anything above 'Human' will no loner lock all NPC's levels to being double that of yours.</ul>"
			+"<ul>Slightly improved genetics/inheritance method, so that offspring's ass & hip sizes (and probably a few other things) will now more closely resemble that of their parents.</ul>"
			+"<ul>Fixed bugged arousal gain values in sex.</ul>"
			+"<ul>Winter event Reindeer-morphs will no longer spawn in as human (if your furry settings are set to 'Human', then they'll spawn in as minor Reindeer-morphs).</ul>"
			+"<ul>Reindeer overseers and cultist chapels should now both be able to be accessed if they are on the same tile.</ul>"
			+"<ul>'Spread pussy' action will now transfer lubrication between fingers & vagina.</ul>"
		+ "</list>"

		+ "</br>"

		+ "<list>"
			+ "<h6>v0.1.97.6</h6>"
			+"<li>Other:</li>"
			+"<ul>Removed mutual orgasms (again). They weren't really serving much purpose (the only two instances of mutual orgasms were just appending normal orgasm text together), and were removing your control over your partner's orgasm.</ul>"
			+"<ul>Converted 'generic' partner orgasms into the new system. They're still a little bland at the moment, but I'll write in more detail this week. :3</ul>"
			+"<ul>Reduced default size of horse-morph breasts (from GG to DD), and increased default size of cow-morph breasts (from E to G).</ul>"
				
			+"<li>Bugs:</li>"
			+"<ul><b>Fixed:</b> Game freezes/unresponsive orgasm actions during sex (the 'Stay in position' ones).</ul>"
			+"<ul><b>Fixed:</b> Numerous cases of sex actions becoming unavailable when they shouldn't have been. (You should now be able to perform multiple different 'ongoing' penetrations at once, just like you used to be able to.)</ul>"
			+"<ul>Fixed pregnant characters not working in 'New game (import)', as well as pregnant characters not being imported in Slaver Alley's auction block.</ul>"
			+"<ul>The 'Wash' action in your room will now correctly clean currently equipped clothing.</ul>"
			+"<ul>Fixed quite a few reported typos and instances of incorrect gender/character parsing.</ul>"
			+"<ul>The 'Pull out' orgasm actions will now correctly stop penis penetration.</ul>"
			+"<ul>NPCs in the stocks can no longer manage your or their own clothes.</ul>"
			+"<ul>Fixed bug where your partner's ongoing sex actions would be available to you (such as getting fingering options when your partner would be fingering themselves).</ul>"
			+"<ul>Fixed a few more causes of game freezes/background errors.</ul>"
			+"<ul>Fixed 'Anal tease' sex action sometimes returning a blank description.</ul>"
		+ "</list>"
			
		+ "</br>"

		+ "<list>"
			+ "<h6>v0.1.98</h6>"
			+"<li>Gameplay:</li>"
			+"<ul>Added 'Cum Inflation' option to content preferences screen (on by default).</ul>"
			+"<ul>Reworked and improved creampie status effects, adding new icons, and keeping track of how much cum is currently inside of your orifices. Having the 'masochist' or 'cum addict' fetishes now makes these status effects apply a positive modifier.</ul>"
			+"<ul>Added related status effects for cum inflation, and added in more detailed cum inflation descriptions in orgasms (can be disabled in the content preferences screen).</ul>"
			+"<ul>Further improved orgasm descriptions for all penis modifiers, and added in the start of fluid descriptions. (I ran out of time in which to properly create alcoholic and psychoactive status effects and descriptions.)</ul>"
			+"<ul>Improved UI for changing colour of a body part (in Kate's shop and character creator).</ul>"
			+"<ul>Added the (basic) ability to send slaves to Kate's shop, in order to change their appearance. (I'll expand this and tidy up the UI at a later date.)</ul>"
			+"<ul>Added missionary position (both on back and between legs for both sub and dom) to generic sex scenes. NPCs will now also use this position (if they want to).</ul>"
			
			+"<li>Other:</li>"
			+"<ul>Displacement of clothing is now restored after a sex scene. (So if you start a sex scene with your jacket unbuttoned, it will be re-equipped after sex in its unbuttoned state.)</ul>"
			+"<ul>Reduced arousal gains from characters with the 'Unwilling Fuck-Toy' fetish resisting in sex from 150% normal value, to 125%.</ul>"
			+"<ul>Made all penetrative actions visible in sex scenes, although disabled until you meet their requirements.</ul>"
			+"<ul>Added submissive sex variations for offspring encounters.</ul>"
			
			+"<li>Bugs:</li>"
			+"<ul>Fixed some reported instances of incorrect parsing & typos.</ul>"
			+"<ul>NPCs should no longer repeatedly start/stop penetrations in sex.</ul>"
			+"<ul>Fixed black and grey text colours being inverted.</ul>"
			+"<ul>Fixed unavailable eye colours for demons, wolf-morphs, and cat-morphs.</ul>"
			+"<ul>NPCs should now comment on body parts the first time they're revealed in sex again.</ul>"
			+"<ul>Fixed several instances of orgasms removing ongoing penetrations.</ul>"
			+"<ul>Fixed bug where you could increase the wetness of your vagina even if you didn't have one.</ul>"
			+"<ul>Fixed inconsistent descriptions in being force-fed TF potions.</ul>"
			+"<ul>Fixed bug where loading a saved game would not load any of your clothing's displacements. (All clothing would be reset to having not being displaced.)</ul>"
			+"<ul>Fixed case where multiple types of exposed status effects could be applied at once to one character.</ul>"
			+"<ul>Corrected description of the double-sized bed upgrade in the two-person slave room.</ul>"
			+"<ul>Fixed the bug where when feeding a potion to an NPC (or drinking it yourself) which has a large number of effects, all of the TF descriptions were based on the target's end state.</ul>"
			+"<ul>NPCs will no longer use the last of their stamina on a special attack.</ul>"
			+"<ul>Fixed parsing errors in hypno-watch effects.</ul>"
			+"<ul>Added some more reasonable descriptions for alligator 'body hair' (scales).</ul>"
			+"<ul>Choosing 'Rough'/'Gentle'/'Eager'/'Resisting' options at the start of sex will now correctly start the sex scene with you in that pace.</ul>"
			+"<ul>Fixed bug where you could drop/remove/displace NPC's clothes through the Phone > Contacts > NPC Name tabs.</ul>"
			+"<ul>Fixed not being able to switch positions in Kate's sex scene.</ul>"
			+"<ul>Fixed all offensive spells referencing 'arcane fire'.</ul>"
		+ "</list>"
			
		+ "<list>"
			+ "<h6>v0.1.98.1</h6>"
			+"<li>Bugs:</li>"
			+"<ul>Fixed bug where multiple incompatible penetrations could be performed at once.</ul>"
			+"<ul>Nipple penetration options should no longer appear as a greyed-out option if the character's nipples are not able to be penetrated.</ul>"
			+"<ul>Orgasm descriptions will no longer reference cum if the character that's orgasming doesn't produce any.</ul>"
			+"<ul>Fixed bug where orgasm descriptions were referencing the wrong person. </ul>"
			+"<ul>Fixed bug where NPCs would continuously put you into the missionary position every turn.</ul>"
			+"<ul>Fixed some incorrect name parsing during orgasm descriptions.</ul>"
			+"<ul>Fixed bug where repeating Ralph's discount scene would cause the game to freeze.</ul>"
			+"<ul>Fixed the 'Grow cock' action for demon NPCs setting cum production value to max.</ul>"
			+"<ul>Fixed bug where creampie effects could stop being applied.</ul>"
			+"<ul>NPCs should no longer switch positions the moment before orgasm. (I thought I'd fixed this before, but there was another cause of it.)</ul>"
			+"<ul>Creampie effects should no longer instantly disappear when sex ends.</ul>"
			+"<ul>Fixed Ralph's discount incrementing to the point where he pays you to take his items from him.</ul>"
			+"<ul>(Hopefully) Fixed the error where Lilaya's sex scene would sometimes freeze.</ul>"
		+ "</list>"
		;
	
	public static String disclaimer = "<h6 style='text-align: center; color:"+Colour.GENERIC_ARCANE.toWebHexString()+";'>You must read and agree to the following in order to play this game!</h6>"

			+ "<p>This game is a <b>fictional</b> text-based erotic RPG." + " All content contained within this game forms part of a fictional universe that is not related to real-life places, people or events.</br></br>"

			+ " All of the characters that appear in this story are fictional entities who have given their consent to appear and act in this story."
			+ " If you find yourself concerned for the characters in the story then please be reassured that they are all consenting adults who are speaking lines from a script."
			+ " None of the characters portrayed within this game were or are being harmed in any way during the construction or execution of this game."
			+ " Every character in the game is at least 18 years of age (or is magically the legal age needed to appear in erotic literature in whatever country you are playing this).</br></br>"

			+ "By agreeing to this disclaimer and playing this game you agree to be exposed to graphic sexual and adult content that is presented as part of the game's fictional universe."
			+ " Such content consists of, but is not limited to; graphic depictions of sex, inter-species sex (with fantasy creatures), sexual transformation,"
			+ " rape fantasy/implied lack of consent, mild physical violence, sexual violence, and drug use.</br>"
			+ "Extreme fetish content such as gore/extreme violence, scat, and under/questionable age, is <i>not</i> a part of this game.</br></br>"

			+ "By agreeing to this disclaimer and playing this game you also agree that you are <b>at least 18 years of age</b>,"
			+ " or at least the legal age for you to purchase and view pornographic material in your country if that age is over 18.</br></br>"

			+ "As a final note, the creators of this game wish to stress that the content presented within is entirely fictional and does not reflect any of their personal views or opinions."
			+ " This game has been made in the spirit of creating a piece of artistic interactive literature, and it is imperative that you maintain a clear distinction between reality and the fictional events depicted in this game.</p>";
	
	public static List<CreditsSlot> credits = new ArrayList<>();

	// World generation:
	public static Generation gen;
	@Override
	public void start(Stage primaryStage) throws Exception {

		credits.add(new CreditsSlot("Anonymous", "", 0, 6, 111+61, 37+20));
		

		credits.add(new CreditsSlot("fun_bot", "", 0, 0, 0, 2));
		credits.add(new CreditsSlot("Garth614", "", 0, 0, 0, 2));
		credits.add(new CreditsSlot("Dan", "", 0, 1, 0, 2));
		credits.add(new CreditsSlot("Ash", "", 0, 1, 0, 2));
=======
package com.lilithsthrone.main;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.lilithsthrone.controller.MainController;
import com.lilithsthrone.game.Game;
import com.lilithsthrone.game.Properties;
import com.lilithsthrone.game.character.CharacterUtils;
import com.lilithsthrone.game.character.NameTriplet;
import com.lilithsthrone.game.character.PlayerCharacter;
import com.lilithsthrone.game.character.QuestLine;
import com.lilithsthrone.game.character.body.valueEnums.Femininity;
import com.lilithsthrone.game.character.gender.Gender;
import com.lilithsthrone.game.character.race.RaceStage;
import com.lilithsthrone.game.character.race.RacialBody;
import com.lilithsthrone.game.dialogue.DialogueNodeOld;
import com.lilithsthrone.game.dialogue.MapDisplay;
import com.lilithsthrone.game.dialogue.responses.Response;
import com.lilithsthrone.game.dialogue.story.CharacterCreation;
import com.lilithsthrone.game.dialogue.utils.OptionsDialogue;
import com.lilithsthrone.game.inventory.enchanting.TFEssence;
import com.lilithsthrone.utils.Colour;
import com.lilithsthrone.utils.CreditsSlot;
import com.lilithsthrone.world.Generation;
import com.lilithsthrone.world.WorldType;
import com.lilithsthrone.world.places.PlaceType;

import javafx.application.Application;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * @since 0.1.0
 * @version 0.1.95
 * @author Innoxia
 */
public class Main extends Application {

	public static Game game;

	public static MainController mainController;

	public static Scene mainScene;

	public static Stage primaryStage;
	public static String author = "Innoxia";

	public static final String VERSION_NUMBER = "0.1.95",
			VERSION_DESCRIPTION = "Early Alpha";

	public static final Image WINDOW_IMAGE = new Image("/com/lilithsthrone/res/images/windowIcon32.png");

	private static Properties properties;
	
	public static String patchNotes =
			
//		"<h1 style='text-align:center;'>Version " + Main.VERSION_NUMBER + "</h1>"
//		+ "<h6 style='text-align:center;'><b style='color:" + Colour.GENERIC_TERRIBLE.toWebHexString() + ";'>Buggy Preview!</b></h6>"
//		+ "<h6 style='text-align:center;'><b style='color:" + Colour.GENERIC_BAD.toWebHexString() + ";'>Early Alpha!</b></h6>"
		
		"<p>"
			+ "Hello everyone! :3"
		+ "</p>"
			
		+ "<p>"
			+ "I spent a lot of my time this week getting a lot of work done on designing and programming multiple-partner sex mechanics."
			+ " It isn't finished just yet (as I warned might happen last week), as it's a little complex, but I'm hoping to have it done by next week's release (which is another public release before I take a 1-week Christmas holiday). :3"
		+ "</p>"
			
		+ "<p>"
			+ "In the time I spent working on things other than the multiple-partner sex, I managed to fix a lot of bugs, add thigh-sex, and merge Rfpnj's alligator-morphs into the game! :3"
		+ "</p>"
			
		+ "<p>"
			+ "I hope you enjoy this release, and to those of you who are anticipating the new orgasm/body-part content,"
				+ " please know that I spent a good deal of time planning out how that will fit into the new multiple-partner sex code (which took a while), and that I'll be writing the content in first thing on Monday. :3"
		+ "</p>"
				
		+ "<p>"
			+ "The next release on Friday 22nd December will be another public release, and will include the new orgasm content and a Christmas-related event."
			+ " (I'm hoping for multiple-partner sex to be finished, but it's turning out to be quite a lot of work, so I can't promise it... ;_;)"
		+ "</p>"
			
		+ "<p>"
			+ "Speaking of the next version, it will be 0.1.95, and will have the sole target of getting multiple-partner sex scenes set up in the engine. :3"
		+ "</p>"
		
		+ "<p>"
			+ "Thank you all for playing Lilith's Throne! And a very big thank you to all the people supporting me on Patreon! :3"
		+ "</p>"
		
		+ "<p>"
			+ "If you wanted to ask me any specific questions about the game, you can either find me on my blog, or on the Lilith's Throne Discord. You can find a link to the discord on my blog. ^^"
		+ "</p>"
			
		+ "</br>"

		+ "<list>"
			+ "<h6>v0.1.90.5 (Preview)</h6>"
			+"<li>Gameplay:</li>"
			+"<ul>Finished Zaranix's house placeholders (the ones after fighting Zaranix). Imported games with a version prior to 0.1.95 should reset Zaranix's quest, allowing you to complete it without experiencing bugs (hopefully).</ul>"
			+"<ul>Added in slave's 'molest' action content.</ul>"
			+"<ul>Added wing size to possible transformations.</ul>"
			+"<ul>Added demonic transformation menu to your phone, as a post-combat victory action over demons, and to demon slaves. (The UI really needs a lot more polishing, but it should be fully functional.)</ul>"
			+"<ul>Added month selection to character creation process. (If you want to edit the date after starting the game, simply change the 'date' value in the save's .xml value. The in-game date is that value plus the amount of minutes shown in the 'minutesPassed' value.)</ul>"
			+"<ul>Added public use slaves in the stocks in Slaver Alley.</ul>"
			+"<ul>Added an incubus variation to the succubus alleyway attacker (also set spawn rates for succubi/incubi to be based on your gender preferences). Also improved variety of clothing worn by succubus/incubus attackers. (Some of the text hasn't been updated for the incubus just yet. It will be finished for the next release.)</ul>"
			+"<ul>Added 'public use' as a job for your slaves. When selected, your slaves will be sent to Slaver Alley's public stocks, where they will be used by randomly generated NPCs.</ul>"
			+"<ul>Added self-doggy oral positions.</ul>"
			+"<ul>Added difficulty setting in the options.</ul>"

			+"<li>Other:</li>"
			+"<ul>In-game start date is now set to the current date (instead of 1 week behind).</ul>"
			+"<ul>Added a new name generator for demons.</ul>"
			+"<ul>Slaves can now only clean their clothes/wash their bodies while not at work.</ul>"
				
			+"<li>Contributions:</li>"
			+"<ul>Multiple spelling corrections (submitted via github PR by shutizake).</ul>"

			+"<li>Bugs:</li>"
			+"<ul>Fixed an issue with older character exports not being imported correctly (related to an old personality value being changed in newer versions).</ul>"
			+"<ul>Fixed an issue with used condoms causing game imports to break.</ul>"
			+"<ul>Imported slaves can now be impregnated.</ul>"
			+"<ul>Fixed chemise and pantyhose blocking displacement of each other (which was causing a major crash during sex).</ul>"
			+"<ul>Minor grammatical and typo fixes.</ul>"
			+"<ul>Fixed bug where imported slaves would call you by their own name. (Will take effect for newly exported slaves from now on.)</ul>"
			+"<ul>Slaves should now go to, and return from, work on time. (They were an hour late for both.)</ul>"
			+"<ul>Fixed several causes of major errors when importing old games.</ul>"
			+"<ul>Fixed a few minor dialogue bugs in Zaranix's house.</ul>"
			+"<ul>Fixed major bug of Zaranix's house being repeatable once completed. (I will make it repeatable in the future, but for now it needs to be disabled to avoid major bugs & dialogue inconsistencies.)</ul>"
			+"<ul>Fixed succubi only ever using the 'back-to-wall' position.</ul>"
			+"<ul>Fixed bug where some slaves would have unchangeable names like 'horse-girl'.</ul>"
			+"<ul>Stopped used condoms from being able to be spawned in using the debug menu (as it was causing issues).</ul>"
			+"<ul>Versions prior to 0.1.95 will now have all NPC's hair lengths reset to default values (to address broken hair lengths in older versions).</ul>"
		+"</list>"
			
		+ "</br>"

		+ "<list>"
			+ "<h6>v0.1.95</h6>"
			+"<li>Gameplay & Sex:</li>"
			+"<ul>Added a small (<5%) chance for alleyway attackers to be alligator morphs. (I'll move them into Submission when I add that area.)</ul>"
			+"<ul><b>Added thigh sex</b> and associated thigh-related sex status effect (both receiving and performing action variants for both NPC's and PC's dom and sub paces).</ul>"
				
			+"<li>Contributions:</li>"
			+"<ul><b>Added alligator-morphs</b>, with associated items/consumables/transformations. (by rfpnj)</ul>"
			+"<ul>Added a black variation to the lab coat. (by rfpnj)</ul>"
			+"<ul>Improved NPC prostitution methods, which now allows males to be prostitutes, as well as providing a price based on the prostitute's body. (by tukaima)</ul>"
				
			+"<li>Other:</li>"
			+"<ul>The blazer item of clothing now conceals the wearer's chest and waist until unbuttoned.</ul>"
			+"<ul>Changed kissing dirty talk.</ul>"
			+"<ul>Added paizuri-specific dirty talk.</ul>"
			+"<ul>Added bovine-specific horns to HornTypes, to resolve the issue of horn races being inconsistent between demons and cow-morphs.</ul>"
			+"<ul>You can now pull down the Milk Maid's dress to expose breasts & nipples.</ul>"
			+"<ul>Lab coats now block breasts/genitals/ass, and can be unbuttoned and pulled up to reveal blocked parts.</ul>"
			+"<ul>Added option to pay for submissive sex with NPC prostitutes.</ul>"
			+"<ul>Added the full demonic transformations menu to the witch cultists.</ul>"
			+"<ul>Fixed several inconsistencies in the new incubus encounter dialogue.</ul>"
				
			+"<li>Bugs:</li>"
			+"<ul>Fixed cause of characters present screen not opening.</ul>"
			+"<ul>Fixed (another) major bug related to game importing.</ul>"
			+"<ul>Flat-chested characters will no longer have their nipple be referred to as 'teats'.</ul>"
			+"<ul>Fixed multiple virginity loss readings in body description.</ul>"
			+"<ul>Corrected hair length in character viewer's stats panel to be displayed in inches.</ul>"
			+"<ul>Characters that are imported while wearing enchanted gear will now correctly have that gear's stats applied. (Before you would not receive gear bonuses upon import, and would then suffer attribute decreases when unequipping that clothing.)</ul>"
			+"<ul>Slave settings now import correctly (cleanliness settings will no longer reset on import).</ul>"
			+"<ul>Slaves locked in public use stocks will now have their nipples fucked (if they are accessible and are able to be penetrated).</ul>"
			+"<ul>Slave rooms (as well as all other places in all maps) will now correctly import all additions (such as obedience trainers, room service, arcane instruments, etc.).</ul>"
			+"<ul>Fixed major import error caused by the game trying to load the old position 'DOGGY_ORAL_PLAYER_ON_ALL_FOURS'.</ul>"
			+"<ul>Fixed incorrect transformation dialogue for NPCs who are forcibly transforming you.</ul>"
			+"<ul>Fixed minor description error in wing transformations.</ul>"
			+"<ul>Imported characters now correctly keep their available perk points.</ul>"
			+"<ul>Fixed bug with Zaranix's non-violent resolution option not being available.</ul>"
			+"<ul>Fixed bug where Arthur wouldn't be moved to Lilaya's Lab (this should correct itself when you import your game into this new version).</ul>"
			+"<ul>The 'Submissive talk' option in Lilaya's sex scene is now linked to the Submissive fetish.</ul>"
			+"<ul>Tidied up the total mess that was the 'repeat actions' tab in sex.</ul>"
			+"<ul>Androgynous characters will no longer be able to spawn in with a beard.</ul>"
			+"<ul>Growing horns now sets their starting length value to 'small' (2 inches), if their previous length is 0.</ul>"
			+"<ul>Changing difficulty level now correctly resets the health/willpower/stamina of all NPCs.</ul>"
			+"<ul>The 'pent up' status effect for slaves is now calculated based on the last time they orgasmed, not the last time they had sex, allowing you to have sex with your slave and stop before they orgasm to leave them pent-up.</ul>"
			+"<ul>Fixed bug where slaves were not getting paid and working when they weren't supposed to.</ul>"
				
			+"<li>Demonic transformation menu bugs:</li>"
			+"<ul>Iris shape and pupil shape now work correctly on NPCs.</ul>"
			+"<ul>Changing lip size now works correctly on all characters.</ul>"
			+"<ul>Added options to change lip & throat colour.</ul>"
			+"<ul>Changing hair colour now correctly changes the target's hair colour, instead of their skin colour.</ul>"
			+"<ul>Fixed bug where you couldn't turn off orifice or penis modifiers.</ul>"
			+"<ul>Added options to change throat and tongue modifiers.</ul>"
			+"<ul>You can now set ass and hip sizes to any value.</ul>"
			+"<ul>Removed duplicate lactation menu.</ul>"
			+"<ul>Added options to set elasticity, plasticity, wetness and capacity for anus.</ul>"
			+"<ul>Minor typo fixes.</ul>"
		+ "</list>"
		;
	
	public static String disclaimer = "<h6 style='text-align: center; color:"+Colour.GENERIC_ARCANE.toWebHexString()+";'>You must read and agree to the following in order to play this game!</h6>"

			+ "<p>This game is a <b>fictional</b> text-based erotic RPG." + " All content contained within this game forms part of a fictional universe that is not related to real-life places, people or events.</br></br>"

			+ " All of the characters that appear in this story are fictional entities who have given their consent to appear and act in this story."
			+ " If you find yourself concerned for the characters in the story then please be reassured that they are all consenting adults who are speaking lines from a script."
			+ " None of the characters portrayed within this game were or are being harmed in any way during the construction or execution of this game."
			+ " Every character in the game is at least 18 years of age (or is magically the legal age needed to appear in erotic literature in whatever country you are playing this).</br></br>"

			+ "By agreeing to this disclaimer and playing this game you agree to be exposed to graphic sexual and adult content that is presented as part of the game's fictional universe."
			+ " Such content consists of, but is not limited to; graphic depictions of sex, inter-species sex (with fantasy creatures), sexual transformation,"
			+ " rape fantasy/implied lack of consent, mild physical violence, sexual violence, and drug use.</br>"
			+ "Extreme fetish content such as gore/extreme violence, scat, and under/questionable age, is <i>not</i> a part of this game.</br></br>"

			+ "By agreeing to this disclaimer and playing this game you also agree that you are <b>at least 18 years of age</b>,"
			+ " or at least the legal age for you to purchase and view pornographic material in your country if that age is over 18.</br></br>"

			+ "As a final note, the creators of this game wish to stress that the content presented within is entirely fictional and does not reflect any of their personal views or opinions."
			+ " This game has been made in the spirit of creating a piece of artistic interactive literature, and it is imperative that you maintain a clear distinction between reality and the fictional events depicted in this game.</p>";
	
	public static List<CreditsSlot> credits = new ArrayList<>();

	// World generation:
	public static Generation gen;
	@Override
	public void start(Stage primaryStage) throws Exception {

=======
package com.lilithsthrone.main;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.lilithsthrone.controller.MainController;
import com.lilithsthrone.game.Game;
import com.lilithsthrone.game.Properties;
import com.lilithsthrone.game.character.CharacterUtils;
import com.lilithsthrone.game.character.NameTriplet;
import com.lilithsthrone.game.character.PlayerCharacter;
import com.lilithsthrone.game.character.QuestLine;
import com.lilithsthrone.game.character.body.valueEnums.Femininity;
import com.lilithsthrone.game.character.gender.Gender;
import com.lilithsthrone.game.character.race.RaceStage;
import com.lilithsthrone.game.character.race.RacialBody;
import com.lilithsthrone.game.dialogue.DialogueNodeOld;
import com.lilithsthrone.game.dialogue.MapDisplay;
import com.lilithsthrone.game.dialogue.responses.Response;
import com.lilithsthrone.game.dialogue.story.CharacterCreation;
import com.lilithsthrone.game.dialogue.utils.OptionsDialogue;
import com.lilithsthrone.game.inventory.enchanting.TFEssence;
import com.lilithsthrone.utils.Colour;
import com.lilithsthrone.utils.CreditsSlot;
import com.lilithsthrone.world.Generation;
import com.lilithsthrone.world.WorldType;
import com.lilithsthrone.world.places.PlaceType;

import javafx.application.Application;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * @since 0.1.0
 * @version 0.1.95
 * @author Innoxia
 */
public class Main extends Application {

	public static Game game;

	public static MainController mainController;

	public static Scene mainScene;

	public static Stage primaryStage;
	public static String author = "Innoxia";

	public static final String VERSION_NUMBER = "0.1.95",
			VERSION_DESCRIPTION = "Early Alpha";

	public static final Image WINDOW_IMAGE = new Image("/com/lilithsthrone/res/images/windowIcon32.png");

	private static Properties properties;
	
	public static String patchNotes =
			
//		"<h1 style='text-align:center;'>Version " + Main.VERSION_NUMBER + "</h1>"
//		+ "<h6 style='text-align:center;'><b style='color:" + Colour.GENERIC_TERRIBLE.toWebHexString() + ";'>Buggy Preview!</b></h6>"
//		+ "<h6 style='text-align:center;'><b style='color:" + Colour.GENERIC_BAD.toWebHexString() + ";'>Early Alpha!</b></h6>"
		
		"<p>"
			+ "Hello everyone! :3"
		+ "</p>"
			
		+ "<p>"
			+ "I spent a lot of my time this week getting a lot of work done on designing and programming multiple-partner sex mechanics."
			+ " It isn't finished just yet (as I warned might happen last week), as it's a little complex, but I'm hoping to have it done by next week's release (which is another public release before I take a 1-week Christmas holiday). :3"
		+ "</p>"
			
		+ "<p>"
			+ "In the time I spent working on things other than the multiple-partner sex, I managed to fix a lot of bugs, add thigh-sex, and merge Rfpnj's alligator-morphs into the game! :3"
		+ "</p>"
			
		+ "<p>"
			+ "I hope you enjoy this release, and to those of you who are anticipating the new orgasm/body-part content,"
				+ " please know that I spent a good deal of time planning out how that will fit into the new multiple-partner sex code (which took a while), and that I'll be writing the content in first thing on Monday. :3"
		+ "</p>"
				
		+ "<p>"
			+ "The next release on Friday 22nd December will be another public release, and will include the new orgasm content and a Christmas-related event."
			+ " (I'm hoping for multiple-partner sex to be finished, but it's turning out to be quite a lot of work, so I can't promise it... ;_;)"
		+ "</p>"
			
		+ "<p>"
			+ "Speaking of the next version, it will be 0.1.95, and will have the sole target of getting multiple-partner sex scenes set up in the engine. :3"
		+ "</p>"
		
		+ "<p>"
			+ "Thank you all for playing Lilith's Throne! And a very big thank you to all the people supporting me on Patreon! :3"
		+ "</p>"
		
		+ "<p>"
			+ "If you wanted to ask me any specific questions about the game, you can either find me on my blog, or on the Lilith's Throne Discord. You can find a link to the discord on my blog. ^^"
		+ "</p>"
			
		+ "</br>"

		+ "<list>"
			+ "<h6>v0.1.90.5 (Preview)</h6>"
			+"<li>Gameplay:</li>"
			+"<ul>Finished Zaranix's house placeholders (the ones after fighting Zaranix). Imported games with a version prior to 0.1.95 should reset Zaranix's quest, allowing you to complete it without experiencing bugs (hopefully).</ul>"
			+"<ul>Added in slave's 'molest' action content.</ul>"
			+"<ul>Added wing size to possible transformations.</ul>"
			+"<ul>Added demonic transformation menu to your phone, as a post-combat victory action over demons, and to demon slaves. (The UI really needs a lot more polishing, but it should be fully functional.)</ul>"
			+"<ul>Added month selection to character creation process. (If you want to edit the date after starting the game, simply change the 'date' value in the save's .xml value. The in-game date is that value plus the amount of minutes shown in the 'minutesPassed' value.)</ul>"
			+"<ul>Added public use slaves in the stocks in Slaver Alley.</ul>"
			+"<ul>Added an incubus variation to the succubus alleyway attacker (also set spawn rates for succubi/incubi to be based on your gender preferences). Also improved variety of clothing worn by succubus/incubus attackers. (Some of the text hasn't been updated for the incubus just yet. It will be finished for the next release.)</ul>"
			+"<ul>Added 'public use' as a job for your slaves. When selected, your slaves will be sent to Slaver Alley's public stocks, where they will be used by randomly generated NPCs.</ul>"
			+"<ul>Added self-doggy oral positions.</ul>"
			+"<ul>Added difficulty setting in the options.</ul>"

			+"<li>Other:</li>"
			+"<ul>In-game start date is now set to the current date (instead of 1 week behind).</ul>"
			+"<ul>Added a new name generator for demons.</ul>"
			+"<ul>Slaves can now only clean their clothes/wash their bodies while not at work.</ul>"
				
			+"<li>Contributions:</li>"
			+"<ul>Multiple spelling corrections (submitted via github PR by shutizake).</ul>"

			+"<li>Bugs:</li>"
			+"<ul>Fixed an issue with older character exports not being imported correctly (related to an old personality value being changed in newer versions).</ul>"
			+"<ul>Fixed an issue with used condoms causing game imports to break.</ul>"
			+"<ul>Imported slaves can now be impregnated.</ul>"
			+"<ul>Fixed chemise and pantyhose blocking displacement of each other (which was causing a major crash during sex).</ul>"
			+"<ul>Minor grammatical and typo fixes.</ul>"
			+"<ul>Fixed bug where imported slaves would call you by their own name. (Will take effect for newly exported slaves from now on.)</ul>"
			+"<ul>Slaves should now go to, and return from, work on time. (They were an hour late for both.)</ul>"
			+"<ul>Fixed several causes of major errors when importing old games.</ul>"
			+"<ul>Fixed a few minor dialogue bugs in Zaranix's house.</ul>"
			+"<ul>Fixed major bug of Zaranix's house being repeatable once completed. (I will make it repeatable in the future, but for now it needs to be disabled to avoid major bugs & dialogue inconsistencies.)</ul>"
			+"<ul>Fixed succubi only ever using the 'back-to-wall' position.</ul>"
			+"<ul>Fixed bug where some slaves would have unchangeable names like 'horse-girl'.</ul>"
			+"<ul>Stopped used condoms from being able to be spawned in using the debug menu (as it was causing issues).</ul>"
			+"<ul>Versions prior to 0.1.95 will now have all NPC's hair lengths reset to default values (to address broken hair lengths in older versions).</ul>"
		+"</list>"
			
		+ "</br>"

		+ "<list>"
			+ "<h6>v0.1.95</h6>"
			+"<li>Gameplay & Sex:</li>"
			+"<ul>Added a small (<5%) chance for alleyway attackers to be alligator morphs. (I'll move them into Submission when I add that area.)</ul>"
			+"<ul><b>Added thigh sex</b> and associated thigh-related sex status effect (both receiving and performing action variants for both NPC's and PC's dom and sub paces).</ul>"
				
			+"<li>Contributions:</li>"
			+"<ul><b>Added alligator-morphs</b>, with associated items/consumables/transformations. (by rfpnj)</ul>"
			+"<ul>Added a black variation to the lab coat. (by rfpnj)</ul>"
			+"<ul>Improved NPC prostitution methods, which now allows males to be prostitutes, as well as providing a price based on the prostitute's body. (by tukaima)</ul>"
				
			+"<li>Other:</li>"
			+"<ul>The blazer item of clothing now conceals the wearer's chest and waist until unbuttoned.</ul>"
			+"<ul>Changed kissing dirty talk.</ul>"
			+"<ul>Added paizuri-specific dirty talk.</ul>"
			+"<ul>Added bovine-specific horns to HornTypes, to resolve the issue of horn races being inconsistent between demons and cow-morphs.</ul>"
			+"<ul>You can now pull down the Milk Maid's dress to expose breasts & nipples.</ul>"
			+"<ul>Lab coats now block breasts/genitals/ass, and can be unbuttoned and pulled up to reveal blocked parts.</ul>"
			+"<ul>Added option to pay for submissive sex with NPC prostitutes.</ul>"
			+"<ul>Added the full demonic transformations menu to the witch cultists.</ul>"
			+"<ul>Fixed several inconsistencies in the new incubus encounter dialogue.</ul>"
				
			+"<li>Bugs:</li>"
			+"<ul>Fixed cause of characters present screen not opening.</ul>"
			+"<ul>Fixed (another) major bug related to game importing.</ul>"
			+"<ul>Flat-chested characters will no longer have their nipple be referred to as 'teats'.</ul>"
			+"<ul>Fixed multiple virginity loss readings in body description.</ul>"
			+"<ul>Corrected hair length in character viewer's stats panel to be displayed in inches.</ul>"
			+"<ul>Characters that are imported while wearing enchanted gear will now correctly have that gear's stats applied. (Before you would not receive gear bonuses upon import, and would then suffer attribute decreases when unequipping that clothing.)</ul>"
			+"<ul>Slave settings now import correctly (cleanliness settings will no longer reset on import).</ul>"
			+"<ul>Slaves locked in public use stocks will now have their nipples fucked (if they are accessible and are able to be penetrated).</ul>"
			+"<ul>Slave rooms (as well as all other places in all maps) will now correctly import all additions (such as obedience trainers, room service, arcane instruments, etc.).</ul>"
			+"<ul>Fixed major import error caused by the game trying to load the old position 'DOGGY_ORAL_PLAYER_ON_ALL_FOURS'.</ul>"
			+"<ul>Fixed incorrect transformation dialogue for NPCs who are forcibly transforming you.</ul>"
			+"<ul>Fixed minor description error in wing transformations.</ul>"
			+"<ul>Imported characters now correctly keep their available perk points.</ul>"
			+"<ul>Fixed bug with Zaranix's non-violent resolution option not being available.</ul>"
			+"<ul>Fixed bug where Arthur wouldn't be moved to Lilaya's Lab (this should correct itself when you import your game into this new version).</ul>"
			+"<ul>The 'Submissive talk' option in Lilaya's sex scene is now linked to the Submissive fetish.</ul>"
			+"<ul>Tidied up the total mess that was the 'repeat actions' tab in sex.</ul>"
			+"<ul>Androgynous characters will no longer be able to spawn in with a beard.</ul>"
			+"<ul>Growing horns now sets their starting length value to 'small' (2 inches), if their previous length is 0.</ul>"
			+"<ul>Changing difficulty level now correctly resets the health/willpower/stamina of all NPCs.</ul>"
			+"<ul>The 'pent up' status effect for slaves is now calculated based on the last time they orgasmed, not the last time they had sex, allowing you to have sex with your slave and stop before they orgasm to leave them pent-up.</ul>"
			+"<ul>Fixed bug where slaves were not getting paid and working when they weren't supposed to.</ul>"
				
			+"<li>Demonic transformation menu bugs:</li>"
			+"<ul>Iris shape and pupil shape now work correctly on NPCs.</ul>"
			+"<ul>Changing lip size now works correctly on all characters.</ul>"
			+"<ul>Added options to change lip & throat colour.</ul>"
			+"<ul>Changing hair colour now correctly changes the target's hair colour, instead of their skin colour.</ul>"
			+"<ul>Fixed bug where you couldn't turn off orifice or penis modifiers.</ul>"
			+"<ul>Added options to change throat and tongue modifiers.</ul>"
			+"<ul>You can now set ass and hip sizes to any value.</ul>"
			+"<ul>Removed duplicate lactation menu.</ul>"
			+"<ul>Added options to set elasticity, plasticity, wetness and capacity for anus.</ul>"
			+"<ul>Minor typo fixes.</ul>"
		+ "</list>"
		;
	
	public static String disclaimer = "<h6 style='text-align: center; color:"+Colour.GENERIC_ARCANE.toWebHexString()+";'>You must read and agree to the following in order to play this game!</h6>"

			+ "<p>This game is a <b>fictional</b> text-based erotic RPG." + " All content contained within this game forms part of a fictional universe that is not related to real-life places, people or events.</br></br>"

			+ " All of the characters that appear in this story are fictional entities who have given their consent to appear and act in this story."
			+ " If you find yourself concerned for the characters in the story then please be reassured that they are all consenting adults who are speaking lines from a script."
			+ " None of the characters portrayed within this game were or are being harmed in any way during the construction or execution of this game."
			+ " Every character in the game is at least 18 years of age (or is magically the legal age needed to appear in erotic literature in whatever country you are playing this).</br></br>"

			+ "By agreeing to this disclaimer and playing this game you agree to be exposed to graphic sexual and adult content that is presented as part of the game's fictional universe."
			+ " Such content consists of, but is not limited to; graphic depictions of sex, inter-species sex (with fantasy creatures), sexual transformation,"
			+ " rape fantasy/implied lack of consent, mild physical violence, sexual violence, and drug use.</br>"
			+ "Extreme fetish content such as gore/extreme violence, scat, and under/questionable age, is <i>not</i> a part of this game.</br></br>"

			+ "By agreeing to this disclaimer and playing this game you also agree that you are <b>at least 18 years of age</b>,"
			+ " or at least the legal age for you to purchase and view pornographic material in your country if that age is over 18.</br></br>"

			+ "As a final note, the creators of this game wish to stress that the content presented within is entirely fictional and does not reflect any of their personal views or opinions."
			+ " This game has been made in the spirit of creating a piece of artistic interactive literature, and it is imperative that you maintain a clear distinction between reality and the fictional events depicted in this game.</p>";
	
	public static List<CreditsSlot> credits = new ArrayList<>();

	// World generation:
	public static Generation gen;
	@Override
	public void start(Stage primaryStage) throws Exception {

>>>>>>> 600d4dc merge and chair update
		credits.add(new CreditsSlot("Anonymous", "", 0, 6, 117, 38));
		

		credits.add(new CreditsSlot("fun_bot", "", 0, 0, 0, 1));
		credits.add(new CreditsSlot("WodashGSJ", "", 0, 0, 1, 0));
		credits.add(new CreditsSlot("Dan", "", 0, 1, 0, 1));
		credits.add(new CreditsSlot("Cryostorm", "", 0, 0, 1, 0));
		credits.add(new CreditsSlot("Testostetyrone", "", 0, 0, 1, 0));
		credits.add(new CreditsSlot("Tanall", "", 0, 1, 3, 0));
		credits.add(new CreditsSlot("vasadariu", "", 0, 0, 1, 0));
		credits.add(new CreditsSlot("Casper &quot;Cdaser&quot; D.", "", 0, 0, 1, 0));
		credits.add(new CreditsSlot("Ash", "", 0, 1, 0, 1));
		credits.add(new CreditsSlot("BLKCandy", "", 0, 0, 1, 0));
>>>>>>> 78d186e upstream
		
		credits.add(new CreditsSlot("WodashGSJ", "", 0, 0, 2, 0));
		credits.add(new CreditsSlot("vasadariu", "", 0, 0, 1, 0));
		credits.add(new CreditsSlot("Casper &quot;Cdaser&quot; D.", "", 0, 0, 2, 0));
		credits.add(new CreditsSlot("Cryostorm", "", 0, 0, 2, 0));
		credits.add(new CreditsSlot("BLKCandy", "", 0, 0, 2, 0));
		credits.add(new CreditsSlot("Testostetyrone", "", 0, 0, 2, 0));
		credits.add(new CreditsSlot("Brandon Stach", "", 0, 0, 2, 0));
		credits.add(new CreditsSlot("CMPirate9867", "", 0, 0, 2, 0));

		credits.add(new CreditsSlot("Zakarin", "", 0, 0, 0, 1));
		credits.add(new CreditsSlot("Demonicgamer666", "", 0, 0, 0, 1));
		credits.add(new CreditsSlot("masterpuppet", "", 0, 0, 2, 0));

		credits.add(new CreditsSlot("Endness", "", 0, 0, 0, 1));
		credits.add(new CreditsSlot("Aleskah", "", 0, 0, 0, 1));
		credits.add(new CreditsSlot("The Void Prince", "", 0, 0, 1, 0));
		
<<<<<<< Upstream, based on upstream/master
		
		
		
<<<<<<< Upstream, based on upstream/master
		credits.add(new CreditsSlot("Adhana Konker", "", 0, 0, 3, 0));
		credits.add(new CreditsSlot("Lexi <3", "", 0, 0, 0, 1));
		credits.add(new CreditsSlot("48days", "", 0, 0, 2, 4));
		credits.add(new CreditsSlot("Spaghetti Code", "", 0, 0, 2, 0));
		credits.add(new CreditsSlot("SchALLieS", "", 0, 0, 0, 5));
		credits.add(new CreditsSlot("Argmoe", "", 0, 0, 5, 0));
		credits.add(new CreditsSlot("HoneyNutQueerios", "", 0, 0, 3, 0));
		credits.add(new CreditsSlot("Arkhan", "", 0, 0, 6, 0));
		credits.add(new CreditsSlot("Avery", "", 0, 1, 4, 0));
		credits.add(new CreditsSlot("b00marrows", "", 0, 1, 5, 0));
		credits.add(new CreditsSlot("Baz GoldenClaw", "", 0, 0, 4, 0));
		credits.add(new CreditsSlot("Runehood66", "", 0, 0, 0, 4));
		credits.add(new CreditsSlot("Blackcanine", "", 0, 0, 4, 0));
		credits.add(new CreditsSlot("Blacktouch", "", 0, 0, 2, 4));
		credits.add(new CreditsSlot("Blue999", "", 0, 0, 0, 6));
		credits.add(new CreditsSlot("BreakerB", "", 0, 0, 3, 0));
		credits.add(new CreditsSlot("BRobort", "", 0, 0, 6, 0));
		credits.add(new CreditsSlot("BloodsailXXII", "", 0, 0, 0, 6));
		credits.add(new CreditsSlot("Burt", "", 0, 0, 4, 0));
		credits.add(new CreditsSlot("Calrak", "", 0, 0, 0, 5));
		credits.add(new CreditsSlot("CelestialNightmare", "", 0, 0, 0, 6));
		credits.add(new CreditsSlot("Sxythe", "", 0, 0, 0, 2));
		credits.add(new CreditsSlot("Lexi the slut", "", 0, 0, 0, 6));
		credits.add(new CreditsSlot("Vmpireassassin (Chloe)", "", 0, 0, 0, 1));
		credits.add(new CreditsSlot("crashtestdummy", "", 0, 0, 6, 0));
		credits.add(new CreditsSlot("Crimson", "", 0, 0, 0, 4));
		credits.add(new CreditsSlot("Cursed Rena", "", 0, 0, 1, 4));
		credits.add(new CreditsSlot("DeadMasterZero", "", 0, 0, 1, 0));
		credits.add(new CreditsSlot("Destont", "", 0, 0, 3, 0));
		credits.add(new CreditsSlot("Yllarius", "", 0, 0, 2, 0));
		credits.add(new CreditsSlot("John Scarlet", "", 0, 0, 0, 1));
		credits.add(new CreditsSlot("rinoskin", "", 0, 0, 0, 2));
		credits.add(new CreditsSlot("Alatar", "", 0, 0, 0, 2));
		credits.add(new CreditsSlot("Elmsdor", "", 0, 0, 0, 6));
		credits.add(new CreditsSlot("Gr33n B3ans", "", 0, 0, 0, 2));
		credits.add(new CreditsSlot("Farseeker", "", 0, 0, 5, 0));
		credits.add(new CreditsSlot("pupslut felix", "", 0, 0, 0, 4));
		credits.add(new CreditsSlot("Fenrakk101", "", 0, 0, 5, 0));
		credits.add(new CreditsSlot("Fiona", "", 0, 0, 0, 6));
		credits.add(new CreditsSlot("ForeverFree2MeTaMax", "", 0, 0, 6, 0));
		credits.add(new CreditsSlot("Niki Parks", "", 0, 0, 6, 0));
		credits.add(new CreditsSlot("Georgio154", "", 0, 0, 1, 4));
		credits.add(new CreditsSlot("glocknar", "", 0, 0, 3, 0));
		credits.add(new CreditsSlot("Krissy2017", "", 0, 0, 0, 4));
		credits.add(new CreditsSlot("Grakcnar", "", 0, 0, 4, 0));
		credits.add(new CreditsSlot("Hedgehog", "", 0, 0, 0, 3));
		credits.add(new CreditsSlot("Bocaj91", "", 0, 0, 0, 4));
		credits.add(new CreditsSlot("Krejil", "", 0, 0, 4, 0));
		credits.add(new CreditsSlot("suka", "", 0, 0, 6, 0));
		credits.add(new CreditsSlot("EnigmaticYoshi", "", 0, 0, 6, 0));
		credits.add(new CreditsSlot("HerrKommissar11", "", 0, 0, 1, 2));
		credits.add(new CreditsSlot("Kelly999", "", 0, 1, 3, 0));
		credits.add(new CreditsSlot("kenshin5491", "", 0, 0, 5, 0));
		credits.add(new CreditsSlot("Kestrel", "", 0, 0, 6, 0));
		credits.add(new CreditsSlot("Kiroberos", "", 0, 0, 0, 4));
		credits.add(new CreditsSlot("Kernog", "", 0, 0, 1, 0));
		credits.add(new CreditsSlot("Knight-Lord Xander", "", 0, 0, 0, 6));
		credits.add(new CreditsSlot("Chris Turpin", "", 0, 0, 4, 0));
		credits.add(new CreditsSlot("Pallid", "", 0, 0, 0, 5));
		credits.add(new CreditsSlot("Mr L", "", 0, 0, 4, 1));
		credits.add(new CreditsSlot("loveless", "", 0, 0, 0, 6));
		credits.add(new CreditsSlot("Vaddex", "", 0, 0, 0, 3));
		credits.add(new CreditsSlot("KingofKings", "", 0, 0, 0, 6));
		credits.add(new CreditsSlot("waaaghkus", "", 0, 0, 6, 0));
		credits.add(new CreditsSlot("Nightmare", "", 0, 0, 0, 5));
		credits.add(new CreditsSlot("AlphaOneBravo", "", 0, 0, 0, 6));
		credits.add(new CreditsSlot("Max Nobody", "", 0, 0, 0, 6));
		credits.add(new CreditsSlot("Muhaku", "", 0, 0, 4, 0));
		credits.add(new CreditsSlot("Nick LaBlue", "", 0, 0, 5, 0));
		credits.add(new CreditsSlot("Kvernik", "", 0, 0, 4, 0));
		credits.add(new CreditsSlot("Niko", "", 0, 0, 6, 0));
		credits.add(new CreditsSlot("Odd8Ball", "", 0, 0, 0, 5));
		credits.add(new CreditsSlot("Party Commissar", "", 0, 0, 4, 0));
		credits.add(new CreditsSlot("Rohsie", "", 0, 0, 0, 6));
		credits.add(new CreditsSlot("P.", "", 0, 0, 0, 4));
		credits.add(new CreditsSlot("Pierre Mura", "", 0, 0, 0, 6));
		credits.add(new CreditsSlot("Pokys", "", 0, 0, 6, 0));
		credits.add(new CreditsSlot("QQQ", "", 0, 0, 0, 6));
		credits.add(new CreditsSlot("Rakesh", "", 0, 0, 5, 0));
		credits.add(new CreditsSlot("Master's dumb bitch", "", 0, 0, 0, 6));
		credits.add(new CreditsSlot("redwulfen", "", 0, 0, 0, 5));
		credits.add(new CreditsSlot("RogueRandom", "", 0, 0, 3, 0));
		credits.add(new CreditsSlot("Horagen81", "", 0, 0, 0, 5));
		credits.add(new CreditsSlot("RyubosJ", "", 0, 0, 3, 0));
		credits.add(new CreditsSlot("Saladine the Legendary", "", 0, 0, 0, 6));
		credits.add(new CreditsSlot("S", "", 0, 0, 1, 5));
		credits.add(new CreditsSlot("Shas'O Dal'yth Kauyon Kais Taku", "", 0, 0, 6, 0));
		credits.add(new CreditsSlot("Crow Invictus", "", 0, 0, 5, 0));
		credits.add(new CreditsSlot("Sheltem", "", 0, 0, 4, 0));
		credits.add(new CreditsSlot("Sig", "", 0, 0, 4, 0));
		credits.add(new CreditsSlot("Silentark", "", 0, 0, 3, 0));
		credits.add(new CreditsSlot("Sorter", "", 0, 0, 0, 6));
		credits.add(new CreditsSlot("Spookermen", "", 0, 0, 0, 6));
		credits.add(new CreditsSlot("Swift Shot", "", 0, 0, 6, 0));
		credits.add(new CreditsSlot("TalonMort", "", 0, 0, 4, 0));
		credits.add(new CreditsSlot("Tanall", "", 0, 1, 3, 0));
		credits.add(new CreditsSlot("Tanner D.", "", 0, 0, 0, 5));
		credits.add(new CreditsSlot("Terrance", "", 0, 0, 3, 0));
		credits.add(new CreditsSlot("Jordan Aitken", "", 0, 0, 6, 0));
		credits.add(new CreditsSlot("T. Garou", "", 0, 0, 0, 4));
		credits.add(new CreditsSlot("Timmybond24", "", 0, 0, 0, 4));
		credits.add(new CreditsSlot("Torinir", "", 0, 0, 6, 0));
		credits.add(new CreditsSlot("Torsten015", "", 0, 0, 0, 5));
		credits.add(new CreditsSlot("TreenVall", "", 0, 0, 2, 0));
		credits.add(new CreditsSlot("triangleman", "", 0, 0, 5, 0));
		credits.add(new CreditsSlot("Antriad", "", 0, 0, 1, 2));
		credits.add(new CreditsSlot("Isidoros", "", 0, 0, 5, 0));
		credits.add(new CreditsSlot("Vaelin", "", 0, 0, 4, 0));
		credits.add(new CreditsSlot("iloveyouMiaoNiNi", "", 0, 0, 0, 6));
		credits.add(new CreditsSlot("Whatever", "", 0, 0, 4, 0));
		credits.add(new CreditsSlot("William Brown", "", 0, 0, 5, 1));
		credits.add(new CreditsSlot("Wolfregis", "", 0, 0, 0, 6));
		credits.add(new CreditsSlot("Nelson Adams", "", 0, 0, 6, 0));
		
		
		credits.sort(Comparator.comparing((CreditsSlot a) -> a.getName().toLowerCase()));
		
		
		Main.primaryStage = primaryStage;

		Main.primaryStage.getIcons().add(WINDOW_IMAGE);

		Main.primaryStage.setTitle("Lilith's Throne " + VERSION_NUMBER + " " + VERSION_DESCRIPTION);
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/lilithsthrone/res/fxml/main.fxml"));

		Pane pane = loader.load();

		mainScene = new Scene(pane);

		if (properties.lightTheme) {
			mainScene.getStylesheets().add("/com/lilithsthrone/res/css/stylesheet_light.css");
		} else {
			mainScene.getStylesheets().add("/com/lilithsthrone/res/css/stylesheet.css");
		}

		mainController = loader.getController();
		Main.primaryStage.setScene(mainScene);
		Main.primaryStage.show();
		Main.game = new Game();
		
		loader = new FXMLLoader(getClass().getResource("/com/lilithsthrone/res/fxml/main.fxml"));
		try {
			if (Main.mainScene == null) {
				pane = loader.load();
				Main.mainController = loader.getController();

				Main.mainScene = new Scene(pane);
				if (Main.getProperties().lightTheme)
					Main.mainScene.getStylesheets().add("/com/lilithsthrone/res/css/stylesheet_light.css");
				else
					Main.mainScene.getStylesheets().add("/com/lilithsthrone/res/css/stylesheet.css");
			}

			Main.primaryStage.setScene(Main.mainScene);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Main.game.setContent(new Response("", "", OptionsDialogue.MENU));
		
	}

	public static void main(String[] args) {
		
		// Create folders:
		File dir = new File("data/");
		dir.mkdir();
		dir = new File("data/saves");
		dir.mkdir();
		dir = new File("data/characters");
		dir.mkdir();
		
		// Load properties:
		if (new File("data/properties.xml").exists()) {
			try {
				properties = new Properties();
				properties.loadPropertiesFromXML();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} else {
			properties = new Properties();
			properties.savePropertiesAsXML();
		}
		
		launch(args);
	}
	
	/**
	 * Starts a completely new game. Runs a new World Generation.
	 */
	public static void startNewGame(DialogueNodeOld startingDialogueNode) {
		
		Main.game = new Game();
		
		// Generate world:
		if (!(gen == null))
			if (gen.isRunning()) {
				gen.cancel();
			}

		gen = new Generation();

		gen.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
			@Override
			public void handle(WorkerStateEvent t) {
				
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/lilithsthrone/res/fxml/main.fxml"));
				Pane pane;
				try {
					if (Main.mainScene == null) {
						pane = loader.load();
						Main.mainController = loader.getController();

						Main.mainScene = new Scene(pane);
						if (Main.getProperties().lightTheme)
							Main.mainScene.getStylesheets().add("/com/lilithsthrone/res/css/stylesheet_light.css");
						else
							Main.mainScene.getStylesheets().add("/com/lilithsthrone/res/css/stylesheet.css");
					}

					Main.primaryStage.setScene(Main.mainScene);

				} catch (Exception e) {
					e.printStackTrace();
				}
				Main.game.setPlayer(new PlayerCharacter(new NameTriplet("Player"), "", 1, Gender.M_P_MALE, RacialBody.HUMAN, RaceStage.HUMAN, null, WorldType.EMPTY, PlaceType.GENERIC_MUSEUM));

				Main.game.initNewGame(startingDialogueNode);
				
				Main.game.endTurn(0);
				//Main.mainController.processNewDialogue();
			}
		});
		new Thread(gen).start();
	}
	
	public static boolean isVersionOlderThan(String versionToCheck, String versionToCheckAgainst) {
		String[] v1 = versionToCheck.split("\\.");
		String[] v2 = versionToCheckAgainst.split("\\.");
		
		try {
			if(Integer.valueOf(v1[0]) < Integer.valueOf(v2[0])) {
				return true;
			}
			
			if(Integer.valueOf((v1[1].length()==1?v1[1]+"0":v1[1])) < Integer.valueOf((v2[1].length()==1?v2[1]+"0":v2[1]))) {
				return true;
			}
			
			if(Integer.valueOf((v1[2].length()==1?v1[2]+"0":v1[2])) < Integer.valueOf((v2[2].length()==1?v2[2]+"0":v2[2]))) {
				return true;
			}
			
			if(v1.length<4) {
				if(v2.length<4) {
					return false;
				} else {
					return true;
				}
			}
			if(v2.length<4) {
				return false;
			}
			
			if(Integer.valueOf((v1[3].length()==1?v1[3]+"0":v1[3])) < Integer.valueOf((v2[3].length()==1?v2[3]+"0":v2[3]))) {
				return true;
			}
		} catch(Exception ex) {
			return true;
		}
		
		return false;
	}
	
	public static int getFontSize() {
		return properties.fontSize;
	}

	public static void setFontSize(int size) {
		properties.fontSize = size;
		properties.savePropertiesAsXML();
	}
	
	
	public static void quickSaveGame() {
		if (Main.game.isInCombat()) {
			Main.game.flashMessage(Colour.GENERIC_BAD, "Cannot quicksave while in combat!");
			
		} else if (Main.game.isInSex()) {
			Main.game.flashMessage(Colour.GENERIC_BAD, "Cannot quicksave while in sex!");
			
		} else if (Main.game.getCurrentDialogueNode().getMapDisplay()!=MapDisplay.NORMAL) {
			Main.game.flashMessage(Colour.GENERIC_BAD, "Can only quicksave in a normal scene!");
			
		} else {
			Main.getProperties().lastQuickSaveName = "QuickSave_"+Main.game.getPlayer().getName();
			saveGame("QuickSave_"+Main.game.getPlayer().getName(), true);
		}
	}

	public static void quickLoadGame() {
		String name = "QuickSave_"+Main.game.getPlayer().getName();
		
//		if(new File("data/saves/"+name+".lts").exists()) {
			loadGame(name);
//		} else {
//			loadGame(Main.getProperties().lastQuickSaveName);
//		}
	}

	public static boolean isSaveGameAvailable() {
		return Main.game.isStarted() && Main.game.getSavedDialogueNode() == DebugDialogue.getDefaultDialogueNoEncounter();
	}
	
	public static void saveGame(String name, boolean allowOverwrite) {
		if (name.length()==0) {
			Main.game.flashMessage(Colour.GENERIC_BAD, "Name too short!");
			return;
		}
		if (name.length() > 32) {
			Main.game.flashMessage(Colour.GENERIC_BAD, "Name too long!");
			return;
		}
		if (!name.matches("[a-zA-Z0-9]+[a-zA-Z0-9' _]*")) {
			Main.game.flashMessage(Colour.GENERIC_BAD, "Incompatible characters!");
			return;
		}
		
		Game.exportGame(name, allowOverwrite);

		try {
			properties.lastSaveLocation = name;//"data/saves/"+name+".lts";
			properties.nameColour = Femininity.valueOf(game.getPlayer().getFemininityValue()).getColour().toWebHexString();
			properties.name = game.getPlayer().getName();
			properties.level = game.getPlayer().getLevel();
			properties.money = game.getPlayer().getMoney();
			properties.arcaneEssences = game.getPlayer().getEssenceCount(TFEssence.ARCANE);
			properties.race = game.getPlayer().getRace().getName();
			properties.quest = game.getPlayer().getQuest(QuestLine.MAIN).getName();

			properties.savePropertiesAsXML();


		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static boolean isLoadGameAvailable(String name) {
		File file = new File("data/saves/"+name+".xml");

		return file.exists();
	}
	
	public static void loadGame(String name) {
		if (isLoadGameAvailable(name)) {
			Game.importGame(name);
		}
	}
	
	public static void deleteGame(String name) {
		File file = new File("data/saves/"+name+".xml");

		if (file.exists()) {
			try {
				file.delete();
				Main.game.setContent(new Response("", "", Main.game.getCurrentDialogueNode()));
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			
		} else {
			Main.game.flashMessage(Colour.GENERIC_BAD, "File not found...");
		}
	}
	
	public static void deleteExportedGame(String name) {
		File file = new File("data/saves/"+name+".xml");

		if (file.exists()) {
			try {
				file.delete();
				Main.game.setContent(new Response("", "", Main.game.getCurrentDialogueNode()));
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			
		} else {
			Main.game.flashMessage(Colour.GENERIC_BAD, "File not found...");
		}
	}
	
	public static void deleteExportedCharacter(String name) {
		File file = new File("data/characters/"+name+".xml");

		if (file.exists()) {
			try {
				file.delete();
				Main.game.setContent(new Response("", "", Main.game.getCurrentDialogueNode()));
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			
		} else {
			Main.game.flashMessage(Colour.GENERIC_BAD, "File not found...");
		}
	}
	
	public static List<File> getSavedGames() {
		List<File> filesList = new ArrayList<>();
		
		File dir = new File("data/saves");
		if (dir.isDirectory()) {
			File[] directoryListing = dir.listFiles((path, name) -> name.endsWith(".xml"));
			if (directoryListing != null) {
				filesList.addAll(Arrays.asList(directoryListing));
			}
		}

		filesList.sort(Comparator.comparingLong(File::lastModified).reversed());
		
		return filesList;
	}
	
	public static List<File> getCharactersForImport() {
		List<File> filesList = new ArrayList<>();
		
		File dir = new File("data/characters");
		if (dir.isDirectory()) {
			File[] directoryListing = dir.listFiles((path, name) -> name.endsWith(".xml"));
			if (directoryListing != null) {
				filesList.addAll(Arrays.asList(directoryListing));
			}
		}

		filesList.sort(Comparator.comparingLong(File::lastModified).reversed());
		
		return filesList;
	}
	
	public static List<File> getSlavesForImport() {
		List<File> filesList = new ArrayList<>();
		
		File dir = new File("data/characters");
		if (dir.isDirectory()) {
			File[] directoryListing = dir.listFiles((path, name) -> name.endsWith(".xml"));
			if (directoryListing != null) {
				filesList.addAll(Arrays.asList(directoryListing));
			}
		}
		
		filesList.sort(Comparator.comparingLong(File::lastModified).reversed());
		
		return filesList;
	}
	
	public static List<File> getGamesForImport() {
		List<File> filesList = new ArrayList<>();
		
		File dir = new File("data/saves");
		if (dir.isDirectory()) {
			File[] directoryListing = dir.listFiles((path, name) -> name.endsWith(".xml"));
			if (directoryListing != null) {
				filesList.addAll(Arrays.asList(directoryListing));
			}
		}

		filesList.sort(Comparator.comparingLong(File::lastModified).reversed());
		
		return filesList;
	}
	
	public static void importCharacter(File file) {
		if (file != null) {
			try {
				Main.game.setPlayer(CharacterUtils.startLoadingCharacterFromXML());
				Main.game.setPlayer(CharacterUtils.loadCharacterFromXML(file, Main.game.getPlayer(), CharacterImportSetting.NO_PREGNANCY));
				
				Main.game.getPlayer().getSlavesOwned().clear();
				Main.game.getPlayer().endPregnancy(false);
				
				Main.game.setRenderAttributesSection(true);
				Main.game.clearTextStartStringBuilder();
				Main.game.clearTextEndStringBuilder();
				Main.getProperties().setNewWeaponDiscovered(false);
				Main.getProperties().setNewClothingDiscovered(false);
				Main.getProperties().setNewItemDiscovered(false);
				Main.game.getPlayer().calculateStatusEffects(0);

				Main.game.initNewGame(CharacterCreation.START_GAME_WITH_IMPORT);
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	public static Properties getProperties() {
		return properties;
	}

	public static void saveProperties() {
		properties.savePropertiesAsXML();
	}
}
=======
		
		
		
		
		
		credits.add(new CreditsSlot("Adhana Konker", "", 0, 0, 3, 0));
		credits.add(new CreditsSlot("Lexi <3", "", 0, 0, 0, 1));
		credits.add(new CreditsSlot("48days", "", 0, 0, 2, 3));
		credits.add(new CreditsSlot("Spaghetti Code", "", 0, 0, 2, 0));
		credits.add(new CreditsSlot("SchALLieS", "", 0, 0, 0, 4));
		credits.add(new CreditsSlot("Argmoe", "", 0, 0, 4, 0));
		credits.add(new CreditsSlot("HoneyNutQueerios", "", 0, 0, 2, 0));
		credits.add(new CreditsSlot("Arkhan", "", 0, 0, 5, 0));
		credits.add(new CreditsSlot("Avery", "", 0, 1, 2, 0));
		credits.add(new CreditsSlot("b00marrows", "", 0, 1, 4, 0));
		credits.add(new CreditsSlot("Baz GoldenClaw", "", 0, 0, 3, 0));
		credits.add(new CreditsSlot("Runehood66", "", 0, 0, 0, 1));
		credits.add(new CreditsSlot("Blackcanine", "", 0, 0, 3, 0));
		credits.add(new CreditsSlot("Blacktouch", "", 0, 0, 2, 3));
		credits.add(new CreditsSlot("Blue999", "", 0, 0, 0, 5));
		credits.add(new CreditsSlot("BreakerB", "", 0, 0, 2, 0));
		credits.add(new CreditsSlot("BRobort", "", 0, 0, 5, 0));
		credits.add(new CreditsSlot("BloodsailXXII", "", 0, 0, 0, 5));
		credits.add(new CreditsSlot("Burt", "", 0, 0, 3, 0));
		credits.add(new CreditsSlot("Calrak", "", 0, 0, 0, 4));
		credits.add(new CreditsSlot("CelestialNightmare", "", 0, 0, 0, 5));
		credits.add(new CreditsSlot("Sxythe", "", 0, 0, 0, 2));
		credits.add(new CreditsSlot("Lexi the slut", "", 0, 0, 0, 5));
		credits.add(new CreditsSlot("Vmpireassassin (Chloe)", "", 0, 0, 0, 1));
		credits.add(new CreditsSlot("crashtestdummy", "", 0, 0, 5, 0));
		credits.add(new CreditsSlot("Crimson", "", 0, 0, 0, 3));
		credits.add(new CreditsSlot("Cursed Rena", "", 0, 0, 1, 3));
		credits.add(new CreditsSlot("DeadMasterZero", "", 0, 0, 1, 0));
		credits.add(new CreditsSlot("Destont", "", 0, 0, 2, 0));
		credits.add(new CreditsSlot("Yllarius", "", 0, 0, 2, 0));
		credits.add(new CreditsSlot("John Scarlet", "", 0, 0, 0, 1));
		credits.add(new CreditsSlot("rinoskin", "", 0, 0, 0, 2));
		credits.add(new CreditsSlot("Alatar", "", 0, 0, 0, 2));
		credits.add(new CreditsSlot("Elmsdor", "", 0, 0, 0, 5));
		credits.add(new CreditsSlot("Gr33n B3ans", "", 0, 0, 0, 2));
		credits.add(new CreditsSlot("Farseeker", "", 0, 0, 4, 0));
		credits.add(new CreditsSlot("pupslut felix", "", 0, 0, 0, 3));
		credits.add(new CreditsSlot("Fenrakk101", "", 0, 0, 4, 0));
		credits.add(new CreditsSlot("Fiona", "", 0, 0, 0, 5));
		credits.add(new CreditsSlot("ForeverFree2MeTaMax", "", 0, 0, 5, 0));
		credits.add(new CreditsSlot("Niki Parks", "", 0, 0, 5, 0));
		credits.add(new CreditsSlot("Georgio154", "", 0, 0, 1, 3));
		credits.add(new CreditsSlot("glocknar", "", 0, 0, 2, 0));
		credits.add(new CreditsSlot("Krissy2017", "", 0, 0, 0, 3));
		credits.add(new CreditsSlot("Grakcnar", "", 0, 0, 3, 0));
		credits.add(new CreditsSlot("Hedgehog", "", 0, 0, 0, 2));
		credits.add(new CreditsSlot("Bocaj91", "", 0, 0, 0, 3));
		credits.add(new CreditsSlot("Krejil", "", 0, 0, 3, 0));
		credits.add(new CreditsSlot("suka", "", 0, 0, 5, 0));
		credits.add(new CreditsSlot("Enigamatic Yoshi", "", 0, 0, 5, 0));
		credits.add(new CreditsSlot("HerrKommissar11", "", 0, 0, 1, 1));
		credits.add(new CreditsSlot("Kelly999", "", 0, 1, 2, 0));
		credits.add(new CreditsSlot("kenshin5491", "", 0, 0, 4, 0));
		credits.add(new CreditsSlot("Kestrel", "", 0, 0, 5, 0));
		credits.add(new CreditsSlot("Kiroberos", "", 0, 0, 0, 3));
		credits.add(new CreditsSlot("Kernog", "", 0, 0, 1, 0));
		credits.add(new CreditsSlot("Knight-Lord Xander", "", 0, 0, 0, 5));
		credits.add(new CreditsSlot("Chris Turpin", "", 0, 0, 3, 0));
		credits.add(new CreditsSlot("Pallid", "", 0, 0, 0, 5));
		credits.add(new CreditsSlot("Mr L", "", 0, 0, 4, 0));
		credits.add(new CreditsSlot("loveless", "", 0, 0, 0, 5));
		credits.add(new CreditsSlot("Vaddex", "", 0, 0, 0, 2));
		credits.add(new CreditsSlot("KingofKings", "", 0, 0, 0, 5));
		credits.add(new CreditsSlot("waaaghkus", "", 0, 0, 5, 0));
		credits.add(new CreditsSlot("Nightmare", "", 0, 0, 0, 5));
		credits.add(new CreditsSlot("AlphaOneBravo", "", 0, 0, 0, 5));
		credits.add(new CreditsSlot("Max Nobody", "", 0, 0, 0, 5));
		credits.add(new CreditsSlot("Muhaku", "", 0, 0, 3, 0));
		credits.add(new CreditsSlot("Nick LaBlue", "", 0, 0, 4, 0));
		credits.add(new CreditsSlot("Kvernik", "", 0, 0, 3, 0));
		credits.add(new CreditsSlot("Niko", "", 0, 0, 5, 0));
		credits.add(new CreditsSlot("Odd8Ball", "", 0, 0, 0, 4));
		credits.add(new CreditsSlot("Party Commissar", "", 0, 0, 3, 0));
		credits.add(new CreditsSlot("Rohsie", "", 0, 0, 0, 5));
		credits.add(new CreditsSlot("P.", "", 0, 0, 0, 4));
		credits.add(new CreditsSlot("Pierre Mura", "", 0, 0, 0, 5));
		credits.add(new CreditsSlot("Pokys", "", 0, 0, 5, 0));
		credits.add(new CreditsSlot("QQQ", "", 0, 0, 0, 5));
		credits.add(new CreditsSlot("Rakesh", "", 0, 0, 4, 0));
		credits.add(new CreditsSlot("Master's dumb bitch", "", 0, 0, 0, 5));
		credits.add(new CreditsSlot("redwulfen", "", 0, 0, 0, 4));
		credits.add(new CreditsSlot("RogueRandom", "", 0, 0, 2, 0));
		credits.add(new CreditsSlot("Horagen81", "", 0, 0, 0, 4));
		credits.add(new CreditsSlot("RyubosJ", "", 0, 0, 2, 0));
		credits.add(new CreditsSlot("Saladine", "", 0, 0, 0, 5));
		credits.add(new CreditsSlot("S", "", 0, 0, 1, 4));
		credits.add(new CreditsSlot("Shas'O Dal'yth Kauyon Kais Taku", "", 0, 0, 5, 0));
		credits.add(new CreditsSlot("Crow Invictus", "", 0, 0, 4, 0));
		credits.add(new CreditsSlot("Sheltem", "", 0, 0, 3, 0));
		credits.add(new CreditsSlot("Silentark", "", 0, 0, 2, 0));
		credits.add(new CreditsSlot("Sorter", "", 0, 0, 0, 5));
		credits.add(new CreditsSlot("Spookermen", "", 0, 0, 0, 5));
		credits.add(new CreditsSlot("Swift Shot", "", 0, 0, 5, 0));
		credits.add(new CreditsSlot("TalonMort", "", 0, 0, 3, 0));
		credits.add(new CreditsSlot("Tanner D.", "", 0, 0, 0, 4));
		credits.add(new CreditsSlot("Terrance", "", 0, 0, 3, 0));
		credits.add(new CreditsSlot("Jordan Aitken", "", 0, 0, 5, 0));
		credits.add(new CreditsSlot("T. Garou", "", 0, 0, 0, 3));
		credits.add(new CreditsSlot("Timmybond24", "", 0, 0, 0, 3));
		credits.add(new CreditsSlot("Torinir", "", 0, 0, 5, 0));
		credits.add(new CreditsSlot("Torsten015", "", 0, 0, 0, 4));
		credits.add(new CreditsSlot("TreenVall", "", 0, 0, 2, 0));
		credits.add(new CreditsSlot("triangleman", "", 0, 0, 5, 0));
		credits.add(new CreditsSlot("Antriad", "", 0, 0, 1, 1));
		credits.add(new CreditsSlot("Isidoros", "", 0, 0, 4, 0));
		credits.add(new CreditsSlot("Vaelin", "", 0, 0, 4, 0));
		credits.add(new CreditsSlot("iloveyouMiaoNiNi", "", 0, 0, 0, 5));
		credits.add(new CreditsSlot("Whatever", "", 0, 0, 3, 0));
		credits.add(new CreditsSlot("William Brown", "", 0, 0, 5, 0));
		credits.add(new CreditsSlot("Wolfregis", "", 0, 0, 0, 5));
		credits.add(new CreditsSlot("Nelson Adams", "", 0, 0, 5, 0));
		
		
		credits.sort(Comparator.comparing((CreditsSlot a) -> a.getName().toLowerCase()));
		
		
		Main.primaryStage = primaryStage;

		Main.primaryStage.getIcons().add(WINDOW_IMAGE);

		Main.primaryStage.setTitle("Lilith's Throne " + VERSION_NUMBER + " " + VERSION_DESCRIPTION);
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/lilithsthrone/res/fxml/main.fxml"));

		Pane pane = loader.load();

		mainScene = new Scene(pane);

		if (properties.lightTheme) {
			mainScene.getStylesheets().add("/com/lilithsthrone/res/css/stylesheet_light.css");
		} else {
			mainScene.getStylesheets().add("/com/lilithsthrone/res/css/stylesheet.css");
		}

		mainController = loader.getController();
		Main.primaryStage.setScene(mainScene);
		Main.primaryStage.show();
		Main.game = new Game();
		
		loader = new FXMLLoader(getClass().getResource("/com/lilithsthrone/res/fxml/main.fxml"));
		try {
			if (Main.mainScene == null) {
				pane = loader.load();
				Main.mainController = loader.getController();

				Main.mainScene = new Scene(pane);
				if (Main.getProperties().lightTheme)
					Main.mainScene.getStylesheets().add("/com/lilithsthrone/res/css/stylesheet_light.css");
				else
					Main.mainScene.getStylesheets().add("/com/lilithsthrone/res/css/stylesheet.css");
			}

			Main.primaryStage.setScene(Main.mainScene);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Main.game.setContent(new Response("", "", OptionsDialogue.MENU));
		
	}

	public static void main(String[] args) {
		
		// Create folders:
		File dir = new File("data/");
		dir.mkdir();
		dir = new File("data/saves");
		dir.mkdir();
		dir = new File("data/characters");
		dir.mkdir();
		
		// Load properties:
		if (new File("data/properties.xml").exists()) {
			try {
				properties = new Properties();
				properties.loadPropertiesFromXML();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} else {
			properties = new Properties();
			properties.savePropertiesAsXML();
		}
		
		launch(args);
	}
	
	/**
	 * Starts a completely new game. Runs a new World Generation.
	 */
	public static void startNewGame(DialogueNodeOld startingDialogueNode) {
		
		Main.game = new Game();
		
		// Generate world:
		if (!(gen == null))
			if (gen.isRunning()) {
				gen.cancel();
			}

		gen = new Generation();

		gen.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
			@Override
			public void handle(WorkerStateEvent t) {
				
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/lilithsthrone/res/fxml/main.fxml"));
				Pane pane;
				try {
					if (Main.mainScene == null) {
						pane = loader.load();
						Main.mainController = loader.getController();

						Main.mainScene = new Scene(pane);
						if (Main.getProperties().lightTheme)
							Main.mainScene.getStylesheets().add("/com/lilithsthrone/res/css/stylesheet_light.css");
						else
							Main.mainScene.getStylesheets().add("/com/lilithsthrone/res/css/stylesheet.css");
					}

					Main.primaryStage.setScene(Main.mainScene);

				} catch (Exception e) {
					e.printStackTrace();
				}
				Main.game.setPlayer(new PlayerCharacter(new NameTriplet("Player"), "", 1, Gender.M_P_MALE, RacialBody.HUMAN, RaceStage.HUMAN, null, WorldType.EMPTY, PlaceType.GENERIC_MUSEUM));

				Main.game.initNewGame(startingDialogueNode);
				
				Main.game.endTurn(0);
				//Main.mainController.processNewDialogue();
			}
		});
		new Thread(gen).start();
	}
	
	public static boolean isVersionOlderThan(String versionToCheck, String versionToCheckAgainst) {
		String[] v1 = versionToCheck.split("\\.");
		String[] v2 = versionToCheckAgainst.split("\\.");
		
		try {
			if(Integer.valueOf(v1[0]) < Integer.valueOf(v2[0])) {
				return true;
			}
			
			if(Integer.valueOf((v1[1].length()==1?v1[1]+"0":v1[1])) < Integer.valueOf((v2[1].length()==1?v2[1]+"0":v2[1]))) {
				return true;
			}
			
			if(Integer.valueOf((v1[2].length()==1?v1[2]+"0":v1[2])) < Integer.valueOf((v2[2].length()==1?v2[2]+"0":v2[2]))) {
				return true;
			}
			
			if(v1.length<4) {
				if(v2.length<4) {
					return false;
				} else {
					return true;
				}
			}
			if(v2.length<4) {
				return false;
			}
			
			if(Integer.valueOf((v1[3].length()==1?v1[3]+"0":v1[3])) < Integer.valueOf((v2[3].length()==1?v2[3]+"0":v2[3]))) {
				return true;
			}
		} catch(Exception ex) {
			return true;
		}
		
		return false;
	}
	
	public static int getFontSize() {
		return properties.fontSize;
	}

	public static void setFontSize(int size) {
		properties.fontSize = size;
		properties.savePropertiesAsXML();
	}
	
	
	public static void quickSaveGame() {
		if (Main.game.isInCombat()) {
			Main.game.flashMessage(Colour.GENERIC_BAD, "Cannot quicksave while in combat!");
			
		} else if (Main.game.isInSex()) {
			Main.game.flashMessage(Colour.GENERIC_BAD, "Cannot quicksave while in sex!");
			
		} else if (Main.game.getCurrentDialogueNode().getMapDisplay()!=MapDisplay.NORMAL) {
			Main.game.flashMessage(Colour.GENERIC_BAD, "Can only quicksave in a normal scene!");
			
		} else {
			Main.getProperties().lastQuickSaveName = "QuickSave_"+Main.game.getPlayer().getName();
			saveGame("QuickSave_"+Main.game.getPlayer().getName(), true);
		}
	}

	public static void quickLoadGame() {
		String name = "QuickSave_"+Main.game.getPlayer().getName();
		
//		if(new File("data/saves/"+name+".lts").exists()) {
			loadGame(name);
//		} else {
//			loadGame(Main.getProperties().lastQuickSaveName);
//		}
	}

	public static void saveGame(String name, boolean allowOverwrite) {
		if (name.length()==0) {
			Main.game.flashMessage(Colour.GENERIC_BAD, "Name too short!");
			return;
		}
		if (name.length() > 32) {
			Main.game.flashMessage(Colour.GENERIC_BAD, "Name too long!");
			return;
		}
		if (!name.matches("[a-zA-Z0-9]+[a-zA-Z0-9' _]*")) {
			Main.game.flashMessage(Colour.GENERIC_BAD, "Incompatible characters!");
			return;
		}
		
		File dir = new File("data/");
		dir.mkdir();

		dir = new File("data/saves");
		dir.mkdir();
		
		boolean overwrite = false;
		if (dir.isDirectory()) {
			File[] directoryListing = dir.listFiles((path, filename) -> filename.endsWith(".lts"));
			if (directoryListing != null) {
				for (File child : directoryListing) {
					if (child.getName().equals(name+".lts")){
						if(!allowOverwrite) {
							Main.game.flashMessage(Colour.GENERIC_BAD, "Name already exists!");
							return;
						} else {
							overwrite = true;
						}
					}
				}
			}
		}
		
		File file = new File("data/saves/"+name+".lts");
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
//			long timeStart = System.nanoTime();
//			System.out.println(timeStart);
			
			try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
			  oos.writeObject(Main.game);
			  oos.close();
			}
			
//			System.out.println("Difference: "+(System.nanoTime()-timeStart)/1000000000f);

			properties.lastSaveLocation = name;//"data/saves/"+name+".lts";
			properties.nameColour = Femininity.valueOf(game.getPlayer().getFemininityValue()).getColour().toWebHexString();
			properties.name = game.getPlayer().getName();
			properties.level = game.getPlayer().getLevel();
			properties.money = game.getPlayer().getMoney();
			properties.arcaneEssences = game.getPlayer().getEssenceCount(TFEssence.ARCANE);
			properties.race = game.getPlayer().getRace().getName();
			properties.quest = game.getPlayer().getQuest(QuestLine.MAIN).getName();

			properties.savePropertiesAsXML();


		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		if(Main.game.getCurrentDialogueNode() == OptionsDialogue.SAVE_LOAD) {
			if(overwrite) {
				Main.game.setContent(new Response("", "", Main.game.getCurrentDialogueNode()), Colour.GENERIC_GOOD, "Save game overwritten!");
			} else {
				Main.game.setContent(new Response("", "", Main.game.getCurrentDialogueNode()), Colour.GENERIC_GOOD, "Game saved!");
			}
		} else if(name.equals("QuickSave_"+Main.game.getPlayer().getName())){
			Main.game.flashMessage(Colour.GENERIC_GOOD, "Quick saved!");
		}
	}

	public static void loadGame(String name) {
		
		File file = new File("data/saves/"+name+".lts");
		
		if (file.exists()) {
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
				Main.game = (Game) ois.readObject();
				Main.game.reloadContent();
				if (Main.game.getCurrentDialogueNode().getMapDisplay() == MapDisplay.OPTIONS) {
					Main.mainController.openOptions();
				}
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			
		} else {
			Main.game.flashMessage(Colour.GENERIC_BAD, "File not found...");
		}
	}
	
	public static void deleteGame(String name) {
		File file = new File("data/saves/"+name+".lts");

		if (file.exists()) {
			try {
				file.delete();
				Main.game.setContent(new Response("", "", Main.game.getCurrentDialogueNode()));
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			
		} else {
			Main.game.flashMessage(Colour.GENERIC_BAD, "File not found...");
		}
	}
	
	public static void deleteExportedGame(String name) {
		File file = new File("data/saves/"+name+".xml");

		if (file.exists()) {
			try {
				file.delete();
				Main.game.setContent(new Response("", "", Main.game.getCurrentDialogueNode()));
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			
		} else {
			Main.game.flashMessage(Colour.GENERIC_BAD, "File not found...");
		}
	}
	
	public static void deleteExportedCharacter(String name) {
		File file = new File("data/characters/"+name+".xml");

		if (file.exists()) {
			try {
				file.delete();
				Main.game.setContent(new Response("", "", Main.game.getCurrentDialogueNode()));
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			
		} else {
			Main.game.flashMessage(Colour.GENERIC_BAD, "File not found...");
		}
	}
	
	public static List<File> getSavedGames() {
		List<File> filesList = new ArrayList<>();
		
		File dir = new File("data/saves");
		if (dir.isDirectory()) {
			File[] directoryListing = dir.listFiles((path, name) -> name.endsWith(".lts"));
			if (directoryListing != null) {
				filesList.addAll(Arrays.asList(directoryListing));
			}
		}

		filesList.sort(Comparator.comparingLong(File::lastModified).reversed());
		
		return filesList;
	}
	
	public static List<File> getCharactersForImport() {
		List<File> filesList = new ArrayList<>();
		
		File dir = new File("data/characters");
		if (dir.isDirectory()) {
			File[] directoryListing = dir.listFiles((path, name) -> name.endsWith(".xml"));
			if (directoryListing != null) {
				filesList.addAll(Arrays.asList(directoryListing));
			}
		}

		filesList.sort(Comparator.comparingLong(File::lastModified).reversed());
		
		return filesList;
	}
	
	public static List<File> getSlavesForImport() {
		List<File> filesList = new ArrayList<>();
		
		File dir = new File("data/characters");
		if (dir.isDirectory()) {
			File[] directoryListing = dir.listFiles((path, name) -> name.endsWith(".xml"));
			if (directoryListing != null) {
				filesList.addAll(Arrays.asList(directoryListing));
			}
		}
		
		filesList.sort(Comparator.comparingLong(File::lastModified).reversed());
		
		return filesList;
	}
	
	public static List<File> getGamesForImport() {
		List<File> filesList = new ArrayList<>();
		
		File dir = new File("data/saves");
		if (dir.isDirectory()) {
			File[] directoryListing = dir.listFiles((path, name) -> name.endsWith(".xml"));
			if (directoryListing != null) {
				filesList.addAll(Arrays.asList(directoryListing));
			}
		}

		filesList.sort(Comparator.comparingLong(File::lastModified).reversed());
		
		return filesList;
	}
	
	public static void importCharacter(File file) {
		if (file != null) {
			try {
				Main.game.setPlayer(CharacterUtils.startLoadingCharacterFromXML());
				Main.game.setPlayer(CharacterUtils.loadCharacterFromXML(file, Main.game.getPlayer()));
				
				Main.game.getPlayer().getSlavesOwned().clear();
				Main.game.getPlayer().endPregnancy(false);
				
				Main.game.setRenderAttributesSection(true);
				Main.game.clearTextStartStringBuilder();
				Main.game.clearTextEndStringBuilder();
				Main.getProperties().setNewWeaponDiscovered(false);
				Main.getProperties().setNewClothingDiscovered(false);
				Main.getProperties().setNewItemDiscovered(false);
				Main.game.getPlayer().calculateStatusEffects(0);

				Main.game.initNewGame(CharacterCreation.START_GAME_WITH_IMPORT);
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	public static Properties getProperties() {
		return properties;
	}

	public static void saveProperties() {
		properties.savePropertiesAsXML();
	}
}
>>>>>>> 78d186e upstream
=======
		
		
		
		
		credits.add(new CreditsSlot("Adhana Konker", "", 0, 0, 3, 0));
		credits.add(new CreditsSlot("Lexi <3", "", 0, 0, 0, 1));
		credits.add(new CreditsSlot("48days", "", 0, 0, 2, 3));
		credits.add(new CreditsSlot("Spaghetti Code", "", 0, 0, 2, 0));
		credits.add(new CreditsSlot("SchALLieS", "", 0, 0, 0, 4));
		credits.add(new CreditsSlot("Argmoe", "", 0, 0, 4, 0));
		credits.add(new CreditsSlot("HoneyNutQueerios", "", 0, 0, 2, 0));
		credits.add(new CreditsSlot("Arkhan", "", 0, 0, 5, 0));
		credits.add(new CreditsSlot("Avery", "", 0, 1, 2, 0));
		credits.add(new CreditsSlot("b00marrows", "", 0, 1, 4, 0));
		credits.add(new CreditsSlot("Baz GoldenClaw", "", 0, 0, 3, 0));
		credits.add(new CreditsSlot("Runehood66", "", 0, 0, 0, 1));
		credits.add(new CreditsSlot("Blackcanine", "", 0, 0, 3, 0));
		credits.add(new CreditsSlot("Blacktouch", "", 0, 0, 2, 3));
		credits.add(new CreditsSlot("Blue999", "", 0, 0, 0, 5));
		credits.add(new CreditsSlot("BreakerB", "", 0, 0, 2, 0));
		credits.add(new CreditsSlot("BRobort", "", 0, 0, 5, 0));
		credits.add(new CreditsSlot("BloodsailXXII", "", 0, 0, 0, 5));
		credits.add(new CreditsSlot("Burt", "", 0, 0, 3, 0));
		credits.add(new CreditsSlot("Calrak", "", 0, 0, 0, 4));
		credits.add(new CreditsSlot("CelestialNightmare", "", 0, 0, 0, 5));
		credits.add(new CreditsSlot("Sxythe", "", 0, 0, 0, 2));
		credits.add(new CreditsSlot("Lexi the slut", "", 0, 0, 0, 5));
		credits.add(new CreditsSlot("Vmpireassassin (Chloe)", "", 0, 0, 0, 1));
		credits.add(new CreditsSlot("crashtestdummy", "", 0, 0, 5, 0));
		credits.add(new CreditsSlot("Crimson", "", 0, 0, 0, 3));
		credits.add(new CreditsSlot("Cursed Rena", "", 0, 0, 1, 3));
		credits.add(new CreditsSlot("DeadMasterZero", "", 0, 0, 1, 0));
		credits.add(new CreditsSlot("Destont", "", 0, 0, 2, 0));
		credits.add(new CreditsSlot("Yllarius", "", 0, 0, 2, 0));
		credits.add(new CreditsSlot("John Scarlet", "", 0, 0, 0, 1));
		credits.add(new CreditsSlot("rinoskin", "", 0, 0, 0, 2));
		credits.add(new CreditsSlot("Alatar", "", 0, 0, 0, 2));
		credits.add(new CreditsSlot("Elmsdor", "", 0, 0, 0, 5));
		credits.add(new CreditsSlot("Gr33n B3ans", "", 0, 0, 0, 2));
		credits.add(new CreditsSlot("Farseeker", "", 0, 0, 4, 0));
		credits.add(new CreditsSlot("pupslut felix", "", 0, 0, 0, 3));
		credits.add(new CreditsSlot("Fenrakk101", "", 0, 0, 4, 0));
		credits.add(new CreditsSlot("Fiona", "", 0, 0, 0, 5));
		credits.add(new CreditsSlot("ForeverFree2MeTaMax", "", 0, 0, 5, 0));
		credits.add(new CreditsSlot("Niki Parks", "", 0, 0, 5, 0));
		credits.add(new CreditsSlot("Georgio154", "", 0, 0, 1, 3));
		credits.add(new CreditsSlot("glocknar", "", 0, 0, 2, 0));
		credits.add(new CreditsSlot("Krissy2017", "", 0, 0, 0, 3));
		credits.add(new CreditsSlot("Grakcnar", "", 0, 0, 3, 0));
		credits.add(new CreditsSlot("Hedgehog", "", 0, 0, 0, 2));
		credits.add(new CreditsSlot("Bocaj91", "", 0, 0, 0, 3));
		credits.add(new CreditsSlot("Krejil", "", 0, 0, 3, 0));
		credits.add(new CreditsSlot("suka", "", 0, 0, 5, 0));
		credits.add(new CreditsSlot("Enigamatic Yoshi", "", 0, 0, 5, 0));
		credits.add(new CreditsSlot("HerrKommissar11", "", 0, 0, 1, 1));
		credits.add(new CreditsSlot("Kelly999", "", 0, 1, 2, 0));
		credits.add(new CreditsSlot("kenshin5491", "", 0, 0, 4, 0));
		credits.add(new CreditsSlot("Kestrel", "", 0, 0, 5, 0));
		credits.add(new CreditsSlot("Kiroberos", "", 0, 0, 0, 3));
		credits.add(new CreditsSlot("Kernog", "", 0, 0, 1, 0));
		credits.add(new CreditsSlot("Knight-Lord Xander", "", 0, 0, 0, 5));
		credits.add(new CreditsSlot("Chris Turpin", "", 0, 0, 3, 0));
		credits.add(new CreditsSlot("Pallid", "", 0, 0, 0, 5));
		credits.add(new CreditsSlot("Mr L", "", 0, 0, 4, 0));
		credits.add(new CreditsSlot("loveless", "", 0, 0, 0, 5));
		credits.add(new CreditsSlot("Vaddex", "", 0, 0, 0, 2));
		credits.add(new CreditsSlot("KingofKings", "", 0, 0, 0, 5));
		credits.add(new CreditsSlot("waaaghkus", "", 0, 0, 5, 0));
		credits.add(new CreditsSlot("Nightmare", "", 0, 0, 0, 5));
		credits.add(new CreditsSlot("AlphaOneBravo", "", 0, 0, 0, 5));
		credits.add(new CreditsSlot("Max Nobody", "", 0, 0, 0, 5));
		credits.add(new CreditsSlot("Muhaku", "", 0, 0, 3, 0));
		credits.add(new CreditsSlot("Nick LaBlue", "", 0, 0, 4, 0));
		credits.add(new CreditsSlot("Kvernik", "", 0, 0, 3, 0));
		credits.add(new CreditsSlot("Niko", "", 0, 0, 5, 0));
		credits.add(new CreditsSlot("Odd8Ball", "", 0, 0, 0, 4));
		credits.add(new CreditsSlot("Party Commissar", "", 0, 0, 3, 0));
		credits.add(new CreditsSlot("Rohsie", "", 0, 0, 0, 5));
		credits.add(new CreditsSlot("P.", "", 0, 0, 0, 4));
		credits.add(new CreditsSlot("Pierre Mura", "", 0, 0, 0, 5));
		credits.add(new CreditsSlot("Pokys", "", 0, 0, 5, 0));
		credits.add(new CreditsSlot("QQQ", "", 0, 0, 0, 5));
		credits.add(new CreditsSlot("Rakesh", "", 0, 0, 4, 0));
		credits.add(new CreditsSlot("Master's dumb bitch", "", 0, 0, 0, 5));
		credits.add(new CreditsSlot("redwulfen", "", 0, 0, 0, 4));
		credits.add(new CreditsSlot("RogueRandom", "", 0, 0, 2, 0));
		credits.add(new CreditsSlot("Horagen81", "", 0, 0, 0, 4));
		credits.add(new CreditsSlot("RyubosJ", "", 0, 0, 2, 0));
		credits.add(new CreditsSlot("Saladine", "", 0, 0, 0, 5));
		credits.add(new CreditsSlot("S", "", 0, 0, 1, 4));
		credits.add(new CreditsSlot("Shas'O Dal'yth Kauyon Kais Taku", "", 0, 0, 5, 0));
		credits.add(new CreditsSlot("Crow Invictus", "", 0, 0, 4, 0));
		credits.add(new CreditsSlot("Sheltem", "", 0, 0, 3, 0));
		credits.add(new CreditsSlot("Silentark", "", 0, 0, 2, 0));
		credits.add(new CreditsSlot("Sorter", "", 0, 0, 0, 5));
		credits.add(new CreditsSlot("Spookermen", "", 0, 0, 0, 5));
		credits.add(new CreditsSlot("Swift Shot", "", 0, 0, 5, 0));
		credits.add(new CreditsSlot("TalonMort", "", 0, 0, 3, 0));
		credits.add(new CreditsSlot("Tanner D.", "", 0, 0, 0, 4));
		credits.add(new CreditsSlot("Terrance", "", 0, 0, 3, 0));
		credits.add(new CreditsSlot("Jordan Aitken", "", 0, 0, 5, 0));
		credits.add(new CreditsSlot("T. Garou", "", 0, 0, 0, 3));
		credits.add(new CreditsSlot("Timmybond24", "", 0, 0, 0, 3));
		credits.add(new CreditsSlot("Torinir", "", 0, 0, 5, 0));
		credits.add(new CreditsSlot("Torsten015", "", 0, 0, 0, 4));
		credits.add(new CreditsSlot("TreenVall", "", 0, 0, 2, 0));
		credits.add(new CreditsSlot("triangleman", "", 0, 0, 5, 0));
		credits.add(new CreditsSlot("Antriad", "", 0, 0, 1, 1));
		credits.add(new CreditsSlot("Isidoros", "", 0, 0, 4, 0));
		credits.add(new CreditsSlot("Vaelin", "", 0, 0, 4, 0));
		credits.add(new CreditsSlot("iloveyouMiaoNiNi", "", 0, 0, 0, 5));
		credits.add(new CreditsSlot("Whatever", "", 0, 0, 3, 0));
		credits.add(new CreditsSlot("William Brown", "", 0, 0, 5, 0));
		credits.add(new CreditsSlot("Wolfregis", "", 0, 0, 0, 5));
		credits.add(new CreditsSlot("Nelson Adams", "", 0, 0, 5, 0));
		
		
		credits.sort(Comparator.comparing((CreditsSlot a) -> a.getName().toLowerCase()));
		
		
		Main.primaryStage = primaryStage;

		Main.primaryStage.getIcons().add(WINDOW_IMAGE);

		Main.primaryStage.setTitle("Lilith's Throne " + VERSION_NUMBER + " " + VERSION_DESCRIPTION);
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/lilithsthrone/res/fxml/main.fxml"));

		Pane pane = loader.load();

		mainScene = new Scene(pane);

		if (properties.lightTheme) {
			mainScene.getStylesheets().add("/com/lilithsthrone/res/css/stylesheet_light.css");
		} else {
			mainScene.getStylesheets().add("/com/lilithsthrone/res/css/stylesheet.css");
		}

		mainController = loader.getController();
		Main.primaryStage.setScene(mainScene);
		Main.primaryStage.show();
		Main.game = new Game();
		
		loader = new FXMLLoader(getClass().getResource("/com/lilithsthrone/res/fxml/main.fxml"));
		try {
			if (Main.mainScene == null) {
				pane = loader.load();
				Main.mainController = loader.getController();

				Main.mainScene = new Scene(pane);
				if (Main.getProperties().lightTheme)
					Main.mainScene.getStylesheets().add("/com/lilithsthrone/res/css/stylesheet_light.css");
				else
					Main.mainScene.getStylesheets().add("/com/lilithsthrone/res/css/stylesheet.css");
			}

			Main.primaryStage.setScene(Main.mainScene);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Main.game.setContent(new Response("", "", OptionsDialogue.MENU));
		
	}

	public static void main(String[] args) {
		
		// Create folders:
		File dir = new File("data/");
		dir.mkdir();
		dir = new File("data/saves");
		dir.mkdir();
		dir = new File("data/characters");
		dir.mkdir();
		
		// Load properties:
		if (new File("data/properties.xml").exists()) {
			try {
				properties = new Properties();
				properties.loadPropertiesFromXML();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} else {
			properties = new Properties();
			properties.savePropertiesAsXML();
		}
		
		launch(args);
	}
	
	/**
	 * Starts a completely new game. Runs a new World Generation.
	 */
	public static void startNewGame(DialogueNodeOld startingDialogueNode) {
		
		Main.game = new Game();
		
		// Generate world:
		if (!(gen == null))
			if (gen.isRunning()) {
				gen.cancel();
			}

		gen = new Generation();

		gen.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
			@Override
			public void handle(WorkerStateEvent t) {
				
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/lilithsthrone/res/fxml/main.fxml"));
				Pane pane;
				try {
					if (Main.mainScene == null) {
						pane = loader.load();
						Main.mainController = loader.getController();

						Main.mainScene = new Scene(pane);
						if (Main.getProperties().lightTheme)
							Main.mainScene.getStylesheets().add("/com/lilithsthrone/res/css/stylesheet_light.css");
						else
							Main.mainScene.getStylesheets().add("/com/lilithsthrone/res/css/stylesheet.css");
					}

					Main.primaryStage.setScene(Main.mainScene);

				} catch (Exception e) {
					e.printStackTrace();
				}
				Main.game.setPlayer(new PlayerCharacter(new NameTriplet("Player"), "", 1, Gender.M_P_MALE, RacialBody.HUMAN, RaceStage.HUMAN, null, WorldType.EMPTY, PlaceType.GENERIC_MUSEUM));

				Main.game.initNewGame(startingDialogueNode);
				
				Main.game.endTurn(0);
				//Main.mainController.processNewDialogue();
			}
		});
		new Thread(gen).start();
	}
	
	public static boolean isVersionOlderThan(String versionToCheck, String versionToCheckAgainst) {
		String[] v1 = versionToCheck.split("\\.");
		String[] v2 = versionToCheckAgainst.split("\\.");
		
		try {
			if(Integer.valueOf(v1[0]) < Integer.valueOf(v2[0])) {
				return true;
			}
			
			if(Integer.valueOf((v1[1].length()==1?v1[1]+"0":v1[1])) < Integer.valueOf((v2[1].length()==1?v2[1]+"0":v2[1]))) {
				return true;
			}
			
			if(Integer.valueOf((v1[2].length()==1?v1[2]+"0":v1[2])) < Integer.valueOf((v2[2].length()==1?v2[2]+"0":v2[2]))) {
				return true;
			}
			
			if(v1.length<4) {
				if(v2.length<4) {
					return false;
				} else {
					return true;
				}
			}
			if(v2.length<4) {
				return false;
			}
			
			if(Integer.valueOf((v1[3].length()==1?v1[3]+"0":v1[3])) < Integer.valueOf((v2[3].length()==1?v2[3]+"0":v2[3]))) {
				return true;
			}
		} catch(Exception ex) {
			return true;
		}
		
		return false;
	}
	
	public static int getFontSize() {
		return properties.fontSize;
	}

	public static void setFontSize(int size) {
		properties.fontSize = size;
		properties.savePropertiesAsXML();
	}
	
	
	public static void quickSaveGame() {
		if (Main.game.isInCombat()) {
			Main.game.flashMessage(Colour.GENERIC_BAD, "Cannot quicksave while in combat!");
			
		} else if (Main.game.isInSex()) {
			Main.game.flashMessage(Colour.GENERIC_BAD, "Cannot quicksave while in sex!");
			
		} else if (Main.game.getCurrentDialogueNode().getMapDisplay()!=MapDisplay.NORMAL) {
			Main.game.flashMessage(Colour.GENERIC_BAD, "Can only quicksave in a normal scene!");
			
		} else {
			Main.getProperties().lastQuickSaveName = "QuickSave_"+Main.game.getPlayer().getName();
			saveGame("QuickSave_"+Main.game.getPlayer().getName(), true);
		}
	}

	public static void quickLoadGame() {
		String name = "QuickSave_"+Main.game.getPlayer().getName();
		
//		if(new File("data/saves/"+name+".lts").exists()) {
			loadGame(name);
//		} else {
//			loadGame(Main.getProperties().lastQuickSaveName);
//		}
	}

	public static void saveGame(String name, boolean allowOverwrite) {
		if (name.length()==0) {
			Main.game.flashMessage(Colour.GENERIC_BAD, "Name too short!");
			return;
		}
		if (name.length() > 32) {
			Main.game.flashMessage(Colour.GENERIC_BAD, "Name too long!");
			return;
		}
		if (!name.matches("[a-zA-Z0-9]+[a-zA-Z0-9' _]*")) {
			Main.game.flashMessage(Colour.GENERIC_BAD, "Incompatible characters!");
			return;
		}
		
		File dir = new File("data/");
		dir.mkdir();

		dir = new File("data/saves");
		dir.mkdir();
		
		boolean overwrite = false;
		if (dir.isDirectory()) {
			File[] directoryListing = dir.listFiles((path, filename) -> filename.endsWith(".lts"));
			if (directoryListing != null) {
				for (File child : directoryListing) {
					if (child.getName().equals(name+".lts")){
						if(!allowOverwrite) {
							Main.game.flashMessage(Colour.GENERIC_BAD, "Name already exists!");
							return;
						} else {
							overwrite = true;
						}
					}
				}
			}
		}
		
		File file = new File("data/saves/"+name+".lts");
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
//			long timeStart = System.nanoTime();
//			System.out.println(timeStart);
			
			try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
			  oos.writeObject(Main.game);
			  oos.close();
			}
			
//			System.out.println("Difference: "+(System.nanoTime()-timeStart)/1000000000f);

			properties.lastSaveLocation = name;//"data/saves/"+name+".lts";
			properties.nameColour = Femininity.valueOf(game.getPlayer().getFemininityValue()).getColour().toWebHexString();
			properties.name = game.getPlayer().getName();
			properties.level = game.getPlayer().getLevel();
			properties.money = game.getPlayer().getMoney();
			properties.arcaneEssences = game.getPlayer().getEssenceCount(TFEssence.ARCANE);
			properties.race = game.getPlayer().getRace().getName();
			properties.quest = game.getPlayer().getQuest(QuestLine.MAIN).getName();

			properties.savePropertiesAsXML();


		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		if(Main.game.getCurrentDialogueNode() == OptionsDialogue.SAVE_LOAD) {
			if(overwrite) {
				Main.game.setContent(new Response("", "", Main.game.getCurrentDialogueNode()), Colour.GENERIC_GOOD, "Save game overwritten!");
			} else {
				Main.game.setContent(new Response("", "", Main.game.getCurrentDialogueNode()), Colour.GENERIC_GOOD, "Game saved!");
			}
		} else if(name.equals("QuickSave_"+Main.game.getPlayer().getName())){
			Main.game.flashMessage(Colour.GENERIC_GOOD, "Quick saved!");
		}
	}

	public static void loadGame(String name) {
		
		File file = new File("data/saves/"+name+".lts");
		
		if (file.exists()) {
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
				Main.game = (Game) ois.readObject();
				Main.game.reloadContent();
				if (Main.game.getCurrentDialogueNode().getMapDisplay() == MapDisplay.OPTIONS) {
					Main.mainController.openOptions();
				}
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			
		} else {
			Main.game.flashMessage(Colour.GENERIC_BAD, "File not found...");
		}
	}
	
	public static void deleteGame(String name) {
		File file = new File("data/saves/"+name+".lts");

		if (file.exists()) {
			try {
				file.delete();
				Main.game.setContent(new Response("", "", Main.game.getCurrentDialogueNode()));
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			
		} else {
			Main.game.flashMessage(Colour.GENERIC_BAD, "File not found...");
		}
	}
	
	public static void deleteExportedGame(String name) {
		File file = new File("data/saves/"+name+".xml");

		if (file.exists()) {
			try {
				file.delete();
				Main.game.setContent(new Response("", "", Main.game.getCurrentDialogueNode()));
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			
		} else {
			Main.game.flashMessage(Colour.GENERIC_BAD, "File not found...");
		}
	}
	
	public static void deleteExportedCharacter(String name) {
		File file = new File("data/characters/"+name+".xml");

		if (file.exists()) {
			try {
				file.delete();
				Main.game.setContent(new Response("", "", Main.game.getCurrentDialogueNode()));
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			
		} else {
			Main.game.flashMessage(Colour.GENERIC_BAD, "File not found...");
		}
	}
	
	public static List<File> getSavedGames() {
		List<File> filesList = new ArrayList<>();
		
		File dir = new File("data/saves");
		if (dir.isDirectory()) {
			File[] directoryListing = dir.listFiles((path, name) -> name.endsWith(".lts"));
			if (directoryListing != null) {
				filesList.addAll(Arrays.asList(directoryListing));
			}
		}

		filesList.sort(Comparator.comparingLong(File::lastModified).reversed());
		
		return filesList;
	}
	
	public static List<File> getCharactersForImport() {
		List<File> filesList = new ArrayList<>();
		
		File dir = new File("data/characters");
		if (dir.isDirectory()) {
			File[] directoryListing = dir.listFiles((path, name) -> name.endsWith(".xml"));
			if (directoryListing != null) {
				filesList.addAll(Arrays.asList(directoryListing));
			}
		}

		filesList.sort(Comparator.comparingLong(File::lastModified).reversed());
		
		return filesList;
	}
	
	public static List<File> getSlavesForImport() {
		List<File> filesList = new ArrayList<>();
		
		File dir = new File("data/characters");
		if (dir.isDirectory()) {
			File[] directoryListing = dir.listFiles((path, name) -> name.endsWith(".xml"));
			if (directoryListing != null) {
				filesList.addAll(Arrays.asList(directoryListing));
			}
		}
		
		filesList.sort(Comparator.comparingLong(File::lastModified).reversed());
		
		return filesList;
	}
	
	public static List<File> getGamesForImport() {
		List<File> filesList = new ArrayList<>();
		
		File dir = new File("data/saves");
		if (dir.isDirectory()) {
			File[] directoryListing = dir.listFiles((path, name) -> name.endsWith(".xml"));
			if (directoryListing != null) {
				filesList.addAll(Arrays.asList(directoryListing));
			}
		}

		filesList.sort(Comparator.comparingLong(File::lastModified).reversed());
		
		return filesList;
	}
	
	public static void importCharacter(File file) {
		if (file != null) {
			try {
				Main.game.setPlayer(CharacterUtils.startLoadingCharacterFromXML());
				Main.game.setPlayer(CharacterUtils.loadCharacterFromXML(file, Main.game.getPlayer()));
				
				Main.game.getPlayer().getSlavesOwned().clear();
				Main.game.getPlayer().endPregnancy(false);
				
				Main.game.setRenderAttributesSection(true);
				Main.game.clearTextStartStringBuilder();
				Main.game.clearTextEndStringBuilder();
				Main.getProperties().setNewWeaponDiscovered(false);
				Main.getProperties().setNewClothingDiscovered(false);
				Main.getProperties().setNewItemDiscovered(false);
				Main.game.getPlayer().calculateStatusEffects(0);

				Main.game.initNewGame(CharacterCreation.START_GAME_WITH_IMPORT);
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	public static Properties getProperties() {
		return properties;
	}

	public static void saveProperties() {
		properties.savePropertiesAsXML();
	}
}
>>>>>>> 600d4dc merge and chair update

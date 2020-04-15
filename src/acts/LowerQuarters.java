package acts;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import leveleditor.actors.*;
import leveleditor.items.*;
import leveleditor.room.*;
import main.Main;
import acts.*;
import battle.*;
import dialog.*;
import engine.Engine;
/**
 * 
 * @author Stephen Sarquah
 * @copyright
 * Copyright 2011 Stephen Sarquah
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
 @SuppressWarnings("unused")
public class LowerQuarters implements Act, Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EventRoom roomtmp;
	private String firstroom;
	private Potion potiontmp;
	private Key keytmp;
	private Armor armortmp;
	private Weapon weapontmp;
	private Gold goldtmp;
	private Enemy enemytmp;
	private NPC npctmp;
	private Key unlockkeytmp;
	private DialogController dialogContmp;
	private DialogChoices dialogChoicestmp;
	private Dialog dialogtmp;
	private DialogSkillTest dialogSkillTesttmp;
	private RoomEvent roomeventtmp;
	private Trap traptmp;
	private String actName;
	private Act gotoAct;
	private String description;
	private Quest questtmp;
	private Accessory accessorytmp;
	
	public LowerQuarters()
	{
		actName="LowerQuarters";
		description="King Blade Kahn from the city Sonthalas has lost his daughter. She has been kidnapped by a group of humanoids and been taken to the Tower of Zaldagor. The most interesting part is the Great White Dragon haven't responded to the summons Blade Kahn has made. You seek out this opportunity to redeem yourself and earn the king's trust";
		
	}
	
	public void createWorld()
	{
		HashMap<String, Room> world = new HashMap<String, Room>();
		
		firstroom="room1";
		
			//Create room
			
				roomtmp = new EventRoom();
			
			roomtmp.setName("room1");
			roomtmp.setDescription("You've entered the tower by the sewers. The walls are green and the smell of garbage is the only thing you can think of. In the northeast part of the room there's a big rat. In the southwest part there is a pack of bread. The road continues to the north");
			roomtmp.setHidden(false);
			roomtmp.setHiddenEvent(false);
			roomtmp.setLocked(false);
			roomtmp.setRevealed(false);
			
				roomtmp.setPostDescription("On the floor is a dead big rat.");
			
			
				roomtmp.setPostItemsDescription("The road continues to the north");
			
			
			
			
			//Connect rooms
			
			
			
			
				roomtmp.setNorth("room2");
			
						
			
				//Set items in room
				
					potiontmp = new Potion();
					potiontmp.setName("Bread");
					potiontmp.setAddSkill(20);
					potiontmp.setSkill(ESkill.HP);
					roomtmp.getItems().add(potiontmp);
				
						
			
						
			
						
			
				//Set enemies
				enemytmp = new Enemy();
				enemytmp.setAgility(9);
				enemytmp.setArmor(0);
				enemytmp.setAttacking(false);
				enemytmp.setCharisma(0);
				enemytmp.setCreatureClass(ECreatureClass.Warrior);
				enemytmp.setDamageFire(0);
				enemytmp.setDamageIce(0);
				enemytmp.setDamageLightning(0);
				enemytmp.setDamagePoison(3);
				enemytmp.setGold(0);
				enemytmp.setInitPlayerActions(1);
				enemytmp.setInitHp(47);
				enemytmp.setIntelligence(0);
				enemytmp.setLevel(1);
				enemytmp.setMale(true);
				enemytmp.setMana(0);
				enemytmp.setName("Big rat");
				enemytmp.setRace(ECreatureRace.Rat);
				enemytmp.setResistFire(0);
				enemytmp.setResistIce(0);
				enemytmp.setResistLightning(0);
				enemytmp.setResistPoison(10);
				enemytmp.setScarefactor(40);
				enemytmp.setStrength(9);
				
								
				roomtmp.getEnemies().add(enemytmp);
						
			
			
			
				//Create RoomEvent
				roomeventtmp = new RoomEvent();
				roomeventtmp.setCondition(ERoomEventCondition.ITEM_TAKEN);
				roomeventtmp.setAction(ERoomEventAction.ENEMY_ATTACK);
				roomeventtmp.setHP(0);
				
				roomeventtmp.setEnemyDead(false);
				
				roomeventtmp.setItemtaken(false);
				roomeventtmp.setItemused(false);
				roomeventtmp.setRoomdescription("null");
				roomeventtmp.setRoomenteredtimes(0);
				roomeventtmp.setTrapdescription("null");
				
				
				
					roomeventtmp.setEnemyattack(enemytmp);
				
				
						
								
				
					//Set itemtaken in roomevent										
					
						roomeventtmp.setItemtaken(potiontmp);
					
				
				
								
				
	
				
				//Add roomevent
				roomtmp.getEvents().add(roomeventtmp);		
			
			
			
							
			//Add room to world list
			world.put(roomtmp.getName(), roomtmp);
		
			//Create room
			
				roomtmp = new EventRoom();
			
			roomtmp.setName("room2");
			roomtmp.setDescription("You walk north the sewers. While you walk you spot a key on the ground. Suddenly you are attacked by a big rat!");
			roomtmp.setHidden(false);
			roomtmp.setHiddenEvent(false);
			roomtmp.setLocked(false);
			roomtmp.setRevealed(false);
			
				roomtmp.setPostDescription("On the floor is a dead rat.");
			
			
				roomtmp.setPostItemsDescription("The road continues to the west and east");
			
			
			
			
			//Connect rooms
			
				roomtmp.setEast("room4");
			
			
				roomtmp.setWest("room3");
			
			
				roomtmp.setSouth("room1");
			
			
						
			
				//Set items in room
				
					keytmp = new Key();
					keytmp.setId("key1");
					keytmp.setName("Bone key");
					roomtmp.getItems().add(keytmp);
				
						
			
						
			
						
			
				//Set enemies
				enemytmp = new Enemy();
				enemytmp.setAgility(9);
				enemytmp.setArmor(0);
				enemytmp.setAttacking(true);
				enemytmp.setCharisma(0);
				enemytmp.setCreatureClass(ECreatureClass.Warrior);
				enemytmp.setDamageFire(0);
				enemytmp.setDamageIce(0);
				enemytmp.setDamageLightning(0);
				enemytmp.setDamagePoison(4);
				enemytmp.setGold(0);
				enemytmp.setInitPlayerActions(1);
				enemytmp.setInitHp(45);
				enemytmp.setIntelligence(0);
				enemytmp.setLevel(1);
				enemytmp.setMale(true);
				enemytmp.setMana(0);
				enemytmp.setName("Big rat");
				enemytmp.setRace(ECreatureRace.Rat);
				enemytmp.setResistFire(0);
				enemytmp.setResistIce(0);
				enemytmp.setResistLightning(0);
				enemytmp.setResistPoison(10);
				enemytmp.setScarefactor(40);
				enemytmp.setStrength(9);
				
								
				roomtmp.getEnemies().add(enemytmp);
						
			
			
			
			
			
							
			//Add room to world list
			world.put(roomtmp.getName(), roomtmp);
		
			//Create room
			
				roomtmp = new EventRoom();
			
			roomtmp.setName("room3");
			roomtmp.setDescription("The smell is great in this room. In the middle is a pile of dead rats and on top of them are som big rats eating them. Beneath all of this you can see the glimpse of a sword. There's a road to the north a road to the west and a road to the south. When listening to the south you can hear some animal screams.");
			roomtmp.setHidden(false);
			roomtmp.setHiddenEvent(false);
			roomtmp.setLocked(false);
			roomtmp.setRevealed(false);
			
				roomtmp.setPostDescription("On the floor is a dead big rat");
			
			
				roomtmp.setPostItemsDescription("To the south is animal screams. There's a road to the west, north and east");
			
			
			
			
			//Connect rooms
			
				roomtmp.setEast("room2");
			
			
				roomtmp.setWest("room7");
			
			
				roomtmp.setSouth("room8");
			
			
				roomtmp.setNorth("room6");
			
						
			
				//Set items in room
				
					weapontmp = new Weapon();
					weapontmp.setName("Cleaver, Sword of Legions");
					weapontmp.setTwohanded(false);
					weapontmp.setDamage(8);
					weapontmp.setDamageFire(0);
					weapontmp.setDamageIce(0);
					weapontmp.setDamageLightning(0);
					weapontmp.setDamagePoison(0);
					roomtmp.getItems().add(weapontmp);
				
						
			
						
			
						
			
				//Set enemies
				enemytmp = new Enemy();
				enemytmp.setAgility(9);
				enemytmp.setArmor(0);
				enemytmp.setAttacking(false);
				enemytmp.setCharisma(0);
				enemytmp.setCreatureClass(ECreatureClass.Warrior);
				enemytmp.setDamageFire(0);
				enemytmp.setDamageIce(0);
				enemytmp.setDamageLightning(0);
				enemytmp.setDamagePoison(3);
				enemytmp.setGold(0);
				enemytmp.setInitPlayerActions(1);
				enemytmp.setInitHp(50);
				enemytmp.setIntelligence(0);
				enemytmp.setLevel(1);
				enemytmp.setMale(true);
				enemytmp.setMana(0);
				enemytmp.setName("Big rat");
				enemytmp.setRace(ECreatureRace.Rat);
				enemytmp.setResistFire(0);
				enemytmp.setResistIce(0);
				enemytmp.setResistLightning(0);
				enemytmp.setResistPoison(10);
				enemytmp.setScarefactor(40);
				enemytmp.setStrength(9);
				
								
				roomtmp.getEnemies().add(enemytmp);
						
			
			
			
			
			
							
			//Add room to world list
			world.put(roomtmp.getName(), roomtmp);
		
			//Create room
			
				roomtmp = new EventRoom();
			
			roomtmp.setName("room4");
			roomtmp.setDescription("As you walk down east, the ground begins to be not so muddy. You see light from a fire where a Goblin sits and eats his chicken. There's a door to the south");
			roomtmp.setHidden(false);
			roomtmp.setHiddenEvent(false);
			roomtmp.setLocked(false);
			roomtmp.setRevealed(false);
			
				roomtmp.setPostDescription("On the ground lies a dead goblin");
			
			
				roomtmp.setPostItemsDescription("There's a road leading west and a door to the south");
			
			
			
			
			//Connect rooms
			
			
				roomtmp.setWest("room2");
			
			
				roomtmp.setSouth("room5");
			
			
						
			
				//Set items in room
				
					potiontmp = new Potion();
					potiontmp.setName("Chicken");
					potiontmp.setAddSkill(30);
					potiontmp.setSkill(ESkill.HP);
					roomtmp.getItems().add(potiontmp);
				
						
			
						
			
						
			
				//Set enemies
				enemytmp = new Enemy();
				enemytmp.setAgility(9);
				enemytmp.setArmor(0);
				enemytmp.setAttacking(false);
				enemytmp.setCharisma(0);
				enemytmp.setCreatureClass(ECreatureClass.Warrior);
				enemytmp.setDamageFire(0);
				enemytmp.setDamageIce(0);
				enemytmp.setDamageLightning(0);
				enemytmp.setDamagePoison(0);
				enemytmp.setGold(0);
				enemytmp.setInitPlayerActions(1);
				enemytmp.setInitHp(50);
				enemytmp.setIntelligence(0);
				enemytmp.setLevel(1);
				enemytmp.setMale(true);
				enemytmp.setMana(0);
				enemytmp.setName("Goblin");
				enemytmp.setRace(ECreatureRace.Goblin);
				enemytmp.setResistFire(0);
				enemytmp.setResistIce(0);
				enemytmp.setResistLightning(0);
				enemytmp.setResistPoison(0);
				enemytmp.setScarefactor(30);
				enemytmp.setStrength(10);
				
								
				roomtmp.getEnemies().add(enemytmp);
						
			
			
			
				//Create RoomEvent
				roomeventtmp = new RoomEvent();
				roomeventtmp.setCondition(ERoomEventCondition.ITEM_TAKEN);
				roomeventtmp.setAction(ERoomEventAction.ENEMY_ATTACK);
				roomeventtmp.setHP(0);
				
				roomeventtmp.setEnemyDead(false);
				
				roomeventtmp.setItemtaken(false);
				roomeventtmp.setItemused(false);
				roomeventtmp.setRoomdescription("null");
				roomeventtmp.setRoomenteredtimes(0);
				roomeventtmp.setTrapdescription("null");
				
				
				
					roomeventtmp.setEnemyattack(enemytmp);
				
				
						
								
				
					//Set itemtaken in roomevent										
					
						roomeventtmp.setItemtaken(potiontmp);
					
				
				
								
				
	
				
				//Add roomevent
				roomtmp.getEvents().add(roomeventtmp);		
			
			
			
							
			//Add room to world list
			world.put(roomtmp.getName(), roomtmp);
		
			//Create room
			
				roomtmp = new EventRoom();
			
			roomtmp.setName("room5");
			roomtmp.setDescription("There's food on a stove in the south corner. Next to that is a Goblin who is playing dart.");
			roomtmp.setHidden(false);
			roomtmp.setHiddenEvent(false);
			roomtmp.setLocked(true);
			roomtmp.setRevealed(false);
			
				roomtmp.setPostDescription("There's a dead goblin on the floor");
			
			
			
				roomtmp.setRevealedDescription("There's food on a stove in the south corner. There's a secret door to the east");
			
			
			
			//Connect rooms
			
				roomtmp.setEast("room9");
			
			
			
			
				roomtmp.setNorth("room4");
			
						
			
						
			
				//Set unlock keys
				keytmp = new Key();
				keytmp.setId("key1");
				keytmp.setName("Bone key");
				roomtmp.getUnlockKeys().add(keytmp);
			
						
			
						
			
				//Set enemies
				enemytmp = new Enemy();
				enemytmp.setAgility(10);
				enemytmp.setArmor(10);
				enemytmp.setAttacking(false);
				enemytmp.setCharisma(0);
				enemytmp.setCreatureClass(ECreatureClass.Warrior);
				enemytmp.setDamageFire(0);
				enemytmp.setDamageIce(0);
				enemytmp.setDamageLightning(0);
				enemytmp.setDamagePoison(0);
				enemytmp.setGold(0);
				enemytmp.setInitPlayerActions(2);
				enemytmp.setInitHp(120);
				enemytmp.setIntelligence(0);
				enemytmp.setLevel(4);
				enemytmp.setMale(true);
				enemytmp.setMana(0);
				enemytmp.setName("Big troll");
				enemytmp.setRace(ECreatureRace.Troll);
				enemytmp.setResistFire(0);
				enemytmp.setResistIce(0);
				enemytmp.setResistLightning(0);
				enemytmp.setResistPoison(0);
				enemytmp.setScarefactor(0);
				enemytmp.setStrength(30);
				
								
				roomtmp.getEnemies().add(enemytmp);
			
				//Set enemies
				enemytmp = new Enemy();
				enemytmp.setAgility(9);
				enemytmp.setArmor(0);
				enemytmp.setAttacking(false);
				enemytmp.setCharisma(0);
				enemytmp.setCreatureClass(ECreatureClass.Warrior);
				enemytmp.setDamageFire(0);
				enemytmp.setDamageIce(0);
				enemytmp.setDamageLightning(0);
				enemytmp.setDamagePoison(3);
				enemytmp.setGold(0);
				enemytmp.setInitPlayerActions(1);
				enemytmp.setInitHp(50);
				enemytmp.setIntelligence(0);
				enemytmp.setLevel(1);
				enemytmp.setMale(true);
				enemytmp.setMana(0);
				enemytmp.setName("Goblin soldier");
				enemytmp.setRace(ECreatureRace.Goblin);
				enemytmp.setResistFire(0);
				enemytmp.setResistIce(0);
				enemytmp.setResistLightning(0);
				enemytmp.setResistPoison(10);
				enemytmp.setScarefactor(30);
				enemytmp.setStrength(10);
				
								
				roomtmp.getEnemies().add(enemytmp);
						
			
			
			
				//Create RoomEvent
				roomeventtmp = new RoomEvent();
				roomeventtmp.setCondition(ERoomEventCondition.ITEM_USED);
				roomeventtmp.setAction(ERoomEventAction.ENEMY_ATTACK);
				roomeventtmp.setHP(0);
				
				roomeventtmp.setEnemyDead(false);
				
				roomeventtmp.setItemtaken(false);
				roomeventtmp.setItemused(false);
				roomeventtmp.setRoomdescription("null");
				roomeventtmp.setRoomenteredtimes(0);
				roomeventtmp.setTrapdescription("null");
				
				
				
					roomeventtmp.setEnemyattack(enemytmp);
				
				
						
								
				
				
				
								
				
					//Set Itemused in roomevent
											
						keytmp = new Key();
						keytmp.setId("key2");
						keytmp.setName("Kitchen key");
						roomeventtmp.setItemUsed(keytmp);
					
	
				
				//Add roomevent
				roomtmp.getEvents().add(roomeventtmp);		
			
			
			
							
			//Add room to world list
			world.put(roomtmp.getName(), roomtmp);
		
			//Create room
			
				roomtmp = new EventRoom();
			
			roomtmp.setName("room6");
			roomtmp.setDescription("The smell is unbearable. You feel so bad you almost puke. A goblin smiles which looks cunning");
			roomtmp.setHidden(false);
			roomtmp.setHiddenEvent(false);
			roomtmp.setLocked(false);
			roomtmp.setRevealed(false);
			
				roomtmp.setPostDescription("The smell is unbearable. You feel so bad you almost puke. On the floor is a dead goblin");
			
			
			
			
			
			//Connect rooms
			
			
			
				roomtmp.setSouth("room3");
			
			
						
			
						
			
						
			
				//Set NPCs
				npctmp = new NPC();
				npctmp.setName("Kauk");
				npctmp.setTalking(false);
				npctmp.setFirsttime(true);
				npctmp.setGotoId(8);
				npctmp.setAgility(9);
				npctmp.setArmor(0);
				npctmp.setCreatureClass(ECreatureClass.Warrior);				
				npctmp.setGold(0);
				npctmp.setInitPlayerActions(1);
				npctmp.setInitHp(47);
				npctmp.setLevel(1);
				npctmp.setMale(true);
				npctmp.setMana(0);
				npctmp.setName("Kauk");
				npctmp.setRace(ECreatureRace.Goblin);
				npctmp.setResistFire(0);
				npctmp.setResistIce(0);
				npctmp.setResistLightning(0);
				npctmp.setResistPoison(0);
				npctmp.setStrength(10);
				dialogContmp = new DialogController();
				
					//Set dialogs
					dialogChoicestmp = new DialogChoices();
					dialogChoicestmp.setId(0);
											
						dialogtmp = new Dialog();
						dialogtmp.setId(1);
						dialogtmp.setOptiontext("Hi! Who are you?");
						dialogtmp.setAnswertext("Hello there. I'm Kauk. Who are you?");
						dialogtmp.setGotoId(2);
						dialogtmp.setAttacking(false);
						
						
												
												
						dialogChoicestmp.getDialogs().add(dialogtmp);
					
					dialogContmp.getConversation().add(dialogChoicestmp);
				
					//Set dialogs
					dialogChoicestmp = new DialogChoices();
					dialogChoicestmp.setId(2);
											
						dialogtmp = new Dialog();
						dialogtmp.setId(3);
						dialogtmp.setOptiontext("I'm eh... What are you doing here??");
						dialogtmp.setAnswertext("A secret agent huh? Well haven't you seen these big rats occuring around? These rats have been spawned by the Wererats. They have a clan which is infesting our quarters. I hate them! There is a Wererat Assasin to the south and then to the west. Will you kill him for me?");
						dialogtmp.setGotoId(5);
						dialogtmp.setAttacking(false);
						
						
												
												
						dialogChoicestmp.getDialogs().add(dialogtmp);
											
						dialogtmp = new Dialog();
						dialogtmp.setId(4);
						dialogtmp.setOptiontext("I'm your doom kiddo! Now tell me what I need to know or your throat might be cut!");
						dialogtmp.setAnswertext("Answertext dude");
						dialogtmp.setGotoId(2);
						dialogtmp.setAttacking(false);
						
						
							dialogSkillTesttmp = new DialogSkillTest();
							dialogSkillTesttmp.setSkill(ESkill.CHARISMA);
							dialogSkillTesttmp.setFailText("Don't threaten me or i'll sound the alarm! Now answer me, who are you??");
							dialogSkillTesttmp.setSucessText("Ok ok ok!! But WAIT! There's a Wererat to the south then to the west. This rat needs to be killed or we're doomed! Please don't hurt me...");
							dialogSkillTesttmp.setGotoIdFail(2);
							dialogSkillTesttmp.setGotoIdSuccess(5);
							dialogSkillTesttmp.setSkillNPC(17);
							dialogtmp.setDialogskilltest(dialogSkillTesttmp);
						
												
												
						dialogChoicestmp.getDialogs().add(dialogtmp);
					
					dialogContmp.getConversation().add(dialogChoicestmp);
				
					//Set dialogs
					dialogChoicestmp = new DialogChoices();
					dialogChoicestmp.setId(5);
											
						dialogtmp = new Dialog();
						dialogtmp.setId(6);
						dialogtmp.setOptiontext("Ok i'll kill this rat and return");
						dialogtmp.setAnswertext("Great. As a token of you've killed him, bring me his head!");
						dialogtmp.setGotoId(0);
						dialogtmp.setAttacking(false);
													
							//Set Quest on dialog
							questtmp = new Quest();
							questtmp.setId(1);
							questtmp.setIntroduction("Infestation of Wererats");
							questtmp.setDescription("Kauk wants you to kill a Wererat located to the south the in the room to the west. Bring his head to Kauk");
							questtmp.setCompleteText("You've killed the wererat!");
							questtmp.setXpEarned(300);
							questtmp.setQuestCondition(ERoomEventCondition.ITEM_GIVEN);
							questtmp.setNpcGivenby("Kauk");
							questtmp.setEnemydead("");
							
							//Set item on Quest
							
								questtmp.setQuestItem("Head of Wererat");
														
							
									accessorytmp = new Accessory();
									accessorytmp.setName("Moonlight dust");
									
										accessorytmp.setRoom("room8");
									
									questtmp.setAwardItem(accessorytmp);
								
							dialogtmp.setQuest(questtmp);
						
						
						
							dialogtmp.setFinal(true);
												
												
						dialogChoicestmp.getDialogs().add(dialogtmp);
											
						dialogtmp = new Dialog();
						dialogtmp.setId(7);
						dialogtmp.setOptiontext("No I wont risk my life for you");
						dialogtmp.setAnswertext("Then go away young blood. I have something you want!");
						dialogtmp.setGotoId(0);
						dialogtmp.setAttacking(false);
						
						
						
							dialogtmp.setFinal(true);
												
												
						dialogChoicestmp.getDialogs().add(dialogtmp);
					
					dialogContmp.getConversation().add(dialogChoicestmp);
				
					//Set dialogs
					dialogChoicestmp = new DialogChoices();
					dialogChoicestmp.setId(8);
											
						dialogtmp = new Dialog();
						dialogtmp.setId(9);
						dialogtmp.setOptiontext("I killed the Wererat. Here is his head");
						dialogtmp.setAnswertext("Splendid! Thank you! Now we can be more safe. Here take this magic dust. I have no use of it");
						dialogtmp.setGotoId(0);
						dialogtmp.setAttacking(false);
						
						
						
							dialogtmp.setFinal(true);
												
						
							//Set item in dialog
							
								accessorytmp = new Accessory();
								accessorytmp.setName("Head of Wererat");
								
								dialogtmp.setItem(accessorytmp);
													
						dialogChoicestmp.getDialogs().add(dialogtmp);
											
						dialogtmp = new Dialog();
						dialogtmp.setId(10);
						dialogtmp.setOptiontext("Ehm.. nevermind");
						dialogtmp.setAnswertext("Ok then...");
						dialogtmp.setGotoId(0);
						dialogtmp.setAttacking(false);
						
						
						
							dialogtmp.setFinal(true);
												
												
						dialogChoicestmp.getDialogs().add(dialogtmp);
					
					dialogContmp.getConversation().add(dialogChoicestmp);
				
				npctmp.setDialogcontroller(dialogContmp);
				
					
				
				roomtmp.getNpcs().add(npctmp);
			
						
						
			
			
			
			
			
							
			//Add room to world list
			world.put(roomtmp.getName(), roomtmp);
		
			//Create room
			
				roomtmp = new EventRoom();
			
			roomtmp.setName("room7");
			roomtmp.setDescription("On the ground is a torch and a key. You hear a sound and suddenly a wererat attacks!");
			roomtmp.setHidden(false);
			roomtmp.setHiddenEvent(false);
			roomtmp.setLocked(false);
			roomtmp.setRevealed(false);
			
				roomtmp.setPostDescription("On the floor is a dead rat which has the shape of a human; a Wererat.");
			
			
				roomtmp.setPostItemsDescription("The only exit is east");
			
			
			
			
			//Connect rooms
			
				roomtmp.setEast("room3");
			
			
			
			
						
			
				//Set items in room
				
					keytmp = new Key();
					keytmp.setId("key2");
					keytmp.setName("Kitchen key");
					roomtmp.getItems().add(keytmp);
				
				//Set items in room
				
					weapontmp = new Weapon();
					weapontmp.setName("Torch");
					weapontmp.setTwohanded(false);
					weapontmp.setDamage(5);
					weapontmp.setDamageFire(0);
					weapontmp.setDamageIce(0);
					weapontmp.setDamageLightning(0);
					weapontmp.setDamagePoison(0);
					roomtmp.getItems().add(weapontmp);
				
						
			
						
			
						
			
				//Set enemies
				enemytmp = new Enemy();
				enemytmp.setAgility(13);
				enemytmp.setArmor(0);
				enemytmp.setAttacking(true);
				enemytmp.setCharisma(0);
				enemytmp.setCreatureClass(ECreatureClass.Warrior);
				enemytmp.setDamageFire(0);
				enemytmp.setDamageIce(0);
				enemytmp.setDamageLightning(0);
				enemytmp.setDamagePoison(0);
				enemytmp.setGold(0);
				enemytmp.setInitPlayerActions(1);
				enemytmp.setInitHp(75);
				enemytmp.setIntelligence(0);
				enemytmp.setLevel(2);
				enemytmp.setMale(true);
				enemytmp.setMana(0);
				enemytmp.setName("Wererat Assasin");
				enemytmp.setRace(ECreatureRace.Wererat);
				enemytmp.setResistFire(0);
				enemytmp.setResistIce(0);
				enemytmp.setResistLightning(0);
				enemytmp.setResistPoison(0);
				enemytmp.setScarefactor(20);
				enemytmp.setStrength(13);
				
				
					//Set items on enemy
					
						accessorytmp = new Accessory();
						accessorytmp.setName("Head of Wererat");
						
						enemytmp.getInventory().add(accessorytmp);
									
				roomtmp.getEnemies().add(enemytmp);
						
			
			
			
			
			
							
			//Add room to world list
			world.put(roomtmp.getName(), roomtmp);
		
			//Create room
			
				roomtmp = new EventRoom();
			
			roomtmp.setName("room8");
			roomtmp.setDescription("You enter the room and see leaves on the ground. At the wall to the south you see cages containing animals. Mostly boas. They scream and grunt loud. Maybe they would scream louder if you scared them?");
			roomtmp.setHidden(false);
			roomtmp.setHiddenEvent(false);
			roomtmp.setLocked(false);
			roomtmp.setRevealed(false);
			
			
			
			
			
			//Connect rooms
			
			
			
			
				roomtmp.setNorth("room3");
			
						
			
						
			
						
			
						
						
			
			
			
				//Create RoomEvent
				roomeventtmp = new RoomEvent();
				roomeventtmp.setCondition(ERoomEventCondition.ITEM_USED);
				roomeventtmp.setAction(ERoomEventAction.ROOM_PLACEENEMY);
				roomeventtmp.setHP(0);
				
				roomeventtmp.setEnemyDead(false);
				
				roomeventtmp.setItemtaken(false);
				roomeventtmp.setItemused(false);
				roomeventtmp.setRoomdescription("You throw the magic dust in the air over the animals. They get so scared that they scream so loud that you need to cover your ears. The sound of a big creature comes nearer. A big troll suddenly storms in and begins to shout at the animals. He begins to lash them!");
				roomeventtmp.setRoomenteredtimes(0);
				roomeventtmp.setTrapdescription("null");
				
				
				
				
				
					//Creating enemy in roomevent					
					enemytmp = new Enemy();
					enemytmp.setAgility(10);
					enemytmp.setArmor(10);
					enemytmp.setAttacking(false);
					enemytmp.setCharisma(0);
					enemytmp.setCreatureClass(ECreatureClass.Warrior);
					enemytmp.setDamageFire(0);
					enemytmp.setDamageIce(0);
					enemytmp.setDamageLightning(0);
					enemytmp.setDamagePoison(0);
					enemytmp.setGold(0);
					enemytmp.setInitPlayerActions(2);
					enemytmp.setInitHp(120);
					enemytmp.setIntelligence(0);
					enemytmp.setLevel(4);
					enemytmp.setMale(true);
					enemytmp.setMana(0);
					enemytmp.setName("Big troll");
					enemytmp.setRace(ECreatureRace.Troll);
					enemytmp.setResistFire(0);
					enemytmp.setResistIce(0);
					enemytmp.setResistLightning(0);
					enemytmp.setResistPoison(0);
					enemytmp.setScarefactor(0);
					enemytmp.setStrength(30);	
					
					
					
					roomeventtmp.setPlaceenemy(enemytmp);	
						
								
				
				
				
								
				
	
				
				//Add roomevent
				roomtmp.getEvents().add(roomeventtmp);		
			
				//Create RoomEvent
				roomeventtmp = new RoomEvent();
				roomeventtmp.setCondition(ERoomEventCondition.ITEM_USED);
				roomeventtmp.setAction(ERoomEventAction.REMOVE_ENEMY);
				roomeventtmp.setHP(0);
				
				roomeventtmp.setEnemyDead(false);
				
				roomeventtmp.setItemtaken(false);
				roomeventtmp.setItemused(false);
				roomeventtmp.setRoomdescription("");
				roomeventtmp.setRoomenteredtimes(0);
				roomeventtmp.setTrapdescription("null");
				
					roomeventtmp.setRoom("room5");
				
				
				
					roomeventtmp.setEnemyattack(enemytmp);
				
				
						
								
				
				
				
								
				
	
				
				//Add roomevent
				roomtmp.getEvents().add(roomeventtmp);		
			
			
			
							
			//Add room to world list
			world.put(roomtmp.getName(), roomtmp);
		
			//Create room
			
				roomtmp = new EventRoom();
			
			roomtmp.setName("room9");
			roomtmp.setDescription("The secret doorway leads you a long way east. The walls are covered with stone. You enter a room where there's a health potion on the floor. There's a road to the north and a door to the south");
			roomtmp.setHidden(true);
			roomtmp.setHiddenEvent(false);
			roomtmp.setLocked(true);
			roomtmp.setRevealed(false);
			
				roomtmp.setPostDescription("The secret doorway leads you a long way east. The walls are covered with stone. There's a dead orc on the floor");
			
			
				roomtmp.setPostItemsDescription("There's a pathway to the north and a door to the south");
			
			
			
				roomtmp.setHiddenDescription("You wander around searching each corner. At the east wall you see some vintages covering a part of the wall. You begin removing them and find behind them a door!");
			
			
			//Connect rooms
			
			
				roomtmp.setWest("room5");
			
			
				roomtmp.setSouth("room10");
			
			
				roomtmp.setNorth("room11");
			
						
			
				//Set items in room
				
					potiontmp = new Potion();
					potiontmp.setName("Health Potion");
					potiontmp.setAddSkill(25);
					potiontmp.setSkill(ESkill.HP);
					roomtmp.getItems().add(potiontmp);
				
						
			
				//Set unlock keys
				keytmp = new Key();
				keytmp.setId("key2");
				keytmp.setName("Kitchen key");
				roomtmp.getUnlockKeys().add(keytmp);
			
						
			
						
						
			
			
			
				//Create RoomEvent
				roomeventtmp = new RoomEvent();
				roomeventtmp.setCondition(ERoomEventCondition.ITEM_TAKEN);
				roomeventtmp.setAction(ERoomEventAction.ROOM_PLACEENEMY);
				roomeventtmp.setHP(0);
				
				roomeventtmp.setEnemyDead(false);
				
				roomeventtmp.setItemtaken(false);
				roomeventtmp.setItemused(false);
				roomeventtmp.setRoomdescription("As you take the health potion the door to the south opens and an orc warrior walks in. He looks tired and streches his arms");
				roomeventtmp.setRoomenteredtimes(0);
				roomeventtmp.setTrapdescription("null");
				
				
				
				
				
					//Creating enemy in roomevent					
					enemytmp = new Enemy();
					enemytmp.setAgility(10);
					enemytmp.setArmor(0);
					enemytmp.setAttacking(false);
					enemytmp.setCharisma(0);
					enemytmp.setCreatureClass(ECreatureClass.Warrior);
					enemytmp.setDamageFire(0);
					enemytmp.setDamageIce(0);
					enemytmp.setDamageLightning(0);
					enemytmp.setDamagePoison(0);
					enemytmp.setGold(0);
					enemytmp.setInitPlayerActions(1);
					enemytmp.setInitHp(68);
					enemytmp.setIntelligence(0);
					enemytmp.setLevel(2);
					enemytmp.setMale(true);
					enemytmp.setMana(0);
					enemytmp.setName("Orc warrior");
					enemytmp.setRace(ECreatureRace.Orc);
					enemytmp.setResistFire(0);
					enemytmp.setResistIce(0);
					enemytmp.setResistLightning(0);
					enemytmp.setResistPoison(0);
					enemytmp.setScarefactor(30);
					enemytmp.setStrength(13);	
					
					
					
					roomeventtmp.setPlaceenemy(enemytmp);	
						
								
				
					//Set itemtaken in roomevent										
					
						roomeventtmp.setItemtaken(potiontmp);
					
				
				
								
				
	
				
				//Add roomevent
				roomtmp.getEvents().add(roomeventtmp);		
			
				//Create RoomEvent
				roomeventtmp = new RoomEvent();
				roomeventtmp.setCondition(ERoomEventCondition.ITEM_TAKEN);
				roomeventtmp.setAction(ERoomEventAction.REMOVE_ENEMY);
				roomeventtmp.setHP(0);
				
				roomeventtmp.setEnemyDead(false);
				
				roomeventtmp.setItemtaken(false);
				roomeventtmp.setItemused(false);
				roomeventtmp.setRoomdescription("null");
				roomeventtmp.setRoomenteredtimes(0);
				roomeventtmp.setTrapdescription("null");
				
					roomeventtmp.setRoom("room10");
				
				
				
					roomeventtmp.setEnemyattack(enemytmp);
				
				
						
								
				
					//Set itemtaken in roomevent										
					
						roomeventtmp.setItemtaken(potiontmp);
					
				
				
								
				
	
				
				//Add roomevent
				roomtmp.getEvents().add(roomeventtmp);		
			
			
			
							
			//Add room to world list
			world.put(roomtmp.getName(), roomtmp);
		
			//Create room
			
				roomtmp = new EventRoom();
			
			roomtmp.setName("room10");
			roomtmp.setDescription("You walk south and enter a room which looks like a living room");
			roomtmp.setHidden(false);
			roomtmp.setHiddenEvent(false);
			roomtmp.setLocked(false);
			roomtmp.setRevealed(false);
			
				roomtmp.setPostDescription("There's a dead orc on the floor");
			
			
			
			
			
			//Connect rooms
			
			
			
			
				roomtmp.setNorth("room9");
			
						
			
						
			
						
			
						
			
				//Set enemies
				enemytmp = new Enemy();
				enemytmp.setAgility(10);
				enemytmp.setArmor(0);
				enemytmp.setAttacking(false);
				enemytmp.setCharisma(0);
				enemytmp.setCreatureClass(ECreatureClass.Warrior);
				enemytmp.setDamageFire(0);
				enemytmp.setDamageIce(0);
				enemytmp.setDamageLightning(0);
				enemytmp.setDamagePoison(0);
				enemytmp.setGold(0);
				enemytmp.setInitPlayerActions(1);
				enemytmp.setInitHp(68);
				enemytmp.setIntelligence(0);
				enemytmp.setLevel(2);
				enemytmp.setMale(true);
				enemytmp.setMana(0);
				enemytmp.setName("Orc warrior");
				enemytmp.setRace(ECreatureRace.Orc);
				enemytmp.setResistFire(0);
				enemytmp.setResistIce(0);
				enemytmp.setResistLightning(0);
				enemytmp.setResistPoison(0);
				enemytmp.setScarefactor(30);
				enemytmp.setStrength(13);
				
								
				roomtmp.getEnemies().add(enemytmp);
						
			
			
			
			
			
							
			//Add room to world list
			world.put(roomtmp.getName(), roomtmp);
		
			//Create room
			
				roomtmp = new EventRoom();
			
			roomtmp.setName("room11");
			roomtmp.setDescription("You enter a room where the walls are all covered with stone and it's dark. There's two torches revealing the sight of an orc. This orc has a darker skin than the usual ones. He is observing you");
			roomtmp.setHidden(false);
			roomtmp.setHiddenEvent(false);
			roomtmp.setLocked(false);
			roomtmp.setRevealed(false);
			
			
			
			
			
			//Connect rooms
			
				roomtmp.setEast("room21");
			
			
				roomtmp.setWest("room12");
			
			
				roomtmp.setSouth("room9");
			
			
						
			
						
			
						
			
				//Set NPCs
				npctmp = new NPC();
				npctmp.setName("Coldblood the Shaman");
				npctmp.setTalking(false);
				npctmp.setFirsttime(true);
				npctmp.setGotoId(9);
				npctmp.setAgility(11);
				npctmp.setArmor(20);
				npctmp.setCreatureClass(ECreatureClass.Wizard);				
				npctmp.setGold(250);
				npctmp.setInitPlayerActions(2);
				npctmp.setInitHp(130);
				npctmp.setLevel(4);
				npctmp.setMale(true);
				npctmp.setMana(0);
				npctmp.setName("Coldblood the Shaman");
				npctmp.setRace(ECreatureRace.DarkOrc);
				npctmp.setResistFire(5);
				npctmp.setResistIce(5);
				npctmp.setResistLightning(5);
				npctmp.setResistPoison(5);
				npctmp.setStrength(13);
				dialogContmp = new DialogController();
				
					//Set dialogs
					dialogChoicestmp = new DialogChoices();
					dialogChoicestmp.setId(0);
											
						dialogtmp = new Dialog();
						dialogtmp.setId(1);
						dialogtmp.setOptiontext("Hi, who are you?");
						dialogtmp.setAnswertext("Who I am? You are not from around here... I am Coldblood! Who are you and what are you doing here?");
						dialogtmp.setGotoId(2);
						dialogtmp.setAttacking(false);
						
						
												
												
						dialogChoicestmp.getDialogs().add(dialogtmp);
					
					dialogContmp.getConversation().add(dialogChoicestmp);
				
					//Set dialogs
					dialogChoicestmp = new DialogChoices();
					dialogChoicestmp.setId(2);
											
						dialogtmp = new Dialog();
						dialogtmp.setId(3);
						dialogtmp.setOptiontext("I am an agent sent by Blade Kahn to retrieve his daughter");
						dialogtmp.setAnswertext("Ahh the King's daughter. Very well. I could use your help. Do you want to aid Coldblood?");
						dialogtmp.setGotoId(6);
						dialogtmp.setAttacking(false);
						
						
												
												
						dialogChoicestmp.getDialogs().add(dialogtmp);
											
						dialogtmp = new Dialog();
						dialogtmp.setId(4);
						dialogtmp.setOptiontext("I am me");
						dialogtmp.setAnswertext("Ahh a resistant one. This ability will not aid you long! I have a problem with some pesky rats. Do you want to aid Coldblood?");
						dialogtmp.setGotoId(6);
						dialogtmp.setAttacking(false);
						
						
												
												
						dialogChoicestmp.getDialogs().add(dialogtmp);
											
						dialogtmp = new Dialog();
						dialogtmp.setId(5);
						dialogtmp.setOptiontext("I AM ZALDAGOR, YOUR RULER. WHERE IS YOUR LEADER PITYFUL BEING??");
						dialogtmp.setAnswertext("");
						dialogtmp.setGotoId(0);
						dialogtmp.setAttacking(false);
						
						
							dialogSkillTesttmp = new DialogSkillTest();
							dialogSkillTesttmp.setSkill(ESkill.CHARISMA);
							dialogSkillTesttmp.setFailText("You are not Zaldagor else you would posses an aura that I could not mistake. Small being, tell me who you are!");
							dialogSkillTesttmp.setSucessText("null");
							dialogSkillTesttmp.setGotoIdFail(2);
							dialogSkillTesttmp.setGotoIdSuccess(0);
							dialogSkillTesttmp.setSkillNPC(100);
							dialogtmp.setDialogskilltest(dialogSkillTesttmp);
						
												
												
						dialogChoicestmp.getDialogs().add(dialogtmp);
					
					dialogContmp.getConversation().add(dialogChoicestmp);
				
					//Set dialogs
					dialogChoicestmp = new DialogChoices();
					dialogChoicestmp.setId(6);
											
						dialogtmp = new Dialog();
						dialogtmp.setId(7);
						dialogtmp.setOptiontext("Sure i'll help you with these rats");
						dialogtmp.setAnswertext("Very well. A Wererat Captain has escaped and released some of his Wererats. This is not acceptable and my leader doesn't accept failures. I need you to kill this Wererat Captain and bring me his head. Afterwards you shall receive your reward. Now go!");
						dialogtmp.setGotoId(0);
						dialogtmp.setAttacking(false);
													
							//Set Quest on dialog
							questtmp = new Quest();
							questtmp.setId(2);
							questtmp.setIntroduction("The hunt on Snark");
							questtmp.setDescription("The Wererat Captain has escaped the jail. Find him, kill him and bring his head to Coldblood the Shaman. He will give you a reward afterwards");
							questtmp.setCompleteText("You have successfully killed the Wererat Captain");
							questtmp.setXpEarned(400);
							questtmp.setQuestCondition(ERoomEventCondition.ITEM_GIVEN);
							questtmp.setNpcGivenby("Coldblood the Shaman");
							questtmp.setEnemydead("null");
							
							//Set item on Quest
							
								questtmp.setQuestItem("Head of Snark");
														
							
									goldtmp = new Gold();
									goldtmp.setName("gold");
									goldtmp.setAmmount(500);
									questtmp.setAwardItem(goldtmp);
								
							dialogtmp.setQuest(questtmp);
						
						
						
							dialogtmp.setFinal(true);
												
												
						dialogChoicestmp.getDialogs().add(dialogtmp);
											
						dialogtmp = new Dialog();
						dialogtmp.setId(8);
						dialogtmp.setOptiontext("I'm not a boy who does everything you want me to do!");
						dialogtmp.setAnswertext("I could cut your tongue out without you knowing little worm! Now go kill the Wererat Captain and bring me his head!");
						dialogtmp.setGotoId(0);
						dialogtmp.setAttacking(false);
													
							//Set Quest on dialog
							questtmp = new Quest();
							questtmp.setId(2);
							questtmp.setIntroduction("The hunt on Snark");
							questtmp.setDescription("The Wererat Captain has escaped the jail. Find him, kill him and bring his head to Coldblood the Shaman. He will give you a reward afterwards");
							questtmp.setCompleteText("You have successfully killed the Wererat Captain");
							questtmp.setXpEarned(400);
							questtmp.setQuestCondition(ERoomEventCondition.ITEM_GIVEN);
							questtmp.setNpcGivenby("Coldblood the Shaman");
							questtmp.setEnemydead("null");
							
							//Set item on Quest
							
								questtmp.setQuestItem("Head of Snark");
														
							
									goldtmp = new Gold();
									goldtmp.setName("gold");
									goldtmp.setAmmount(500);
									questtmp.setAwardItem(goldtmp);
								
							dialogtmp.setQuest(questtmp);
						
						
						
							dialogtmp.setFinal(true);
												
												
						dialogChoicestmp.getDialogs().add(dialogtmp);
					
					dialogContmp.getConversation().add(dialogChoicestmp);
				
					//Set dialogs
					dialogChoicestmp = new DialogChoices();
					dialogChoicestmp.setId(9);
											
						dialogtmp = new Dialog();
						dialogtmp.setId(10);
						dialogtmp.setOptiontext("I killed the Wererat Captain. Here is his head");
						dialogtmp.setAnswertext("Excellent! Here take this goal and get out of here because I kill you!");
						dialogtmp.setGotoId(0);
						dialogtmp.setAttacking(false);
						
						
						
							dialogtmp.setFinal(true);
												
						
							//Set item in dialog
							
								accessorytmp = new Accessory();
								accessorytmp.setName("Head of Snark");
								
								dialogtmp.setItem(accessorytmp);
													
						dialogChoicestmp.getDialogs().add(dialogtmp);
											
						dialogtmp = new Dialog();
						dialogtmp.setId(11);
						dialogtmp.setOptiontext("So... I..");
						dialogtmp.setAnswertext("???");
						dialogtmp.setGotoId(0);
						dialogtmp.setAttacking(false);
						
						
						
							dialogtmp.setFinal(true);
												
												
						dialogChoicestmp.getDialogs().add(dialogtmp);
											
						dialogtmp = new Dialog();
						dialogtmp.setId(12);
						dialogtmp.setOptiontext("[ATTACK] I will destroy you, you snake!");
						dialogtmp.setAnswertext("Your death will be my pleasure!");
						dialogtmp.setGotoId(0);
						dialogtmp.setAttacking(true);
						
						
						
							dialogtmp.setFinal(true);
												
												
						dialogChoicestmp.getDialogs().add(dialogtmp);
					
					dialogContmp.getConversation().add(dialogChoicestmp);
				
				npctmp.setDialogcontroller(dialogContmp);
				
				
					//Set items on NPC
					
						weapontmp = new Weapon();
						weapontmp.setName("Phoenix");
						weapontmp.setTwohanded(true);
						weapontmp.setDamage(5);
						weapontmp.setDamageFire(0);
						weapontmp.setDamageIce(0);
						weapontmp.setDamageLightning(8);
						weapontmp.setDamagePoison(0);
						npctmp.getInventory().add(weapontmp);
					
					//Set items on NPC
					
						keytmp = new Key();
						keytmp.setId("key3");
						keytmp.setName("Jail key");
						npctmp.getInventory().add(keytmp);
						
				
				roomtmp.getNpcs().add(npctmp);
			
						
						
			
			
			
			
			
							
			//Add room to world list
			world.put(roomtmp.getName(), roomtmp);
		
			//Create room
			
				roomtmp = new EventRoom();
			
			roomtmp.setName("room12");
			roomtmp.setDescription("The walls are covered with stone and you get the feeling of being in a prison.  To the north is an iron lattice where a Wererat is behind. A big Wererat runs towards you!");
			roomtmp.setHidden(false);
			roomtmp.setHiddenEvent(false);
			roomtmp.setLocked(false);
			roomtmp.setRevealed(false);
			
				roomtmp.setPostDescription("There is a wererat looking at you behind bars to the north");
			
			
			
			
			
			//Connect rooms
			
				roomtmp.setEast("room11");
			
			
				roomtmp.setWest("room14");
			
			
			
				roomtmp.setNorth("room13");
			
						
			
						
			
						
			
				//Set NPCs
				npctmp = new NPC();
				npctmp.setName("Snark, Wererat Captain");
				npctmp.setTalking(true);
				npctmp.setFirsttime(true);
				npctmp.setGotoId(0);
				npctmp.setAgility(15);
				npctmp.setArmor(20);
				npctmp.setCreatureClass(ECreatureClass.Warrior);				
				npctmp.setGold(0);
				npctmp.setInitPlayerActions(2);
				npctmp.setInitHp(94);
				npctmp.setLevel(4);
				npctmp.setMale(true);
				npctmp.setMana(0);
				npctmp.setName("Snark, Wererat Captain");
				npctmp.setRace(ECreatureRace.Wererat);
				npctmp.setResistFire(0);
				npctmp.setResistIce(0);
				npctmp.setResistLightning(0);
				npctmp.setResistPoison(10);
				npctmp.setStrength(10);
				dialogContmp = new DialogController();
				
					//Set dialogs
					dialogChoicestmp = new DialogChoices();
					dialogChoicestmp.setId(0);
											
						dialogtmp = new Dialog();
						dialogtmp.setId(1);
						dialogtmp.setOptiontext("Wowowow!!!! Don't attack!?!");
						dialogtmp.setAnswertext("Don't worry. I am not an enemy but i'm neither a friend. Have you been sent by Coldblood to kill me?");
						dialogtmp.setGotoId(2);
						dialogtmp.setAttacking(false);
						
						
												
												
						dialogChoicestmp.getDialogs().add(dialogtmp);
					
					dialogContmp.getConversation().add(dialogChoicestmp);
				
					//Set dialogs
					dialogChoicestmp = new DialogChoices();
					dialogChoicestmp.setId(2);
											
						dialogtmp = new Dialog();
						dialogtmp.setId(3);
						dialogtmp.setOptiontext("Yes I have and I will make this quick!");
						dialogtmp.setAnswertext("Another dead body to my pile orc lover!");
						dialogtmp.setGotoId(0);
						dialogtmp.setAttacking(true);
						
						
						
							dialogtmp.setFinal(true);
												
												
						dialogChoicestmp.getDialogs().add(dialogtmp);
											
						dialogtmp = new Dialog();
						dialogtmp.setId(4);
						dialogtmp.setOptiontext("No?? What the hell are you talking about?? You think I want to kill you??");
						dialogtmp.setAnswertext("null");
						dialogtmp.setGotoId(0);
						dialogtmp.setAttacking(false);
						
						
							dialogSkillTesttmp = new DialogSkillTest();
							dialogSkillTesttmp.setSkill(ESkill.CHARISMA);
							dialogSkillTesttmp.setFailText("Do not test me! I have executed ones like you before for trying!");
							dialogSkillTesttmp.setSucessText("I couldn't be sure. I apoligize. I don't know what you are here for. I haven't seen your kin around but we can get further. Coldblood guards a door which we have to go through to move on. I have been sent to kill the Dark Orc Leader. He's the one responsible for enslaving us Wererats. Help me free my brothers from this jail and I will help you get past Coldblood");
							dialogSkillTesttmp.setGotoIdFail(2);
							dialogSkillTesttmp.setGotoIdSuccess(5);
							dialogSkillTesttmp.setSkillNPC(10);
							dialogtmp.setDialogskilltest(dialogSkillTesttmp);
						
												
												
						dialogChoicestmp.getDialogs().add(dialogtmp);
					
					dialogContmp.getConversation().add(dialogChoicestmp);
				
					//Set dialogs
					dialogChoicestmp = new DialogChoices();
					dialogChoicestmp.setId(5);
											
						dialogtmp = new Dialog();
						dialogtmp.setId(6);
						dialogtmp.setOptiontext("Yes I will help you. I will free your brothers");
						dialogtmp.setAnswertext("Good. Find a way to open the gates and we will launch an attack on Coldblood");
						dialogtmp.setGotoId(0);
						dialogtmp.setAttacking(false);
													
							//Set Quest on dialog
							questtmp = new Quest();
							questtmp.setId(3);
							questtmp.setIntroduction("Jail break");
							questtmp.setDescription("Snark is a captain of the wererats. He and his fellow wererats have been enslaved by the Dark Orc Leader. They are being kept in the jail where they are guarded by Coldblood a Dark Orc Shaman. Find a way to open the gates to the jail and free the other wererats");
							questtmp.setCompleteText("null");
							questtmp.setXpEarned(400);
							questtmp.setQuestCondition(ERoomEventCondition.ITEM_USED);
							questtmp.setNpcGivenby("Snark, Wererat Captain");
							questtmp.setEnemydead("null");
							
							//Set item on Quest
							
								questtmp.setQuestItem("Lever");
														
							
							dialogtmp.setQuest(questtmp);
						
						
						
							dialogtmp.setFinal(true);
												
												
						dialogChoicestmp.getDialogs().add(dialogtmp);
											
						dialogtmp = new Dialog();
						dialogtmp.setId(7);
						dialogtmp.setOptiontext("I won't help you");
						dialogtmp.setAnswertext("Leave quickly or I will have to get rid of you!");
						dialogtmp.setGotoId(0);
						dialogtmp.setAttacking(false);
						
						
						
							dialogtmp.setFinal(true);
												
												
						dialogChoicestmp.getDialogs().add(dialogtmp);
					
					dialogContmp.getConversation().add(dialogChoicestmp);
				
				npctmp.setDialogcontroller(dialogContmp);
				
				
					//Set items on NPC
					
						accessorytmp = new Accessory();
						accessorytmp.setName("Head of Snark");
						
						npctmp.getInventory().add(accessorytmp);
						
				
				roomtmp.getNpcs().add(npctmp);
			
						
						
			
			
			
				//Create RoomEvent
				roomeventtmp = new RoomEvent();
				roomeventtmp.setCondition(ERoomEventCondition.ROOM_ENTERED_TWICE);
				roomeventtmp.setAction(ERoomEventAction.REMOVE_NPC);
				roomeventtmp.setHP(0);
				
					roomeventtmp.setNpc("Snark, Wererat Captain");
				
				roomeventtmp.setEnemyDead(false);
				
				roomeventtmp.setItemtaken(false);
				roomeventtmp.setItemused(false);
				roomeventtmp.setRoomdescription("null");
				roomeventtmp.setRoomenteredtimes(0);
				roomeventtmp.setTrapdescription("null");
				
					roomeventtmp.setRoom("room12");
				
				
				
				
						
								
				
				
				
								
				
	
				
				//Add roomevent
				roomtmp.getEvents().add(roomeventtmp);		
			
			
			
							
			//Add room to world list
			world.put(roomtmp.getName(), roomtmp);
		
			//Create room
			
				roomtmp = new EventRoom();
			
			roomtmp.setName("room13");
			roomtmp.setDescription("It stinks in here of vomit. You don't wanna be in here too long");
			roomtmp.setHidden(false);
			roomtmp.setHiddenEvent(false);
			roomtmp.setLocked(true);
			roomtmp.setRevealed(false);
			
			
			
			
			
			//Connect rooms
			
			
			
				roomtmp.setSouth("room12");
			
			
						
			
						
			
						
			
						
						
			
			
			
			
			
							
			//Add room to world list
			world.put(roomtmp.getName(), roomtmp);
		
			//Create room
			
				roomtmp = new EventRoom();
			
			roomtmp.setName("room14");
			roomtmp.setDescription("An orc guard is sleeping. You see a cell to the north where a wererat is looking at  you. He whispers, please help me");
			roomtmp.setHidden(false);
			roomtmp.setHiddenEvent(false);
			roomtmp.setLocked(false);
			roomtmp.setRevealed(false);
			
				roomtmp.setPostDescription("There's a dead orc on the floor");
			
			
			
			
			
			//Connect rooms
			
				roomtmp.setEast("room12");
			
			
				roomtmp.setWest("room16");
			
			
			
				roomtmp.setNorth("room15");
			
						
			
						
			
						
			
						
			
				//Set enemies
				enemytmp = new Enemy();
				enemytmp.setAgility(10);
				enemytmp.setArmor(0);
				enemytmp.setAttacking(false);
				enemytmp.setCharisma(0);
				enemytmp.setCreatureClass(ECreatureClass.Warrior);
				enemytmp.setDamageFire(0);
				enemytmp.setDamageIce(0);
				enemytmp.setDamageLightning(0);
				enemytmp.setDamagePoison(0);
				enemytmp.setGold(0);
				enemytmp.setInitPlayerActions(1);
				enemytmp.setInitHp(68);
				enemytmp.setIntelligence(0);
				enemytmp.setLevel(3);
				enemytmp.setMale(true);
				enemytmp.setMana(0);
				enemytmp.setName("Orc guardian");
				enemytmp.setRace(ECreatureRace.Orc);
				enemytmp.setResistFire(0);
				enemytmp.setResistIce(0);
				enemytmp.setResistLightning(0);
				enemytmp.setResistPoison(0);
				enemytmp.setScarefactor(30);
				enemytmp.setStrength(13);
				
								
				roomtmp.getEnemies().add(enemytmp);
						
			
			
			
				//Create RoomEvent
				roomeventtmp = new RoomEvent();
				roomeventtmp.setCondition(ERoomEventCondition.ROOM_ENTERED_TWICE);
				roomeventtmp.setAction(ERoomEventAction.ENEMY_ATTACK);
				roomeventtmp.setHP(0);
				
				roomeventtmp.setEnemyDead(false);
				
				roomeventtmp.setItemtaken(false);
				roomeventtmp.setItemused(false);
				roomeventtmp.setRoomdescription("null");
				roomeventtmp.setRoomenteredtimes(0);
				roomeventtmp.setTrapdescription("null");
				
				
				
					roomeventtmp.setEnemyattack(enemytmp);
				
				
						
								
				
				
				
								
				
	
				
				//Add roomevent
				roomtmp.getEvents().add(roomeventtmp);		
			
			
			
							
			//Add room to world list
			world.put(roomtmp.getName(), roomtmp);
		
			//Create room
			
				roomtmp = new EventRoom();
			
			roomtmp.setName("room15");
			roomtmp.setDescription("null");
			roomtmp.setHidden(false);
			roomtmp.setHiddenEvent(false);
			roomtmp.setLocked(true);
			roomtmp.setRevealed(false);
			
			
			
			
			
			//Connect rooms
			
			
			
				roomtmp.setSouth("room14");
			
			
						
			
						
			
						
			
						
						
			
			
			
			
			
							
			//Add room to world list
			world.put(roomtmp.getName(), roomtmp);
		
			//Create room
			
				roomtmp = new EventRoom();
			
			roomtmp.setName("room16");
			roomtmp.setDescription("On the ground is 2 mana potions. To the north you see a cell where a Wererat is dead. Blood is everywhere");
			roomtmp.setHidden(false);
			roomtmp.setHiddenEvent(false);
			roomtmp.setLocked(false);
			roomtmp.setRevealed(false);
			
			
				roomtmp.setPostItemsDescription("To the north you see a cell where a Wererat is dead. Blood is everywhere");
			
			
			
			
			//Connect rooms
			
				roomtmp.setEast("room14");
			
			
				roomtmp.setWest("room18");
			
			
			
				roomtmp.setNorth("room17");
			
						
			
				//Set items in room
				
					potiontmp = new Potion();
					potiontmp.setName("Mana potion");
					potiontmp.setAddSkill(20);
					potiontmp.setSkill(ESkill.MANA);
					roomtmp.getItems().add(potiontmp);
				
				//Set items in room
				
					potiontmp = new Potion();
					potiontmp.setName("Mana potion");
					potiontmp.setAddSkill(20);
					potiontmp.setSkill(ESkill.MANA);
					roomtmp.getItems().add(potiontmp);
				
						
			
						
			
						
						
			
			
			
			
			
							
			//Add room to world list
			world.put(roomtmp.getName(), roomtmp);
		
			//Create room
			
				roomtmp = new EventRoom();
			
			roomtmp.setName("room17");
			roomtmp.setDescription("");
			roomtmp.setHidden(false);
			roomtmp.setHiddenEvent(false);
			roomtmp.setLocked(true);
			roomtmp.setRevealed(false);
			
			
			
			
			
			//Connect rooms
			
			
			
				roomtmp.setSouth("room16");
			
			
						
			
						
			
						
			
						
						
			
			
			
			
			
							
			//Add room to world list
			world.put(roomtmp.getName(), roomtmp);
		
			//Create room
			
				roomtmp = new EventRoom();
			
			roomtmp.setName("room18");
			roomtmp.setDescription("On the ground is a helm. To the north you see a cell where a Wererat is sitting behind starring at you");
			roomtmp.setHidden(false);
			roomtmp.setHiddenEvent(false);
			roomtmp.setLocked(false);
			roomtmp.setRevealed(false);
			
			
				roomtmp.setPostItemsDescription("To the north you see a cell where a Wererat is sitting behind starring at you");
			
			
			
			
			//Connect rooms
			
				roomtmp.setEast("room16");
			
			
				roomtmp.setWest("room20");
			
			
			
				roomtmp.setNorth("room19");
			
						
			
				//Set items in room
				
					armortmp = new Armor();
					armortmp.setName("Arachna");
					armortmp.setArmor(9);
					armortmp.setArmorType(EArmorType.HEAD);
					armortmp.setResistFire(0);
					armortmp.setResistIce(0);
					armortmp.setResistPoison(10);
					armortmp.setResistLightning(0);
					roomtmp.getItems().add(armortmp);
				
						
			
						
			
						
						
			
			
			
				//Create RoomEvent
				roomeventtmp = new RoomEvent();
				roomeventtmp.setCondition(ERoomEventCondition.ROOM_ENTERED);
				roomeventtmp.setAction(ERoomEventAction.TRIGGER_TRAP);
				roomeventtmp.setHP(0);
				
				roomeventtmp.setEnemyDead(false);
				
				roomeventtmp.setItemtaken(false);
				roomeventtmp.setItemused(false);
				roomeventtmp.setRoomdescription("null");
				roomeventtmp.setRoomenteredtimes(1);
				roomeventtmp.setTrapdescription("There's an explosion! You hear something to the north and west. Maybe you should hide?");
				
				
				
				
						
								
				
				
				
								
				
	
				
					//Set trap in roomevent
					traptmp = new Trap();
					traptmp.setFire(0);
					traptmp.setLightning(0);
					traptmp.setIce(0);
					traptmp.setPoison(18);
					traptmp.setNormal(0);
					traptmp.setTrapagility(15);
					traptmp.setTrapdescription("You trip over a wire!");
					traptmp.setType(ETrapType.POISON);
					roomeventtmp.setTrap(traptmp);
				
				//Add roomevent
				roomtmp.getEvents().add(roomeventtmp);		
			
			
			
							
			//Add room to world list
			world.put(roomtmp.getName(), roomtmp);
		
			//Create room
			
				roomtmp = new EventRoom();
			
			roomtmp.setName("room19");
			roomtmp.setDescription("null");
			roomtmp.setHidden(false);
			roomtmp.setHiddenEvent(false);
			roomtmp.setLocked(true);
			roomtmp.setRevealed(false);
			
			
			
			
			
			//Connect rooms
			
			
			
			
						
			
						
			
						
			
						
						
			
			
			
			
			
							
			//Add room to world list
			world.put(roomtmp.getName(), roomtmp);
		
			//Create room
			
				roomtmp = new EventRoom();
			
			roomtmp.setName("room20");
			roomtmp.setDescription("You've entered the guards room. A lever is lying on the ground. In the east wall there's a hole");
			roomtmp.setHidden(false);
			roomtmp.setHiddenEvent(false);
			roomtmp.setLocked(false);
			roomtmp.setRevealed(false);
			
				roomtmp.setPostDescription("There's two dead orcs on the floor and Coldblood");
			
			
			
			
			
			//Connect rooms
			
				roomtmp.setEast("room18");
			
			
			
			
						
			
				//Set items in room
				
					accessorytmp = new Accessory();
					accessorytmp.setName("Lever");
					
						accessorytmp.setRoom("room20");
					
					roomtmp.getItems().add(accessorytmp);
				
						
			
						
			
						
			
				//Set enemies
				enemytmp = new Enemy();
				enemytmp.setAgility(10);
				enemytmp.setArmor(0);
				enemytmp.setAttacking(true);
				enemytmp.setCharisma(0);
				enemytmp.setCreatureClass(ECreatureClass.Warrior);
				enemytmp.setDamageFire(0);
				enemytmp.setDamageIce(0);
				enemytmp.setDamageLightning(0);
				enemytmp.setDamagePoison(0);
				enemytmp.setGold(0);
				enemytmp.setInitPlayerActions(1);
				enemytmp.setInitHp(68);
				enemytmp.setIntelligence(0);
				enemytmp.setLevel(3);
				enemytmp.setMale(true);
				enemytmp.setMana(0);
				enemytmp.setName("Orc guard");
				enemytmp.setRace(ECreatureRace.Orc);
				enemytmp.setResistFire(0);
				enemytmp.setResistIce(0);
				enemytmp.setResistLightning(0);
				enemytmp.setResistPoison(0);
				enemytmp.setScarefactor(30);
				enemytmp.setStrength(13);
				
								
				roomtmp.getEnemies().add(enemytmp);
			
				//Set enemies
				enemytmp = new Enemy();
				enemytmp.setAgility(10);
				enemytmp.setArmor(0);
				enemytmp.setAttacking(false);
				enemytmp.setCharisma(0);
				enemytmp.setCreatureClass(ECreatureClass.Warrior);
				enemytmp.setDamageFire(0);
				enemytmp.setDamageIce(0);
				enemytmp.setDamageLightning(0);
				enemytmp.setDamagePoison(0);
				enemytmp.setGold(0);
				enemytmp.setInitPlayerActions(1);
				enemytmp.setInitHp(68);
				enemytmp.setIntelligence(0);
				enemytmp.setLevel(3);
				enemytmp.setMale(true);
				enemytmp.setMana(0);
				enemytmp.setName("Orc guard");
				enemytmp.setRace(ECreatureRace.Orc);
				enemytmp.setResistFire(0);
				enemytmp.setResistIce(0);
				enemytmp.setResistLightning(0);
				enemytmp.setResistPoison(0);
				enemytmp.setScarefactor(30);
				enemytmp.setStrength(13);
				
								
				roomtmp.getEnemies().add(enemytmp);
						
			
			
			
				//Create RoomEvent
				roomeventtmp = new RoomEvent();
				roomeventtmp.setCondition(ERoomEventCondition.ITEM_USED);
				roomeventtmp.setAction(ERoomEventAction.ROOM_DESCRIPTION);
				roomeventtmp.setHP(0);
				
				roomeventtmp.setEnemyDead(false);
				
				roomeventtmp.setItemtaken(false);
				roomeventtmp.setItemused(false);
				roomeventtmp.setRoomdescription("You hear gates open and suddenly you hear somebody fighting. You hear explosions! Snark runs into the room and yells HIDE! Suddenly a fireball blasts him apart. Coldblood enters the room and says I knew you would fail me!");
				roomeventtmp.setRoomenteredtimes(0);
				roomeventtmp.setTrapdescription("");
				
				
				
				
						
								
				
				
				
								
				
					//Set Itemused in roomevent
					
						accessorytmp = new Accessory();
						accessorytmp.setName("Lever");
						
							accessorytmp.setRoom("room20");
						
						roomeventtmp.setItemUsed(accessorytmp);
					
	
				
				//Add roomevent
				roomtmp.getEvents().add(roomeventtmp);		
			
				//Create RoomEvent
				roomeventtmp = new RoomEvent();
				roomeventtmp.setCondition(ERoomEventCondition.ITEM_USED);
				roomeventtmp.setAction(ERoomEventAction.ROOM_PLACEENEMY);
				roomeventtmp.setHP(0);
				
				roomeventtmp.setEnemyDead(false);
				
				roomeventtmp.setItemtaken(false);
				roomeventtmp.setItemused(false);
				roomeventtmp.setRoomdescription("");
				roomeventtmp.setRoomenteredtimes(0);
				roomeventtmp.setTrapdescription("");
				
				
				
				
				
					//Creating enemy in roomevent					
					enemytmp = new Enemy();
					enemytmp.setAgility(11);
					enemytmp.setArmor(20);
					enemytmp.setAttacking(false);
					enemytmp.setCharisma(0);
					enemytmp.setCreatureClass(ECreatureClass.Wizard);
					enemytmp.setDamageFire(10);
					enemytmp.setDamageIce(0);
					enemytmp.setDamageLightning(0);
					enemytmp.setDamagePoison(0);
					enemytmp.setGold(250);
					enemytmp.setInitPlayerActions(2);
					enemytmp.setInitHp(54);
					enemytmp.setIntelligence(0);
					enemytmp.setLevel(4);
					enemytmp.setMale(true);
					enemytmp.setMana(0);
					enemytmp.setName("Coldblood The Shaman");
					enemytmp.setRace(ECreatureRace.DarkOrc);
					enemytmp.setResistFire(5);
					enemytmp.setResistIce(5);
					enemytmp.setResistLightning(5);
					enemytmp.setResistPoison(5);
					enemytmp.setScarefactor(0);
					enemytmp.setStrength(13);	
					
					
						//Set items on enemy in roomevent
						
							weapontmp = new Weapon();
							weapontmp.setName("Phoenix");
							weapontmp.setTwohanded(true);
							weapontmp.setDamage(5);
							weapontmp.setDamageFire(0);
							weapontmp.setDamageIce(0);
							weapontmp.setDamageLightning(8);
							weapontmp.setDamagePoison(0);
							enemytmp.getInventory().add(weapontmp);
						
						//Set items on enemy in roomevent
						
							keytmp = new Key();
							keytmp.setId("key3");
							keytmp.setName("Jail key");
							enemytmp.getInventory().add(keytmp);
						
					
					roomeventtmp.setPlaceenemy(enemytmp);	
						
								
				
				
				
								
				
					//Set Itemused in roomevent
					
						accessorytmp = new Accessory();
						accessorytmp.setName("Lever");
						
							accessorytmp.setRoom("room20");
						
						roomeventtmp.setItemUsed(accessorytmp);
					
	
				
				//Add roomevent
				roomtmp.getEvents().add(roomeventtmp);		
			
				//Create RoomEvent
				roomeventtmp = new RoomEvent();
				roomeventtmp.setCondition(ERoomEventCondition.ITEM_USED);
				roomeventtmp.setAction(ERoomEventAction.REMOVE_NPC);
				roomeventtmp.setHP(0);
				
					roomeventtmp.setNpc("Coldblood the Shaman");
				
				roomeventtmp.setEnemyDead(false);
				
				roomeventtmp.setItemtaken(false);
				roomeventtmp.setItemused(false);
				roomeventtmp.setRoomdescription("");
				roomeventtmp.setRoomenteredtimes(0);
				roomeventtmp.setTrapdescription("");
				
					roomeventtmp.setRoom("room11");
				
				
				
				
						
								
				
				
				
								
				
					//Set Itemused in roomevent
					
						accessorytmp = new Accessory();
						accessorytmp.setName("Lever");
						
							accessorytmp.setRoom("room20");
						
						roomeventtmp.setItemUsed(accessorytmp);
					
	
				
				//Add roomevent
				roomtmp.getEvents().add(roomeventtmp);		
			
				//Create RoomEvent
				roomeventtmp = new RoomEvent();
				roomeventtmp.setCondition(ERoomEventCondition.ITEM_USED);
				roomeventtmp.setAction(ERoomEventAction.ROOM_DESCRIPTION);
				roomeventtmp.setHP(0);
				
				roomeventtmp.setEnemyDead(false);
				
				roomeventtmp.setItemtaken(false);
				roomeventtmp.setItemused(false);
				roomeventtmp.setRoomdescription("The room is covered with stone. To the east is a door");
				roomeventtmp.setRoomenteredtimes(0);
				roomeventtmp.setTrapdescription("null");
				
					roomeventtmp.setRoom("room11");
				
				
				
				
						
								
				
				
				
								
				
	
				
				//Add roomevent
				roomtmp.getEvents().add(roomeventtmp);		
			
				//Create RoomEvent
				roomeventtmp = new RoomEvent();
				roomeventtmp.setCondition(ERoomEventCondition.ITEM_USED);
				roomeventtmp.setAction(ERoomEventAction.ROOM_DESCRIPTION);
				roomeventtmp.setHP(0);
				
				roomeventtmp.setEnemyDead(false);
				
				roomeventtmp.setItemtaken(false);
				roomeventtmp.setItemused(false);
				roomeventtmp.setRoomdescription("The room is covered with stone. To the north is a cell");
				roomeventtmp.setRoomenteredtimes(0);
				roomeventtmp.setTrapdescription("null");
				
					roomeventtmp.setRoom("room12");
				
				
				
				
						
								
				
				
				
								
				
	
				
				//Add roomevent
				roomtmp.getEvents().add(roomeventtmp);		
			
			
			
							
			//Add room to world list
			world.put(roomtmp.getName(), roomtmp);
		
			//Create room
			
				roomtmp = new EventRoom();
			
			roomtmp.setName("room21");
			roomtmp.setDescription("You enter a room which is dark. There's only a torch to light the room. You see an elf who is bruised playing a flute");
			roomtmp.setHidden(false);
			roomtmp.setHiddenEvent(false);
			roomtmp.setLocked(true);
			roomtmp.setRevealed(false);
			
			
			
			
			
			//Connect rooms
			
			
				roomtmp.setWest("room11");
			
			
			
				roomtmp.setNorth("room22");
			
						
			
						
			
				//Set unlock keys
				keytmp = new Key();
				keytmp.setId("key3");
				keytmp.setName("Jail key");
				roomtmp.getUnlockKeys().add(keytmp);
			
						
			
				//Set NPCs
				npctmp = new NPC();
				npctmp.setName("Shantir, Bard of Azangar");
				npctmp.setTalking(false);
				npctmp.setFirsttime(true);
				npctmp.setGotoId(0);
				npctmp.setAgility(0);
				npctmp.setArmor(0);
				npctmp.setCreatureClass(ECreatureClass.Warrior);				
				npctmp.setGold(0);
				npctmp.setInitPlayerActions(0);
				npctmp.setInitHp(0);
				npctmp.setLevel(0);
				npctmp.setMale(false);
				npctmp.setMana(0);
				npctmp.setName("Shantir, Bard of Azangar");
				npctmp.setRace(ECreatureRace.Human);
				npctmp.setResistFire(0);
				npctmp.setResistIce(0);
				npctmp.setResistLightning(0);
				npctmp.setResistPoison(0);
				npctmp.setStrength(0);
				dialogContmp = new DialogController();
				
					//Set dialogs
					dialogChoicestmp = new DialogChoices();
					dialogChoicestmp.setId(0);
											
						dialogtmp = new Dialog();
						dialogtmp.setId(1);
						dialogtmp.setOptiontext("What is an elf doing here?");
						dialogtmp.setAnswertext("Ah a "+Engine.engine.getPlayer().getRace()+". I was once a bard of the Dark Orc leader, Azangar but he was too brutal. I escaped his filthy claws.");
						dialogtmp.setGotoId(2);
						dialogtmp.setAttacking(false);
						
						
												
												
						dialogChoicestmp.getDialogs().add(dialogtmp);
					
					dialogContmp.getConversation().add(dialogChoicestmp);
				
					//Set dialogs
					dialogChoicestmp = new DialogChoices();
					dialogChoicestmp.setId(2);
											
						dialogtmp = new Dialog();
						dialogtmp.setId(3);
						dialogtmp.setOptiontext("How did you manage to escape?");
						dialogtmp.setAnswertext("I enchanted him with the lullaby song from the forests of Affengut where my people is from. After I started escaping his quarters I only got this far. I'm injured by Azangar's Hellhound called Cereberus. It guards the entrance to his quarters. Proceed with caution!");
						dialogtmp.setGotoId(5);
						dialogtmp.setAttacking(false);
						
						
												
												
						dialogChoicestmp.getDialogs().add(dialogtmp);
											
						dialogtmp = new Dialog();
						dialogtmp.setId(4);
						dialogtmp.setOptiontext("I should be going");
						dialogtmp.setAnswertext("Take care");
						dialogtmp.setGotoId(0);
						dialogtmp.setAttacking(false);
						
						
						
							dialogtmp.setFinal(true);
												
												
						dialogChoicestmp.getDialogs().add(dialogtmp);
					
					dialogContmp.getConversation().add(dialogChoicestmp);
				
					//Set dialogs
					dialogChoicestmp = new DialogChoices();
					dialogChoicestmp.setId(5);
											
						dialogtmp = new Dialog();
						dialogtmp.setId(4);
						dialogtmp.setOptiontext("I should be going");
						dialogtmp.setAnswertext("Take care");
						dialogtmp.setGotoId(0);
						dialogtmp.setAttacking(false);
						
						
						
							dialogtmp.setFinal(true);
												
												
						dialogChoicestmp.getDialogs().add(dialogtmp);
					
					dialogContmp.getConversation().add(dialogChoicestmp);
				
				npctmp.setDialogcontroller(dialogContmp);
				
					
				
				roomtmp.getNpcs().add(npctmp);
			
						
						
			
			
			
				//Create RoomEvent
				roomeventtmp = new RoomEvent();
				roomeventtmp.setCondition(ERoomEventCondition.ROOM_ENTERED);
				roomeventtmp.setAction(ERoomEventAction.REMOVE_ENEMY);
				roomeventtmp.setHP(0);
				
				roomeventtmp.setEnemyDead(false);
				
				roomeventtmp.setItemtaken(false);
				roomeventtmp.setItemused(false);
				roomeventtmp.setRoomdescription("");
				roomeventtmp.setRoomenteredtimes(0);
				roomeventtmp.setTrapdescription("");
				
					roomeventtmp.setRoom("room22");
				
				
				
					roomeventtmp.setEnemyattack(enemytmp);
				
				
						
								
				
				
				
								
				
	
				
				//Add roomevent
				roomtmp.getEvents().add(roomeventtmp);		
			
			
			
							
			//Add room to world list
			world.put(roomtmp.getName(), roomtmp);
		
			//Create room
			
				roomtmp = new EventRoom();
			
			roomtmp.setName("room22");
			roomtmp.setDescription("The room is dark only lighted by a torch on the north wall. You suddenly hear the big howls of a creature to the northwest");
			roomtmp.setHidden(false);
			roomtmp.setHiddenEvent(false);
			roomtmp.setLocked(false);
			roomtmp.setRevealed(false);
			
			
				roomtmp.setPostItemsDescription("The room is dark only lighted by a torch on the north wall. You suddenly hear the big howls of a creature to the northwest");
			
			
			
			
			//Connect rooms
			
				roomtmp.setEast("room25");
			
			
				roomtmp.setWest("room26");
			
			
				roomtmp.setSouth("room21");
			
			
						
			
				//Set items in room
				
					potiontmp = new Potion();
					potiontmp.setName("HP potion");
					potiontmp.setAddSkill(25);
					potiontmp.setSkill(ESkill.HP);
					roomtmp.getItems().add(potiontmp);
				
						
			
						
			
						
			
				//Set enemies
				enemytmp = new Enemy();
				enemytmp.setAgility(11);
				enemytmp.setArmor(20);
				enemytmp.setAttacking(false);
				enemytmp.setCharisma(0);
				enemytmp.setCreatureClass(ECreatureClass.Wizard);
				enemytmp.setDamageFire(10);
				enemytmp.setDamageIce(0);
				enemytmp.setDamageLightning(0);
				enemytmp.setDamagePoison(0);
				enemytmp.setGold(250);
				enemytmp.setInitPlayerActions(2);
				enemytmp.setInitHp(54);
				enemytmp.setIntelligence(0);
				enemytmp.setLevel(4);
				enemytmp.setMale(true);
				enemytmp.setMana(0);
				enemytmp.setName("Coldblood The Shaman");
				enemytmp.setRace(ECreatureRace.DarkOrc);
				enemytmp.setResistFire(5);
				enemytmp.setResistIce(5);
				enemytmp.setResistLightning(5);
				enemytmp.setResistPoison(5);
				enemytmp.setScarefactor(0);
				enemytmp.setStrength(13);
				
				
					//Set items on enemy
					
						weapontmp = new Weapon();
						weapontmp.setName("Phoenix");
						weapontmp.setTwohanded(true);
						weapontmp.setDamage(5);
						weapontmp.setDamageFire(0);
						weapontmp.setDamageIce(0);
						weapontmp.setDamageLightning(8);
						weapontmp.setDamagePoison(0);
						enemytmp.getInventory().add(weapontmp);
					
					//Set items on enemy
					
						keytmp = new Key();
						keytmp.setId("key3");
						keytmp.setName("Jail key");
						enemytmp.getInventory().add(keytmp);
									
				roomtmp.getEnemies().add(enemytmp);
						
			
			
			
			
			
							
			//Add room to world list
			world.put(roomtmp.getName(), roomtmp);
		
			//Create room
			
				roomtmp = new EventRoom();
			
			roomtmp.setName("room26");
			roomtmp.setDescription("The howls of the creature sounds closer. As you wander you see an orc. He spots you and looks ready to attack");
			roomtmp.setHidden(false);
			roomtmp.setHiddenEvent(false);
			roomtmp.setLocked(false);
			roomtmp.setRevealed(false);
			
				roomtmp.setPostDescription("There's a dead orc on the floor");
			
			
			
			
			
			//Connect rooms
			
				roomtmp.setEast("room22");
			
			
			
			
				roomtmp.setNorth("room23");
			
						
			
						
			
						
			
						
			
				//Set enemies
				enemytmp = new Enemy();
				enemytmp.setAgility(12);
				enemytmp.setArmor(0);
				enemytmp.setAttacking(false);
				enemytmp.setCharisma(0);
				enemytmp.setCreatureClass(ECreatureClass.Warrior);
				enemytmp.setDamageFire(0);
				enemytmp.setDamageIce(0);
				enemytmp.setDamageLightning(0);
				enemytmp.setDamagePoison(0);
				enemytmp.setGold(0);
				enemytmp.setInitPlayerActions(1);
				enemytmp.setInitHp(71);
				enemytmp.setIntelligence(0);
				enemytmp.setLevel(4);
				enemytmp.setMale(true);
				enemytmp.setMana(0);
				enemytmp.setName("Orc warrior");
				enemytmp.setRace(ECreatureRace.Orc);
				enemytmp.setResistFire(0);
				enemytmp.setResistIce(0);
				enemytmp.setResistLightning(0);
				enemytmp.setResistPoison(0);
				enemytmp.setScarefactor(30);
				enemytmp.setStrength(13);
				
								
				roomtmp.getEnemies().add(enemytmp);
						
			
			
			
			
			
							
			//Add room to world list
			world.put(roomtmp.getName(), roomtmp);
		
			//Create room
			
				roomtmp = new EventRoom();
			
			roomtmp.setName("room25");
			roomtmp.setDescription("The lights shiver in the room. You step further when suddenly you hear the sound of a cling");
			roomtmp.setHidden(false);
			roomtmp.setHiddenEvent(false);
			roomtmp.setLocked(false);
			roomtmp.setRevealed(false);
			
			
			
			
			
			//Connect rooms
			
			
				roomtmp.setWest("room22");
			
			
			
				roomtmp.setNorth("room24");
			
						
			
						
			
						
			
						
						
			
			
			
				//Create RoomEvent
				roomeventtmp = new RoomEvent();
				roomeventtmp.setCondition(ERoomEventCondition.ROOM_ENTERED);
				roomeventtmp.setAction(ERoomEventAction.TRIGGER_TRAP);
				roomeventtmp.setHP(0);
				
				roomeventtmp.setEnemyDead(false);
				
				roomeventtmp.setItemtaken(false);
				roomeventtmp.setItemused(false);
				roomeventtmp.setRoomdescription("null");
				roomeventtmp.setRoomenteredtimes(0);
				roomeventtmp.setTrapdescription("The swinging axe decapites you!");
				
				
				
				
						
								
				
				
				
								
				
	
				
					//Set trap in roomevent
					traptmp = new Trap();
					traptmp.setFire(0);
					traptmp.setLightning(0);
					traptmp.setIce(0);
					traptmp.setPoison(0);
					traptmp.setNormal(200);
					traptmp.setTrapagility(21);
					traptmp.setTrapdescription("You see a big axe swinging towards you!");
					traptmp.setType(ETrapType.NORMAL);
					roomeventtmp.setTrap(traptmp);
				
				//Add roomevent
				roomtmp.getEvents().add(roomeventtmp);		
			
			
			
							
			//Add room to world list
			world.put(roomtmp.getName(), roomtmp);
		
			//Create room
			
				roomtmp = new EventRoom();
			
			roomtmp.setName("room23");
			roomtmp.setDescription("As you wander closer in the dark the howling becomes louder. You come to a gate which is guarded by a big three headed hellhound. You have never seen such a monstrous creature before! It snaps at you everytime you try to go past it");
			roomtmp.setHidden(false);
			roomtmp.setHiddenEvent(false);
			roomtmp.setLocked(false);
			roomtmp.setRevealed(false);
			
				roomtmp.setPostDescription("On the floor is the dead corpus of Cerberus. A giant three-headed hound");
			
			
			
			
			
			//Connect rooms
			
				roomtmp.setEast("room27");
			
			
			
				roomtmp.setSouth("room26");
			
			
				roomtmp.setNorth("room28");
			
						
			
						
			
						
			
						
			
				//Set enemies
				enemytmp = new Enemy();
				enemytmp.setAgility(11);
				enemytmp.setArmor(20);
				enemytmp.setAttacking(false);
				enemytmp.setCharisma(0);
				enemytmp.setCreatureClass(ECreatureClass.Warrior);
				enemytmp.setDamageFire(10);
				enemytmp.setDamageIce(0);
				enemytmp.setDamageLightning(0);
				enemytmp.setDamagePoison(0);
				enemytmp.setGold(0);
				enemytmp.setInitPlayerActions(3);
				enemytmp.setInitHp(120);
				enemytmp.setIntelligence(0);
				enemytmp.setLevel(6);
				enemytmp.setMale(true);
				enemytmp.setMana(0);
				enemytmp.setName("Cerberus, Guardian hound of Azangar");
				enemytmp.setRace(ECreatureRace.Hellhound);
				enemytmp.setResistFire(40);
				enemytmp.setResistIce(0);
				enemytmp.setResistLightning(0);
				enemytmp.setResistPoison(0);
				enemytmp.setScarefactor(0);
				enemytmp.setStrength(9);
				
								
				roomtmp.getEnemies().add(enemytmp);
						
			
			
			
				//Create RoomEvent
				roomeventtmp = new RoomEvent();
				roomeventtmp.setCondition(ERoomEventCondition.ENEMY_DIED);
				roomeventtmp.setAction(ERoomEventAction.HIDDENROOM_FOUND);
				roomeventtmp.setHP(0);
				
				roomeventtmp.setEnemyDead(false);
				
					roomeventtmp.setHiddenroomfound("room28");
				
				roomeventtmp.setItemtaken(false);
				roomeventtmp.setItemused(false);
				roomeventtmp.setRoomdescription("null");
				roomeventtmp.setRoomenteredtimes(0);
				roomeventtmp.setTrapdescription("null");
				
				
				
					roomeventtmp.setEnemyattack(enemytmp);
				
				
						
								
				
				
				
								
				
	
				
				//Add roomevent
				roomtmp.getEvents().add(roomeventtmp);		
			
				//Create RoomEvent
				roomeventtmp = new RoomEvent();
				roomeventtmp.setCondition(ERoomEventCondition.ITEM_USED);
				roomeventtmp.setAction(ERoomEventAction.SET_HP_ENEMY);
				roomeventtmp.setHP(50);
				
				roomeventtmp.setEnemyDead(false);
				
				roomeventtmp.setItemtaken(false);
				roomeventtmp.setItemused(false);
				roomeventtmp.setRoomdescription("");
				roomeventtmp.setRoomenteredtimes(0);
				roomeventtmp.setTrapdescription("null");
				
					roomeventtmp.setRoom("room23");
				
				
				
					roomeventtmp.setEnemyattack(enemytmp);
				
				
						
								
				
				
				
								
				
					//Set Itemused in roomevent
					
						accessorytmp = new Accessory();
						accessorytmp.setName("Bottle with green liquid");
						
							accessorytmp.setRoom("room23");
						
						roomeventtmp.setItemUsed(accessorytmp);
					
	
				
				//Add roomevent
				roomtmp.getEvents().add(roomeventtmp);		
			
				//Create RoomEvent
				roomeventtmp = new RoomEvent();
				roomeventtmp.setCondition(ERoomEventCondition.ITEM_USED);
				roomeventtmp.setAction(ERoomEventAction.ROOM_DESCRIPTION);
				roomeventtmp.setHP(0);
				
				roomeventtmp.setEnemyDead(false);
				
				roomeventtmp.setItemtaken(false);
				roomeventtmp.setItemused(false);
				roomeventtmp.setRoomdescription("You throw the bottle of green liquid at the big monstrous hell hound. The creature screams and is more mad and angry than before! It tries to launch an attack at you but it can't");
				roomeventtmp.setRoomenteredtimes(0);
				roomeventtmp.setTrapdescription("null");
				
				
				
				
						
								
				
				
				
								
				
					//Set Itemused in roomevent
					
						accessorytmp = new Accessory();
						accessorytmp.setName("Bottle with green liquid");
						
							accessorytmp.setRoom("room23");
						
						roomeventtmp.setItemUsed(accessorytmp);
					
	
				
				//Add roomevent
				roomtmp.getEvents().add(roomeventtmp);		
			
			
			
							
			//Add room to world list
			world.put(roomtmp.getName(), roomtmp);
		
			//Create room
			
				roomtmp = new EventRoom();
			
			roomtmp.setName("room27");
			roomtmp.setDescription("There's a body of some creature on the floor. You can't see what creature it is. Suddenly a creature yells You cannot be here! It looks like an orc but has a darker skin");
			roomtmp.setHidden(false);
			roomtmp.setHiddenEvent(false);
			roomtmp.setLocked(false);
			roomtmp.setRevealed(false);
			
				roomtmp.setPostDescription("You see a dead dark orc on the ground");
			
			
			
			
			
			//Connect rooms
			
				roomtmp.setEast("room24");
			
			
				roomtmp.setWest("room23");
			
			
			
						
			
						
			
						
			
						
			
				//Set enemies
				enemytmp = new Enemy();
				enemytmp.setAgility(13);
				enemytmp.setArmor(0);
				enemytmp.setAttacking(false);
				enemytmp.setCharisma(0);
				enemytmp.setCreatureClass(ECreatureClass.Warrior);
				enemytmp.setDamageFire(0);
				enemytmp.setDamageIce(0);
				enemytmp.setDamageLightning(0);
				enemytmp.setDamagePoison(0);
				enemytmp.setGold(0);
				enemytmp.setInitPlayerActions(1);
				enemytmp.setInitHp(68);
				enemytmp.setIntelligence(0);
				enemytmp.setLevel(4);
				enemytmp.setMale(true);
				enemytmp.setMana(0);
				enemytmp.setName("Dark Orc Warrior");
				enemytmp.setRace(ECreatureRace.DarkOrc);
				enemytmp.setResistFire(0);
				enemytmp.setResistIce(0);
				enemytmp.setResistLightning(0);
				enemytmp.setResistPoison(0);
				enemytmp.setScarefactor(20);
				enemytmp.setStrength(14);
				
				
					//Set items on enemy
					
						potiontmp = new Potion();
						potiontmp.setName("Meat");
						potiontmp.setAddSkill(20);
						potiontmp.setSkill(ESkill.HP);
						enemytmp.getInventory().add(potiontmp);
									
				roomtmp.getEnemies().add(enemytmp);
						
			
			
			
			
			
							
			//Add room to world list
			world.put(roomtmp.getName(), roomtmp);
		
			//Create room
			
				roomtmp = new EventRoom();
			
			roomtmp.setName("room24");
			roomtmp.setDescription("As you walk down the dark tunnel you see torches on the north wall out of nowhere you are attacked!");
			roomtmp.setHidden(false);
			roomtmp.setHiddenEvent(false);
			roomtmp.setLocked(false);
			roomtmp.setRevealed(false);
			
				roomtmp.setPostDescription("On the floor is a dead assasin");
			
			
			
			
			
			//Connect rooms
			
			
				roomtmp.setWest("room27");
			
			
				roomtmp.setSouth("room25");
			
			
						
			
						
			
						
			
						
			
				//Set enemies
				enemytmp = new Enemy();
				enemytmp.setAgility(15);
				enemytmp.setArmor(0);
				enemytmp.setAttacking(true);
				enemytmp.setCharisma(0);
				enemytmp.setCreatureClass(ECreatureClass.Warrior);
				enemytmp.setDamageFire(0);
				enemytmp.setDamageIce(0);
				enemytmp.setDamageLightning(0);
				enemytmp.setDamagePoison(5);
				enemytmp.setGold(0);
				enemytmp.setInitPlayerActions(2);
				enemytmp.setInitHp(54);
				enemytmp.setIntelligence(0);
				enemytmp.setLevel(4);
				enemytmp.setMale(true);
				enemytmp.setMana(0);
				enemytmp.setName("Dark Elf Assasin");
				enemytmp.setRace(ECreatureRace.Human);
				enemytmp.setResistFire(0);
				enemytmp.setResistIce(0);
				enemytmp.setResistLightning(0);
				enemytmp.setResistPoison(0);
				enemytmp.setScarefactor(0);
				enemytmp.setStrength(8);
				
				
					//Set items on enemy
					
						accessorytmp = new Accessory();
						accessorytmp.setName("Bottle with green liquid");
						
							accessorytmp.setRoom("room23");						
						
						enemytmp.getInventory().add(accessorytmp);
									
				roomtmp.getEnemies().add(enemytmp);
						
			
			
			
			
			
							
			//Add room to world list
			world.put(roomtmp.getName(), roomtmp);
		
			//Create room
			
				roomtmp = new EventRoom();
			
			roomtmp.setName("room28");
			roomtmp.setDescription("You wander past the gate of the guard hound of the dark orc leader thinking is he around somewhere? While you walk a dark orc spots you!");
			roomtmp.setHidden(true);
			roomtmp.setHiddenEvent(true);
			roomtmp.setLocked(false);
			roomtmp.setRevealed(false);
			
				roomtmp.setPostDescription("On the floor is a dead dark orc");
			
			
				roomtmp.setPostItemsDescription("There's a dark orc yelling");
			
			
			
				roomtmp.setHiddenDescription("As Cerberus falls to his death the gate behind him becomes more visible and you are now able to pass through it!");
			
			
			//Connect rooms
			
				roomtmp.setEast("room29");
			
			
				roomtmp.setWest("room33");
			
			
				roomtmp.setSouth("room23");
			
			
						
			
				//Set items in room
				
					potiontmp = new Potion();
					potiontmp.setName("Wild boa");
					potiontmp.setAddSkill(22);
					potiontmp.setSkill(ESkill.HP);
					roomtmp.getItems().add(potiontmp);
				
				//Set items in room
				
					potiontmp = new Potion();
					potiontmp.setName("Chicken");
					potiontmp.setAddSkill(20);
					potiontmp.setSkill(ESkill.HP);
					roomtmp.getItems().add(potiontmp);
				
						
			
						
			
						
			
				//Set enemies
				enemytmp = new Enemy();
				enemytmp.setAgility(13);
				enemytmp.setArmor(0);
				enemytmp.setAttacking(false);
				enemytmp.setCharisma(0);
				enemytmp.setCreatureClass(ECreatureClass.Warrior);
				enemytmp.setDamageFire(0);
				enemytmp.setDamageIce(0);
				enemytmp.setDamageLightning(0);
				enemytmp.setDamagePoison(0);
				enemytmp.setGold(0);
				enemytmp.setInitPlayerActions(1);
				enemytmp.setInitHp(68);
				enemytmp.setIntelligence(0);
				enemytmp.setLevel(5);
				enemytmp.setMale(true);
				enemytmp.setMana(0);
				enemytmp.setName("Dark Orc Warrior");
				enemytmp.setRace(ECreatureRace.DarkOrc);
				enemytmp.setResistFire(0);
				enemytmp.setResistIce(0);
				enemytmp.setResistLightning(0);
				enemytmp.setResistPoison(0);
				enemytmp.setScarefactor(20);
				enemytmp.setStrength(14);
				
				
					//Set items on enemy
					
						potiontmp = new Potion();
						potiontmp.setName("Meat");
						potiontmp.setAddSkill(20);
						potiontmp.setSkill(ESkill.HP);
						enemytmp.getInventory().add(potiontmp);
									
				roomtmp.getEnemies().add(enemytmp);
						
			
			
			
			
			
							
			//Add room to world list
			world.put(roomtmp.getName(), roomtmp);
		
			//Create room
			
				roomtmp = new EventRoom();
			
			roomtmp.setName("room29");
			roomtmp.setDescription("You open a door and enter a room where an orc is sitting on the floor looking angry. He yells he has no respect for the pure ones!");
			roomtmp.setHidden(false);
			roomtmp.setHiddenEvent(false);
			roomtmp.setLocked(false);
			roomtmp.setRevealed(false);
			
			
			
			
			
			//Connect rooms
			
			
				roomtmp.setWest("room28");
			
			
			
						
			
						
			
						
			
				//Set NPCs
				npctmp = new NPC();
				npctmp.setName("Grukin");
				npctmp.setTalking(false);
				npctmp.setFirsttime(true);
				npctmp.setGotoId(0);
				npctmp.setAgility(0);
				npctmp.setArmor(0);
				npctmp.setCreatureClass(ECreatureClass.Warrior);				
				npctmp.setGold(0);
				npctmp.setInitPlayerActions(0);
				npctmp.setInitHp(0);
				npctmp.setLevel(0);
				npctmp.setMale(false);
				npctmp.setMana(0);
				npctmp.setName("Grukin");
				npctmp.setRace(ECreatureRace.Human);
				npctmp.setResistFire(0);
				npctmp.setResistIce(0);
				npctmp.setResistLightning(0);
				npctmp.setResistPoison(0);
				npctmp.setStrength(0);
				dialogContmp = new DialogController();
				
					//Set dialogs
					dialogChoicestmp = new DialogChoices();
					dialogChoicestmp.setId(0);
											
						dialogtmp = new Dialog();
						dialogtmp.setId(1);
						dialogtmp.setOptiontext("Who is it you're talking about?");
						dialogtmp.setAnswertext("Azangar! He whips us normal orcs as if we we're slaves... He only cares for the dark orcs");
						dialogtmp.setGotoId(2);
						dialogtmp.setAttacking(false);
						
						
												
												
						dialogChoicestmp.getDialogs().add(dialogtmp);
					
					dialogContmp.getConversation().add(dialogChoicestmp);
				
					//Set dialogs
					dialogChoicestmp = new DialogChoices();
					dialogChoicestmp.setId(2);
											
						dialogtmp = new Dialog();
						dialogtmp.setId(3);
						dialogtmp.setOptiontext("Who is Azangar?");
						dialogtmp.setAnswertext("He is the Dark Orc leader. He made us do terrible things like kidnapping Blade Kahn's daughter!");
						dialogtmp.setGotoId(4);
						dialogtmp.setAttacking(false);
						
						
												
												
						dialogChoicestmp.getDialogs().add(dialogtmp);
					
					dialogContmp.getConversation().add(dialogChoicestmp);
				
					//Set dialogs
					dialogChoicestmp = new DialogChoices();
					dialogChoicestmp.setId(4);
											
						dialogtmp = new Dialog();
						dialogtmp.setId(5);
						dialogtmp.setOptiontext("How do I get to the upper levels. I need to see Zaldagor");
						dialogtmp.setAnswertext("Nobody ever sees Zaldagor. Only powerfull people like the Lord of Time sees the mighty white dragon. Azangar guards the stairs to go to the upper level. I haven't seen anybody go there");
						dialogtmp.setGotoId(6);
						dialogtmp.setAttacking(false);
						
						
												
												
						dialogChoicestmp.getDialogs().add(dialogtmp);
					
					dialogContmp.getConversation().add(dialogChoicestmp);
				
					//Set dialogs
					dialogChoicestmp = new DialogChoices();
					dialogChoicestmp.setId(6);
											
						dialogtmp = new Dialog();
						dialogtmp.setId(7);
						dialogtmp.setOptiontext("I should get going");
						dialogtmp.setAnswertext("Please give us a new leader by challeging Azangar. He is too brutal! Beware further ahead you will need to talk to Azangar's trusted architect to enter his quarters");
						dialogtmp.setGotoId(0);
						dialogtmp.setAttacking(false);
						
						
						
							dialogtmp.setFinal(true);
												
												
						dialogChoicestmp.getDialogs().add(dialogtmp);
					
					dialogContmp.getConversation().add(dialogChoicestmp);
				
				npctmp.setDialogcontroller(dialogContmp);
				
					
				
				roomtmp.getNpcs().add(npctmp);
			
						
						
			
			
			
			
			
							
			//Add room to world list
			world.put(roomtmp.getName(), roomtmp);
		
			//Create room
			
				roomtmp = new EventRoom();
			
			roomtmp.setName("room33");
			roomtmp.setDescription("You enter a room which is beautifully lit up by chandeliers. There's a metal door to the west. Next to it is orc and goblin heads impaled by a spear. You think this is a warning");
			roomtmp.setHidden(false);
			roomtmp.setHiddenEvent(false);
			roomtmp.setLocked(false);
			roomtmp.setRevealed(false);
			
			
				roomtmp.setPostItemsDescription("There's a metal door to the west");
			
			
			
			
			//Connect rooms
			
				roomtmp.setEast("room28");
			
			
				roomtmp.setWest("room32");
			
			
			
						
			
				//Set items in room
				
					armortmp = new Armor();
					armortmp.setName("Leather tunic");
					armortmp.setArmor(20);
					armortmp.setArmorType(EArmorType.BODY);
					armortmp.setResistFire(0);
					armortmp.setResistIce(0);
					armortmp.setResistPoison(0);
					armortmp.setResistLightning(0);
					roomtmp.getItems().add(armortmp);
				
						
			
						
			
						
						
			
			
			
			
			
							
			//Add room to world list
			world.put(roomtmp.getName(), roomtmp);
		
			//Create room
			
				roomtmp = new EventRoom();
			
			roomtmp.setName("room32");
			roomtmp.setDescription("This room is rather dark. The middle of the room is lit by a statue of a strong body which has a dragon head. One eye is missing");
			roomtmp.setHidden(false);
			roomtmp.setHiddenEvent(false);
			roomtmp.setLocked(false);
			roomtmp.setRevealed(false);
			
			
			
			
			
			//Connect rooms
			
				roomtmp.setEast("room33");
			
			
			
				roomtmp.setSouth("room34");
			
			
						
			
						
			
						
			
						
						
			
			
			
				//Create RoomEvent
				roomeventtmp = new RoomEvent();
				roomeventtmp.setCondition(ERoomEventCondition.ITEM_USED);
				roomeventtmp.setAction(ERoomEventAction.ROOM_DESCRIPTION);
				roomeventtmp.setHP(0);
				
				roomeventtmp.setEnemyDead(false);
				
				roomeventtmp.setItemtaken(false);
				roomeventtmp.setItemused(false);
				roomeventtmp.setRoomdescription("The eyes suddenly turn red as fire and the mouth of the dragon statue opens revealing a key");
				roomeventtmp.setRoomenteredtimes(0);
				roomeventtmp.setTrapdescription("null");
				
				
				
				
						
								
				
				
				
								
				
					//Set Itemused in roomevent
					
						accessorytmp = new Accessory();
						accessorytmp.setName("Blood Agate");
						
							accessorytmp.setRoom("room32");
						
						roomeventtmp.setItemUsed(accessorytmp);
					
	
				
				//Add roomevent
				roomtmp.getEvents().add(roomeventtmp);		
			
				//Create RoomEvent
				roomeventtmp = new RoomEvent();
				roomeventtmp.setCondition(ERoomEventCondition.ITEM_USED);
				roomeventtmp.setAction(ERoomEventAction.ADD_ITEM);
				roomeventtmp.setHP(0);
				
				roomeventtmp.setEnemyDead(false);
				
				roomeventtmp.setItemtaken(false);
				roomeventtmp.setItemused(false);
				roomeventtmp.setRoomdescription("");
				roomeventtmp.setRoomenteredtimes(0);
				roomeventtmp.setTrapdescription("null");
				
				
				
				
						
								
				
				
				
					//Set receiveditem in roomevent
											
						keytmp = new Key();
						keytmp.setId("key4");
						keytmp.setName("Chamber key");
						roomeventtmp.setReceivedItem(keytmp);
					
								
				
					//Set Itemused in roomevent
					
						accessorytmp = new Accessory();
						accessorytmp.setName("Blood Agate");
						
							accessorytmp.setRoom("room32");
						
						roomeventtmp.setItemUsed(accessorytmp);
					
	
				
				//Add roomevent
				roomtmp.getEvents().add(roomeventtmp);		
			
			
			
							
			//Add room to world list
			world.put(roomtmp.getName(), roomtmp);
		
			//Create room
			
				roomtmp = new EventRoom();
			
			roomtmp.setName("room34");
			roomtmp.setDescription("You close the door entering a room where the floor is made of marble. Some strong dark orcs with shiny armor shouts INTRUDER and attacks!");
			roomtmp.setHidden(false);
			roomtmp.setHiddenEvent(false);
			roomtmp.setLocked(false);
			roomtmp.setRevealed(false);
			
				roomtmp.setPostDescription("There's two dead high guards on the floor");
			
			
			
			
			
			//Connect rooms
			
				roomtmp.setEast("room31");
			
			
				roomtmp.setWest("room30");
			
			
			
				roomtmp.setNorth("room32");
			
						
			
						
			
						
			
						
			
				//Set enemies
				enemytmp = new Enemy();
				enemytmp.setAgility(15);
				enemytmp.setArmor(20);
				enemytmp.setAttacking(true);
				enemytmp.setCharisma(0);
				enemytmp.setCreatureClass(ECreatureClass.Warrior);
				enemytmp.setDamageFire(0);
				enemytmp.setDamageIce(5);
				enemytmp.setDamageLightning(0);
				enemytmp.setDamagePoison(0);
				enemytmp.setGold(0);
				enemytmp.setInitPlayerActions(2);
				enemytmp.setInitHp(83);
				enemytmp.setIntelligence(0);
				enemytmp.setLevel(6);
				enemytmp.setMale(true);
				enemytmp.setMana(0);
				enemytmp.setName("Dark Orc High Guard");
				enemytmp.setRace(ECreatureRace.DarkOrc);
				enemytmp.setResistFire(0);
				enemytmp.setResistIce(0);
				enemytmp.setResistLightning(0);
				enemytmp.setResistPoison(0);
				enemytmp.setScarefactor(0);
				enemytmp.setStrength(17);
				
				
					//Set items on enemy
					
						potiontmp = new Potion();
						potiontmp.setName("Minor health potion");
						potiontmp.setAddSkill(25);
						potiontmp.setSkill(ESkill.HP);
						enemytmp.getInventory().add(potiontmp);
									
				roomtmp.getEnemies().add(enemytmp);
			
				//Set enemies
				enemytmp = new Enemy();
				enemytmp.setAgility(15);
				enemytmp.setArmor(20);
				enemytmp.setAttacking(false);
				enemytmp.setCharisma(0);
				enemytmp.setCreatureClass(ECreatureClass.Warrior);
				enemytmp.setDamageFire(0);
				enemytmp.setDamageIce(5);
				enemytmp.setDamageLightning(0);
				enemytmp.setDamagePoison(0);
				enemytmp.setGold(0);
				enemytmp.setInitPlayerActions(2);
				enemytmp.setInitHp(83);
				enemytmp.setIntelligence(0);
				enemytmp.setLevel(6);
				enemytmp.setMale(true);
				enemytmp.setMana(0);
				enemytmp.setName("Dark Orc High Guard");
				enemytmp.setRace(ECreatureRace.DarkOrc);
				enemytmp.setResistFire(0);
				enemytmp.setResistIce(0);
				enemytmp.setResistLightning(0);
				enemytmp.setResistPoison(0);
				enemytmp.setScarefactor(0);
				enemytmp.setStrength(17);
				
				
					//Set items on enemy
					
						potiontmp = new Potion();
						potiontmp.setName("Minor health potion");
						potiontmp.setAddSkill(25);
						potiontmp.setSkill(ESkill.HP);
						enemytmp.getInventory().add(potiontmp);
									
				roomtmp.getEnemies().add(enemytmp);
						
			
			
			
				//Create RoomEvent
				roomeventtmp = new RoomEvent();
				roomeventtmp.setCondition(ERoomEventCondition.ROOM_ENTERED_TWICE);
				roomeventtmp.setAction(ERoomEventAction.ROOM_DESCRIPTION);
				roomeventtmp.setHP(0);
				
				roomeventtmp.setEnemyDead(false);
				
				roomeventtmp.setItemtaken(false);
				roomeventtmp.setItemused(false);
				roomeventtmp.setRoomdescription("You suddenly hear a dark deep voice coming from the west: WHAT IS GOING ON OUT THERE?? You hear the creatures footsteps...");
				roomeventtmp.setRoomenteredtimes(0);
				roomeventtmp.setTrapdescription("null");
				
				
				
				
						
								
				
				
				
								
				
	
				
				//Add roomevent
				roomtmp.getEvents().add(roomeventtmp);		
			
			
			
							
			//Add room to world list
			world.put(roomtmp.getName(), roomtmp);
		
			//Create room
			
				roomtmp = new EventRoom();
			
			roomtmp.setName("room31");
			roomtmp.setDescription("You enter a hall which is beautifully lit by chandeliers. You see creations of machinery and creatures. A Goblin laughs loud and says You really think you can defeat Dhal you petty "+Engine.engine.getPlayer().getRace()+". Attack my finest creation!");
			roomtmp.setHidden(false);
			roomtmp.setHiddenEvent(false);
			roomtmp.setLocked(false);
			roomtmp.setRevealed(false);
			
				roomtmp.setPostDescription("On the floor lies Dhal");
			
			
				roomtmp.setPostItemsDescription("Dhal and an Ice golem looks ready to attack you");
			
			
			
			
			//Connect rooms
			
			
				roomtmp.setWest("room34");
			
			
			
						
			
				//Set items in room
				
					potiontmp = new Potion();
					potiontmp.setName("Wild boa");
					potiontmp.setAddSkill(30);
					potiontmp.setSkill(ESkill.HP);
					roomtmp.getItems().add(potiontmp);
				
				//Set items in room
				
					potiontmp = new Potion();
					potiontmp.setName("Chicken");
					potiontmp.setAddSkill(24);
					potiontmp.setSkill(ESkill.HP);
					roomtmp.getItems().add(potiontmp);
				
						
			
						
			
						
			
				//Set enemies
				enemytmp = new Enemy();
				enemytmp.setAgility(10);
				enemytmp.setArmor(40);
				enemytmp.setAttacking(false);
				enemytmp.setCharisma(0);
				enemytmp.setCreatureClass(ECreatureClass.Warrior);
				enemytmp.setDamageFire(0);
				enemytmp.setDamageIce(21);
				enemytmp.setDamageLightning(0);
				enemytmp.setDamagePoison(0);
				enemytmp.setGold(0);
				enemytmp.setInitPlayerActions(1);
				enemytmp.setInitHp(67);
				enemytmp.setIntelligence(0);
				enemytmp.setLevel(5);
				enemytmp.setMale(true);
				enemytmp.setMana(0);
				enemytmp.setName("Ice golem");
				enemytmp.setRace(ECreatureRace.Troll);
				enemytmp.setResistFire(0);
				enemytmp.setResistIce(100);
				enemytmp.setResistLightning(0);
				enemytmp.setResistPoison(0);
				enemytmp.setScarefactor(0);
				enemytmp.setStrength(11);
				
								
				roomtmp.getEnemies().add(enemytmp);
			
				//Set enemies
				enemytmp = new Enemy();
				enemytmp.setAgility(9);
				enemytmp.setArmor(0);
				enemytmp.setAttacking(false);
				enemytmp.setCharisma(0);
				enemytmp.setCreatureClass(ECreatureClass.Warrior);
				enemytmp.setDamageFire(0);
				enemytmp.setDamageIce(0);
				enemytmp.setDamageLightning(0);
				enemytmp.setDamagePoison(0);
				enemytmp.setGold(0);
				enemytmp.setInitPlayerActions(1);
				enemytmp.setInitHp(50);
				enemytmp.setIntelligence(0);
				enemytmp.setLevel(4);
				enemytmp.setMale(true);
				enemytmp.setMana(0);
				enemytmp.setName("Dhal, Architect of the Dark Orcs");
				enemytmp.setRace(ECreatureRace.Goblin);
				enemytmp.setResistFire(0);
				enemytmp.setResistIce(0);
				enemytmp.setResistLightning(0);
				enemytmp.setResistPoison(0);
				enemytmp.setScarefactor(30);
				enemytmp.setStrength(10);
				
				
					//Set items on enemy
					
						accessorytmp = new Accessory();
						accessorytmp.setName("Blood Agate");
						
							accessorytmp.setRoom("room32");						
						
						enemytmp.getInventory().add(accessorytmp);
									
				roomtmp.getEnemies().add(enemytmp);
						
			
			
			
				//Create RoomEvent
				roomeventtmp = new RoomEvent();
				roomeventtmp.setCondition(ERoomEventCondition.ITEM_TAKEN);
				roomeventtmp.setAction(ERoomEventAction.ROOM_DESCRIPTION);
				roomeventtmp.setHP(0);
				
				roomeventtmp.setEnemyDead(false);
				
				roomeventtmp.setItemtaken(false);
				roomeventtmp.setItemused(false);
				roomeventtmp.setRoomdescription("The diamond is blood red. Maybe it would fit into the dragon head which stands in the northwest?");
				roomeventtmp.setRoomenteredtimes(0);
				roomeventtmp.setTrapdescription("null");
				
				
				
				
						
								
				
					//Set itemtaken in roomevent										
					
						roomeventtmp.setItemtaken(accessorytmp);
					
				
				
								
				
	
				
				//Add roomevent
				roomtmp.getEvents().add(roomeventtmp);		
			
			
			
							
			//Add room to world list
			world.put(roomtmp.getName(), roomtmp);
		
			//Create room
			
				roomtmp = new EventRoom();
			
			roomtmp.setName("room30");
			roomtmp.setDescription("You enter a marvelous chamber. At the north end is a gate where behind are stairs going up. There's a table with delicious meat and fruit. At the end of the table sits the biggest dark orc you've seen. He tells you to come closer");
			roomtmp.setHidden(true);
			roomtmp.setHiddenEvent(false);
			roomtmp.setLocked(true);
			roomtmp.setRevealed(false);
			
				roomtmp.setPostDescription("Blood is flowing into a pool. The Warlord of the Dark orcs is defeated and is starring straight into the air");
			
			
			
			
				roomtmp.setHiddenDescription("Behind some cloth you find a door leading west!");
			
			
			//Connect rooms
			
				roomtmp.setEast("room34");
			
			
			
			
				roomtmp.setNorth("room35");
			
						
			
				//Set items in room
				
					potiontmp = new Potion();
					potiontmp.setName("Fried ox");
					potiontmp.setAddSkill(30);
					potiontmp.setSkill(ESkill.HP);
					roomtmp.getItems().add(potiontmp);
				
				//Set items in room
				
					potiontmp = new Potion();
					potiontmp.setName("Fruit");
					potiontmp.setAddSkill(30);
					potiontmp.setSkill(ESkill.HP);
					roomtmp.getItems().add(potiontmp);
				
						
			
				//Set unlock keys
				keytmp = new Key();
				keytmp.setId("key4");
				keytmp.setName("Chamber key");
				roomtmp.getUnlockKeys().add(keytmp);
			
						
			
				//Set NPCs
				npctmp = new NPC();
				npctmp.setName("Azangar, Warlord of the Dark Orcs");
				npctmp.setTalking(false);
				npctmp.setFirsttime(true);
				npctmp.setGotoId(0);
				npctmp.setAgility(17);
				npctmp.setArmor(21);
				npctmp.setCreatureClass(ECreatureClass.Warrior);				
				npctmp.setGold(200);
				npctmp.setInitPlayerActions(2);
				npctmp.setInitHp(77);
				npctmp.setLevel(8);
				npctmp.setMale(true);
				npctmp.setMana(0);
				npctmp.setName("Azangar, Warlord of the Dark Orcs");
				npctmp.setRace(ECreatureRace.DarkOrc);
				npctmp.setResistFire(10);
				npctmp.setResistIce(0);
				npctmp.setResistLightning(10);
				npctmp.setResistPoison(0);
				npctmp.setStrength(21);
				dialogContmp = new DialogController();
				
					//Set dialogs
					dialogChoicestmp = new DialogChoices();
					dialogChoicestmp.setId(0);
											
						dialogtmp = new Dialog();
						dialogtmp.setId(1);
						dialogtmp.setOptiontext("What do you want?");
						dialogtmp.setAnswertext("Who are you and why have you savagely slaughtered my kin??");
						dialogtmp.setGotoId(2);
						dialogtmp.setAttacking(false);
						
						
												
												
						dialogChoicestmp.getDialogs().add(dialogtmp);
					
					dialogContmp.getConversation().add(dialogChoicestmp);
				
					//Set dialogs
					dialogChoicestmp = new DialogChoices();
					dialogChoicestmp.setId(2);
											
						dialogtmp = new Dialog();
						dialogtmp.setId(3);
						dialogtmp.setOptiontext("I am "+Engine.engine.getPlayer().getName()+". Your orcs attacked me not the other way around!");
						dialogtmp.setAnswertext("I see... What are you doing in this area. Who sent you?");
						dialogtmp.setGotoId(6);
						dialogtmp.setAttacking(false);
						
						
												
												
						dialogChoicestmp.getDialogs().add(dialogtmp);
											
						dialogtmp = new Dialog();
						dialogtmp.setId(4);
						dialogtmp.setOptiontext("My name is not important! Your orcs attacked me not the other way around!");
						dialogtmp.setAnswertext("An agent? Who are you working for?");
						dialogtmp.setGotoId(6);
						dialogtmp.setAttacking(false);
						
						
												
												
						dialogChoicestmp.getDialogs().add(dialogtmp);
											
						dialogtmp = new Dialog();
						dialogtmp.setId(5);
						dialogtmp.setOptiontext("Wait it's not me who have killed your orcs!");
						dialogtmp.setAnswertext("Yes it is! Do not lie to me! Who sent you?");
						dialogtmp.setGotoId(6);
						dialogtmp.setAttacking(false);
						
						
												
												
						dialogChoicestmp.getDialogs().add(dialogtmp);
					
					dialogContmp.getConversation().add(dialogChoicestmp);
				
					//Set dialogs
					dialogChoicestmp = new DialogChoices();
					dialogChoicestmp.setId(6);
											
						dialogtmp = new Dialog();
						dialogtmp.setId(7);
						dialogtmp.setOptiontext("I've been sent by the king of Sonthalas: Blade Kahn to retrieve his daugther kidnapped by your orcs I assume");
						dialogtmp.setAnswertext("YOU! I knew you would come! Do you think i'm a fool? I know you're not sent by Blade Kahn! Zaldagor told me about you Demon. I see your mark! *Azangar suddenly roars in pain* I WILL STOP YOU!");
						dialogtmp.setGotoId(9);
						dialogtmp.setAttacking(false);
						
						
												
												
						dialogChoicestmp.getDialogs().add(dialogtmp);
											
						dialogtmp = new Dialog();
						dialogtmp.setId(8);
						dialogtmp.setOptiontext("I work for nobody...");
						dialogtmp.setAnswertext("That is a lie!");
						dialogtmp.setGotoId(6);
						dialogtmp.setAttacking(false);
						
						
												
												
						dialogChoicestmp.getDialogs().add(dialogtmp);
					
					dialogContmp.getConversation().add(dialogChoicestmp);
				
					//Set dialogs
					dialogChoicestmp = new DialogChoices();
					dialogChoicestmp.setId(9);
											
						dialogtmp = new Dialog();
						dialogtmp.setId(10);
						dialogtmp.setOptiontext("[ATTACK] You cannot stop me!");
						dialogtmp.setAnswertext("So be it!");
						dialogtmp.setGotoId(0);
						dialogtmp.setAttacking(true);
						
						
						
							dialogtmp.setFinal(true);
												
												
						dialogChoicestmp.getDialogs().add(dialogtmp);
					
					dialogContmp.getConversation().add(dialogChoicestmp);
				
				npctmp.setDialogcontroller(dialogContmp);
				
				
					//Set items on NPC
					
						armortmp = new Armor();
						armortmp.setName("Deathmourne");
						armortmp.setArmor(21);
						armortmp.setArmorType(EArmorType.LEGGINS);
						armortmp.setResistFire(10);
						armortmp.setResistIce(0);
						armortmp.setResistPoison(0);
						armortmp.setResistLightning(10);
						npctmp.getInventory().add(armortmp);
					
					//Set items on NPC
					
						weapontmp = new Weapon();
						weapontmp.setName("Inferno");
						weapontmp.setTwohanded(true);
						weapontmp.setDamage(10);
						weapontmp.setDamageFire(11);
						weapontmp.setDamageIce(0);
						weapontmp.setDamageLightning(0);
						weapontmp.setDamagePoison(0);
						npctmp.getInventory().add(weapontmp);
					
					//Set items on NPC
					
						keytmp = new Key();
						keytmp.setId("key5");
						keytmp.setName("Golden key");
						npctmp.getInventory().add(keytmp);
						
				
				roomtmp.getNpcs().add(npctmp);
			
						
						
			
			
			
				//Create RoomEvent
				roomeventtmp = new RoomEvent();
				roomeventtmp.setCondition(ERoomEventCondition.ITEM_TAKEN);
				roomeventtmp.setAction(ERoomEventAction.ROOM_DESCRIPTION);
				roomeventtmp.setHP(0);
				
				roomeventtmp.setEnemyDead(false);
				
				roomeventtmp.setItemtaken(false);
				roomeventtmp.setItemused(false);
				roomeventtmp.setRoomdescription("As you take the key Azangar looks at you while his blood is spilling on the floor and with the last energy he whispers you are dooming us all. He lies still starring at you");
				roomeventtmp.setRoomenteredtimes(0);
				roomeventtmp.setTrapdescription("null");
				
				
				
				
						
								
				
					//Set itemtaken in roomevent										
					
						roomeventtmp.setItemtaken(keytmp);
					
				
				
								
				
	
				
				//Add roomevent
				roomtmp.getEvents().add(roomeventtmp);		
			
			
			
							
			//Add room to world list
			world.put(roomtmp.getName(), roomtmp);
		
			//Create room
			
				roomtmp = new FinalRoom();
			
			roomtmp.setName("room35");
			roomtmp.setDescription("As you walk up the stairs you can't stop thinking about what Azangar ment about you being a demon and Blade Kahn. Something is wrong. Maybe you will find out.");
			roomtmp.setHidden(false);
			roomtmp.setHiddenEvent(false);
			roomtmp.setLocked(true);
			roomtmp.setRevealed(false);
			
			
			
			
			
			//Connect rooms
			
			
			
			
						
			
						
			
				//Set unlock keys
				keytmp = new Key();
				keytmp.setId("key5");
				keytmp.setName("Golden key");
				roomtmp.getUnlockKeys().add(keytmp);
			
						
			
						
						
							
				((FinalRoom)roomtmp).setFinal(true);
			
			
			
			
			
							
			//Add room to world list
			world.put(roomtmp.getName(), roomtmp);
		
		
		//Place player into world
		//TODO: Change currentroom for debugging
		Engine.engine.getPlayer().setCurrentroom(firstroom);
		
		//Add world to engine
		Engine.engine.getPlayer().setWorld(world);
		
		//Set act
		Engine.engine.getPlayer().setAct(this);
	}
	@Override
	public String getActName() {
		return actName;
	}
	@Override
	public Act getGotoAct() {
		return gotoAct;
	}
	@Override
	public String getDescription() {
		return description;
	}
}

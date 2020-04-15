package engine;

import filehandler.Filehandler;
import gui.InventoryGUI;
import gui.LevelupGUI;
import gui.NavigationGUI;
import gui.StatsGUI;
import leveleditor.actors.ECreatureClass;
import leveleditor.actors.Enemy;
import leveleditor.actors.Player;
import leveleditor.items.Accessory;
import leveleditor.items.Gold;
import leveleditor.items.Key;
import leveleditor.room.ERoomEventCondition;
import leveleditor.room.EventRoom;
import leveleditor.room.FinalRoom;
import battle.Battle;
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
public class Engine 
{
	private NavigationGUI navigateWindow;
	private Battle battle;
	public static Engine engine=new Engine();
	private InventoryGUI inventoryGUI = new InventoryGUI();
	private Player player;

	public void start()
	{
		player.setHp(player.getInitHp());
		if (player.getCreatureClass()==ECreatureClass.Wizard)
		{
			player.setMana(player.getInitMana());
		}
		for (int i = 0; i < Engine.engine.getPlayer().getQuests().size(); i++) 
		{
			Engine.engine.getPlayer().getQuests().remove(i);
		}
		navigateWindow = new NavigationGUI(); 
		navigateWindow.setup();
		navigateWindow.write(player.getAct().getDescription()+"\n");
		enterRoom();		
	}
	public boolean loadgame()
	{
		if (Filehandler.load())
		{
			if (navigateWindow!=null)
			{
				navigateWindow.getFrame().setVisible(false);
			}
			navigateWindow = new NavigationGUI();
			navigateWindow.setup();
			navigateWindow.write("Game loaded!\n");
			enterRoom();
			return true;
		}
		return false;
	}
	public void savegame()
	{
		Filehandler.save();
	}
	public void goNorth()
	{
		if (player.getWorld().get(player.getWorld().get(player.getCurrentroom()).getNorth()).isLocked())
		{
			navigateWindow.write("You can't go north. The door is locked\n");
		}
		else
		{
			player.setCurrentroom(player.getWorld().get(player.getCurrentroom()).getNorth());
			enterRoom();
		}
	}
	public void goSouth()
	{
		if (player.getWorld().get(player.getWorld().get(player.getCurrentroom()).getSouth()).isLocked())
		{
			navigateWindow.write("You can't go south. The door is locked\n");
		}
		else
		{
			player.setCurrentroom(player.getWorld().get(player.getCurrentroom()).getSouth());
			enterRoom();
		}
	}
	public void goEast()
	{
		if (player.getWorld().get(player.getWorld().get(player.getCurrentroom()).getEast()).isLocked())
		{
			navigateWindow.write("You can't go east. The door is locked\n");
		}
		else
		{
			player.setCurrentroom(player.getWorld().get(player.getCurrentroom()).getEast());
			enterRoom();
		}
	}
	public void goWest()
	{
		if (player.getWorld().get(player.getWorld().get(player.getCurrentroom()).getWest()).isLocked())
		{
			navigateWindow.write("You can't go west. The door is locked\n");
		}
		else
		{
			player.setCurrentroom(player.getWorld().get(player.getCurrentroom()).getWest());
			enterRoom();
		}
	}
	public void enterRoom()
	{
		boolean printNormaldescription=true;

		if (player.getWorld().get(player.getCurrentroom()) instanceof EventRoom)
		{
			((EventRoom) player.getWorld().get(player.getCurrentroom())).evaluateCondition();
			Engine.engine.getPlayer().getQuests().add(((EventRoom) player.getWorld().get(player.getCurrentroom())).getQuest());
			if (((EventRoom)player.getWorld().get(player.getCurrentroom())).getQuest() != null)
			{
				navigateWindow.write("Quest added!\n");
			}
		}
		if (player.getWorld().get(player.getCurrentroom()).isRevealed())
		{
			navigateWindow.write(player.getWorld().get(player.getCurrentroom()).getRevealedDescription()+"\n");
			printNormaldescription=false;
		}
		if (player.getWorld().get(player.getCurrentroom()).getItems().isEmpty() && player.getWorld().get(player.getCurrentroom()).getPostItemsDescription()!=null)
		{
			navigateWindow.write(player.getWorld().get(player.getCurrentroom()).getPostItemsDescription()+"\n");
			printNormaldescription=false;
		}
		if (player.getWorld().get(player.getCurrentroom()).getEnemies().isEmpty())
		{
			navigateWindow.getAttack().setEnabled(false);
			if (player.getWorld().get(player.getCurrentroom()).getPostDescription()!=null && (player.getWorld().get(player.getCurrentroom()).getNpcs().isEmpty()))
			{
				navigateWindow.write(player.getWorld().get(player.getCurrentroom()).getPostDescription()+"\n");
				printNormaldescription=false;
			}
		}
		else
		{
			navigateWindow.getAttack().setEnabled(true);
			for (int i = 0; i < player.getWorld().get(player.getCurrentroom()).getEnemies().size(); i++) 
			{
				if (player.getWorld().get(player.getCurrentroom()).getEnemies().get(i).isAttacking())
				{
					attackedBy(player.getWorld().get(player.getCurrentroom()).getEnemies().get(i));
					battle.write(player.getWorld().get(player.getCurrentroom()).getDescription()+"\n");
				}
			}
		}

		if (player.getWorld().get(player.getCurrentroom()).getSouth()==null)
		{
			navigateWindow.getSouth().setEnabled(false);
		}
		else
		{
			if (player.getWorld().get(player.getWorld().get(player.getCurrentroom()).getSouth()).isHidden())
			{
				navigateWindow.getSouth().setEnabled(false);
			}
			else
			{
				navigateWindow.getSouth().setEnabled(true);
			}
		}

		if (player.getWorld().get(player.getCurrentroom()).getEast()==null)
		{
			navigateWindow.getEast().setEnabled(false);
		}
		else
		{
			if (player.getWorld().get(player.getWorld().get(player.getCurrentroom()).getEast()).isHidden())
			{
				navigateWindow.getEast().setEnabled(false);
			}
			else
			{
				navigateWindow.getEast().setEnabled(true);
			}
		}

		if (player.getWorld().get(player.getCurrentroom()).getWest()==null)
		{
			navigateWindow.getWest().setEnabled(false);
		}
		else
		{
			if (player.getWorld().get(player.getWorld().get(player.getCurrentroom()).getWest()).isHidden())
			{
				navigateWindow.getWest().setEnabled(false);
			}
			else
			{
				navigateWindow.getWest().setEnabled(true);
			}
		}

		if (player.getWorld().get(player.getCurrentroom()).getNorth()==null)
		{
			navigateWindow.getNorth().setEnabled(false);
		}
		else
		{
			if (player.getWorld().get(player.getWorld().get(player.getCurrentroom()).getNorth()).isHidden())
			{
				navigateWindow.getNorth().setEnabled(false);
			}
			else
			{
				navigateWindow.getNorth().setEnabled(true);
			}
		}
		if (!(player.getWorld().get(player.getCurrentroom()).getItems().isEmpty()))
		{
			navigateWindow.getItem().setEnabled(true);
			navigateWindow.setItemName(player.getWorld().get(player.getCurrentroom()).getItems().get(0).toString());
		}
		else
		{
			navigateWindow.getItem().setEnabled(false);
			navigateWindow.setItemName("item");
		}
		if (printNormaldescription)
		{
			navigateWindow.write(player.getWorld().get(player.getCurrentroom()).getDescription()+"\n");
		}
		if (player.getWorld().get(player.getCurrentroom()) instanceof FinalRoom)
			if (((FinalRoom)player.getWorld().get(player.getCurrentroom())).isFinal())
			{
				navigateWindow.getAttack().setVisible(false);
				navigateWindow.getEast().setVisible(false);
				navigateWindow.getWest().setVisible(false);
				navigateWindow.getNorth().setVisible(false);
				navigateWindow.getSouth().setVisible(false);
				navigateWindow.getItem().setVisible(false);
				navigateWindow.getInventory().setVisible(false);
				navigateWindow.getSearchroom().setVisible(false);
				navigateWindow.getTalk().setVisible(false);
				navigateWindow.getNextact().setVisible(true);
				if (player.getAct().getGotoAct()!=null)
					navigateWindow.getNextact().setEnabled(true);
			}
		if (!player.getWorld().get(player.getCurrentroom()).getNpcs().isEmpty())
		{
			if (player.getWorld().get(player.getCurrentroom()).getNpcs().get(0).isTalking())
			{
				Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getNpcs().get(0).getDialogcontroller().talk(0);
				Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getNpcs().get(0).getDialogcontroller().write(player.getWorld().get(player.getCurrentroom()).getDescription()+"\n");
			}
			navigateWindow.getTalk().setEnabled(true);
		}
		else
		{
			navigateWindow.getTalk().setEnabled(false);
		}
		navigateWindow.getFrame().pack();
	}
	public void attack()
	{
		battle = new Battle(player.getWorld().get(player.getCurrentroom()).getEnemies().get(0));
		navigateWindow.write("You are in battle with "+player.getWorld().get(player.getCurrentroom()).getEnemies().get(0).getName()+"\n");
		navigateWindow.getFrame().setVisible(false);
	}

	public void takeItem()
	{
		if (player.getWorld().get(player.getCurrentroom()) instanceof EventRoom)
		{
			for (int i = 0; i < ((EventRoom)player.getWorld().get(player.getCurrentroom())).getEvents().size(); i++) 
			{
				if (((EventRoom) player.getWorld().get(player.getCurrentroom())).getEvents().get(i).getCondition()==ERoomEventCondition.ITEM_TAKEN)
				{
					if (player.getWorld().get(player.getCurrentroom()).getItems().get(0)==((EventRoom) player.getWorld().get(player.getCurrentroom())).getEvents().get(i).getItemtaken())
					{
						((EventRoom) player.getWorld().get(player.getCurrentroom())).getEvents().get(i).setItemtaken(true);						
					}
				}
			}
			((EventRoom) player.getWorld().get(player.getCurrentroom())).evaluateCondition();
		}
		if (player.getWorld().get(player.getCurrentroom()).getItems().get(0) instanceof Gold)
		{
			Gold castgold=(Gold) player.getWorld().get(player.getCurrentroom()).getItems().get(0);
			navigateWindow.write("You've taken "+castgold.getAmmount()+" gold\n");			
			player.setGold(player.getGold()+castgold.getAmmount());
			player.getWorld().get(player.getCurrentroom()).getItems().remove(0);
		}
		else
		{
			navigateWindow.write("You've added "+player.getWorld().get(player.getCurrentroom()).getItems().get(0)+" to your inventory\n");
			player.getInventory().add(player.getWorld().get(player.getCurrentroom()).getItems().remove(0));
		}
		if (!player.getWorld().get(player.getCurrentroom()).getItems().isEmpty())
		{
			navigateWindow.setItemName(player.getWorld().get(player.getCurrentroom()).getItems().get(0).toString());
		}
		else
		{
			navigateWindow.setItemName("item");
			navigateWindow.getItem().setEnabled(false);
		}
		navigateWindow.getFrame().pack();
	}
	public void useKey(Key key)
	{
		boolean usedKey=false;
		if (player.getWorld().get(player.getCurrentroom()).getNorth()!=null)
		{
			if (!player.getWorld().get(player.getWorld().get(player.getCurrentroom()).getNorth()).getUnlockKeys().isEmpty() && !player.getWorld().get(player.getWorld().get(player.getCurrentroom()).getNorth()).isHidden())
			{
				if (key.getId()==player.getWorld().get(player.getWorld().get(player.getCurrentroom()).getNorth()).getUnlockKeys().get(0).getId())
				{
					usedKey=true;
					navigateWindow.write("The door to the north is now unlocked\n");
					player.getWorld().get(player.getWorld().get(player.getCurrentroom()).getNorth()).getUnlockKeys().remove(0);
					for (int i = 0; i < player.getInventory().size(); i++) 
					{
						if (player.getInventory().get(i)==key)
						{
							player.getInventory().remove(i);
						}
					}
					if (player.getWorld().get(player.getWorld().get(player.getCurrentroom()).getNorth()).getUnlockKeys().isEmpty())
					{
						player.getWorld().get(player.getWorld().get(player.getCurrentroom()).getNorth()).setLocked(false);
					}
				}
			}
		}
		if (player.getWorld().get(player.getCurrentroom()).getSouth()!=null) 
		{
			if (!player.getWorld().get(player.getWorld().get(player.getCurrentroom()).getSouth()).getUnlockKeys().isEmpty() && !player.getWorld().get(player.getWorld().get(player.getCurrentroom()).getSouth()).isHidden())
			{
				if (key.getId()==player.getWorld().get(player.getWorld().get(player.getCurrentroom()).getSouth()).getUnlockKeys().get(0).getId())
				{
					usedKey=true;
					navigateWindow.write("The door to the south is now unlocked\n");
					player.getWorld().get(player.getWorld().get(player.getCurrentroom()).getSouth()).getUnlockKeys().remove(0);
					for (int i = 0; i < player.getInventory().size(); i++) 
					{
						if (player.getInventory().get(i)==key)
						{
							player.getInventory().remove(i);
						}
					}
					if (player.getWorld().get(player.getWorld().get(player.getCurrentroom()).getSouth()).getUnlockKeys().isEmpty())
					{
						player.getWorld().get(player.getWorld().get(player.getCurrentroom()).getSouth()).setLocked(false);
					}
				}
			}
		}
		if (player.getWorld().get(player.getCurrentroom()).getEast()!=null) 
		{
			if (!player.getWorld().get(player.getWorld().get(player.getCurrentroom()).getEast()).getUnlockKeys().isEmpty() && !player.getWorld().get(player.getWorld().get(player.getCurrentroom()).getEast()).isHidden())
			{
				if (key.getId()==player.getWorld().get(player.getWorld().get(player.getCurrentroom()).getEast()).getUnlockKeys().get(0).getId())
				{
					usedKey=true;
					navigateWindow.write("The door to the east is now unlocked\n");
					player.getWorld().get(player.getWorld().get(player.getCurrentroom()).getEast()).getUnlockKeys().remove(0);
					for (int i = 0; i < player.getInventory().size(); i++) 
					{
						if (player.getInventory().get(i)==key)
						{
							player.getInventory().remove(i);
						}
					}
					if (player.getWorld().get(player.getWorld().get(player.getCurrentroom()).getEast()).getUnlockKeys().isEmpty())
					{
						player.getWorld().get(player.getWorld().get(player.getCurrentroom()).getEast()).setLocked(false);
					}
				}
			}
		}
		if (player.getWorld().get(player.getCurrentroom()).getWest()!=null) 
		{
			if (!player.getWorld().get(player.getWorld().get(player.getCurrentroom()).getWest()).getUnlockKeys().isEmpty() && !player.getWorld().get(player.getWorld().get(player.getCurrentroom()).getWest()).isHidden())
			{
				if (key.getId()==player.getWorld().get(player.getWorld().get(player.getCurrentroom()).getWest()).getUnlockKeys().get(0).getId())		
				{
					usedKey=true;
					navigateWindow.write("The door to the west is now unlocked\n");
					player.getWorld().get(player.getWorld().get(player.getCurrentroom()).getWest()).getUnlockKeys().remove(0);
					for (int i = 0; i < player.getInventory().size(); i++) 
					{
						if (player.getInventory().get(i)==key)
						{
							player.getInventory().remove(i);
						}
					}
					if (player.getWorld().get(player.getWorld().get(player.getCurrentroom()).getWest()).getUnlockKeys().isEmpty())
					{
						player.getWorld().get(player.getWorld().get(player.getCurrentroom()).getWest()).setLocked(false);
					}
				}
			}
		}
		if (usedKey)
		{
			if (player.getWorld().get(player.getCurrentroom()) instanceof EventRoom)
			{
				for (int i = 0; i < ((EventRoom)player.getWorld().get(player.getCurrentroom())).getEvents().size(); i++) 
				{
					if (((EventRoom)player.getWorld().get(player.getCurrentroom())).getEvents().get(i).getCondition()==ERoomEventCondition.ITEM_USED)
					{
						if (key.getId()==((Key)((EventRoom)player.getWorld().get(player.getCurrentroom())).getEvents().get(i).getItemUsed()).getId())
						{
							((EventRoom)player.getWorld().get(player.getCurrentroom())).getEvents().get(i).setItemused(true);
							((EventRoom)player.getWorld().get(player.getCurrentroom())).evaluateCondition();
						}
					}
				}
			}
		}
		if (usedKey==false)
		{
			navigateWindow.write("You can't use "+key+" here\n");
		}
	}
	public void addExp(int exp)
	{
		player.setExperience(player.getExperience()+exp);
		levelup(player.getExperience());
	}
	private void levelup(int exp)
	{
		double expcap=Math.pow(((15.81)*(player.getLevel()+1)),2);		
		if (player.getExperience()>=expcap && player.getLevel()!=20) 
		{
			player.setLevel(player.getLevel()+1);
			navigateWindow.write("Congratulations! You've reached level "+player.getLevel()+"\n");
			LevelupGUI levelup = new LevelupGUI();
			levelup.setup();
		}
	}
	public void revealHiddenDoor()
	{
		boolean hiddenDoor=false;
		if (player.getWorld().get(player.getCurrentroom()).getNorth()!=null)
		{
			if (player.getWorld().get(player.getWorld().get(player.getCurrentroom()).getNorth()).isHidden() && (!player.getWorld().get(player.getWorld().get(player.getCurrentroom()).getNorth()).isHiddenEvent()))
			{
				navigateWindow.write(player.getWorld().get(player.getWorld().get(player.getCurrentroom()).getNorth()).getHiddenDescription()+"\n");
				player.getWorld().get(player.getWorld().get(player.getCurrentroom()).getNorth()).setHidden(false);
				navigateWindow.getNorth().setEnabled(true);
				hiddenDoor=true;
				player.getWorld().get(player.getCurrentroom()).setRevealed(true);
				if (player.getWorld().get(player.getWorld().get(player.getCurrentroom()).getNorth()) instanceof EventRoom)
				{
					for (int i = 0; i < ((EventRoom) player.getWorld().get(player.getWorld().get(player.getCurrentroom()).getNorth())).getEvents().size(); i++) 
					{
						if (((EventRoom) player.getWorld().get(player.getWorld().get(player.getCurrentroom()).getNorth())).getEvents().get(i).getCondition()==ERoomEventCondition.HIDDENROOM_FOUND)
						{
							((EventRoom) player.getWorld().get(player.getWorld().get(player.getCurrentroom()).getNorth())).getEvents().get(i).setHiddenroomfound(player.getWorld().get(player.getCurrentroom()).getNorth());
						}
					}
				}
			}
		}
		if (player.getWorld().get(player.getCurrentroom()).getSouth()!=null)
		{
			if (player.getWorld().get(player.getWorld().get(player.getCurrentroom()).getSouth()).isHidden() && (!player.getWorld().get(player.getWorld().get(player.getCurrentroom()).getSouth()).isHiddenEvent()))
			{
				navigateWindow.write(player.getWorld().get(player.getWorld().get(player.getCurrentroom()).getSouth()).getHiddenDescription()+"\n");
				player.getWorld().get(player.getWorld().get(player.getCurrentroom()).getSouth()).setHidden(false);
				navigateWindow.getSouth().setEnabled(true);
				hiddenDoor=true;
				player.getWorld().get(player.getCurrentroom()).setRevealed(true);
				if (player.getWorld().get(player.getWorld().get(player.getCurrentroom()).getSouth()) instanceof EventRoom)
				{
					for (int i = 0; i < ((EventRoom) player.getWorld().get(player.getWorld().get(player.getCurrentroom()).getSouth())).getEvents().size(); i++) 
					{
						if (((EventRoom) player.getWorld().get(player.getWorld().get(player.getCurrentroom()).getSouth())).getEvents().get(i).getCondition()==ERoomEventCondition.HIDDENROOM_FOUND)
						{
							((EventRoom) player.getWorld().get(player.getWorld().get(player.getCurrentroom()).getSouth())).getEvents().get(i).setHiddenroomfound(player.getWorld().get(player.getCurrentroom()).getSouth());
						}
					}
				}
			}
		}
		if (player.getWorld().get(player.getCurrentroom()).getEast()!=null)
		{
			if (player.getWorld().get(player.getWorld().get(player.getCurrentroom()).getEast()).isHidden() && (!player.getWorld().get(player.getWorld().get(player.getCurrentroom()).getEast()).isHiddenEvent()))
			{
				navigateWindow.write(player.getWorld().get(player.getWorld().get(player.getCurrentroom()).getEast()).getHiddenDescription()+"\n");
				player.getWorld().get(player.getWorld().get(player.getCurrentroom()).getEast()).setHidden(false);
				navigateWindow.getEast().setEnabled(true);
				hiddenDoor=true;
				player.getWorld().get(player.getCurrentroom()).setRevealed(true);
				if (player.getWorld().get(player.getWorld().get(player.getCurrentroom()).getEast()) instanceof EventRoom)
				{
					for (int i = 0; i < ((EventRoom) player.getWorld().get(player.getWorld().get(player.getCurrentroom()).getEast())).getEvents().size(); i++) 
					{
						if (((EventRoom) player.getWorld().get(player.getWorld().get(player.getCurrentroom()).getEast())).getEvents().get(i).getCondition()==ERoomEventCondition.HIDDENROOM_FOUND)
						{
							((EventRoom) player.getWorld().get(player.getWorld().get(player.getCurrentroom()).getEast())).getEvents().get(i).setHiddenroomfound(player.getWorld().get(player.getCurrentroom()).getEast());
						}
					}
				}
			}
		}
		if (player.getWorld().get(player.getCurrentroom()).getWest()!=null)
		{
			if (player.getWorld().get(player.getWorld().get(player.getCurrentroom()).getWest()).isHidden() && (!player.getWorld().get(player.getWorld().get(player.getCurrentroom()).getWest()).isHiddenEvent()))
			{
				navigateWindow.write(player.getWorld().get(player.getWorld().get(player.getCurrentroom()).getWest()).getHiddenDescription()+"\n");
				player.getWorld().get(player.getWorld().get(player.getCurrentroom()).getWest()).setHidden(false);
				navigateWindow.getWest().setEnabled(true);
				hiddenDoor=true;
				player.getWorld().get(player.getCurrentroom()).setRevealed(true);
				if (player.getWorld().get(player.getWorld().get(player.getCurrentroom()).getNorth()) instanceof EventRoom)
				{
					for (int i = 0; i < ((EventRoom) player.getWorld().get(player.getWorld().get(player.getCurrentroom()).getWest())).getEvents().size(); i++) 
					{
						if (((EventRoom) player.getWorld().get(player.getWorld().get(player.getCurrentroom()).getWest())).getEvents().get(i).getCondition()==ERoomEventCondition.HIDDENROOM_FOUND)
						{
							((EventRoom) player.getWorld().get(player.getWorld().get(player.getCurrentroom()).getWest())).getEvents().get(i).setHiddenroomfound(player.getWorld().get(player.getCurrentroom()).getWest());
						}
					}
				}
			}
		}
		if (hiddenDoor==false)
		{
			navigateWindow.write("There is nothing hidden...\n");
		}
	}

	public NavigationGUI getNavigateWindow() {
		return navigateWindow;
	}

	public Battle getBattle() {
		return battle;
	}

	public void setBattle(Battle battle) {
		this.battle = battle;
	}

	public void attackedBy(Enemy enemy) 
	{
		battle = new Battle(enemy);
		navigateWindow.write("You are attacked by "+enemy.getName()+"\n");
		navigateWindow.getFrame().setVisible(false);
		battle.switchTurn();
	}

	public void seeStats()
	{
		StatsGUI stats = new StatsGUI();
		stats.setup();
	}

	public void seeInventory()
	{
		if (player.getInventory().isEmpty())
		{
			if (isInBattle())
			{
				battle.getGUI().write("You have no items in your inventory!\n");
			}
			else
			{						
				navigateWindow.write("You have no items in your inventory!\n");
			}
		}
		else
		{
			inventoryGUI.setup();
		}
	}

	public boolean isInBattle()
	{
		if (battle==null)
		{
			return false;
		}
		else
		{
			return battle.isInBattle();
		}
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public void useAccessory(Accessory accessory) 
	{
		for (int i = 0; i < ((EventRoom)(Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()))).getEvents().size(); i++) 
		{
			((EventRoom)(Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()))).getEvents().get(i).setItemused(true);			
		}
		((EventRoom)(Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()))).evaluateCondition();
		for (int j = 0; j < Engine.engine.getPlayer().getQuests().size(); j++)
		{
			if (Engine.engine.getPlayer().getQuests().get(j)!=null)
			{
				if (!Engine.engine.getPlayer().getQuests().get(j).isComplete())
				{
					if (Engine.engine.getPlayer().getQuests().get(j).getQuestCondition()==ERoomEventCondition.ITEM_USED && Engine.engine.getPlayer().getQuests().get(j).getQuestItem()==accessory.toString())
					{
						Engine.engine.getPlayer().getQuests().get(j).setComplete(true);
						Engine.engine.addExp(Engine.engine.getPlayer().getQuests().get(j).getXpEarned());
						navigateWindow.write("Quest completed!\n");
						navigateWindow.write("You've gained "+Engine.engine.getPlayer().getQuests().get(j).getXpEarned()+" experience!\n");
					}
				}
			}
		}
	}
	public void talk() 
	{
		if (!Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getNpcs().isEmpty())
		{
			if (Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getNpcs().get(0).isFirsttime())
			{
				Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getNpcs().get(0).getDialogcontroller().talk(0);
				Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getNpcs().get(0).setFirsttime(false);
			}
			else
			{
				Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getNpcs().get(0).getDialogcontroller().talk(Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getNpcs().get(0).getGotoId());
			}
		}
	}
}

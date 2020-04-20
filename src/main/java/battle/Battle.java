package battle;

import engine.Engine;
import gui.BattleGUI;
import gui.MagicGUI;

import java.io.Serializable;

import leveleditor.actors.ECreatureClass;
import leveleditor.actors.EElement;
import leveleditor.actors.Enemy;
import leveleditor.room.ERoomEventCondition;
import leveleditor.room.EventRoom;
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
public class Battle implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6566439610434485869L;
	private Enemy enemy;
	private int playerTurn;
	private BattleGUI GUI;
	private boolean isCrit;
	private MagicGUI magicGUI=new MagicGUI();
	private boolean isInBattle;

	public Battle(Enemy enemy)
	{
		GUI = new BattleGUI();
		GUI.setup();
		this.enemy=enemy;
		isCrit=false;
		isInBattle=true;
		playerTurn=Engine.engine.getPlayer().getInitPlayerActions();
		GUI.write("You are in battle with "+enemy.getName()+"\n");
		enemy.setHp(enemy.getInitHp());
		if (Engine.engine.getPlayer().getCreatureClass()==ECreatureClass.Wizard)
		{
			magicGUI.setup();
			GUI.write("You have "+Engine.engine.getPlayer().getMana()+" mana!\n");
		}
	}
	public void write(String text)
	{
		GUI.write(text);
	}
	private boolean hitOpponent(boolean isPlayer)
	{
		double playerAgility=Engine.engine.getPlayer().getAgility();
		double enemyAgility=enemy.getAgility();
		int d20=(int)(Math.random()*19);
		if (d20==0)
		{
			isCrit=true;
			return true;
		}
		if (isPlayer)
		{
			double hitenemy=(playerAgility/enemyAgility)*17;	
			if (d20 <= hitenemy)
			{
				return true;
			}
		}
		else
		{
			double hitenemy=(enemyAgility/playerAgility)*17;
			if (d20 <= hitenemy)
			{
				return true;
			}
		}
		return false;
	}
	public void castSpell(int damage, EElement spellType, int manaUsed)
	{
		if (Engine.engine.getPlayer().getMana()-manaUsed>=0)
		{
			if (spellType==EElement.HEAL && (Engine.engine.getPlayer().getHp()+damage)>Engine.engine.getPlayer().getInitHp())
			{
				write("You have full HP!\n");
			}
			else
			{
				write("You've cast the spell!\n");
				playerTurn--;
				Engine.engine.getPlayer().setMana(Engine.engine.getPlayer().getMana()-manaUsed);
				double dmg=0.0;
				if (spellType==EElement.FIRE)
				{
					double resist = (double)enemy.getResistFire()/100;
					dmg = damage - damage*resist;
				}
				else if (spellType==EElement.ICE)
				{
					double resist = (double)enemy.getResistIce()/100;
					dmg = damage - damage*resist;

				}
				else if (spellType==EElement.LIGHTNING)
				{
					double resist = (double)enemy.getResistLightning()/100;
					dmg = damage - damage*resist;
				}
				else if (spellType==EElement.POISON)
				{
					double resist = (double)enemy.getResistPoison()/100;
					dmg = damage - damage*resist;
				}
				if (spellType==EElement.HEAL)
				{					
					Engine.engine.getPlayer().setHp(Engine.engine.getPlayer().getHp()+damage);
					write("You now have "+Engine.engine.getPlayer().getHp()+" HP\n");
				}
				else
				{
					enemy.setHp(enemy.getHp()-(int)dmg);
					write("You've damaged "+enemy.getName()+" for "+(int)dmg+"!\n");
					write(enemy.getName()+" now has "+enemy.getHp()+" HP left!\n");
					write("You have "+Engine.engine.getPlayer().getMana()+" mana left!\n");
					if (fleeEnemy())
					{
						Engine.engine.getNavigateWindow().write(enemy.getName()+" is trying to flee!\n");
						GUI.write(enemy.getName()+" is trying to flee!\n");
						int enemyHP=enemy.getHp()-(int)dmg;
						enemy.setHp(enemyHP);
						playerTurn--;
						GUI.write("You hit "+enemy.getName()+" for "+(int)dmg+"!\n"+enemy.getName()+" now has "+enemy.getHp()+" HP left\n");
					}
					if (enemy.getHp()<0)
					{
						victory();
					}
				}
				if (playerTurn==0)
				{
					GUI.getAttack().setEnabled(false);
					magicGUI.getFrame().setVisible(false);
				}
			}
		}
		else
		{
			write("You don't have enough mana to cast the spell!\n");
		}
	}
	public void attackEnemy()
	{
		if (hitOpponent(true))
		{
			double dmg=0.0;
			double denominator;
			denominator=(100+enemy.getArmor());

			if (Engine.engine.getPlayer().getEquippedWeapon()!=null)
			{
				double dmgWeapon=Engine.engine.getPlayer().getEquippedWeapon().getAllDamage();
				if (Engine.engine.getPlayer().getEquippedWeapon().getDamageType()!=null)
				{
					if (Engine.engine.getPlayer().getEquippedWeapon().getDamageType()==EElement.FIRE)
					{
						double resist = (double)enemy.getResistFire()/100;
						dmgWeapon-=dmgWeapon*resist;
					}
					else if (Engine.engine.getPlayer().getEquippedWeapon().getDamageType()==EElement.ICE)
					{
						double resist = (double)enemy.getResistIce()/100;
						dmgWeapon-=dmgWeapon*resist;
					}
					else if (Engine.engine.getPlayer().getEquippedWeapon().getDamageType()==EElement.LIGHTNING)
					{
						double resist = (double)enemy.getResistLightning()/100;
						dmgWeapon-=dmgWeapon*resist;
					}
					else if (Engine.engine.getPlayer().getEquippedWeapon().getDamageType()==EElement.POISON)
					{
						double resist = (double)enemy.getResistPoison()/100;
						dmgWeapon-=dmgWeapon*resist;
					}
				}
				dmg=100*((Engine.engine.getPlayer().getStrength()+dmgWeapon)/denominator);
			}
			else
			{
				dmg=100*(Engine.engine.getPlayer().getStrength()/denominator);
			}
			if (isCrit)
			{		
				dmg=dmg*2; //TODO: Change crit factor so it's a variable
				int enemyHP=enemy.getHp()-(int)dmg;
				enemy.setHp(enemyHP);
				playerTurn--;
				GUI.write("You've crit "+enemy.getName()+" for "+(int)dmg+"!\n"+enemy.getName()+" now has "+enemy.getHp()+" HP left\n");
				isCrit=false;
			}
			else
			{
				int enemyHP=enemy.getHp()-(int)dmg;
				enemy.setHp(enemyHP);
				playerTurn--;
				GUI.write("You hit "+enemy.getName()+" for "+(int)dmg+"!\n"+enemy.getName()+" now has "+enemy.getHp()+" HP left\n");
			}
			if (fleeEnemy())
			{
				Engine.engine.getNavigateWindow().write(enemy.getName()+" is trying to flee!\n");
				GUI.write(enemy.getName()+" is trying to flee!\n");
				int enemyHP=enemy.getHp()-(int)dmg;
				enemy.setHp(enemyHP);
				playerTurn--;
				GUI.write("You hit "+enemy.getName()+" for "+(int)dmg+"!\n"+enemy.getName()+" now has "+enemy.getHp()+" HP left\n");
			}
			if (enemy.getHp()<0)
			{
				victory();
			}
			if (playerTurn==0)
			{
				GUI.getAttack().setEnabled(false);
			}
		}
		else
		{
			playerTurn--;
			GUI.write("You missed "+enemy.getName()+"\n");
			if (playerTurn==0)
			{
				GUI.getAttack().setEnabled(false);
			}
		}
	}
	private boolean fleeEnemy() 
	{
		double scare=(double)enemy.getScarefactor()/100;
		double belowFleeHP=enemy.getInitHp()*scare;
		if (enemy.getHp()<=belowFleeHP)
		{
			return true;
		}
		return false;
	}
	public void switchTurn()
	{
		double dmg=0.0;
		double denominator;
		double elementDamage=enemy.getDamage();
		if (enemy.getDamageType()== EElement.FIRE)
		{
			elementDamage-=elementDamage*(Engine.engine.getPlayer().getResistFire()/100);
		}
		else if (enemy.getDamageType()== EElement.ICE)
		{
			elementDamage-=elementDamage*(Engine.engine.getPlayer().getResistFire()/100);
		}
		else if (enemy.getDamageType()== EElement.LIGHTNING)
		{
			elementDamage-=elementDamage*(Engine.engine.getPlayer().getResistLightning()/100);
		}
		else if (enemy.getDamageType()== EElement.POISON)
		{
			elementDamage-=elementDamage*(Engine.engine.getPlayer().getResistPoison()/100);
		}
		denominator=(100+Engine.engine.getPlayer().getArmorPts());
		dmg=100*((enemy.getStrength()+elementDamage)/denominator);
		for (int i = 0; i < enemy.getInitPlayerActions(); i++) 
		{
			if (hitOpponent(false))
			{
				if (isCrit)
				{
					dmg=dmg*2; //TODO: Change crit factor so it's a variable
					int playerHP=Engine.engine.getPlayer().getHp()-(int)dmg;
					Engine.engine.getPlayer().setHp(playerHP);
					GUI.write(enemy.getName()+" has crit you for "+(int)dmg+"!\n"+"You now have "+Engine.engine.getPlayer().getHp()+" HP left\n");
					isCrit=false;
				}
				else
				{
					int playerHP=Engine.engine.getPlayer().getHp()-(int)dmg;
					Engine.engine.getPlayer().setHp(playerHP);
					GUI.write(enemy.getName()+" hit you for "+(int)dmg+"!\n"+"You now have "+Engine.engine.getPlayer().getHp()+" HP left\n");
				}					
			}
			else
			{
				GUI.write(enemy.getName()+" missed the attack on you!\n");
			}
		}
		GUI.getAttack().setEnabled(true);
		playerTurn=Engine.engine.getPlayer().getInitPlayerActions();
		if (Engine.engine.getPlayer().getHp()<1)
		{
			defeat();
		}
		else if (Engine.engine.getPlayer().getCreatureClass()==ECreatureClass.Wizard)
		{
			magicGUI.getFrame().setVisible(true);
		}
	}
	private void defeat() 
	{
		GUI.write("You have died!\n");
		GUI.defeat();
	}
	private void victory()
	{
		int exp = enemy.getLevel()*300;
		GUI.getFrame().setVisible(false);
		Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getEnemies().remove(enemy);
		Engine.engine.getNavigateWindow().getAttack().setEnabled(false);
		if (Engine.engine.getPlayer().getCreatureClass()==ECreatureClass.Wizard)
		{ 
			magicGUI.getFrame().setVisible(false);
		}
		if (Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getEnemies().isEmpty())
		{
			Engine.engine.getNavigateWindow().getFrame().setVisible(true);
			isInBattle=false;
		}
		else
		{
			Engine.engine.attack();
		}
		Engine.engine.getNavigateWindow().write("You won the battle against "+enemy.getName()+"!\n");
		Engine.engine.getNavigateWindow().write("You've gained "+exp+" experience\n");
		Engine.engine.addExp(exp);
		if (enemy.getGold()>0)
		{
			Engine.engine.getPlayer().setGold(Engine.engine.getPlayer().getGold()+enemy.getGold());
			Engine.engine.getNavigateWindow().write("You've taken "+enemy.getGold()+" gold from "+enemy.getName()+"\n");
		}
		if (Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()) instanceof EventRoom)
		{
			for (int i = 0; i < ((EventRoom)Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom())).getEvents().size(); i++) 
			{
				if (((EventRoom)Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom())).getEvents().get(i).getCondition()==ERoomEventCondition.ENEMY_DIED)
				{
					((EventRoom)Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom())).getEvents().get(i).setEnemyDead(true);
				}
			}
			((EventRoom)Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom())).evaluateCondition();
		}
		if (!Engine.engine.getPlayer().getQuests().isEmpty())
		{
			for (int i = 0; i < Engine.engine.getPlayer().getQuests().size(); i++) 
			{
				if (Engine.engine.getPlayer().getQuests().get(i) != null)
				{
					if (Engine.engine.getPlayer().getQuests().get(i).getQuestCondition()==ERoomEventCondition.ENEMY_DIED)
					{
						if (Engine.engine.getPlayer().getQuests().get(i).getEnemydead().equals(enemy.getName()))
						{
							Engine.engine.getPlayer().getQuests().get(i).setComplete(true);
							Engine.engine.getNavigateWindow().write("Quest is complete!\n");
							Engine.engine.getNavigateWindow().write("You've gained "+Engine.engine.getPlayer().getQuests().get(i).getXpEarned()+" experience from the quest!\n");
							Engine.engine.getPlayer().setExperience(Engine.engine.getPlayer().getExperience()+Engine.engine.getPlayer().getQuests().get(i).getXpEarned());
						}
					}
				}
			}
		}
		for (int i = 0; i < enemy.getInventory().size(); i++) 
		{
			Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getItems().add(enemy.getInventory().get(i));
			Engine.engine.getNavigateWindow().write(enemy.getName()+" dropped "+enemy.getInventory().get(i)+"\n");
			Engine.engine.getNavigateWindow().setItemName(Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getItems().get(0).toString());
			Engine.engine.getNavigateWindow().getItem().setEnabled(true);
		}
	}
	public void fleeFromCombat()
	{
		double dmg=0.0;
		double denominator=(100+Engine.engine.getPlayer().getArmorPts());
		dmg=100*(enemy.getStrength()/denominator);
		int playerHP=Engine.engine.getPlayer().getHp()-(int)dmg;
		Engine.engine.getPlayer().setHp(playerHP);
		Engine.engine.getNavigateWindow().write("You try to flee!\n");
		Engine.engine.getNavigateWindow().write(enemy.getName()+" hit you for "+(int)dmg+"!\n"+"You now have "+Engine.engine.getPlayer().getHp()+" HP left\n");
		if (Engine.engine.getPlayer().getHp()<1)
		{
			GUI.write("You try to flee!\n");
			defeat();
		}	
		else if ((Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getNorth()!=null) && !Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getNorth()).isLocked() && !Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getNorth()).isHidden())
		{
			Engine.engine.getPlayer().setCurrentroom(Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getNorth());
			GUI.getFrame().setVisible(false);
			if (Engine.engine.getPlayer().getCreatureClass()==ECreatureClass.Wizard)
			{ 
				magicGUI.getFrame().setVisible(false);
			}
			isInBattle=false;
			Engine.engine.getNavigateWindow().getFrame().setVisible(true);
			Engine.engine.enterRoom();
		}
		else if ((Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getSouth()!=null) && !Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getSouth()).isLocked() && !Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getSouth()).isHidden())
		{
			Engine.engine.getPlayer().setCurrentroom(Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getSouth());
			GUI.getFrame().setVisible(false);
			if (Engine.engine.getPlayer().getCreatureClass()==ECreatureClass.Wizard)
			{ 
				magicGUI.getFrame().setVisible(false);
			}
			isInBattle=false;
			Engine.engine.getNavigateWindow().getFrame().setVisible(true);
			Engine.engine.enterRoom();
		}
		else if ((Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getEast()!=null) && !Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getEast()).isLocked() && !Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getEast()).isHidden())
		{
			Engine.engine.getPlayer().setCurrentroom(Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getEast());
			GUI.getFrame().setVisible(false);
			if (Engine.engine.getPlayer().getCreatureClass()==ECreatureClass.Wizard)
			{ 
				magicGUI.getFrame().setVisible(false);
			}
			isInBattle=false;
			Engine.engine.getNavigateWindow().getFrame().setVisible(true);
			Engine.engine.enterRoom();
		}
		else if ((Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getWest()!=null) && !Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getWest()).isLocked() && !Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getWest()).isHidden())
		{
			Engine.engine.getPlayer().setCurrentroom(Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getWest());
			GUI.getFrame().setVisible(false);
			if (Engine.engine.getPlayer().getCreatureClass()==ECreatureClass.Wizard)
			{ 
				magicGUI.getFrame().setVisible(false);
			}
			isInBattle=false;
			Engine.engine.getNavigateWindow().getFrame().setVisible(true);
			Engine.engine.enterRoom();
		}
	}
	public BattleGUI getGUI() {
		return GUI;
	}
	public boolean isInBattle() {
		return isInBattle;
	}
	public void setInBattle(boolean isInBattle) {
		this.isInBattle = isInBattle;
	}
}

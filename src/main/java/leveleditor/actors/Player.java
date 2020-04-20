package leveleditor.actors;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import leveleditor.items.Armor;
import leveleditor.items.Weapon;
import leveleditor.room.Room;
import acts.Act;
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
public class Player extends Creature implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6496633912901840265L;
	private String currentroom;
	private Act act;
	private Weapon equippedWeapon;
	private Armor equippedLeggins;
	private Armor equippedBody;
	private Armor equippedHead;
	private HashMap<String, Room> world = new HashMap<String, Room>();
	private ArrayList<Quest> quests = new ArrayList<Quest>();

	public Player() 
	{
		super();
	}

	public int getResistance(EElement element)
	{
		int resistance=0;
		if (Engine.engine.getPlayer().getEquippedBody()!=null)
		{
			if (element==EElement.FIRE)
			{
				resistance+=Engine.engine.getPlayer().getEquippedBody().getResistFire();
			}
			else if (element==EElement.ICE)
			{
				resistance+=Engine.engine.getPlayer().getEquippedBody().getResistIce();
			}
			else if (element==EElement.LIGHTNING)
			{
				resistance+=Engine.engine.getPlayer().getEquippedBody().getResistLightning();
			}
			else if (element==EElement.POISON)
			{
				resistance+=Engine.engine.getPlayer().getEquippedBody().getResistPoison();
			}
		}
		if (Engine.engine.getPlayer().getEquippedHead()!=null)
		{
			if (element==EElement.FIRE)
			{
				resistance+=Engine.engine.getPlayer().getEquippedHead().getResistFire();
			}
			else if (element==EElement.ICE)
			{
				resistance+=Engine.engine.getPlayer().getEquippedHead().getResistIce();
			}
			else if (element==EElement.LIGHTNING)
			{
				resistance+=Engine.engine.getPlayer().getEquippedHead().getResistLightning();
			}
			else if (element==EElement.POISON)
			{
				resistance+=Engine.engine.getPlayer().getEquippedHead().getResistPoison();
			}
		}
		if (Engine.engine.getPlayer().getEquippedLeggins()!=null)
		{
			if (element==EElement.FIRE)
			{
				resistance+=Engine.engine.getPlayer().getEquippedLeggins().getResistFire();
			}
			else if (element==EElement.ICE)
			{
				resistance+=Engine.engine.getPlayer().getEquippedLeggins().getResistIce();
			}
			else if (element==EElement.LIGHTNING)
			{
				resistance+=Engine.engine.getPlayer().getEquippedLeggins().getResistLightning();
			}
			else if (element==EElement.POISON)
			{
				resistance+=Engine.engine.getPlayer().getEquippedLeggins().getResistPoison();
			}
		}
		return resistance;
	}
	public int getArmorPts()
	{
		int ac=0;
		if (Engine.engine.getPlayer().getEquippedBody()!=null)
		{
			ac+=Engine.engine.getPlayer().getEquippedBody().getArmor();
		}
		if (Engine.engine.getPlayer().getEquippedHead()!=null)
		{
			ac+=Engine.engine.getPlayer().getEquippedHead().getArmor();
		}
		if (Engine.engine.getPlayer().getEquippedLeggins()!=null)
		{
			ac+=Engine.engine.getPlayer().getEquippedLeggins().getArmor();
		}
		return ac;
	}
	public Weapon getEquippedWeapon() {
		return equippedWeapon;
	}

	public void setEquippedWeapon(Weapon equippedWeapon) {
		this.equippedWeapon = equippedWeapon;
	}

	public Armor getEquippedLeggins() {
		return equippedLeggins;
	}

	public void setEquippedLeggins(Armor equippedLeggins) {
		this.equippedLeggins = equippedLeggins;
	}

	public Armor getEquippedBody() {
		return equippedBody;
	}

	public void setEquippedBody(Armor equippedBody) {
		this.equippedBody = equippedBody;
	}

	public Armor getEquippedHead() {
		return equippedHead;
	}

	public void setEquippedHead(Armor equippedHead) {
		this.equippedHead = equippedHead;
	}

	public Act getAct() {
		return act;
	}

	public void setAct(Act act) {
		this.act = act;
	}

	public String getCurrentroom() {
		return currentroom;
	}

	public void setCurrentroom(String currentroom) {
		this.currentroom = currentroom;
	}

	/**
	 * @return the world
	 */
	public HashMap<String, Room> getWorld() {
		return world;
	}

	/**
	 * @param world the world to set
	 */
	public void setWorld(HashMap<String, Room> world) {
		this.world = world;
	}

	public ArrayList<Quest> getQuests() {
		return quests;
	}

	public void setQuests(ArrayList<Quest> quests) {
		this.quests = quests;
	}
}

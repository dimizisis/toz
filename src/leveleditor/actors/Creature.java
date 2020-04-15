package leveleditor.actors;

import java.io.Serializable;
import java.util.ArrayList;

import leveleditor.items.Item;
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
public abstract class Creature implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1697139219694970388L;
	protected String name;
	protected int hp;
	protected int initHp;
	protected int initMana;
	protected int mana;
	protected int strength;
	protected int agility;
	protected int charisma;
	protected int intelligence;
	protected int level;
	protected ArrayList<Item> inventory;
	protected int experience;
	protected int gold;
	protected int initPlayerActions;
	protected int resistLightning=0;
	protected int resistFire=0;
	protected int resistPoison=0;
	protected int resistIce=0;
	protected boolean isMale;
	protected ECreatureRace race;
	protected ECreatureClass creatureClass;
	protected int armor;
	
	public Creature()
	{
		inventory = new ArrayList<Item>();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public ArrayList<Item> getInventory() {
		return inventory;
	}
	public void setInventory(ArrayList<Item> inventory) {
		this.inventory = inventory;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public int getGold() {
		return gold;
	}
	public void setGold(int gold) {
		this.gold = gold;
	}
	public int getInitPlayerActions() {
		return initPlayerActions;
	}
	public void setInitPlayerActions(int initPlayerActions) {
		this.initPlayerActions = initPlayerActions;
	}
	public int getAgility() {
		return agility;
	}
	public void setAgility(int agility) {
		this.agility = agility;
	}
	public int getResistLightning() {
		return resistLightning;
	}
	public void setResistLightning(int resistLightning) {
		this.resistLightning = resistLightning;
	}
	public int getResistFire() {
		return resistFire;
	}
	public void setResistFire(int resistFire) {
		this.resistFire = resistFire;
	}
	public int getResistPoison() {
		return resistPoison;
	}
	public void setResistPoison(int resistPoison) {
		this.resistPoison = resistPoison;
	}
	public int getResistIce() {
		return resistIce;
	}
	public void setResistIce(int resistIce) {
		this.resistIce = resistIce;
	}
	public int getInitHp() {
		return initHp;
	}
	public void setInitHp(int initHp) {
		this.initHp = initHp;
	}
	public boolean isMale() {
		return isMale;
	}
	public void setMale(boolean isMale) {
		this.isMale = isMale;
	}
	public ECreatureRace getRace() {
		return race;
	}
	public void setRace(ECreatureRace race) {
		this.race = race;
	}

	public ECreatureClass getCreatureClass() {
		return creatureClass;
	}

	public void setCreatureClass(ECreatureClass creatureClass) {
		this.creatureClass = creatureClass;
	}	
	public int getCharisma() {
		return charisma;
	}

	public void setCharisma(int charisma) {
		this.charisma = charisma;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public int getArmor() {
		return armor;
	}

	public void setArmor(int armor) {
		this.armor = armor;
	}

	public int getInitMana() {
		return initMana;
	}

	public void setInitMana(int initMana) {
		this.initMana = initMana;
	}

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}
}

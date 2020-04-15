package leveleditor.items;


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
public class Armor extends Item
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5422593050712947540L;
	private int armor;
	private EArmorType armorType;
	private int resistLightning=0;
	private int resistFire=0;
	private int resistPoison=0;
	private int resistIce=0;
	
	public int getArmor() {
		return armor;
	}

	public void setArmor(int armor) {
		this.armor = armor;
	}

	public EArmorType getArmorType() {
		return armorType;
	}

	public void setArmorType(EArmorType armorType) {
		this.armorType = armorType;
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
}

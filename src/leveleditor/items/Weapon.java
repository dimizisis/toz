package leveleditor.items;

import leveleditor.actors.EElement;

/**
 * 
 * @author Stephen Sarquah
 * @info A weapon can only have one damage type
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
public class Weapon extends Item
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -187829717587451881L;
	private int damage;
	private boolean isTwohanded;
	private int damageLightning=0;
	private int damageFire=0;
	private int damagePoison=0;
	private int damageIce=0;

	public EElement getDamageType()
	{
		if (damageFire>0)
		{
			return EElement.FIRE;
		}
		else if (damageLightning>0)
		{
			return EElement.LIGHTNING;
		}
		else if (damagePoison>0)
		{
			return EElement.POISON;
		}
		else if (damageIce>0)
		{
			return EElement.ICE;
		}
		else
		{
			return null;
		}
	}
	public int getAllDamage() {
		return damage+damageFire+damageIce+damageLightning+damagePoison;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public boolean isTwohanded() {
		return isTwohanded;
	}
	public void setTwohanded(boolean isTwohanded) {
		this.isTwohanded = isTwohanded;
	}
	public int getDamageLightning() {
		return damageLightning;
	}
	public void setDamageLightning(int damageLightning) {
		this.damageLightning = damageLightning;
	}
	public int getDamageFire() {
		return damageFire;
	}
	public void setDamageFire(int damageFire) {
		this.damageFire = damageFire;
	}
	public int getDamagePoison() {
		return damagePoison;
	}
	public void setDamagePoison(int damagePoison) {
		this.damagePoison = damagePoison;
	}
	public int getDamageIce() {
		return damageIce;
	}
	public void setDamageIce(int damageIce) {
		this.damageIce = damageIce;
	}
}

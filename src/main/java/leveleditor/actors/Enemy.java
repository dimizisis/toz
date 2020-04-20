package leveleditor.actors;

import java.io.Serializable;

/**
 * 
 * @author Stephen Sarquah
 * @info Enemy can only damage with one type of elemental damage
 * @copyright Copyright 2011 Stephen Sarquah
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
public class Enemy extends Creature implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5677635781739955292L;
	private boolean isAttacking=false;
	private int scarefactor;
	private int damageFire=0;
	private int damageLightning=0;
	private int damageIce=0;
	private int damagePoison=0;
	
	public boolean isAttacking() {
		return isAttacking;
	}

	public void setAttacking(boolean isAttacking) {
		this.isAttacking = isAttacking;
	}

	public int getScarefactor() {
		return scarefactor;
	}

	public void setScarefactor(int scarefactor) {
		this.scarefactor = scarefactor;
	}

	public int getDamageFire() {
		return damageFire;
	}

	public void setDamageFire(int damageFire) {
		this.damageFire = damageFire;
	}

	public int getDamageLightning() {
		return damageLightning;
	}

	public void setDamageLightning(int damageLightning) {
		this.damageLightning = damageLightning;
	}

	public int getDamageIce() {
		return damageIce;
	}

	public void setDamageIce(int damageIce) {
		this.damageIce = damageIce;
	}

	public int getDamagePoison() {
		return damagePoison;
	}

	public void setDamagePoison(int damagePoison) {
		this.damagePoison = damagePoison;
	}

	public int getDamage() 
	{
		return damageFire+damageIce+damageLightning+damagePoison;
	}
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
}

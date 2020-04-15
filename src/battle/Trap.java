package battle;

import java.io.Serializable;

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
public class Trap implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8875513184314500988L;
	private int poison;
	private int fire;
	private int ice;
	private int lightning;
	private int normal;
	private int trapagility;
	private ETrapType type;
	private String trapdescription;

	public void trigger() 
	{
		Engine.engine.getNavigateWindow().write(trapdescription+"\n");
		if (Engine.engine.getPlayer().getAgility()>=trapagility)
		{
			Engine.engine.getNavigateWindow().write("You've dodge the trap!\n");
		}
		else
		{
			if (type==ETrapType.FIRE)
			{
				fireDamage();
			}
			else if (type==ETrapType.ICE)
			{
				iceDamage();
			}
			else if (type==ETrapType.LIGHTNING)
			{
				lightningDamage();
			}
			else if (type==ETrapType.POISON)
			{
				poisonDamage();
			}
			else if (type==ETrapType.NORMAL)
			{
				normalDamage();
			}
		}
	}

	private void normalDamage() 
	{
		double dmg1=Engine.engine.getPlayer().getArmorPts()/100.0;
		double dmg2=normal-dmg1;
		Engine.engine.getPlayer().setHp(Engine.engine.getPlayer().getHp()-(int)dmg2);
		Engine.engine.getNavigateWindow().write("You've lost "+(int)dmg2+" health\n");
		Engine.engine.getNavigateWindow().write("You now have "+Engine.engine.getPlayer().getHp()+"\n");
		if (Engine.engine.getPlayer().getHp()<1)
		{
			defeat();
		}
	}

	private void poisonDamage()
	{
		double dmg1=Engine.engine.getPlayer().getResistPoison()/100.0;
		double dmg2=poison-dmg1;
		Engine.engine.getPlayer().setHp(Engine.engine.getPlayer().getHp()-(int)dmg2);
		Engine.engine.getNavigateWindow().write("You've lost "+(int)dmg2+" health\n");
		Engine.engine.getNavigateWindow().write("You now have "+Engine.engine.getPlayer().getHp()+"\n");
		if (Engine.engine.getPlayer().getHp()<1)
		{
			defeat();
		}
	}

	private void fireDamage()
	{
		double dmg1=Engine.engine.getPlayer().getResistFire()/100.0;
		double dmg2=fire-dmg1;
		Engine.engine.getPlayer().setHp(Engine.engine.getPlayer().getHp()-(int)dmg2);
		Engine.engine.getNavigateWindow().write("You've lost "+(int)dmg2+" health\n");
		Engine.engine.getNavigateWindow().write("You now have "+Engine.engine.getPlayer().getHp()+"\n");
		if (Engine.engine.getPlayer().getHp()<1)
		{
			defeat();
		}
	}

	private void iceDamage()
	{
		double dmg1=Engine.engine.getPlayer().getResistIce()/100.0;
		double dmg2=ice-dmg1;
		Engine.engine.getPlayer().setHp(Engine.engine.getPlayer().getHp()-(int)dmg2);
		Engine.engine.getNavigateWindow().write("You've lost "+(int)dmg2+" health\n");
		Engine.engine.getNavigateWindow().write("You now have "+Engine.engine.getPlayer().getHp()+"\n");
		if (Engine.engine.getPlayer().getHp()<1)
		{
			defeat();
		}
	}

	private void lightningDamage()
	{
		double dmg1=Engine.engine.getPlayer().getResistLightning()/100.0;
		double dmg2=lightning-dmg1;
		Engine.engine.getPlayer().setHp(Engine.engine.getPlayer().getHp()-(int)dmg2);
		Engine.engine.getNavigateWindow().write("You've lost "+(int)dmg2+" health\n");
		Engine.engine.getNavigateWindow().write("You now have "+Engine.engine.getPlayer().getHp()+"\n");
		if (Engine.engine.getPlayer().getHp()<1)
		{
			defeat();
		}
	}

	private void defeat() 
	{
		Engine.engine.getNavigateWindow().getAttack().setVisible(false);
		Engine.engine.getNavigateWindow().getEast().setVisible(false);
		Engine.engine.getNavigateWindow().getInventory().setVisible(false);
		Engine.engine.getNavigateWindow().getItem().setVisible(false);
		Engine.engine.getNavigateWindow().getNorth().setVisible(false);
		Engine.engine.getNavigateWindow().getSearchroom().setVisible(false);
		Engine.engine.getNavigateWindow().getSouth().setVisible(false);
		Engine.engine.getNavigateWindow().getTalk().setVisible(false);
		Engine.engine.getNavigateWindow().getWest().setVisible(false);
		Engine.engine.getNavigateWindow().write("You have died!\n");
	}

	public int getPoison() {
		return poison;
	}

	public void setPoison(int poison) {
		this.poison = poison;
	}

	public int getFire() {
		return fire;
	}

	public void setFire(int fire) {
		this.fire = fire;
	}

	public int getIce() {
		return ice;
	}

	public void setIce(int ice) {
		this.ice = ice;
	}

	public int getLightning() {
		return lightning;
	}

	public void setLightning(int lightning) {
		this.lightning = lightning;
	}

	public ETrapType getType() {
		return type;
	}

	public void setType(ETrapType type) {
		this.type = type;
	}

	public void setTrapdescription(String trapdescription) {
		this.trapdescription = trapdescription;
	}

	public int getNormal() {
		return normal;
	}

	public void setNormal(int normal) {
		this.normal = normal;
	}

	public int getTrapagility() {
		return trapagility;
	}

	public void setTrapagility(int trapagility) {
		this.trapagility = trapagility;
	}
}

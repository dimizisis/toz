package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import leveleditor.actors.ECreatureClass;
import leveleditor.actors.EElement;
import leveleditor.actors.ESkill;
import leveleditor.items.Accessory;
import leveleditor.items.Armor;
import leveleditor.items.EArmorType;
import leveleditor.items.Key;
import leveleditor.items.Potion;
import leveleditor.items.Weapon;
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
public class InventoryGUI 
{
	private JList itemlist;
	private JButton useKey;
	private JButton useWeapon;
	private JButton useArmor;
	private JButton useItem;
	private JFrame frame;
	private Object[] items;
	private ListSelectionModel itemsSelectionModel;
	private JTextArea text;

	public void setup()
	{
		items = Engine.engine.getPlayer().getInventory().toArray();
		frame = new JFrame("Tower of Zaldagor - Inventory");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocation(300, 200);

		JPanel navigatePanel = new JPanel();
		navigatePanel.setLayout(new FlowLayout(FlowLayout.LEFT));

		JPanel equippedPanel = new JPanel();
		equippedPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

		itemlist = new JList(items);
		itemlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		itemlist.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		itemlist.setVisibleRowCount(-1);
		JScrollPane scrollpane = new JScrollPane(itemlist, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		itemsSelectionModel=itemlist.getSelectionModel();

		useKey = new JButton("Use key");
		useKey.setToolTipText("Press this button to use the selected key");	
		useKey.setEnabled(false);

		useWeapon = new JButton("Equip weapon");
		useWeapon.setToolTipText("Press this button to equip the selected weapon");	
		useWeapon.setEnabled(false);

		useArmor = new JButton("Equip armor");
		useArmor.setToolTipText("Press this button to equip the selected armor");	
		useArmor.setEnabled(false);

		useItem = new JButton("Use item");
		useItem.setToolTipText("Press this button to use the selected item");	
		useItem.setEnabled(false);

		text = new JTextArea(7, 35);
		text.setEditable(false);
		JScrollPane scrollpaneText = new JScrollPane(text, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		itemsSelectionModel.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (itemlist.getSelectedIndex()!=-1)
				{
					if (Engine.engine.getPlayer().getInventory().get(itemlist.getSelectedIndex()) instanceof Key && Engine.engine.isInBattle()==false)
					{
						useKey.setEnabled(true);
						useWeapon.setEnabled(false);
						useArmor.setEnabled(false);
						useItem.setEnabled(false);
					}
					else if (Engine.engine.getPlayer().getInventory().get(itemlist.getSelectedIndex()) instanceof Weapon && Engine.engine.isInBattle()==false)
					{
						useWeapon.setEnabled(true);
						useKey.setEnabled(false);
						useArmor.setEnabled(false);
						useItem.setEnabled(false);
					}
					else if (Engine.engine.getPlayer().getInventory().get(itemlist.getSelectedIndex()) instanceof Armor && Engine.engine.isInBattle()==false)
					{
						useWeapon.setEnabled(false);
						useKey.setEnabled(false);
						useArmor.setEnabled(true);
						useItem.setEnabled(false);
					}
					else if (Engine.engine.getPlayer().getInventory().get(itemlist.getSelectedIndex()) instanceof Potion)
					{
						useWeapon.setEnabled(false);
						useKey.setEnabled(false);
						useArmor.setEnabled(false);
						useItem.setEnabled(true);
					}
					else if (Engine.engine.getPlayer().getInventory().get(itemlist.getSelectedIndex()) instanceof Accessory && Engine.engine.isInBattle()==false)
					{
						useWeapon.setEnabled(false);
						useKey.setEnabled(false);
						useArmor.setEnabled(false);
						useItem.setEnabled(true);
					}
					else
					{
						useWeapon.setEnabled(false);
						useKey.setEnabled(false);
						useArmor.setEnabled(false);
						useItem.setEnabled(false);
					}
				}
			}
		});
		useKey.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {				
				Engine.engine.useKey((Key) Engine.engine.getPlayer().getInventory().get(itemlist.getSelectedIndex()));
				frame.setVisible(false);
			}
		});
		useWeapon.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Engine.engine.getPlayer().setEquippedWeapon((Weapon) Engine.engine.getPlayer().getInventory().get(itemlist.getSelectedIndex()));
				Engine.engine.getNavigateWindow().write("You've equipped yourself with "+Engine.engine.getPlayer().getInventory().get(itemlist.getSelectedIndex())+"\n");
				frame.setVisible(false);
			}
		});
		useArmor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (((Armor) Engine.engine.getPlayer().getInventory().get(itemlist.getSelectedIndex())).getArmorType() == EArmorType.HEAD)
				{
					Engine.engine.getPlayer().setEquippedHead((Armor) Engine.engine.getPlayer().getInventory().get(itemlist.getSelectedIndex()));
					Engine.engine.getNavigateWindow().write("You've equipped yourself with "+Engine.engine.getPlayer().getInventory().get(itemlist.getSelectedIndex())+" on your head\n");
					frame.setVisible(false);
				}
				else if (((Armor) Engine.engine.getPlayer().getInventory().get(itemlist.getSelectedIndex())).getArmorType() == EArmorType.BODY)
				{
					Engine.engine.getPlayer().setEquippedBody((Armor) Engine.engine.getPlayer().getInventory().get(itemlist.getSelectedIndex()));
					Engine.engine.getNavigateWindow().write("You've equipped yourself with "+Engine.engine.getPlayer().getInventory().get(itemlist.getSelectedIndex())+" on your body\n");
					frame.setVisible(false);
				}
				else if (((Armor) Engine.engine.getPlayer().getInventory().get(itemlist.getSelectedIndex())).getArmorType() == EArmorType.LEGGINS)
				{
					Engine.engine.getPlayer().setEquippedLeggins((Armor) Engine.engine.getPlayer().getInventory().get(itemlist.getSelectedIndex()));
					Engine.engine.getNavigateWindow().write("You've equipped yourself with "+Engine.engine.getPlayer().getInventory().get(itemlist.getSelectedIndex())+" on your leggins\n");
					frame.setVisible(false);
				}
			}
		});
		useItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (Engine.engine.getPlayer().getInventory().get(itemlist.getSelectedIndex()) instanceof Potion)
				{
					if (((Potion)(Engine.engine.getPlayer().getInventory().get(itemlist.getSelectedIndex()))).getSkill()==ESkill.MANA)
					{
						if (Engine.engine.isInBattle())
						{
							if (Engine.engine.getPlayer().getCreatureClass()==ECreatureClass.Warrior)
							{
								Engine.engine.getBattle().getGUI().write("You cannot use this potion\n");
							}
							else
							{
								Engine.engine.getBattle().getGUI().write("You've used "+Engine.engine.getPlayer().getInventory().get(itemlist.getSelectedIndex()));
								Engine.engine.getBattle().getGUI().write(" and added "+((Potion)(Engine.engine.getPlayer().getInventory().get(itemlist.getSelectedIndex()))).getAddSkill()+" to your mana\n");
							}
							Engine.engine.getPlayer().setMana(Engine.engine.getPlayer().getMana()+((Potion)(Engine.engine.getPlayer().getInventory().get(itemlist.getSelectedIndex()))).getAddSkill());
						}
						else
						{
							if (Engine.engine.getPlayer().getCreatureClass()==ECreatureClass.Warrior)
							{
								Engine.engine.getNavigateWindow().write("You cannot use this potion\n");
							}
							else
							{
								Engine.engine.getNavigateWindow().write("You've used "+Engine.engine.getPlayer().getInventory().get(itemlist.getSelectedIndex()));
								Engine.engine.getNavigateWindow().write(" and added "+((Potion)(Engine.engine.getPlayer().getInventory().get(itemlist.getSelectedIndex()))).getAddSkill()+" to your mana\n");
							}
							Engine.engine.getPlayer().setMana(Engine.engine.getPlayer().getMana()+((Potion)(Engine.engine.getPlayer().getInventory().get(itemlist.getSelectedIndex()))).getAddSkill());
						}						
					}
					else if (((Potion)(Engine.engine.getPlayer().getInventory().get(itemlist.getSelectedIndex()))).getSkill()==ESkill.HP)
					{
						if (Engine.engine.isInBattle())
						{
							Engine.engine.getBattle().getGUI().write("You've used "+Engine.engine.getPlayer().getInventory().get(itemlist.getSelectedIndex()));
							Engine.engine.getBattle().getGUI().write(" and added "+((Potion)(Engine.engine.getPlayer().getInventory().get(itemlist.getSelectedIndex()))).getAddSkill()+" to your HP\n");
						}
						else
						{
							Engine.engine.getNavigateWindow().write("You've used "+Engine.engine.getPlayer().getInventory().get(itemlist.getSelectedIndex()));
							Engine.engine.getNavigateWindow().write(" and added "+((Potion)(Engine.engine.getPlayer().getInventory().get(itemlist.getSelectedIndex()))).getAddSkill()+" to your HP\n");						
						}
						Engine.engine.getPlayer().setHp(Engine.engine.getPlayer().getHp()+((Potion)(Engine.engine.getPlayer().getInventory().get(itemlist.getSelectedIndex()))).getAddSkill());					
					}
					Engine.engine.getPlayer().getInventory().remove(itemlist.getSelectedIndex());
					frame.setVisible(false);
				}
				//TODO: Needs to do the same for strength etc.
				else if (Engine.engine.getPlayer().getInventory().get(itemlist.getSelectedIndex()) instanceof Accessory && !Engine.engine.isInBattle())
				{
					if (((Accessory)(Engine.engine.getPlayer().getInventory().get(itemlist.getSelectedIndex()))).getRoom()==Engine.engine.getPlayer().getCurrentroom())
					{
						Engine.engine.useAccessory((Accessory)(Engine.engine.getPlayer().getInventory().get(itemlist.getSelectedIndex())));
						Engine.engine.getPlayer().getInventory().remove(itemlist.getSelectedIndex());
						frame.setVisible(false);
					}
					else
					{
						Engine.engine.getNavigateWindow().write("You can't use this item here\n");
						frame.setVisible(false);
					}
				}				
			}
		});

		navigatePanel.add(useKey);
		navigatePanel.add(useWeapon);
		navigatePanel.add(useArmor);
		navigatePanel.add(useItem);
		navigatePanel.add(scrollpane);

		equippedPanel.add(scrollpaneText);

		frame.getContentPane().setLayout(new BorderLayout());
		frame.getContentPane().add(navigatePanel, BorderLayout.NORTH);
		frame.getContentPane().add(equippedPanel, BorderLayout.SOUTH);
		frame.pack();
		frame.setResizable(false);
		frame.setVisible(true);
		seeEquipedItems();
	}
	public void seeEquipedItems()
	{
		if (Engine.engine.getPlayer().getEquippedHead()!=null)
		{
			text.append("Equipped armor head:\n"+Engine.engine.getPlayer().getEquippedHead()+" (Armor points: "+Engine.engine.getPlayer().getEquippedHead().getArmor()+") ");
			if (Engine.engine.getPlayer().getEquippedHead().getResistFire()!=0)
			{
				text.append("(Resist fire: "+Engine.engine.getPlayer().getEquippedHead().getResistFire()+") ");
			}
			if (Engine.engine.getPlayer().getEquippedHead().getResistIce()!=0)
			{
				text.append("(Resist ice: "+Engine.engine.getPlayer().getEquippedHead().getResistIce()+") ");
			}
			if (Engine.engine.getPlayer().getEquippedHead().getResistLightning()!=0)
			{
				text.append("(Resist lightning: "+Engine.engine.getPlayer().getEquippedHead().getResistLightning()+") ");
			}
			if (Engine.engine.getPlayer().getEquippedHead().getResistPoison()!=0)
			{
				text.append("(Resist poison: "+Engine.engine.getPlayer().getEquippedHead().getResistPoison()+") ");
			}
			text.append("\n");
		}
		else
		{
			text.append("Equipped armor head: Nothing\n");
		}
		if (Engine.engine.getPlayer().getEquippedBody()!=null)
		{
			text.append("Equipped armor body:\n"+Engine.engine.getPlayer().getEquippedBody()+" (Armor points: "+Engine.engine.getPlayer().getEquippedBody().getArmor()+") ");
			if (Engine.engine.getPlayer().getEquippedBody().getResistFire()!=0)
			{
				text.append("(Resist fire: "+Engine.engine.getPlayer().getEquippedBody().getResistFire()+") ");
			}
			if (Engine.engine.getPlayer().getEquippedBody().getResistIce()!=0)
			{
				text.append("(Resist ice: "+Engine.engine.getPlayer().getEquippedBody().getResistIce()+") ");
			}
			if (Engine.engine.getPlayer().getEquippedBody().getResistLightning()!=0)
			{
				text.append("(Resist lightning: "+Engine.engine.getPlayer().getEquippedBody().getResistLightning()+") ");
			}
			if (Engine.engine.getPlayer().getEquippedBody().getResistPoison()!=0)
			{
				text.append("(Resist poison: "+Engine.engine.getPlayer().getEquippedBody().getResistPoison()+") ");
			}
			text.append("\n");
		}
		else
		{
			text.append("Equipped armor body: Nothing\n");
		}
		if (Engine.engine.getPlayer().getEquippedLeggins()!=null)
		{
			text.append("Equipped armor leggins:\n"+Engine.engine.getPlayer().getEquippedLeggins()+" (Armor points: "+Engine.engine.getPlayer().getEquippedLeggins().getArmor()+") ");
			if (Engine.engine.getPlayer().getEquippedLeggins().getResistFire()!=0)
			{
				text.append("(Resist fire: "+Engine.engine.getPlayer().getEquippedLeggins().getResistFire()+") ");
			}
			if (Engine.engine.getPlayer().getEquippedLeggins().getResistIce()!=0)
			{
				text.append("(Resist ice: "+Engine.engine.getPlayer().getEquippedLeggins().getResistIce()+") ");
			}
			if (Engine.engine.getPlayer().getEquippedLeggins().getResistLightning()!=0)
			{
				text.append("(Resist lightning: "+Engine.engine.getPlayer().getEquippedLeggins().getResistLightning()+") ");
			}
			if (Engine.engine.getPlayer().getEquippedLeggins().getResistPoison()!=0)
			{
				text.append("(Resist poison: "+Engine.engine.getPlayer().getEquippedLeggins().getResistPoison()+") ");
			}
			text.append("\n");
		}
		else
		{
			text.append("Equipped armor leggins: Nothing\n");
		}
		if (Engine.engine.getPlayer().getEquippedWeapon()!=null)
		{
			text.append("Equipped weapon:\n"+Engine.engine.getPlayer().getEquippedWeapon()+" (Damage points: "+Engine.engine.getPlayer().getEquippedWeapon().getAllDamage()+") ");
			if (Engine.engine.getPlayer().getEquippedWeapon().getDamageType()==EElement.FIRE)
			{
				text.append("(Damage fire: "+Engine.engine.getPlayer().getEquippedWeapon().getDamageFire()+") ");
			}
			else if (Engine.engine.getPlayer().getEquippedWeapon().getDamageType()==EElement.ICE)
			{
				text.append("(Damage ice: "+Engine.engine.getPlayer().getEquippedWeapon().getDamageIce()+") ");
			}
			else if (Engine.engine.getPlayer().getEquippedWeapon().getDamageType()==EElement.LIGHTNING)
			{
				text.append("(Damage lightning: "+Engine.engine.getPlayer().getEquippedWeapon().getDamageLightning()+") ");
			}
			else if (Engine.engine.getPlayer().getEquippedWeapon().getDamageType()==EElement.POISON)
			{
				text.append("(Damage poison: "+Engine.engine.getPlayer().getEquippedWeapon().getDamagePoison()+") ");
			}
			text.append("\n");
		}
		else
		{
			text.append("Equipped weapon: Nothing\n");
		}
	}

	public JButton getUseKey() {
		return useKey;
	}

	public JFrame getFrame() {
		return frame;
	}
}

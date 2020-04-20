package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import leveleditor.actors.ECreatureClass;
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
public class LevelupGUI 
{
	private JButton incStr;
	private JButton incHP;
	private JButton incMana;
	private JButton incChar;
	private JButton incAgi;
	private JFrame frame;
	private JTextArea text;
	private int leveluppoints;

	//TODO: When pressing exit then there needs to be some way of getting the menu again
	public void setup()
	{
		leveluppoints=3;
		frame = new JFrame("Tower of Zaldagor - Level up");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(200, 150);
		frame.setLocation(300, 200);

		JPanel textPanel = new JPanel();
		textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
		
		incStr = new JButton("+");
		incStr.setToolTipText("Press this button to increase your strength with 3. Costs 2 levelup points!");
		incHP = new JButton("+");
		incHP.setToolTipText("Press this button to increase your health with 10. Costs 1 levelup point!");
		incMana = new JButton("+");
		incMana.setToolTipText("Press this button to increase your mana with 10. Costs 1 levelup point!");
		incChar = new JButton("+");
		incChar.setToolTipText("Press this button to increase your charisma with 3. Costs 2 levelup points!");
		incAgi = new JButton("+");
		incAgi.setToolTipText("Press this button to increase your agility with 1. Costs 2 levelup points!");
		text= new JTextArea("You have "+leveluppoints+" points left\n");
		incStr.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				text.append("You've added 3 to your strength\n");
				leveluppoints=leveluppoints-2;
				Engine.engine.getPlayer().setStrength(Engine.engine.getPlayer().getStrength()+3);
				frame.pack();
				if (leveluppoints==0)
				{
					incHP.setEnabled(false);
					incStr.setEnabled(false);
					incMana.setEnabled(false);
					incChar.setEnabled(false);
					incAgi.setEnabled(false);
					Engine.engine.getPlayer().setHp(Engine.engine.getPlayer().getInitHp());
					Engine.engine.getPlayer().setMana(Engine.engine.getPlayer().getInitMana());
				}
				if (leveluppoints==1)
				{
					incStr.setEnabled(false);
					incChar.setEnabled(false);
					incAgi.setEnabled(false);
				}
			}
		});
		incHP.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				text.append("You've added 10 to your HP\n");
				leveluppoints--;
				Engine.engine.getPlayer().setInitHp(Engine.engine.getPlayer().getInitHp()+10);
				frame.pack();
				if (leveluppoints==0)
				{
					incHP.setEnabled(false);
					incStr.setEnabled(false);
					incMana.setEnabled(false);
					incChar.setEnabled(false);
					incAgi.setEnabled(false);
					Engine.engine.getPlayer().setHp(Engine.engine.getPlayer().getInitHp());
					Engine.engine.getPlayer().setMana(Engine.engine.getPlayer().getInitMana());
				}
				if (leveluppoints==1)
				{
					incStr.setEnabled(false);
					incChar.setEnabled(false);
					incAgi.setEnabled(false);
				}
			}
		});
		incMana.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				text.append("You've added 10 to your mana\n");
				leveluppoints--;
				Engine.engine.getPlayer().setInitMana(Engine.engine.getPlayer().getInitMana()+10);
				frame.pack();
				if (leveluppoints==0)
				{
					incHP.setEnabled(false);
					incStr.setEnabled(false);
					incMana.setEnabled(false);
					incChar.setEnabled(false);
					incAgi.setEnabled(false);
					Engine.engine.getPlayer().setHp(Engine.engine.getPlayer().getInitHp());
					Engine.engine.getPlayer().setMana(Engine.engine.getPlayer().getInitMana());
				}
				if (leveluppoints==1)
				{
					incStr.setEnabled(false);
					incChar.setEnabled(false);
					incAgi.setEnabled(false);
				}
			}
		});
		incChar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				text.append("You've added 3 to your charisma\n");
				leveluppoints=leveluppoints-2;
				Engine.engine.getPlayer().setCharisma(Engine.engine.getPlayer().getCharisma()+3);
				frame.pack();
				if (leveluppoints==0)
				{
					incHP.setEnabled(false);
					incStr.setEnabled(false);
					incMana.setEnabled(false);
					incChar.setEnabled(false);
					incAgi.setEnabled(false);
					Engine.engine.getPlayer().setHp(Engine.engine.getPlayer().getInitHp());
					Engine.engine.getPlayer().setMana(Engine.engine.getPlayer().getInitMana());
				}
				if (leveluppoints==1)
				{
					incStr.setEnabled(false);
					incChar.setEnabled(false);
					incAgi.setEnabled(false);
				}
			}
		});
		incAgi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				text.append("You've added 1 to your agility\n");
				leveluppoints=leveluppoints-2;
				Engine.engine.getPlayer().setAgility(Engine.engine.getPlayer().getAgility()+1);
				frame.pack();
				if (leveluppoints==0)
				{
					incHP.setEnabled(false);
					incStr.setEnabled(false);
					incMana.setEnabled(false);
					incChar.setEnabled(false);
					incAgi.setEnabled(false);
					Engine.engine.getPlayer().setHp(Engine.engine.getPlayer().getInitHp());
					Engine.engine.getPlayer().setMana(Engine.engine.getPlayer().getInitMana());
				}
				if (leveluppoints==1)
				{
					incStr.setEnabled(false);
					incChar.setEnabled(false);
					incAgi.setEnabled(false);
				}
			}
		});
		JTextArea strText = new JTextArea();
		strText.setEditable(false);
		strText.append("Strength");
		
		JTextArea hpText = new JTextArea();
		hpText.setEditable(false);
		hpText.append("Health");
		
		JTextArea manaText = new JTextArea();
		manaText.setEditable(false);
		manaText.append("Mana");
		
		JTextArea charText = new JTextArea();
		charText.setEditable(false);
		charText.append("Charisma");
		
		JTextArea agiText = new JTextArea();
		agiText.setEditable(false);
		agiText.append("Agility");
		
		buttonPanel.add(strText );
		buttonPanel.add(incStr);
		buttonPanel.add(hpText);
		buttonPanel.add(incHP);
		if (Engine.engine.getPlayer().getCreatureClass()==ECreatureClass.Wizard)
		{
			buttonPanel.add(manaText);
			buttonPanel.add(incMana);
		}
		buttonPanel.add(charText);
		buttonPanel.add(incChar);
		buttonPanel.add(agiText);
		buttonPanel.add(incAgi);
		textPanel.add(text);
		frame.getContentPane().add(buttonPanel, BorderLayout.NORTH);
		frame.getContentPane().add(textPanel, BorderLayout.SOUTH);
		frame.setResizable(false);
		textPanel.revalidate();
		frame.setVisible(true);
		frame.pack();
	}
}

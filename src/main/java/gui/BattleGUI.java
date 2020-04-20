package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

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
public class BattleGUI 
{
	private JTextArea text;
	private JButton attack;
	private JButton switchturn;
	private JFrame frame;
	private JButton flee;
	private JButton inventory;
	private JButton mainmenu;

	public void setup()
	{
		frame = new JFrame("Tower of Zaldagor - Battle");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(450, 350);
		frame.setLocation(200, 200);

		JPanel navigatePanel = new JPanel();
		navigatePanel.setLayout(new FlowLayout(FlowLayout.LEFT));

		text = new JTextArea(10, 30);
		text.setEditable(false);
		JScrollPane scrollpane = new JScrollPane(text, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		attack = new JButton("Attack");
		attack.setToolTipText("Press this button to attack enemy");
		switchturn = new JButton("Switch turn");
		switchturn.setToolTipText("Press this button to switch turn to the enemy");
		flee = new JButton("Flee from enemy");
		flee.setToolTipText("Press this button to escape the combat");
		inventory = new JButton("Inventory");
		inventory.setToolTipText("Press this button to open your inventory");
		mainmenu = new JButton("Main menu");
		mainmenu.setToolTipText("Press this button to go to the Main menu");

		navigatePanel.add(attack);
		navigatePanel.add(switchturn);
		navigatePanel.add(flee);
		navigatePanel.add(inventory);
		navigatePanel.add(mainmenu);
		navigatePanel.add(scrollpane);

		frame.getContentPane().add(navigatePanel);
		frame.setResizable(false);
		navigatePanel.revalidate();

		attack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Engine.engine.getBattle().attackEnemy();
			}
		});
		switchturn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Engine.engine.getBattle().switchTurn();
			}
		});
		flee.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Engine.engine.getBattle().fleeFromCombat();
			}
		});
		inventory.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Engine.engine.seeInventory();
			}
		});
		mainmenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {				
				MainGUI main = new MainGUI();
				main.setup();
				frame.setVisible(false);
			}
		});
		frame.setVisible(true);
		mainmenu.setVisible(false);
	}

	public void write(String writetext)
	{
		String resttext=writetext;

		while (resttext.length()>55)
		{
			text.append(resttext.substring(0, 55)+"\n");
			resttext=resttext.substring(55, resttext.length());
		}
		text.append(resttext);
	}

	public JButton getAttack() {
		return attack;
	}

	public JButton getSwitchTurn() {
		return switchturn;
	}

	public JFrame getFrame() {
		return frame;
	}

	public JButton getMainmenu() {
		return mainmenu;
	}

	public void defeat() 
	{
		attack.setVisible(false);
		flee.setVisible(false);
		inventory.setVisible(false);
		switchturn.setVisible(false);
		mainmenu.setVisible(true);
	}
}

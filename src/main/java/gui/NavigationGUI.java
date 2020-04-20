package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

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
public class NavigationGUI 
{		
	private JTextArea text;
	private JButton north;
	private JButton south;
	private JButton east;
	private JButton west;
	private JButton talk;
	private JFrame frame;
	private JButton attack;
	private JButton takeitem;
	private JButton inventory;
	private JButton searchroom;
	private JButton stats;
	private JButton nextact;
	private JButton mainmenu;
	private JButton quests;

	public void setup()
	{
		frame = new JFrame("Tower of Zaldagor - "+Engine.engine.getPlayer().getAct().getActName());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(470, 370);
		frame.setLocation(200, 200);

		JPanel northButtonPanel = new JPanel();
		northButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

		JPanel navigatePanel = new JPanel();
		navigatePanel.setLayout(new FlowLayout(FlowLayout.CENTER));

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

		text = new JTextArea(10, 30);
		text.setEditable(false);
		JScrollPane scrollpane = new JScrollPane(text, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		north = new JButton("North");
		north.setToolTipText("Press this button to go north");
		south = new JButton("South");
		south.setToolTipText("Press this button to go south");
		east = new JButton("East");
		east.setToolTipText("Press this button to go east");
		west = new JButton("West");
		west.setToolTipText("Press this button to go west");
		attack = new JButton("Attack");
		attack.setToolTipText("Press this button to attack the enemy");
		takeitem = new JButton("Take item");
		takeitem.setToolTipText("Press this button to take the marked item");
		inventory = new JButton("Look into inventory");
		inventory.setToolTipText("Press this button to look into inventory");
		searchroom = new JButton("Search room");
		searchroom.setToolTipText("Press this button to search the room for hidden doors");
		talk = new JButton("Talk");
		talk.setToolTipText("Press this button to talk with the NPC");
		stats = new JButton("Character");
		stats.setToolTipText("Press this button to see the stats of your character");
		nextact = new JButton("Go to next act");
		nextact.setToolTipText("Press this button to go to next act");
		mainmenu = new JButton("Main menu");
		mainmenu.setToolTipText("Press this button to go to open the Main Menu");
		quests = new JButton("Quest log");
		quests.setToolTipText("Press this button to see your quests");

		northButtonPanel.add(north);
		northButtonPanel.add(south);
		northButtonPanel.add(east);
		northButtonPanel.add(west);
		northButtonPanel.add(attack);
		northButtonPanel.add(mainmenu);

		navigatePanel.add(scrollpane);

		buttonPanel.add(takeitem);
		buttonPanel.add(inventory);
		buttonPanel.add(searchroom);
		buttonPanel.add(talk);
		buttonPanel.add(stats);
		buttonPanel.add(nextact);
		buttonPanel.add(quests);

		takeitem.setEnabled(false);
		talk.setEnabled(false);
		nextact.setEnabled(false);
		nextact.setVisible(false);
		frame.getContentPane().setLayout(new BorderLayout());
		frame.getContentPane().add(northButtonPanel, BorderLayout.NORTH);
		frame.getContentPane().add(navigatePanel, BorderLayout.CENTER);
		frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
		frame.pack();
		frame.setResizable(false);
		navigatePanel.revalidate();

		north.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Engine.engine.goNorth();
			}
		});
		south.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Engine.engine.goSouth();
			}
		});
		east.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Engine.engine.goEast();
			}
		});
		west.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Engine.engine.goWest();
			}
		});
		attack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Engine.engine.attack();
			}
		});
		takeitem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Engine.engine.takeItem();
			}
		});
		inventory.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Engine.engine.seeInventory();
			}
		});
		searchroom.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Engine.engine.revealHiddenDoor();
			}
		});
		talk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Engine.engine.talk();			}
		});
		stats.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Engine.engine.seeStats();
			}
		});
		nextact.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Engine.engine.getNavigateWindow().getFrame().setVisible(false);
				Act gotoAct = Engine.engine.getPlayer().getAct().getGotoAct();
				gotoAct.createWorld();
				Engine.engine.getPlayer().setAct(gotoAct);
				Engine.engine.start();
			}
		});
		mainmenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainGUI mainGUI = new MainGUI();
				mainGUI.setup();
			}
		});
		quests.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				QuestGUI questGUI = new QuestGUI();
				questGUI.setup();
			}
		});
		frame.setVisible(true);
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

	public JButton getNorth() {
		return north;
	}

	public JButton getSouth() {
		return south;
	}

	public JButton getEast() {
		return east;
	}

	public JButton getWest() {
		return west;
	}

	/**************************** my method (used in EventRoom, commandMap.put(ERoomEventAction.HIDDENROOM_FOUND...) ****************************/
	public ArrayList<JButton> getAllDirectionsBtn(){
		return new ArrayList<JButton>(Arrays.asList(getNorth(), getSouth(), getEast(), getWest()));
	}

	public JFrame getFrame() {
		return frame;
	}

	public JButton getAttack() {
		return attack;
	}

	public JButton getItem() {
		return takeitem;
	}

	public JButton getTalk() {
		return talk;
	}

	public void setItemName(String itemname)
	{
		takeitem.setText("Take "+itemname);
	}
	public JButton getInventory() {
		return inventory;
	}
	public JButton getSearchroom() {
		return searchroom;
	}

	public JButton getNextact() {
		return nextact;
	}
}

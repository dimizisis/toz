package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import leveleditor.actors.EElement;
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
public class MagicGUI 
{
	private JButton firebolt;
	private JButton icearrow;
	private JButton minorheal;
	private JButton heal;
	private JButton inferno;
	private JFrame frame;

	public void setup()
	{
		frame = new JFrame("Tower of Zaldagor - Magic menu");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(450, 350);
		frame.setLocation(200, 200);

		JPanel navigatePanel = new JPanel();
		navigatePanel.setLayout(new FlowLayout(FlowLayout.LEFT));

		firebolt = new JButton("Firebolt");
		firebolt.setToolTipText("Press this button to cast Firebolt");
		icearrow = new JButton("Ice Arrow");
		icearrow.setToolTipText("Press this button to cast Ice Arrow");
		minorheal = new JButton("Minor heal");
		minorheal.setToolTipText("Press this button to cast Minor heal");
		heal = new JButton("Heal");
		heal.setToolTipText("Press this button to cast Heal");
		inferno = new JButton("Inferno");
		inferno.setToolTipText("Press this button to cast Inferno");

		navigatePanel.add(firebolt);
		navigatePanel.add(icearrow);
		if (Engine.engine.getPlayer().getLevel()>=2)
		{
			navigatePanel.add(minorheal);
		}
		if (Engine.engine.getPlayer().getLevel()>=3)
		{
			navigatePanel.add(heal);
		}
		if (Engine.engine.getPlayer().getLevel()>=5)
		{
			navigatePanel.add(inferno);
		}
		frame.getContentPane().add(navigatePanel);
		frame.setResizable(false);
		navigatePanel.revalidate();

		firebolt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Engine.engine.getBattle().write("You try to cast Firebolt...\n");
				Engine.engine.getBattle().castSpell(25, EElement.FIRE, 10);
			}
		});
		icearrow.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Engine.engine.getBattle().write("You try to cast Ice Arrow...\n");
				Engine.engine.getBattle().castSpell(30, EElement.ICE, 15);
			}
		});
		minorheal.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Engine.engine.getBattle().write("You try to cast Minor heal...\n");
				Engine.engine.getBattle().castSpell(20, EElement.HEAL, 10);
			}
		});
		heal.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Engine.engine.getBattle().write("You try to cast Heal...\n");
				Engine.engine.getBattle().castSpell(50, EElement.HEAL, 20);
			}
		});
		inferno.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Engine.engine.getBattle().write("You try to cast Inferno...\n");
				Engine.engine.getBattle().castSpell(30, EElement.FIRE, 12);
			}
		});
		frame.setVisible(true);
		frame.pack();
	}

	public JFrame getFrame() {
		return frame;
	}
}

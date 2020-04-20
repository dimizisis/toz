package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import leveleditor.actors.ECreatureClass;
import leveleditor.actors.ECreatureRace;
import acts.*;
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
public class CustomizeGUI 
{		
	private JTextField name;
	private JRadioButton male;
	private JRadioButton female;
	private JRadioButton raceElf;
	private JRadioButton raceHuman;
	private JRadioButton classWarrior;
	private JRadioButton classWizard;
	private JButton startGame;
	private JFrame frame;
	private ButtonGroup radioMale = new ButtonGroup();
	private ButtonGroup radioRace = new ButtonGroup();
	private ButtonGroup radioClass = new ButtonGroup();
	private JPanel panelBase;
	private JPanel panelMale;
	private JPanel panelRace;
	private JPanel panelClass;

	public void setup()
	{
		frame = new JFrame("Tower of Zaldagor - Customize character");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(470, 370);
		frame.setLocation(200, 200);

		panelBase = new JPanel();
		panelBase.setLayout(new BoxLayout(panelBase, BoxLayout.Y_AXIS));

		panelMale = new JPanel();
		panelMale.setLayout(new GridLayout(2, 1));
		panelMale.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Gender"));
		
		panelRace= new JPanel();
		panelRace.setLayout(new GridLayout(2, 1));
		panelRace.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Race"));
		
		panelClass = new JPanel();
		panelClass.setLayout(new GridLayout(2, 1));
		panelClass.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Class"));
		
		name = new JTextField("Name...");
		name.setSize(30, 10);
		name.setEditable(true);
		name.selectAll();

		male = new JRadioButton("Male");
		male.setSelected(true);
		male.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Engine.engine.getPlayer().setMale(true);
			}
		});

		female = new JRadioButton("Female");
		female.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Engine.engine.getPlayer().setMale(false);
			}
		});

		raceHuman = new JRadioButton("Human");
		raceHuman.setSelected(true);
		raceHuman.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Engine.engine.getPlayer().setRace(ECreatureRace.Human);
			}
		});

		raceElf = new JRadioButton("Elf");
		raceElf.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Engine.engine.getPlayer().setRace(ECreatureRace.Elf);
			}
		});

		classWarrior = new JRadioButton("Warrior");
		classWarrior.setSelected(true);
		classWarrior.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Engine.engine.getPlayer().setCreatureClass(ECreatureClass.Warrior);
			}
		});

		classWizard = new JRadioButton("Wizard");
		classWizard.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Engine.engine.getPlayer().setCreatureClass(ECreatureClass.Wizard);
			}
		});

		startGame = new JButton("Start game");
		startGame.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Engine.engine.getPlayer().setLevel(1);
				Engine.engine.getPlayer().setName(name.getText());
				Engine.engine.getPlayer().setInitPlayerActions(1);
				Engine.engine.getPlayer().setExperience(0);

				if (male.isSelected())
				{
					Engine.engine.getPlayer().setMale(true);
				}
				else
				{
					Engine.engine.getPlayer().setMale(false);
				}
				if (raceElf.isSelected())
				{
					Engine.engine.getPlayer().setRace(ECreatureRace.Elf);
				}
				else if (raceHuman.isSelected())
				{
					Engine.engine.getPlayer().setRace(ECreatureRace.Human);
				}
				if (classWarrior.isSelected())
				{
					Engine.engine.getPlayer().setCreatureClass(ECreatureClass.Warrior);
					//TODO: Changed HP from 100
					Engine.engine.getPlayer().setInitHp(100);
					Engine.engine.getPlayer().setInitMana(0);
					Engine.engine.getPlayer().setCharisma(10);
					Engine.engine.getPlayer().setStrength(13);
					//TODO: Changed agility from 14
					Engine.engine.getPlayer().setAgility(14);
				}
				else if (classWizard.isSelected())
				{
					Engine.engine.getPlayer().setCreatureClass(ECreatureClass.Wizard);
					//TODO: Changed HP from 80
					Engine.engine.getPlayer().setInitHp(80);
					Engine.engine.getPlayer().setInitMana(50);
					Engine.engine.getPlayer().setCharisma(15);
					Engine.engine.getPlayer().setStrength(8);
					Engine.engine.getPlayer().setAgility(13);
				}
				//TODO Find out which is the first act. One might be able to pick from a list
				LowerQuarters act1 = new LowerQuarters();
				act1.createWorld();
				Engine.engine.start();
				frame.setVisible(false);
			}
		});
		
		panelBase.add(name);

		radioMale.add(male);
		radioMale.add(female);

		radioRace.add(raceHuman);
		radioRace.add(raceElf);

		radioClass.add(classWarrior);
		radioClass.add(classWizard);

		panelMale.add(male);
		panelMale.add(female);

		panelRace.add(raceHuman);
		panelRace.add(raceElf);

		panelClass.add(classWarrior);
		panelClass.add(classWizard);
		
		panelBase.add(panelMale);
		panelBase.add(panelRace);
		panelBase.add(panelClass);
		
		panelBase.add(startGame);
		
		frame.getContentPane().setLayout(new BorderLayout());
		frame.getContentPane().add(panelBase, BorderLayout.CENTER);
		frame.pack();
		frame.setResizable(false);
		panelBase.revalidate();

		Engine.engine.getPlayer().setMale(true);
		Engine.engine.getPlayer().setRace(ECreatureRace.Human);
		Engine.engine.getPlayer().setCreatureClass(ECreatureClass.Warrior);

		frame.setVisible(true);
	}
}

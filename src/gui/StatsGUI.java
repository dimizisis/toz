package gui;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import leveleditor.actors.ECreatureClass;
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
public class StatsGUI 
{
	private JTextArea text;
	private JFrame frame;

	public void setup()
	{
		frame = new JFrame("Tower of Zaldagor - Character");
		frame.setSize(450, 350);
		frame.setLocation(200, 200);

		JPanel navigatePanel = new JPanel();
		navigatePanel.setLayout(new FlowLayout(FlowLayout.LEFT));

		text = new JTextArea(18, 35);
		text.setEditable(false);
		JScrollPane scrollpane = new JScrollPane(text, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		navigatePanel.add(scrollpane);

		frame.getContentPane().add(navigatePanel);
		frame.setResizable(false);
		navigatePanel.revalidate();

		frame.setVisible(true);
		writeStats();
	}

	
	private void writeStats() 
	{
		write(Engine.engine.getPlayer().getName()+"\n");
		if (Engine.engine.getPlayer().isMale())
		{
			write("Sex: Male\n");
		}
		else
		{
			write("Sex: Female\n");
		}
		write("Race: "+Engine.engine.getPlayer().getRace()+"\n");
		write("Class: "+Engine.engine.getPlayer().getCreatureClass()+"\n");
		write("Health: "+Engine.engine.getPlayer().getHp()+"\n");
		if (Engine.engine.getPlayer().getCreatureClass()==ECreatureClass.Wizard)
		{
			write("Mana: "+Engine.engine.getPlayer().getMana()+"\n");
		}
		write("Level: "+Engine.engine.getPlayer().getLevel()+"\n");
		write("Experience: "+Engine.engine.getPlayer().getExperience()+"\n");
		write("Armor points: "+Engine.engine.getPlayer().getArmorPts()+"\n");
		write("Strength: "+Engine.engine.getPlayer().getStrength()+"\n");
		write("Agility: "+Engine.engine.getPlayer().getAgility()+"\n");
		write("Charisma: "+Engine.engine.getPlayer().getCharisma()+"\n");
		write("Gold: "+Engine.engine.getPlayer().getGold()+"\n");
		write("Fire resist: "+Engine.engine.getPlayer().getResistance(EElement.FIRE)+"\n");
		write("Ice resist: "+Engine.engine.getPlayer().getResistance(EElement.ICE)+"\n");
		write("Lightning resist: "+Engine.engine.getPlayer().getResistance(EElement.LIGHTNING)+"\n");
		write("Poison resist: "+Engine.engine.getPlayer().getResistance(EElement.POISON)+"\n");
	}


	public void write(String writetext)
	{
		text.append(writetext);
	}

	public JFrame getFrame() {
		return frame;
	}
}

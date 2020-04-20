package gui;

import java.awt.FlowLayout;

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
public class QuestGUI 
{
	private JTextArea text;
	private JFrame frame;

	public void setup()
	{
		frame = new JFrame("Tower of Zaldagor - Quest");
		frame.setSize(450, 350);
		frame.setLocation(200, 200);

		JPanel navigatePanel = new JPanel();
		navigatePanel.setLayout(new FlowLayout(FlowLayout.LEFT));

		text = new JTextArea(18, 35);
		text.setEditable(false);
		JScrollPane scrollpane = new JScrollPane(text, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		navigatePanel.add(scrollpane);

		frame.getContentPane().add(navigatePanel);
		frame.setResizable(false);
		navigatePanel.revalidate();

		frame.setVisible(true);
		seeQuests();
	}

	private void seeQuests()
	{
		for (int i = 0; i < Engine.engine.getPlayer().getQuests().size(); i++) 
		{
			if (Engine.engine.getPlayer().getQuests().get(i) != null && !Engine.engine.getPlayer().getQuests().get(i).isComplete())
			{
				write(Engine.engine.getPlayer().getQuests().get(i).getIntroduction()+":\n");
				write(Engine.engine.getPlayer().getQuests().get(i).getDescription()+"\n\n");
			}
		}
	}
	private void write(String writetext)
	{
		String resttext=writetext;

		while (resttext.length()>55)
		{
			text.append(resttext.substring(0, 55)+"\n");
			resttext=resttext.substring(55, resttext.length());
		}
		text.append(resttext);
	}

	public JFrame getFrame() {
		return frame;
	}
}

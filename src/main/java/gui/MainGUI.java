package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import main.Main;
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
public class MainGUI 
{
	private JButton newgame;
	private JButton loadgame;
	private JButton savegame;
	private JFrame frame;

	public void setup()
	{
		frame = new JFrame("Tower of Zaldagor - Main menu");
		frame.setSize(320, 70);
		frame.setLocation(200, 200);

		JPanel navigatePanel = new JPanel();
		navigatePanel.setLayout(new FlowLayout(FlowLayout.LEFT));

		newgame = new JButton("New game");
		loadgame = new JButton("Load game");
		savegame = new JButton("Save game");

		navigatePanel.add(newgame);
		navigatePanel.add(loadgame);
		navigatePanel.add(savegame);		

		if (Engine.engine.getPlayer()==null || (Engine.engine.getPlayer().getHp()<=0))
		{
			savegame.setEnabled(false);
		}

		frame.getContentPane().add(navigatePanel);
		frame.setResizable(false);
		navigatePanel.revalidate();

		newgame.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Main.newgame();
				frame.setVisible(false);
			}
		});
		loadgame.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {				
				if (Engine.engine.loadgame())
					frame.setVisible(false);
			}
		});
		savegame.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Engine.engine.savegame();
			}
		});
		frame.setVisible(true);
	}

	public JButton getNewgame() {
		return newgame;
	}

	public JButton getLoadgame() {
		return loadgame;
	}

	public JFrame getFrame() {
		return frame;
	}

}

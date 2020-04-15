package gui;

import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;

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
public class MapGUI {
	private JFrame frame;

	public void setup()
	{
		frame = new JFrame("Tower of Zaldagor - Map");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setLocation(200, 200);

		frame.getContentPane().add(new MyCanvas());
		frame.setResizable(false);
		frame.setVisible(true);
	}
}

class MyCanvas extends JComponent
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2526234109945291333L;

	public void paint(Graphics g)
	{
		if (Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getNorth()!=null)
		{
			//North
			g.drawRect(120, 3, 50, 50);
			//Line from center to north
			g.drawLine(150, 100, 150, 53);
		}
		if (Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getWest()!=null)
		{
			//West
			g.drawRect(3, 100, 50, 50);
			//Line from center to west
			g.drawLine(53, 120, 119, 120);
		}
		if (Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getEast()!=null)
		{
			//East
			g.drawRect(220, 100, 50, 50);
			//Line from center to east
			g.drawLine(170, 120, 220, 120);
		}
		if (Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getSouth()!=null)
		{
			//South
			g.drawRect(120, 200, 50, 50);
			//Line from center to south
			g.drawLine(150, 200, 150, 150);
		}
		//CurrentRoom
		g.drawRect(120, 100, 50, 50);
		//String CurrentRoom
		g.drawString("You", 135, 130);
	}
}

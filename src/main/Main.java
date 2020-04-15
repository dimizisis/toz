package main;

import engine.Engine;
import gui.CustomizeGUI;
import gui.MainGUI;
import leveleditor.actors.Player;
import multiplayer.chat.ChatClient;
import multiplayer.chat.ChatServer;
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
public class Main {
	
	public static void main(String[] args) 
	{
//		ChatServer server = new ChatServer();
//		Engine.engine.setPlayer(new Player());
//		ChatClient client = new ChatClient();
		MainGUI mainGUI = new MainGUI();
		mainGUI.setup();
	}

	public static void newgame()
	{
		Engine.engine.setPlayer(new Player());
		CustomizeGUI start = new CustomizeGUI();
		start.setup();
	}
}

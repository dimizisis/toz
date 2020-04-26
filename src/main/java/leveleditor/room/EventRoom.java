package leveleditor.room;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import leveleditor.actors.Quest;

import engine.Engine;
import leveleditor.room.commands.CommandExecutor;
import leveleditor.room.commands.action.AttackEnemyCommand;

import javax.swing.*;

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
public class EventRoom extends Room 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -493681774995476044L;
	private ArrayList<RoomEvent> events;
	private Quest quest;

	public EventRoom()
	{
		super();
		events = new ArrayList<RoomEvent>();
	}

	public void evaluateCondition()
	{
		for (int i = 0; i < events.size(); i++)
			new CommandExecutor(events, i, false).executeCommand(events.get(i).getCondition()); /**************************** Instead of if else ****************************/
	}

	public ArrayList<RoomEvent> getEvents() {
		return events;
	}

	public void setEvents(ArrayList<RoomEvent> events) {
		this.events = events;
	}

	public Quest getQuest() {
		return quest;
	}

	public void setQuest(Quest quest) {
		this.quest = quest;
	}
}

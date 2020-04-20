package leveleditor.room;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import leveleditor.actors.Quest;

import engine.Engine;

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

	private Map<Enum<?>, EventHandler> commandMap = new HashMap<Enum<?>, EventHandler>(); /**************************** contains ACTION/CONDITION, COMMAND ****************************/

	public EventRoom()
	{
		super();
		events = new ArrayList<RoomEvent>();
		fillCommandMap();	/**************************** command init ****************************/
	}

	public void evaluateCondition()
	{
		for (int i = 0; i < events.size(); i++)
				commandMap.get(events.get(i).getCondition()).handle(i);	/**************************** Instead of if else ****************************/
	}

	private void evaluateAction(int index) 
	{
		commandMap.get(events.get(index).getAction()).handle(index);	/**************************** Instead of if else ****************************/
		events.remove(index);
		if (events.size()>0)
		{
			evaluateCondition();
		}
	}

	private void fillCommandMap(){
		fillConditionEvents();	/**************************** Fill conditions ****************************/
		fillActionEvents();	/**************************** Fill actions ****************************/
	}

	private void fillActionEvents(){
		/**************************** Filling ****************************/
		commandMap.put(ERoomEventAction.ENEMY_ATTACK, new EventHandler(){
			public void handle(int index) {
				try {
					for (int i = 0; i < Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getEnemies().size(); i++) {
						if (Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getEnemies().get(i) == events.get(index).getEnemyattack()) {
							Engine.engine.attackedBy(Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getEnemies().get(i));
						}
					}
				}catch (Exception e){
					System.out.println(e);
				}
			}
		});

		commandMap.put(ERoomEventAction.ROOM_DESCRIPTION, new EventHandler(){
			public void handle(int index) {
				try{
					Engine.engine.getPlayer().getWorld().get(events.get(index).getRoom()).setDescription(events.get(index).getRoomdescription());
				}catch (Exception e)
				{
					Engine.engine.getNavigateWindow().write(events.get(index).getRoomdescription()+"\n");
				}
			}
		});

		commandMap.put(ERoomEventAction.HIDDENROOM_FOUND, new EventHandler(){
			public void handle(int index) {
				/**************************** Replaced long code (if else conditions) with for loop ****************************/
				if (events.get(index).getAction()==ERoomEventAction.HIDDENROOM_FOUND)
				{
					ArrayList<String> directions = Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getAllDirections();
					ArrayList<JButton> directionsBtn = Engine.engine.getNavigateWindow().getAllDirectionsBtn();
					for(int i=0; i<directions.size(); ++i){
						if (directions.get(i) != null)
						{
							if (Engine.engine.getPlayer().getWorld().get(directions.get(i)).isHiddenEvent)
							{
								if (directions.get(i)==events.get(index).getHiddenroomfound())
								{
									Engine.engine.getPlayer().getWorld().get(directions.get(i)).setHiddenEvent(false);
									Engine.engine.getPlayer().getWorld().get(directions.get(i)).setHidden(false);
									Engine.engine.getNavigateWindow().write(Engine.engine.getPlayer().getWorld().get(directions.get(i)).getHiddenDescription()+"\n");
									directionsBtn.get(i).setEnabled(true);
								}
							}
						}
					}
					Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).setRevealed(true);
				}
			}
		});

		commandMap.put(ERoomEventAction.ROOM_PLACEENEMY, new EventHandler(){
			public void handle(int index) {
				Engine.engine.getNavigateWindow().write(events.get(index).getRoomdescription()+"\n");
				Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getEnemies().add(events.get(index).getPlaceenemy());
				Engine.engine.getNavigateWindow().getAttack().setEnabled(true);
			}
		});

		commandMap.put(ERoomEventAction.TRIGGER_TRAP, new EventHandler(){
			public void handle(int index) {
				events.get(index).getTrap().trigger();
				events.get(index).getTrap().setTrapdescription(events.get(index).getTrapdescription());
			}
		});

		commandMap.put(ERoomEventAction.ADD_ITEM, new EventHandler(){
			public void handle(int index) {
				Engine.engine.getNavigateWindow().write("You've added "+events.get(index).getReceivedItem()+" to your inventory\n");
				Engine.engine.getPlayer().getInventory().add(events.get(index).getReceivedItem());
			}
		});

		commandMap.put(ERoomEventAction.REMOVE_ENEMY, new EventHandler(){
			public void handle(int index) {
				for (int i = 0; i < Engine.engine.getPlayer().getWorld().get(events.get(index).getRoom()).getEnemies().size(); i++)
				{
					if (Engine.engine.getPlayer().getWorld().get(events.get(index).getRoom()).getEnemies().get(i).getName()==events.get(index).getEnemyattack().getName())
					{
						Engine.engine.getPlayer().getWorld().get(events.get(index).getRoom()).getEnemies().remove(i);
					}
				}
			}
		});

		commandMap.put(ERoomEventAction.REMOVE_NPC, new EventHandler(){
			public void handle(int index) {
				for (int i = 0; i < Engine.engine.getPlayer().getWorld().get(events.get(index).getRoom()).getNpcs().size(); i++)
				{
					if (Engine.engine.getPlayer().getWorld().get(events.get(index).getRoom()).getNpcs().get(i).getName()==events.get(index).getNpc())
					{
						Engine.engine.getPlayer().getWorld().get(events.get(index).getRoom()).getNpcs().remove(i);
					}
				}
			}
		});

		commandMap.put(ERoomEventAction.SET_HP_ENEMY, new EventHandler(){
			public void handle(int index) {
				for (int i = 0; i < Engine.engine.getPlayer().getWorld().get(events.get(index).getRoom()).getEnemies().size(); i++)
				{
					if (Engine.engine.getPlayer().getWorld().get(events.get(index).getRoom()).getEnemies().get(i).getName()==events.get(index).getEnemyattack().getName())
					{
						if (events.get(index).getRoom()==Engine.engine.getPlayer().getCurrentroom())
						{
							Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getEnemies().get(i).setInitHp(events.get(index).getHP());
						}
						else
						{
							Engine.engine.getPlayer().getWorld().get(events.get(index).getRoom()).getEnemies().get(i).setInitHp(events.get(index).getHP());
						}
					}
				}
			}
		});
	}

	private void fillConditionEvents() {
		/**************************** Filling ****************************/
		commandMap.put(ERoomEventCondition.ENEMY_DIED, new EventHandler() {
			public void handle(int index) {
				if (events.get(index).isEnemyDead())
					evaluateAction(index);
			}
		});

		commandMap.put(ERoomEventCondition.ITEM_USED, new EventHandler() {
			public void handle(int index) {
				if (events.get(index).isItemused())
					evaluateAction(index);
			}
		});

		commandMap.put(ERoomEventCondition.HIDDENROOM_FOUND, new EventHandler() {
			public void handle(int index) {
				if (events.get(index).getHiddenroomfound() != null)
					evaluateAction(index);
			}
		});

		commandMap.put(ERoomEventCondition.ITEM_TAKEN, new EventHandler() {
			public void handle(int index) {
				if (events.get(index).isItemtaken())
					evaluateAction(index);
			}
		});

		/******* NOT USED BY CREATOR
		 commandMap.put(ERoomEventCondition.ITEM_GIVEN, new EventHandler(){
		 public void handle(int index) {

		 }
		 });	********/

		commandMap.put(ERoomEventCondition.ROOM_ENTERED_TWICE, new EventHandler() {
			public void handle(int index) {
				events.get(index).setRoomenteredtimes(events.get(index).getRoomenteredtimes() + 1);
				if (events.get(index).getRoomenteredtimes() == 2)
					evaluateAction(index);
			}
		});

		commandMap.put(ERoomEventCondition.ROOM_ENTERED, new EventHandler() {
			public void handle(int index) {
				evaluateAction(index);
			}
		});
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

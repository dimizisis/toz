package leveleditor.room;

import java.util.ArrayList;

import leveleditor.actors.Quest;

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
		{
			if (events.get(i).getCondition()==ERoomEventCondition.ENEMY_DIED)
			{
				if (events.get(i).isEnemyDead())
				{
					evaluateAction(i);
				}
			}
			else if (events.get(i).getCondition()==ERoomEventCondition.HIDDENROOM_FOUND)
			{
				if (events.get(i).getHiddenroomfound()!=null)
				{
					evaluateAction(i);
				}
			}
			else if (events.get(i).getCondition()==ERoomEventCondition.ITEM_TAKEN)
			{
				if (events.get(i).isItemtaken())
				{
					evaluateAction(i);
				}
			}
			else if (events.get(i).getCondition()==ERoomEventCondition.ITEM_USED)
			{
				if (events.get(i).isItemused())
				{
					evaluateAction(i);
				}
			}
			else if (events.get(i).getCondition()==ERoomEventCondition.ROOM_ENTERED_TWICE)
			{
				events.get(i).setRoomenteredtimes(events.get(i).getRoomenteredtimes()+1);

				if(events.get(i).getRoomenteredtimes()==2)
				{
					evaluateAction(i);
				}
			}
			else if (events.get(i).getCondition()==ERoomEventCondition.ROOM_ENTERED)
			{
				evaluateAction(i);
			}
		}
	}

	private void evaluateAction(int index) 
	{
		if (events.get(index).getAction()==ERoomEventAction.ENEMY_ATTACK)
		{
			if (Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getEnemies()!=null)
			{
				for (int i = 0; i < Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getEnemies().size(); i++) 
				{
					if (Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getEnemies().get(i)==events.get(index).getEnemyattack())
					{
						Engine.engine.attackedBy(Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getEnemies().get(i));
					}
				}
			}
		}
		else if (events.get(index).getAction()==ERoomEventAction.HIDDENROOM_FOUND)
		{
			if (Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getNorth()) != null)
			{
				if (Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getNorth()).isHiddenEvent)
				{
					if (Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getNorth()==events.get(index).getHiddenroomfound())
					{
						Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getNorth()).setHiddenEvent(false);
						Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getNorth()).setHidden(false);
						Engine.engine.getNavigateWindow().write(Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getNorth()).getHiddenDescription()+"\n");
						Engine.engine.getNavigateWindow().getNorth().setEnabled(true);
					}
				}
			}
			if (Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getSouth()) != null)
			{
				if (Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getSouth()).isHiddenEvent)
				{
					if (Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getSouth()==events.get(index).getHiddenroomfound())
					{
						Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getSouth()).setHiddenEvent(false);
						Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getSouth()).setHidden(false);
						Engine.engine.getNavigateWindow().write(Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getSouth()).getHiddenDescription()+"\n");
						Engine.engine.getNavigateWindow().getSouth().setEnabled(true);
					}
				}
			}
			if (Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getWest()) != null)
			{
				if (Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getWest()).isHiddenEvent)
				{
					if (Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getWest()==events.get(index).getHiddenroomfound())
					{
						Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getWest()).setHiddenEvent(false);
						Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getWest()).setHidden(false);
						Engine.engine.getNavigateWindow().write(Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getWest()).getHiddenDescription()+"\n");
						Engine.engine.getNavigateWindow().getWest().setEnabled(true);
					}
				}
			}
			if (Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getEast()) != null)
			{
				if (Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getEast()).isHiddenEvent)
				{
					if (Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getEast()==events.get(index).getHiddenroomfound())
					{
						Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getEast()).setHiddenEvent(false);
						Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getEast()).setHidden(false);
						Engine.engine.getNavigateWindow().write(Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getEast()).getHiddenDescription()+"\n");
						Engine.engine.getNavigateWindow().getEast().setEnabled(true);					
					}
				}
			}
			Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).setRevealed(true);
		}
		else if (events.get(index).getAction()==ERoomEventAction.ROOM_DESCRIPTION)
		{
			if (events.get(index).getRoom()!=null)
			{
				Engine.engine.getPlayer().getWorld().get(events.get(index).getRoom()).setDescription(events.get(index).getRoomdescription());
			}
			else
			{
				Engine.engine.getNavigateWindow().write(events.get(index).getRoomdescription()+"\n");
			}
		}
		else if (events.get(index).getAction()==ERoomEventAction.ROOM_PLACEENEMY)
		{
			Engine.engine.getNavigateWindow().write(events.get(index).getRoomdescription()+"\n");
			Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getEnemies().add(events.get(index).getPlaceenemy());
			Engine.engine.getNavigateWindow().getAttack().setEnabled(true);
		}
		else if (events.get(index).getAction()==ERoomEventAction.TRIGGER_TRAP)
		{
			events.get(index).getTrap().trigger();
			events.get(index).getTrap().setTrapdescription(events.get(index).getTrapdescription());
		}
		else if (events.get(index).getAction()==ERoomEventAction.ADD_ITEM)
		{
			Engine.engine.getNavigateWindow().write("You've added "+events.get(index).getReceivedItem()+" to your inventory\n");
			Engine.engine.getPlayer().getInventory().add(events.get(index).getReceivedItem());
		}
		else if (events.get(index).getAction()==ERoomEventAction.REMOVE_ENEMY)
		{
			for (int i = 0; i < Engine.engine.getPlayer().getWorld().get(events.get(index).getRoom()).getEnemies().size(); i++) 
			{
				if (Engine.engine.getPlayer().getWorld().get(events.get(index).getRoom()).getEnemies().get(i).getName()==events.get(index).getEnemyattack().getName())
				{
					Engine.engine.getPlayer().getWorld().get(events.get(index).getRoom()).getEnemies().remove(i);
				}
			}
		}
		else if (events.get(index).getAction()==ERoomEventAction.REMOVE_NPC)
		{
			for (int i = 0; i < Engine.engine.getPlayer().getWorld().get(events.get(index).getRoom()).getNpcs().size(); i++) 
			{
				if (Engine.engine.getPlayer().getWorld().get(events.get(index).getRoom()).getNpcs().get(i).getName()==events.get(index).getNpc())
				{
					Engine.engine.getPlayer().getWorld().get(events.get(index).getRoom()).getNpcs().remove(i);
				}
			}
		}
		else if (events.get(index).getAction()==ERoomEventAction.SET_HP_ENEMY)
		{
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
		events.remove(index);
		if (events.size()>0)
		{
			evaluateCondition();
		}
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

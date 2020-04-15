package leveleditor.room;

import java.io.Serializable;

import leveleditor.actors.Enemy;
import leveleditor.items.Item;
import battle.Trap;
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
public class RoomEvent implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4946946105421102582L;
	private ERoomEventCondition condition;
	private ERoomEventAction action;
	private boolean isEnemyDead;
	private boolean isItemused;
	private String hiddenroomfound;
	private Item itemtaken;
	private boolean isItemtaken;
	private int roomenteredtimes=0;
	private Enemy enemyattack;
	private Enemy placeenemy;
	private String roomdescription;
	private Trap trap;
	private String trapdescription;
	private Item receivedItem;
	private Item itemUsed;
	private String room;
	private String npc;
	private int HP;
	
	public Item getReceivedItem() {
		return receivedItem;
	}
	public void setReceivedItem(Item receivedItem) {
		this.receivedItem = receivedItem;
	}
	public ERoomEventCondition getCondition() {
		return condition;
	}
	public void setCondition(ERoomEventCondition condition) {
		this.condition = condition;
	}
	public ERoomEventAction getAction() {
		return action;
	}
	public void setAction(ERoomEventAction action) {
		this.action = action;
	}
	public Item getItemtaken() {
		return itemtaken;
	}
	public void setItemtaken(Item itemtaken) {
		this.itemtaken = itemtaken;
	}
	public Enemy getEnemyattack() {
		return enemyattack;
	}
	public void setEnemyattack(Enemy enemyattack) {
		this.enemyattack = enemyattack;
	}
	public String getRoomdescription() {
		return roomdescription;
	}
	public void setRoomdescription(String roomdescription) {
		this.roomdescription = roomdescription;
	}
	public int getRoomenteredtimes() {
		return roomenteredtimes;
	}
	public void setRoomenteredtimes(int roomenteredtimes) {
		this.roomenteredtimes = roomenteredtimes;
	}
	public boolean isEnemyDead() {
		return isEnemyDead;
	}
	public void setEnemyDead(boolean isEnemyDead) {
		this.isEnemyDead = isEnemyDead;
	}
	public boolean isItemtaken() {
		return isItemtaken;
	}
	public void setItemtaken(boolean isItemtaken) {
		this.isItemtaken = isItemtaken;
	}
	public Trap getTrap() {
		return trap;
	}
	public void setTrap(Trap trap) {
		this.trap = trap;
	}
	public String getTrapdescription() {
		return trapdescription;
	}
	public void setTrapdescription(String trapdescription) {
		this.trapdescription = trapdescription;
	}
	public String getHiddenroomfound() {
		return hiddenroomfound;
	}
	public void setHiddenroomfound(String hiddenroomfound) {
		this.hiddenroomfound = hiddenroomfound;
	}
	public Item getItemUsed() {
		return itemUsed;
	}
	public void setItemUsed(Item itemUsed) {
		this.itemUsed = itemUsed;
	}
	public boolean isItemused() {
		return isItemused;
	}
	public void setItemused(boolean isItemused) {
		this.isItemused = isItemused;
	}
	public Enemy getPlaceenemy() {
		return placeenemy;
	}
	public void setPlaceenemy(Enemy placeenemy) {
		this.placeenemy = placeenemy;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public String getNpc() {
		return npc;
	}
	public void setNpc(String npc) {
		this.npc = npc;
	}
	public int getHP() {
		return HP;
	}
	public void setHP(int hP) {
		HP = hP;
	}
}

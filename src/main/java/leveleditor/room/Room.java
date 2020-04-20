package leveleditor.room;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

import leveleditor.actors.Enemy;
import leveleditor.actors.NPC;
import leveleditor.items.Item;
import leveleditor.items.Key;
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
public abstract class Room implements Serializable
{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7970144220766382860L;
	protected String name;
	protected String description;
	protected String postDescription;
	protected String postItemsDescription;
	protected String revealedDescription;
	protected String hiddenDescription;
	protected ArrayList<Enemy> enemies;
	protected ArrayList<NPC> npcs;
	protected ArrayList<Item> items;
	protected String north;
	protected String south;
	protected String east;
	protected String west;
	protected boolean isLocked=false;
	protected ArrayList<Key> unlockKeys;
	protected boolean isHidden=false;
	protected boolean isRevealed=false;
	protected boolean isHiddenEvent=false;
	
	public Room()
	{
		enemies = new ArrayList<Enemy>();
		npcs = new ArrayList<NPC>();
		unlockKeys = new ArrayList<Key>();
		items = new ArrayList<Item>();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ArrayList<Enemy> getEnemies() {
		return enemies;
	}
	public void setEnemies(ArrayList<Enemy> enemies) {
		this.enemies = enemies;
	}
	public ArrayList<Item> getItems() {
		return items;
	}
	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
	public boolean isLocked() {
		return isLocked;
	}
	public void setLocked(boolean isLocked) {
		this.isLocked = isLocked;
	}
	public ArrayList<Key> getUnlockKeys() {
		return unlockKeys;
	}
	public void setUnlockKeys(ArrayList<Key> unlockKeys) {
		this.unlockKeys = unlockKeys;
	}
	public boolean isHidden() {
		return isHidden;
	}
	public void setHidden(boolean isHidden) {
		this.isHidden = isHidden;
	}
	public String getHiddenDescription() {
		return hiddenDescription;
	}
	public void setHiddenDescription(String hiddenDescription) {
		this.hiddenDescription = hiddenDescription;
	}
	public String getPostDescription() {
		return postDescription;
	}
	public void setPostDescription(String postdescription) {
		this.postDescription = postdescription;
	}
	public String getRevealedDescription() {
		return revealedDescription;
	}
	public void setRevealedDescription(String revealedscription) {
		this.revealedDescription = revealedscription;
	}
	public boolean isRevealed() {
		return isRevealed;
	}
	public void setRevealed(boolean isRevealed) {
		this.isRevealed = isRevealed;
	}
	public String getPostItemsDescription() {
		return postItemsDescription;
	}
	public void setPostItemsDescription(String postItemsDescription) {
		this.postItemsDescription = postItemsDescription;
	}
	public boolean isHiddenEvent() {
		return isHiddenEvent;
	}
	public void setHiddenEvent(boolean isHiddenEvent) {
		this.isHiddenEvent = isHiddenEvent;
	}
	public ArrayList<NPC> getNpcs() {
		return npcs;
	}
	public void setNpcs(ArrayList<NPC> npcs) {
		this.npcs = npcs;
	}

	public String getNorth() {
		return north;
	}

	public void setNorth(String north) {
		this.north = north;
	}

	public String getSouth() {
		return south;
	}

	public void setSouth(String south) {
		this.south = south;
	}

	public String getEast() {
		return east;
	}

	public void setEast(String east) {
		this.east = east;
	}

	public String getWest() {
		return west;
	}

	public void setWest(String west) {
		this.west = west;
	}

	/**************************** my method (used in EventRoom, commandMap.put(ERoomEventAction.HIDDENROOM_FOUND...) ****************************/
	public ArrayList<String> getAllDirections(){
		return new ArrayList<String>(Arrays.asList(getNorth(), getSouth(), getEast(), getWest()));
	}
}

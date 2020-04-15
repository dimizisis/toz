package leveleditor.actors;

import java.io.Serializable;

import leveleditor.items.Item;
import leveleditor.room.ERoomEventCondition;

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
public class Quest implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4266081895692472707L;
	private int id;
	private String introduction;
	private String description;
	private String completeText;
	private ERoomEventCondition questCondition;
	private String enemydead;
	private String questItem;
	private boolean isComplete=false;
	private int xpEarned;
	private String npcGivenby;
	private Item awardItem;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ERoomEventCondition getQuestCondition() {
		return questCondition;
	}
	public void setQuestCondition(ERoomEventCondition questCondition) {
		this.questCondition = questCondition;
	}
	public boolean isComplete() {
		return isComplete;
	}
	public void setComplete(boolean complete) {
		this.isComplete = complete;
	}
	public String getCompleteText() {
		return completeText;
	}
	public void setCompleteText(String completeText) {
		this.completeText = completeText;
	}
	public int getXpEarned() {
		return xpEarned;
	}
	public void setXpEarned(int xpEarned) {
		this.xpEarned = xpEarned;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public Item getAwardItem() {
		return awardItem;
	}
	public void setAwardItem(Item awardItem) {
		this.awardItem = awardItem;
	}
	public String getNpcGivenby() {
		return npcGivenby;
	}
	public void setNpcGivenby(String npcGivenby) {
		this.npcGivenby = npcGivenby;
	}
	public String getEnemydead() {
		return enemydead;
	}
	public void setEnemydead(String enemydead) {
		this.enemydead = enemydead;
	}
	public String getQuestItem() {
		return questItem;
	}
	public void setQuestItem(String questItem) {
		this.questItem = questItem;
	}
}

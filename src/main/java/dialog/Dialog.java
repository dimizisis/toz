package dialog;

import java.io.Serializable;

import leveleditor.actors.Quest;
import leveleditor.items.Item;


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
public class Dialog implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7603311675472608365L;
	private String optiontext;
	private String answertext;
	private int id;
	private int gotoId;
	private boolean isFinal=false;
	private boolean takeItem=false;
	private DialogSkillTest dialogskilltest;
	private boolean giveItem=false;
	private boolean isAttacking=false;
	private Item item;
	private Quest quest;
	
	public String getOptiontext() {
		return optiontext;
	}
	public void setOptiontext(String optiontext) {
		this.optiontext = optiontext;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getGotoId() {
		return gotoId;
	}
	public void setGotoId(int gotoId) {
		this.gotoId = gotoId;
	}
	public String getAnswertext() {
		return answertext;
	}
	public void setAnswertext(String answertext) {
		this.answertext = answertext;
	}
	public boolean isFinal() {
		return isFinal;
	}
	public void setFinal(boolean isFinal) {
		this.isFinal = isFinal;
	}
	public DialogSkillTest getDialogskilltest() {
		return dialogskilltest;
	}
	public void setDialogskilltest(DialogSkillTest dialogskilltest) {
		this.dialogskilltest = dialogskilltest;
	}
	public boolean isGiveItem() {
		return giveItem;
	}
	public void setGiveItem(boolean giveItem) {
		this.giveItem = giveItem;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public boolean isTakeItem() {
		return takeItem;
	}
	public void setTakeItem(boolean takeItem) {
		this.takeItem = takeItem;
	}
	public Quest getQuest() {
		return quest;
	}
	public void setQuest(Quest quest) {
		this.quest = quest;
	}
	public boolean isAttacking() {
		return isAttacking;
	}
	public void setAttacking(boolean isAttacking) {
		this.isAttacking = isAttacking;
	}
}

package dialog;

import java.io.Serializable;

import leveleditor.actors.ESkill;
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
public class DialogSkillTest implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2460859312415982067L;
	private ESkill skill;
	private int gotoIdSuccess;
	private int gotoIdFail;
	private int skillNPC;
	private String sucessText;
	private String failText;

	public ESkill getSkill() {
		return skill;
	}
	public void setSkill(ESkill skill) {
		this.skill = skill;
	}
	public int getGotoIdSuccess() {
		return gotoIdSuccess;
	}
	public void setGotoIdSuccess(int gotoIdSuccess) {
		this.gotoIdSuccess = gotoIdSuccess;
	}
	public int getGotoIdFail() {
		return gotoIdFail;
	}
	public void setGotoIdFail(int gotoIdFail) {
		this.gotoIdFail = gotoIdFail;
	}
	public int getSkillNPC() {
		return skillNPC;
	}
	public void setSkillNPC(int skillNPC) {
		this.skillNPC = skillNPC;
	}
	public String getSucessText() {
		return sucessText;
	}
	public void setSucessText(String sucessText) {
		this.sucessText = sucessText;
	}
	public String getFailText() {
		return failText;
	}
	public void setFailText(String failText) {
		this.failText = failText;
	}
}

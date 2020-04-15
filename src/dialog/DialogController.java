package dialog;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import leveleditor.actors.ESkill;
import leveleditor.actors.Enemy;
import leveleditor.actors.NPC;
import leveleditor.items.Gold;
import leveleditor.items.Item;
import leveleditor.room.ERoomEventCondition;
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
public class DialogController implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4450846858094454628L;
	private ArrayList<DialogChoices> conversation;
	private int copyDialogChoiceIndex;
	private int copyJ;
	private JFrame buttonframe;
	private JFrame textframe;
	private JPanel textpanel;
	private JTextArea text;

	public DialogController()
	{
		conversation = new ArrayList<DialogChoices>();
		textframe = new JFrame("Textdialog");
		textpanel = new JPanel();
		textframe.setSize(400, 300);
		textframe.setLocation(400, 400);
		text = new JTextArea(10, 30);
		text.setEditable(false);
		JScrollPane scrollpane = new JScrollPane(text, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		textpanel.add(scrollpane);
		textframe.add(textpanel);
		textframe.setResizable(false);
		textframe.setVisible(false);
	}

	public ArrayList<DialogChoices> getConversation() {
		return conversation;
	}
	//TODO: Needs method to get players name etc.
	public void talk(int dialogChoiceIndex)
	{
		Engine.engine.getNavigateWindow().getFrame().setVisible(false);
		textframe.setVisible(true);
		JPanel buttonPanel = new JPanel();
		buttonframe = new JFrame("Dialog - "+Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getNpcs().get(0).getName());
		buttonframe.setSize(400, 300);
		buttonframe.setLocation(200, 400);
		buttonframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int gridnumber=1;		
		for (int i = 0; i < conversation.size(); i++) 
		{
			if (conversation.get(i).getId()==dialogChoiceIndex)
			{
				copyDialogChoiceIndex=i;
				for (int j = 0; j < conversation.get(i).getDialogs().size(); j++) 
				{
					copyJ=j;
					JButton button = new JButton();					
					if (conversation.get(i).getDialogs().get(j).getDialogskilltest()==null && (conversation.get(i).getDialogs().get(j).getItem()==null))
					{
						button.setText(gridnumber + ". " + conversation.get(i).getDialogs().get(j).getOptiontext());
					}
					else if (conversation.get(i).getDialogs().get(j).getItem()!=null)
					{
						for (int k = 0; k < Engine.engine.getPlayer().getInventory().size(); k++) 
						{
							if (conversation.get(i).getDialogs().get(j).getItem().toString()==Engine.engine.getPlayer().getInventory().get(k).toString())
							{
								button.setText(gridnumber + ". [GIVE " + conversation.get(i).getDialogs().get(j).getItem() + "] " + conversation.get(i).getDialogs().get(j).getOptiontext());
							}
						}						
					}
					else
					{
						button.setText(gridnumber + ". [" + conversation.get(i).getDialogs().get(j).getDialogskilltest().getSkill() + "] " + conversation.get(i).getDialogs().get(j).getOptiontext());
					}
					button.addActionListener(new ActionListener() {

						private int id=copyJ;
						@Override
						public void actionPerformed(ActionEvent e) {
							for (int k = 0; k < Engine.engine.getPlayer().getQuests().size(); k++) 
							{
								if (Engine.engine.getPlayer().getQuests().get(k) != null)
								{
									if (Engine.engine.getPlayer().getQuests().get(k).getNpcGivenby()!=null)
									{
										if (Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getNpcs().get(0).getName()==Engine.engine.getPlayer().getQuests().get(k).getNpcGivenby())
										{
											for (int l = 0; l < Engine.engine.getPlayer().getInventory().size(); l++) 
											{
												if (Engine.engine.getPlayer().getInventory().get(l) != null)
												{
													if ((Engine.engine.getPlayer().getQuests().get(k).getQuestCondition()==ERoomEventCondition.ITEM_GIVEN) && (Engine.engine.getPlayer().getInventory().get(l).toString()==Engine.engine.getPlayer().getQuests().get(k).getQuestItem()))
													{
														Engine.engine.getPlayer().getQuests().get(k).setComplete(true);
														Engine.engine.addExp(Engine.engine.getPlayer().getQuests().get(k).getXpEarned());
														Engine.engine.getPlayer().getInventory().remove(l);
														write("Quest completed!\n");
														write("You've gained "+Engine.engine.getPlayer().getQuests().get(k).getXpEarned()+" experience!\n");
														if ((Engine.engine.getPlayer().getQuests().get(k).getAwardItem()!=null))
														{
															if ((Engine.engine.getPlayer().getQuests().get(k).getAwardItem() instanceof Gold))
															{
																Engine.engine.getPlayer().setGold(Engine.engine.getPlayer().getGold()+((Gold)Engine.engine.getPlayer().getQuests().get(k).getAwardItem()).getAmmount());
																write("You've received "+((Gold)Engine.engine.getPlayer().getQuests().get(k).getAwardItem()).getAmmount()+" Gold\n");
															}
															else
															{
																Engine.engine.getPlayer().getInventory().add(Engine.engine.getPlayer().getQuests().get(k).getAwardItem());
																write("You've received "+Engine.engine.getPlayer().getQuests().get(k).getAwardItem()+"\n");
															}
														}
													}
												}
											}
										}
									}
								}
							}							
							if (conversation.get(copyDialogChoiceIndex).getDialogs().get(id).getQuest() != null)
							{
								Engine.engine.getPlayer().getQuests().add(conversation.get(copyDialogChoiceIndex).getDialogs().get(id).getQuest());
								Engine.engine.getPlayer().getQuests().trimToSize();
								write("Quest added!\n");
							}
							if (conversation.get(copyDialogChoiceIndex).getDialogs().get(id).isFinal())
							{			
								if (conversation.get(copyDialogChoiceIndex).getDialogs().get(id).isAttacking())
								{									
									NPC npc = Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getNpcs().get(0);
									Enemy enemy = new Enemy();
									enemy.setAgility(npc.getAgility());
									enemy.setArmor(npc.getArmor());
									enemy.setCharisma(npc.getCharisma());
									enemy.setCreatureClass(npc.getCreatureClass());
									enemy.setGold(npc.getGold());
									enemy.setInitHp(npc.getInitHp());
									enemy.setInitMana(npc.getInitMana());
									enemy.setInitPlayerActions(npc.getInitPlayerActions());
									enemy.setLevel(npc.getLevel());
									enemy.setMale(npc.isMale());
									enemy.setName(npc.getName());
									enemy.setRace(npc.getRace());
									enemy.setResistFire(npc.getResistFire());
									enemy.setResistIce(npc.getResistIce());
									enemy.setResistLightning(npc.getResistLightning());
									enemy.setResistPoison(npc.getResistPoison());
									enemy.setStrength(npc.getStrength());
									enemy.setScarefactor(0);
									for (Item item : npc.getInventory()) 
									{
										enemy.getInventory().add(item);
									}									
									Engine.engine.attackedBy(enemy);
									buttonframe.setVisible(false);
									write("You: "+conversation.get(copyDialogChoiceIndex).getDialogs().get(id).getOptiontext()+"\n");
									write(Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getNpcs().get(0).getName()+": "+conversation.get(copyDialogChoiceIndex).getDialogs().get(id).getAnswertext()+"\n");
									Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getNpcs().remove(0);
								}
								else
								{
									buttonframe.setVisible(false);
									write("You: "+conversation.get(copyDialogChoiceIndex).getDialogs().get(id).getOptiontext()+"\n");
									write(Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getNpcs().get(0).getName()+": "+conversation.get(copyDialogChoiceIndex).getDialogs().get(id).getAnswertext()+"\n");
									Engine.engine.getNavigateWindow().getFrame().setVisible(true);
								}
							}
							else if (conversation.get(copyDialogChoiceIndex).getDialogs().get(id).getDialogskilltest()!=null)
							{
								buttonframe.setVisible(false);
								testSkill(copyDialogChoiceIndex, id);
							}							
							else
							{
								buttonframe.setVisible(false);
								write("You: "+conversation.get(copyDialogChoiceIndex).getDialogs().get(id).getOptiontext()+"\n");
								write(Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getNpcs().get(0).getName()+": "+conversation.get(copyDialogChoiceIndex).getDialogs().get(id).getAnswertext()+"\n");
								talk(conversation.get(copyDialogChoiceIndex).getDialogs().get(id).getGotoId());
							}
						}
						private void testSkill(int dialogchoicesIndex, int idIndex) 
						{
							if (conversation.get(dialogchoicesIndex).getDialogs().get(idIndex).getDialogskilltest().getSkill()==ESkill.AGILITY)
							{
								int d10=(int)(Math.random()*9);
								if ((Engine.engine.getPlayer().getAgility()+d10) >= conversation.get(dialogchoicesIndex).getDialogs().get(idIndex).getDialogskilltest().getSkillNPC())
								{
									write(conversation.get(dialogchoicesIndex).getDialogs().get(idIndex).getDialogskilltest().getSkill() + " success!\n");
									write("You: "+conversation.get(copyDialogChoiceIndex).getDialogs().get(id).getOptiontext()+"\n");
									write(Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getNpcs().get(0).getName()+": "+conversation.get(copyDialogChoiceIndex).getDialogs().get(id).getDialogskilltest().getSucessText()+"\n");
									if (conversation.get(copyDialogChoiceIndex).getDialogs().get(id).isGiveItem())
									{
										if (conversation.get(copyDialogChoiceIndex).getDialogs().get(id).getItem() instanceof Gold)
										{
											Engine.engine.getPlayer().setGold(Engine.engine.getPlayer().getGold()+((Gold)(conversation.get(copyDialogChoiceIndex).getDialogs().get(id).getItem())).getAmmount());
											write("You've gained "+((Gold)(conversation.get(copyDialogChoiceIndex).getDialogs().get(id).getItem())).getAmmount()+" gold!\n");
										}
										else
										{
											Engine.engine.getPlayer().getInventory().add(conversation.get(copyDialogChoiceIndex).getDialogs().get(id).getItem());
											write("You've added "+conversation.get(copyDialogChoiceIndex).getDialogs().get(id).getItem()+" to your inventory\n");
										}
									}
									talk(conversation.get(copyDialogChoiceIndex).getDialogs().remove(id).getDialogskilltest().getGotoIdSuccess());
								}
								else
								{
									write(conversation.get(dialogchoicesIndex).getDialogs().get(idIndex).getDialogskilltest().getSkill() + " failed!\n");
									write("You: "+conversation.get(copyDialogChoiceIndex).getDialogs().get(id).getOptiontext()+"\n");
									write(Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getNpcs().get(0).getName()+": "+conversation.get(copyDialogChoiceIndex).getDialogs().get(id).getDialogskilltest().getFailText()+"\n");
									talk(conversation.get(copyDialogChoiceIndex).getDialogs().remove(id).getDialogskilltest().getGotoIdFail());
								}
							}
							else if (conversation.get(dialogchoicesIndex).getDialogs().get(idIndex).getDialogskilltest().getSkill()==ESkill.CHARISMA)
							{
								int d10=(int)(Math.random()*9);
								if ((Engine.engine.getPlayer().getCharisma()+d10) >= conversation.get(dialogchoicesIndex).getDialogs().get(idIndex).getDialogskilltest().getSkillNPC())
								{
									write(conversation.get(dialogchoicesIndex).getDialogs().get(idIndex).getDialogskilltest().getSkill() + " success!\n");
									write("You: "+conversation.get(copyDialogChoiceIndex).getDialogs().get(id).getOptiontext()+"\n");
									write(Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getNpcs().get(0).getName()+": "+conversation.get(copyDialogChoiceIndex).getDialogs().get(id).getDialogskilltest().getSucessText()+"\n");
									if (conversation.get(copyDialogChoiceIndex).getDialogs().get(id).isGiveItem())
									{
										if (conversation.get(copyDialogChoiceIndex).getDialogs().get(id).getItem() instanceof Gold)
										{
											Engine.engine.getPlayer().setGold(Engine.engine.getPlayer().getGold()+((Gold)(conversation.get(copyDialogChoiceIndex).getDialogs().get(id).getItem())).getAmmount());
											write("You've gained "+((Gold)(conversation.get(copyDialogChoiceIndex).getDialogs().get(id).getItem())).getAmmount()+" gold!\n");
										}
										else
										{
											Engine.engine.getPlayer().getInventory().add(conversation.get(copyDialogChoiceIndex).getDialogs().get(id).getItem());
											write("You've added "+conversation.get(copyDialogChoiceIndex).getDialogs().get(id).getItem()+" to your inventory\n");
										}
									}
									talk(conversation.get(copyDialogChoiceIndex).getDialogs().remove(id).getDialogskilltest().getGotoIdSuccess());
								}
								else
								{
									write(conversation.get(dialogchoicesIndex).getDialogs().get(idIndex).getDialogskilltest().getSkill() + " failed!\n");
									write("You: "+conversation.get(copyDialogChoiceIndex).getDialogs().get(id).getOptiontext()+"\n");
									write(Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getNpcs().get(0).getName()+": "+conversation.get(copyDialogChoiceIndex).getDialogs().get(id).getDialogskilltest().getFailText()+"\n");
									talk(conversation.get(copyDialogChoiceIndex).getDialogs().remove(id).getDialogskilltest().getGotoIdFail());
								}
							}
							else if (conversation.get(dialogchoicesIndex).getDialogs().get(idIndex).getDialogskilltest().getSkill()==ESkill.INTELLIGENCE)
							{
								int d10=(int)(Math.random()*9);
								if ((Engine.engine.getPlayer().getIntelligence()+d10) >= conversation.get(dialogchoicesIndex).getDialogs().get(idIndex).getDialogskilltest().getSkillNPC())
								{
									write(conversation.get(dialogchoicesIndex).getDialogs().get(idIndex).getDialogskilltest().getSkill() + " success!\n");
									write("You: "+conversation.get(copyDialogChoiceIndex).getDialogs().get(id).getOptiontext()+"\n");
									write(Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getNpcs().get(0).getName()+": "+conversation.get(copyDialogChoiceIndex).getDialogs().get(id).getDialogskilltest().getSucessText()+"\n");
									if (conversation.get(copyDialogChoiceIndex).getDialogs().get(id).isGiveItem())
									{
										if (conversation.get(copyDialogChoiceIndex).getDialogs().get(id).getItem() instanceof Gold)
										{
											Engine.engine.getPlayer().setGold(Engine.engine.getPlayer().getGold()+((Gold)(conversation.get(copyDialogChoiceIndex).getDialogs().get(id).getItem())).getAmmount());
											write("You've gained "+((Gold)(conversation.get(copyDialogChoiceIndex).getDialogs().get(id).getItem())).getAmmount()+" gold!\n");
										}
										else
										{
											Engine.engine.getPlayer().getInventory().add(conversation.get(copyDialogChoiceIndex).getDialogs().get(id).getItem());
											write("You've added "+conversation.get(copyDialogChoiceIndex).getDialogs().get(id).getItem()+" to your inventory\n");
										}
									}
									talk(conversation.get(copyDialogChoiceIndex).getDialogs().remove(id).getDialogskilltest().getGotoIdSuccess());
								}
								else
								{
									write(conversation.get(dialogchoicesIndex).getDialogs().get(idIndex).getDialogskilltest().getSkill() + " failed!\n");
									write("You: "+conversation.get(copyDialogChoiceIndex).getDialogs().get(id).getOptiontext()+"\n");
									write(Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getNpcs().get(0).getName()+": "+conversation.get(copyDialogChoiceIndex).getDialogs().get(id).getDialogskilltest().getFailText()+"\n");
									talk(conversation.get(copyDialogChoiceIndex).getDialogs().remove(id).getDialogskilltest().getGotoIdFail());
								}
							}
							else if (conversation.get(dialogchoicesIndex).getDialogs().get(idIndex).getDialogskilltest().getSkill()==ESkill.STRENGTH)
							{
								int d10=(int)(Math.random()*9);
								if ((Engine.engine.getPlayer().getStrength()+d10) >= conversation.get(dialogchoicesIndex).getDialogs().get(idIndex).getDialogskilltest().getSkillNPC())
								{
									write(conversation.get(dialogchoicesIndex).getDialogs().get(idIndex).getDialogskilltest().getSkill() + " success!\n");
									write("You: "+conversation.get(copyDialogChoiceIndex).getDialogs().get(id).getOptiontext()+"\n");
									write(Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getNpcs().get(0).getName()+": "+conversation.get(copyDialogChoiceIndex).getDialogs().get(id).getDialogskilltest().getSucessText()+"\n");
									if (conversation.get(copyDialogChoiceIndex).getDialogs().get(id).isGiveItem())
									{
										if (conversation.get(copyDialogChoiceIndex).getDialogs().get(id).getItem() instanceof Gold)
										{
											Engine.engine.getPlayer().setGold(Engine.engine.getPlayer().getGold()+((Gold)(conversation.get(copyDialogChoiceIndex).getDialogs().get(id).getItem())).getAmmount());
											write("You've gained "+((Gold)(conversation.get(copyDialogChoiceIndex).getDialogs().get(id).getItem())).getAmmount()+" gold!\n");
										}
										else
										{
											Engine.engine.getPlayer().getInventory().add(conversation.get(copyDialogChoiceIndex).getDialogs().get(id).getItem());
											write("You've added "+conversation.get(copyDialogChoiceIndex).getDialogs().get(id).getItem()+" to your inventory\n");
										}
									}
									talk(conversation.get(copyDialogChoiceIndex).getDialogs().remove(id).getDialogskilltest().getGotoIdSuccess());
								}
								else
								{
									write(conversation.get(dialogchoicesIndex).getDialogs().get(idIndex).getDialogskilltest().getSkill() + " failed!\n");
									write("You: "+conversation.get(copyDialogChoiceIndex).getDialogs().get(id).getOptiontext()+"\n");
									write(Engine.engine.getPlayer().getWorld().get(Engine.engine.getPlayer().getCurrentroom()).getNpcs().get(0).getName()+": "+conversation.get(copyDialogChoiceIndex).getDialogs().get(id).getDialogskilltest().getFailText()+"\n");
									talk(conversation.get(copyDialogChoiceIndex).getDialogs().remove(id).getDialogskilltest().getGotoIdFail());
								}
							}
						}
					});
					if (!button.getText().isEmpty())
					{
						buttonPanel.add(button);
					}
					gridnumber++;
				}
				i=conversation.size();
			}
		}
		buttonPanel.setLayout(new GridLayout(gridnumber, 0));
		buttonframe.getContentPane().add(buttonPanel);
		buttonframe.setResizable(false);
		buttonframe.pack();
		buttonframe.setVisible(true);
	}

	public void setConversation(ArrayList<DialogChoices> conversation) {
		this.conversation = conversation;
	}

	public JTextArea getText() {
		return text;
	}

	public void write(String writetext)
	{
		String resttext=writetext;

		while (resttext.length()>55)
		{
			text.append(resttext.substring(0, 55)+"\n");
			resttext=resttext.substring(55, resttext.length());
		}
		text.append(resttext);
	}
}

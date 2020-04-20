package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import multiplayer.chat.ChatClient;

public class ChatGUI implements Serializable
{	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7214189501753321476L;
	private JTextArea chatText;
	private JTextArea writeText;
	private JButton sendButton;
	private JFrame frame;
	private ChatClient chatClient;

	public ChatGUI(ChatClient client)
	{
		this.chatClient = client;
	}

	public void setup()
	{		
		frame = new JFrame("Tower of Zaldagor - Chat");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(470, 370);
		frame.setLocation(200, 200);

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());

		chatText = new JTextArea(10,10);
		chatText.setEditable(false);

		JScrollPane scrollpane = new JScrollPane(chatText, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);	
		writeText = new JTextArea(5,10);

		sendButton = new JButton("Send");
		sendButton.setToolTipText("Press this button to send message");

		panel.add(BorderLayout.NORTH, scrollpane);
		panel.add(BorderLayout.CENTER, writeText);
		panel.add(BorderLayout.EAST, sendButton);

		frame.getContentPane().add(panel);
		frame.setResizable(false);

		sendButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					chatClient.sendMessage(writeText.getText());
					writeText.setText("");
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
			}
		});
		frame.setVisible(true);
	}

	public void write(String writetext)
	{
		chatText.setText(chatText.getText()+writetext+"\n");
	}

	public JFrame getFrame() {
		return frame;
	}

	public JButton getTalk() {
		return sendButton;
	}
}

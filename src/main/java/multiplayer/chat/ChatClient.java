package multiplayer.chat;

import gui.ChatGUI;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ChatClient {
	
	private IChatServer interfaceStub;
	private ChatGUI gui;
	private Message client;

	public ChatClient()
	{
		client = new Message();
		client.setName("Joe");
		client.setServerIP("192.168.2.81");
		Registry playerRegistry;
		try {
			playerRegistry = LocateRegistry.getRegistry(client.getServerIP(), 1200);
			try {
				interfaceStub = (IChatServer) playerRegistry.lookup("tozchat");					
			} catch (NotBoundException e) {
				e.printStackTrace();
			}
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		gui = new ChatGUI(this);
		gui.setup();
		try {
			interfaceStub.joinChat(client);
		} catch (RemoteException e) {
			System.err.println("Join chat error");
			e.printStackTrace();
		}
	}

	public void sendMessage(String message) throws RemoteException {
		try {
			interfaceStub.broadcastMessage(message, client);
		} catch (Exception e) {
			System.err.println("Send message error");
			e.printStackTrace();
		}
	}

	public void receiveMessage(String message) throws RemoteException {
		gui.write(message);
	}

	public void exitChat() throws RemoteException {
		interfaceStub.exitChat(client);
	}

	public IChatServer getInterfaceStub() {
		return interfaceStub;
	}

	public void setInterfaceStub(IChatServer interfaceStub) {
		this.interfaceStub = interfaceStub;
	}

	public ChatGUI getGui() {
		return gui;
	}

	public void setGui(ChatGUI gui) {
		this.gui = gui;
	}
}

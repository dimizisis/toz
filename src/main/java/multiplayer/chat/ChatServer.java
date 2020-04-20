package multiplayer.chat;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ChatServer implements IChatServer
{

	private IChatServer interfaceStub;
	private ArrayList<Message> clients;

	public ChatServer()
	{
		clients = new ArrayList<Message>();
		try {
			interfaceStub = (IChatServer) UnicastRemoteObject.exportObject(this, 0);
			Registry serverRegistry = LocateRegistry.createRegistry(1200);
			try {
				serverRegistry.bind("tozchat", interfaceStub);
			} catch (AlreadyBoundException e) {
				e.printStackTrace();
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void broadcastMessage(String message, Message client) throws RemoteException {
		for (int i = 0; i < clients.size(); i++) {			
			clients.get(i).receiveMessage(client.getName() + ": " + message);
		}
	}

	@Override
	public void joinChat(Message client) throws RemoteException {
		if (!clients.isEmpty())
		{
			for (int i = 0; i < clients.size(); i++) {
				clients.get(i).receiveMessage(client.getName() + " has joined the game...");
			}
		}
		clients.add(client);
	}

	@Override
	public void exitChat(Message client) throws RemoteException {
		for (int i = 0; i < clients.size(); i++) {
			clients.get(i).receiveMessage(client.getName() + " has left the game...");
		}
		clients.remove(client);
	}
}

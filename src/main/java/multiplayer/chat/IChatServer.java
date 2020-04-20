package multiplayer.chat;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IChatServer extends Remote 
{
	void broadcastMessage(String message, Message client) throws RemoteException;
	void joinChat(Message client) throws RemoteException;
	void exitChat(Message client) throws RemoteException;
}

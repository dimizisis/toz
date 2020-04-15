package multiplayer.chat;

import java.io.Serializable;

public class Message implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4221191228683257018L;
	private String name;
	private String serverIP;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getServerIP() {
		return serverIP;
	}
	public void setServerIP(String serverIP) {
		this.serverIP = serverIP;
	}
	public void receiveMessage(String string) {
		// TODO Auto-generated method stub
		
	}
}

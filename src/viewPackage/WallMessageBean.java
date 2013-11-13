package viewPackage;

import java.sql.Timestamp;

public class WallMessageBean {

	private String WallMessages;
	private int sender;
	private int reciver;
	private String wallMessage;
	private Timestamp datasent;
	
	public String getWallMessages() {
		return WallMessages;
	}
	public void setWallMessages(String wallMessages) {
		WallMessages = wallMessages;
	}
	public int getSender() {
		return sender;
	}
	public void setSender(int sender) {
		this.sender = sender;
	}
	public int getReciver() {
		return reciver;
	}
	public void setReciver(int reciver) {
		this.reciver = reciver;
	}
	public String getWallMessage() {
		return wallMessage;
	}
	public void setWallMessage(String wallMessage) {
		this.wallMessage = wallMessage;
	}
	public Timestamp getDatasent() {
		return datasent;
	}
	public void setDatasent(Timestamp datasent) {
		this.datasent = datasent;
	}
	
	
}

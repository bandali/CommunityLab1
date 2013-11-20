package viewPackage;

import java.sql.Timestamp;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import logicPackage.MessageHandler;

@ManagedBean(name="wallmessageBean")
@SessionScoped
public class WallMessageBean {

	
	private int sender;
	private int reciver;
	private String senderName;
	private String wallMessage;
	private Timestamp datasent;
	
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
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	
	public String SendWallMessage(int sender,int reciever)
	{
		MessageHandler mh = new MessageHandler();
		if(mh.SendWallMessage(wallMessage, sender, reciever))
		{
			return "Homepage?faces-redirect=true";
		}
		else{
			return "Profile?faces-redirect=true";
		}
	}
}

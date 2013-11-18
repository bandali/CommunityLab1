package viewPackage;

import java.sql.Timestamp;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import logicPackage.MessageHandler;

@ManagedBean(name="privatemessagebean")
@SessionScoped
public class PrivateMessageBean {
	private int sender;
	private int reciver;
	private String privateMessage;
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
	public String getPrivateMessage() {
		return privateMessage;
	}
	public void setPrivateMessage(String privateMessage) {
		this.privateMessage = privateMessage;
	}
	public Timestamp getDatasent() {
		return datasent;
	}
	public void setDatasent(Timestamp datasent) {
		this.datasent = datasent;
	}
	
	public String redirectPrivateMessage()
	{
		return "PrivateMessage?faces-redirect=true";
	}
	
	
	public String sendPrivateMessage()
	{
		
		System.out.println("help");
		MessageHandler mh = new MessageHandler();
		return mh.sendPrivateMessage(reciver, privateMessage);
	
	}
}

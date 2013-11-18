package logicPackage;

import static javax.persistence.GenerationType.IDENTITY;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Messages")
public class PrivateMessage {
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idMessage")
	private int idMessage;
	
	public int getIdMessage() {
		return idMessage;
	}
	public void setIdMessage(int idMessage) {
		this.idMessage = idMessage;
	}
	@Column(name = "sender")
	private int sender;
	
	@Column(name = "reciever")
	private int reciver;
	
	@Column(name = "message")
	private String privateMessage;
	
	@Column(name = "dateSent")
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
	
	
}

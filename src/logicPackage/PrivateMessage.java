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
	@Column(name = "idMessages")
	private int idMessage;
	
	@Column(name = "sender")
	private int sender;
	
	@Column(name = "reciever")
	private int reciever;
	
	@Column(name = "message")
	private String privateMessage;
	
	@Column(name = "dateSent")
	private Timestamp datasent;
	
	
	public int getIdMessage() {
		return idMessage;
	}
	public void setIdMessage(int idMessage) {
		this.idMessage = idMessage;
	}
	
	public int getSender() {
		return sender;
	}
	public void setSender(int sender) {
		this.sender = sender;
	}
	public int getReciever() {
		return reciever;
	}
	public void setReciever(int reciver) {
		this.reciever = reciver;
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

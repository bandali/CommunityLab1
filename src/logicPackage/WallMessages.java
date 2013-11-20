package logicPackage;

import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="WallMessages")
public class WallMessages {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idWallMessages")
	private int idWallMessages;
	
	@Column(name = "sender")
	private int sender;
	
	@Column(name = "reciever")
	private int reciever;
	
	@Column(name = "wallMessage")
	private String wallMessage;
	
	@Column(name = "dateSent")
	private Timestamp datasent;
	
	public int getIdMessage() {
		return idWallMessages;
	}
	public void setIdMessage(int idMessage) {
		this.idWallMessages = idMessage;
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
	public String getWallMessages() {
		return wallMessage;
	}
	public void setWallMessages(String privateMessage) {
		this.wallMessage = privateMessage;
	}
	public Timestamp getDatasent() {
		return datasent;
	}
	public void setDatasent(Timestamp datasent) {
		this.datasent = datasent;
	}
}

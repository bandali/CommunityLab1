package logicPackage;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Friends")
public class Friends {
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idFriends")
	private int idFriend;
	
	@Column(name = "userId")
	private int userId;
	
	@Column(name = "friendId")
	private int friendId;
	
	
	public int getIdFriend() {
		return idFriend;
	}
	public void setIdFriend(int idFriend) {
		this.idFriend = idFriend;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getFriendId() {
		return friendId;
	}
	public void setFriendId(int friendId) {
		this.friendId = friendId;
	}
}

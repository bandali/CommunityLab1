package viewPackage;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import logicPackage.UserHandler;


@ManagedBean(name="profileBean")
@SessionScoped
public class ProfileBean {
	
	private int idUser; 
	private String firstname; 
	private String lastname; 
	private String country;
	private String email;
	private List<WallMessageBean> wallmessages;
	
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<WallMessageBean> getWallmessages() {
		return wallmessages;
	}
	public void setWallmessages(List<WallMessageBean> wallmessages) {
		this.wallmessages = wallmessages;
	}
	
	public String showProfile()
	{
		UserHandler uh = new UserHandler();
		return uh.getFriendbyName(firstname);
	}
}

package viewPackage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import logicPackage.MessageHandler;
import logicPackage.UserHandler;

@ManagedBean(name="userBean")
@SessionScoped
public class UserBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int idUser; 
	private String firstname; 
	private String lastname; 
	private String country;
	private String password; 
	private String email;
	private List<UserBean> friendList;
	private List<WallMessageBean> wallmessages;
	private List<PrivateMessageBean> pm;
	
	public List<UserBean> getFriendList() {
		return friendList;
	}
	public void setFriendList(List<UserBean> friendList) {
		this.friendList = friendList;
	}
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String doLogin()
	{
		UserBean ub = new UserBean();
		UserHandler uh = new UserHandler();
		ub.setEmail(email);
		ub.setPassword(password);
		String s = uh.login(email,password);
		initFriendList();
		return s;
	}	
	public String redirectRegister()
	{
		UserHandler uh = new  UserHandler();
		uh.reloadWallMessages();
		return "Register?faces-redirect=true";
	}
	
	public String redirectPrivateMessage()
	{
		MessageHandler mh = new MessageHandler();
		this.setPm(mh.initPrivateMessages(this.idUser));
		return "PrivateMessage?faces-redirect=true";
	}
	
	public String register()
	{
		UserHandler uh = new UserHandler();
		return uh.register(firstname,lastname,country,password, email);
	}
	public String redirectUserProfile()
	{
		return "UserProfile?faces-redirect=true";
	}
	
	public void initFriendList(){
		UserHandler uh = new UserHandler();
		setFriendList(uh.initFriendList(getIdUser()));
	}
	public List<WallMessageBean> getWallmessages() {
		return wallmessages;
	}
	public void setWallmessages(List<WallMessageBean> wallmessages) {
		this.wallmessages = wallmessages;
	}
	public List<PrivateMessageBean> getPm() {
		return pm;
	}
	public void setPm(List<PrivateMessageBean> pm) {
		this.pm = pm;
	}
	
}

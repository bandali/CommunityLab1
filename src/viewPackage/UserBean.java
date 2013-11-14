package viewPackage;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

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
		return uh.login(email,password);
	}	
	public String redirectRegister()
	{
		return "Register";
	}
	
	public String register()
	{
		UserHandler uh = new UserHandler();
		return uh.register(firstname,lastname,country,password, email);
	}
	
	
	
}

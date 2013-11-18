package logicPackage;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import viewPackage.UserBean;
import daoPackage.daoUser;

public class UserHandler {

	public String login(String  email, String password)
	{
		daoUser daou = new daoUser();
		
		
		if(daou.login(email, password))
		{//Hämta bönan i session
			
			FacesContext ctx = FacesContext.getCurrentInstance();
		    ExternalContext extCtx = ctx.getExternalContext();
		   
			
			User u = daou.loginFillBean(email, password);
			UserBean ub = (UserBean)extCtx.getSessionMap().get("userBean");
			//UserBean uBean = (UserBean) request.getSession().getAttribute("userBean");
			/*UserBean Ub = (UserBean) FacesContext.getCurrentInstance().
					getExternalContext().getRequestMap().get("userBean");*/
			
			ub.setFirstname(u.getFirstname());
			ub.setEmail(u.getEmail());
			ub.setLastname(u.getLastname());
			ub.setCountry(u.getCountry());
			ub.setIdUser(u.getIdUser());
			ub.setPassword(u.getPassword());

			return "Homepage?faces-redirect=true";
		}
		else {
			return "Login?faces-redirect=true";
		}
	}
	
	public String register(String firstname, String lastname, String country, String password, String email)
	{
		daoUser daou = new daoUser();
		
		
		if(daou.register(email, password, firstname, lastname, country))
		{
			return "Login.xhtml";
		}
		else
		{
			return "Register.xhtml";
		}	
	}
	
	public List<UserBean> initFriendList(int id)
	{
		//ArrayList<UserBean> friendList = new ArrayList<>();
		daoUser du = new daoUser();
		ArrayList<User> rawFriends = du.initFriendList(id);
		List<UserBean> beans = new LinkedList<>();
		for (User user : rawFriends) {
			UserBean bean = new UserBean();
			bean.setIdUser(user.getIdUser());
			bean.setFirstname(user.getFirstname());
			bean.setLastname(user.getLastname());
			bean.setEmail(user.getEmail());
			bean.setCountry(user.getCountry());
			
			beans.add(bean);
		}
		return beans;
	}
	
}

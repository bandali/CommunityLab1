package logicPackage;

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

			return "Homepage.xhtml";
		}
		else {
			return "Login.xhtml";
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
}

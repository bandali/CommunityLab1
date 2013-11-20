package logicPackage;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import viewPackage.ProfileBean;
import viewPackage.UserBean;
import viewPackage.WallMessageBean;
import daoPackage.daoMessage;
import daoPackage.daoUser;

public class UserHandler {

	public String login(String  email, String password)
	{
		daoUser daou = new daoUser();
		daoMessage dm = new daoMessage();
		
		if(daou.login(email, password))
		{//Hämta bönan i session
			
			FacesContext ctx = FacesContext.getCurrentInstance();
		    ExternalContext extCtx = ctx.getExternalContext();
		    List<WallMessageBean> beans = new LinkedList<WallMessageBean>();
			
			User u = daou.loginFillBean(email, password);
			UserBean ub = (UserBean)extCtx.getSessionMap().get("userBean");
			
			ub.setFirstname(u.getFirstname());
			ub.setEmail(u.getEmail());
			ub.setLastname(u.getLastname());
			ub.setCountry(u.getCountry());
			ub.setIdUser(u.getIdUser());
			ub.setPassword(u.getPassword());
			for(WallMessages wm:dm.getWallMessageForUser(ub.getIdUser()))
			{
				WallMessageBean wmb = new WallMessageBean();
				wmb.setReciver(wm.getReciever());
				wmb.setSender(wm.getSender());
				wmb.setWallMessage(wm.getWallMessages());
				wmb.setSenderName(daou.getUserNameById(wm.getSender()));
				wmb.setDatasent(wm.getDatasent());
				beans.add(wmb);
			}
			ub.setWallmessages(beans);
			
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
	
	public String getFriendbyName(String name){
		daoUser du = new daoUser();
		daoMessage dm = new daoMessage();
		User user = du.getFriendbyName(name);
		
		FacesContext ctx = FacesContext.getCurrentInstance();
	    ExternalContext extCtx = ctx.getExternalContext();
		ProfileBean pb = (ProfileBean)extCtx.getSessionMap().get("profileBean");
		
		List<WallMessages> wallmsg = new LinkedList<WallMessages>();
		List<WallMessageBean> wmb = new LinkedList<WallMessageBean>();
		wallmsg = dm.getWallMessageForUser(user.getIdUser());
		
		pb.setFirstname(user.getFirstname());
		pb.setLastname(user.getLastname());
		pb.setIdUser(user.getIdUser());
		pb.setCountry(user.getCountry());
		pb.setEmail(user.getEmail());
		for (WallMessages wallm : wallmsg) {
			WallMessageBean wb = new WallMessageBean();
			wb.setSender(wallm.getSender());
			wb.setReciver(wallm.getReciever());
			wb.setWallMessage(wallm.getWallMessages());
			wb.setSenderName(du.getUserNameById(wallm.getSender()));
			wmb.add(wb);
		}
		pb.setWallmessages(wmb);
		
		return "Profile?faces-redirect=true";
	}
	
	public void reloadWallMessages()
	{
		daoMessage dm = new daoMessage();
		daoUser daou = new daoUser();
		FacesContext ctx = FacesContext.getCurrentInstance();
	    ExternalContext extCtx = ctx.getExternalContext();
	    List<WallMessageBean> beans = new LinkedList<WallMessageBean>();
		UserBean ub = (UserBean)extCtx.getSessionMap().get("userBean");
		
		for(WallMessages wm:dm.getWallMessageForUser(ub.getIdUser()))
		{
			WallMessageBean wmb = new WallMessageBean();
			wmb.setReciver(wm.getReciever());
			wmb.setSender(wm.getSender());
			wmb.setWallMessage(wm.getWallMessages());
			wmb.setSenderName(daou.getUserNameById(wm.getSender()));
			wmb.setDatasent(wm.getDatasent());
			beans.add(wmb);
		}
		ub.setWallmessages(beans);
	}
	
}

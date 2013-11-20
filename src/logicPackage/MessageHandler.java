package logicPackage;


import java.util.LinkedList;
import java.util.List;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import viewPackage.PrivateMessageBean;
import viewPackage.UserBean;
import daoPackage.daoMessage;
import daoPackage.daoUser;

public class MessageHandler {
	
	public String sendPrivateMessage(int reciver, String message){
		daoMessage msg = new daoMessage();
		
		FacesContext ctx = FacesContext.getCurrentInstance();
	    ExternalContext extCtx = ctx.getExternalContext();
		UserBean ub = (UserBean)extCtx.getSessionMap().get("userBean");
		
		if(msg.sendPrivateMessage(ub.getIdUser(), reciver, message)){
			return "Homepage?faces-redirect=true";
		}
		else{
			return "PrivateMessage?faces-redirect=true";
		}
	}
	
	
	public List<PrivateMessageBean> initPrivateMessages(int userId)
	{
		daoMessage daom = new daoMessage();
		daoUser du = new daoUser();
		List<PrivateMessage> privateMessages = daom.getPrivateMessages(userId);
		List<PrivateMessageBean> beans = new LinkedList<>();
		for(PrivateMessage pms : privateMessages) {
			PrivateMessageBean pm = new PrivateMessageBean();
			pm.setSender(pms.getSender());
			pm.setReciver(pms.getReciever());
			pm.setPrivateMessage(pms.getPrivateMessage());
			pm.setDatasent(pms.getDatasent());
			pm.setSenderName(du.getUserNameById(pms.getSender()));
			
			beans.add(pm);
		}
		return beans;
	}
	
	public boolean SendWallMessage(String message, int sender, int reciever){
		daoMessage msg = new daoMessage();
		if(msg.sendWallMessage(sender, reciever, message))
		{
			return true;
		}
		else{
			return false;
		}
		
	}
}
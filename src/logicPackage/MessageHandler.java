package logicPackage;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import viewPackage.UserBean;
import daoPackage.daoMessage;

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
}

package logicPackage;

import daoPackage.daoUser;

public class UserHandler {

	public String login(String  email, String password)
	{
		daoUser daou = new daoUser();
		
		if(daou.login(email, password))
		{
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

package com;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LogoutAction extends Action{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
				
			String name = request.getParameter("uname");
			String upass = request.getParameter("upass");
			DBConn dbcon = new DBConn();
			
			boolean resetflag = dbcon.resetFlag(name, upass);
			
			if(resetflag) {
				return "logout.success";
			}else {
				return "logout.failure";
			}
			
	}
}

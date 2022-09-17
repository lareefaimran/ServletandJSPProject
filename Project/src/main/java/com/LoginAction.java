package com;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginAction extends Action {
		@Override
		public String execute(HttpServletRequest request, HttpServletResponse response) {
			String name = request.getParameter("uname");
			String upass = request.getParameter("upass");
			DBConn dbcon = new DBConn();
			boolean valid = dbcon.checkUser(name, upass);
			
			request.setAttribute("uname", name);
			request.setAttribute("upass", upass);
			
			int num = dbcon.checkFlag(name, upass);
			 if( valid && num==1) {
				 return "login.success";
			 }
			 if(valid && num==2) {
				 return "already.logged";
			 }
			return "login.register";
			
			
		}
}

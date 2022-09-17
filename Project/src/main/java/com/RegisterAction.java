package com;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterAction extends Action {
		@Override
		public String execute(HttpServletRequest request, HttpServletResponse response) {
			int uid =Integer.parseInt(request.getParameter("uid"));
			String name = request.getParameter("uname");
			String upass = request.getParameter("upass");
			String city = request.getParameter("city");
			String number = request.getParameter("number");
			
			DBConn dbcon = new DBConn();
			int add = dbcon.register(uid, name, upass, city, number);
			if(add==1) {
				return "register.success";
			}
			else {
				return "register.failure";
			}
		}
}

package com.controller;

import java.io.IOException;

import com.dao.ClientDAO;
import com.model.ClientModel;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class ClientController extends HttpServlet {
	// private static final long serialVersionUID = 1L;
	
	public ClientController() {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello");
		String fullname = request.getParameter("fullname");
		String username = request.getParameter("username");
		String Emailaddress = request.getParameter("Emailaddress");
		String password = request.getParameter("password");
		String confirmpassword = request.getParameter("confirmpassword");
		
		ClientModel cm = new ClientModel();
		cm.setFullname(fullname);
		cm.setUsername(username);
		cm.setEmailaddress(Emailaddress);
		cm.setPassword(password);
		cm.setConfirmpassword(confirmpassword);
 		System.out.println("Model data: " + cm);
		
		ClientDAO cd = new ClientDAO ();
		String status = cd.insertClient(cm);
		System.out.println(status);
		
		if(status.equals("SUCCESS")) {
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}

}
}
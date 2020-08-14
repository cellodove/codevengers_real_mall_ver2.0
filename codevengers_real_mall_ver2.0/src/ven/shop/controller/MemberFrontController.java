package ven.shop.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ven.member.service.MemberAddService;
import ven.member.service.MemberLoginCheckService;
import ven.member.service.MemberMainService;
import ven.shop.action.Action;
import ven.shop.command.ActionCommand;

@WebServlet("/MemberFrontController")
public class MemberFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String pathURL = requestURI.substring(contextPath.length());

		ActionCommand actionCommand = null;
		Action action = null;

		if (pathURL.equals("/MemberMain.do")) {
			action = new MemberMainService();
			System.out.println("memberMain.do");
			try {
				actionCommand = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if (pathURL.equals("/MemberLogin.do")) {
			actionCommand = new ActionCommand();
			actionCommand.setRedirect(false);
			actionCommand.setPath("./member/member_login.jsp");
			System.out.println("memberLogin.do");
			
		}else if (pathURL.equals("/MemberAllInfo.do")) {
			actionCommand = new ActionCommand();
			actionCommand.setRedirect(false);
			actionCommand.setPath("./member/member_all_info.jsp");
			System.out.println("member_all_info.do");
			
		} else if (pathURL.equals("/MemberLoginCheck.do")) {
			action = new MemberLoginCheckService();
			System.out.println("MemberLoginCheck.do");
			try {
				actionCommand = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if (pathURL.equals("/MemberSignup.do")) {
			actionCommand = new ActionCommand();
			actionCommand.setRedirect(false);
			actionCommand.setPath("./member/member_signup.jsp");
			System.out.println("MemberSignup.do");
			
		}else if (pathURL.equals("/MemberAdd.do")) {
			action = new MemberAddService();
			System.out.println("MemberAddCheck.do");
			try {
				actionCommand = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		
		
		
		
		
		
		
		
		
		if (actionCommand != null) {
			if (actionCommand.isRedirect()) {
				response.sendRedirect(actionCommand.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(actionCommand.getPath());
				dispatcher.forward(request, response);
			}
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

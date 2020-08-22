package ven.shop.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ven.member.service.MemberAddService;
import ven.member.service.MemberChangeInformationGoService;
import ven.member.service.MemberChangeInformationService;
import ven.member.service.MemberDeleteService;
import ven.member.service.MemberFindAccountIDService;
import ven.member.service.MemberFindAccountPasswdService;
import ven.member.service.MemberLoginCheckService;
import ven.member.service.MemberMailCodeCheckService;
import ven.member.service.MemberMainService;
import ven.member.service.MemberMyInformationService;
import ven.member.service.MemberSendMailService;
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
			System.out.println("MemberAdd.do");
			try {
				actionCommand = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if (pathURL.equals("/MemberSendMail.do")) {
			System.out.println("MemberSendMail.do");
			action = new MemberSendMailService();
			try {
				actionCommand = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if (pathURL.equals("/MemberMailCodeCheck.do")) {
			System.out.println("memberMailCheck.do");
			action = new MemberMailCodeCheckService();
			try {
				actionCommand = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
	
		}else if (pathURL.equals("/MemberFindAccountGo.do")) {
			System.out.println("MemberFindAccountGo.do");
			actionCommand = new ActionCommand();
			actionCommand.setRedirect(false);
			actionCommand.setPath("./member/member_find.jsp");
			
		}else if (pathURL.equals("/MemberFindAccountIDGo.do")) {
			System.out.println("MemberFindAccountIDGo.do");
			actionCommand = new ActionCommand();
			actionCommand.setRedirect(false);
			actionCommand.setPath("./member/member_find_id.jsp");
			
		}else if (pathURL.equals("/MemberFindAccountPasswdGo.do")) {
			System.out.println("MemberFindAccountPasswdGo.do");
			actionCommand = new ActionCommand();
			actionCommand.setRedirect(false);
			actionCommand.setPath("./member/member_find_passwd.jsp");
			
		}else if (pathURL.equals("/MemberFindAccountID.do")) {
			System.out.println("MemberFindAccount.do");
			action = new MemberFindAccountIDService();
			try {
				actionCommand = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
	
		}else if (pathURL.equals("/MemberFindAccountPasswd.do")) {
			System.out.println("MemberFindAccountPasswd.do");
			action = new MemberFindAccountPasswdService();
			try {
				actionCommand = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
	
		}else if (pathURL.equals("/MemberMyInformation.do")) {
			System.out.println("/MemberMyInformation.do");
			action = new MemberMyInformationService();
			try {
				actionCommand = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
	
		}else if (pathURL.equals("/MemberChangeInformationGo.do")) {
			System.out.println("/MemberChangeInformationGo.do");
			action = new MemberChangeInformationGoService();
			try {
				actionCommand = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
	
		}else if (pathURL.equals("/MemberChangeInformation.do")) {
			System.out.println("/MemberChangeInformation.do");
			action = new MemberChangeInformationService();
			try {
				actionCommand = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
	
		}else if(pathURL.equals("/MemberDeleteGo.do")) {
			actionCommand = new ActionCommand();
			System.out.println("memberDelete.do");
			String mem_id = request.getParameter("mem_id");
			request.setAttribute("mem_id", mem_id);
			actionCommand.setRedirect(false);
			actionCommand.setPath("./member/member_delete.jsp");
			
		}else if(pathURL.equals("/MemberDelete.do")) {
			System.out.println("MemberDelete.do");
			action = new MemberDeleteService();

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

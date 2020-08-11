package ven.shop.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ven.member.service.MemberMainService;
import ven.shop.action.Action;
import ven.shop.command.ActionCommand;

@WebServlet("/MemberFrontController")
public class MemberFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// �꽌釉붾┸ 留듯븨紐낆쓣 �꽕�젙�븳�떎.
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String pathURL = requestURI.substring(contextPath.length());

		// �룷�썙�뵫 �젙蹂� ���옣
		ActionCommand actionCommand = null;
		// 硫붿냼�뱶 洹쒓꺽�솕
		Action action = null;

		if (pathURL.equals("/MemberMain.do")) {
			action = new MemberMainService();
			System.out.println("memberMain.do�뿰寃�");
			try {
				actionCommand = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (false) {
			System.out.println();
		}

		
		
		
		
		
		
		
		
		
		if (actionCommand != null) {
			// isRedirect 硫붿냼�뱶 媛믪씠 false�씠硫� forward 諛⑹떇�씠怨� true�씠硫� redirect 諛⑹떇�씠 �맂�떎.
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

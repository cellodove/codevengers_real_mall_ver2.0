package ven.shop.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ven.item.service.ItemManDetailService;
import ven.item.service.ItemManListService;
import ven.item.service.ItemRunningListService;
import ven.item.service.ItemSuitShoesListService;
import ven.item.service.ItemWomanListService;
import ven.shop.action.Action;
import ven.shop.command.ActionCommand;

@WebServlet("/ItemFrontController")
public class ItemFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String pathURL = requestURI.substring(contextPath.length());

		ActionCommand actionCommand = null;
		Action action = null;

		if (pathURL.equals("/ItemMain.no")) {
			actionCommand = new ActionCommand();
			actionCommand.setRedirect(false);
			actionCommand.setPath("./item/item_main.jsp");
			System.out.println("ItemMain.no");
			//////////////////////////////////
		} else if (pathURL.equals("/ItemMan.no")) {
			action = new ItemManListService();
			try {
				actionCommand = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("ItemMan.no");
			///////////////////////////////
		}else if (pathURL.equals("/ItemWoman.no")) {
			action = new ItemWomanListService();
			try {
				actionCommand = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("ItemWoan.no");
			/////////////////////////////////
		}else if (pathURL.equals("/ItemRunning.no")) {
			action = new ItemRunningListService();
			try {
				actionCommand = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("ItemRunning.no");
			/////////////////////////////////
		}else if (pathURL.equals("/ItemSuitShoes.no")) {
			action = new ItemSuitShoesListService();
			try {
				actionCommand = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("ItemSuitShoes.no");
			
		}else if (pathURL.equals("/ItemManDetail.no")) {
			action = new ItemManDetailService();
			try {
				actionCommand = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("ItemManDetail.no");
			
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

package ven.shop.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ven.admin.service.ADItemDeleteService;
import ven.admin.service.ADItemDetailService;
import ven.admin.service.ADMemberDeleteService;
import ven.admin.service.AdminLoginCheckService;
import ven.admin.service.AdminMemberChangeInformationService;
import ven.admin.service.GoAdminMemberChangeInformationService;
import ven.admin.service.GoItemManagementService;
import ven.admin.service.ItemAddService;
import ven.admin.service.MemberDetailService;
import ven.admin.service.MemberManagementService;
import ven.shop.action.Action;
import ven.shop.command.ActionCommand;

@WebServlet("/AdminFrontController")
public class AdminFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String pathURL = requestURI.substring(contextPath.length());

		ActionCommand actionCommand = null;
		Action action = null;

		if (pathURL.equals("/AdminLogin.ko")) {
			actionCommand = new ActionCommand();
			actionCommand.setRedirect(false);
			actionCommand.setPath("./admin/admin_login.jsp");
			System.out.println("AdminLogin.ko");
			
		} else if(pathURL.equals("/AdminLoginCheck.ko")){
			action = new AdminLoginCheckService();
			System.out.println("AdminLoginCheck.ko");
			try {
				actionCommand = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else if(pathURL.equals("/MemberManagement.ko")){
			action = new MemberManagementService();
			System.out.println("MemberManagement.ko");
			try {
				actionCommand = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else if(pathURL.equals("/MemberDetail.ko")){
			action = new MemberDetailService();
			System.out.println("MemberDetail.ko");
			try {
				actionCommand = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else if(pathURL.equals("/GoAdminMemberChangeInformation.ko")){
			action = new GoAdminMemberChangeInformationService();
			System.out.println("GoAdminMemberChangeInformation.ko");
			try {
				actionCommand = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else if(pathURL.equals("/AdminMemberChangeInformation.ko")){
			action = new AdminMemberChangeInformationService();
			System.out.println("AdminMemberChangeInformation.ko");
			try {
				actionCommand = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else if(pathURL.equals("/ADMemberDelete.ko")){
			action = new ADMemberDeleteService();
			System.out.println("ADMemberDelete.ko");
			try {
				actionCommand = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else if(pathURL.equals("/GoItemManagement.ko")){
			action = new GoItemManagementService();
			System.out.println("GoItemManagement.ko");
			try {
				actionCommand = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else if(pathURL.equals("/ADItemDelete.ko")){
			action = new ADItemDeleteService();
			System.out.println("ADItemDelete.ko");
			try {
				actionCommand = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else if(pathURL.equals("/GoItemAdd.ko")){
			actionCommand = new ActionCommand();
			actionCommand.setRedirect(false);
			actionCommand.setPath("./admin/add_item.jsp");
			System.out.println("GoItemAdd.ko");
			
		} else if(pathURL.equals("/ItemAdd.ko")){
			action = new ItemAddService();
			System.out.println("ItemAdd.ko");
			try {
				actionCommand = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else if(pathURL.equals("/ADItemDetail.ko")){
			action = new ADItemDetailService();
			System.out.println("ADItemDetail.ko");
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

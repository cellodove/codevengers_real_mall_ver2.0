package ven.member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ven.shop.action.Action;
import ven.shop.command.ActionCommand;
import ven.shop.dao.MemberDAO;
import ven.shop.model.MemberVO;

public class MemberLoginCheckService implements Action {

	@Override
	public ActionCommand execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberDAO memberDAO= new MemberDAO();
		MemberVO memberVO = new MemberVO();
		
		System.out.println("MemberLoginCheckService Come");
		
		System.out.println(request.getParameter("mem_id"));
		System.out.println(request.getParameter("mem_passwd"));
		
		String mem_id = request.getParameter("mem_id");
		String mem_passwd=request.getParameter("mem_passwd");
		
		memberVO.setMem_id(mem_id);
		memberVO.setMem_passwd(mem_passwd);
		
		ActionCommand actionCommand = new ActionCommand();
		actionCommand.setRedirect(false);
		boolean loginCheck = memberDAO.loginCheck(memberVO);
		if (loginCheck) {
			System.out.println("Login OK");
			
			HttpSession session = request.getSession();
			session.setAttribute("mem_id", mem_id);
			actionCommand.setPath("./main/main.jsp");
			
		}else {


			actionCommand.setPath("./member/member_login.jsp");
			System.out.println("Login fail");
		}
		
		return actionCommand;
		
		
		
		
	}

}

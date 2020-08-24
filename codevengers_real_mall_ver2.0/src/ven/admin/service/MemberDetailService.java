package ven.admin.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ven.shop.action.Action;
import ven.shop.command.ActionCommand;
import ven.shop.dao.AdminDAO;
import ven.shop.model.MemberVO;

public class MemberDetailService implements Action {

	@Override
	public ActionCommand execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("MemberDetailService");
		AdminDAO adminDAO = new AdminDAO();
		MemberVO memberVO = new MemberVO();
		String mem_id = request.getParameter("mem_id");
		
		memberVO = adminDAO.getMemberDetail(mem_id);
		
		if (memberVO == null) {
			System.out.println("viewDetail fail");
			return null;
		}
		System.out.println("viewDetail ture");
		request.setAttribute("memberVO", memberVO);
		ActionCommand actionCommand = new ActionCommand();
		actionCommand.setRedirect(false);
		actionCommand.setPath("./admin/admin_member_detailview.jsp");
		return actionCommand;
	}

}

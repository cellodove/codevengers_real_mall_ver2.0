package ven.admin.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ven.shop.action.Action;
import ven.shop.command.ActionCommand;
import ven.shop.dao.AdminDAO;
import ven.shop.dao.MemberDAO;
import ven.shop.model.MemberVO;

public class ADMemberDeleteService implements Action {

	@Override
	public ActionCommand execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionCommand actionCommand = new ActionCommand();
		actionCommand.setRedirect(false);
		
		AdminDAO adminDAO = new AdminDAO();
		
		System.out.println("ADMemberDeleteService");
		String mem_id = request.getParameter("mem_id");
		
		MemberVO memberVO = new MemberVO();
		
		memberVO.setMem_id(mem_id);
		
		boolean idPassCK=adminDAO.ADmemberDelete(memberVO);

		
		if (idPassCK==false) {
			System.out.println("삭제실패");
			actionCommand.setPath("./member/member_delete.jsp");
			System.out.println("서비스 삭제실패");
			
			
		}else {
			System.out.println("회원삭제");
			actionCommand.setPath("./main/main.jsp");
			System.out.println("서비스 삭제성공");
			
		}
		return actionCommand;
	}

}

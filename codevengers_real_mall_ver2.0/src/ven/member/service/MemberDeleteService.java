package ven.member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ven.shop.action.Action;
import ven.shop.command.ActionCommand;
import ven.shop.dao.MemberDAO;
import ven.shop.model.MemberVO;

public class MemberDeleteService implements Action {

	@Override
	public ActionCommand execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionCommand actionCommand = new ActionCommand();
		actionCommand.setRedirect(false);
		
		MemberDAO memberDAO = new MemberDAO();
		System.out.println("MemberDeleteGoService");
		String mem_id = request.getParameter("mem_id");
		String mem_passwd = request.getParameter("mem_passwd");
		
		MemberVO memberVO = new MemberVO();
		
		memberVO.setMem_id(mem_id);
		memberVO.setMem_passwd(mem_passwd);
		
		memberDAO.memberDelete(memberVO);

		System.out.println(memberDAO.memberDelete(memberVO));
		
		if (memberDAO.memberDelete(memberVO)==false) {
			System.out.println("삭제실패");
			actionCommand.setPath("./member/member_delete.jsp");
			
		}else {
			System.out.println("회원삭제");
			actionCommand.setPath("./main/main.jsp");
		}
		
		return actionCommand;

	}

}

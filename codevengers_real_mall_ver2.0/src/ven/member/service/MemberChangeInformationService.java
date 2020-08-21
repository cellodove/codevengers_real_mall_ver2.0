package ven.member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ven.shop.action.Action;
import ven.shop.command.ActionCommand;
import ven.shop.dao.MemberDAO;
import ven.shop.model.MemberVO;

public class MemberChangeInformationService implements Action {

	@Override
	public ActionCommand execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("MemberChangeInformationService");
		MemberVO memberVO = new MemberVO();
		MemberDAO memberDAO = new MemberDAO();
		
		memberVO.setMem_id(request.getParameter("mem_id"));
		memberVO.setMem_passwd(request.getParameter("mem_passwd"));
		memberVO.setMem_name(request.getParameter("mem_name"));
		memberVO.setMem_birth(java.sql.Date.valueOf(request.getParameter("mem_birth")));
		memberVO.setMem_tel1(Integer.parseInt(request.getParameter("mem_tel1")));
		memberVO.setMem_tel2(Integer.parseInt(request.getParameter("mem_tel2")));
		memberVO.setMem_tel3(Integer.parseInt(request.getParameter("mem_tel3")));
		memberVO.setMem_zipcode(Integer.parseInt(request.getParameter("mem_zipcode")));
		memberVO.setMem_address1(request.getParameter("mem_address1"));
		memberVO.setMem_address2(request.getParameter("mem_address2"));
		memberVO.setMem_gender(request.getParameter("mem_gender"));
		memberVO.setMem_email(request.getParameter("mem_email"));
		memberVO.setMem_receive_email(request.getParameter("mem_receive_email"));
		memberVO.setMem_receive_sms(request.getParameter("mem_receive_sms"));
		
		memberDAO.memberInformationChange(memberVO);
		
		ActionCommand actionCommand = new ActionCommand();
		actionCommand.setRedirect(false);
		
		if (memberDAO.memberInformationChange(memberVO)==true) {
			System.out.println("회원수정 완료.");
			actionCommand.setPath("./main/main.jsp");
			
		}else {
			System.out.println("회원수정실패 다시시도해주세요.");
			actionCommand.setPath("./member/member_information.jsp");
		}
		
		return actionCommand;
	}

}

package ven.admin.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ven.shop.action.Action;
import ven.shop.command.ActionCommand;
import ven.shop.dao.AdminDAO;
import ven.shop.model.MemberVO;

public class MemberUpdateService implements Action {

	@Override
	public ActionCommand execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("MemberUpdateService");
		MemberVO memberVO = new MemberVO();
		AdminDAO adminDAO = new AdminDAO();
		
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
		memberVO.setMem_point(Integer.parseInt(request.getParameter("mem_point")));
		memberVO.setMem_grade(request.getParameter("mem_grade"));
		memberVO.setMem_adminmemo(request.getParameter("mem_adminmemo"));
		memberVO.setMem_manager(request.getParameter("mem_manager"));
		
		System.out.println(request.getParameter("mem_adminmemo"));
		
		
		
		adminDAO.ADmemberUpdate(memberVO);
		
		ActionCommand actionCommand = new ActionCommand();
		actionCommand.setRedirect(false);
		
		if (adminDAO.ADmemberUpdate(memberVO)==true) {
			System.out.println("회원수정 완료.");
			actionCommand.setPath("./admin/admin_main.jsp");
			
		}else {
			System.out.println("회원수정실패 다시시도해주세요.");
			actionCommand.setPath("./admin/admin_member_change_information.jsp");
		}
		
		return actionCommand;
	}

}

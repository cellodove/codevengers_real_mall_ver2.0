package ven.admin.service;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ven.shop.action.Action;
import ven.shop.command.ActionCommand;
import ven.shop.dao.AdminDAO;
import ven.shop.model.MemberVO;

public class GoAdminMemberChangeInformationService implements Action {

	@Override
	public ActionCommand execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("GoAdminMemberChangeInformationService");
		
		MemberVO memberVO = new MemberVO();
		AdminDAO adminDAO = new AdminDAO();
		
		String mem_id=request.getParameter("mem_id");
		System.out.println(request.getParameter("mem_id"));
		
		memberVO.setMem_id(mem_id);
		adminDAO.adminMemberInfoCall(memberVO);
		
		mem_id=memberVO.getMem_id();
		String mem_passwd = memberVO.getMem_passwd();
		String mem_name = memberVO.getMem_name();
		Date mem_birth = memberVO.getMem_birth();
		int mem_tel1 = memberVO.getMem_tel1();
		int mem_tel2 = memberVO.getMem_tel2();
		int mem_tel3 = memberVO.getMem_tel3();
		int mem_zipcode = memberVO.getMem_zipcode();
		String mem_address1 = memberVO.getMem_address1();
		String mem_address2 = memberVO.getMem_address2();
		String mem_gender = memberVO.getMem_gender();
		String mem_email = memberVO.getMem_email();
		String mem_email_ck = memberVO.getMem_email_ck();
		String mem_grade = memberVO.getMem_grade();
		int mem_point = memberVO.getMem_point();
		String mem_receive_email = memberVO.getMem_receive_email();
		String mem_receive_sms = memberVO.getMem_receive_sms();
		Date mem_register_datetime = memberVO.getMem_register_datetime();
		String mem_adminmemo = memberVO.getMem_adminmemo();
		String mem_group = memberVO.getMem_group();
		String mem_manager = memberVO.getMem_manager();
		
		request.setAttribute("mem_id", mem_id);
		request.setAttribute("mem_passwd", mem_passwd);
		request.setAttribute("mem_name", mem_name);
		request.setAttribute("mem_birth", mem_birth);
		request.setAttribute("mem_tel1", mem_tel1);
		request.setAttribute("mem_tel2", mem_tel2);
		request.setAttribute("mem_tel3", mem_tel3);
		request.setAttribute("mem_zipcode", mem_zipcode);
		request.setAttribute("mem_address1", mem_address1);
		request.setAttribute("mem_address2", mem_address2);
		request.setAttribute("mem_gender", mem_gender);
		request.setAttribute("mem_email", mem_email);
		request.setAttribute("mem_email_ck", mem_email_ck);
		request.setAttribute("mem_grade", mem_grade);
		request.setAttribute("mem_point", mem_point);
		request.setAttribute("mem_receive_email", mem_receive_email);
		request.setAttribute("mem_receive_sms", mem_receive_sms);
		request.setAttribute("mem_register_datetime", mem_register_datetime);
		request.setAttribute("mem_adminmemo", mem_adminmemo);
		request.setAttribute("mem_group", mem_group);
		request.setAttribute("mem_manager", mem_manager);
		
		System.out.println(mem_register_datetime);
		
		
		ActionCommand actionCommand = new ActionCommand();
		//리다이렉트안하니깐 포워드로하고
		actionCommand.setRedirect(false);
		//글목록 페이지로 이동한다.
		actionCommand.setPath("./admin/admin_member_change_information.jsp");
		//저 두개내용을 리턴해준다.
		return actionCommand;
	}

}

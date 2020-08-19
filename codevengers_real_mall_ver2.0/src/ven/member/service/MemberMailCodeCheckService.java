package ven.member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ven.shop.action.Action;
import ven.shop.command.ActionCommand;
import ven.shop.dao.MemberDAO;
import ven.shop.model.MemberVO;

public class MemberMailCodeCheckService implements Action {

	@Override
	public ActionCommand execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String authenticationUser = request.getParameter("mem_email_code");
		String authenticationKey = request.getParameter("email_code");
		String mem_email =  request.getParameter("mem_email");
		
		MemberVO memberVO = new MemberVO();
		MemberDAO memberDAO = new MemberDAO();
		ActionCommand actionCommand = new ActionCommand();
		
		System.out.println(authenticationKey);
		
		actionCommand.setRedirect(false);
		if(!authenticationKey.equals(authenticationUser))
        {
            System.out.println("인증번호 일치하지 않음");

            actionCommand.setPath("./member/member_email_check.jsp");
            return actionCommand;
        } else {
        	System.out.println("인증번호 일치");

        	memberVO.setMem_email(mem_email);
        	memberDAO.emailCheck(memberVO);
        	actionCommand.setPath("./main/main.jsp");
        	return actionCommand;
        }
	}

}

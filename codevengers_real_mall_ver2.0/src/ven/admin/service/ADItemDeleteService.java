package ven.admin.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ven.shop.action.Action;
import ven.shop.command.ActionCommand;
import ven.shop.dao.AdminDAO;
import ven.shop.model.MallItemVO;

public class ADItemDeleteService implements Action {

	@Override
	public ActionCommand execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionCommand actionCommand = new ActionCommand();
		actionCommand.setRedirect(false);
		
		AdminDAO adminDAO = new AdminDAO();
		
		MallItemVO mallItemVO = new MallItemVO();
		
		System.out.println("ADItemDeleteService");
		int item_num = Integer.parseInt(request.getParameter("item_num"));
		
		
		
		mallItemVO.setItem_num(item_num);
		
		boolean idPassCK=adminDAO.ADItemDelete(mallItemVO);

		
		if (idPassCK==false) {
			System.out.println("삭제실패");
			actionCommand.setPath("./member/member_delete.jsp");
			System.out.println("서비스 삭제실패");
			
			
		}else {
			System.out.println("회원삭제");
			actionCommand.setRedirect(true);
			actionCommand.setPath("./GoItemManagement.ko");
			System.out.println("서비스 삭제성공");
			
		}
		return actionCommand;
	}

}

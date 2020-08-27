package ven.admin.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ven.shop.action.Action;
import ven.shop.command.ActionCommand;
import ven.shop.dao.AdminDAO;
import ven.shop.model.MallItemVO;

public class GoItemUpdateService implements Action {

	@Override
	public ActionCommand execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
System.out.println("GoItemUpdateService");
		
		MallItemVO mallItemVO = new MallItemVO();
		AdminDAO adminDAO = new AdminDAO();
		

		int item_num = Integer.parseInt(request.getParameter("item_num"));
		mallItemVO=adminDAO.getItemDetail(item_num);
		
		if (mallItemVO == null) {
			System.out.println("goitemchange fail");
			return null;
		}
		
		System.out.println("goitemchange ture");
		request.setAttribute("mallItemVO", mallItemVO);
		
		ActionCommand actionCommand = new ActionCommand();
		//리다이렉트안하니깐 포워드로하고
		actionCommand.setRedirect(false);
		//글목록 페이지로 이동한다.
		actionCommand.setPath("./admin/admin_item_change_information.jsp");
		//저 두개내용을 리턴해준다.
		return actionCommand;
	}

}

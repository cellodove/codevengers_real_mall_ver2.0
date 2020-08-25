package ven.admin.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ven.shop.action.Action;
import ven.shop.command.ActionCommand;
import ven.shop.dao.AdminDAO;
import ven.shop.model.MallItemVO;

public class ADItemDetailService implements Action {

	@Override
	public ActionCommand execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("ADItemDetailService");
		
		MallItemVO mallItemVO = new MallItemVO();
		
		AdminDAO adminDAO = new AdminDAO();
		int item_num =Integer.parseInt(request.getParameter("item_num"));
		
		mallItemVO = adminDAO.getItemDetail(item_num);
		
		if (mallItemVO == null) {
			System.out.println("viewDetail fail");
			return null;
		}
		System.out.println("viewDetail ture");
		request.setAttribute("mallItemVO", mallItemVO);
		ActionCommand actionCommand = new ActionCommand();
		actionCommand.setRedirect(false);
		actionCommand.setPath("./admin/admin_item_detailview.jsp");
		return actionCommand;
	}

}

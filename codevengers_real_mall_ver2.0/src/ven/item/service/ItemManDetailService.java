package ven.item.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ven.shop.action.Action;
import ven.shop.command.ActionCommand;
import ven.shop.dao.ItemDAO;
import ven.shop.model.MallItemVO;

public class ItemManDetailService implements Action {

	@Override
	public ActionCommand execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ItemDAO itemDAO = new ItemDAO();
		MallItemVO mallItemVO = new MallItemVO();
		int num = Integer.parseInt(request.getParameter("item_num"));
		
		mallItemVO = itemDAO.getDetail(num);
		
		if (mallItemVO == null) {
			System.out.println("viewDetail fail");
			return null;
		}
		System.out.println("viewDetail ture");
		request.setAttribute("mallItemVO", mallItemVO);
		ActionCommand actionCommand = new ActionCommand();
		actionCommand.setRedirect(false);
		actionCommand.setPath("./item/item_detailview.jsp");
		return actionCommand;
		
		
		
	}

}

package ven.item.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ven.shop.action.Action;
import ven.shop.command.ActionCommand;
import ven.shop.dao.BoardDAO;
import ven.shop.dao.ItemDAO;

public class ItemManListService implements Action {

	@Override
	public ActionCommand execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("itemManListService come");
		ItemDAO itemDAO = new ItemDAO();
		List<?> itemManList = new ArrayList<Object>();
		int page = 1;
		int limit = 10;
		if (request.getParameter("page")!=null){
			page=Integer.parseInt(request.getParameter("page"));
		}
		int listcount = itemDAO.getManListCount();
		itemManList = itemDAO.getManList(page,limit);
		int maxpage = (int) ((double) listcount / limit + 0.95);
		int startpage = (((int) ((double) page / 10 + 0.9)) - 1) * 10 + 1;
		int endpage = startpage + 10 - 1;
		if (endpage > maxpage) {
			endpage = maxpage;
		}
		request.setAttribute("page", page);
		request.setAttribute("maxpage", maxpage);
		request.setAttribute("startpage", startpage);
		request.setAttribute("endpage", endpage);
		request.setAttribute("listcount", listcount);
		request.setAttribute("itemManList", itemManList);
		ActionCommand actionCommand = new ActionCommand();
		actionCommand.setRedirect(false);
		actionCommand.setPath("./item/item_man.jsp");
		return actionCommand;
	}
}

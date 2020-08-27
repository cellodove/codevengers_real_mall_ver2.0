package ven.admin.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import ven.shop.action.Action;
import ven.shop.command.ActionCommand;
import ven.shop.dao.AdminDAO;
import ven.shop.model.MallItemVO;

public class ItemUpdateService implements Action {

	@Override
	public ActionCommand execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("ItemUpdateService");
		
		MallItemVO mallItemVO = new MallItemVO();
		AdminDAO adminDAO = new AdminDAO();
		ActionCommand actionCommand = new ActionCommand();
		
		
		String realFolder = "";
		String saveFolder = "./images/product";
		
		realFolder = request.getSession().getServletContext().getRealPath(saveFolder);
		int fileSize = 5 * 2048 * 2048;
		boolean result = false;
		
		System.out.println(realFolder);
		
		try {
			MultipartRequest multipartRequest = new MultipartRequest(request, realFolder, fileSize, "UTF-8", new DefaultFileRenamePolicy());
			
			mallItemVO.setItem_num(Integer.parseInt(multipartRequest.getParameter("item_num")));
			mallItemVO.setItem_name(multipartRequest.getParameter("item_name"));
			mallItemVO.setItem_type(multipartRequest.getParameter("item_type"));
			mallItemVO.setItem_size(Integer.parseInt(multipartRequest.getParameter("item_size")));
			mallItemVO.setItem_gender(multipartRequest.getParameter("item_gender"));
			mallItemVO.setItem_maketime(java.sql.Date.valueOf(multipartRequest.getParameter("item_maketime")));
			mallItemVO.setItem_price(Integer.parseInt(multipartRequest.getParameter("item_price")));
			mallItemVO.setItem_remain(Integer.parseInt(multipartRequest.getParameter("item_remain")));
			mallItemVO.setItem_allnumber(Integer.parseInt(multipartRequest.getParameter("item_allnumber")));
			mallItemVO.setItem_summary(multipartRequest.getParameter("item_summary"));
			mallItemVO.setItem_picture(multipartRequest.getParameter("item_picture"));
			
			result=adminDAO.ADItemUpdate(mallItemVO);
			
			if (result == false) {
				System.out.println("상품수정 실패");
				return null;
			}
			System.out.println("상품수정 완료");
			actionCommand.setRedirect(true);
			actionCommand.setPath("./ADItemDetail.ko");
			return actionCommand;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}

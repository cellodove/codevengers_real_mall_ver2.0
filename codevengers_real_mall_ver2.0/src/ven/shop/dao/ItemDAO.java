package ven.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import ven.shop.model.MallItemVO;

public class ItemDAO {

	public int getManListCount() {
		System.out.println("getManListCount come");
		int i = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			String sql = "select count(man) from mall_item";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				i = resultSet.getInt(1);
			}
		} catch (Exception e) {
			System.out.println("manListCount Err");
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				System.out.println("manListCount DB Err");
				e.printStackTrace();
			}
		}
		return i;
	}
	
	
	public List<MallItemVO> getManList(int page, int limit) {
		System.out.println("getManList come");
		
		List<MallItemVO> list = new ArrayList<MallItemVO>();
		int startrow = (page - 1) * 10 + 1;
		int endrow = startrow + limit - 1;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			String sql = "select * from(select rownum rnum, item_num, item_name, item_type,item_gender,item_price,item_picture";
			sql+=" from (select * from count(man)))";
			sql+="where rnum>=? and rnum<=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, startrow);
			preparedStatement.setInt(2, endrow);
			resultSet = preparedStatement.executeQuery( );
			
			while (resultSet.next()) {
				MallItemVO mallItemVO = new MallItemVO();
				mallItemVO.setItem_num(resultSet.getInt("item_num"));
				mallItemVO.setItem_name(resultSet.getString("item_name"));
				mallItemVO.setItem_type(resultSet.getString("item_type"));
				mallItemVO.setItem_gender(resultSet.getString("item_gender"));
				mallItemVO.setItem_price(resultSet.getInt("item_price"));
				mallItemVO.setItem_picture(resultSet.getString("item_picture"));
				list.add(mallItemVO);
			}
			return list;
		} catch (Exception e) {
			System.out.println("getManList Err");
			e.printStackTrace();
		}finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				System.out.println("getManList DB Err");
				e.printStackTrace();
			}
		}
		return null;
	}


	public int getWomanListCount() {
		System.out.println("getWomanListCount come");
		int i = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			String sql = "select count(woman) from mall_item";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				i = resultSet.getInt(1);
			}
		} catch (Exception e) {
			System.out.println("WomanListCount Err");
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				System.out.println("WomanListCount DB Err");
				e.printStackTrace();
			}
		}
		return i;
	}

	
	
	public List<MallItemVO> getWomanList(int page, int limit) {
		System.out.println("getWomanList come");
		
		List<MallItemVO> list = new ArrayList<MallItemVO>();
		int startrow = (page - 1) * 10 + 1;
		int endrow = startrow + limit - 1;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			String sql = "select * from(select rownum rnum, item_num, item_name, item_type,item_gender,item_price,item_picture";
			sql+=" from (select * from count(woman)))";
			sql+="where rnum>=? and rnum<=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, startrow);
			preparedStatement.setInt(2, endrow);
			resultSet = preparedStatement.executeQuery( );
			
			while (resultSet.next()) {
				MallItemVO mallItemVO = new MallItemVO();
				mallItemVO.setItem_num(resultSet.getInt("item_num"));
				mallItemVO.setItem_name(resultSet.getString("item_name"));
				mallItemVO.setItem_type(resultSet.getString("item_type"));
				mallItemVO.setItem_gender(resultSet.getString("item_gender"));
				mallItemVO.setItem_price(resultSet.getInt("item_price"));
				mallItemVO.setItem_picture(resultSet.getString("item_picture"));
				list.add(mallItemVO);
			}
			return list;
		} catch (Exception e) {
			System.out.println("getWomanList Err");
			e.printStackTrace();
		}finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				System.out.println("getWomanList DB Err");
				e.printStackTrace();
			}
		}
		return null;
	}


	public MallItemVO getDetail(int num) {
		System.out.println("getDetail come");
		
		MallItemVO mallItemVO = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			Context context = new InitialContext( );
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection( );
			String sql = "select * from mall_item where item_num = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, num);
			resultSet = preparedStatement.executeQuery( );
			if (resultSet.next()) {
				mallItemVO = new MallItemVO();
				mallItemVO.setItem_num(resultSet.getInt("item_num"));
				mallItemVO.setItem_name(resultSet.getString("item_name"));
				mallItemVO.setItem_type(resultSet.getString("item_type"));
				mallItemVO.setItem_gender(resultSet.getString("item_gender"));
				mallItemVO.setItem_size(resultSet.getInt("item_size"));
				mallItemVO.setItem_price(resultSet.getInt("item_price"));
				mallItemVO.setItem_summary(resultSet.getString("item_summary"));
				mallItemVO.setItem_picture(resultSet.getString("itme_picture"));
				
	}
			return mallItemVO;
		} catch (Exception e) {
			System.out.println("getDetail Err");
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				System.out.println("getDetail DB Err");
				e.printStackTrace();
			}
		}
		return null;	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

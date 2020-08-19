package ven.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import ven.shop.model.MallItemVO;

public class ItemDAO {
	
	public ItemDAO() {
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			System.out.println(dataSource + "연결되었습니다!!");
		} catch (NamingException e) {
			System.out.println("DB 연결 실패 유감 ㅠㅠ");
			e.printStackTrace();
		}
	}

	public int getManListCount() {
		System.out.println("getManListCount dao come");
		int i = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			String sql = "select count(*) from mall_item where item_gender = 'man'";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				i = resultSet.getInt(1);
			}
		} catch (Exception e) {
			System.out.println("manListCount dao Err");
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				System.out.println("manListCount dao DB Err");
				e.printStackTrace();
			}
		}
		return i;
	}
	
	
	public List<MallItemVO> getManList(int page, int limit) {
		System.out.println("getManList dao come");
		
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
			sql+=" from (select * from mall_item where item_gender = 'man'))";
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
			System.out.println("getManList dao Err");
			e.printStackTrace();
		}finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				System.out.println("getManList dao DB Err");
				e.printStackTrace();
			}
		}
		return null;
	}


	public int getWomanListCount() {
		System.out.println("getWomanListCount dao come");
		int i = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			String sql = "select count(*) from mall_item where item_gender = 'woman'";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				i = resultSet.getInt(1);
			}
		} catch (Exception e) {
			System.out.println("WomanListCount dao Err");
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				System.out.println("WomanListCount dao DB Err");
				e.printStackTrace();
			}
		}
		return i;
	}

	
	
	public List<MallItemVO> getWomanList(int page, int limit) {
		System.out.println("getWomanList dao come");
		
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
			sql+=" from (select * from mall_item where item_gender = 'woman'))";
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
			System.out.println("getWomanList dao Err");
			e.printStackTrace();
		}finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				System.out.println("getWomanList dao DB Err");
				e.printStackTrace();
			}
		}
		return null;
	}


	public MallItemVO getDetail(int num) {
		System.out.println("getDetail dao come");
		
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
			System.out.println("getDetail dao Err");
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				System.out.println("getDetail dao DB Err");
				e.printStackTrace();
			}
		}
		return null;	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

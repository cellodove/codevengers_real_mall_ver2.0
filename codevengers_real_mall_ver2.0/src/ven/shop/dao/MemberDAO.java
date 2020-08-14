package ven.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import ven.shop.model.MemberVO;

public class MemberDAO {
	MemberVO memberVO = new MemberVO();
	
	public MemberDAO() {
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			System.out.println(dataSource + "connect");
		} catch (NamingException e) {
			System.out.println("DB connect fail");
			e.printStackTrace();
		}
	}

	public boolean loginCheck() {
		System.out.println("loginCheck DAO COME");
		
		String sql="";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		System.out.println(memberVO.getMem_id());
		System.out.println(memberVO.getMem_passwd());
		try {
			
			Context context = new InitialContext();
			DataSource dataSource = (DataSource)context.lookup("java:comp/env/jdbc");
			connection=dataSource.getConnection();
			
			sql="select mem_id, mem_passwd from member where mem_id = ? and mem_passwd = ? ";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, memberVO.getMem_id());
			preparedStatement.setString(2, memberVO.getMem_passwd());
			resultSet=preparedStatement.executeQuery();
			int result = preparedStatement.executeUpdate();
			
			if (result==0) {
				System.out.println("비밀번호나 아이디가 틀렸습니다.");
				return false;
			}else {
				System.out.println("로그인 되었습니다.");
				return true;
			}
		} catch (Exception e) {
			
			e.printStackTrace();
			
			}finally {
				try {
					resultSet.close();
					preparedStatement.close();
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return false;
	}

}

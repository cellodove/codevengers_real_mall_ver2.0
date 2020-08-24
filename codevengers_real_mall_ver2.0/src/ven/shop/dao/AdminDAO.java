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

import ven.shop.model.MemberVO;

public class AdminDAO {

	public boolean adminLoginCheck(MemberVO memberVO) {
		System.out.println("adminLoginCheck DAO COME");

		String sql = "";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		System.out.println(memberVO.getMem_id());
		System.out.println(memberVO.getMem_passwd());
		try {

			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();

			sql = "select mem_id from (select * from member where mem_id = ? and mem_passwd = ? and mem_manager = 'yes')";
			
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, memberVO.getMem_id());
			preparedStatement.setString(2, memberVO.getMem_passwd());
			resultSet = preparedStatement.executeQuery();
			int result = preparedStatement.executeUpdate();

			if (result == 0) {
				System.out.println("비밀번호나 아이디가 틀렸습니다.");
				return false;
			} else {
				System.out.println("관리자 로그인 되었습니다.");
				return true;
			}
		} catch (Exception e) {
			System.out.println("adminLoginCheck DAO error");
			e.printStackTrace();

		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				System.out.println("adminLoginCheck DAO DB error");
				e.printStackTrace();
			}
		}
		return false;
	}

	public List<?> getMemberList(int page, int limit) {
System.out.println("getManList dao come");
		
		List<MemberVO> list = new ArrayList<MemberVO>();
		int startrow = (page - 1) * 10 + 1;
		int endrow = startrow + limit - 1;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			String sql = "select * from(select rownum rnum, mem_num, mem_id, mem_passwd, mem_name, mem_birth, mem_tel1, mem_tel2, ";    
			sql	+= "mem_tel3, mem_zipcode, mem_address1, mem_address2, mem_gender, mem_email, mem_email_ck, mem_grade, mem_point, ";
			sql	+= "mem_receive_email, mem_receive_sms, mem_register_datetime, mem_adminmemo, mem_group, mem_manager";
			sql +=" from (select * from member))";
			sql +="where rnum>=? and rnum<=?";
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, startrow);
			preparedStatement.setInt(2, endrow);
			resultSet = preparedStatement.executeQuery( );
			
			while (resultSet.next()) {
				MemberVO memberVO = new MemberVO();
				memberVO.setMem_num(resultSet.getInt("mem_num"));
				memberVO.setMem_id(resultSet.getString("mem_id"));
				memberVO.setMem_passwd(resultSet.getString("mem_passwd"));
				memberVO.setMem_name(resultSet.getString("mem_name"));
				memberVO.setMem_birth(resultSet.getDate("mem_birth"));
				memberVO.setMem_tel1(resultSet.getInt("mem_tel1"));
				memberVO.setMem_tel2(resultSet.getInt("mem_tel2"));
				memberVO.setMem_tel3(resultSet.getInt("mem_tel3"));
				memberVO.setMem_zipcode(resultSet.getInt("mem_zipcode"));
				memberVO.setMem_address1(resultSet.getString("mem_address1"));
				memberVO.setMem_address2(resultSet.getString("mem_address2"));
				memberVO.setMem_gender(resultSet.getString("mem_gender"));
				memberVO.setMem_email(resultSet.getString("mem_email"));
				memberVO.setMem_email_ck(resultSet.getString("mem_email_ck"));
				memberVO.setMem_grade(resultSet.getString("mem_grade"));
				memberVO.setMem_point(resultSet.getInt("mem_point"));
				memberVO.setMem_receive_email(resultSet.getString("mem_receive_email"));
				memberVO.setMem_receive_sms(resultSet.getString("mem_receive_sms"));
				memberVO.setMem_register_datetime(resultSet.getDate("mem_register_datetime"));
				memberVO.setMem_adminmemo(resultSet.getString("mem_adminmemo"));
				memberVO.setMem_group(resultSet.getString("mem_group"));
				memberVO.setMem_manager(resultSet.getString("mem_manager"));
				
				list.add(memberVO);
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

	public int getMemberListCount() {
		System.out.println("getMemberListCount dao come");
		int i = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			String sql = "select count(*) from member ";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				i = resultSet.getInt(1);
			}
		} catch (Exception e) {
			System.out.println("getMemberListCount dao Err");
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				System.out.println("getMemberListCount dao DB Err");
				e.printStackTrace();
			}
		}
		return i;
	}

	
	public MemberVO getMemberDetail(String mem_id) {
		System.out.println("getMemberDetail dao come");
		
		MemberVO memberVO = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			Context context = new InitialContext( );
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection( );
			String sql = "select * from member where mem_id = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, mem_id);
			resultSet = preparedStatement.executeQuery( );
			if (resultSet.next()) {
				
				memberVO = new MemberVO();
				memberVO.setMem_num(resultSet.getInt("mem_num"));
				memberVO.setMem_id(resultSet.getString("mem_id"));
				memberVO.setMem_passwd(resultSet.getString("mem_passwd"));
				memberVO.setMem_name(resultSet.getString("mem_name"));
				memberVO.setMem_birth(resultSet.getDate("mem_birth"));
				memberVO.setMem_tel1(resultSet.getInt("mem_tel1"));
				memberVO.setMem_tel2(resultSet.getInt("mem_tel2"));
				memberVO.setMem_tel3(resultSet.getInt("mem_tel3"));
				memberVO.setMem_zipcode(resultSet.getInt("mem_zipcode"));
				memberVO.setMem_address1(resultSet.getString("mem_address1"));
				memberVO.setMem_address2(resultSet.getString("mem_address2"));
				memberVO.setMem_gender(resultSet.getString("mem_gender"));
				memberVO.setMem_email(resultSet.getString("mem_email"));
				memberVO.setMem_email_ck(resultSet.getString("mem_email_ck"));
				memberVO.setMem_grade(resultSet.getString("mem_grade"));
				memberVO.setMem_point(resultSet.getInt("mem_point"));
				memberVO.setMem_receive_email(resultSet.getString("mem_receive_email"));
				memberVO.setMem_receive_sms(resultSet.getString("mem_receive_sms"));
				memberVO.setMem_register_datetime(resultSet.getDate("mem_register_datetime"));
				memberVO.setMem_adminmemo(resultSet.getString("mem_adminmemo"));
				memberVO.setMem_group(resultSet.getString("mem_group"));
				memberVO.setMem_manager(resultSet.getString("mem_manager"));
				
	}
			return memberVO;
		} catch (Exception e) {
			System.out.println("getMemberDetail dao Err");
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				System.out.println("getMemberDetail dao DB Err");
				e.printStackTrace();
			}
		}
		return null;	
	}


	
	
	
	
	
	
	
	
	
	
	
	
}

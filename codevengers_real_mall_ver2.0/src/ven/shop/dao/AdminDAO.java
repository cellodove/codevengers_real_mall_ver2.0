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

	public boolean adminMemberInfoCall(MemberVO memberVO) {
		System.out.println("memberInfoCall dao");
		String sql = "";

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();

			sql = "select mem_id,mem_passwd,mem_name,mem_birth,mem_tel1,mem_tel2,mem_tel3,mem_zipcode,mem_address1,mem_address2,mem_gender,mem_email,mem_email_ck,mem_grade,mem_point,mem_receive_email,mem_receive_sms,mem_register_datetime, mem_adminmemo, mem_group, mem_manager from member";
			sql += " where mem_id = ?";

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, memberVO.getMem_id());

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
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
				
				
				System.out.println("dao" + " " + resultSet.getDate("mem_register_datetime"));

			}
			return true;
		} catch (Exception e) {
			System.out.println("memberInfo dao error");
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				System.out.println("memberInfo dao db error");
				e.printStackTrace();
			}
		}
		return false;
		
	}

	public boolean ADmemberUpdate(MemberVO memberVO) {
		System.out.println("ADmemberUpdate dao come");
		String sql = "";
		int result = 0;

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();

			sql = "update member set mem_passwd=?,mem_name=?,mem_birth=?,mem_tel1=?,mem_tel2=?,mem_tel3=?,mem_zipcode=?,mem_address1=?,mem_address2=?,mem_gender=?,mem_email=?,mem_receive_email=?,mem_receive_sms=?,mem_point=?,mem_grade=?,mem_adminmemo=?,mem_manager=?";
			sql += " where mem_id=?";

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, memberVO.getMem_passwd());
			preparedStatement.setString(2, memberVO.getMem_name());
			preparedStatement.setDate(3, memberVO.getMem_birth());
			preparedStatement.setInt(4, memberVO.getMem_tel1());
			preparedStatement.setInt(5, memberVO.getMem_tel2());
			preparedStatement.setInt(6, memberVO.getMem_tel3());
			preparedStatement.setInt(7, memberVO.getMem_zipcode());
			preparedStatement.setString(8, memberVO.getMem_address1());
			preparedStatement.setString(9, memberVO.getMem_address2());
			preparedStatement.setString(10, memberVO.getMem_gender());
			preparedStatement.setString(11, memberVO.getMem_email());
			preparedStatement.setString(12, memberVO.getMem_receive_email());
			preparedStatement.setString(13, memberVO.getMem_receive_sms());
			preparedStatement.setInt(14, memberVO.getMem_point());
			preparedStatement.setString(15, memberVO.getMem_grade());
			preparedStatement.setString(16, memberVO.getMem_adminmemo());
			preparedStatement.setString(17,memberVO.getMem_manager());
			
			preparedStatement.setString(18, memberVO.getMem_id());

			result = preparedStatement.executeUpdate();
			if (result == 0) {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			System.out.println("ADmemberUpdate dao error");
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				System.out.println("ADmemberUpdate dao DB error");
				e.printStackTrace();
			}
		}
		return false;
		
	}

	public boolean ADmemberDelete(MemberVO memberVO) {
		System.out.println("ADmemberDelete dao come");
		String sql = "";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		int result = 0;

		System.out.println(memberVO.getMem_id());

		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();

			sql = "delete from member where mem_id = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, memberVO.getMem_id());
			
			result = preparedStatement.executeUpdate();

			if (result == 1) {
				System.out.println("DB회원삭제되었습니다.");
				System.out.println("dao 삭제성공");
				return true;
			}else {
				System.out.println("dao 삭제실패");
				return false;
			}
		} catch (Exception e) {
			System.out.println("ADmemberDelete dao error");
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				System.out.println("ADmemberDelete dao DB error");
				e.printStackTrace();
			}
		}
		return false;
	}

	public List<?> getItemList(int page, int limit) {
		System.out.println("getItemList dao come");
		
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
			String sql = "select * from (select rownum rnum, item_num, item_name, item_type, item_gender, ";
			sql	+= "item_price, item_remain,item_allnumber,item_picture from mall_item) ";
			sql +="where rnum>=? and rnum<=?";
			
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
				mallItemVO.setItem_remain(resultSet.getInt("item_remain"));
				mallItemVO.setItem_allnumber(resultSet.getInt("item_allnumber"));
				mallItemVO.setItem_picture(resultSet.getString("item_picture"));
				list.add(mallItemVO);
			}
			return list;
		} catch (Exception e) {
			System.out.println("getItemList dao Err");
			e.printStackTrace();
		}finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				System.out.println("getItemList dao DB Err");
				e.printStackTrace();
			}
		}
		return null;
	}

	public boolean ADItemDelete(MallItemVO mallItemVO) {
		System.out.println("ADItemDelete dao come");
		String sql = "";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		int result = 0;


		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();

			sql = "delete from mall_Item where item_num = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, mallItemVO.getItem_num());
			
			result = preparedStatement.executeUpdate();

			if (result == 1) {
				System.out.println("DB상품삭제되었습니다.");
				System.out.println("dao 삭제성공");
				return true;
			}else {
				System.out.println("dao 삭제실패");
				return false;
			}
		} catch (Exception e) {
			System.out.println("ADItemDelete dao error");
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				System.out.println("ADItemDelete dao DB error");
				e.printStackTrace();
			}
		}
		return false;
	}

	public boolean itemInsert(MallItemVO mallItemVO) {
		int num = 0;
		String sql = "";
		int result = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			sql = "select max(item_num) from mall_item";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				num = resultSet.getInt(1) + 1;
			} else {
				num = 1;
			}
			preparedStatement.close();
			sql = "insert into mall_item (item_num,item_name,item_type,item_gender,item_maketime,item_price,item_remain,item_allnumber,item_summary,item_date,item_picture )";
			sql += " values(?,?,?,?,?,?,?,?,?,sysdate,?)";
		
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, num);
			preparedStatement.setString(2, mallItemVO.getItem_name());
			preparedStatement.setString(3, mallItemVO.getItem_type());
			preparedStatement.setString(4, mallItemVO.getItem_gender());
			preparedStatement.setDate(5,mallItemVO.getItem_maketime());
			preparedStatement.setInt(6, mallItemVO.getItem_price());
			preparedStatement.setInt(7, mallItemVO.getItem_remain());
			preparedStatement.setInt(8, mallItemVO.getItem_allnumber());
			preparedStatement.setString(9, mallItemVO.getItem_summary());
			preparedStatement.setString(10, mallItemVO.getItem_picture());
			
			result = preparedStatement.executeUpdate();
			if (result == 0) {
				return false;
			}
			return true;
		} catch (Exception e) {
			System.out.println("글 등록 실패!:");
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

	public MallItemVO getItemDetail(int item_num) {
		System.out.println("getItemDetail dao come");
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			Context context = new InitialContext( );
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection( );
			String sql = "select * from mall_item where item_num = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, item_num);
			resultSet = preparedStatement.executeQuery( );
			if (resultSet.next()) {
				
				MallItemVO mallItemVO = new MallItemVO();
				
				mallItemVO.setItem_num(resultSet.getInt("item_num"));
				mallItemVO.setItem_name(resultSet.getString("item_name"));
				mallItemVO.setItem_type(resultSet.getString("item_type"));
				mallItemVO.setItem_size(resultSet.getInt("item_size"));
				mallItemVO.setItem_gender(resultSet.getString("item_gender"));
				mallItemVO.setItem_maketime(resultSet.getDate("item_maketime"));
				mallItemVO.setItem_price(resultSet.getInt("item_price"));
				mallItemVO.setItem_remain(resultSet.getInt("item_remain"));
				mallItemVO.setItem_allnumber(resultSet.getInt("item_allnumber"));
				mallItemVO.setItem_summary(resultSet.getString("item_summary"));
				mallItemVO.setItem_date(resultSet.getDate("item_date"));
				mallItemVO.setItem_picture(resultSet.getString("item_picture"));
				
				return mallItemVO;
			
	}
			
		} catch (Exception e) {
			System.out.println("getItemDetail dao Err");
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				System.out.println("getItemDetail dao DB Err");
				e.printStackTrace();
			}
		}
		return null;	
	}

	public boolean ADItemUpdate(MallItemVO mallItemVO) {
		System.out.println("ADItemUpdate dao come");
		String sql = "";
		int result = 0;

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();

			sql = "update mall_item set item_name=?,item_type=?,item_size=?,item_gender=?,item_maketime=?,item_price=?,item_remain=?,item_allnumber=?,item_summary=?,item_picture=?";
			sql += " where item_num=?";

			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, mallItemVO.getItem_name());
			preparedStatement.setString(2, mallItemVO.getItem_type());
			preparedStatement.setString(3, mallItemVO.getItem_gender());
			preparedStatement.setInt(4, mallItemVO.getItem_size());
			preparedStatement.setDate(5, mallItemVO.getItem_maketime());
			preparedStatement.setInt(6, mallItemVO.getItem_price());
			preparedStatement.setInt(7, mallItemVO.getItem_remain());
			preparedStatement.setInt(8, mallItemVO.getItem_allnumber());
			preparedStatement.setString(9, mallItemVO.getItem_summary());
			preparedStatement.setString(10, mallItemVO.getItem_picture());
			preparedStatement.setInt(11, mallItemVO.getItem_num());


			result = preparedStatement.executeUpdate();
			if (result == 0) {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			System.out.println("ADItemUpdate dao error");
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				System.out.println("ADItemUpdate dao DB error");
				e.printStackTrace();
			}
		}
		return false;
	}


	
	
	
	
	
	
	
	
	
	
	
	
}

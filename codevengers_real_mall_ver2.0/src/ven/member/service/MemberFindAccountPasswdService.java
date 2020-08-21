package ven.member.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ven.shop.action.Action;
import ven.shop.command.ActionCommand;
import ven.shop.dao.MemberDAO;
import ven.shop.model.MemberVO;

public class MemberFindAccountPasswdService implements Action {

	@Override
	public ActionCommand execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberVO memberVO = new MemberVO();
		MemberDAO memberDAO = new MemberDAO();
		System.out.println("MemberFindAccountService passwd Come");
		
		
		
		ActionCommand actionCommand = new ActionCommand();
		boolean result = false;
		
		
		try {
			System.out.println(request.getParameter("mem_id"));
			System.out.println(request.getParameter("mem_name"));
			System.out.println(request.getParameter("mem_birth"));
			
			memberVO.setMem_id(request.getParameter("mem_id"));
			memberVO.setMem_name(request.getParameter("mem_name"));
			memberVO.setMem_birth(java.sql.Date.valueOf(request.getParameter("mem_birth")));
			
			result = memberDAO.memberFindNameBirthPasswd(memberVO);
			
			if (result == false) {
				System.out.println("계정을 찾을수없습니다.");				
				actionCommand.setRedirect(false);
				actionCommand.setPath("./member/member_find_passwd.jsp");
				
			}else {
				System.out.println(memberVO.getMem_id());
				System.out.println(memberVO.getMem_passwd());
				System.out.println(memberVO.getMem_email());
				
				
				String mem_passwd = memberVO.getMem_passwd();		
				String mem_email = memberVO.getMem_email();

				// mail server 설정
				String host = "smtp.naver.com";
				String user = "vividcello@naver.com"; // 자신의 네이버 계정
				String password = "zheldwjtm123?";// 자신의 네이버 패스워드

				// 메일 받을 주소
				/* String to_email = m.getEmail(); */
				String to_email = mem_email;

				// SMTP 서버 정보를 설정한다.
				Properties props = new Properties();
				props.put("mail.smtp.host", host);
				props.put("mail.smtp.port", 465);
				props.put("mail.smtp.auth", "true");
				props.put("mail.smtp.ssl.enable", "true");
				props.put("mail.smtp.starttls.enable", "true");
				props.put("mail.debug", "true");

				
				
				Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(user, password);
					}
				});
				
				// email 전송
				try {
					MimeMessage msg = new MimeMessage(session);
					msg.setFrom(new InternetAddress(user, "Codevengers shop"));
					msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to_email));

					// 메일 제목
					msg.setSubject("안녕하세요  코딩져스 회원 비밀번호입니다.");
					// 메일 내용
					msg.setText("비밀번호는 :" + mem_passwd + " " + "입니다.");
					Transport.send(msg);
					System.out.println("이메일 전송");
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				System.out.println("이메일이 전송되었습니다.");			
				actionCommand.setRedirect(false);
				actionCommand.setPath("./member/member_login.jsp");
				
				System.out.println();
				
			}

		} catch (Exception e) {
			
		}

		return actionCommand;
	}

}

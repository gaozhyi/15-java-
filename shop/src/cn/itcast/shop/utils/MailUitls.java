package cn.itcast.shop.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUitls {
	/**
	 * 发送邮件的方法
	 * @param to	:收件人
	 * @param code	:激活码
	 */
	public static void sendMail(String to,String code){
		/**
		 * 1.获得一个Session对象.
		 * 2.创建一个代表邮件的对象Message.
		 * 3.发送邮件Transport
		 */
		// 1.获得连接对象
		Properties props = new Properties();
		// 设置邮件服务器
		props.put("mail.host","smtp.163.com" );
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", true);
		final String from = "你的163邮箱";
		final String pwd = "邮箱密码";
		Session session = Session.getInstance(props, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, pwd);
			}
			
		});
		// 2.创建邮件对象:
		Message message = new MimeMessage(session);
		// 设置发件人:
		try {
			message.setFrom(new InternetAddress(from));
			// 设置收件人:
			message.addRecipient(RecipientType.TO, new InternetAddress(to));
			// 抄送 CC   密送BCC
			// 设置标题
			message.setSubject("来自网上商城官方激活邮件");
			// 设置邮件正文:
			message.setContent("<h1>网上商城官方激活邮件!点下面链接完成激活操作!</h1><h3><a href='http://localhost:8080/shop/user_active.action?code="+code+"'>http://localhost:8080/shop/user_active.action?code="+code+"</a></h3>", "text/html;charset=UTF-8");
			// 3.发送邮件:
			Transport.send(message);
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		sendMail("965421625@qq.com","11111111111111");
	}
}

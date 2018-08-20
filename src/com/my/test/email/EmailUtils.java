package com.my.test.email;

import java.util.Date;
import java.util.Properties;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailUtils {
//	private static String HOST = "smtp.gmail.com";
//	
//	private static String USERNAME = "nftcoin@gmail.com";
//	
//	private static String PASSWORD = "nft66668888";
//	
//	private static String FROM = "nftcoin@gmail.com";	
	
//////////////////////////////////////////////////////////////////
	
//	private static String HOST = "smtp.gmail.com";
//	
//	private static String USERNAME = "bravecarsonyan@gmail.com";
//	
//	private static String PASSWORD = "XML19930823";
//	
//	private static String FROM = "bravecarsonyan@gmail.com";
//	
//////////////////////////////////////////////////////////////////
	
	private static String HOST = "smtp.qq.com";
	
	private static String USERNAME = "424194899@qq.com";
	
	private static String PASSWORD = "tebyjrziyhzlbgjh";
	
	private static String FROM = "424194899@qq.com";
	
//////////////////////////////////////////////////////////////////
	
	private static String TO = "yan_shuai@163.com";
	
	private static String TO2 = "424194899@qq.com";
	
	private static String CC = "424194899@qq.com";
	
	private static String BCC = "424194899@qq.com";
	
	private static String SUBJECT = "Test";
	
	private static String CONTENT = "Hello world :-)";

	public static void main(String[] args) throws Exception {
		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.smtp.host", HOST);
		props.setProperty("mail.smtp.auth", "true");
		props.setProperty("mail.smtp.port", "465");
		props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.setProperty("mail.smtp.socketFactory.fallback", "false");
		props.setProperty("mail.smtp.socketFactory.port", "465");
		Session session = Session.getDefaultInstance(props);
		session.setDebug(true);
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(FROM, "", "UTF-8"));
		message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(TO, "", "UTF-8"));
		message.addRecipient(MimeMessage.RecipientType.TO, new InternetAddress(TO2, "USER_DD", "UTF-8"));
        message.setRecipient(MimeMessage.RecipientType.CC, new InternetAddress(CC, "USER_EE", "UTF-8"));
        message.setRecipient(MimeMessage.RecipientType.BCC, new InternetAddress(BCC, "USER_FF", "UTF-8"));
        message.setSubject(SUBJECT, "UTF-8");
		message.setContent(CONTENT, "text/html;charset=UTF-8");
		message.setSentDate(new Date());
		message.saveChanges();
		Transport transport = session.getTransport();
		transport.connect(USERNAME, PASSWORD);
		transport.sendMessage(message, message.getAllRecipients());
		transport.close();
	}
}

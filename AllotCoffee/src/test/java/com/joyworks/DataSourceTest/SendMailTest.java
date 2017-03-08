package com.joyworks.DataSourceTest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import com.joyworks.service.SendMailService;


public class SendMailTest {

	ApplicationContext ioc = new ClassPathXmlApplicationContext("apllication-context.xml");

	@Test
	public void test02(){
		SendMailService bean = ioc.getBean(SendMailService.class);
		List<String> recipients = new ArrayList<>();
		recipients.add("zhuliang6520@163.com");
		recipients.add("2031434350@qq.com");
		String subject= "TEST";
		String content = "测试为多人发送邮件";
		bean.send(recipients, subject, content);
		System.out.println("发送成功");
	}
	
	@Test
	public void test01(){
		MailSender mailSender = ioc.getBean(MailSender.class);
		SimpleMailMessage simpleMailMessage = ioc.getBean(SimpleMailMessage.class);
		 simpleMailMessage.setTo("zhuliang6520@163.com");  
	     simpleMailMessage.setSubject("异常");  
	     simpleMailMessage.setText("数据库连接失败");  
	     mailSender.send(simpleMailMessage); 
	     System.out.println("发送完成");
	
	}
}

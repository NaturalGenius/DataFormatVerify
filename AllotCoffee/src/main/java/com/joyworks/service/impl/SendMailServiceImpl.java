package com.joyworks.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.joyworks.service.SendMailService;

@Service
public class SendMailServiceImpl implements SendMailService {

	@Autowired
	private MailSender mailSender;

	@Autowired
	private SimpleMailMessage simpleMailMessage;

	@Override
	public void send(String recipient, String subject, String content) {
		simpleMailMessage.setTo(recipient);
		simpleMailMessage.setSubject(subject);
		simpleMailMessage.setText(content);
		mailSender.send(simpleMailMessage);
	}

	@Override
	public void send(List<String> recipients, String subject, String content) {
		simpleMailMessage.setTo(recipients.toArray(new String[recipients.size()]));
		simpleMailMessage.setSubject(subject);
		simpleMailMessage.setText(content);
		mailSender.send(simpleMailMessage);
	}
}

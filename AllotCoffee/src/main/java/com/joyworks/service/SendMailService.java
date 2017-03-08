package com.joyworks.service;

import java.util.List;

/**
 * 发送邮件的服务
 * @author joyworks
 *
 */
public interface SendMailService {
	/** 
     * 单发 
     * 
     * @param recipient 收件人 
     * @param subject 主题 
     * @param content 内容 
     */ 
	void send(String recipient,String subject,String content);
	/** 
     * 群发 
     * 
     * @param recipients 收件人 
     * @param subject 主题 
     * @param content 内容 
     */  
	void send(List<String> recipients,String subject,String content);
}

package com.joyworks.service;

import java.util.List;

/**
 * 发送邮件的服务
 * @author zhuliang
 *
 */
public interface SendMailService {
	/** 
     * 为单个人发送邮件
     * 
     * @param recipient 收件人 
     * @param subject 主题 
     * @param content 内容 
     */ 
	void send(String recipient,String subject,String content);
	/** 
     * 为多人发送文件 
     * 
     * @param recipients 收件人 (多个)
     * @param subject 主题 
     * @param content 内容 
     */  
	void send(List<String> recipients,String subject,String content);
}

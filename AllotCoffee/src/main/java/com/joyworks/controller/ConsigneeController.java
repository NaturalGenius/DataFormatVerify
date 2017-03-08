package com.joyworks.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.joyworks.entity.Consignee;
import com.joyworks.entity.Page;
import com.joyworks.service.ConsigneeService;
import com.joyworks.service.SendMailService;
import com.joyworks.util.VerifyFieldUtil;

/**
 * 处理收货人相关请求的控制器
 * 
 * @author 朱亮
 *
 */
@Controller
@RequestMapping("/user")
public class ConsigneeController {

	@Autowired
	private ConsigneeService consigneeService;
	
	@Autowired
	private SendMailService sendMailService;

	/**
	 * 此方法用于分页查询收获着信息
	 * 
	 * @param pageNo
	 *            当前页码
	 * @param map
	 * @return 当前页面所有的用户信息
	 */
	@RequestMapping("/getPageConsignee")
	public String listPageConsigneeMessage(@RequestParam(value = "pageNo", required = false) String pageNo,
			Map<String, Object> map) {
		Page<Consignee> page = consigneeService.listPageConsigneeMessage(pageNo);
		map.put("page", page);
		return "listConsignee";
	}

	/**
	 * 为用户非配咖啡
	 * 
	 * @param consignee
	 *            收货人信息
	 * @param response
	 *            分配成功，响应分配咖啡成功的信息 分配失败，响应分配咖啡失败的信息
	 */
	@RequestMapping("/getCoffee")
	@ResponseBody
	public void getCoffee(Consignee consignee, HttpServletResponse response) {
		// 验证用户传入数据格式是否正确,message等于null说明 数据正确
		String message = VerifyFieldUtil.verifyConsigneeMessage(consignee);
		response.setContentType("text/html;charset=UTF-8");
		if (message == null) {

			try {
				boolean flag = consigneeService.getCoffee(consignee);
				if (flag) {
					try {
						response.getWriter().write("成功获得咖啡");
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else {
					try {
						response.getWriter().write("咖啡已售完");
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			} catch (RuntimeException e) {
				String recipient = "zhuliang6520@163.com";
				String subject = "数据库连接中断";
				String info = e.getMessage();
				String content = info+"数据库出现故障，请速处理";
				//出异常说明数据库连接失败，需要发送邮件告知管理者
				sendMailService.send(recipient, subject, content);
				try {
					response.getWriter().write("操作失败，请重新操作");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			
		} else {
			try {
				response.getWriter().write(message);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	/**
	 * 跳转到表单
	 * 
	 * @return
	 */
	@RequestMapping("/tosubmitform")
	public String toFormPage() {
		return "formpage";
	}

}

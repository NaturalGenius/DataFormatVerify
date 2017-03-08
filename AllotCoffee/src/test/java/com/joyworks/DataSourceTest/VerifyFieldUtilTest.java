package com.joyworks.DataSourceTest;

import org.junit.Test;

import com.joyworks.entity.Consignee;
import com.joyworks.util.VerifyFieldUtil;

public class VerifyFieldUtilTest {
	@Test
	public void test01(){
		Consignee consignee = new Consignee("", "北京", "相信地址", "18341893858", "zhuliang@joyworks.com.cn", "74641");
		String message = VerifyFieldUtil.verifyConsigneeMessage(consignee);
		System.out.println(message);
		
	}
}

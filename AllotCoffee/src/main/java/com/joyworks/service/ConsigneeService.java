package com.joyworks.service;

import com.joyworks.entity.Consignee;
import com.joyworks.entity.Page;
/**
 * 分配咖啡的接口
 * @author zhuliang
 *
 */
public interface ConsigneeService {

	/**
	 * 是否分配到了咖啡
	 * @param user
	 * @return
	 */
	boolean getCoffee(Consignee user);
	/**
	 * 此方法用于分页查询收获着信息
	 * @param pageNo 当前页
	 * @return 
	 * 当前页面所有的收货者的信息
	 */
	Page<Consignee> listPageConsigneeMessage(String pageNo);

}

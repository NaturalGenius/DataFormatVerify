package com.joyworks.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.joyworks.entity.Consignee;

/**
 * 此接口用于持久化收货人相关的信息
 * @author joyworks
 *
 */
public interface ConsigneeDao {
	/**
	 * 此方法用于保存收货人相关信息
	 * @param consignee
	 * @return
	 */
	Integer saveConsignee(Consignee consignee);

	/**
	 * 查询总共有多少收货者
	 * @return
	 */
	Integer getToatlCount();

	/**
	 * 查询当前页面收货者的信息信息
	 * @param start
	 * @param pageSize
	 * @return
	 */
	List<Consignee> listPageConsigneeMessage(@Param("start")Integer Start, @Param("pageSize")Integer pageSize);
}

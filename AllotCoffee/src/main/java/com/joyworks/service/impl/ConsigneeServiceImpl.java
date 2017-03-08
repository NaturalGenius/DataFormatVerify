package com.joyworks.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joyworks.dao.ConsigneeDao;
import com.joyworks.entity.Consignee;
import com.joyworks.entity.Page;
import com.joyworks.exception.DatabaseConnectFailedException;
import com.joyworks.finalmessage.CommonFiledConstant;
import com.joyworks.finalmessage.ExceptionMessage;
import com.joyworks.service.ConsigneeService;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Transaction;

@Service
public class ConsigneeServiceImpl implements ConsigneeService {

	@Autowired
	private JedisPool jedisPool;
	
	@Autowired
	private ConsigneeDao consineeDao;
	@Override
	public boolean getCoffee(Consignee consignee) {
		
		Jedis jedis = jedisPool.getResource();
		String coffeeCount = CommonFiledConstant.COFFEE_COUNT;
		if (jedis != null) {

			jedis.watch("coffeecount");
			Integer num = Integer.parseInt(jedis.get(coffeeCount));
		
			if (num.intValue() == 0) {
				jedis.unwatch();
				jedis.close();
				return false;
			} else {
				while (true) {
					num = Integer.parseInt(jedis.get(coffeeCount));
					if (num.intValue() == 0) {
						jedis.unwatch();
						jedis.close();
						return false;
					} else {
						Transaction transaction = jedis.multi();
						transaction.decr(coffeeCount);
						List<Object> list = transaction.exec();
						if (list != null) {
							// 保存用户信息
							//1.用户第一次保存时，将其的创建和修改时间设置为相同的
							consignee.setCreateTime(new Date());
							consignee.setModifyTime(new Date());
							//保存用户信息到数据库中
							try {
								consineeDao.saveConsignee(consignee);
								jedis.close();
								return true;
							} catch (Exception e) {
								jedis.incr(coffeeCount);
								jedis.close();
								throw new DatabaseConnectFailedException(ExceptionMessage.MYSQL_DOWN);
							}
						}
					}
				}
			}
		}
		throw new DatabaseConnectFailedException(ExceptionMessage.REDIS_DOWN);
	}
	@Override
	public Page<Consignee> listPageConsigneeMessage(String pageNo) {
		//查询数据库中总的记录数
		Integer totalRecoards=consineeDao.getToatlCount();
		//创建页面对象
		Page<Consignee> page = new Page<>(pageNo, totalRecoards, CommonFiledConstant.PAGE_SIZE);
		
		//查询当前页面收货者信息
		Integer pageSize = page.getPageSize();
		
		List<Consignee> list=consineeDao.listPageConsigneeMessage((page.getPageNo() - 1)* pageSize, pageSize);
		
		page.setPages(list);
		
		return page;
	}

}

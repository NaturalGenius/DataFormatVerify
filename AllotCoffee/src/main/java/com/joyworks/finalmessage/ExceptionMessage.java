package com.joyworks.finalmessage;

/**
 * 主要保存一些异常提示信息
 * @author joyworks
 *
 */
public class ExceptionMessage {
	private ExceptionMessage(){}
	public static final String REDIS_DOWN = "redis缓存数据库连接异常";
	public static final String MYSQL_DOWN = "mysql 数据库数据库连接异常";
}

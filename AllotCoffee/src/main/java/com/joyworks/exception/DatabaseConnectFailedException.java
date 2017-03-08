package com.joyworks.exception;
/**
 * 数据库连接失败的异常
 * @author joyworks
 *
 */
public class DatabaseConnectFailedException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	public DatabaseConnectFailedException(String message){
		super(message);
	}
}

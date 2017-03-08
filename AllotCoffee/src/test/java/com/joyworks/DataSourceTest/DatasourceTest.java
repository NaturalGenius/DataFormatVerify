package com.joyworks.DataSourceTest;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class DatasourceTest {

	ApplicationContext ioc = new ClassPathXmlApplicationContext("apllication-context.xml");
	
	
	@Test
	public void test06(){
		//验证邮编
		Pattern p = Pattern.compile("[1-9]\\d{5}");     
		Matcher m = p.matcher("7464101");
		
		System.out.println(m.matches());
	}
	@Test
	public void test05(){
		//验证电话格式
		Pattern p = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$");     
        Matcher m = p.matcher("18341893858");
		
		System.out.println(m.matches());
	}
	@Test
	public void test04(){
		//验证邮箱格式
		Pattern pattern = Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");

		Matcher matcher = pattern.matcher("");
		
		System.out.println(matcher.matches());
	}
	
	@Test
	public void test03(){
		JedisPool bean = ioc.getBean(JedisPool.class);
		Jedis resource = bean.getResource();
		String ping = resource.ping();
		System.out.println(ping);
	}
	@Test
	public  void test01() throws SQLException{
		DataSource bean = ioc.getBean(DataSource.class);
		System.out.println(bean.getConnection());
	}
	@Test
	public  void test02() {
		Jedis jedis = new Jedis("192.168.222.128", 6379);
		String ping = jedis.ping();
		System.out.println(ping);
		jedis.close();
	}
}

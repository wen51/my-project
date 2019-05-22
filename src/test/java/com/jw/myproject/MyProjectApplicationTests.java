package com.jw.myproject;

import com.jw.myproject.dao.RedisDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyProjectApplicationTests {

	@Resource
	private RedisDAO redisDAO;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testRedis(){
//		redisDAO.setKey("name", "jiawen");
//		redisDAO.setKey("age", "18");
        System.out.println(redisDAO.getValue("*"));
        System.out.println(redisDAO.getValue("age"));
	}
}


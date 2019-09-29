package com.jw.myproject;

import com.jw.myproject.dao.RedisDAO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyProjectApplicationTests {

	@Resource
	private RedisDAO redisDAO;

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

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

	public void testRedisString(){
		stringRedisTemplate.opsForValue().set("aaa", "111");
        Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
	}
}


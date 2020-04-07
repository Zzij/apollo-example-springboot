package com.zz.apollo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zz.apollo.config.ApolloConfigMyTest;
import com.zz.apollo.config.ApolloConfigRedis;
import com.zz.apollo.config.ApolloConfigWeb;

@RestController
@RequestMapping(value = "apollo")
public class ApolloConfigController {

	@Autowired
	private ApolloConfigRedis redis;
	
	@Autowired
	private ApolloConfigWeb web;
	
	@Autowired
	private ApolloConfigMyTest myTest;
	
	@Value("${applicationName}")
	private String applicationName;
	
	@Value("${app.name.test}")
	private String cache;
	
	@GetMapping("redis")
	public ApolloConfigRedis getRedis() {
		System.out.println(redis == null);
		System.out.println(redis.getHost());
		System.out.println(redis.getPort());
		return redis;
	}
	
	@GetMapping("web")
	public ApolloConfigWeb getWeb() {
		return web;
	}
	
	@GetMapping("value")
	public String getValue() {
		return applicationName + cache;
	}
	
	@GetMapping("mytest")
	public String getMy() {
		System.out.println(myTest);
		return myTest.toString();
	}

}

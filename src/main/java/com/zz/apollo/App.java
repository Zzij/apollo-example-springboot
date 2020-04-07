package com.zz.apollo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;

@SpringBootApplication
@EnableApolloConfig
@EnableConfigurationProperties
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}

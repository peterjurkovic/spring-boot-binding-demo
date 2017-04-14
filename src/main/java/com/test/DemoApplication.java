package com.test;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.test.config.Props;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	
	@Component
	static class MyBean{
	    
	    @Autowired Props props;
	    
	    @PostConstruct
	    public void print(){
	        System.out.println(props);
	    }
	}
}

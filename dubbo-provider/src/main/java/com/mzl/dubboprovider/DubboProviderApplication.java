package com.mzl.dubboprovider;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import java.util.concurrent.CountDownLatch;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class DubboProviderApplication {

	public static void main(String[] args) throws InterruptedException{
		SpringApplication.run(DubboProviderApplication.class, args);
		new CountDownLatch(1).await(); //hold住应用，防止provider退出
	}
	
}

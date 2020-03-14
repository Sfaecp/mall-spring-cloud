package com.lbx.mall.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import tk.mybatis.spring.annotation.MapperScan;

@MapperScan(basePackages = "com.lbx.mall.order.mapper")
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class OrderApplication extends SpringBootServletInitializer
{
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(OrderApplication.class);
	}
	
    public static void main( String[] args )
    {
        SpringApplication.run(OrderApplication.class, args);
    }
}

package com.selfservice;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SelfServiceApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder().bannerMode(Banner.Mode.OFF).sources(SelfServiceConfig.class).build().run(args);
	}
}

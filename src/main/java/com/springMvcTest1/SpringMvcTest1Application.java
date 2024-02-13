package com.springMvcTest1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // 컴포넌트/모듈 스캔해서 빈 등록
public class SpringMvcTest1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcTest1Application.class, args);
	}

}

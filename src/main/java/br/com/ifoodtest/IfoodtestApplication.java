package br.com.ifoodtest;

import feign.Contract;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class IfoodtestApplication {

	public static void main(String[] args) {
		SpringApplication.run(IfoodtestApplication.class, args);
	}


	@Bean
	public Contract feignContract() {
		return new Contract.Default();
	}
}

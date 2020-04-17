package io.github.brenovit.torrebrasil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class TorrebrasilApplication {

	public static void main(String[] args) {
		SpringApplication.run(TorrebrasilApplication.class, args);
	}

}

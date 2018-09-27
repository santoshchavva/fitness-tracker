/**
 * 
 */
package com.sdet.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//extends SpringBootServletInitializer
@SpringBootApplication
@EntityScan(basePackages= {"com.sdet.model"})
@ComponentScan(basePackages= {"com.sdet.model","com.sdet.presentation","com.sdet.services","com.sdet.dao"})
@EnableJpaRepositories(basePackages= {"com.sdet.dao","com.sdet.model"})
public class Application  {

	
	/*@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    } */
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(Application.class, args);
	}

}

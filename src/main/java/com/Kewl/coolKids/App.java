package com.Kewl.coolKids;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

/**
 * Hello world!
 *
 */
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class, FlywayAutoConfiguration.class })
@SpringBootApplication(exclude={
	DataSourceAutoConfiguration.class,
	HibernateJpaAutoConfiguration.class,
	RedisAutoConfiguration.class
})
public class App 
{
    public static void main( String[] args )
    {
    	System.setProperty("es.set.netty.runtime.available.processors", "false");
		SpringApplication.run(App.class, args);
    }
}

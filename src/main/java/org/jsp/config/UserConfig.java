package org.jsp.config;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.SessionAttributes;

@Configuration
@ComponentScan("org.jsp")
public class UserConfig {
	@Bean
public EntityManager getEntityManager() {
	return Persistence.createEntityManagerFactory("dev").createEntityManager();
}
}

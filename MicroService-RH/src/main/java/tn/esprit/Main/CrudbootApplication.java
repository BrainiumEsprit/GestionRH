package tn.esprit.Main;





import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@ComponentScan({"tn.esprit.Controller","tn.esprit.Service"})
@EntityScan("tn.esprit.Class")
@EnableJpaRepositories("tn.esprit.Repository")
@SpringBootApplication
public class CrudbootApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(CrudbootApplication.class, args);
	}
	
	/**
	 * Save demo users, courses and students to H2 DB
	 * @param repository
	 * @return
	 */

	
}

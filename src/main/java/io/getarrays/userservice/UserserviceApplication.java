package io.getarrays.userservice;

import io.getarrays.userservice.domain.Role;
import io.getarrays.userservice.domain.Member;
import io.getarrays.userservice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class UserserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}

	@Bean
	CommandLineRunner run (UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPERADMIN"));

			userService.saveUser(new Member(null, "Janek", "junker", "1234", new ArrayList<>()));
			userService.saveUser(new Member(null, "Sali", "toporek", "1234", new ArrayList<>()));
			userService.saveUser(new Member(null, "Willie", "tuptus", "1234", new ArrayList<>()));
			userService.saveUser(new Member(null, "Szrama", "szramiasty", "1234", new ArrayList<>()));

			userService.AddRoleToUser("junker", "ROLE_USER");
			userService.AddRoleToUser("junker", "ROLE_MANAGER");
			userService.AddRoleToUser("toporek", "ROLE_ADMIN");
			userService.AddRoleToUser("szramiasty", "ROLE_SUPERADMIN");
		};
	}
}

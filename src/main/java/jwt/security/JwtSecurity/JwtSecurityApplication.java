package jwt.security.JwtSecurity;

import jwt.security.JwtSecurity.domain.Role;
import jwt.security.JwtSecurity.domain.User;
import jwt.security.JwtSecurity.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class JwtSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtSecurityApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run (UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null, "Imad TTomi", "imad", "12345", new ArrayList<>()));
			userService.saveUser(new User(null, "Ahmed Arouchdi", "ahmed", "12345", new ArrayList<>()));
			userService.saveUser(new User(null, "Morad Ali", "morad", "12345", new ArrayList<>()));
			userService.saveUser(new User(null, "Mohammed abgar", "mohammed", "12345", new ArrayList<>()));

			userService.addRoleToUser("imad", "ROLE_USER");
			userService.addRoleToUser("imad", "ROLE_MANAGER");
			userService.addRoleToUser("ahmed", "ROLE_MANAGER");
			userService.addRoleToUser("morad", "ROLE_ADMIN");
			userService.addRoleToUser("mohammed", "ROLE_USER");
			userService.addRoleToUser("mohammed", "ROLE_MANAGER");
			userService.addRoleToUser("mohammed", "ROLE_ADMIN");
			userService.addRoleToUser("mohammed", "ROLE_SUPER_ADMIN");


		};
	}
}

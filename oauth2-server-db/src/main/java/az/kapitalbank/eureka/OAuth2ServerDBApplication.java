package az.kapitalbank.eureka;


import az.kapitalbank.eureka.entity.Role;
import az.kapitalbank.eureka.entity.UserSystem;
import az.kapitalbank.eureka.repository.RoleRepository;
import az.kapitalbank.eureka.repository.UserSystemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;
import java.util.Collection;

@SpringBootApplication
@EnableDiscoveryClient
@EnableJpaRepositories({"com.kapitalbank.repository"})
@EntityScan({"com.kapitalbank.entity"})
@ComponentScan("com.kapitalbank")
public class OAuth2ServerDBApplication {

	public static void main(String[] args) {
		SpringApplication.run(OAuth2ServerDBApplication.class, args);
	}
	
	@Bean
	CommandLineRunner init(UserSystemRepository userSystemRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
		return args -> {
			initUsers(userSystemRepository, roleRepository, passwordEncoder);
		};
	}

	private void initUsers(UserSystemRepository userSystemRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
		
		Role role = roleRepository.findByDescription("Admin");

		if (role == null) {
			role = Role.builder()
					.description("Admin")
					.build();

			role = roleRepository.save(role);
		}

		UserSystem userSystem = userSystemRepository.findByEmail("ronnie.lopes@esales.com.br");

		if(userSystem == null) {
			userSystem = UserSystem.builder()
					.name("ronnie")
					.email("ronnie.lopes@esales.com.br")
					.password(passwordEncoder.encode("@123"))
					.roles(Arrays.asList(role))
					.build();

			userSystemRepository.save(userSystem);
		}

		final Iterable<UserSystem> itUserSystems = userSystemRepository.findAll();

		if(((Collection<?>) itUserSystems).size() < 30) {
			for(long i=2; i<=30; i++) {
				userSystem = UserSystem.builder()
						.name("ronnie" + i)
						.email("ronnie.lopes-" + i + "@esales.com.br")
						.password(passwordEncoder.encode("@123"))
						.roles(Arrays.asList(role))
						.build();

				userSystemRepository.save(userSystem);
			}
		}
	}

}
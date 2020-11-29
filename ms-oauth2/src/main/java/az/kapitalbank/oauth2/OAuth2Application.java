package az.kapitalbank.oauth2;


import az.kapitalbank.common.entity.Role;
import az.kapitalbank.common.entity.UserSystem;
import az.kapitalbank.common.repository.RoleRepository;
import az.kapitalbank.common.repository.UserSystemRepository;
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
@EnableJpaRepositories({"az.kapitalbank.common.repository"})
@EntityScan({"az.kapitalbank.common.entity"})
@ComponentScan("az.kapitalbank")
public class OAuth2Application {

	public static void main(String[] args) {
		SpringApplication.run(OAuth2Application.class, args);
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

		UserSystem userSystem = userSystemRepository.findByEmail("irkan.ehmedov@gmail.com");

		if(userSystem == null) {
			userSystem = UserSystem.builder()
					.name("irkan")
					.email("irkan.ehmedov@gmail.com")
					.password(passwordEncoder.encode("@123"))
					.roles(Arrays.asList(role))
					.build();

			userSystemRepository.save(userSystem);
		}

		final Iterable<UserSystem> itUserSystems = userSystemRepository.findAll();

		if(((Collection<?>) itUserSystems).size() < 30) {
			for(long i=2; i<=30; i++) {
				userSystem = UserSystem.builder()
						.name("irkan" + i)
						.email("irkan.ehmedov-" + i + "@gmail.com")
						.password(passwordEncoder.encode("@123"))
						.roles(Arrays.asList(role))
						.build();

				userSystemRepository.save(userSystem);
			}
		}
	}

}
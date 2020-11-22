package az.kapitalbank.eureka;

import az.kapitalbank.eureka.entity.Product;
import az.kapitalbank.eureka.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Collection;
import java.util.Optional;

@SpringBootApplication
@EnableDiscoveryClient
@EnableJpaRepositories({"com.kapitalbank.repository"})
@EntityScan({"com.kapitalbank.entity"})
@ComponentScan("com.kapitalbank")
public class RestProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestProductApplication.class, args);
	}

	@Bean
	CommandLineRunner init(ProductRepository productRepository) {
		return args -> {
			initUsers(productRepository);
		};
	}

	private void initUsers(ProductRepository productRepository) {
		final Optional<Product> optionalProduct = productRepository.findById(1L);

		if(optionalProduct.isEmpty()) {
			final Product product = Product.builder()
					.name("Product Example")
					.build();

			productRepository.save(product);
		}

		Product product = null;
		final Iterable<Product> itProducts = productRepository.findAll();

		if(((Collection<?>) itProducts).size() < 30) {
			for(long i=2; i<=30; i++) {
				product = Product.builder()
						.name("Product Example " + i)
						.build();

				productRepository.save(product);
			}
		}
	}

}

package mark.warren93.dev.WarriorsFootballAssociationapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@ComponentScan
public class WarriorsFootballAssociationApiApplication {
	private static final Logger logger = LoggerFactory.getLogger(WarriorsFootballAssociationApiApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(WarriorsFootballAssociationApiApplication.class, args);
	}
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		logger.info("Configuring Cors");
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/api/v1/**")
						.allowedOrigins("*")
						.allowedMethods("GET", "POST", "PUT", "DELETE")
						.allowedHeaders("*")
						.allowCredentials(false).maxAge(3600);
			}
		};
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		logger.info("Configuring security...");
		http
				.csrf(csrf -> csrf.disable()) // Disable CSRF protection
				.authorizeHttpRequests(authorize ->
						authorize
								.requestMatchers("/**").permitAll() // Allow all requests without authentication
				)
				.formLogin(formLogin ->
						formLogin.disable() // Disable form-based login
				)
				.httpBasic(httpBasic ->
						httpBasic.disable() // Disable HTTP Basic authentication
				);
		return http.build();
	}
}
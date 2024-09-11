package em.dio.daycare_management_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@OpenAPIDefinition
@SpringBootApplication
public class DaycareManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(DaycareManagementSystemApplication.class, args);
	}
}

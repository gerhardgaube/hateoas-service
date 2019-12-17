package payroll;

import lombok.extern.slf4j.Slf4j;

import org.aspectj.bridge.MessageUtil;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
class LoadDatabase {

	@Bean
	CommandLineRunner initDatabase(EmployeeRepository repository) {
		return args -> {
			MessageUtil log;
			MessageUtil.info("Preloading " + repository.save(new Employee("Donald", "Duck", "employee")));
			MessageUtil.info("Preloading " + repository.save(new Employee("Dagobert", "Duck", "president")));
		};
	}
}

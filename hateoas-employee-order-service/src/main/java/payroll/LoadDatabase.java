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
	CommandLineRunner initDatabase(EmployeeRepository employeeRepository,
								   OrderRepository orderRepository) {
		return args -> {
			employeeRepository.save(new Employee("Bilbo", "Baggins", "burglar"));
			employeeRepository.save(new Employee("Frodo", "Baggins", "thief"));

			employeeRepository.findAll().forEach(employee -> {
				MessageUtil.info ("Preloaded " + employee);
			});

			// tag::order[]
			orderRepository.save(new Order("MacBook Pro", Status.COMPLETED));
			orderRepository.save(new Order("iPhone", Status.IN_PROGRESS));

			orderRepository.findAll().forEach(order -> {
				MessageUtil.info("Preloaded " + order);
			});
			// end::order[]
		};
	}
}

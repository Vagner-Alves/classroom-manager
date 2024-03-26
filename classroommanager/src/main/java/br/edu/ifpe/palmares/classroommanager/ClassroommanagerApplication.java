package br.edu.ifpe.palmares.classroommanager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import br.edu.ifpe.palmares.classroommanager.domain.Car;
import br.edu.ifpe.palmares.classroommanager.domain.CarRepository;

@SpringBootApplication
public class ClassroommanagerApplication implements CommandLineRunner {
	private static final Logger logger =
			LoggerFactory.getLogger(
					ClassroommanagerApplication.class
			);
	private final CarRepository repository;
	public ClassroommanagerApplication(CarRepository repository) {
		this.repository = repository;

	public static void main(String[] args) {

		SpringApplication.run(ClassroommanagerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {}


		// CardataseApplication.java run method
		@Override
		public void run(String... args) throws Exception {
			repository.save(new Car("Ford", "Mustang", "Red",
					"ADF-1121", 2023, 59000));
			repository.save(new Car("Nissan", "Leaf", "White",
					"SSJ-3002", 2020, 29000));
			repository.save(new Car("Toyota", "Prius",
					"Silver", "KKO-0212", 2022, 39000));
			// Fetch all cars and log to console
			for (Car car : repository.findAll()) {
				logger.info("brand: {}, model: {}",
						car.getBrand(), car.getModel());
			}
}

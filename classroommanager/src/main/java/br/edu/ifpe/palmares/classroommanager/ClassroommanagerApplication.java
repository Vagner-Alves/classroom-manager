package br.edu.ifpe.palmares.classroommanager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import com.packt.cardatabase.domain.Car;
import com.packt.cardatabase.domain.CarRepository;

@SpringBootApplication
public class ClassroommanagerApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(ClassroommanagerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {}
}

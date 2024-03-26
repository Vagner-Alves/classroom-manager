package br.edu.ifpe.palmares.classroommanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class ClassroommanagerApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(ClassroommanagerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {}
}

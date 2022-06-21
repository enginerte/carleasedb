package org.demo.carlease;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.demo.carlease.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CarleaseApplication {
	@Autowired	
	private CarRepository repository;

	@Autowired	
	private OwnerRepository orepository;

	@Autowired	
	private UserRepository urepository;


	public static void main(String[] args) {
		SpringApplication.run(CarleaseApplication.class, args);
	}
	@JsonIgnore

	@Bean
	CommandLineRunner runner() {
		return args -> {
			Owner owner1 = new Owner("Kees" , "Hoek");
			Owner owner2 = new Owner("Jan" , "Smit");
			orepository.save(owner1);
			orepository.save(owner2);
			
			repository.save(new Car("Toyota", "Aygo", "X", "5", "25kg", 25500, 55555, owner1));
			repository.save(new Car("BMW", "525", "tdi", "5", "36kg", 44444, 64343));
			repository.save(new Car("Toyota", "Prius", "X", "5", "55kg", 39000, 45454, owner2));
			
			urepository.save(new User("badmin", "$2fsdfs$1.YhMIgNX/8TkCfsdfsUONWO1waedKhQ5KrnB30fl0Q01QKqmzLf.Zi", "USER"));
			urepository.save(new User("admin", "$2fsdfsdKNLfsdfsLiBjb9Tk9bfdsfdsI12ICuvzXQQKG", "ADMIN"));
		};
	}	
}

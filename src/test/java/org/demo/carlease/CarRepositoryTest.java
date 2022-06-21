package org.demo.carlease;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import org.demo.carlease.domain.Car;
import org.demo.carlease.domain.CarRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CarRepositoryTest {
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private CarRepository repository;
	
	@Test
	public void saveCar() {
		Car car = new Car("Toyota", "Aygo", "X", "5", "25kg", 25500, 55555);
		entityManager.persistAndFlush(car);
		
		assertThat(car.getId()).isNotNull();
	}
	
	@Test
	public void deleteCars() {
		entityManager.persistAndFlush(new Car("Toyota", "Aygo", "X", "5", "25kg", 25500, 55555));
		entityManager.persistAndFlush(new Car("BMW", "525", "tdi", "5", "36kg", 44444, 64343));
		
		repository.deleteAll();
		assertThat(repository.findAll()).isEmpty();
	}	

}

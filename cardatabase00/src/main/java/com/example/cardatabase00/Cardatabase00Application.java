package com.example.cardatabase00;

import com.example.cardatabase00.entity.Car;
import com.example.cardatabase00.entity.Owner;
import com.example.cardatabase00.repository.CarRepository;
import com.example.cardatabase00.repository.OwnerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class Cardatabase00Application implements CommandLineRunner {

	private final CarRepository carRepository;
	private final OwnerRepository ownerRepository;

    public Cardatabase00Application(CarRepository carRepository, OwnerRepository ownerRepository) {
        this.carRepository = carRepository;
        this.ownerRepository = ownerRepository;
    }

    public static void main(String[] args) {
		SpringApplication.run(Cardatabase00Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Owner owner0 = new Owner("김", "영");
		Owner owner1 = new Owner("김", "일");

		ownerRepository.saveAll(Arrays.asList(owner0, owner1));

		carRepository.save(new Car("현대", "소나타", "검정", "123가4567", 2026, 30000000, owner0));
		carRepository.save(new Car("기아", "K9", "흰색", "987나5432", 2025, 20000000, owner1));
		carRepository.save(new Car("람보르기니", "쿤타치", "빨강", "159다7532", 2010, 130000000, owner1));
	}
}

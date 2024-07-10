package com.example.laptopStore.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.laptopStore.dto.LaptopDTO;
import com.example.laptopStore.entity.Laptop;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long>{
	List<Laptop> findByName(String name);

	List<Laptop> findByPrice(Double price);

	List<Laptop> findByBrand(String brand);
	
	

}

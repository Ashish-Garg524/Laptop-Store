package com.example.laptopStore.service;

import java.util.*;

import org.springframework.stereotype.Service;

import com.example.laptopStore.dto.LaptopDTO;

import jakarta.validation.Valid;

@Service
public interface LaptopService {

	List<LaptopDTO> getAllLaptop();

	LaptopDTO createLaptop(LaptopDTO laptopDTO);

	LaptopDTO getLaptopById(Long id);

	LaptopDTO updateLaptop(LaptopDTO laptopDTO, Long id);

	Map<String, Boolean> delete(Long id);

	List<LaptopDTO> searchLaptopByName(String name);
	
	List<LaptopDTO> searchLaptopByPrice(Double price);
	
	List<LaptopDTO> searchLaptopByBrand(String brand);
	
	
	

}

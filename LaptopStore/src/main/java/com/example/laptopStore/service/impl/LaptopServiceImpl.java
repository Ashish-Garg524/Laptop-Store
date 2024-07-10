package com.example.laptopStore.service.impl;

import java.util.*;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.laptopStore.dto.LaptopDTO;
import com.example.laptopStore.entity.Laptop;

import com.example.laptopStore.service.LaptopService;
import com.example.laptopStore.repository.LaptopRepository;

import com.example.laptopStore.exception.ResourceNotFoundException;

@Service
public class LaptopServiceImpl implements LaptopService {

	private final LaptopRepository laptopRepository;
	private final ModelMapper modelMapper;
	
	
	public LaptopServiceImpl(LaptopRepository laptopRepository, ModelMapper modelMapper) {
		super();
		this.laptopRepository = laptopRepository;
		this.modelMapper = modelMapper;
	}


	@Override
	public List<LaptopDTO> getAllLaptop() {
		return laptopRepository.findAll()
				.stream()
				.map(laptop -> modelMapper.map(laptop,LaptopDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public LaptopDTO createLaptop(LaptopDTO laptopDTO) {
		Laptop laptop = modelMapper.map(laptopDTO, Laptop.class);
		Laptop savedLaptop = laptopRepository.save(laptop);
		return modelMapper.map(savedLaptop, LaptopDTO.class);
	}

	@Override
	public LaptopDTO getLaptopById(Long id) {
		return laptopRepository.findById(id)
				.map(laptop -> modelMapper.map(laptop,LaptopDTO.class))
				.orElseThrow(() -> new ResourceNotFoundException("Laptop Not found with id: "+ id));
			
	}


	@Override
	public LaptopDTO updateLaptop(LaptopDTO laptopDTO, Long id) {
		return laptopRepository.findById(id)
				.map(laptop ->{
					laptop.setName(laptopDTO.getName());
					laptop.setBrand(laptopDTO.getName());
					laptop.setPrice(laptopDTO.getPrice());
					laptop.setProcessor(laptopDTO.getProcessor());
					laptop.setRam(laptopDTO.getRam());
					laptop.setStorage(laptopDTO.getStorage());
					Laptop updatedLaptop = laptopRepository.save(laptop);
					return modelMapper.map(updatedLaptop, LaptopDTO.class);
				})
				.orElseThrow(() -> new ResourceNotFoundException("Laptop Not found with id: "+ id));
	}

	@Override
	public Map<String, Boolean> delete(Long id) {
		return laptopRepository.findById(id)
				.map(laptop -> {
						laptopRepository.delete(laptop);
						Map<String, Boolean> response = new HashMap<>();
						response.put("Laptop Deleted", Boolean.TRUE);
						return response;
				})
				.orElseThrow(() -> new ResourceNotFoundException("Laptop Not found with id: "+ id));
				
	}


	@Override
	public List<LaptopDTO> searchLaptopByName(String name) {
		return laptopRepository.findByName(name)
				.stream()
				.map(laptop -> modelMapper.map(laptop,LaptopDTO.class))
				.collect(Collectors.toList());
	}


	@Override
	public List<LaptopDTO> searchLaptopByPrice(Double price) {
		return laptopRepository.findByPrice(price)
				.stream()
				.map(laptop -> modelMapper.map(laptop,LaptopDTO.class))
				.collect(Collectors.toList());
	}


	@Override
	public List<LaptopDTO> searchLaptopByBrand(String brand) {
		return laptopRepository.findByBrand(brand)
				.stream()
				.map(laptop -> modelMapper.map(laptop,LaptopDTO.class))
				.collect(Collectors.toList());
	}

	
	

}















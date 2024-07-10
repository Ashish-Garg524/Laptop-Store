package com.example.laptopStore.dto;

import jakarta.validation.constraints.*;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class LaptopDTO {
	
	
	public LaptopDTO() {
		super();
	}

	public LaptopDTO(Long id, @NotBlank @Size(min = 3, max = 20) String name, @NotNull @Min(0) @Max(9999) Double price,
			@NotBlank String brand, @NotBlank String storage, @NotBlank String ram, @NotBlank String processor) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.brand = brand;
		this.storage = storage;
		this.ram = ram;
		this.processor = processor;
	}

	private Long id;
	
	@NotBlank
	@Size(min=3, max = 20)
	private String name;
	
	@NotNull
	@Min(0)
	@Max(9999)
	private Double price;
	
	@NotBlank
	private String brand;
	
	@NotBlank
	private String storage;
	
	@NotBlank
	private String ram;
	
	@NotBlank
	private String processor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getStorage() {
		return storage;
	}

	public void setStorage(String storage) {
		this.storage = storage;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getProcessor() {
		return processor;
	}

	public void setProcessor(String processor) {
		this.processor = processor;
	}
	
	

}

package com.example.laptopStore.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import com.example.laptopStore.dto.LaptopDTO;
import com.example.laptopStore.entity.Laptop;
import com.example.laptopStore.service.LaptopService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/laptops")
@CrossOrigin
public class LaptopController {
	
	private final LaptopService laptopService;

	public LaptopController(LaptopService laptopService) {
		super();
		this.laptopService = laptopService;
	}
	
	@GetMapping()
	public ResponseEntity<List<LaptopDTO>> getAllLaptop() {
		List<LaptopDTO> laptops = laptopService.getAllLaptop();
		return new ResponseEntity<>(laptops,HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<LaptopDTO> createLaptop(@Valid @RequestBody LaptopDTO laptopDTO){
		LaptopDTO savedLaptop = laptopService.createLaptop(laptopDTO);
		return new ResponseEntity<>(savedLaptop,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<LaptopDTO> getLaptopById(@PathVariable("id") Long id){
		LaptopDTO laptopDTO = laptopService.getLaptopById(id);
		return new ResponseEntity<>(laptopDTO,HttpStatus.OK);
	}
	
// There are some extra line of code which is used to display custom message when the validation of provided JSON data is failed .
//	@PutMapping("/{id}")
//	public ResponseEntity<?> updateLaptop(@PathVariable("id") Long id, @Valid @RequestBody LaptopDTO laptopdto, BindingResult result){
//		List<String> displayErrors = new ArrayList<String>();
//		
//		if (result.hasErrors()) {
//			List<FieldError> errors = result.getFieldErrors();
//			
//			for(FieldError err:errors) {
//				displayErrors.add(err.getField() + ": " + err.getDefaultMessage());
//				System.out.println( displayErrors);
//			}
//			
//			return ResponseEntity.badRequest().body(displayErrors);
//		}
//		
//		LaptopDTO laptop = laptopService.updateLaptop(id, laptopdto);
//		return new ResponseEntity<>(laptop, HttpStatus.OK);
//		
//	}
	
	@PutMapping("/{id}")
	public ResponseEntity<LaptopDTO> updateLaptop(@Valid @RequestBody LaptopDTO laptopDTO, @PathVariable Long id) {
		LaptopDTO updatedLaptop = laptopService.updateLaptop(laptopDTO, id);
		return new ResponseEntity<>(updatedLaptop,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String,Boolean>> delete(@PathVariable("id") Long id){
		Map<String,Boolean> response = laptopService.delete(id);
		return new ResponseEntity<>(response,HttpStatus.OK);
		
	}
	
	@GetMapping("/search")
	public ResponseEntity<List<LaptopDTO>> searchLaptop(
	        @RequestParam(value = "name", required = false) String name,
	        @RequestParam(value = "price", required = false) Double price,
	        @RequestParam(value = "brand", required = false) String brand) {
	    
	    List<LaptopDTO> laptops = new ArrayList<>();
	    
	    if (name != null) {
	        laptops = laptopService.searchLaptopByName(name);
	    } else if (price != null) {
	        laptops = laptopService.searchLaptopByPrice(price);
	    } else if (brand != null) {
	        laptops = laptopService.searchLaptopByBrand(brand);
	    } else {
	        // Handle case where no parameters are provided
	        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	    }

	    return new ResponseEntity<>(laptops, HttpStatus.OK);
	}


}


































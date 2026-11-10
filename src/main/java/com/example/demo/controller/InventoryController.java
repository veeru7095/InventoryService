package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.InventoryDto;
import com.example.demo.DTO.ProductResponseDto;
import com.example.demo.Entity.InventoryEntity;
import com.example.demo.Repository.InventoryRepository;
import com.example.demo.service.InventoryService;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

	
	private final InventoryService inventoryService;
	private final InventoryRepository inventoryRepository;
	
	public InventoryController(InventoryService inventoryService,InventoryRepository inventoryRepository) {
		this.inventoryRepository=inventoryRepository;
		this.inventoryService=inventoryService;
	}
	
	@PostMapping("/addproduct")
	public InventoryDto addproduct(@RequestBody InventoryDto inventoryDto) {
		return inventoryService.addProduct(inventoryDto);
	}
	
	@GetMapping("/getProduct/{id}")
	public ProductResponseDto getProduct(@PathVariable Long id) {
		return inventoryService.getProductById(id);
	}
	
}

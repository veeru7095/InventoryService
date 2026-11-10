package com.example.demo.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.InventoryDto;
import com.example.demo.DTO.ProductResponseDto;
import com.example.demo.Entity.InventoryEntity;
import com.example.demo.Repository.InventoryRepository;

@Service
public class InventoryService {
	
	@Autowired
	private final ModelMapper modelMapper;
	
	@Autowired
	private final InventoryRepository inventoryRepository;

	public InventoryService(ModelMapper modelMapper, InventoryRepository inventoryRepository) {
		this.modelMapper=modelMapper;
		this.inventoryRepository = inventoryRepository;
	}
	
	public InventoryDto addProduct(InventoryDto inventoryDto) {
		InventoryEntity inv=modelMapper.map(inventoryDto, InventoryEntity.class);
		InventoryEntity savedInv=inventoryRepository.save(inv);
		return modelMapper.map(savedInv, InventoryDto.class);
	}
	
	
	
	public ProductResponseDto getProductById(Long id) {
		InventoryEntity product=inventoryRepository.findById(id).orElseThrow(
				() -> new RuntimeException("Product is not found by id "+id));
		
		ProductResponseDto responseDto=modelMapper.map(product, ProductResponseDto.class);
		
		if(product.getQuantity() != 0 && product.getQuantity() >0 ) {
			responseDto.setStockStatus("AVAILBLE");
			responseDto.setMessage("Product is available for purchase");
		}
		else {
			responseDto.setStockStatus("Not Availble");
			responseDto.setMessage("Product is out_Of_stock! sorry, try after some time please ");
		}
		
		return responseDto;
		
	}
	
}

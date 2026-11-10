package com.example.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDto {

	private Long id;
	
	private String productName;
	
	private String description;
	
	private double price;
	
	private int quantity;
	
	private String stockStatus;
	
	private String message;
}

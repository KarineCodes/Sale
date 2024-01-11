package com.example.demo.utils;

import com.example.demo.dto.ProductDto;
import com.example.demo.entities.Product;

public class ProductUtils {
	
	public static Product extract(ProductDto dto)
	{
		return extract(new Product(),dto);
	}
	
	public static Product extract(Product original, ProductDto dto)
	{
		if(dto.category != null)
		{
			original.category = dto.category;
		}
		if(dto.creationDate != null)
		{
			original.creationDate = dto.creationDate;
		}
		if(dto.desc != null)
		{
			original.desc = dto.desc;
		}
		if(dto.name != null)
		{
			original.name = dto.name;
		}
		return original;
	}
	
}

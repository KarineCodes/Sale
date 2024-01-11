package com.example.demo.utils;

import com.example.demo.dto.SalesDto;
import com.example.demo.entities.Sale;

public class SaleUtils {
	public static Sale extract(SalesDto dto)
	{
		return extract(new Sale(),dto);
	}
	
	public static Sale extract(Sale original, SalesDto dto)
	{
		if(dto.client != null)
		{
			original.client = dto.client;
		}
		if(dto.creationDate != null)
		{
			original.creationDate = dto.creationDate;
		}
		if(dto.seller != null)
		{
			original.seller = dto.seller;
		}
		if(dto.transactions != null)
		{
			original.transactions = dto.transactions;
		}
		return original;
	}
}

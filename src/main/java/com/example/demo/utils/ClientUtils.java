package com.example.demo.utils;

import com.example.demo.dto.ClientDto;
import com.example.demo.entities.Client;

public class ClientUtils {
	public static Client extract(ClientDto dto)
	{
		return extract(new Client(),dto);
	}
	
	public static Client extract(Client original, ClientDto dto)
	{
		if(dto.lastName != null)
		{
			original.lastName = dto.lastName;
		}
		if(dto.mobile != null)
		{
			original.mobile = dto.mobile;
		}
		if(dto.name != null)
		{
			original.name = dto.name;
		}
		return original;
	}
}

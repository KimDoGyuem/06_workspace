package com.project.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.dto.WealthDto;
import com.project.service.ShopService;

import lombok.AllArgsConstructor;

@RequestMapping("/shop/*")
@RestController
@AllArgsConstructor
public class ShopController {
	
	private ShopService service;
	
	@RequestMapping("/getWealth")
	public WealthDto getWealth() {
		return service.getWealth();
	}
	
	@RequestMapping("/buyGold")
	public void buyGold() {
		service.buyGold();
	}
	
	@RequestMapping("/buyTicket")
	public void buyTicket() {
		service.buyTicket();
	}
	
}

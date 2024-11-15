package com.peisia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.peisia.dto.WealthDto;
import com.peisia.service.ShopService;

import lombok.Setter;

@CrossOrigin(origins = "http://localhost:3000") // 3000포트에서의 요청 허용
@RequestMapping("/shop/*")
@RestController
public class ShopController {
	
	@Setter(onMethod_ = @Autowired)
	private ShopService service;	
	
	@RequestMapping("/getWealth")			
	public WealthDto getWealth() {
		return service.getWealth();
	}	
	
	@RequestMapping("/buyGold")			
	public void buyGold() {
		System.out.println("==== 만원 충전");
		service.buyGold();
	}
	
	@RequestMapping("/buyDice")			
	public void buyDice() {
		System.out.println("==== 1 주사위상자 구매");
		service.buyDice();
	}
	
	@RequestMapping("/payGold")			
	public void payGold() {
		System.out.println("==== 돈 나감(골드)");
		service.payGold();
	}
}
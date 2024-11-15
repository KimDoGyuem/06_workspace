package com.peisia.controller;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.peisia.dto.CardDto;
import com.peisia.service.CardService;

import lombok.Setter;

@CrossOrigin(origins = "http://localhost:3000") // 3000포트에서의 요청 허용
@RequestMapping("/card/*")
@RestController
public class CardController {
	
	@Setter(onMethod_ = @Autowired)
	private CardService service;	
	
	@RequestMapping("/getMyCards")			
	public ArrayList<CardDto> getMyCards() {
		ArrayList<CardDto> n = service.getList();
		System.out.println("==== 총 카드 수:"+n.size());
		System.out.println("==== 확인"+n);
		return n;
	}
	
	@RequestMapping("/partyAdd")			
	public void partyAdd(@RequestBody Map<String, Object> requestData) {
		CardDto c = new CardDto((String)requestData.get("job"),(String)requestData.get("grade"));
		service.partyAdd(c);
		System.out.println("==== 데이터 잘 오나?: job:"+requestData.get("job"));
		System.out.println("==== 데이터 잘 오나?: grade:"+requestData.get("grade"));
	}
	
	@RequestMapping("/getParty")			
	public ArrayList<CardDto> getParty() {
		ArrayList<CardDto> n = service.getParty();
		System.out.println("==== 파티 카드 수:"+n.size());
		return n;
	}	
	
	@RequestMapping("/clearParty")			
	public void clearParty() {
		service.clearParty();
	}	
	@RequestMapping("/clearCardList")
	public void clearCardList() {
		service.clearCardList();
	}
	
}

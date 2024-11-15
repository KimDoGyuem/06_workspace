package com.project.controller;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.dto.CardDto;
import com.project.listproc.Dice;
import com.project.service.CardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@AllArgsConstructor
@RestController
@RequestMapping("/card/*")
public class CardGameController {

	private CardService service;
	
	@GetMapping("/gacha")
	public CardDto gacha() {
		String pokemons[] = { "꼬마돌", "꼬렛", "구구", "뿔충이", "알통몬", "고오스", "이상해씨", "꼬부기", "파이리", "피카츄" };
		String grade[] = { "v6", "v5", "v4", "v3", "v2", "v1" };
		CardDto c = new CardDto(pokemons[Dice.roll(0, 9)], grade[Dice.getLuck()]);
		service.addCard(c);
		return c;
	}
	
	@RequestMapping("/getMyCards")
	public ArrayList<CardDto> getMyCards(){
		ArrayList<CardDto> c = service.getMyCards();
		return c;
	}
	
	@RequestMapping("/partyAdd")
	public void partyAdd(@RequestBody Map<String, Object> requestData) {
		CardDto c = new CardDto((String)requestData.get("pokemon"),(String)requestData.get("grade"),(double)requestData.get("attack"),(double)requestData.get("defense"));
		System.out.println("====확인2:"+requestData.get("attack"));
		service.partyAdd(c);
	}
	
	@RequestMapping("/getMyParty")
	public ArrayList<CardDto> getMyParty(){
		ArrayList<CardDto> c = service.getMyParty();
		return c;
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

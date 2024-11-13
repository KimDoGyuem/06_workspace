package com.peisia.controller;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.peisia.dto.CardDto;
import com.peisia.service.CardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@AllArgsConstructor
@RestController			
@RequestMapping("/card/*")				
public class CardController {
	
	private CardService service;
	
	public int getLuck() {
		//확률 공개:
		//SSR: 1%
		//SR: 3%
		//S: 6%
		//R: 10%
		//H: 30%
		//N: 50%
		int r = Dice.roll(1,100);
		int t = 5;	// N Normal
		if(r<=50) {	// H High
			t = 4; 
		}
		if(r<=20) {	// R Rare
			t = 3; 
		}
		if(r<=10) {	// S Super
			t = 2; 
		}
		if(r<=4) {	// SR SuperRare
			t = 1; 
		}
		if(r==1) {	// SSR SuperSuperRare
			t = 0; 
		}
		return t;
	}
	
	@GetMapping("/gacha")
	public CardDto gacha() {
		String jobs[] = {"전사","마법사","궁수","도적","사제"};
		String grade[] = {"SSR","SR","S","R","H","N"};
		CardDto c = new CardDto(jobs[Dice.roll(0,4)],grade[getLuck()]);
		service.addCard(c);
		return c;
	}
	
	@RequestMapping("/listDelete")
	public void del() {
		service.del();
	}
	
	@RequestMapping("/getMyCards")
	public ArrayList<CardDto> getMyCards() {
		ArrayList<CardDto> n = service.getList();
		System.out.println("===총 카드 수:"+n.size());
		
		return n;
	}
	
	@RequestMapping("/partyAdd")
	public void patyAdd(@RequestBody Map<String,Object> requestData) {
		CardDto c = new CardDto((String)requestData.get("job"),(String)requestData.get("grade"));
		service.partyAdd(c);
	}
	
}			

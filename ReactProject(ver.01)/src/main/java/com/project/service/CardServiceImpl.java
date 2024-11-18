package com.project.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dto.CardDto;
import com.project.mapper.CardMapper;
import com.project.mapper.ShopMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class CardServiceImpl implements CardService{
	
	private CardMapper mapper;
	private ShopMapper shopMapper;
	
	@Transactional
	public void addCard(CardDto c) {
		mapper.addCard(c);
		shopMapper.payTicket();
	}
	
	public ArrayList<CardDto> getMyCards(){
		ArrayList<CardDto> c = mapper.getMyCards();
		return c;
	}
	
	public void partyAdd(CardDto c) {
		mapper.partyAdd(c);
	}
	
	public ArrayList<CardDto> getMyParty(){
		ArrayList<CardDto> c = mapper.getMyParty();
		return c;
	}
	
	public void clearParty() {
		mapper.clearParty();
	}
	
	public void clearCardList() {
		mapper.clearCardList();
	}
}

package com.peisia.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.peisia.dto.CardDto;
import com.peisia.mapper.CardMapper;
import com.peisia.mapper.ShopMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class CardServiceImpl implements CardService{

	private CardMapper mapper;
	private ShopMapper mappershop;
	

	@Override
	public ArrayList<CardDto> getList() {
		ArrayList<CardDto> n = mapper.getList();
		return n;
	}
	
	@Transactional
	@Override
	public void addCard(CardDto c) {
		mapper.addCard(c);
		mappershop.payDice();
	}

	@Override
	public void partyAdd(CardDto c) {
		mapper.partyAdd(c);
	}

	@Override
	public ArrayList<CardDto> getParty() {
		ArrayList<CardDto> n = mapper.getParty();
		return n;		
	}	
	@Override
	public void clearParty() {
		mapper.clearParty();
	}	
	
	public void clearCardList() {
		mapper.clearCardList();
	}
}
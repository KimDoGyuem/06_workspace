package com.peisia.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.peisia.dto.CardDto;
import com.peisia.mapper.CardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class CardServiceImpl implements CardService{
	
	private CardMapper mapper;
	
	@Override
	public ArrayList<CardDto> getList() {
		ArrayList<CardDto> n = mapper.getList();
		return n;
	}
	
	public void addCard(CardDto c) {
		mapper.addCard(c);
	}
	
	public void del() {
		mapper.del();
	}
	
	public void partyAdd(CardDto c) {
		mapper.partyAdd(c);
	}
	
}

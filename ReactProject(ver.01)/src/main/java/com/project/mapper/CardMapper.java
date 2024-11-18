package com.project.mapper;

import java.util.ArrayList;

import com.project.dto.CardDto;

public interface CardMapper {
	
	public void addCard(CardDto c);
	
	public ArrayList<CardDto> getMyCards();
	
	public void partyAdd(CardDto c);
	
	public ArrayList<CardDto> getMyParty();
	
	public void clearParty();
	
	public void clearCardList();
}

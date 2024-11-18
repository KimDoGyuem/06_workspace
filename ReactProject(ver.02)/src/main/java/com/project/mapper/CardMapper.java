package com.project.mapper;

import java.util.ArrayList;

import com.project.dto.CardDto;
import com.project.dto.SelectCardDto;

public interface CardMapper {
	
	public void addCard(CardDto c);
	
	public ArrayList<CardDto> getMyCards();
	
	public void partyAdd(SelectCardDto s);
	
	public ArrayList<CardDto> getMyParty(int no);
	
	public void clearCardList();
	
	public void clearParty();
}

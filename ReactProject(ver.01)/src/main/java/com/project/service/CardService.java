package com.project.service;

import java.util.ArrayList;

import com.project.dto.CardDto;

public interface CardService {
	
	public void addCard(CardDto c);
	
	public ArrayList<CardDto> getMyCards();
	
	public void partyAdd(CardDto c);
	
	public ArrayList<CardDto> getMyParty();
	
	public void clearParty();
	
	public void clearCardList();
	
}

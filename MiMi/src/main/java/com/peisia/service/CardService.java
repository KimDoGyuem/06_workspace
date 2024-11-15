package com.peisia.service;

import java.util.ArrayList;

import com.peisia.dto.CardDto;

public interface CardService {
	public ArrayList<CardDto> getList();
	public void addCard(CardDto c);
	public void partyAdd(CardDto c);
	public ArrayList<CardDto> getParty();
	public void clearParty();
	public void clearCardList();
}

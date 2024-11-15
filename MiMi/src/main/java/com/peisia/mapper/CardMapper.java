package com.peisia.mapper;

import java.util.ArrayList;

import com.peisia.dto.CardDto;

public interface CardMapper {
	public ArrayList<CardDto> getList();
	public void addCard(CardDto c);
	public void partyAdd(CardDto c);
	public ArrayList<CardDto> getParty();
	public void clearParty();
	public void clearCardList();
}

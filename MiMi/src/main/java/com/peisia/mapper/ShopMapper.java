package com.peisia.mapper;

import com.peisia.dto.WealthDto;

public interface ShopMapper {
	public WealthDto getWealth();
	public void buyGold();
	public void buyDice();	
	public void payGold();
	public void payDice();
}

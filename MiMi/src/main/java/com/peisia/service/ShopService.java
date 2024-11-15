package com.peisia.service;

import com.peisia.dto.WealthDto;

public interface ShopService {
	public WealthDto getWealth();
	public void buyGold();
	public void buyDice();
	public void payGold();
}

package com.project.mapper;

import com.project.dto.WealthDto;

public interface ShopMapper {
	public WealthDto getWealth();
	public void buyGold();
	public void buyTicket();
	public void payGold();
	public void payTicket();
}

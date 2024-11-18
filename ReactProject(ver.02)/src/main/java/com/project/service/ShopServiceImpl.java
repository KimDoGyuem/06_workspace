package com.project.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dto.WealthDto;
import com.project.mapper.ShopMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class ShopServiceImpl implements ShopService{
	
	private ShopMapper mapper;
	
	public WealthDto getWealth() {
		return mapper.getWealth();
	}
	
	public void buyGold() {
		mapper.buyGold();
	}
	
	@Transactional
	public void buyTicket() {
		mapper.buyTicket();
		mapper.payGold();
	}
}

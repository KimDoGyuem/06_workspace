package com.peisia.dto;

import lombok.Data;

@Data
public class WealthDto {
	private Long gold;
	private Long dice;
	private String id;
	
	public WealthDto(Long gold, Long dice, String id) {
		super();
		this.gold = gold;
		this.dice = dice;
		this.id = id;
	}
	
}
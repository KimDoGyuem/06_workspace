package com.project.dto;

import lombok.Data;

@Data
public class WealthDto {
	private Long gold;
	private Long ticket;
	
	public WealthDto(Long gold, Long ticket) {
		super();
		this.gold = gold;
		this.ticket = ticket;
	}
	
}

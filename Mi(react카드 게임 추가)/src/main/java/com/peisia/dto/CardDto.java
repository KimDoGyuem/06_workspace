package com.peisia.dto;

import lombok.Data;

@Data
public class CardDto {
	private Long no;
	private String job;
	private String grade;
	private String id;
	
	public CardDto() {
		
	}
	
	public CardDto(String job, String grade) {
		super();
		this.job = job;
		this.grade = grade;
	}
	
}
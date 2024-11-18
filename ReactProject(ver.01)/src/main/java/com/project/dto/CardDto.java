package com.project.dto;

public class CardDto {
	
	int no;
	String pokemon;
	String grade;
	int attack;
	int defense;
	
	public CardDto() {
		
	}
	
	public CardDto(String pokemon, String grade) {
		super();
		this.pokemon = pokemon;
		this.grade = grade;
		
		if (pokemon.equals("꼬마돌")) {
			double attack = 10;
			double defense = 80;
			for (int i = 1; i <= 6; i++) {
				if (grade.equals("v" + i)) {
					attack = attack * (1 + 0.1 * i);
					defense = defense * (1 + 0.1 * i);
				}
			}
			this.attack = (int) attack;
			this.defense = (int) defense;
		}else if(pokemon.equals("꼬렛")){
			double attack = 50;
			double defense = 30;
			for (int i = 1; i <= 6; i++) {
				if (grade.equals("v" + i)) {
					attack = attack * (1 + 0.1 * i);
					defense = defense * (1 + 0.1 * i);
				}
			}
			this.attack = (int) attack;
			this.defense = (int) defense;
		}else if(pokemon.equals("구구")){
			double attack = 40;
			double defense = 40;
			for (int i = 1; i <= 6; i++) {
				if (grade.equals("v" + i)) {
					attack = attack * (1 + 0.1 * i);
					defense = defense * (1 + 0.1 * i);
				}
			}
			this.attack = (int) attack;
			this.defense = (int) defense;
		}else if(pokemon.equals("뿔충이")){
			double attack = 30;
			double defense = 30;
			for (int i = 1; i <= 6; i++) {
				if (grade.equals("v" + i)) {
					attack = attack * (1 + 0.1 * i);
					defense = defense * (1 + 0.1 * i);
				}
			}
			this.attack = (int) attack;
			this.defense = (int) defense;
		}else if(pokemon.equals("알통몬")){
			double attack = 60;
			double defense = 30;
			for (int i = 1; i <= 6; i++) {
				if (grade.equals("v" + i)) {
					attack = attack * (1 + 0.1 * i);
					defense = defense * (1 + 0.1 * i);
				}
			}
			this.attack = (int) attack;
			this.defense = (int) defense;
		}else if(pokemon.equals("고오스")){
			double attack = 60;
			double defense = 20;
			for (int i = 1; i <= 6; i++) {
				if (grade.equals("v" + i)) {
					attack = attack * (1 + 0.1 * i);
					defense = defense * (1 + 0.1 * i);
				}
			}
			this.attack = (int) attack;
			this.defense = (int) defense;
		}else if(pokemon.equals("이상해씨")){
			double attack = 50;
			double defense = 60;
			for (int i = 1; i <= 6; i++) {
				if (grade.equals("v" + i)) {
					attack = attack * (1 + 0.1 * i);
					defense = defense * (1 + 0.1 * i);
				}
			}
			this.attack = (int) attack;
			this.defense = (int) defense;
		}else if(pokemon.equals("꼬부기")){
			double attack = 40;
			double defense = 70;
			for (int i = 1; i <= 6; i++) {
				if (grade.equals("v" + i)) {
					attack = attack * (1 + 0.1 * i);
					defense = defense * (1 + 0.1 * i);
				}
			}
			this.attack = (int) attack;
			this.defense = (int) defense;
		}else if(pokemon.equals("파이리")){
			double attack = 70;
			double defense = 40;
			for (int i = 1; i <= 6; i++) {
				if (grade.equals("v" + i)) {
					attack = attack * (1 + 0.1 * i);
					defense = defense * (1 + 0.1 * i);
				}
			}
			this.attack = (int) attack;
			this.defense = (int) defense;
		}else if(pokemon.equals("피카츄")){
			double attack = 50;
			double defense = 50;
			for (int i = 1; i <= 6; i++) {
				if (grade.equals("v" + i)) {
					attack = attack * (1 + 0.1 * i);
					defense = defense * (1 + 0.1 * i);
				}
			}
			this.attack = (int) attack;
			this.defense = (int) defense;
		}
		
	}

	public CardDto(String pokemon, String grade, double attack, double defense) {
		super();
		this.pokemon = pokemon;
		this.grade = grade;
		this.attack = (int)attack;
		this.defense = (int)defense;
	}
	
	
}

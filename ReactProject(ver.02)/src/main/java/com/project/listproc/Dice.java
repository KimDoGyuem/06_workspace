package com.project.listproc;

public class Dice {

	static private final boolean CHANCE_REVEAL = true;

	static public int roll(int min, int max) {
		int n = max - min + 1;
		int r = (int) (Math.random() * n + min);
		if (CHANCE_REVEAL) {
//			System.out.println(String.format("<%s ~ %s 중 %s 나옴>", min, max, r));
		}
		return r;
	}
	
	static public int getLuck() {
		int r = roll(1, 100);
		int t = 5; // 12
		if (r <= 88) { // 20
			t = 4;
		}
		if (r <= 68) { // 30
			t = 3;
		}
		if (r <= 38) { // 25
			t = 2;
		}
		if (r <= 13) { // 10
			t = 1;
		}
		if (r <= 3) { // 3
			t = 0;
		}
		return t;
	}
	
}

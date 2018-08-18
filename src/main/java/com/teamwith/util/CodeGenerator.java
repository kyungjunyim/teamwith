package com.teamwith.util;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class CodeGenerator {

	public static String generate() {

		Random rnd = new Random();

		StringBuffer result = new StringBuffer();

		for (int i = 0; i < 8; i++) {

			if (rnd.nextBoolean()) {
				result.append((char) ((int) (rnd.nextInt(26)) + 65));
			} else {
				result.append((rnd.nextInt(10)));
			}

		}
		return result.toString();
	}
}

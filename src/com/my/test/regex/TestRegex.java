package com.my.test.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex {
	public static void main(String[] args) {
		String inputNumber = "100.1";
		String regex = "[1-9]{1}[0-9]{1,6}";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(inputNumber);
		boolean flag = matcher.matches();
		System.out.println(flag);
		if (!flag) {
			System.out.println("Ð¡Êý");
		}
	}
}

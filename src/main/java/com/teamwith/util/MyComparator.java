package com.teamwith.util;

import java.util.Comparator;
import java.util.Map;

public class MyComparator implements Comparator<String> {
	private Map<String, Double> base;

	public MyComparator(Map<String, Double> base) {
		this.base = base;
	}

	public int compare(String o1, String o2) {
		if (base.get(o1) >= base.get(o2)) {
			return -1;
		} else {
			return 1;
		}
	}
}

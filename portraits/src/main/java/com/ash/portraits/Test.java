package com.ash.portraits;

import java.util.HashMap;

public class Test {

	public static void main(String[] args) {

Integer[] ar = {2,3,7};
Integer target = 5;

HashMap<Integer, Integer> m = new HashMap<>();

for (Integer i : ar) {
	m.put(i, target-i);
}
System.out.println(m);
m.forEach((k,v) -> {
	if (m.get(v) !=null) {
		System.out.println(k);
	}
}); 
	}

}

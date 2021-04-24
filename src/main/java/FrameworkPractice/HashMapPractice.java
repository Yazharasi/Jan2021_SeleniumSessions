package FrameworkPractice;

import java.util.HashMap;
import java.util.Map;

public class HashMapPractice {

	public static void main(String[] args) {

		Map<String, String> empdtls = new HashMap<String, String>();
		empdtls.put("name", "Yazh");
		empdtls.put("", "12345");
		empdtls.put("Company", "PWC");
		empdtls.put("Location", "Atlanta");

//		Method 1: Using entrySet():
		for (Map.Entry<String, String> entry : empdtls.entrySet()) {
				System.out.println("The key is: " + entry.getKey() + " -- The Vaue is: " + entry.getValue());
		}

		System.out.println("------");

		for (String e : empdtls.keySet()) {
			if (e.contains("i")) {
				System.out.println("The key is: " + e);
			}
		}
		System.out.println("------");

		for (String e : empdtls.values()) {
			System.out.println("The value is: " + e);
		}

		System.out.println("------");

		empdtls.forEach((k, v) -> System.out.println("The key is: " + k + " -- The value is: " + v));
		
		System.out.println("------");
		
		System.out.println("The value: "+empdtls.get("Company"));
		if(empdtls.containsKey("id")) {
			System.out.println(empdtls.get("id"));
		}

	}

}

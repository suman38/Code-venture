package com.suman.game;

import org.json.JSONObject;

//A demo on how to implement JSON through org.json library.

public class JsonDemo {

	public static void main(String[] args) {
		JSONObject obj = new JSONObject();

		// to store data
		obj.put("name", "suman");
		obj.put("roll", 1022);
		obj.put("points", 15.4);

		System.out.println(obj);

		// to read data:
		System.out.println(obj.get("name")); // returns string by default
		System.out.println(obj.getNumber("roll")); // returns as a Number format
		System.out.println(obj.getDouble("points")); // returns parsed double

		//Number is a generic representation of the numerical types
		Number xa = obj.getNumber("roll");  //output: 1022
		Number xb = obj.getNumber("points"); //output: 15.4
		System.out.println(xa+" "+xb);
		
		// lets try some method
		double x = obj.getDouble("roll");
		System.out.println(x + 10);

	}
}

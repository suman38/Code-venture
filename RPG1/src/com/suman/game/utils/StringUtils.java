package com.suman.game.utils;

import java.io.BufferedReader;
import java.io.FileReader;

public class StringUtils {

	public static String loadFileAsString(String path) {
		StringBuilder str = new StringBuilder();

		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line = "";
			while ((line = br.readLine()) != null) {
				str.append(line + "\n");
			}

			br.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return str.toString();
	}
}

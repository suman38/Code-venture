package com.suman.game.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class StringUtils {

	public static String loadMapData(String path) {
		StringBuilder str = new StringBuilder();

		try {
			BufferedReader bf = new BufferedReader(new FileReader(path));

			String line = "";
			while ((line = bf.readLine()) != null) {
				str.append(line.trim());
			}

			bf.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str.toString();
	}

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

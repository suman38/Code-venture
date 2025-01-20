package com.suman.game.misc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerialDemo {
	
	private int count = 0;
	private String fileDir = System.getenv("USERPROFILE") + "/documents/mygame";
	private String fileName = fileDir + "/mysave"+(++count)+".dat";

	public SerialDemo() {
		// to create a folder in the target location
		new File(fileDir).mkdir();

		DemoPlayer player = new DemoPlayer("Suman", 110, 20);
		System.out.println(player.toString());
		serializeThis(player);

		player.setName("Rahul");
		System.out.println(player.toString());
		serializeThis(player);

		DemoPlayer p1 = deSerializeThis();
		System.out.println(p1.toString());
	}

	public void serializeThis(DemoPlayer player) 
	{
		ObjectOutputStream objout;

		try {
			objout = new ObjectOutputStream(new FileOutputStream(fileName));
			objout.writeObject(player);
			objout.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public DemoPlayer deSerializeThis() 
	{
		ObjectInputStream objin;

		try {
			objin = new ObjectInputStream(new FileInputStream(fileName));
			DemoPlayer d = (DemoPlayer) objin.readObject();
			objin.close();
			return d;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static void main(String[] args) {
		new SerialDemo();
	}
}

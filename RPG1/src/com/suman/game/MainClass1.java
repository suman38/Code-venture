package com.suman.game;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MainClass1 {

	public MainClass1() {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				Engine e = new Engine();
				JFrame frm = new JFrame("Game");
				frm.add(e);
				frm.pack();
				frm.setLocationRelativeTo(null);
				frm.setResizable(false);
				frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frm.setVisible(true);
			}
		});
	}

	public static void main(String[] args) {
		new MainClass1();
	}
}

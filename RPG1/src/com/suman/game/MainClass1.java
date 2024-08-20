package com.suman.game;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MainClass1 {

	public MainClass1() {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				JFrame frm = new JFrame("Game");
				Engine g = new Engine(frm);
				frm.add(g);
				frm.pack();
				frm.setLocationRelativeTo(null);
				frm.setResizable(false);
				frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frm.setVisible(true);
				g.startGame();
			}
		});
	}

	public static void main(String[] args) {
		new MainClass1();
	}
}

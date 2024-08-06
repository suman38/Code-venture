package com.suman.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SidePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton btnAction, btnMap, btnInventory, btnQuests, btnExit;

	public SidePanel() {
		setBackground(Color.GRAY);

		JPanel pnl = new JPanel();
		pnl.setLayout(new GridLayout(5,1));
		
		Font f= new Font("Comic Sans MS",Font.BOLD,22);

		btnAction = new JButton("Action");
		btnMap = new JButton("Map");
		btnInventory = new JButton("Inventory");
		btnQuests = new JButton("Quests");
		btnExit = new JButton("Exit");
		
		btnAction.setPreferredSize(new Dimension(150,70));
		
		btnMap.setFont(f);
		btnAction.setFont(f);
		btnInventory.setFont(f);
		btnQuests.setFont(f);
		btnExit.setFont(f);
		
		btnAction.setEnabled(false);
		
		pnl.add(btnAction);
		pnl.add(btnMap);
		pnl.add(btnInventory);
		pnl.add(btnQuests);
		pnl.add(btnExit);
		
		add(pnl);
	}
}

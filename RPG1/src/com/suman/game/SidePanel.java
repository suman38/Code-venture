package com.suman.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SidePanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private Engine engine;
	private JButton btnAction, btnMap, btnBag, btnQuests, btnExit;

	public SidePanel(Engine engine) {
		this.engine = engine;
		setBackground(Color.GRAY);

		JPanel pnl = new JPanel();
		pnl.setLayout(new GridLayout(5, 1));

		Font f = new Font("Comic Sans MS", Font.BOLD, 22);

		btnAction = new JButton("Interact");
		btnMap = new JButton("Map", new ImageIcon(getClass().getResource("/misc/map.png")));
		btnBag = new JButton("Bag", new ImageIcon(getClass().getResource("/misc/backpack.png")));
		btnQuests = new JButton("Quests", new ImageIcon(getClass().getResource("/misc/scroll.png")));
		btnExit = new JButton("Exit", new ImageIcon(getClass().getResource("/misc/x.png")));

		btnAction.setPreferredSize(new Dimension(150, 70));
		btnAction.setEnabled(true);

		btnMap.setFont(f);
		btnAction.setFont(f);
		btnBag.setFont(f);
		btnQuests.setFont(f);
		btnExit.setFont(f);

		btnMap.setMnemonic(KeyEvent.VK_M);
		btnExit.setMnemonic(KeyEvent.VK_X);
		btnBag.setMnemonic(KeyEvent.VK_B);
		btnAction.setMnemonic(KeyEvent.VK_E);
		btnQuests.setMnemonic(KeyEvent.VK_Q);
		
		pnl.add(btnAction);
		pnl.add(btnMap);
		pnl.add(btnBag);
		pnl.add(btnQuests);
		pnl.add(btnExit);

		btnExit.addActionListener(this);
		btnMap.addActionListener(this);
		btnQuests.addActionListener(this);
		btnAction.addActionListener(this);
		btnBag.addActionListener(this);

		add(pnl);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnExit) {
			int ch = JOptionPane.showConfirmDialog(engine, "Do you want to exit the game?", "Exit game",
					JOptionPane.YES_NO_OPTION);

			if (ch == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		} else if (e.getSource() == btnMap) {
			// Code will be added in the future
		} else if (e.getSource() == btnQuests) {
			// Code will be added in the future
		} else if (e.getSource() == btnBag) {
			// Code will be added in the future
		} else if (e.getSource() == btnAction) {
			// Code will be added in the future
		}
	}
}

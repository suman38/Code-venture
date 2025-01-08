package com.suman.game.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import com.suman.game.entities.InteractableObject;
import com.suman.game.entities.Player;
import com.suman.game.states.GameState;

public class SidePanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;

	private GameState engine;
	private Player player;
	private InteractableObject obj;

	private JToggleButton btnBag, btnMap, btnQuests;
	private JButton btnAction, btnExit;

	private TitledBorder titledBorder;

	public SidePanel(GameState engine) {
		this.engine = engine;
		this.player = engine.getGame().getPlayer();

		setBackground(Color.DARK_GRAY);
		setPreferredSize(new Dimension(160, 480));

		titledBorder = new TitledBorder("Menu");
		titledBorder.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, Color.WHITE, Color.GREEN));
		titledBorder.setTitleColor(Color.YELLOW);
		titledBorder.setTitleJustification(TitledBorder.RIGHT);
		titledBorder.setTitleFont(new Font("Comic Sans MS", Font.BOLD, 20));

		JPanel pnl = new JPanel();
		pnl.setLayout(new GridLayout(5, 1));
		pnl.setBackground(Color.DARK_GRAY);
		pnl.setBorder(titledBorder);

		Font f = new Font("Comic Sans MS", Font.BOLD, 18);

		btnAction = new JButton("Interact");
		btnMap = new JToggleButton("Map", new ImageIcon(getClass().getResource("/misc/map.png")));
		btnBag = new JToggleButton("Bag", new ImageIcon(getClass().getResource("/misc/backpack.png")));
		btnQuests = new JToggleButton("Log", new ImageIcon(getClass().getResource("/misc/scroll.png")));
		btnExit = new JButton("Exit", new ImageIcon(getClass().getResource("/misc/x.png")));

		btnAction.setEnabled(false);

		btnMap.setFont(f);
		btnAction.setFont(f);
		btnBag.setFont(f);
		btnQuests.setFont(f);
		btnExit.setFont(f);

		btnMap.setFocusPainted(false);
		btnAction.setFocusPainted(false);
		btnQuests.setFocusPainted(false);
		btnBag.setFocusPainted(false);
		btnExit.setFocusPainted(false);

		btnMap.setMnemonic(KeyEvent.VK_M);
		btnExit.setMnemonic(KeyEvent.VK_X);
		btnBag.setMnemonic(KeyEvent.VK_B);
		btnAction.setMnemonic(KeyEvent.VK_E);
		btnQuests.setMnemonic(KeyEvent.VK_L);

		btnMap.setToolTipText("World Map");
		btnQuests.setToolTipText("Quest Log");
		btnBag.setToolTipText("Your Bag");
		btnAction.setToolTipText("Talk/Accept");

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

	public void setInteract(boolean state, InteractableObject obj) {
		btnAction.setEnabled(state);
		this.obj = obj;
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
			if (btnMap.getModel().isSelected())
				engine.showPanel("map");
			else
				engine.showPanel("game");

		} else if (e.getSource() == btnQuests) {
			// code will be added in the future
		} else if (e.getSource() == btnBag) {
			if (btnBag.getModel().isSelected()) {
				// this will make sure we are updating the view of the bag
				// every time we pick or drop items from it.
				engine.getBagPanel().updateBagView();
				engine.showPanel("bag");
			} else {
				engine.showPanel("game");
			}
		} else if (e.getSource() == btnAction) {
			// code will be added in the future
			player.interact(obj);
		}
	}
}

package com.suman.game.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.suman.game.Engine;

public class HomeState extends State implements ActionListener{

	private static final long serialVersionUID = 1L;
	private Font myTitleFont, myButtonFont;
	private JLabel lblTitle;
	private JButton bStart, bLoad, bExit;
	private JPanel panelTitle, panelButtons;

	public HomeState(Engine engine) {
		super(engine);
		setBackground(Color.DARK_GRAY);
		setLayout(null); //Null Layout
		myTitleFont = new Font("Segoe Print", Font.BOLD, 50);
		myButtonFont = new Font("Comic Sans MS", Font.ITALIC, 25);
		displayUI();
	}

	private void displayUI() {
		lblTitle = new JLabel("Code-venture");
		lblTitle.setForeground(Color.BLACK);
		lblTitle.setFont(myTitleFont);

		bStart = new JButton("Start Game");
		bStart.setFont(myButtonFont);
		bStart.addActionListener(this);
		
		bLoad = new JButton("Load Game");		
		bLoad.setFont(myButtonFont);
		bLoad.addActionListener(this);
		
		bExit = new JButton("Exit Game");
		bExit.setFont(myButtonFont);
		bExit.addActionListener(this);

		panelTitle = new JPanel();
		panelTitle.setBackground(Color.WHITE);

		panelButtons = new JPanel();
		panelButtons.setBackground(Color.DARK_GRAY);
		panelButtons.setLayout(new GridLayout(3,1,0,20));

		panelTitle.add(lblTitle);
		panelButtons.add(bStart);
		panelButtons.add(bLoad);
		panelButtons.add(bExit);

		//Null layout requires bounds to show components
		//setBounds(x,y,width,height);
		panelTitle.setBounds(150, 100, 500, 110); 
		add(panelTitle);
		
		panelButtons.setBounds(280,250,250,230);
		add(panelButtons);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == bStart)
		{
			engine.showScene(StateType.GAME);
		}
		else if(e.getSource() == bLoad)
		{
			//code yet to implement
		}
		else if(e.getSource() == bExit)
		{
			int ch = JOptionPane.showConfirmDialog(engine, "Do you want to exit the game?", "Exit game",
					JOptionPane.YES_NO_OPTION);

			if (ch == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		}
	}
}

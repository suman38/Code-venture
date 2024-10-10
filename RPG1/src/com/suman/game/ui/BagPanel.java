package com.suman.game.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import com.suman.game.Game;
import com.suman.game.bag.InventorySlot;

public class BagPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private Game game;

	private JPanel viewPanel;
	private Font f;
	
	public BagPanel(Game game)
	{
		this.game = game;
		
		f = new Font("Arial",Font.PLAIN,18);
		
		setLayout(new BorderLayout());
		
		JLabel lbl = new JLabel("    Bag    ");
		lbl.setFont(new Font("Arial",Font.BOLD,24));
		add(lbl,"North");
		
		viewPanel = new JPanel();
		viewPanel.setBackground(Color.WHITE);
		viewPanel.setPreferredSize(new Dimension(600,600));
		
		JScrollPane scrollPane = new JScrollPane(viewPanel);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		add(scrollPane,"Center");
		updateBagView();
	}
	
	public void updateBagView()
	{
		//There is a bug here.
		//Sometimes the same items gets added again and again into the view.
		//To solve it, I write the below line of code.	
		viewPanel.removeAll();
		
		//Now it will remove the previous components and add new ones.
	
		
		for(InventorySlot it : game.getPlayer().getBag().getItems())
		{
			String s = game.getItemManager().getGameItem(it.getItemId()).getItemName()+
					" x "+it.getItemAmount();
			
			JTextField txt = new JTextField(" "+s+" ");
			txt.setEditable(false);
			txt.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
			txt.setFont(f);
			txt.setBackground(new Color(0,230,230));
			viewPanel.add(txt);
		}
	}
	
	
	
	
	
	
	
	
}

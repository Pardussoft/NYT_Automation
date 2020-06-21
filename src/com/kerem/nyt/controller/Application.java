package com.kerem.nyt.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;

import com.kerem.nyt.gui.components.MainFrame;
import com.kerem.nyt.model.dal.ItemParser;
import com.kerem.nyt.model.entity.Item;
import com.kerem.nyt.model.utility.ItemType;

public class Application 
{
	private static final String GENERAL_ADDRESS = "https://rss.nytimes.com/services/xml/rss/nyt/";
	private static final String EXTENSION = ".xml";
	
	private ItemParser itemParser; // model
	private MainFrame mainFrame; // view

	private JButton btnGetAllScience;
	private JButton btnFindByIDScience;
	
	private JButton btnGetAllWorld;
	private JButton btnFindByIDWorld;
	
	public Application() 
	{
		mainFrame = new MainFrame();
		
		initializeComponents();
		manageActions();
	}
		
	private void manageActions() 
	{	
		btnGetAllScience.addActionListener(new ActionListener() 
		{	
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				String scienceAddress = GENERAL_ADDRESS + ItemType.science + EXTENSION;
				
				itemParser = new ItemParser(scienceAddress);
				List<Item> itemList = itemParser.createItemList();	
				mainFrame.getSciencePanel().fillEntities(itemList);
			}
		});
		
		btnGetAllWorld.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				String worldAddress = GENERAL_ADDRESS + ItemType.world + EXTENSION;
				
				itemParser = new ItemParser(worldAddress);				
				List<Item> itemList = itemParser.createItemList();	
				mainFrame.getWorldPanel().fillEntities(itemList);
			}
		});
	}

	private void initializeComponents() 
	{
		btnGetAllScience = mainFrame.getSciencePanel().getBtnGetAll();
		btnFindByIDScience = mainFrame.getSciencePanel().getBtnFindByID();
		
		btnGetAllWorld = mainFrame.getWorldPanel().getBtnGetAll();
		btnFindByIDWorld = mainFrame.getWorldPanel().getBtnFindByID();
	}

	public void start()
	{
		mainFrame.show();
	}
}

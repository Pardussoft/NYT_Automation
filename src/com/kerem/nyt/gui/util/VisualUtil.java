package com.kerem.nyt.gui.util;

import java.awt.Component;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

import com.kerem.nyt.model.utility.ItemType;

public final class VisualUtil 
{
	private static final int DEFAULT_BUTTON_HEIGHT = 150;
	private static final int DEFAULT_BUTTON_WIDTH = 100;
	
	private static final int DEFAULT_IMAGE_WITDTH = 40;
	private static final int DEFAULT_IMAGE_HEIGHT = 40;
	
	private static final int DEFAULT_FONT_SIZE = 10;
	private static final int DEFAULT_FONT_STYLE = Font.ITALIC;
	private static final String DEFAULT_FONT_NAME = "Calibri";
	

	private VisualUtil() {}
	
	public static void addTab(JTabbedPane tabbedPane, Component component, ItemType itemType) 
	{
		tabbedPane.addTab(itemType + " tab", createScaledIcon(itemType), component, itemType + " news screen");
	}
	
	// https://stackoverflow.com/questions/6714045/how-to-resize-jlabel-imageicon
	public static ImageIcon createScaledIcon(ItemType itemType)
	{
		String fileName = itemType + ".png";
		ImageIcon imageIcon = new ImageIcon(fileName); 
		
		Image image = imageIcon.getImage(); 
		Image newImage = image.getScaledInstance(DEFAULT_IMAGE_WITDTH, 
											   DEFAULT_IMAGE_HEIGHT, 
											   java.awt.Image.SCALE_SMOOTH); 
		
		imageIcon = new ImageIcon(newImage);  
		
		return imageIcon;
	}
	
	public static JButton createButton(String tagName, int width, int height)
	{
		JButton button = new JButton(tagName);
		button.setSize(width, height);
		return button;
	}
	
	public static JButton createButton(String tagName)
	{
		JButton button = new JButton(tagName);
		button.setSize(DEFAULT_BUTTON_WIDTH, DEFAULT_BUTTON_HEIGHT);
		return button;
	}
	
	public static JLabel createLabel(String labelName, String fontName, int fontStyle, int fontSize)
	{
		JLabel label = new JLabel(labelName);
		Font font = new Font(fontName, fontStyle, fontSize);
		label.setFont(font);
		return label;
	}
	
	public static JLabel createLabel(String labelName)
	{
		JLabel label = new JLabel(labelName);
		Font font = new Font(DEFAULT_FONT_NAME, DEFAULT_FONT_STYLE, DEFAULT_FONT_SIZE);
		label.setFont(font);
		return label;
	}
	
}

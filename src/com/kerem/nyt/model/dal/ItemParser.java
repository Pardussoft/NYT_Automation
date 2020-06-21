package com.kerem.nyt.model.dal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.kerem.nyt.model.entity.Item;
import com.kerem.nyt.model.utility.XML_TAG;
import com.kerem.nyt.util.Util;


public final class ItemParser 
{
	private String xmlURL;
	private List<Item> itemList;
	
	public ItemParser(String xmlURL) 
	{
		this.xmlURL = xmlURL;
	}
	
	/**
	 * 
	 * @return
	 * 	list of items on destination link,
	 *  in other words list of news
	 */
	public List<Item> createItemList()
	{
		itemList = new ArrayList<Item>();
		
		try 
		{
			SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();		
			try 
			{
				saxParser.parse(xmlURL, new HaberXMLHandler());
			} 
			catch (IOException e) 
			{
				Util.hataMesajiYaz("Error Message: " + e.getMessage());
			}
		} 
		catch (ParserConfigurationException e) 
		{
			Util.hataMesajiYaz("Error Message: " + e.getMessage());
		} 
		catch (SAXException e) 
		{
			Util.hataMesajiYaz("Error Message: " + e.getMessage());
		}
		
		return itemList;
	}
	
	private class HaberXMLHandler extends DefaultHandler
	{
		private Item item;
		private boolean isItem;
		private boolean isTitle;
		private boolean isLink;
		private boolean isGuid;
		private boolean isDescription;
		
		// xml'deki baþlangýç etiketi için
		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException 
		{
			if(qName.equals(XML_TAG.item.toString()))
			{
				item = new Item();
				isItem = true;
			}
			else if(qName.equals(XML_TAG.title.toString()))
			{
				isTitle = isItem;
			}
			else if(qName.equals(XML_TAG.link.toString()))
			{
				isLink = isItem; // o haberin "link"i 
			}
			else if(qName.equals(XML_TAG.guid.toString()))
			{
				isGuid = isItem;
			}
			else if(qName.equals(XML_TAG.description.toString()))
			{
				isDescription = isItem;
			}
		}
		
		
		// xml'deki baþlangýç ve bitiþ etiketi arasýndaki karakterler için
		@Override
		public void characters(char[] ch, int start, int length) throws SAXException
		{
			if(isTitle)
			{
				item.setTitle(new String(ch, start, length));
				isTitle = false;
			}
			else if(isLink)
			{
				item.setLink(new String(ch, start, length));
				isLink = false;
			}
			else if(isGuid)
			{
				item.setGuid(new String(ch, start, length));
				isGuid = false;
			}
			else if(isDescription)
			{
				item.setDescription(new String(ch, start, length));
				isDescription = false;
			}
		}
				
		// xml'deki bitiþ etiketi için
		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException 
		{
			if(qName.equals(XML_TAG.item.toString()))
			{
				itemList.add(item);
			}
		}
	}
}

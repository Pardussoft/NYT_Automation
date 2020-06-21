package com.kerem.nyt.model.entity;

import java.util.UUID;

public class Item
{
	private static int counter;
	private int number;
	private UUID itemID;
	private String title;
	private String link;
	private String guid;
	private String description;

	public Item() 
	{
		itemID = UUID.randomUUID();
		number = ++counter;
	}
	
	public UUID getItemID() {
		return itemID;
	}

	public void setItemID(UUID itemID) {
		this.itemID = itemID;
	}
	
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getTitle() {
		return title;
	}
	
	public String getLink() {
		return link;
	}
	
	public String getGuid() {
		return guid;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setLink(String link) {
		this.link = link;
	}
	public void setGuid(String guid) {
		this.guid = guid;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "\nItem [itemID=" + itemID + ", title=" + title + ", link=" + link + ", guid=" + guid + ", description="
				+ description + "]\n";
	}	
}

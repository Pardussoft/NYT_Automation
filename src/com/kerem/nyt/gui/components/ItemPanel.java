package com.kerem.nyt.gui.components;

import com.kerem.nyt.gui.model.ItemTableModel;
import com.kerem.nyt.model.entity.Item;
import com.kerem.nyt.model.utility.ItemType;

public class ItemPanel extends AncestorPanel<Item>
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ItemPanel(ItemType itemType) 
	{
		super(itemType, new ItemTableModel<Item>());
	}
}

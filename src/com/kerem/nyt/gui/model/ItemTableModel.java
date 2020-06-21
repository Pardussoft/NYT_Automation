package com.kerem.nyt.gui.model;

import com.kerem.nyt.model.entity.Item;

public class ItemTableModel<E> extends AbstractEntityTableModel<E>
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final String[] COLUMN_NAMES = {"Number", "Title", "Link", "Guid", "Description"};
	private static final  Class<?>[] COLUMN_CLASSES = {Integer.class, String.class, String.class, String.class, String.class};
	
	public ItemTableModel()
	{
		super(COLUMN_NAMES, COLUMN_CLASSES);
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) 
	{
		Object value = null;
		
		// rowIndex, item'i bulmak icin
		Item item = (Item) getEntities().get(rowIndex);
		
		switch (columnIndex) 
		{
			case 0:
				value = item.getNumber();
				break;
	
			case 1:
				value = item.getTitle();
				break;
			
			case 2:
				value = item.getLink();
				break;	
				
			case 3:
				value = item.getGuid();
				break;	
				
			case 4:
				value = item.getDescription();
				break;	
		}
		
		return value;
	}
	
}

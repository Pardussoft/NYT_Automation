package com.kerem.nyt.gui.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public abstract class AbstractEntityTableModel<E> extends AbstractTableModel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String[] columnNames;
	private Class<?>[] columnClasses;

	private List<E> entities;
	
	public AbstractEntityTableModel(String[] columnNames, Class<?>[] columnClasses)
	{
		this.columnNames = columnNames;
		this.columnClasses = columnClasses;
	}
	
	public List<E> getEntities() {
		return entities;
	}

	public void setEntities(List<E> entities) {
		this.entities = entities;
		
		/*
		 * https://docs.oracle.com/javase/7/docs/api/javax
		 * /swing/table/AbstractTableModel.html#fireTableDataChanged()
		 */
	 	fireTableDataChanged();
	}

	@Override
	public int getRowCount() 
	{
		return entities == null ? 0 : entities.size();
	}

	@Override
	public int getColumnCount() 
	{
		return columnNames.length;
	}

	@Override
	public String getColumnName(int column)
	{
		return columnNames[column];
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) 
	{
		return columnClasses[columnIndex];
	}
}

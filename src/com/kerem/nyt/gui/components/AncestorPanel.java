package com.kerem.nyt.gui.components;

import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumnModel;

import com.kerem.nyt.gui.model.AbstractEntityTableModel;
import com.kerem.nyt.gui.util.VisualUtil;
import com.kerem.nyt.model.utility.ItemType;

public class AncestorPanel<E> extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final int DEFAULT_ROW_HEIGHT = 30;
	private static final int DEFAULT_COLUMN_WIDTH = 150;

	private JTable table;
	private TableColumnModel columnModel;
	private int columnCount;
	
	private JButton btnGetAll;
	private JButton btnFindByID;	
	
	private ItemType itemType;
	private AbstractEntityTableModel<E> tableModel;
	
	public AncestorPanel(ItemType itemType, AbstractEntityTableModel<E> tableModel) 
	{
		this.itemType = itemType;
		this.tableModel = tableModel;
		initializeComponents();
	}

	private void initializeComponents() 
	{
		BoxLayout boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
		setLayout(boxLayout);
		{
			JPanel panelTop = new JPanel();
			{
				btnGetAll = VisualUtil.createButton("show all " + itemType + " news");
				panelTop.add(btnGetAll);
				
				btnFindByID = VisualUtil.createButton("show an item detail");
				panelTop.add(btnFindByID);
			}
			add(panelTop);
			
			
			JPanel panelBottom = new JPanel();
			{
				table = new JTable( tableModel );
				
				table.setRowHeight(DEFAULT_ROW_HEIGHT);
				
				columnModel = table.getColumnModel();
				columnCount = table.getColumnModel().getColumnCount();
				columnModel.getColumn(0).setPreferredWidth(DEFAULT_COLUMN_WIDTH);
				columnModel.getColumn(1).setPreferredWidth(DEFAULT_COLUMN_WIDTH);
				columnModel.getColumn(2).setPreferredWidth(DEFAULT_COLUMN_WIDTH);
				columnModel.getColumn(3).setPreferredWidth(DEFAULT_COLUMN_WIDTH);
				columnModel.getColumn(4).setPreferredWidth(DEFAULT_COLUMN_WIDTH);
				
				panelBottom.add( new JScrollPane(table) );
			}
			add(panelBottom);
		}
	}

	public void fillEntities(List<E> entityList)
	{
		tableModel.setEntities(entityList);
	}
	
	public JButton getBtnGetAll() {
		return btnGetAll;
	}

	public JButton getBtnFindByID() {
		return btnFindByID;
	}
		
}

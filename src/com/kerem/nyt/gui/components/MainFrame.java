package com.kerem.nyt.gui.components;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import com.kerem.nyt.gui.util.VisualUtil;
import com.kerem.nyt.model.utility.ItemType;

public class MainFrame 
{
	private ItemPanel sciencePanel;
	private ItemPanel worldPanel;
	
	private static final int DEFAULT_WIDTH = 800;
	private static final int DEFAULT_HEIGHT = 600;
	
	private static final String MAIN_FRAME_TITLE = "NYT NEWS AUTOMATION";
	private JFrame mainFrame;
	
	public MainFrame() 
	{
		initializeComponents();
	}

	private void initializeComponents() 
	{
		mainFrame = new JFrame();
		mainFrame.setTitle(MAIN_FRAME_TITLE);
		mainFrame.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		{
			/* science.png uri:
			 https://www.pngitem.com/pimgs/m
			 /425-4250229_vector-illustration-of-science-microscope-instrument-clip-art.png
			 */
			sciencePanel = new ItemPanel(ItemType.science);
			VisualUtil.addTab(tabbedPane, sciencePanel, ItemType.science);
		}
		
		{
			/* world.png uri:
			   https://c7.hotpng.com/preview/847/779/707/5bc002c6cbe81.jpg
			 */
			worldPanel = new ItemPanel(ItemType.world);
			VisualUtil.addTab(tabbedPane, worldPanel, ItemType.world);
		}
		
		mainFrame.add(tabbedPane);
	}
	
	public void show()
	{
		mainFrame.setVisible(true);
	}

	public ItemPanel getSciencePanel() {
		return sciencePanel;
	}

	public ItemPanel getWorldPanel() {
		return worldPanel;
	}
	
}

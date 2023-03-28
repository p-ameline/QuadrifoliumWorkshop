package org.quadrifolium.workshop.client.util;

import java.util.ArrayList;
import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.core.client.EntryPoint; 
import com.google.gwt.event.dom.client.ClickEvent; 
import com.google.gwt.event.dom.client.ClickHandler; 
import com.google.gwt.safehtml.shared.SafeHtmlBuilder; 
import com.google.gwt.user.cellview.client.CellTree; 
import com.google.gwt.user.client.ui.AbsolutePanel; 
import com.google.gwt.user.client.ui.Button; 
import com.google.gwt.user.client.ui.RootPanel; 
import com.google.gwt.view.client.ListDataProvider; 
import com.google.gwt.view.client.SingleSelectionModel; 
import com.google.gwt.view.client.TreeViewModel; 

public class MyCelltreeTest implements EntryPoint 
{ 
	private AbsolutePanel absolutePanel; 
	private CellTree cellTree; 
	private Button btnAdd; 
	private Button btnRemove; 
	private MyTreeModel myTreeModel; 
	private SingleSelectionModel<MyNode> selectionModelCellTree = null;
	
	public void onModuleLoad() 
	{ 
		RootPanel rootPanel = RootPanel.get(); 
		rootPanel.add(getAbsolutePanel(), 0, 0); 
	} 
	
	private AbsolutePanel getAbsolutePanel() 
	{ 
		if (absolutePanel == null) 
		{ 
			absolutePanel = new AbsolutePanel(); 
			absolutePanel.setSize("612px", "482px"); 
			absolutePanel.add(getCellTree(), 0, 0); 
			absolutePanel.add(getBtnAdd(), 265, 428); 
			absolutePanel.add(getBtnRemove(), 336, 428); 
		} 
		return absolutePanel; 
	} 
	
	private CellTree getCellTree() 
	{ 
		if (cellTree == null) 
		{ 
			myTreeModel = new MyTreeModel(); 
			cellTree = new CellTree(myTreeModel, null);    
			cellTree.setSize("285px", "401px"); 
		} 
		return cellTree; 
	} 
	
	private Button getBtnAdd() 
	{ 
		if (btnAdd == null) 
		{ 
			btnAdd = new Button("Add"); 
			btnAdd.addClickHandler(new ClickHandler() 
			  { 
					public void onClick(ClickEvent event) 
					{ 
						MyNode node = selectionModelCellTree.getSelectedObject(); 
						if(node != null) 
							myTreeModel.addNew(node, "Bla"); 
					} 
				}); 
		} 
		return btnAdd; 
	} 
	
	private Button getBtnRemove() 
	{ 
		if (btnRemove == null) 
		{ 
			btnRemove = new Button("Remove"); 
			btnRemove.addClickHandler(new ClickHandler() 
			  { 
					public void onClick(ClickEvent event) 
					{ 
						MyNode node = selectionModelCellTree.getSelectedObject(); 
						if(node != null) 
							myTreeModel.remove(node); 
					} 
				}); 
		} 
		return btnRemove; 
	} 
	
	public class MyNode 
	{ 
		private String name; 
		private ArrayList<MyNode> childs; //nodes childrens private 
		MyNode parent;                    //track internal parent 
		private MyCell cell;              //for refresh - reference to visual component 
		public MyNode(String name) 
		{ 
			super(); 
			parent = null; 
			this.name = name; 
			childs = new ArrayList<MyNode>(); 
		} 
		
		public void addSubMenu(MyNode m) 
		{ 
			m.parent = this; 
			childs.add(m); 
		} 
		
		public void removeMenu(MyNode m) { 
			m.getParent().childs.remove(m); 
		} 
		
		public boolean hasChildrens() { 
			return childs.size()>0; 
		} 
		
		public ArrayList<MyNode> getList() { 
			return childs;	
		} 
		
		public MyNode getParent() { 
			return parent; 
		} 
		
		public void setCell(MyCell cell) { 
			this.cell = cell; 
		} 
		
		public void refresh() { 
			if(parent!=null) { 
				parent.refresh(); 
			} 
			if (cell!=null) { 
				cell.refresh(); //refresh tree 
			} 
		} 
		
		public String getName() { 
			return name; 
		} 
		
		public void setName(String name) { 
			this.name = name; 
		} 
	} 
	
	public class MyTreeModel implements TreeViewModel 
	{ 
		private MyNode officialRoot; //default not dynamic 
		private MyNode studentRoot;  //default not dynamic 
		private MyNode testRoot;     //default not dynamic 
		private MyNode root; 
		
		public MyNode getRoot() { // to set CellTree root 
			return root; 
		} 
		
		public MyTreeModel() 
		{ 
			selectionModelCellTree = new SingleSelectionModel<MyNode>(); 
			root = new MyNode("root"); // Default items 
			officialRoot = new MyNode("Cat"); //some basic static data 
			studentRoot = new MyNode("Dog"); 
			testRoot = new MyNode("Fish"); 
			root.addSubMenu(officialRoot); 
			root.addSubMenu(studentRoot); 
			root.addSubMenu(testRoot); 
		} 
		
		//example of add add logic public 
		void addNew(MyNode myparent, String name) 
		{ 
			myparent.addSubMenu(new MyNode(name)); 
			myparent.refresh(); //HERE refresh tree 
		} 
		
		public void remove(MyNode objToRemove) 
		{ 
			objToRemove.removeMenu(objToRemove); 
			objToRemove.refresh(); 
		} 
		
		@Override public <T> NodeInfo<?> getNodeInfo(T value) 
		{ 
			ListDataProvider<MyNode> dataProvider; 
			MyNode myValue = null; 
			if (value == null) { // root is not set 
				dataProvider = new ListDataProvider<MyNode>(root.getList()); 
			} 
			else { 
				myValue = (MyNode) value; 
				dataProvider = new ListDataProvider<MyNode>(myValue.getList()); 
			} 
			
			MyCell cell = new MyCell(dataProvider); //HERE Add reference 
			if (myValue != null) 
				myValue.setCell(cell); 
			return new DefaultNodeInfo<MyNode>(dataProvider, cell, selectionModelCellTree, null); 
		} 
		
		@Override public boolean isLeaf(Object value) 
		{ 
			if (value instanceof MyNode) 
			{ 
				MyNode t = (MyNode) value; 
				if (!t.hasChildrens()) 
					return true; 
				return false; 
			} 
			return false; 
		} 
	} 
	
	public class MyCell extends AbstractCell<MyNode> 
	{ 
		ListDataProvider<MyNode> dataProvider; //for refresh public
		
		MyCell(ListDataProvider<MyNode> dataProvider) 
		{ 
			super(); 
			this.dataProvider = dataProvider; 
		} 
		
		public void refresh() 
		{ 
			dataProvider.refresh(); 
		} 
		
		@Override public void render(Context context, MyNode value, SafeHtmlBuilder sb) 
		{ 
			if (value == null) { 
				return; 
			} 
			sb.appendEscaped(value.getName()); 
		} 
	} 
}

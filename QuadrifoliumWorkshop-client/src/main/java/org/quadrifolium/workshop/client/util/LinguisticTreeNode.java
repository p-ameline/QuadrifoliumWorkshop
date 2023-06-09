package org.quadrifolium.workshop.client.util;

import java.util.ArrayList;
import java.util.List;

import org.quadrifolium.shared.ontology.FlexWithTraits;
import org.quadrifolium.shared.ontology.LemmaWithInflections;
import org.quadrifolium.shared.ontology.TripleWithLabel;

import org.quadrifolium.workshop.client.mvp_components.QuadrifoliumLemmasView;
import org.quadrifolium.workshop.client.mvp_components.QuadrifoliumComponentBaseDisplayModel.INTERFACETYPE;

/**
 * The LinguisticTreeNode is the object that contains information to be displayed in a cell
 * 
 * @author Philippe
 *
 */
public class LinguisticTreeNode
{ 
	private String               _name ;           // root
	private LemmaWithInflections _lemma ;          // lemma
	private FlexWithTraits       _inflection ;     // inflections
	private TripleWithLabel      _trait ;          // traits
		
	private final List<LinguisticTreeNode> _childs = new ArrayList<LinguisticTreeNode>() ; // nodes childrens 
	private       LinguisticTreeNode       _parent ;                                       // track internal parent
	
	private LinguisticTreeCell   _cell ;            //for refresh - reference to visual component
	
	public LinguisticTreeNode(LemmaWithInflections lemma, LinguisticTreeNode parent) 
	{
		super() ;
		
		_lemma      = lemma ;
		_inflection = null ;
		_trait      = null ;
		_name       = null ;
		
		connectToParent(parent) ;
	}
	
	public LinguisticTreeNode(FlexWithTraits inflection, LinguisticTreeNode parent) 
	{
		super() ;
		
		_lemma      = null ;
		_inflection = inflection ;
		_trait      = null ;
		_name       = null ;
		
		connectToParent(parent) ;
	}
	
	public LinguisticTreeNode(TripleWithLabel trait, LinguisticTreeNode parent) 
	{
		super() ;
		
		_lemma      = null ;
		_inflection = null ;
		_trait      = trait ;
		_name       = null ;
		
		connectToParent(parent) ;
	}
	
	public LinguisticTreeNode(final String name, LinguisticTreeNode parent) 
	{
		super() ;
		
		_lemma      = null ;
		_inflection = null ;
		_trait      = null ;
		_name       = name ;
		
		connectToParent(parent) ;
	} 
	
	/**
	 * Connect this node to its parent (declare the parent and add this node to parent's children list) 
	 */
	public void connectToParent(LinguisticTreeNode parent)
	{
		if (null == parent)
			_parent = null ;
		else
			parent.addSubNode(this) ;
	}
	
	/**
	 * Add a node as a child to this node (add to children list and declare this node as other's parent)
	 */
	public void addSubNode(LinguisticTreeNode m) 
	{ 
		m._parent = this ; 
		_childs.add(m) ; 
	}
	
	public void removeNode(LinguisticTreeNode m) { 
		m.getParent()._childs.remove(m) ; 
	} 
	
	public boolean hasChildrens() { 
		return _childs.size() > 0 ; 
	} 
	
	public List<LinguisticTreeNode> getList() { 
		return _childs ;	
	} 
	
	public LinguisticTreeNode getParent() { 
		return _parent ;
	} 
	
	public void setCell(LinguisticTreeCell cell) { 
		_cell = cell ;
	} 
	
	public void refresh(final INTERFACETYPE iInterfaceType, final QuadrifoliumLemmasView parentView) 
	{ 
		if (null != _parent)
			_parent.refresh(iInterfaceType, parentView) ;

		if (null != _cell)
			_cell.refresh(iInterfaceType, parentView) ; //refresh tree 
	}
	
	public String getName()
	{
		if (null != _name)
			return _name ;
		if (null != _trait)
			return _trait.getName() ;
		if (null != _inflection)
			return _inflection.getName() + " [" + _inflection.getCode() + "]" ;
		if (null != _lemma)
			return _lemma.getName() + " [" + _lemma.getCode() + "]" ;
		
		return "" ;
	}
	
	public String getCode()
	{
		if (null != _name)
			return "" ;
		if (null != _trait)
			return _trait.getObject() ;
		if (null != _inflection)
			return _inflection.getCode() ;
		if (null != _lemma)
			return _lemma.getCode() ;
		
		return "" ;
	}
	
	public void setContent(final String sName)
	{
		_name       = sName ;           
		_lemma      = null ;       
		_inflection = null ; 
		_trait      = null ;
	}
}

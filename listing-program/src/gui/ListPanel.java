/*
 * Copyright (c) 2010, 2016, Ask Andreas Vargset. All rights reserved.
 * All use without the author's permission is forbidden.
 */

package gui;

import java.awt.Color;
import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;

/**
 * XXX
 *
 * @author   Ask Andreas Vargset
 * @version  2.0, 2016-12-11
 * @see      gui.ListingGUI
 */
@SuppressWarnings( "serial" )
public class ListPanel extends EvilTreePanel {
	private JList<String> list; // TODO change to World
	private DefaultListModel<String> listModel; // TODO change to World
	private JScrollPane scrollPane;
	private final int PREFERRED_LIST_WIDTH = 150;
	private final int PREFERRED_LIST_HEIGHT = 278; // Minimum value.
	private ParallelGroup hpg, vpg;
	private SequentialGroup hsg, vsg;
	
	private class MyCellRender extends DefaultListCellRenderer {
		   @Override
		   public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
		       super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		       Color green = new Color( 0, 128, 0 );
		       Color orange = new Color( 230, 110, 0 );
		       Color red = new Color( 238, 0, 0 );
		       int grayValue = 128;
		       Color gray = new Color( grayValue, grayValue, grayValue );
		       if(value.toString().contains("W68")) {
		           Color fg = green;
		           setForeground(fg);
		       } else if(value.toString().contains("W65")) {
		           Color fg = orange;
		           setForeground(fg);
		       } else if(value.toString().contains("W6 ")) {
		           Color fg = red;
		           setForeground(fg);
		       } else  if(value.toString().contains("W61")) {
		           Color fg = gray;
		           setForeground(fg);
		       } else {
		           setForeground(list.getForeground());
		       }
		       return this;
		   }
		}
	
	/**
	 * Standard constructor.
	 * 
	 * @param  title
	 *         The title of this panel.
	 */
	public ListPanel( String title ) {
		super( title );

		listModel.addElement( "W68 NOW" );
		listModel.addElement( "W23 2 mins" );
		listModel.addElement( "W54 7 mins" );
		listModel.addElement( "W65 23 mins" );
		listModel.addElement( "W67 28 mins" );
		listModel.addElement( "W12 29 mins" );
		listModel.addElement( "W6 32 mins" );
		listModel.addElement( "W123 42 mins" );
		listModel.addElement( "W61 102 mins" );
		listModel.addElement( "W95 112 mins" );
		
		list.setCellRenderer( new MyCellRender() );
		
	} // end constructor(String)

	private void createHorizontalLayout() {		
			hsg.addComponent( scrollPane, GroupLayout.PREFERRED_SIZE,
				PREFERRED_LIST_WIDTH, Short.MAX_VALUE );
			hpg.addGroup( GroupLayout.Alignment.TRAILING, hsg );
			layout.setHorizontalGroup( hpg );
	} // end method createHorizontalLayout():void

	/**
	 * XXX
	 */
	@Override
	protected void createLayout() {
		createHorizontalLayout();
		createVerticalLayout();
	} // end method createLayout():void

	private void createVerticalLayout() {
			vsg.addComponent( scrollPane, GroupLayout.DEFAULT_SIZE,
				PREFERRED_LIST_HEIGHT, Short.MAX_VALUE );
			vpg.addGroup( vsg );
			layout.setVerticalGroup( vpg );
	} // end method createHorizontalLayout():void

	private void initGroups() {
		hpg = layout.createParallelGroup( Alignment.LEADING );
		vpg = layout.createParallelGroup( Alignment.LEADING );
		
		hsg = layout.createSequentialGroup();
		vsg = layout.createSequentialGroup();
	} // end method initGroups():void

	/**
	 * Initialises instance variables needed for the layout.
	 */
	protected void initLayout() {
		initList();
		initGroups();
	} // end method initLayout():void

	private void initList() {
		listModel = new DefaultListModel<>();
		list = new JList<>( listModel );
		scrollPane = new JScrollPane( list );
	} // end method initPanels():void
} // end class ListPanel
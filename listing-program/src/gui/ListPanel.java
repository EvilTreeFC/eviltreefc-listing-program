/*
 * Copyright (c) 2010, 2016, Ask Andreas Vargset. All rights reserved.
 * All use without the author's permission is forbidden.
 */

package gui;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import world.World;

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
	private JList<World> listUI; // TODO change to World
	private DefaultListModel<World> listModel; // TODO change to World
	private JScrollPane scrollPane;
	private final int PREFERRED_LIST_WIDTH = 150;
	private final int PREFERRED_LIST_HEIGHT = 278; // Minimum value.
	private ParallelGroup hpg, vpg;
	private SequentialGroup hsg, vsg;
	private HashMap<Integer, World> map;
	private ArrayList<World> list;

	private class MyCellRender extends DefaultListCellRenderer {
		@Override
		public Component getListCellRendererComponent(
			JList<?> list,
			Object value,
			int index,
			boolean isSelected,
			boolean cellHasFocus ) {
			
			super.getListCellRendererComponent( list, value, index, isSelected,
				cellHasFocus );
			
			World report = (World) value;
			
			Color green = new Color( 0, 128, 0 );
			Color orange = new Color( 230, 110, 0 );
			Color red = new Color( 238, 0, 0 );
			int grayValue = 128;
			Color gray = new Color( grayValue, grayValue, grayValue );
			
			long timeReported = report.getTimeReported();
			long timeDue = report.getTimeReported() + 
				TimeUnit.MINUTES.toMillis( report.getMinutes() );
			long timeUntilDue = timeDue - timeReported;
			long timeNow = System.currentTimeMillis();
			long nowMinusDue = timeDue - timeNow; // find better name
			int counter = 0;
			
//			JOptionPane.showMessageDialog( null,  TimeUnit.MILLISECONDS.toMinutes( nowMinusDue ) );
//			JOptionPane.showMessageDialog( null,  TimeUnit.MINUTES.toMillis( 145 ) );
			
			// TODO: FIX
			while ( TimeUnit.MILLISECONDS.toMinutes( nowMinusDue ) < -15 ) {
				nowMinusDue += TimeUnit.MINUTES.toMillis( 145 );
				counter++;
			} // end while
			
			if ( counter == 0 ) {
				Color fg = green;
				setForeground( fg );
			} else if ( counter == 1 ) {
				Color fg = orange;
				setForeground( fg );
			} else if ( counter < 10 ) {
				Color fg = red;
				setForeground( fg );
			} else if ( counter >= 10 ) {
				Color fg = gray;
				setForeground( fg );
			} else {
				JOptionPane.showMessageDialog( null,  System.currentTimeMillis() );
//				JOptionPane.showMessageDialog( null,  counter );
//				JOptionPane.showMessageDialog( null,  nowMinusDue );
				setForeground( list.getForeground() );
			} // end if...else
			return this;
		} // end method getListCellRendererComponent(JList<?>,Object,int,boolean,boolean):component
	} // end class MyCellRender

	/**
	 * Standard constructor.
	 * 
	 * @param  title
	 *         The title of this panel.
	 */
	public ListPanel( String title ) {
		super( title );
		
		long now = System.currentTimeMillis();
		// 10 000 seconds or 166,67 minutes or 2,78 hours
		int inc = 10000000;

		World world68 = new World( 68, 0, now - inc * 9 );
		World world23 = new World( 23, 2, now - inc * 2 );
		World world54 = new World( 54, 7, now - inc );
		World world65 = new World( 65, 23, now );

		insert( world23 );
		insert( world68 );
		insert( world65 );
		insert( world54 );

		listUI.setCellRenderer( new MyCellRender() );
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

	public DefaultListModel<World> getListModel() {
		return listModel;
	} // end method getListModel():DefaultListModel<World>

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
		list = new ArrayList<>();
		map = new HashMap<>();

		listModel = new DefaultListModel<>();
		listUI = new JList<>( listModel );
		scrollPane = new JScrollPane( listUI );
	} // end method initPanels():void

	public void insertReport( World report ) {
		if ( report == null ) {
			throw new IllegalArgumentException();
		} // end if

		insert( report );
	} // end method insertReport(World):void

	private void insert( World report ) {
		if ( map.containsKey( report.getWorld() ) ) {
			// Duplicate entry
			replaceDuplicateReportWith( report );
		} else {
			// New entry
			int index = determineIndex( report );
			insertToAll( report, index );
		} // end if...else
	} // end method insert(World):void

	private void replaceDuplicateReportWith( World report ) {
		for ( int i = 0; i < list.size(); i++ ) {
			World reportInList = list.get( i );
			
			if ( reportInList.getWorld() == report.getWorld() ) {
				removeReport( reportInList, i );
				insert( report );
			} // end if
		} // end for
	} // end method replaceDuplicateReportWith(World):void

	private void removeReport( World report, int index ) {
		map.remove( report.getWorld(), report );
		list.remove( index );
		listModel.remove( index );
	} // end method removeReport(World,int):void

	private void insertToAll( World report, int index ) {
		map.put( report.getWorld(), report );
		list.add( index, report );
		listModel.add( index, report );
	} // end method insertToAll(World,int):void

	private int determineIndex( World report ) {
		if ( list.size() == 0 ) {
			return 0;
		} // end if

		int index = 0;

		while ( index < list.size() ) {
			// Keep looping until report is less than current element.
			if ( report.compareTo( list.get( index ) ) == -1 ) {
				return index;
			} // end if

			index++;
		} // end while

		return index;
	} // end method determineIndex(World):int
} // end class ListPanel
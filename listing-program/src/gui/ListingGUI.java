/*
 * Copyright (c) 2010, 2016, Ask Andreas Vargset. All rights reserved.
 * All use without the author's permission is forbidden.
 */

package gui;

import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;

/**
 * XXX
 *
 * @author   Ask Andreas Vargset
 * @version  2.0, 2016-12-11
 * @see      main.Listing
 */
@SuppressWarnings( "serial" )
public class ListingGUI extends JFrame {
	public static final Color BG_COLOUR = new Color( 156, 193, 95 );
	private ButtonPanel buttonPanel;
	private CreditPanel creditPanel;
	
	private GroupLayout layout;
	private ListPanel listPanel;
	
	private ParallelGroup hpg, hpgInner, vpg, vpgInner;
	private SequentialGroup hsg, vsg, vsgInner;

	public ListingGUI() {
		initLayout();
		createLayout();

		getContentPane().setBackground( BG_COLOUR );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		pack();
		setVisible( true );
	} // end constructor()

	private void createHorizontalLayout() {
		hsg.addContainerGap();
		
		hpgInner.addComponent( creditPanel, Alignment.LEADING,
			GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
			Short.MAX_VALUE );
		
		hpgInner.addComponent( buttonPanel, Alignment.LEADING,
			GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
			Short.MAX_VALUE );
		
		hsg.addGroup( hpgInner );
		hsg.addPreferredGap( ComponentPlacement.RELATED );
		
		hsg.addComponent( listPanel, GroupLayout.DEFAULT_SIZE,
			GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE );
		
		hsg.addContainerGap();
		hpg.addGroup( hsg );
	} // end method createHorizontalLayout():void

	private void createLayout() {
		// TODO: try to remove contentPane after layout is done
		getContentPane().setLayout( layout );
		
		createHorizontalLayout();
		createVerticalLayout();
		
		layout.setHorizontalGroup( hpg );
		layout.setVerticalGroup( vpg );
	} // end method createLayout():void

	private void createVerticalLayout() {
		vsg.addContainerGap();
		
		vpgInner.addComponent( listPanel, GroupLayout.DEFAULT_SIZE,
			GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE );
		
		vsgInner.addComponent( buttonPanel, GroupLayout.PREFERRED_SIZE,
			GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE );
		
		vsgInner.addPreferredGap( ComponentPlacement.RELATED );
		
		vsgInner.addComponent( creditPanel, GroupLayout.DEFAULT_SIZE,
			GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE );
		
		vpgInner.addGroup( vsgInner );
		vsg.addGroup( vpgInner );
		vsg.addContainerGap();
		vpg.addGroup( Alignment.TRAILING, vsg);
	} // end method createVerticalLayout():void

	private void initGroups() {
		layout = new GroupLayout( getContentPane() );
		
		hpg = layout.createParallelGroup( Alignment.LEADING );
		hpgInner = layout.createParallelGroup( Alignment.TRAILING, false );
		
		vpg = layout.createParallelGroup( Alignment.LEADING );
		vpgInner = layout.createParallelGroup( Alignment.TRAILING );
		
		hsg = layout.createSequentialGroup();
		
		vsg = layout.createSequentialGroup();
		vsgInner = layout.createSequentialGroup();
	} // end method initGroups():void

	/**
	 * Initialises instance variables needed for the layout.
	 */
	private void initLayout() {
		initPanels();
		initGroups();
	} // end method initLayout():void

	private void initPanels() {
		buttonPanel = new ButtonPanel( "Functions" );
		creditPanel = new CreditPanel( "Credits" );
		listPanel = new ListPanel( "The List" );
	} // end method initPanels():void
} // end class ListingGUI
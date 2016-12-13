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
		buttonPanel = new ButtonPanel( "Functions" );
		creditPanel = new CreditPanel( "Credits" );
		listPanel = new ListPanel( "The List" );

		createLayout();

		getContentPane().setBackground( BG_COLOUR );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		pack();
		setVisible( true );
	} // end constructor()

	private void createLayout() {
		// TODO: try to remove contentPane after layout is done
		layout = new GroupLayout( getContentPane() );
		getContentPane().setLayout( layout );

		// TODO: FIX THIS MESSY CODE
		// adding / placing the panels on the horizontal line
		hpg = layout.createParallelGroup( Alignment.LEADING );
		hsg = layout.createSequentialGroup();
		hsg.addContainerGap();
		hpgInner = layout.createParallelGroup(Alignment.TRAILING, false );
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
		layout.setHorizontalGroup( hpg ); // end Horizontal group

		// adding / placing the panels on the vertical line
		vpg = layout.createParallelGroup( Alignment.LEADING );
		vsg = layout.createSequentialGroup();
		vsg.addContainerGap();
		vpgInner = layout.createParallelGroup( Alignment.TRAILING );
		vpgInner.addComponent( listPanel, GroupLayout.DEFAULT_SIZE,
			GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE );
		vsgInner = layout.createSequentialGroup();
		vsgInner.addComponent( buttonPanel, GroupLayout.PREFERRED_SIZE,
			GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE );
		vsgInner.addPreferredGap( ComponentPlacement.RELATED );
		vsgInner.addComponent( creditPanel, GroupLayout.DEFAULT_SIZE,
			GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE );
		vpgInner.addGroup( vsgInner );
		vsg.addGroup( vpgInner ) // add group
				.addContainerGap();
		vpg.addGroup( Alignment.TRAILING, vsg);
		layout.setVerticalGroup( vpg ); // end Vertical group
	} // end method createLayout():void
} // end class ListingGUI
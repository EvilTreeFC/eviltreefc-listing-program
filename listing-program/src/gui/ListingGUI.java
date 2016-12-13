/*
 * Copyright (c) 2010, 2016, Ask Andreas Vargset. All rights reserved.
 * All use without the author's permission is forbidden.
 */

package gui;

import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.LayoutStyle;

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

		// TODO: FIX THIS MESSY AUTO GENERATED CODE
		// adding / placing the panels on the horizontal line
		layout.setHorizontalGroup(
			layout.createParallelGroup( GroupLayout.Alignment.LEADING )
			.addGroup( layout.createSequentialGroup()
				.addContainerGap()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false )
					.addComponent( creditPanel, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
						GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent( buttonPanel, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
						GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE )
					) // add group
				.addPreferredGap( LayoutStyle.ComponentPlacement.RELATED )
				.addComponent( listPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE )
				.addContainerGap()
				) // add group
			); // end Horizontal group

		// adding / placing the panels on the vertical line
		layout.setVerticalGroup(
			layout.createParallelGroup( GroupLayout.Alignment.LEADING )
			.addGroup( GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
				.addContainerGap()
				.addGroup( layout.createParallelGroup( GroupLayout.Alignment.TRAILING )
					.addComponent( listPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE )
					.addGroup( layout.createSequentialGroup()
						.addComponent( buttonPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
							GroupLayout.PREFERRED_SIZE )
						.addPreferredGap( LayoutStyle.ComponentPlacement.RELATED )
						.addComponent( creditPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
							Short.MAX_VALUE )
						) // add group
					) // add group
				.addContainerGap()
				) // add group
			); // end Vertical group
	} // end method createLayout():void
} // end class ListingGUI
/*
 * Copyright (c) 2010, 2016, Ask Andreas Vargset. All rights reserved.
 * All use without the author's permission is forbidden.
 */

package gui;

import javax.swing.JLabel;

import javax.swing.LayoutStyle.ComponentPlacement;

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
public class CreditPanel extends EvilTreePanel {
	private JLabel[] creditLabels;
	private ParallelGroup hpg, hpgInner, vpg;
	private SequentialGroup hsg, vsg;

	// TODO: Evil Tree FC and its members? Testers? Everyone listing? Feedback?
	// People who shared ideas? How to do mist000/iron mist?
	public final static String[] CREDITS = { "Version " + main.Listing.version,
			" ", "Made by: ", "Mist0__0__0 / Iron Mist", " ",
			"Special thanks to:", "Sskraeling", "Raven Risen", "Whiz",
	"Evil Tree FC" };

	/**
	 * Standard constructor.
	 * 
	 * @param  title
	 *         The title of this panel.
	 */
	public CreditPanel( String title ) {
		super( title );
	} // end constructor(String)

	/**
	 * Adds the JLabels stored in {@code creditLabels} to this panel.
	 */
	private void addLabels() {
		for ( int i = 0; i < creditLabels.length; i++ ) {
			hpg.addComponent( creditLabels[i] );
			vsg.addComponent( creditLabels[i] );
		} // end for
	} // end method createLayout():void

	/**
	 * XXX
	 */
	@Override
	protected void createLayout() {
		hsg.addContainerGap(); // TODO: check if needed
		hsg.addGroup( hpgInner );
		hpg.addGroup( hsg );
		layout.setHorizontalGroup( hpg );

		vpg.addGroup( vsg );
		layout.setVerticalGroup( vpg );

		addLabels();

		hsg.addContainerGap( 0, Short.MAX_VALUE );
		vsg.addPreferredGap( ComponentPlacement.RELATED );
		vsg.addContainerGap( 0, Short.MAX_VALUE );
	} // end method createLayout():void

	/**
	 * Instantiates and initialises JLabels that display the credits.
	 */
	private void initLabels() {
		creditLabels = new JLabel[CREDITS.length];

		for ( int i = 0; i < creditLabels.length; i++ ) {
			creditLabels[i] = new JLabel( CREDITS[i] );
		} // end for
	} // end method initLabels():void

	/**
	 * Initialises instance variables needed for the layout.
	 */
	@Override
	protected void initLayout() {
		initLabels();
		initGroups();
	} // end method initLayout():void

	/**
	 * Initialises groups used in the layout.
	 */
	private void initGroups() {
		hpg = layout.createParallelGroup( Alignment.LEADING );
		hpgInner = layout.createParallelGroup( Alignment.LEADING );
		vpg = layout.createParallelGroup( Alignment.LEADING );

		hsg = layout.createSequentialGroup();
		vsg = layout.createSequentialGroup();
	} // end method initLayout():void
} // end class CreditPanel
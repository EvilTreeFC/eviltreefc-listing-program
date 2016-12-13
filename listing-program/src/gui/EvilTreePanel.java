/*
 * Copyright (c) 2010, 2016, Ask Andreas Vargset. All rights reserved.
 * All use without the author's permission is forbidden.
 */

package gui;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JPanel;

import javax.swing.border.TitledBorder;

/**
 * XXX
 *
 * @author   Ask Andreas Vargset
 * @version  2.0, 2016-12-11
 * @see      gui.ListingGUI
 */
@SuppressWarnings( "serial" )
public abstract class EvilTreePanel extends JPanel {
	/**
	 * The standard border for EvilTreePanels.
	 */
	protected TitledBorder border;
	
	/**
	 * The {@code LayoutManager} to be used by this {@code EvilTreePanel}.
	 */
	protected GroupLayout layout;
	
	/**
	 * The title of this {@code EvilTreePanel}.
	 */
	protected String title;
	
	/**
	 * The standard {@code Font} to be used in the header of EvilTreePanels.
	 */
	public static final Font TITLE_FONT = new Font( "Tahoma", 1, 12 );
	
	/**
	 * Standard constructor.
	 * 
	 * @param  title
	 *         The title of this panel.
	 */
	public EvilTreePanel( String title ) {
		this.title = title;
		layout = new GroupLayout( this );
		border = BorderFactory.createTitledBorder(
			null, this.title, TitledBorder.LEADING, TitledBorder.TOP,
			TITLE_FONT );
		
		setLayout( layout );
		setBorder( border );
		setBackground( ListingGUI.BG_COLOUR );
		
		initLayout();
		createLayout();
	} // end constructor()
	
	/**
	 * Initialises variables and/or components used in the panel's layout.
	 */
	protected abstract void initLayout();
	
	/**
	 * Creating the visual layout; setting groups, adding components, adding
	 * gaps, etc.
	 */
	protected abstract void createLayout();
} // end class EvilTreePanel
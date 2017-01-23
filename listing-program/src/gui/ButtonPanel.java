/*
 * Copyright (c) 2010, 2016, Ask Andreas Vargset. All rights reserved.
 * All use without the author's permission is forbidden.
 */

package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;

import javax.swing.LayoutStyle.ComponentPlacement;

/**
 * XXX
 *
 * @author   Ask Andreas Vargset
 * @version  2.0, 2016-12-11
 * @see      gui.ListingGUI
 */
@SuppressWarnings( "serial" )
public class ButtonPanel extends EvilTreePanel {
	private ButtonListener buttonListener;
	private JButton[] buttons;
	private static String[] text = { "Submit", "Sap" ,"Tree", "50 %", "25 %",
			"KO", "Unk %", "Undo", "Reset", "Settings" };
	private ParallelGroup hpg, hpgInner, vpg;
	private SequentialGroup hsg, vsg;
	
	/**
	 * Standard constructor.
	 * 
	 * @param  title
	 *         The title of this panel.
	 */
	public ButtonPanel( String title ) {
		super( title );
		
		
	} // end constructor(String)
	
	private void addButtonsHorizontally() {
		int gap = 3;
        hsg.addGap( gap, gap, gap );
		
		for ( int i = 0; i < buttons.length; i++ ) {
            hsg.addGap( gap );
			hpgInner.addComponent( buttons[i] );
		} // end for
	} // end method addButtons():void
	
	private void addButtonsVertically() {
		for ( int i = 0; i < buttons.length; i++ ) {
			vsg.addComponent( buttons[i] );
			
			if ( i == buttons.length - 1 ) {
				vsg.addPreferredGap( ComponentPlacement.RELATED );
			} else {
				vsg.addPreferredGap( ComponentPlacement.RELATED,
					GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE );
			} // end if...else
		} // end for
	} // end method addButtons():void

	private void createHorizontalLayout() {		
		addButtonsHorizontally();
        
		hsg.addContainerGap();
		hsg.addGroup( hpgInner );
        hsg.addContainerGap( 1, Short.MAX_VALUE );
        hpg.addGroup( hsg );
    
        layout.setHorizontalGroup( hpg );

        // sets resizing behaviour
        layout.linkSize( SwingConstants.HORIZONTAL, buttons );
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
		addButtonsVertically();
		
		vpg.addGroup( vsg );
		
        layout.setVerticalGroup( vpg );
	} // end method createVerticalLayout():void

	private void initButtons() {
		buttons = new JButton[text.length];
		buttonListener = new ButtonListener();
		
		// Allows for the ENTER and SPACEBAR keys to trigger events.
		UIManager.put("Button.defaultButtonFollowsFocus", Boolean.TRUE);
		
		for ( int i = 0; i < buttons.length; i++ ) {
			buttons[i] = new JButton( text[i] );
			buttons[i].addActionListener( buttonListener );
		} // end for
	} // end method initButtons():void

	private void initGroups() {
		hpg = layout.createParallelGroup( Alignment.LEADING );
		hpgInner = layout.createParallelGroup( Alignment.LEADING );
		vpg = layout.createParallelGroup( Alignment.LEADING );

		hsg = layout.createSequentialGroup();
		vsg = layout.createSequentialGroup();
	} // end method initGroups():void

	/**
	 * XXX
	 */
	@Override
	protected void initLayout() {
		initButtons();
		initGroups();
	} // end method initLayout():void
	
	private class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed( ActionEvent e ) {
			control.handleButtonEvent( e );
		} // end method actionPerformed(ActionEvent):void
	} // end class ButtonListener
} // end class ButtonPanel
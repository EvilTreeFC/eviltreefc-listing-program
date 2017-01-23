package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;

import javax.swing.LayoutStyle.ComponentPlacement;

@SuppressWarnings( "serial" )
public class InputPanel extends EvilTreePanel {
	private InputListener inputListener;
	private JLabel[] labels;
	private final static String[] LABEL_TEXT = { "World: ", "Minutes: " };
	private JTextField[] textFields;

	private ParallelGroup hpg, hpgInner, vpg, vpgInnerWorld, vpgInnerMinutes;
	private SequentialGroup hsg, hsgInnerWorld, hsgInnerMinutes, vsg;

	public InputPanel( String title ) {
		super( title );
	} // end constructor(String)
	
	private void addComponentsHorizontally() {
		hsgInnerMinutes.addComponent( labels[0] );
		hsgInnerMinutes.addPreferredGap( ComponentPlacement.RELATED,
			GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE );
		hsgInnerMinutes.addComponent( textFields[0], GroupLayout.PREFERRED_SIZE,
			GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE );

		hsgInnerWorld.addComponent( labels[1] );
		hsgInnerWorld.addPreferredGap( ComponentPlacement.RELATED,
			GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE );
		hsgInnerWorld.addComponent( textFields[1], GroupLayout.PREFERRED_SIZE,
			GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE );
		
	} // end method addButtons():void
	
	private void addComponentsVertically() {
		vpgInnerWorld.addComponent( labels[0] );
        vpgInnerWorld.addComponent( textFields[0], GroupLayout.PREFERRED_SIZE,
        	GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE );

        vpgInnerMinutes.addComponent( labels[1] );
        vpgInnerMinutes.addComponent( textFields[1], GroupLayout.PREFERRED_SIZE,
        	GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE );
	} // end method addButtons():void
	
	public JTextField getMinutesTextField() {
		return textFields[1];
	} // end method getMinutesTextField():JTextField
	
	public JTextField[] getTextFields() {
		return textFields;
	} // end method getTextFields():JTextField[]
	
	public JTextField getWorldTextField() {
		return textFields[0];
	} // end method getWorldTextField():JTextField

	private void initGroups() {
		hpg = layout.createParallelGroup( Alignment.LEADING );
		hpgInner = layout.createParallelGroup( Alignment.TRAILING, false );
		
		vpg = layout.createParallelGroup( Alignment.LEADING );
		vpgInnerWorld = layout.createParallelGroup( Alignment.BASELINE );
		vpgInnerMinutes = layout.createParallelGroup( Alignment.BASELINE );

		hsg = layout.createSequentialGroup();
		hsgInnerWorld = layout.createSequentialGroup();
		hsgInnerMinutes = layout.createSequentialGroup();
		
		vsg = layout.createSequentialGroup();
	} // end method initGroups():void

	private void initLabels() {
		labels = new JLabel[LABEL_TEXT.length];
		
		for ( int i = 0; i < labels.length; i++ ) {
			labels[i] = new JLabel( LABEL_TEXT[i] );
		} // end for
	} // end method initLabels():void

	@Override
	protected void initLayout() {
		initLabels();
		initTextFields();
		initGroups();
	} // end method initLayout():void

	private void initTextFields() {
		textFields = new JTextField[LABEL_TEXT.length];
		inputListener = new InputListener();
		
		for ( int i = 0; i < textFields.length; i++ ) {
			textFields[i] = new JTextField( 3 );
			textFields[i].addActionListener( inputListener );
			textFields[i].setActionCommand( LABEL_TEXT[i] );
		} // end for
	} // end method initTextFields():void

	private void createHorizontalLayout() {
		addComponentsHorizontally();

		hsg.addContainerGap();
		
		hpgInner.addGroup( hsgInnerMinutes );
		hpgInner.addGroup( hsgInnerWorld );
		
		hsg.addGroup( hpgInner );
        hsg.addGap( 0, 0, Short.MAX_VALUE );
        hsg.addContainerGap( GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE );
		
        hpg.addGroup( hsg );
        
		layout.setHorizontalGroup( hpg );
	} // end method createHorizontalLayout():void

	@Override
	protected void createLayout() {
		createHorizontalLayout();
		createVerticalLayout();
	} // end method createLayout():void

	private void createVerticalLayout() {
		addComponentsVertically();
		
		int gapSize = 14;
		
		vsg.addContainerGap();
        vsg.addGroup( vpgInnerWorld );
        vsg.addGap( gapSize, gapSize, gapSize );
        vsg.addGroup( vpgInnerMinutes );
        vsg.addContainerGap( GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE );
		
		vpg.addGroup( vsg );

		layout.setVerticalGroup( vpg );
	} // end method createVerticalLayout():void
	
	private class InputListener implements ActionListener {
		@Override
		public void actionPerformed( ActionEvent e ) {
			control.handleInputEvent( e );
		} // end method actionPerformed(ActionEvent):void
	} // end class ButtonListener
} // end class InputPanel
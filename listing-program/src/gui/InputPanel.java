package gui;

import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;

import javax.swing.LayoutStyle.ComponentPlacement;

@SuppressWarnings( "serial" )
public class InputPanel extends EvilTreePanel {
	private JLabel[] labels;
	private final static String[] LABEL_TEXT = { "World: ", "Minutes: " };
	private JTextField[] textFields;

	private ParallelGroup hpg, hpgInner, vpg;
	private SequentialGroup hsg, vsg;

	public InputPanel( String title ) {
		super( title );
	} // end constructor(String)
	
	private void addComponentsHorizontally() {
		for ( int i = 0; i < LABEL_TEXT.length; i++ ) {

		} // end for
	} // end method addButtons():void
	
	private void addComponentsVertically() {
		for ( int i = 0; i < LABEL_TEXT.length; i++ ) {

		} // end for
	} // end method addButtons():void

	private void initGroups() {
		hpg = layout.createParallelGroup( Alignment.LEADING );
		hpgInner = layout.createParallelGroup( Alignment.TRAILING, false );
		
		vpg = layout.createParallelGroup( Alignment.LEADING );
		
		hsg = layout.createSequentialGroup();
		
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
		
		for ( int i = 0; i < textFields.length; i++ ) {
			textFields[i] = new JTextField( 3 );
		} // end for
	} // end method initTextFields():void

	private void createHorizontalLayout() {
		addComponentsHorizontally();
	} // end method createHorizontalLayout():void

	@Override
	protected void createLayout() {
		createHorizontalLayout();
		createVerticalLayout();
		
		layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addComponent(labels[0])
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                        .addComponent(textFields[0], javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                    .addGroup(layout.createSequentialGroup()
	                        .addComponent(labels[1])
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                        .addComponent(textFields[1], javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                		.addGap(0, 0, Short.MAX_VALUE)
	                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );
		layout.setVerticalGroup(
	        		layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(labels[0])
	                    .addComponent(textFields[0], javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(14, 14, 14)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(labels[1])
	                    .addComponent(textFields[1], javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );
	} // end method createLayout():void

	private void createVerticalLayout() {
		addComponentsVertically();
	} // end method createVerticalLayout():void
} // end class InputPanel
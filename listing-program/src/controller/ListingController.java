package controller;

import gui.ButtonPanel;
import gui.CreditPanel;
import gui.InputPanel;
import gui.ListPanel;

import java.awt.event.ActionEvent;

import java.text.SimpleDateFormat;

import java.util.Date;

import javax.swing.JOptionPane;

import util.ReportValidater;
import util.TimeUtilities;

import world.World;

public class ListingController {
	private ButtonPanel buttonPanel;
	private CreditPanel creditPanel;
	private InputPanel inputPanel;
	private ListPanel listPanel;

	private String calculateMinutesLeft( ActionEvent e ) {
		return TimeUtilities.computeMinutes( e.getActionCommand() );
	} // end method calculateMinutesLeft(ActionEvent):String
	
	public ButtonPanel getButtonPanel() {
		return buttonPanel;
	} // end method getButtonPanel():ButtonPanel
	
	public CreditPanel getCreditPanel() {
		return creditPanel;
	} // end method getCreditPanel():CreditPanel
	
	public InputPanel getInputPanel() {
		return inputPanel;
	} // end method getInputPanel():InputPanel
	
	public ListPanel getListPanel() {
		return listPanel;
	} // end method getListPanel():ListPanel
	
	public void handleButtonEvent( ActionEvent e ) {
		switch( e.getActionCommand() ) {
			case "Unk %":
				unknownPercentagePressed( e );
				break;
			case "Undo":
				undoPressed( e );
				break;
			case "Reset":
				resetPressed( e );
				break;
			case "Settings":
				settingsPressed( e );
				break;
			default:
				reportButtonPressed( e );
				break;
		} // end switch
	} // end method handleButtonEvent(ActionEvent):void

	public void handleInputEvent( ActionEvent e ) {
		if ( e.getActionCommand().equalsIgnoreCase( "World: " ) ) {
			enterPressedWorld( e );
		} else if ( e.getActionCommand().equalsIgnoreCase( "Minutes: " ) ) {
			enterPressedMinutes( e );
		} else {
			throw new IllegalStateException();
		} // end if...else
	} // end method handleInputEvent(ActionEvent):void

	private void enterPressedMinutes( ActionEvent e ) {
		String world = inputPanel.getWorldTextField().getText();
		String minutes = inputPanel.getMinutesTextField().getText();
		
		reportWorld( world, minutes );
	} // end method enterPressedMinutes(ActionEvent):void

	private void resetInputFields() {
		inputPanel.getMinutesTextField().setText( "" );
		inputPanel.getWorldTextField().setText( "" );
		inputPanel.getWorldTextField().requestFocusInWindow();
	} // end method resetInputFields():void

	private void enterPressedWorld( ActionEvent e ) {
		inputPanel.getMinutesTextField().requestFocusInWindow();
	} // end method enterPressedWorld(ActionEvent):void

	private void resetPressed( ActionEvent e ) {
		JOptionPane.showMessageDialog( buttonPanel.getParent(),
			"Reset" );
	} // end method resetPressed(ActionEvent):void

	public void setButtonPanel( ButtonPanel buttonPanel ) {
		this.buttonPanel = buttonPanel;
	} // end method setButtonPanel(ButtonPanel):void
	
	public void setCreditPanel( CreditPanel creditPanel ) {
		this.creditPanel = creditPanel;
	} // end method setCreditPanel(CreditPanel):void
	
	public void setInputPanel( InputPanel inputPanel ) {
		this.inputPanel = inputPanel;
	} // end method setInputPanel(InputPanel):void
	
	public void setListPanel( ListPanel listPanel ) {
		this.listPanel = listPanel;
	} // end method setListPanel(ListPanel):void

	private void settingsPressed( ActionEvent e ) {
		JOptionPane.showMessageDialog( buttonPanel.getParent(),
			"Settings" );
	} // end method settingsPressed(ActionEvent):void

	private void reportButtonPressed( ActionEvent e ) {
		String world = inputPanel.getWorldTextField().getText();
		String minutes;
		
		if ( e.getActionCommand().equals( "Submit" ) ) {
			minutes = inputPanel.getMinutesTextField().getText();
		} else {
			minutes = calculateMinutesLeft( e );
		} // end if...else

		reportWorld( world, minutes );
	} // end method reportButtonPressed(ActionEvent):void
	
	private void reportWorld( String world, String minutes ) {
		boolean dataIsOk = ReportValidater.isDataValid( world, minutes );
		
		if ( dataIsOk ) {
			updateWorld( world, minutes );
			resetInputFields();
		} else {
			JOptionPane.showMessageDialog( buttonPanel.getParent(),
				"Error: bad input" );
		} // end if...else
	} // end method reportWorld(String,String):void

	private void undoPressed( ActionEvent e ) {
		// TODO Auto-generated method stub
		
	} // end method unknownPercentagePressed(ActionEvent):void
	
	private void unknownPercentagePressed( ActionEvent e ) {
		// TODO: fix
		reportWorld(
			inputPanel.getWorldTextField().getText(),
			"134" );
	} // end method unknownPercentagePressed(ActionEvent):void

	private void updateWorld( String world, String minutes ) {
		World report = new World(
			Integer.parseInt( world ),
			Integer.parseInt( minutes ),
			System.currentTimeMillis() );
		
		long ms = report.getTimeReported();
//		LocalDateTime ldt = LocalDateTime.of(2014, 5, 29, 18, 41, 16);
//		ZonedDateTime zdt = ldt.atZone(ZoneId.of("Europe/Paris"));
//		long millis = zdt.toInstant().toEpochMilli();
		SimpleDateFormat sdf = new SimpleDateFormat( "yyyy.MM.dd G 'at' HH:mm:ss z" );

		Date msDate = new Date( ms );
//		long milliseconds = msDate.getTime();
		String date = sdf.format( msDate );
		

		JOptionPane.showMessageDialog( buttonPanel.getParent(),
			ms + "     =    " + date + "   =   time reported according to computer" );
		listPanel.insertReport( report );
	} // end method updateWorld(String,String):void
} // end class ListingController
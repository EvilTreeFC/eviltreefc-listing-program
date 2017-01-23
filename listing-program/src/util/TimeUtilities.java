package util;

public final class TimeUtilities {
	public final static long ONE_ROTATION = 1;
	
	/**
	 * Constructor declared {@code private} in order to suppress the default
	 * constructor, ensuring that {@code TimeUtilities} cannot be
	 * instantiated.
	 */
	private TimeUtilities() {
		
	} // end constructor

	public static String computeMinutes( String actionCommand ) {
		String minutes = null;
		
		switch( actionCommand ) {
			case "Sap":
				minutes = "149";
				break;
			case "Tree":
				minutes = "144";
				break;
			case "50 %":
				minutes = "134";
				break;
			case "25 %":
				minutes = "124";
				break;
			case "KO":
				minutes = "114";
				break;
			default:
				break;
		} // end switch
		
		return minutes;
	} // end method computeMinutes(String):String
} // end class TimeUtilities
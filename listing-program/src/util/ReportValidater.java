package util;

import java.util.regex.Pattern;

import world.Worlds;

public final class ReportValidater {
	/**
	 * Constructor declared {@code private} in order to suppress the default
	 * constructor, ensuring that {@code ReportValidater} cannot be
	 * instantiated.
	 */
	private ReportValidater() {
		
	} // end constructor()
	
	public static boolean isDataValid( String world, String minutes ) {
		return isWorldDataValid( world ) && isMinutesDataValid( minutes );
	} // end method isDataValid(String,String):boolean
	
	public static boolean isMinutesDataValid( String minutes ) {
		return minutes != null &&
				isNumber( minutes ) &&
				isMinutesWithinRange( minutes );
	} // end method isMinutesDataValid(String):boolean

	public static boolean isMinutesWithinRange( String minutes ) {
		int mins = Integer.parseInt( minutes );
		return mins >= 0 && mins <= 149;
	} // end method isMinutesWithinRange(String):boolean

	public static boolean isWorldDataValid( String world ) {
		return world != null &&
				isNumber( world ) &&
				Worlds.isValid( Integer.parseInt( world ) );
	} // end method isWorldDataValid(String):boolean
	
	private static boolean isNumber( String s ) {
		String regex = "[0-9]+";
		Pattern pattern = Pattern.compile( regex );
		return pattern.matcher( s ).matches();
	} // end method isNumber(String):boolean
} // end class ReportValidater
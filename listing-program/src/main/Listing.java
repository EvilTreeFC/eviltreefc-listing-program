/*
 * Copyright (c) 2010, 2016, Ask Andreas Vargset. All rights reserved.
 * All use without the author's permission is forbidden.
 */

package main;

import gui.ListingGUI;

/**
 * {@code Listing} is the starting point of this application. It instantiates
 * class {@code ListingGUI} from the package gui.
 *
 * @author   Ask Andreas Vargset
 * @version  2.0, 2016-12-11
 * @see      gui.ListingGUI
 */
public class Listing {
	public static void main( String[] args ) {
		new ListingGUI();
	} // end method main(String[]):void
} // end class Listing
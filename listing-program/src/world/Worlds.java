/*
 * Copyright (c) 2010, 2016, Ask Andreas Vargset and/or his affiliates.
 * All rights reserved.
 */

package world;

/**
 * XXX
 *
 * @author   Ask Andreas Vargset
 * @version  2.0, 2016-12-11
 * @see      world.World
 */
public final class Worlds {
	/**
	 * Constructor declared {@code private} in order to suppress the default
	 * constructor, ensuring that {@code Worlds} cannot be
	 * instantiated.
	 */
	private Worlds() {
		
	} // end constructor()
	
	/**
	 * Method that checks if the {@code world} is XXX criterias (valid)
	 * 
	 * @param  world
	 *         The integer that is associated with the {@code world}.
	 * 
	 * @return  {@code true} if world is valid, {@code false} otherwise.
	 */
	public static boolean isWorldValid( int world ) {
		// TODO: cross reference with worlds.
		return true;
	} // end method isWorldValid(int):boolean
} // end class Worlds
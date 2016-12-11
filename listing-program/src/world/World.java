/*
 * Copyright (c) 2010, 2016, Ask Andreas Vargset and/or his affiliates.
 * All rights reserved.
 */

package world;

/**
 * This class represents a world in RuneScape.
 *
 * @author   Ask Andreas Vargset
 * @version  2.0, 2016-12-11
 * @see      report.Report
 * @see      world.Worlds
 */
public class World {
	/**
	 * The integer that is associated with this {@code World}.
	 */
	private int world;
	
	/**
	 * Standard constructor.
	 * 
	 * @param  world
	 *         The integer that is associated with this {@code World}.
	 */
	public World( int world ) {
		// Potential inheritance issues if the code is changed.
		setWorld( world );
	} // end constructor(int)
	
	/**
	 * Standard set method
	 * 
	 * @param  world
	 *         The integer that is associated with this {@code World}.
	 */
	public void setWorld( int world ) {
		if ( Worlds.isValid( world ) ) {
			this.world = world;
		} else {
			// Either invalid world or illegal world (bounty, f2p or foreign).
			throw new IllegalArgumentException();
		} // end if...else
	} // end method setWorld(int):void
	
	/**
	 * Converts the {@code World} to an {@code int}.
	 * 
	 * @return  The integer that is associated with this {@code World}.
	 */
	public int toInt() {
		return world;
	} // end method toInt():int
	
	/**
	 * Standard toString method.
	 * 
	 * @return  Returns a {@code String} representation of this {@code World}.
	 */
	@Override
	public String toString() {
		return "W" + toInt();
	} // end method toString():String
} // end class World
/*
 * Copyright (c) 2010, 2016, Ask Andreas Vargset. All rights reserved.
 * All use without the author's permission is forbidden.
 */

package report;

import world.World;

/**
 * XXX
 *
 * @author   Ask Andreas Vargset
 * @version  2.0, 2016-12-11
 * @see      main.Listing
 */
public abstract class Report {
	
	/**
	 * The {@code World} that is associated with this {@code Report}.
	 */
	private World world;
	
	/**
	 * Standard get method.
	 * 
	 * @return  The {@code World} that is associated with this {@code Report}.
	 */
	public World getWorld() {
		return world;
	} // end method getWorld():World
	
	/**
	 * Standard set method
	 * 
	 * @param  world
	 *         The {@code World} that is associated with this {@code Report}.
	 */
	public void setWorld( int world ) {
		this.world = new World( world );
	} // end method setWorld(int):void
	
	/**
	 * Standard set method
	 * 
	 * @param  world
	 *         The {@code World} that is associated with this {@code Report}.
	 */
	public void setWorld( World world ) {
		this.world = world;
	} // end method setWorld(World):void
	
	/**
	 * {@code String} representation of the {@code Report}.
	 */
	public abstract String toString();
} // end class Report
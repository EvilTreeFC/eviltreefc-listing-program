/*
 * Copyright (c) 2010, 2016, Ask Andreas Vargset. All rights reserved.
 * All use without the author's permission is forbidden.
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
public class World implements Comparable<World> {
	/**
	 * The integer that is associated with this {@code World}.
	 */
	private int world;
	
	private int minutes;
	
	private long timeReported;
	
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
	
	public World( int world, int minutes, long timeReported ) {
		this.world = world;
		this.minutes = minutes;
		this.timeReported = timeReported;
	} // end constructor(int)

	@Override
	public int compareTo( World world ) {
		if ( world == null ) {
			return 1;
		} // end if
		
		return Integer.valueOf( minutes ).compareTo( world.getMinutes() );
	} // end method compareTo(World):int

	public int getMinutes() {
		return minutes;
	} // end method getMinutes():int

	public long getTimeReported() {
		return timeReported;
	} // end method getTimeReported():long
	
	public int getWorld() {
		return world;
	} // end method getWorld():int

	public void setMinutes( int minutes ) {
		this.minutes = minutes;
	} // end method setMinutes(int):void

	public void setTimeReported( long timeReported ) {
		this.timeReported = timeReported;
	} // end method setTimeReported(long):void
	
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
		StringBuilder builder = new StringBuilder();
		
		builder.append( "W" );
		builder.append( world );
		builder.append( " " );
		
		if ( minutes == 0 ) {
			builder.append( "NOW" );
		} else {
			builder.append( minutes );
			builder.append( " min" );
			
			if ( !(minutes == 1) ) {
				builder.append( "s" ); // Add s since minutes is greater than 1.
			} // end if
		} // end if...else
		
		return builder.toString();
	} // end method toString():String
} // end class World
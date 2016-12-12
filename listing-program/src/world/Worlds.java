/*
 * Copyright (c) 2010, 2016, Ask Andreas Vargset and/or his affiliates.
 * All rights reserved.
 */

package world;

/**
 * This class is a utility class. As such, it is declared {@code final} and its
 * constructor is declared {@code private}. The reason being that {@code Worlds}
 * simply offers some help methods in ensuring the correctness of a
 * {@code World}.
 *
 * @author   Ask Andreas Vargset
 * @version  2.0, 2016-12-11
 * @see      world.World
 */
public final class Worlds {
	/**
	 * Integer representations of bounty worlds in RuneScape.
	 */
	public static final int[] bountyWorlds = { 97, 106 };

	/**
	 * Integer representations of free-to-play worlds in RuneScape.
	 * 
	 * Note: 55, 94 and 122 are also foreign {@code World}s.
	 */
	public static final int[] f2pWorlds = { 3, 7, 8, 11, 17, 19, 20, 29, 33, 34,
		38, 41, 43, 55, 57, 61, 80, 81, 94, 108, 120, 122, 135, 136, 141 };

	/**
	 * Integer representations of foreign, pay-to-play worlds in RuneScape.
	 */
	public static final int[] foreignWorlds = { 47, 75, 101, 102, 118, 121 };

	/**
	 * Integer representations of pay-to-pay worlds in RuneScape.
	 */
	public static final int[] p2pWorlds = { 1, 2, 4, 5, 6, 9, 10, 12, 14, 15,
		16, 18, 21, 22, 23, 24, 25, 26, 27, 28, 30, 31, 32, 35, 36, 37, 39, 40,
		42, 44, 45, 46, 48, 49, 50, 51, 52, 53, 54, 56, 58, 59, 60, 62, 63, 64,
		65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 76, 77, 78, 79, 82, 83, 84, 85,
		86, 87, 88, 89, 91, 92, 96, 97, 98, 99, 100, 103, 104, 105, 106, 114,
		115, 116, 117, 119, 123, 124, 134, 137, 138, 139, 140 };
	
	/**
	 * Constructor declared {@code private} in order to suppress the default
	 * constructor, ensuring that {@code Worlds} cannot be
	 * instantiated.
	 */
	private Worlds() {
		
	} // end constructor()
	
	/**
	 * Method that checks if {@code world} is contained in
	 * {@code bountyWorlds}.
	 * 
	 * @param  world
	 *         The integer that is associated with the {@code World}.
	 * 
	 * @return  {@code true} if {@code world} represents a bounty {@code World},
	 *          {@code false} otherwise.
	 */
	public static boolean isBountyWorld( int world ) {
		for ( int i = 0; i < bountyWorlds.length; i++ ) {
			if ( world == bountyWorlds[i] ) {
				return true;
			} // end if
		} // end for
		
		return false;
	} // end method isBountyWorld(int):boolean
	
	/**
	 * Method that checks if {@code world} is contained in {@code f2pWorlds}.
	 * 
	 * @param  world
	 *         The integer that is associated with the {@code World}.
	 * 
	 * @return  {@code true} if {@code world} represents an f2p {@code World},
	 *          {@code false} otherwise.
	 */
	public static boolean isF2pWorld( int world ) {
		for ( int i = 0; i < f2pWorlds.length; i++ ) {
			if ( world == f2pWorlds[i] ) {
				return true;
			} // end if
		} // end for
		
		return false;
	} // end method isF2pWorld(int):boolean
	
	/**
	 * Method that checks if {@code world} is contained in
	 * {@code foreignWorlds}.
	 * 
	 * @param  world
	 *         The integer that is associated with the {@code World}.
	 * 
	 * @return  {@code true} if {@code world} represents a foreign
	 *          {@code World}, {@code false} otherwise.
	 */
	public static boolean isForeignWorld( int world ) {
		for ( int i = 0; i < foreignWorlds.length; i++ ) {
			if ( world == foreignWorlds[i] ) {
				return true;
			} // end if
		} // end for
		
		return false;
	} // end method isForeignWorld(int):boolean
	
	/**
	 * Method that checks if {@code world} is contained in {@code p2pWorlds}.
	 * 
	 * @param  world
	 *         The integer that is associated with the {@code World}.
	 * 
	 * @return  {@code true} if {@code world} represents a p2p {@code World},
	 *          {@code false} otherwise.
	 */
	public static boolean isP2pWorld( int world ) {
		for ( int i = 0; i < p2pWorlds.length; i++ ) {
			if ( world == p2pWorlds[i] ) {
				return true;
			} // end if
		} // end for
		
		return false;
	} // end method isP2pWorld(int):boolean
	
	/**
	 * Method that checks if the {@code World} is valid.
	 * 
	 * @param  world
	 *         The integer that is associated with the {@code World}.
	 * 
	 * @return  {@code true} if {@code world} is valid, {@code false} otherwise.
	 */
	public static boolean isValid( int world ) {
		return isP2pWorld( world );
	} // end method isValid(int):boolean
} // end class Worlds
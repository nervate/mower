package com.mowitnow.core.data;

import com.mowitnow.core.loader.MowerInputFormatException;

public enum Cardinal {
	NORTH 	( 0	,	1),
	EAST  	( 1	,	0),
	SOUTH 	( 0	,  -1),
	WEST	(-1	,	0);
	
	/*
	 *  Move attributes
	 *  x = East <-> West
	 *  y = North <-> South 
	 */
	private int x = 0;
	private int y = 0;
	
	
	
	private Cardinal(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Cardinal right(){
		if(this == WEST )return NORTH;
		return values()[this.ordinal()+1];
	}
	
	public Cardinal left(){
		if(this == NORTH)return WEST;
		return values()[this.ordinal()-1];
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public static Cardinal cardinalFormChar(char c) throws MowerInputFormatException{
		switch(c){
			case 'N': return NORTH;
			case 'E': return EAST;
			case 'O': return WEST;
			case 'S': return SOUTH;
			default: throw new MowerInputFormatException("Cardinal unknow "+c);
		}
	}
	
}

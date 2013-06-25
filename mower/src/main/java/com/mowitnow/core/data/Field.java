package com.mowitnow.core.data;


public class Field {
	
	private int height = 0;
	
	private int width = 0;

	public Field(int width, int height) {
		super();
		this.height = height;
		this.width = width;
	}
	
	public boolean isInsideField(int x, int y){
		if(0 <= x && x <= width
			&& 0 <= y && y <= height)
			return true;
		
		return false;
		
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}
	
	
}

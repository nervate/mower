package com.mowitnow.core.context;

import java.util.List;

import com.mowitnow.core.data.Field;
import com.mowitnow.core.data.Mower;
import com.mowitnow.core.loader.MowerInputFormatException;


public interface MowerContext {
	
	public void setField(String fieldLine) throws MowerInputFormatException;
	
	public Field getField();
	
	public void run();

	public boolean canMove(Mower mower);

	public void setMowers(List<String> mowersAndOrders);
	
	public List<Mower> getMowers();
}

package com.mowitnow.core.command.impl;

import com.mowitnow.core.command.Order;
import com.mowitnow.core.data.Mower;

public class ForwardOrder implements Order {

	@Override
	public Mower execute(Mower mower) {
		if(!mower.canMove()) 
			return mower;
		mower.move();
		return mower;
	}

}

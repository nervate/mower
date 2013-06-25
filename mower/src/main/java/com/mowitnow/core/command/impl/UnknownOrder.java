package com.mowitnow.core.command.impl;

import com.mowitnow.core.command.Order;
import com.mowitnow.core.data.Mower;

public class UnknownOrder implements Order {

	@Override
	public Mower execute(Mower mower) {
		// do something stupid...
		return mower;
	}

}

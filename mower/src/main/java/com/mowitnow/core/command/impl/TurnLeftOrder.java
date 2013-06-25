package com.mowitnow.core.command.impl;

import com.mowitnow.core.command.Order;
import com.mowitnow.core.data.Mower;

public class TurnLeftOrder implements Order {

	@Override
	public Mower execute(Mower mower) {
		mower.setCardinal(mower.getCardinal().left());
		return mower;
	}

}

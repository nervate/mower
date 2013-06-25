package com.mowitnow.core.command.impl;

import com.mowitnow.core.command.Order;
import com.mowitnow.core.data.Mower;

public class TurnRightOrder implements Order {

	@Override
	public Mower execute(Mower mower) {
		mower.setCardinal(mower.getCardinal().right());
		return mower;
	}

}

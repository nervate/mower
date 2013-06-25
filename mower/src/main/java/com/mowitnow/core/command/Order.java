package com.mowitnow.core.command;

import com.mowitnow.core.data.Mower;

public interface Order {
	public Mower execute(Mower mower);
}

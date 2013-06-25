package com.mowitnow.core.context.impl;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.mowitnow.core.command.Order;
import com.mowitnow.core.context.MowerContext;
import com.mowitnow.core.data.Field;
import com.mowitnow.core.data.Mower;
import com.mowitnow.core.factory.FieldFactory;
import com.mowitnow.core.factory.MowerFactory;
import com.mowitnow.core.factory.OrderFactory;
import com.mowitnow.core.loader.MowerInputFormatException;

public class MowerContextImpl implements MowerContext {
	
	private Field field ;
	
	private List<Mower> mowers = new LinkedList<Mower>();
	
	
	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		return builder.toString();
	}

	
	
	public Field getField() {
		return field;
	}



	public void setField(String fieldLine) throws MowerInputFormatException {
		field = FieldFactory.getField(fieldLine);
	}


	
	public void setMowers(List<String> mowersAndOrders) {
		
		for (Iterator<String> iterator = mowersAndOrders.iterator(); iterator.hasNext();) {
			// Mower
			String mowerLine = iterator.next();
			Mower mower = MowerFactory.getMower(mowerLine);
			mower.setContext(this);
			if(iterator.hasNext()){
				// Orders
				String orderLine = iterator.next();
				mower.setOrders(OrderFactory.getChainOrder(orderLine));
			}
			this.mowers.add(mower);
		}
	}

	/**
	 * TODO : Add thread
	 */
	@Override
	public void run() {
		for (Mower mower : mowers) {
			for (Order order : mower.getOrders()) {
				order.execute(mower);
			}
		}
	}


	@Override
	public boolean canMove(Mower mower) {
		return field.isInsideField(mower.getX() + mower.getCardinal().getX()
				, mower.getY() + mower.getCardinal().getY());
		
	}


	@Override
	public List<Mower> getMowers() {
		return mowers;
	}
	
}

package com.mowitnow.core.factory;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.mowitnow.core.command.Order;
import com.mowitnow.core.command.impl.ForwardOrder;
import com.mowitnow.core.command.impl.TurnLeftOrder;
import com.mowitnow.core.command.impl.TurnRightOrder;
import com.mowitnow.core.command.impl.UnknownOrder;

public class OrderFactory {

	static Map<Character, Order> orders = new HashMap<Character, Order>();  
	
	static {
		orders.put('G', new TurnLeftOrder());
		orders.put('D', new TurnRightOrder());
		orders.put('A', new ForwardOrder());
		orders.put('U', new UnknownOrder());
	}
	
	public static Order getOrder(char key){
		if(!orders.containsKey(key))
			return orders.get("Unknown");
		return orders.get(key);
	}
	
	public static List<Order> getChainOrder(String keyChain){
		List<Order> chainOrders = new LinkedList<Order>();
		for (char key : keyChain.toCharArray()) {
			chainOrders.add(getOrder(key));
		}
		return chainOrders;
	}
	
}

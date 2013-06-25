package com.mowitnow.core.data;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.mowitnow.core.command.Order;
import com.mowitnow.core.command.impl.ForwardOrder;
import com.mowitnow.core.command.impl.TurnLeftOrder;
import com.mowitnow.core.command.impl.TurnRightOrder;
import com.mowitnow.core.factory.OrderFactory;

public class OrderTest {
	
	@Test
	public void testTurnLeft() {
		assertTrue(OrderFactory.getOrder('G') instanceof TurnLeftOrder);
	}

	@Test
	public void testTurnRight() {
		assertTrue(OrderFactory.getOrder('D') instanceof TurnRightOrder);
	}
	
	@Test
	public void testForward() {
		assertTrue(OrderFactory.getOrder('A') instanceof ForwardOrder);
	}
	
	@Test
	public void testChainOrder() {
		List<Order> chainOrder = OrderFactory.getChainOrder("GDA");
		assertTrue(chainOrder.size() == 3);
		assertTrue(chainOrder.get(0) instanceof TurnLeftOrder);
		assertTrue(chainOrder.get(1) instanceof TurnRightOrder);
		assertTrue(chainOrder.get(2) instanceof ForwardOrder);
	}
	
	
	
}

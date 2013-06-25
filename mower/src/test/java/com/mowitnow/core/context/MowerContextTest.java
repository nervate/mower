/**
 * 
 */
package com.mowitnow.core.context;

import static org.junit.Assert.assertTrue;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import com.mowitnow.core.command.Order;
import com.mowitnow.core.context.MowerContext;
import com.mowitnow.core.context.impl.MowerContextImpl;
import com.mowitnow.core.data.Cardinal;
import com.mowitnow.core.data.Mower;
import com.mowitnow.core.factory.MowerFactory;
import com.mowitnow.core.factory.OrderFactory;
import com.mowitnow.core.loader.MowerInputFormatException;

/**
 * @author "Vincent TARTARE"
 *
 */
public class MowerContextTest {

	@Test
	public void testField() {
		MowerContext context = new MowerContextImpl();
		
		try {
			context.setField("A D");
			assertTrue(false);
		} catch (MowerInputFormatException e) {assertTrue(true);}
		
		try {
			context.setField("AD");
			assertTrue(false);
		} catch (MowerInputFormatException e) {assertTrue(true);}
		
		try {
			context.setField("55");
			assertTrue(false);
		} catch (MowerInputFormatException e) {assertTrue(true);}
		
		try {
			context.setField("5 5 A");
			assertTrue(false);
		} catch (MowerInputFormatException e) {assertTrue(true);}
		
		try {
			context.setField("5 1"); // X Y
			assertTrue(context.getField() != null);
			assertTrue(context.getField().getWidth() == 5);
			assertTrue(context.getField().getHeight() == 1);
		} catch (MowerInputFormatException e) {assertTrue(false);}
	}
	
	@Test
	public void testAddMowers() {
		MowerContext context = new MowerContextImpl();
		context.setField("2 2");
		List<String> mowersList = new LinkedList<String>();
		mowersList.add("1 2 N");
		context.setMowers(mowersList);
		assertTrue(context.getMowers().size() == 1);
		assertTrue(context.getMowers().get(0).getCardinal() == Cardinal.NORTH);
		assertTrue(context.getMowers().get(0).getX() == 1);
		assertTrue(context.getMowers().get(0).getY() == 2);
	}
	@Test
	public void testCanMove() {
		MowerContext context = new MowerContextImpl();
		context.setField("1 1");
		
		Mower mower = MowerFactory.getMower("1 1 N");
		mower.setContext(context);
		assertTrue(!context.canMove(mower));
		
		context.setField("1 2");
		mower = MowerFactory.getMower("0 0 N");
		mower.setContext(context);
		assertTrue(context.canMove(mower));
		
		
		context.setField("2 1");
		mower = MowerFactory.getMower("0 0 E");
		mower.setContext(context);
		assertTrue(context.canMove(mower));
	}
	
	@Test
	public void testSimpleMove() {
		MowerContext context = new MowerContextImpl();
		context.setField("5 5");
		
		
		
		List<String> orderList = new LinkedList<String>();
		orderList.add("1 2 N");
		orderList.add("GAGAGAGAA"); // Expected 1 3 N
		context.setMowers(orderList);
		context.run();
		
		Mower mower = context.getMowers().get(0);
		assertTrue(mower.getCardinal() == Cardinal.NORTH);
		assertTrue(mower.getX() == 1);
		assertTrue(mower.getY() == 3);
		
	}
	
}

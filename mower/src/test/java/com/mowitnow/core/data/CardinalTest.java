package com.mowitnow.core.data;

import static org.junit.Assert.*;

import org.junit.Test;

import com.mowitnow.core.data.Cardinal;

public class CardinalTest {

	@Test
	public void testRight() {
		assertTrue(Cardinal.NORTH.right().equals(Cardinal.EAST));
		assertTrue(Cardinal.EAST.right().equals(Cardinal.SOUTH));
	}
	
	@Test
	public void testleft() {
		assertTrue(Cardinal.NORTH.left().equals(Cardinal.WEST));
		assertTrue(Cardinal.EAST.left().equals(Cardinal.NORTH));
	}
	
}

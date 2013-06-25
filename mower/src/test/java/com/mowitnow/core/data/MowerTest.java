package com.mowitnow.core.data;

import static org.junit.Assert.*;

import org.junit.Test;

import com.mowitnow.core.factory.MowerFactory;
import com.mowitnow.core.loader.MowerInputFormatException;

public class MowerTest {
	
	
	@Test
	public void testCreate() {

		Mower mower = null;
		
		try {
			mower = MowerFactory.getMower("00 N");
			assertTrue(false);
		} catch (MowerInputFormatException e) {
			assertTrue(true);
		}
		
		try {
			mower = MowerFactory.getMower("-10 N");
			assertTrue(false);
		} catch (MowerInputFormatException e) {
			assertTrue(true);
		}
		
		try {
			mower = MowerFactory.getMower("0 0 F");
			assertTrue(false);
		} catch (MowerInputFormatException e) {
			assertTrue(true);
		}
		
		mower = MowerFactory.getMower("12 52 N");
		assertTrue(mower.getCardinal() == Cardinal.NORTH);
		assertTrue(mower.getX() == 12);
		assertTrue(mower.getY() == 52);
	}
	
	@Test
	public void testMove() {

		Mower mower = MowerFactory.getMower("0 0 N");
		mower.move();
		assertTrue(mower.getY() == 1);
		
		mower = MowerFactory.getMower("0 0 N");
		mower.setCardinal(Cardinal.EAST);
		mower.move();
		assertTrue(mower.getX() == 1);
		
	}

}

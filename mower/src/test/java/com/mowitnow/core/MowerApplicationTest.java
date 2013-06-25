/**
 * 
 */
package com.mowitnow.core;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.mowitnow.core.MowerApplication;
import com.mowitnow.core.data.Cardinal;
import com.mowitnow.core.data.Mower;

/**
 * @author "Vincent TARTARE"
 *
 */
public class MowerApplicationTest {

	@Test
	public void testMowerApplication() {
		MowerApplication app = new MowerApplication();
		app.init("/test.txt");
		app.run();
		
		
		List<Mower> mowers =  app.getContext().getMowers();
		assertTrue(mowers.size() == 2);
		
		assertTrue(mowers.get(0).getCardinal() == Cardinal.NORTH);
		assertTrue(mowers.get(0).getX() == 1);
		assertTrue(mowers.get(0).getY() == 3);
		
		assertTrue(mowers.get(1).getCardinal() == Cardinal.EAST);
		assertTrue(mowers.get(1).getX() == 5);
		assertTrue(mowers.get(1).getY() == 1);
	}

}

/**
 * 
 */
package com.mowitnow.core.factory;

import com.mowitnow.core.data.Field;
import com.mowitnow.core.loader.MowerInputFormatException;

/**
 * @author "Vincent TARTARE"
 *
 */
public class FieldFactory {
	
	public static Field getField(String fieldConfig){
		
		Field field = null;
		
		if(fieldConfig == null) 
			throw new  MowerInputFormatException("Invalid field format");
		
		String[] fieldFormat = fieldConfig.split(" ");
		
		if(fieldFormat.length != 2)  
			throw new  MowerInputFormatException("Invalid field format");
		
		try {
			int x = Integer.parseInt(fieldFormat[0]);
			int y = Integer.parseInt(fieldFormat[1]);
			field = new Field(x, y);
		} catch (NumberFormatException e) {
			throw new  MowerInputFormatException("Invalid field format",e);
		}
		
		return field;
	}
	
}

package com.mowitnow.core;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.mowitnow.core.context.MowerContext;
import com.mowitnow.core.context.impl.MowerContextImpl;
import com.mowitnow.core.loader.MowerInputFormatException;

public class MowerApplication {
	
	
	private MowerContext context = new MowerContextImpl();
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MowerApplication app = new MowerApplication();
		app.init(args[0]);
		app.run();
	}

	public void init(String fileName)  {
		
		Scanner scanner = null ;
		try {
			
			scanner = new Scanner(MowerApplication.class.getResourceAsStream(fileName),"UTF-8");
			
			if(!scanner.hasNextLine())
				throw new MowerInputFormatException(fileName + " not found");
			
			context.setField( scanner.nextLine());
			
			List<String> mowersAndOrders = new LinkedList<String>();
			while (scanner.hasNextLine()) {
				mowersAndOrders.add(scanner.nextLine());
			}
			context.setMowers(mowersAndOrders);
		}finally{
			if(scanner != null)
				scanner.close();
		}
		
	}

	public MowerContext getContext() {
		return context;
	}
	
	
	public void run() {
		context.run();
	}
	
}

package com.qa.base;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.Set;

public class BaseTest extends TestBase {
	public void hell(){
		String winhandle = driver.getWindowHandle();
		Set<String> handle = driver.getWindowHandles();
		Iterator<String> iter= handle.iterator();
		
		ListIterator<String> lisIt= (ListIterator<String>) driver.getWindowHandles();
		
	}
	

}

package com.qa.base;

import bsh.Capabilities;

public class CapabilityFactory {
	public Capabilities capabilities;
	public Capabilities getCapabilities(String browser){
		 if (browser.equals("firefox"))
/*	            capabilities = OptionsManager.getFirefoxOptions();
	        else
	            capabilities = OptionsManager.getChromeOptions();
		*/
			 
		return capabilities;
		return capabilities;
	}
	

}

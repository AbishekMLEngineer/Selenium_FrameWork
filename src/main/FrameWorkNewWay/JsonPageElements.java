package FrameWorkNewWay;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*This interface is kind of like the @FindBy annotation. It basically captures the location of the JSON file 
 * in which all our locators are situated, the name of the page 
 * (this will help us find our required JSONObject in our JSON file) 
 * and the name of the html element (imagine this to be the key in our JSONObject ).*/

public class JsonPageElements {
	@Retention (RetentionPolicy.RUNTIME)
	@Target (ElementType.FIELD)
	public @interface SearchWith {
	    String inPage() default "";
	 
	    String locatorsFile() default "";
	 
	    String name() default "";
	}

}

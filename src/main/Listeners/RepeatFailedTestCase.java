package Listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RepeatFailedTestCase implements IRetryAnalyzer {

	public boolean retry(ITestResult result) {
		int count =0;
		int retryLimit =3;
		if(count <=retryLimit){
			return true;
		}
		// TODO Auto-generated method stub
		return false;
	}
	

}

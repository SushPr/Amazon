package testcases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import teststeps.teststephomepage;
import teststeps.teststeptelevisioncategory;

public class verifyamazon extends teststephomepage{
	
	@Test
	public void testscript() throws Exception
	{
		teststephomepage teststephomepage = new teststephomepage();
		teststeptelevisioncategory teststeptelevisioncategory = new teststeptelevisioncategory();
		
		teststephomepage.navigatetoappURL();
		teststeptelevisioncategory.verifyaboutthissection();

		System.out.println("TEST CASE COMPLETED");
	}

}

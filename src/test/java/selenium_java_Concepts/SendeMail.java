package selenium_java_Concepts;

import java.io.IOException;

import org.testng.annotations.Test;



public class SendeMail {

 
	@Test
	private void auService() throws IOException
	{
		String To="sajjushrestha@outlook.com";
		String Subject="test mail";
		String body="This case should be in BAU inbox without Case Mapping";
		String attachmentpath="C:\\Users\\Sajju\\eclipse-workspace\\Selenium-JavaConcepts\\Filename.txt";
			
		try {
	        Runtime.getRuntime().exec(new String[] {"wscript.exe", ".//sendmail.vbs" , To , Subject , body, attachmentpath});       
	       
	       
	    } catch (Exception e) {
	   e.printStackTrace();
	    }
			
	}
	
	
	
}

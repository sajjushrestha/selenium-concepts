package selenium_java_Concepts;


import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.Test;

public class ReadMail {

	@Test
	public void read() throws IOException
	{
		

		String fundmail="test mails";
		
		String path1=".\\Filename.txt";
		
			
		try {
	        Runtime.getRuntime().exec(new String[] {"wscript.exe", ".//readmail.vbs" , fundmail ,path1 });       
	        
	       
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
		
		
		
		
		 try {

	            File f = new File(path1);

	            //System.out.println("Reading files using Apache IO:");

	            List<String> lines = FileUtils.readLines(f, "UTF-8");

	            for (String line : lines) {
	                System.out.println(line);
	            }

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		
		
	}
	
	
	
}

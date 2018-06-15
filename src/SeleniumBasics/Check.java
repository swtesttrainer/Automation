package SeleniumBasics;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Check 
{
	
	public void writeData() throws IOException
	{
		File f = new File("E:\\note\\abc123.txt");
		FileWriter fw = new FileWriter(f);
		fw.write("THis is my first");
		fw.flush();
		fw.close();
	}

	public static void main(String[] args) throws IOException 
	{
		// TODO Auto-generated method stub
		/*File f = new File("E:\\note\\abc.txt");
		FileReader fr = new FileReader(f);
		int i = fr.read();
		while(i!=-1)
		{
			System.out.print((char)i);
			i = fr.read();
		}*/
		Check obj = new Check();
		obj.writeData();
	}

}

import java.io.*;
import java.util.ArrayList;

public class HammingDist
{
	private String fileName= "Mesonet.txt";
	private String firstSTID;
	private String secondSTID;
	private ArrayList <String> allSTID= new ArrayList<String>();
	
	public void readInfo() throws IOException
	{
			int loc=0;
			String temp="";
			BufferedReader STIDVals= new BufferedReader(new FileReader(fileName));
			STIDVals.readLine();
			STIDVals.readLine();
			STIDVals.readLine();
			
			while(loc<120)
			{
				temp=STIDVals.readLine();
				temp=temp.substring(1, 5);
				allSTID.add(temp);
				loc++;
			}
		STIDVals.close();
	}
	
}
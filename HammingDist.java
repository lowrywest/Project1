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
	
	public HammingDist(String first, String second) throws IOException
	{
		firstSTID=first;
		secondSTID=second;
		readInfo();
	}
	
	public int singleHammDist(String first, String second)
	{
		int hamDist=0;
		for(int loc=0;loc<first.length();loc++)
			{
				if(first.charAt(loc)!=second.charAt(loc))
				{
					hamDist++;
				}
			}
		return hamDist;
	}

	public ArrayList <Integer> numNodes(String inputSTID)
	{
		ArrayList <Integer> nodes = new ArrayList<Integer>();
		nodes.add(0); 
		nodes.add(0);
		nodes.add(0);
		nodes.add(0);
		int temp=0;
		
	}
}
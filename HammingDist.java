import java.io.*;
import java.util.ArrayList;

public class HammingDist
{
	//Holding the file to read from in a global variable
	private String fileName= "Mesonet.txt";
	//SITD values to be Tested
	private String firstSTID;
	private String secondSTID;
	//ArrayList of all the STID values
	private ArrayList <String> allSTID= new ArrayList<String>();
	
	//Reading in the STID values from the Mesonet.txt file
	public void readInfo() throws IOException
	{
			//holds the number of the STID value being read in 
			int loc=0;
			//holds the current STID value
			String temp="";
			//Constructing the Buffered reader
			BufferedReader STIDVals= new BufferedReader(new FileReader(fileName));
			//Priming reads to skip the first 3 lines of Mesonet.txt
			STIDVals.readLine();
			STIDVals.readLine();
			STIDVals.readLine();
			
			//loop through lines of the Mesonet.txt file
			while(loc<120)
			{
				//setting temp to the entire line at that location
				temp=STIDVals.readLine();
				//changing the value from the entire line to just the STID value
				temp=temp.substring(1, 5);
				//adding the STID value to the ArrayList
				allSTID.add(temp);
				//Incrementing the location being read in
				loc++;
			}
		//Closing the BufferReader 
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
		for(int i=0; i<allSTID.size();i++)
		{
			
			if(!inputSTID.equals(allSTID.get(i)))
			{
				   temp= singleHammDist(inputSTID, allSTID.get(i));
					if(temp==1)
					{
						nodes.set(0, nodes.get(0)+1);
					}
					else if(temp==2)
					{
						nodes.set(1, nodes.get(1)+1);
					}
					else if(temp==3)
					{
						nodes.set(2, nodes.get(2)+1);
					}
					else 
					{
						nodes.set(3, nodes.get(3)+1);
					}
			}
		}
		return nodes;
		
	}
	
	public String toString() 
	{
		
		int hammDist= singleHammDist(firstSTID, secondSTID);
		ArrayList <Integer> firstNodes= numNodes(firstSTID);
		ArrayList <Integer> secondNodes= numNodes(secondSTID);
		return String.format("The Hamming Distance of %s and %s: %d\nOut of 119, for %s, number of nodes are: %d, %d, %d, %d and\n"
				+ "for %s, number of nodes are: %d, %d, %d, %d respectively. ",firstSTID, secondSTID, hammDist, firstSTID, firstNodes.get(0),
				firstNodes.get(1),firstNodes.get(2),firstNodes.get(3), secondSTID, secondNodes.get(0),secondNodes.get(1),secondNodes.get(2),
				secondNodes.get(3));
	}

}
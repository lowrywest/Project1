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
	
	//Constructing the HammingDist Object
	public HammingDist(String first, String second) throws IOException
	{
		//getting the STID values to be compared and setting them to the global variables
		firstSTID=first;
		secondSTID=second;
		//Calling the method to read in the STID values from Mesonet.txt file 
		readInfo();
	}
	
	//Method for finding the hamming distance between two strings
	public int singleHammDist(String first, String second)
	{
		//Variable to hold the hamming distance
		int hamDist=0;
		//loop through the string
		for(int loc=0;loc<first.length();loc++)
			{
				//comparing the characters at the location
				if(first.charAt(loc)!=second.charAt(loc))
				{
					//increment the hamming distance accordingly
					hamDist++;
				}
			}
		//Returning the hamming distance
		return hamDist;
	}

	//comparing the whole ArrayList of STID Values to a given STID value
	public ArrayList <Integer> numNodes(String inputSTID)
	{
		//Constructing a ArrayList to whold the number of nodes
		ArrayList <Integer> nodes = new ArrayList<Integer>();
		//Initializing the values to 0
		nodes.add(0); 
		nodes.add(0);
		nodes.add(0);
		nodes.add(0);
		//temp holds the current e count
		int hammingDistance=0;
		//Loops through the entire ArrayList of STID values
		for(int i=0; i<allSTID.size();i++)
		{
			//checks to make sure the STID value is different than the one from the ArrayList
			if(!inputSTID.equals(allSTID.get(i)))
			{
				   //gets the hamming Distance between the two STID values
				   hammingDistance= singleHammDist(inputSTID, allSTID.get(i));
				    //Looks to see if the hamming distance is 1
					if(hammingDistance==1)
					{
						//increment the value of the nodes at 0
						nodes.set(0, nodes.get(0)+1);
					}
					//Looks to see if the hamming distance is 2
					else if(hammingDistance==2)
					{
						//increment the value of the nodes at 1
						nodes.set(1, nodes.get(1)+1);
					}
					//Looks to see if the hamming distance is 3
					else if(hammingDistance==3)
					{
						//increment the value of the nodes at 2
						nodes.set(2, nodes.get(2)+1);
					}
					//if the hamming distance is 4
					else 
					{
						//increment the value of the nodes at 3
						nodes.set(3, nodes.get(3)+1);
					}
			}
		}
		//return the ArrayList of node values
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
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class HammingDist
{
	private String fileName= "Mesonet.txt";
	private String firstSTID;
	private String secondSTID;
	private ArrayList <String> allSTID= new ArrayList<String>();
	private String[] temp= new String[120];
	
	public HammingDist(String first, String second)
	{
		firstSTID=first;
		secondSTID=second;
	}
	
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
					temp=temp.substring(0, 5);
					allSTID.add(temp);
					loc++;
				}
			STIDVals.close();
	}
	
	public int singleHammDist(String first, String second)
	{
		int hamDist=0;
		for(int loc=0;loc<first.length();loc++)
			{
			System.out.println(Arrays.toString(allSTID.toArray(temp)));
				if(first.charAt(loc)!=second.charAt(loc))
				{
					hamDist++;
				}
			}
		return hamDist;
	}
	
	public ArrayList <Integer> numNodes(String inputSTID)
	{
		ArrayList <Integer> nodes= new ArrayList<Integer>(4);
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
		return String.format("The Hamming Distance of %s and %s: %f\nOut of 119, for %s, number of nodes are: %f, %f, %f, %f and\n"
				+ "for %s, number of nodes are: %f, %f, %f, %f respectively. ",firstSTID, secondSTID, hammDist, firstSTID, firstNodes.get(0),
				firstNodes.get(1),firstNodes.get(2),firstNodes.get(3), secondSTID, secondNodes.get(0),secondNodes.get(1),secondNodes.get(2),
				secondNodes.get(3));
	}
}
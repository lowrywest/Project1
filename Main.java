import java.io.IOException;

public class Main 
{
	public static void main(String[] args) throws IOException 
	{
		HammingDist HammDist = new HammingDist("HOLL", "NOWA");
		System.out.println(HammDist);
	}
}
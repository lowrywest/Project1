# Project1

ReadInfo Method
The first problem that I worked on in project one was reading in the STID values from the mesonet file. Since the number of STID values is
constant I realized that I could loop through the file a set number of times. So I used the Buffered Reader object to read in every line of 
of the file. I used 3 priming reads to get the Buffered Reader to the 3rd line of the file where the STID values start. Then I set the
entire line equal to a temporary String and then used substring to pull out just the STID value and added all of the STID values to a
global ArrayList to use when comparing the nodes later. 

Hamming Dist Constructor
Next I wrote the constructor for the HammingDist object passing in the STID values to be comapred and setting them equal to Global String 
variables and called the readInfo method detailed above.

Single Hamming Distance Method
This method finds and returns the Hamming distance between two strings. After figuring out what Hamming distance actually is and how to 
calculate it I looped through the length of the STID values. Then while looping through the STID values using the for loop input an if 
statement to compare the characters at the location the for loop holds. The if statement compares the characters at every location in the 
Strings and if they are not equal then increment the Hamming Distance variable by one. Then after looping through the STID values return 
the Hamming Distance variable.

Num Nodes method
This method calculates the number of nodes with a Hamming distance of 1, 2, 3, or 4 from a specific STID value and then returns an
ArrayList that holds the number of nodes at each Hamming Distance. First I created a empty ArrayList to hold the number of nodes. Then use 
the ArrayList that holds all the STID values read in from the Mesonet File and loop through as many as are in the ArrayList. Inside the 
I used an if statment to make sure the STID value being compared and the STID value from the ArrayList are not the same and then I called 
Single Hamming Distance Method to compare the inputed STID value to a STID value from the ArrayList. Then the number retured from the
Single Hamming Distance Method is compared to the numbers 1-4 and if it is equal to one of those it increments the value of the number of 
nodes in the ArrayList of nodes. This process is repeated for all 119 STID values.

To String Method
The toString method calls all of the methods and outputs the data accordingly. First it calls the Single Hamming distance to get the 
Hamming Distance between the two specific strings then it calls the Num Nodes methods and compares each of the input STID values to all the 
STID values from the Mesonet File. All the output is formated to match the specified format.

Extra
I also made a Text.txt file that was a smaller version of the Mesonet.txt File to test the methods for correctness. It is easier to 
calculate the expected output from 7 values instead of 119.

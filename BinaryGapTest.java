import java.util.*;

class BinaryGap
{
  static int solution(int N) {
   String binaryString = Integer.toBinaryString(N);
   System.out.println(binaryString + " its length is : "+binaryString.length());

	List<Integer> listOfOnes = new ArrayList<Integer>();
	int longestBinaryGap = 0;

	for(int i=0;i<binaryString.length();i++)
	{
		char ch = binaryString.charAt(i);

		if(ch=='0')
			continue;
				
		listOfOnes.add(i); //this line is skipped if 'continue' runs
	}  
	for(int i=0; i< listOfOnes.size() - 1; i++)
	{
		int indicesDiff = listOfOnes.get(i+1) - listOfOnes.get(i)-1; 
		longestBinaryGap = Math.max(longestBinaryGap, indicesDiff);
	}

   System.out.println("Longest binary gap length is : "+longestBinaryGap);	
   System.out.println("-----------------------------");

   return longestBinaryGap; //we can print here also but not a good choice
			//since we have to return the answer to codility
  }
}

public class BinaryGapTest {

  public static void main(String args[])
  {
	System.out.println("Begin main");
	
	int length1 = BinaryGap.solution(1);
	int length2 = BinaryGap.solution(9);
	int length3 = BinaryGap.solution(32);
	int length4 = BinaryGap.solution(529);
	int length5 = BinaryGap.solution(47483647);
	int length6 = BinaryGap.solution(247543670);
	int length7 = BinaryGap.solution(2147483647);

	System.out.println("End main");
  }
}

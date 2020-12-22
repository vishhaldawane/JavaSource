package lesson03;

class TapeEquilibrium
{
	public int solution(int A[]) {
		long sumAllElements = 0;
		for (int i = 0; i < A.length; i++) {
			sumAllElements = sumAllElements + A[i];
		} //13 in the case of {3,1,2,4,3};
		int minDifference = Integer.MAX_VALUE;
		int currentDifference = Integer.MAX_VALUE;
		
		long sumOfFirstPart=0;
		long sumOfSecondPart=0;
		for(int p=0; p<A.length-1;p++) {
			sumOfFirstPart =sumOfFirstPart+A[p];//only sum of FIRST part
			sumOfSecondPart =sumAllElements - sumOfFirstPart;
			
			currentDifference = (int) Math.abs(sumOfFirstPart- sumOfSecondPart);
			minDifference = Math.min(currentDifference,minDifference);
		}
		return minDifference;
	}
}

public class TapeEquilibriumTest {
	public static void main(String[] args) {
		int A1[]= {3,1,2,4,3};
		int A2[]= {-3,1,2,-4,3};
		int A3[]= {5,2,7,10};
		int A4[]= {100,-25}; // 
		int A5[]= {-1000,1000,-500,990}; //
		
		TapeEquilibrium tapeEqui = new TapeEquilibrium();
		int diff1 = tapeEqui.solution(A1);
		int diff2 = tapeEqui.solution(A2);
		int diff3 = tapeEqui.solution(A3);
		int diff4 = tapeEqui.solution(A4);
		int diff5 = tapeEqui.solution(A5);
		
		System.out.println("Min Difference1 : "+diff1);
		System.out.println("Min Difference2 : "+diff2);
		System.out.println("Min Difference3 : "+diff3);
		System.out.println("Min Difference4 : "+diff4);
		System.out.println("Min Difference4 : "+diff5);
		
	} 
	
}

package lesson03;

import java.util.HashSet;
import java.util.Set;
/*
 *1 					5
 * 						|
 * 			-----------------------------------
 * 			|							|
 *2 		4							6
 * 	------------------				---------------
 * 		|		|					|		|
 *3 	3									8
 * 		|									|
 * 	----------							---------------	
 * 	|       |							|				|
 * 	2									?				9	
 * 	|										
 * 	1													
 * 														
 * 										
 * 												    
 *4 												
 * 											
 * 													
 *5 													
 */
class PermutationMissingElement
{
	 public int solution(int[] A)// 4,2,3,1,5,6,8,9
	 {
		 int max = A.length + 1; //
		 Set<Integer> incompleteSet = new HashSet<Integer>();
		 
		 for (int i = 0; i < A.length; i++) {
			incompleteSet.add(A[i]); // copy A[] into the Set 
		 }
		 		//1 to 9 
		 for(int i=1; i< max+1; i++) { // 1 to Max+1  1,2,3,4,5,6,7,8,9
			 if( ! incompleteSet.contains(i)) {
				 return (i); //i is being tested and 
			 }			//neither A[i] or sets[i]		
		 }
		 return -1;
	 }
}
public class PermutationMissingElementTest {
	public static void main(String[] args) {
		
		PermutationMissingElement permMissEle = new PermutationMissingElement();
		
		int A0[]= {               };//1
		int A1[]= {              1};//2
		int A2[]= {              2};//1
		int A3[]= {            1,3};//2
		int A4[]= {            2,3};//1
		int A5[]= {            1,2};//3
		int A6[]= {          2,3,4}; //1
		int A7[]= {        2,3,1,5}; //4
		int A8[]= {4,7,3,1,5,6,8,9}; //2
		int A9[]= {4,2,3,1,5,6,8,7}; //9

		int missingElement0 = permMissEle.solution(A0);
		int missingElement1 = permMissEle.solution(A1);
		int missingElement2 = permMissEle.solution(A2);
		int missingElement3 = permMissEle.solution(A3);
		int missingElement4 = permMissEle.solution(A4);
		int missingElement5 = permMissEle.solution(A5);
		int missingElement6 = permMissEle.solution(A6);
		int missingElement7 = permMissEle.solution(A7);
		int missingElement8 = permMissEle.solution(A8);
		int missingElement9 = permMissEle.solution(A9);
		
		System.out.println("Missing Element : "+missingElement0);
		System.out.println("Missing Element : "+missingElement1);
		System.out.println("Missing Element : "+missingElement2);
		System.out.println("Missing Element : "+missingElement3);
		System.out.println("Missing Element : "+missingElement4);
		System.out.println("Missing Element : "+missingElement5);
		System.out.println("Missing Element : "+missingElement6);
		System.out.println("Missing Element : "+missingElement7);
		System.out.println("Missing Element : "+missingElement8);
		System.out.println("Missing Element : "+missingElement9);
		
	}
}

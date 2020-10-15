import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileWritingTest {
	public static void main(String[] args) {
		System.out.println("Begin main");
		try 
		{
			System.out.println("Trying to make a file");
			FileOutputStream fout = new FileOutputStream("d:\\myjava\\queen.txt");
			System.out.println("file is created...");
			
			String stringDataHere = "hello Queen, how are you? hows is th journey of java when u were a princess!!!";
			byte byteDataHere[] = stringDataHere.getBytes();
			fout.write(byteDataHere); 
			System.out.println("Trying to close the file");
			fout.close();
			System.out.println("file is closed...");
			
		}
		catch (FileNotFoundException e) {		//A
			System.out.println("Problem1: "+e);
		}
		catch (IOException e) {				//B
			System.out.println("Problem2: "+e);
		}
		catch(RuntimeException e) {				//C
			System.out.println("Problem3: "+e);
		}
		catch(Exception e) {					//D
			System.out.println("Problem4: "+e);
		}
		catch(Throwable t) {
			System.out.println("Problem5: "+t);
		}
		/*catch(Object t) {
			System.out.println("Problem6: "+e);
		}*/
		System.out.println("End of main");
	}
}

/*						
 * 					   Object
 * 						| isA	
 					Throwable
 * 						|isA
 * 			------------------------
 * 			|			|
 * 	1	 Error		Exception
 * 						| except RTE all are checked
 * 			-------------------------------
 * 			|					|
 * 	2		RTE					IOE
 * 			unchecked			|
 * 	3							FNFE
 * 
 * 
 * 
*/
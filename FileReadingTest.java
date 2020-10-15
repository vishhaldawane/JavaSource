import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileReadingTest {
	public static void main(String[] args) {
		System.out.println("Begin main");
		try 
		{
			System.out.println("Trying to open a file");
			FileInputStream fin = new FileInputStream("d:\\myjava\\queen.txt");
			System.out.println("file is ready...");
			//1 byte			//4 bytes
			byte b = (byte) fin.read(); //read the first letter from the file
			
			while(b!=-1) // what is -1 here ??? End of File 
			{
				//System.out.print("["+(char)b+"]");
				//System.out.print("["+b+"]");
				System.out.print((char)b);
				//System.out.print((char)b);
				b = (byte) fin.read(); //read from second letter onwards
									//in the loop
				Thread.sleep(100); //caught by InterruptedException 
				/*if(b==13) {
					System.out.println();
				}
				else if(b==32) {
					System.out.print("@");
				}
				 */
				
			}
			
			System.out.println("Trying to close the file");
			fin.close();
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
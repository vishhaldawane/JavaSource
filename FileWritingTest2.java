import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

//ctrl+shift+M

									//1 interface
class MyNotepad extends Frame implements ActionListener, WindowListener 
{
	TextArea dataToType = new TextArea(10,40);
	TextField filenameToType = new TextField(20);
	
	Icon ic = new ImageIcon();
	
	JButton saveToClick = new JButton("save",ic);
	Button clearToClick = new Button("Clear Data");
	
	MyNotepad() {
		
		super.setSize(400,400);
		super.setLocation(100,100);
		super.setLayout(new FlowLayout());
		super.add(dataToType);
		super.add(filenameToType);
		super.add(saveToClick);
		super.add(clearToClick);
		
	
		//registration of the component for
		//which we want the function to run
		saveToClick.addActionListener(this);
		clearToClick.addActionListener(this);
		this.addWindowListener(this);
		//|						|
		//source		class where eventFun is found 
	}

	//2 function from interface
	//mandate from ActionListener
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource()==saveToClick)
		{
			System.out.println("save is clicked");
			try 
			{
				System.out.println("Trying to make a file");
				FileOutputStream fout = new FileOutputStream("d:\\myjava\\"+filenameToType.getText());
				System.out.println("file is created...");
				String stringDataHere = dataToType.getText();
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
		}
		else if(ae.getSource()==clearToClick) 
		{
			System.out.println("CLEAR is clicked");
			dataToType.setText("\r");
			filenameToType.setText("\r");
		}
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		System.out.println("Window opened");
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Window closing");
		windowClosed(e); //call from here
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Window closed");
		setVisible(false); // hide the window
		System.exit(0); // and close the overall app
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Window minimized");
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Window restored");
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Window activated");
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Window de-activated");
	}
	
}

public class FileWritingTest2 {
	public static void main(String[] args) {
		System.out.println("Begin main");
		
			MyNotepad n = new MyNotepad();
			n.setVisible(true);
			
	/*
	 * try 
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
		*/
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
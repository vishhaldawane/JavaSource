//singleton design pattern - gang of four 
class Kitchen {
	//1 static data member
	static Kitchen x; //one copy only
	//2. static function
	static Kitchen getInstance() {
		if(x == null)
			x = new Kitchen(); // can be accessed
		return x; 
	}
	//3. private constructor
	private Kitchen() {
		//System.out.println("Private contructor");
	}
}
class House
{
	String houseName;
	Kitchen myKitchen;
	Kitchen ourKitchen;
	
	House(String hn) {
		houseName = hn;
		myKitchen = Kitchen.getInstance(); //Kitchen.getInstance();
		ourKitchen = Kitchen.getInstance(); //Kitchen.getInstance();
	}
	void showHouse() {
		System.out.println("House Name : "+houseName);
		System.out.println("Kitchen    : "+myKitchen);
		System.out.println("Kitchen    : "+ourKitchen);
	}
}

public class SingletonTest {
	public static void main(String[] args) {
		House myHouse = new House("Sweet Home");
		myHouse.showHouse();
		
		House yourHouse = new House("Better Home");
		yourHouse.showHouse();
	}
}

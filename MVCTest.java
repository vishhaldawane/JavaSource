
public class MVCTest {
	public static void main(String[] args) {
		//.ts file
		Flight f = new Flight(); // real time the data is fetched by DB
		f.setFlightNumber("SP-101");
		f.setFlightName("SPICEJET");
		f.setSource("Mumbai");
		f.setDestination("Chennai");
		
		FlightView view = new FlightView(); //html + css

		//model(TS) view (HTML+CSS)
		FlightController controller = new FlightController(f,view);
		controller.updateFlightView();
		
		controller.setFlightDestination("Gujrat"); //indirect change in f
		controller.updateFlightView();
		
		controller.setFlightSource("Delhi"); //indirect change in f
		controller.updateFlightView();
		
		f.setFlightName("GoAir");//direct change in f
		
		controller.updateFlightView();
		
	}
}

class Flight //model 
{
	private String flightNumber;
	private String flightName;
	private String source;
	private String destination;

	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getFlightName() {
		return flightName;
	}
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

}


class FlightView
{
	public void showFlightDetails(Flight ref)
	{
		ref.setDestination("DONT KNOW");
		System.out.println("Flight Number : "+ref.getFlightNumber());
		System.out.println("Flight Name   : "+ref.getFlightName());
		System.out.println("Flight Source : "+ref.getSource());
		System.out.println("Flight Destin : "+ref.getDestination());
		System.out.println("----------------------");
	}
}


class FlightController
{
	private Flight flightModel; 
	private FlightView flightView;
	
	public FlightController(Flight flightModel, FlightView flightView) {
		super();
		this.flightModel = flightModel;
		this.flightView = flightView;
	}
	
	void setFlightNumber(String number) {
		flightModel.setFlightNumber(number);
	}
	String getFlightNumber() {
		return flightModel.getFlightNumber();
	}
	
	void setFlightName(String name) {
		flightModel.setFlightName(name);
	}
	String getFlightName() {
		return flightModel.getFlightName();
	}
	
	void setFlightSource(String source) {
		flightModel.setSource(source);
	}
	String getFlightSource() {
		return flightModel.getSource();
	}
	
	void setFlightDestination(String dest) {
		flightModel.setDestination(dest);
	}
	String getFlightDestination() {
		return flightModel.getDestination();
	}
	
	public void updateFlightView()
	{
		flightView.showFlightDetails(flightModel);
	}
}
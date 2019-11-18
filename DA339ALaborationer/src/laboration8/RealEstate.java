package laboration8;

public class RealEstate {

	private String name;
	private Building building;
	private Address address;
	
	public RealEstate(String Name, Building building, Address address) {
		this.name = Name;
		this.building = building;
		this.address = address;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Building getBuilding() {
		return this.building;
	}
	
	public Address address() {
		return this.address;
	}
	
	public String toString() {
		return "Fastighet: " + name + "\nByggnad; " +
	}
}

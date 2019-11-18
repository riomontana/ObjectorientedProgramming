package laboration8;

public class Contact {

	private String name;
	private PhoneNumber phone;

	public Contact(String name, String home, String work, String mobile) {
		this.name = name;
		this.phone = new PhoneNumber(home, work, mobile);

	}

	public String getName() {
		return this.name;
	}

	public String getHome() {
		return this.phone.getHome();
	}

	public String getWork() {
		return this.phone.getWork();
	}

	public String getMobile() {
		return this.phone.getMobile();
	}

	public String toString() {
		return "Contact: " + name + "\n" + this.phone.toString();
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setHome(String home) {
		this.phone.setHome(home);
	}
	
	public void setWork(String work) {
		this.phone.setWork(work);
	}
	
	public void setMobile(String mobile) {
		this.phone.setMobile(mobile);
	}

	public static void main(String[] args) {
		Contact contact = new Contact("Eva Bok","040-123456","040-333333","0705223344");
		System.out.println( "Namn: " + contact.getName() + "\n" + "Telefonnummer: " + contact.getHome() + ", " +
				contact.getWork() + ", " + contact.getMobile() );
		System.out.println("--------------------------------");
		System.out.println( contact.toString() );

	}
}
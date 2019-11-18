package laboration8;

public class PhoneNumber {

	private String home;
	private String work;
	private String mobile;
	
	public PhoneNumber(String home, String work, String mobile) {
		super();
		this.home = home;
		this.mobile = mobile;
		this.work = work;
	}
	
	public void setHome(String home) {
		this.home = home;
	}
	
	public String getHome() {
		return this.home;
	}
	
	public void setWork(String work) {
		this.work = work;
	}
	
	public String getWork() {
		return this.work;
	}
	
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public String getMobile() {
		return this.mobile;
	}
	
	public String toString() {
		return "Home: " + this.home 
				+ "\nMobile: " + this.mobile
				+ "\nWork: " + this.work;				
	}
		
	
	public static void main(String[] args) {
		PhoneNumber phone = new PhoneNumber( "0413-11111", "040-123456", "0735191919" );
		System.out.println(phone.getHome() + ", " + phone.getWork() + ", " + phone.getMobile() );
		System.out.println("--------------------------------");
		System.out.println(phone.toString());
		System.out.println("--------------------------------");
		phone.setHome("040-123456");
		phone.setWork("0413-11111");
		phone.setMobile("0735191919");
		System.out.print(phone.toString());
		
	}
}

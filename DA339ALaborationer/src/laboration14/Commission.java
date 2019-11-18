package laboration14;

public class Commission extends Wage {
	private double rate;
	private double sales;
	
	public Commission(long id, double rate) {
		super(id);
		this.rate = rate;
	}
	
	public void setRate( double rate ) {
		this.rate = rate;
	}
	public double getRate() {
		return this.rate;
	}
	public void setSales( double sales ) {
		this.sales = sales;
	}
	public double getSales() { 
		return this.sales;
		}
	
	public double wage() {
		return this.rate * this.sales;
	}// returnerar (rate * sales)
	
	
	public static void main(String[] args) {
		Commission employee = new Commission( 19278865, 0.10 ); 
		employee.setSales( 208000 );
		System.out.println( employee.toString() ); 
		System.out.println( "Anställd med id " + employee.getId() +
		" har sålt för " + employee.getSales() +
		" kr till provisionen " + employee.getRate()*100 + " %" );
		employee.setRate( 0.12 );
		System.out.println( "Lön denna månad: " + employee.wage() + " kr");

	}
}

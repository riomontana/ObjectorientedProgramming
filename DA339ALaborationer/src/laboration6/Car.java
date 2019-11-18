package laboration6;

import javax.swing.JOptionPane;

public class Car {
	
	private String brand;
	private String model;
	private String color;
	private int horsepower;
	private int year;
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public void setModel(String model) {
		this.model = model;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public void setHorsepower(int horsepower) {
		this.horsepower = horsepower;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public void info() {
		String text = this.brand + "\n" + this.model + "\n" + this.color + "\n" + this.horsepower + " hp" + "\n" + this.year;
		JOptionPane.showMessageDialog(null, text);
	}
}

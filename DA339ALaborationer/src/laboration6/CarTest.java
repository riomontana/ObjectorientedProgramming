package laboration6;

import javax.swing.*;

public class CarTest {

	public void program() {
		Car bil = new Car();
		bil.setBrand(JOptionPane.showInputDialog("Ange bilmärke"));
		bil.setModel(JOptionPane.showInputDialog("Ange modell"));
		bil.setColor(JOptionPane.showInputDialog("Ange färg"));
		bil.setHorsepower(Integer.parseInt(JOptionPane.showInputDialog("Ange hästkrafter")));
		bil.setYear(Integer.parseInt(JOptionPane.showInputDialog("Ange årsmodell")));
		bil.info();
	}
	
	public static void main(String[] args) {
		CarTest prog = new CarTest();
		prog.program();
	}
	
}

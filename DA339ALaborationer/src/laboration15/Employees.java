package laboration15;

import javax.swing.*;
import java.util.*;

public class Employees {
    public void program() {
        Commission cWage;
        WageEmployee[] employees = new WageEmployee[ 3 ];
        employees[ 0 ] = new FullTime( 19938278, 21500 );
        employees[ 1 ] = new Commission( 19278865, 0.10 );
        String res = "FÖRE SORTERING\n"; ((Commission) employees[1]).setSales(208000); ((Hours) employees[2]).setHours(128);
        for (int i = 0; i < employees.length; i++) {
        res += employees[i].toString() + "\n"; }
        Arrays.sort(employees);
        res += "------------------------------------\n"; res += "EFTER SORTERING\n";
        for (int i = 0; i < employees.length; i++) {
        res += employees[i].toString() + "\n"; }
        JOptionPane.showMessageDialog(null, res);
    }
    public static void main( String[] args ) {
        Employees prog = new Employees();
        prog.program();
    }
}

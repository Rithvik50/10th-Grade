package rithvik;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		NumberFormat dollarFormat = new DecimalFormat("0.00");
		int maritalStatus = Integer
				.parseInt(JOptionPane.showInputDialog(null, "Enter Marital Status(1 = Single, 2 = Married): "));
		double taxableIncome = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter Taxable Income: "));
		IRSTaxCalculator taxCalculator = new IRSTaxCalculator(maritalStatus, taxableIncome);
		JOptionPane.showMessageDialog(null, "Your Federal Tax = $" + dollarFormat.format(taxCalculator.federalTax()));
	}
}

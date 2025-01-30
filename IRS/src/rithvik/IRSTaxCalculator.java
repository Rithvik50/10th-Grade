package rithvik;

public class IRSTaxCalculator {

	private int maritalStatus;
	private double taxIncome;

	/*
	 * +That your code models real world -name second class main Instantiate
	 * variables in constructor take off the redundancy of the operators -Previous
	 * if checks it before
	 * 
	 * 1) 12 2) 11 3) 5 4) 4
	 * 
	 */
	public IRSTaxCalculator(int maritalStatus, double taxIncome) {
		this.maritalStatus = maritalStatus;
		this.taxIncome = taxIncome;
	}

	public boolean isPayerSingle() {
		if (maritalStatus == 1) {
			return true;
		} else {
			return false;
		}
	}

	public double federalTax() {

		double federalTax = 0.0;

		if (isPayerSingle()) {
			if (taxIncome <= 9525)
				federalTax = 0.1 * taxIncome;
			else if (taxIncome <= 38700)
				federalTax = 952.5 + 0.12 * (taxIncome - 9525);
			else if (taxIncome <= 82500)
				federalTax = 4453.5 + 0.22 * (taxIncome - 38700);
			else if (taxIncome <= 157500)
				federalTax = 14089.5 + 0.24 * (taxIncome - 82500);
			else if (taxIncome <= 200000)
				federalTax = 32089.5 + 0.32 * (taxIncome - 157500);
			else if (taxIncome <= 500000)
				federalTax = 45689.5 + 0.35 * (taxIncome - 200000);
			else
				federalTax = 150689.5 + 0.37 * (taxIncome - 500000);
		} else {
			if (taxIncome <= 19050)
				federalTax = 0.1 * taxIncome;
			else if (taxIncome <= 77400)
				federalTax = 1905 + 0.12 * (taxIncome - 19050);
			else if (taxIncome <= 165000)
				federalTax = 8907 + 0.22 * (taxIncome - 77400);
			else if (taxIncome <= 315000)
				federalTax = 28179 + 0.24 * (taxIncome - 165000);
			else if (taxIncome <= 400000)
				federalTax = 64179 + 0.32 * (taxIncome - 315000);
			else if (taxIncome <= 600000)
				federalTax = 91379 + 0.35 * (taxIncome - 400000);
			else
				federalTax = 161379 + 0.37 * (taxIncome - 600000);
		}
		return federalTax;
	}
}

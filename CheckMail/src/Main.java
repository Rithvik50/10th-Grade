import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		double dim1 = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the first dimension of the package"));
		double dim2 = Double
				.parseDouble(JOptionPane.showInputDialog(null, "Enter the second dimension of the package"));
		double dim3 = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the third dimension of the package"));
		double weight = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the weight of the package"));

		CheckMail checker = new CheckMail(dim1, dim2, dim3, weight);
		JOptionPane.showMessageDialog(null, checker.checkMail());
	}
}

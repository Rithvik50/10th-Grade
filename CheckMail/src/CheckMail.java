
public class CheckMail {

	private double dim1, dim2, dim3, weight;

	public CheckMail(double dim1, double dim2, double dim3, double weight) {
		this.dim1 = dim1;
		this.dim2 = dim2;
		this.dim3 = dim3;
		this.weight = weight;
	}

	public String checkMail() {
		double size;
		if (dim1 > dim2) {
			if (dim1 > dim3) {
				size = dim1 + 2 * (dim2 + dim3);
			} else {
				size = dim3 + 2 * (dim1 + dim2);
			}
		} else if (dim2 > dim3) {
			size = dim2 + 2 * (dim1 + dim3);
		} else {
			size = dim3 + 2 * (dim1 + dim2);
		}

		if (size > 100) {
			if (weight > 70) {
				return "Package is too large and too heavy";
			} else {
				return "Package is too large";
			}
		} else {
			if (weight > 70) {
				return "Package is too heavy";
			} else {
				return "Package is acceptable";
			}
		}
	}
}

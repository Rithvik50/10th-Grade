
public class DataSet {

	private int[] data;

	public DataSet() {

	}

	public DataSet(int maxSize) {
		data = new int[maxSize];
	}

	public void readData(String filename) {
		ArrayReader arrayReader = new ArrayReader(filename);
		arrayReader.fillArray(data);
	}

	public void printData() {
		for (int i = 0; i < data.length; i++) {
			System.out.println(data[i]);
		}
	}

	public int getSize() {
		return data.length;
	}

	public double getAverage() {
		double dataSum = 0.0;
		for (int i = 0; i < data.length; i++) {
			dataSum += data[i];
		}

		return dataSum / data.length;
	}

	public double getStanDev() {
		double stanDev = 0;
		for (int i = 0; i < data.length; i++) {
			stanDev += Math.pow(data[i] - getAverage(), 2);
		}
		return Math.sqrt(stanDev / (data.length));
	}

	public int getMode() {
		int primaryCount = 0;
		int secondaryCount = 0;
		for (int i = 0; i < data.length; i++) {
			if (data[i] == data[i + 1] && data[i + 1] < data.length) {
				primaryCount++;
			}
		}

		if (primaryCount > secondaryCount) {

		}
		return 0;
	}
}

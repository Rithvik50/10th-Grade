
public class Statistics {

	public static void main(String[] args) {
		DataSet dataSet = new DataSet();
		dataSet.readData("data/numbers2.txt");
		dataSet.printData();
		System.out.println("Average: " + dataSet.getAverage());
		System.out.println("Standard Deviation: " + dataSet.getStanDev());
		System.out.println("Mode: " + dataSet.getMode());
		System.out.println("Size: " + dataSet.getSize());
	}
}

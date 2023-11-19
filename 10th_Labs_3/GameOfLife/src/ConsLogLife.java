
public class ConsLogLife {

	public static void main(String[] args) {
		Life lifeConsLog = new Life(20, 20, "griddata\\life100.txt");
		lifeConsLog.step(5);
		lifeConsLog.toString();
		System.out.println();
	}

}


public class Main {

	public static void main(String[] args) {
		Erase eraser = new Erase("data//erase.txt");
		eraser.eraseObject(2, 1);
		System.out.println(eraser);
		System.out.println();
		Maze runner = new Maze("data//maze1.txt");
		runner.solve();
		System.out.println(runner);
	}
}

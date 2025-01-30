import java.util.Scanner;

public class Hanoi {

	private static int increment = 0;

	public static void printHanoiSolution(int numberOfDisks) {
		// Call your private Hanoi method
		solveHanoiPuzzle(numberOfDisks, 1, 2, 3);
	}

	// Create a recursive private method
	private static void solveHanoiPuzzle(int disks, int startPeg, int unusedPeg, int endPeg) {
		increment++;
		if (disks == 1) {
			System.out.println("Move the top disk from Peg " + startPeg + " to Peg " + endPeg);
		} else {
			solveHanoiPuzzle(disks - 1, startPeg, endPeg, unusedPeg);
			System.out.println("Move the top disk from Peg " + startPeg + " to Peg " + endPeg);
			solveHanoiPuzzle(disks - 1, unusedPeg, startPeg, endPeg);
		}
	}

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner kboard = new Scanner(System.in);
		System.out.print("Enter the number of rings: ");
		int disks = kboard.nextInt();
		System.out.println("Finding Hanoi solution...");
		printHanoiSolution(disks);
		System.out.println("The number of iterations it takes to solve " + disks + " disks is " + increment);
	}
}

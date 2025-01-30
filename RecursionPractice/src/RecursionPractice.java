
public class RecursionPractice {

	public static int triangleNumber(int n) {
		if (n == 1) {
			return 1;
		} else {
			return n + triangleNumber(n - 1);
		}
	}

	public static int squareNumber(int n) {
		if (n == 0) {
			return 0;
		} else {
			return (n * 2) - 1 + squareNumber(n - 1);
		}
	}

	public static int logBase2(int n) {
		if (n == 1) {
			return 0;
		} else {
			return 1 + logBase2(n / 2);
		}
	}

	public static int pow(int n) {
		if (n == 0) {
			return 1;
		} else {
			return 2 * pow(n - 1);
		}
	}

	public static int pentagonalNumber(int n) {
		if (n == 1) {
			return 1;
		} else {
			return ((n - 2) * 3) + 4 + pentagonalNumber(n - 1);
		}
	}

	public static long iterations = 0;

	public static int fibonacciRecursive(int n) {
		iterations++;
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else {
			return fibonacciRecursive(n - 2) + fibonacciRecursive(n - 1);
		}
	}

	public static long counter = 0;

	public static int fibonacciLoop(int n) {
		int numberBeforeThat = 0;
		int numberBefore = 1;
		int sum;
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else {
			for (int i = 0; i < n - 1; i++) {
				counter++;
				sum = numberBeforeThat + numberBefore;
				numberBeforeThat = numberBefore;
				numberBefore = sum;
			}
			return numberBefore;
		}
	}

	public static void main(String[] args) {

		long start = System.nanoTime();
		int test6 = fibonacciRecursive(45);
		long end = System.nanoTime();

		long commence = System.nanoTime();
		int test7 = fibonacciLoop(40);
		long terminate = System.nanoTime();

		int n = 5;
		int test = triangleNumber(n);
		int test1 = squareNumber(n);
		int l = 32;
		int test2 = logBase2(l);
		int test3 = pow(n);
		int test4 = pentagonalNumber(n);

		System.out.println("The " + n + "th triangular number is " + test);
		System.out.println("The " + n + "th square number is " + test1);
		System.out.println("The log of " + l + " base 2 is " + test2);
		System.out.println("2 to the power of " + n + " is " + test3);
		System.out.println("The " + n + "th pentagonal number is " + test4);
		System.out.println("The output is: " + test6 + ". Iterations: " + iterations + " it took " + (end - start)
				+ " nanoseconds");
		System.out.println("The output is: " + test7 + ". Iterations: " + counter + " it took " + (terminate - commence)
				+ " nanoseconds");

	}
}
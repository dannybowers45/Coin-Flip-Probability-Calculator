import java.util.Arrays;
import java.util.Scanner;

public class coinFlip {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		System.out.println("How many coins will be tossed? ");
		int coins = in.nextInt();

		System.out.println("How many times will the " + coins + " coins be tossed?  ");
		int mult = in.nextInt();

		System.out.println("Number of Heads (0 to " + coins + "):");
		in.close();
		StopwatchInClass x = new StopwatchInClass();
		x.resetWatch();

		int coinArray[] = new int[coins + 1];

		for (int f = 0; f < mult; f++) {
			int e = 0; // coin array adds 1 for as long as the coins are flipped
			for (int up = 0; up < coins; up++) { // how many heads for each time it flips
				e = e + (int) (Math.random() + Math.random()); // Math.random to simulate coin flip
			}

			coinArray[e] += 1;

		} // start up at 1-- only flip one coin - e shouldn't be more than 1 if coin is 1
		double[] percentArray = percent(coinArray, mult);

		factorial(coins);
		scaled(coins, coinArray, mult);
		System.out.println();
		System.out.println();
		System.out.print("This simulation took: " + x.getTime() + " seconds");
	}

	public static double[] percent(int[] data, int mult) {

		double[] pct = new double[data.length];

		for (int x = 0; x < data.length; x++) {
			pct[x] = ((double) data[x] / (double) mult) * 100 + 0.5;
			if (x < 10) {
				System.out.print(" " + x + ": ");
			}
			else {
				System.out.print(x + ": ");
			}
			System.out.println(data[x] + ", " + (int)pct[x] + "%");
		}
		graph(pct);

		return pct;
	}

	public static void graph(double[] percents) {
		System.out.println();
		System.out.println("The bar graph of percentages:");
		System.out.println("    ----+----1----+----2----+----3----+----4----+----5");

		int k, d, r;

		for (r = 0; r < percents.length; r++) {
			String w = "";

			k = (int)percents[r];

			for (d = 0; d < k; d++) {
				w += "*";
			}

			if (percents[r] >= 1 && r < 10) {
				System.out.print(" " + r + ": " + w + " " + (int) percents[r] + "%");
				System.out.println();
			}
			else if (percents[r] >= 1 && r >= 10) {
				System.out.print(r + ": " + w + " " + (int) percents[r] + "%");
				System.out.println();
			}
			else if (percents[r] < 1 && r < 10) {
				System.out.print(" " + r + ": ");
				System.out.println();
			}
			else if (percents[r] < 1 && r >= 10) {
				System.out.print(r + ": ");
				System.out.println();

			}
		}
		System.out.println("    ----+----1----+----2----+----3----+----4----+----5");
	}

	public static int factorial(int coins) {

		int fact = 1;
		for (int h = coins; h > 0; h--) {
			fact = fact * h;
		}

		System.out.println("\n\n" + coins + "! = " + fact);
		return fact;
	}

	public static int[] scaled(int coins, int[] coinArrayx, int toss) {
		int len = coins + 1;
		int[] heads = new int[len];
		int sum = 0;
		double average = (coinArrayx[0] + coinArrayx[len - 1]) / 2;

		for (int i = 1; i < len - 1; i++) {
			heads[i] = (int)(coinArrayx[i] / average + 0.5);
		}
		for (int j = 0; j < len; j++) {
			sum = sum + heads[j];
		}
		sum += 2;
		heads[0] = 1;
		heads[len - 1] = 1;

		System.out.println("\nThe scaled values for " + coins + " coins, after " + toss + " tosses, are: ");
		System.out.print(Arrays.toString(heads));
		System.out.print("  Sum = " + sum);

		return heads;

	}

}

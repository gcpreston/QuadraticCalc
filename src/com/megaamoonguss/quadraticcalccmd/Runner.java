package com.megaamoonguss.quadraticcalccmd;

public class Runner {

	public static void main(String[] args) {

		if (args.length > 3) {
			returnUsage();
			System.exit(0);
		}
		
		try {
			int a = parseInt(args[0]);
			int b = parseInt(args[1]);
			int c = parseInt(args[2]);

			Quadratic quad = new Quadratic (a, b, c);

			int[] factoredEquation = quad.factorEquation();

			System.out.println("\nAnswer:");
			if (factoredEquation == null)
				System.out.println("Not factorable.");
			else {
				System.out.print("(" + factoredEquation[0] + "x ");
				if (factoredEquation[1] > 0)
					System.out.print("+ " + factoredEquation[1] + ")(" + factoredEquation[2] + "x ");
				else
					System.out.print("- " + factoredEquation[1] * -1 + ")(" + factoredEquation[2] + "x ");
				if (factoredEquation[3] > 0)
					System.out.println("+ " + factoredEquation[3] + ")");
				else
					System.out.println("- " + factoredEquation[3] * -1 + ")");
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			returnUsage();
		}
	}

	public static int parseInt(String s) {
		try {
			if (s == null) {
				returnUsage();
				System.exit(0);
				return 0;
			} else {
				return Integer.parseInt(s);
			}
		} catch (final NumberFormatException ex) {
			returnUsage();
			System.exit(0);
			return 0;
		}
	}
	
	public static void returnUsage() {
		System.out.println("Usage: java -jar quadcalc.jar [args...]\nwhere args are three integers a, b, and c to solve ax^2 + bx + c.");
	}
}
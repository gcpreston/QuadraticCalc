package com.megaamoonguss.quadraticcalc;
import java.util.ArrayList;
public class Factor {

	public static ArrayList<Integer> factor (int num) {
		ArrayList<Integer> factors = new ArrayList<Integer>();

		if (num > 0) {
			for (int i = 1; i <= num; i++) {
				if (num % i == 0)
					factors.add(i);
			}
		}
		else {
			for (int i = 1; i <= num*-1; i++) {
				if (num % i == 0)
					factors.add(i);
			}
		}

		return factors;
	}

	public static int findGCF (int num1, int num2) {
		ArrayList<Integer> factorsNum1 = factor(num1);
		ArrayList<Integer> factorsNum2 = factor(num2);
		int GCF = 1;

		for (int i = 0; i < factorsNum1.size(); i++) {
			for (int j = 0; j < factorsNum2.size(); j++) {
				if (factorsNum1.get(i) == factorsNum2.get(j))
					GCF = factorsNum1.get(i);
			}
		}
		return GCF;
	}
}

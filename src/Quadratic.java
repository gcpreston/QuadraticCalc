package com.grahampreston.quadraticcalc;
import java.util.*;
public class Quadratic {

	private int a, b, c;
	private ArrayList<Integer> factors = new ArrayList<Integer>();

	public Quadratic (int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
		factors = Factor.factor(a*c);
	}
	
	public int[] findWorkingFactors () {
		int[] workingFactors = new int[2];
		
		for (int i = 0; i < factors.size(); i++) {
			if (factors.get(i) + factors.get(factors.size() - 1 - i) == b) {
				workingFactors[0] = factors.get(i);
				workingFactors[1] = factors.get(factors.size() - 1 - i);
				return workingFactors;
			}
		}
		
		for (int i = 0; i < factors.size(); i++) {
			if ((factors.get(i) * -1) + (factors.get(factors.size() - 1 - i) * -1) == b) {
				workingFactors[0] = (factors.get(i) * -1);
				workingFactors[1] = (factors.get(factors.size() - 1 - i) * -1);
				return workingFactors;
			}
		}
		
		for (int i = 0; i < factors.size(); i++) {
			if (factors.get(i) + (factors.get(factors.size() - 1 - i) * -1) == b) {
				workingFactors[0] = factors.get(i);
				workingFactors[1] = (factors.get(factors.size() - 1 - i) * -1);
				return workingFactors;
			}
		}

		return null;
	}
	
	public int[] factorEquation () {
		int[] workingFactors = findWorkingFactors();
		
		if (workingFactors == null)
			return null;

		int group1GCF = Factor.findGCF(a, workingFactors[0]);
		int group2GCF = Factor.findGCF(workingFactors[1], c);
		
		if ((a/group1GCF) != (workingFactors[1]/group2GCF) || (workingFactors[0]/group1GCF) != (c/group2GCF)) {
			group2GCF *= -1;
		}
		int[] finalEquation = {group1GCF, group2GCF, (a/group1GCF), (workingFactors[0]/group1GCF)};
		
		return finalEquation;
	}
}

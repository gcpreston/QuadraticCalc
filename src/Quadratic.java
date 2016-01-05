import java.util.ArrayList;

public class Quadratic
{
	private int a;
	private int b;
	private int c;
	private ArrayList<Integer> factors = new ArrayList<Integer>();
	private ArrayList<Integer> negFactors = new ArrayList<Integer>();
	private ArrayList<Integer> revFactors = new ArrayList<Integer>();
	private ArrayList<Integer> revNegFactors = new ArrayList<Integer>();

	public Quadratic(int a, int b, int c)
	{
		this.a = a;
		this.b = b;
		this.c = c;
		this.factors = Factor.factor(a * c);
		this.negFactors = Factor.getNegativeFactors(a * c);
		this.revFactors = Factor.getReverseFactors(a * c);
		this.revNegFactors = Factor.getReverseNegativeFactors(a * c);
	}

	public int[] findWorkingFactors()
	{
		int[] workingFactors = new int[2];
		if (c > 0) {
			for (int i = 0; i < this.factors.size(); i++) {
				if (((Integer)this.factors.get(i)).intValue() + ((Integer)this.revFactors.get(i)).intValue() == this.b)
				{
					workingFactors[0] = ((Integer)this.factors.get(i)).intValue();
					workingFactors[1] = ((Integer)this.revFactors.get(i)).intValue();
					return workingFactors;
				}
			}
		}
		if (c > 0) {
			for (int i = 0; i < this.negFactors.size(); i++) {
				if (((Integer)this.negFactors.get(i)).intValue() + ((Integer)this.revNegFactors.get(i)).intValue() == this.b)
				{
					workingFactors[0] = ((Integer)this.negFactors.get(i)).intValue();
					workingFactors[1] = ((Integer)this.revNegFactors.get(i)).intValue();
					return workingFactors;
				}
			}
		}
		if (c < 0) {
			for (int i = 0; i < this.factors.size(); i++) {
				if (((Integer)this.factors.get(i)).intValue() + ((Integer)this.revNegFactors.get(i)).intValue() == this.b)
				{
					workingFactors[0] = ((Integer)this.factors.get(i)).intValue();
					workingFactors[1] = ((Integer)this.revNegFactors.get(i)).intValue();
					return workingFactors;
				}
			}
		}
		return null;
	}

	public int[] factorEquation()
	{
		int[] workingFactors = findWorkingFactors();
		if (workingFactors == null) {
			return null;
		}
		int group1GCF = Factor.findGCF(this.a, workingFactors[0]);
		int group2GCF = Factor.findGCF(workingFactors[1], this.c);
		if ((this.a / group1GCF != workingFactors[1] / group2GCF) || (workingFactors[0] / group1GCF != this.c / group2GCF)) {
			group2GCF *= -1;
		}
		int[] finalEquation = { group1GCF, group2GCF, this.a / group1GCF, workingFactors[0] / group1GCF };

		return finalEquation;
	}

	public double[] solveForX()
	{
		double[] xValues = new double[2];

		xValues[0] = ((-1 * b) + Math.sqrt((b * b) - (4 * a * c))) / (2 * a);
		xValues[1] = ((-1 * b) - Math.sqrt((b * b) - (4 * a * c))) / (2 * a);

		return xValues;
	}
}

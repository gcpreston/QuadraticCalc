import java.util.ArrayList;

public class Factor
{
  public static ArrayList<Integer> factor(int num)
  {
    ArrayList<Integer> factors = new ArrayList<Integer>();
    if (num > 0) {
      for (int i = 1; i <= num; i++) {
        if (num % i == 0) {
          factors.add(Integer.valueOf(i));
        }
      }
    } else {
      for (int i = 1; i <= num * -1; i++) {
        if (num % i == 0) {
          factors.add(Integer.valueOf(i));
        }
      }
    }
    return factors;
  }
  
  public static ArrayList<Integer> getNegativeFactors(int num)
  {
    ArrayList<Integer> negFactors = factor(num);
    for (int i = 0; i < negFactors.size(); i++) {
      negFactors.set(i, Integer.valueOf(((Integer)negFactors.get(i)).intValue() * -1));
    }
    return negFactors;
  }
  
  public static ArrayList<Integer> getReverseFactors(int num)
  {
    ArrayList<Integer> revFactors = new ArrayList<Integer>();
    if (num > 0) {
      for (int i = num; i >= 1; i--) {
        if (num % i == 0) {
          revFactors.add(Integer.valueOf(i));
        }
      }
    } else {
      for (int i = num * -1; i >= 1; i--) {
        if (num % i == 0) {
          revFactors.add(Integer.valueOf(i));
        }
      }
    }
    return revFactors;
  }
  
  public static ArrayList<Integer> getReverseNegativeFactors(int num)
  {
    ArrayList<Integer> revNegFactors = getReverseFactors(num);
    for (int i = 0; i < revNegFactors.size(); i++) {
      revNegFactors.set(i, Integer.valueOf(((Integer)revNegFactors.get(i)).intValue() * -1));
    }
    return revNegFactors;
  }
  
  public static int findGCF(int num1, int num2)
  {
    ArrayList<Integer> factorsNum1 = factor(num1);
    ArrayList<Integer> factorsNum2 = factor(num2);
    int GCF = 1;
    for (int i = 0; i < factorsNum1.size(); i++) {
      for (int j = 0; j < factorsNum2.size(); j++) {
        if (factorsNum1.get(i) == factorsNum2.get(j)) {
          GCF = ((Integer)factorsNum1.get(i)).intValue();
        }
      }
    }
    return GCF;
  }
}

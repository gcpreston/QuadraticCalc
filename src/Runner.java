import java.util.Scanner;

public class Runner
{
  public static void main(String[] args)
  {
    Scanner kbd = new Scanner(System.in);
    
    boolean again = true;
    
    System.out.println("\n***************************");
    System.out.println("QUADRATIC FACTORING PROGRAM");
    System.out.println("***************************\n");
    while (again)
    {
      System.out.println("Enter a, then b, then c (ax^2 + bx + c):");
      int a = kbd.nextInt();
      int b = kbd.nextInt();
      int c = kbd.nextInt();
      
      Quadratic quad = new Quadratic(a, b, c);
      
      int[] factoredEquation = quad.factorEquation();
      double[] xValues = new double[2];
      
      System.out.println("\nAnswer:");
      if (factoredEquation == null)
      {
        System.out.println("Not factorable.");
      }
      else
      {
        System.out.print("(" + factoredEquation[0] + "x ");
        if (factoredEquation[1] > 0) {
          System.out.print("+ " + factoredEquation[1] + ")(" + factoredEquation[2] + "x ");
        } else {
          System.out.print("- " + factoredEquation[1] * -1 + ")(" + factoredEquation[2] + "x ");
        }
        if (factoredEquation[3] > 0) {
          System.out.println("+ " + factoredEquation[3] + ")");
        } else {
          System.out.println("- " + factoredEquation[3] * -1 + ")");
        }
      }
      
      xValues = quad.solveForX();
      System.out.println("x = " + xValues[0] + ", " + xValues[1]);
      
      System.out.println("\nAgain? y/n");
      if (kbd.next().equals("y")) {
        again = true;
      } else {
        again = false;
      }
      System.out.println("");
    }
    kbd.close();
  }
}

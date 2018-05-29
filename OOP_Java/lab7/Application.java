import java.util.Deque;
import java.util.LinkedList;
import java.lang.RuntimeException;
import java.util.Scanner;

public class Application extends RuntimeException{

  private final static String DELIM = " ";

  public static double parse(String rpnString) {
    if (rpnString == null || rpnString.isEmpty()) {
      throw new RuntimeException();
    }
    Deque<Double> stek = new LinkedList<Double>();
    String[] result = rpnString.split(DELIM);
    for (int i = 0; i < result.length; i++) {
      if (isNumber(result[i])) {
        stek.push(new Double(result[i]));
      } else if (isOperator(result[i])) {
        if (stek.size() < 2) {
          throw new RuntimeException();
        }
        switch (result[i]) {
        case "+":
          stek.push(new Double(stek.pop() + stek.pop()));
          break;
        case "-":
          stek.push(new Double(-stek.pop() + stek.pop()));
          break;
        case "/":
          if(stek.peek() == 0){
            throw new ArithmeticException();
          }
            stek.push(new Double(1/stek.pop() * stek.pop()));
          break;
        case "*":
          stek.push(new Double(stek.pop() * stek.pop()));
          break;
        }
      } else {
        throw new RuntimeException();
      }
    }
    if (stek.size() != 1) {
      throw new RuntimeException();
    }
    return stek.pop();
  }

  private static boolean isNumber(String string) {
    if (string == null)
      return false;
    return string.matches("^-?\\d+(\\.\\d+)?$");
  }

  private static boolean isOperator(String string) {
    if (string == null)
      return false;
    return string.matches("[+-/*]{1}");
  }

  public static void main(String[] args) {
    
    Scanner in = new Scanner(System.in);
    String str = in.nextLine();

    System.out.println(parse(str));
  }
}
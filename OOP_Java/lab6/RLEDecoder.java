import java.util.Scanner;

public class RLEDecoder {

    public static void main( String[] args ) {
       Scanner in = new Scanner(System.in);
        String str = in.next();
        str += '-';

        char[] arr = str.toCharArray();
        boolean inconv = false;
        StringBuffer finstr = new StringBuffer();

        for(int i = 0, len = arr.length - 1; i < len; i++) {
            if(Character.isDigit(arr[i]) && Character.isDigit(arr[i + 1]) || arr[i] == arr[i + 1] || str.equals("")) {
                inconv = true;
            }
        }

        if(inconv || Character.isDigit(arr[0])) {
            System.out.println("");
            return;
        }

        for(int i = 0, len = arr.length - 1; i < len; i++) {
            if(Character.isDigit(arr[i])) {
                for(int j = 0; j < Character.getNumericValue(arr[i]); j++) {
                    finstr.append(arr[i - 1]);
                }
            }
            if(!Character.isDigit(arr[i]) && !Character.isDigit(arr[i + 1])) {
                finstr.append(arr[i]);
            }
        }
        System.out.println(finstr);
    }
}

import java.util.Scanner;

public class RLE {

    public static void main( String[] args ) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        if(str.equals("")) {
            System.out.println("");
            return;
        }
        str += '-';

        char[] arr = str.toCharArray();
        int counter = 0, times = 0, other = 0;
        StringBuffer finstr = new StringBuffer();

        for(int i = 0, len = arr.length - 1; i < len; i++) {
            if(arr[i] == arr[i + 1]) {
                counter++;
            }
            else if(arr[i] != arr[i + 1] || i == len - 1) {
                times = counter / 9;
                other = counter % 9;
                if(times > 0) {
                    while (times > 0) {
                        finstr.append(arr[i]);
                        finstr.append("9");
                        times--;

                    }
                }
                if(other > 0) {
                    other++;
                    finstr.append(arr[i]);
                    finstr.append(other);
                    counter = 0;
                }
                else {
                    finstr.append(arr[i]);
                }
            }
        }
        System.out.println(finstr);
    }
}

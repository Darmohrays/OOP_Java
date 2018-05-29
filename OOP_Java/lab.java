import java.util.Scanner;

public class lab{
    public static void main(String[] args) {
        int n, m, k=0;
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();

        String[] zenyk = new String[n];
        String[] marichka = new String[m];

        for(int i=0; i < n; i++){
            zenyk[i] = scan.nextLine();
        }
        
        for (int j=0; j < m; j++) {
            marichka[j] = scan.nextLine();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(zenyk[i].equals(marichka[j])){
                    k++;
                }
            System.out.print(n+m-k);
            }
        }
    
    }
}
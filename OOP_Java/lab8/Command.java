import java.util.Scanner;

public class Command {
    static Scanner scan=new Scanner(System.in);
    static String str="";
    static String[] words;
    static int c =0;
    public static void input() {
        String in = scan.next();
        while (!in.equals("end")) {
            str+=in+ " ";
            in = scan.next();
        }
        System.out.println("Done!");
    }

    public static void show() {
        System.out.println("String: " + str.toString());
       words = str.split(" ");  
       System.out.print("Words: ");
       for(int i=0;i<str.split(" ").length;i++)
       System.out.print(words[i]+ " ,");
       System.out.println();
 }



    public static void help() {
        System.out.println("Available Commands: \n" +
                "-start - Start the program \n" +
                "-help or -h  - Instructions \n" +
                "-debug or -d  - Debug mode \n" +
                "-show  - Show your's inputted strings \n" +
                "-exit - Exit the program :)");
    }

    public static void debug() {
        System.out.println("String: " + str.toString());
        words = str.split(" ");  
        System.out.print("Words: ");
        for(int i=0;i<str.split(" ").length;i++)
        System.out.print(words[i]+ " ,");
        System.out.println();
        if(c==0) {
            for(int i=0;i<str.split(" ").length;i++) {
           		for(int j=i+1;j<str.split(" ").length;j++) {
           		if(words[i].equals(reverse(words[j]))){
           			c++;
           		}
           	}
           }
            }
            System.out.print("Reversed Words = [");
            for(int i=0;i<str.split(" ").length;i++)
                System.out.print(reverse(words[i])+ ", ");
            System.out.println("]");
            System.out.println("Amount of Couples : " + c);
            System.out.println("Couples :");
            for(int i=0;i<str.split(" ").length;i++) {
        		for(int j=i+1;j<str.split(" ").length;j++) {
        		if(words[i].equals(reverse(words[j]))) {
        			System.out.println("[ " + words[i] + "  --  " + words[j]+ " ]");
        		}
        	}
        }
      }
    public static String reverse ( String s ) {
        int length = s.length(), last = length - 1;
        char[] chars = s.toCharArray();
        for ( int i = 0; i < length/2; i++ ) {
            char c = chars[i];
            chars[i] = chars[last - i];
            chars[last - i] = c;
        }
        return new String(chars);
    }
        
    }

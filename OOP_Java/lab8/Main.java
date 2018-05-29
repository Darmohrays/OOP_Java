import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Command command = new Command();
        Scanner scan = new Scanner(System.in);
         String in;

        command.help();
        while(true){
            in = scan.next();
            switch(in.toLowerCase()){
                case "-start":
                	System.out.println("*** THE PROGRAM IS STARTED ***");
                    System.out.println("Enter string (if you finished type 'end':) ");
                    command.input();
                    break;

                case ("-show"):
                	System.out.println("*** SHOW MODE ***");
                    System.out.print("Your Input: ");
                    System.out.println();
                    command.show();
                    break;

                case "-exit":
                    System.out.print("***Thanks for Attention :) ***");
                    System.exit(0);
                    break;

                case "-help":
                	System.out.println("***HELP***");
                    command.help();
                    break;
                case "-h":
                	System.out.println("***HELP***");
                    command.help();
                    break;
                case "-debug":
                	System.out.println("***DEBUG MODE***");
                    command.debug();
                    break;
                case "-d":
                	System.out.println("***DEBUG MODE***");
                    command.debug();
                    break;
                    default:
                        System.out.println("Wrong command :( Please type -help for instructions");
            }
        }
    }
}
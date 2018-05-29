import java.util.*;

class Item {
    private int Number;
    private String DepartureTime = "";
    private String DaysOfWeek = "";
    private int FreePlaces;
    private ArrayList<String> Route = new ArrayList<String>();

    public void addRouteInfo(String s){
    	Route.add(s);
    }

    public String Info(){
        String res = "Number of the Trip: " + getNumber() + "\n" +
                "Departure Time: " + getDepartureTime() + "\n" +
                "Days of Weeks: " + getDaysOfWeek() + "\n" +
                "Free Places: " + getFreePlaces() + "\n";
        for (String e: Route
             ) {
            res +=  e + "\n";
        }
        return res;
    }


    public String getNumber() {
        return Integer.toString(Number);
    }
    public void setNumber(int i) {
    	Number = i;
    }

    public String getFreePlaces() {
        return Integer.toString(FreePlaces);
    }

    public void setFreePlaces(int i) {
    	FreePlaces = i;
    }
    public String getDepartureTime() {
        return DepartureTime;
    }

    public void setDepartureTime(String i) {
    	DepartureTime = i;
    }
    public void setDaysOfWeek(String u) {
    	DaysOfWeek = u;
    }
    public String getDaysOfWeek() {
        return DaysOfWeek;
    }

    

}

class Trip {
    private ArrayList<Item> items = new ArrayList<Item>();

    public void List(){
        if (items.size() == 0) {
            System.out.println("TripList is empty!");
        } else {
            int c = 0;
            for (Item i: items
                    ) {
                System.out.println("id: " + Integer.toString(c++));
                System.out.println(i.Info());
            }
        }
    }

    public void removeItem(){
        Scanner sc = new Scanner(System.in);
        int i = Integer.parseInt(sc.nextLine());
        items.remove(i);
    }


    public void addItem(){
        Item item = new Item();

        Scanner sc = new Scanner(System.in);
        String in;

        System.out.println("Enter trip number:");
        in = sc.nextLine();
        while (!in.matches("^\\d+")) {
        	
            System.out.println("Enter valid number:");
            in = sc.nextLine();
            
        }
        item.setNumber(Integer.parseInt(in));

        System.out.println("Enter Trip departure time format(yyyy-mm-dd):");
        in = sc.nextLine();
        while (!in.matches("^[0-9]{4}-(((0[13578]|(10|12))-(0[1-9]|[1-2][0-9]|3[0-1]))|(02-(0[1-9]|[1-2][0-9]))|((0[469]|11)-(0[1-9]|[1-2][0-9]|30)))$")) {
        	
            System.out.println("Enter valid time:");
            in = sc.nextLine();
            
        }
        item.setDepartureTime(in);

        System.out.println("Enter Trip Days of Week:");
        item.setDaysOfWeek(sc.nextLine());

        System.out.println("Enter amount of Free Places:");
        in = sc.nextLine();
        while (!in.matches("^\\d+")) {
            System.out.println("Enter valid amount:");
            in = sc.nextLine();
        }

        item.setFreePlaces(Integer.parseInt(in));

        while (true) {

            System.out.println("To exit enter ~");
            System.out.println("Add specification:");
            in = sc.nextLine();
            if (in.equals("~")) {
                break;
            } else {
                item.addRouteInfo(in);
            }

        }
        items.add(item);
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Program started!");
        String in;

        Trip trip = new Trip();

        while(true){
            in = sc.nextLine();
            switch(in.toLowerCase()){

                case "-a":
                case "-add":
                	trip.addItem();
                    break;

                case "-r":
                case "-remove":
                	trip.removeItem();
                    break;
                case "-i":
                case "-info":
                	trip.List();
                    break;

                case "-e":
                case "-exit":
                    System.out.println("Bye, bye!");
                    System.exit(0);
                    break;
  
                default:
                    System.out.println("Wrong command!");
                    break;
            }
        }
    }
}
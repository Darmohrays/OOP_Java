import java.util.*;

class Item {
    private String Number = "";
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
        return Number;
    }
    public void setNumber(String s) {
    	Number = s;
    }

    public String getFreePlaces() {
        return Integer.toString(FreePlaces);
    }

    public void setFreePlaces(int i) {
    	FreePlaces = i;
    }
    public String getDepartureTime() {
        return Integer.toString(FreePlaces);
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
            System.out.println("Trip is empty!");
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
        item.setNumber(in);

        System.out.println("Enter Trip departure time:");
        item.setDepartureTime(sc.nextLine());

        System.out.println("Enter Trip Days of Weeks:");
        item.setDaysOfWeek(sc.nextLine());

        System.out.println("Enter amount of Free Places:");
        item.setFreePlaces(Integer.parseInt(sc.nextLine()));

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

                case "-add":
                case "--add":
                	trip.addItem();
                    break;

                case "-r":
                case "--remove":
                	trip.removeItem();
                    break;
                case "-i":
                case "--info":
                	trip.List();
                    break;

                case "-e":
                case "--exit":
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
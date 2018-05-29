import java.util.Scanner;

class Node<Trip> {
    private Node<Trip> next;
    private Trip data;

    public Node() {
    }

    public Node<Trip> getNext() {
        return next;
    }
    public void setNext(Node next) {
        this.next = next;
    }
    public Trip getData() {
        return data;
    }
    public void setData(Trip data) {
        this.data = data;
    }
}

class LinkedList<Trip> {
    private Node<Trip> tail;
    private Node head;
    private int size = 0;

    public LinkedList() {

    }

    public void add(Trip data) {
        Node<Trip> newNode = new Node<Trip>();
        newNode.setData(data);

        if (size == 0)
            head = newNode;
        else
            tail.setNext(newNode);

        tail = newNode;
        size++;
    }

    public Trip get(int index) {
        Node<Trip> n = findNodeByIndex(index);
        return n.getData();
    }

    public boolean delete(int index) {
        if (findNodeByIndex(index) != null ) {

            if (index != 0)
                findNodeByIndex(index - 1).setNext(findNodeByIndex(index+1));
            else
                head = head.getNext();

            size--;
            return true;
        }
        return false;
    }

    public void clean(){
        int s = size;
        for (int i = 0; i < s; i++) {
            delete(0);
        }
    }

    public int size() {
        return size;
    }

    private Node<Trip> findNodeByIndex(int index) {
        if (index < size && index >= 0) {
            Node<Trip> curNode = head;
            int curIndex = 0;
            while (curIndex < index){
                if (curNode.getNext() != null) {
                    curNode = curNode.getNext();
                    curIndex++;
                }

            }
            return curNode;
        }
        else
            return null;
    }

    public String toString() {
        StringBuilder resultString = new StringBuilder("[");

        for (int i = 0; i < size; i++) {
            resultString.append(get(i));

            if (i < size-1) resultString.append(", ");
        }
        resultString.append("]");
        return resultString.toString();
    }
    public Object[] toArray() {
        Object[] result = new Object[size];
        int i = 0;
        for (Node<Trip> x = head; x != null; x = x.getNext())
            result[i++] = x.getData();
        return result;
    }
}

public class Main {

    static void auto(){
        System.out.println("Creating list...");
        LinkedList<String> list = new LinkedList<String>();

        list.add("Trip 1");
        list.add("Trip 2");
        list.add("Trip 1");
        list.add("Trip 3");
        System.out.println("Using toString:");
        System.out.println(list.toString());
        list.delete(2);
        System.out.println("Converting to Array...");
        Object[] arr = list.toArray();
        for (Object e: arr
                ) {
            System.out.println(e);
        }
        System.out.println("Cleaning list...");
        list.clean();
        System.out.println(list.toString());
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Program started!");
        String in;

        LinkedList<String> list = new LinkedList<String>();

        while(true){
            in = sc.nextLine();
            switch(in.toLowerCase()){

                case "-a":
                case "--auto":
                    auto();
                    System.exit(0);
                    break;

                case "-add":
                case "--add":
                    System.out.println("Enter data:");
                    list.add(sc.nextLine());
                    break;

                case "-r":
                case "--remove":
                    System.out.println("Enter id:");
                    list.delete(Integer.parseInt(sc.nextLine()));
                    break;

                case "-p":
                case "--print":
                    System.out.println(list.toString());
                    break;

                case "-c":
                case "--clean":
                    System.out.println("Cleaning the list...");
                    list.clean();
                    System.out.println("Cleaned.");

                    break;

                case "-array":
                case "--array":
                    System.out.println("Converting to Array...");
                    Object[] arr = list.toArray();
                    for (Object e: arr
                            ) {
                        System.out.println(e);
                    }
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
public class Fibonacci {

    private long number = 0, previous = 1, result = -1;

    public static void main(String args[]){
        Fibonacci fibonacci = new Fibonacci();

        System.out.println(fibonacci.getNumber(6));
    }

    public long getNumber(int position){
        if (position <= 0) {
            return -1;
        }
        if (position == 1 || position == 2) {
            return 1;
        }
        return getNumber(position - 1) + getNumber(position - 2);
    }
}

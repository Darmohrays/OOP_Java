public class DateCommand implements Command {

    public void execute() {
        System.out.println(System.currentTimeMillis());
    }
}

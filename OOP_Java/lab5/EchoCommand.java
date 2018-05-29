public class EchoCommand implements Command {

    private String string;

    public EchoCommand(String string) {
        this.string = string;
    }

    public void execute() {
        System.out.println(this.string);
    }
}

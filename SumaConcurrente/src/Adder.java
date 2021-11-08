public class Adder {
    private final int startNumber;
    private final int endNumber;
    private final String processName;

    public Adder(int startNumber, int endNumber, String processName) {

        this.startNumber = startNumber;
        this.endNumber = endNumber;
        this.processName = processName;
    }

    public int add() {
        int result = 0;
        for (int i = startNumber; i < endNumber; i++) {
            result += 1;
            System.out.println(String.format("%s %d", this.processName, result));
        }
        return result;
    }

    public static void main(String[] args) {
        int startNumber = Integer.parseInt(args[0]);
        int endNumber = Integer.parseInt(args[1]);
        String processName = args[2];
        Adder adder = new Adder(startNumber, endNumber, processName);
        adder.add();
    }
}

public class Principal {
    public static void main(String[] args) {
        final int MAX_CLIENTS = 20;
        final int PROBABILITY_FEMALE = (int) (Math.random() * 10);
        final int PROBABILITY_FAST = (int) (Math.random() * 20);
        final int SIMULATION_TIME = 20000;
        Customer[] customer = new Customer[MAX_CLIENTS];
        for (int i = 0; i < MAX_CLIENTS; i++) {
            if (PROBABILITY_FEMALE > 5) {
                customer[i] = new FemaleCustomer(i, PROBABILITY_FAST);
            }
        }
        System.out.println(PROBABILITY_FEMALE);
    }
}

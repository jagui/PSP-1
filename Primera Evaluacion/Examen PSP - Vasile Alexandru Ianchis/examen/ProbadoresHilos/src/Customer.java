public abstract class Customer {
    private final int SLOW_CLIENT_TIMEOUT = 1500;
    private final int FAST_CLIENT_TIMEOUT = 500;
    private int clientSpeed;
    private int clientName;

    public Customer(int _clientName, int _probabilityFast) {
        clientName = _clientName;

        if (_probabilityFast >= 10) {
            clientSpeed = FAST_CLIENT_TIMEOUT;
        } else {
            clientSpeed = SLOW_CLIENT_TIMEOUT;
        }
    }

}

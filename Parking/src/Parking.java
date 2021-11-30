public class Parking {
    private final int _capacity;
    private int _occupancy;

    public Parking(int capacity) {
        _capacity = capacity;
    }

    public synchronized int ocuppancy() {
        return _occupancy;
    }

    public synchronized void park(Car car) throws InterruptedException {
        while (_occupancy >=_capacity) {
            System.out.printf("Car %s awaiting for available parking space%n", car.getName());
            wait();
        }
        _occupancy++;
        System.out.printf("Car %s parked, there's %d cars parked%n", car.getName(), _occupancy);
        notifyAll();
    }

    public synchronized void leave(Car car) {
        _occupancy--;
        System.out.printf("Car %s parked, there's %d cars parked%n", car.getName(), _occupancy);
        notifyAll();
    }
}

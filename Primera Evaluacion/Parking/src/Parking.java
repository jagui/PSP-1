public class Parking {
    private final int capacidadParking;
    private int plazasOcupadas = 0;

    public Parking(int capacity) {
        capacidadParking = capacity;
    }

    public synchronized int ocuppancy() {
        return plazasOcupadas;
    }

    public synchronized void park(Car car) throws InterruptedException {
        while (plazasOcupadas >= capacidadParking) {
            System.out.printf("Car %s awaiting for available parking space%n", car.getName());
            wait();
        }
        plazasOcupadas++;
        System.out.printf("Car %s parked, there's %d cars parked%n", car.getName(), plazasOcupadas);
        notifyAll();
    }

    public synchronized void leave(Car car) {
        plazasOcupadas--;
        System.out.printf("Car %s left, there's %d cars parked%n", car.getName(), plazasOcupadas);
        notifyAll();
    }
}

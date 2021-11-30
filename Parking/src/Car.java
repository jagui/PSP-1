public class Car extends Thread {

    private final Parking _parking;

    public Car(Parking parking, String name) {
        super(name);
        _parking = parking;

    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep((int) (Math.random() * 1000));
                _parking.park(this);
                Thread.sleep((int) (Math.random() * 1000));
                _parking.leave(this);
            } catch (InterruptedException e) {
                System.out.printf("%s died%n", getName());
                break;
            }
        }
    }
}

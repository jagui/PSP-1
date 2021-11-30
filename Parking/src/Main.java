public class Main {
    public static void main(String[] args) throws InterruptedException {
        Parking parking = new Parking(2);
        Car mustang = new Car(parking, "Mustang");
        Car fiat = new Car(parking, "Fiat");
        Car renault = new Car(parking, "Renault");
        mustang.start();
        fiat.start();
        renault.start();
        Thread.sleep((int) (Math.random() * 10000));

        mustang.interrupt();
        fiat.interrupt();
        renault.interrupt();

        mustang.join();
        fiat.join();
        renault.join();

        System.out.println("Parking just closed.");
    }
}

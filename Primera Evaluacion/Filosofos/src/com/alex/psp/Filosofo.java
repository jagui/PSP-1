package com.alex.psp;

public class Filosofo extends Thread {
    private final int _maximoCenas = 3;
    private final Mesa _mesa;
    private final Tenedor _tenedorIzquierdo;
    private final Tenedor _tenedorDerecho;

    public Filosofo(int numero, Mesa mesa, Tenedor tenedorIzquierdo, Tenedor tenedorDerecho) {
        super(String.format("Filosofo %d", numero));
        _mesa = mesa;
        _tenedorIzquierdo = tenedorIzquierdo;
        _tenedorDerecho = tenedorDerecho;
    }

    private void randomSleep() throws InterruptedException {
        // duerme un segundo más un rango entre 1 y 2 segundos
        Thread.sleep(1000 + (int) (Math.random() * 2000));
    }

    @Override
    public void run() {
        for (int i = 0; i < _maximoCenas; i++) {
            try {
                // Meditar
                System.out.printf("%s meditando%n", getName());
                randomSleep();
                // Coger tenedores
                System.out.printf("%s intentando coger tenedores%n", getName());
                _mesa.cogerTenedores(_tenedorIzquierdo, _tenedorDerecho);
                // Cenar
                System.out.printf("%s cenando%n", getName());
                randomSleep();
                // Dejar tenedores
                System.out.printf("%s ha soltado los tenedores%n", getName());
                _mesa.dejarTenedores(_tenedorIzquierdo, _tenedorDerecho);
            } catch (InterruptedException e) {
                break;
            }
        }


    }
}

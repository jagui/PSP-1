package com.alex.psp;

public class Mesa {

    public synchronized void cogerTenedores(Tenedor tenedorIzquierdo, Tenedor tenedorDerecho) throws InterruptedException {
        while (!tenedorIzquierdo.available || !tenedorDerecho.available) {
            wait();
        }
        tenedorIzquierdo.available = false;
        tenedorDerecho.available = false;
        notifyAll();

    }

    public synchronized void dejarTenedores(Tenedor tenedorIzquierdo, Tenedor tenedorDerecho) {
        tenedorIzquierdo.available = true;
        tenedorDerecho.available = true;
        notifyAll();
    }
}

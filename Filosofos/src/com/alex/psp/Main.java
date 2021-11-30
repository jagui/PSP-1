package com.alex.psp;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Mesa mesa = new Mesa();
        List<Tenedor> tenedores = new ArrayList<Tenedor>();
        List<Filosofo> filosofos = new ArrayList<Filosofo>();
        for (int i = 0; i < 5; i++) {
            tenedores.add(new Tenedor());
        }
        for (int i = 0; i < 5; i++) {
            filosofos.add(new Filosofo(i,
                    mesa,
                    tenedores.get(i),
                    tenedores.get((i + 1) % 5)));
        }
        for (Filosofo filosofo : filosofos) {
            filosofo.start();
        }
    }
}

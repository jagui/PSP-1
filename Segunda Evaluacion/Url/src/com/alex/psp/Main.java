package com.alex.psp;

import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {
        FileDownloader textFileDownloader = new TextFileDownloader("https://docs.oracle.com/javase/tutorial/networking/sockets/index.html"
                , "archivo.html");
        textFileDownloader.download();
        BinaryFileDownloader binaryFileDownloader = new BinaryFileDownloader("https://www.hola.com/imagenes/estar-bien/20190820147813/razas-perros-pequenos-parecen-grandes/0-711-550/razas-perro-pequenos-grandes-a.jpg?filter=w500"
                ,"perro.jpg");
        binaryFileDownloader.download();
    }
}


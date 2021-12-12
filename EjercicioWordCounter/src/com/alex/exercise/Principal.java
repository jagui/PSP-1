package com.alex.exercise;


import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Principal {
    public static void main(String[] args) throws InterruptedException {

        Path booksPath = Paths.get(System.getProperty("user.dir"), "books");
        File mainDirectory = new File(String.valueOf(booksPath));
        int directoryNumberOfFiles = mainDirectory.list().length;
        File[] booksFiles;
        booksFiles = mainDirectory.listFiles();
        /*for (File f : booksFiles) {
            System.out.println(f);
        }*/
        WordCounter firstBook = new WordCounter(booksFiles[0]);
        WordCounter secondBook = new WordCounter(booksFiles[1]);
        WordCounter thirdBook = new WordCounter(booksFiles[2]);
        WordCounter fourthBook = new WordCounter(booksFiles[3]);

        // threads run
        firstBook.run();
        secondBook.run();
        thirdBook.run();
        fourthBook.run();
        // join threads
        firstBook.join();
        secondBook.join();
        thirdBook.join();
        fourthBook.join();
    }
}

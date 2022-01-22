package com.alex.exercise;

import java.io.*;

public class WordCounter extends Thread {
    private File bookFile;
    private FileReader fr;
    private BufferedReader br;
    private int wordCount;


    public WordCounter(File file) {
        bookFile = file;
    }

    @Override
    public void run() {
        try {
            String[] words = null;
            fr = new FileReader(bookFile);
            br = new BufferedReader(fr);
            wordCount = 0;
            String s;
            while (((s = br.readLine()) != null)) {
                words = s.split(" ");
                wordCount += words.length;
            }
            System.out.println("File " + bookFile.getName() + " has " + wordCount + " words.");
            fr.close();
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

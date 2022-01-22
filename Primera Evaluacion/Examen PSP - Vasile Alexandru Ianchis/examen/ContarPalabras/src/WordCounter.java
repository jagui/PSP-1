import java.io.*;

public class WordCounter extends Thread {
    private static File bookFile;
    private static FileReader fr;
    private static BufferedReader br;
    private static int wordCount;



    public static void main(String[] args) throws IOException {
        String[] words = null;
        bookFile = new File(args[0]);
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
    }
}

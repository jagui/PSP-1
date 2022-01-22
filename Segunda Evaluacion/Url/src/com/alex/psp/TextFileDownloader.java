package com.alex.psp;

import java.io.*;
import java.net.MalformedURLException;

public class TextFileDownloader extends FileDownloader {

    public TextFileDownloader(String src, String dst) throws MalformedURLException {
        super(src, dst);
    }

    @Override
    public void download() throws IOException {
        try (InputStream urlStream = url.openStream()) {
            try (InputStreamReader inputStreamReader = new InputStreamReader(urlStream)) {
                try (BufferedReader reader = new BufferedReader(inputStreamReader)) {
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(path.toString()))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            writer.write(line);
                            writer.newLine();
                        }
                    }
                }
            }
        }
    }
}

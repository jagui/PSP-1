package com.alex.psp;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class BinaryFileDownloader extends FileDownloader {
    public BinaryFileDownloader(String src, String dst) throws MalformedURLException {
        super(src, dst);
    }

    @Override
    public void download() throws IOException {
        InputStream in = url.openStream();
        Files.copy(in, path, StandardCopyOption.REPLACE_EXISTING);

    }
}

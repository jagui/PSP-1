package com.alex.psp;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class FileDownloader {
    protected final URL url;
    protected final Path path;

    public FileDownloader(String src, String dst) throws MalformedURLException {
        url = new URL(src);
        path = Paths.get(System.getProperty("user.home"), "downloads", dst);
    }

    public abstract void download() throws IOException;
}

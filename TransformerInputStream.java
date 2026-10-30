package com.epam.autotasks;

import java.io.IOException;
import java.io.InputStream;

public class TransformerInputStream extends InputStream {

    private final InputStream inputStream;

    public TransformerInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public int read() throws IOException {

        int ch;

        while ((ch = inputStream.read()) != -1) {

            if (ch >= 'A' && ch <= 'Z') {
                return 'A' + (ch - 'A' + 2) % 26;
            }

            if (ch >= 'a' && ch <= 'z') {
                return 'a' + (ch - 'a' + 2) % 26;
            }

            if (ch == '\n') {
                return ch;
            }
        }

        return -1;
    }

    @Override
    public void close() throws IOException {
        inputStream.close();
        System.out.println("Stream closed");
    }
}
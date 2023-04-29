package com.goit.reading;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Reader {

    private final String resourceName;

    public Reader(String resourceName) {
        this.resourceName = resourceName;
    }

    public String read() {

        try {
//            List<String> listStrings = Files.readAllLines(Paths.get(resourceName));
//            String result = String.join("", listStrings);
            String result = Files.readString(Paths.get(resourceName));
            return result;
        } catch (Exception e) {
            throw new ResourceReadException("Resource: " + resourceName + " reading failed", e);
        }
    }
}

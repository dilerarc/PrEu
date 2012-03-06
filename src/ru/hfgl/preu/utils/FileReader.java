package ru.hfgl.preu.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

    private Charset charset = Charset.forName("US-ASCII");
    private List<String> list = new ArrayList<>();

    public FileReader(String str, Charset charset) throws NoSuchFileException {
        Path path = Paths.get(str);
        this.charset = charset;
        try (BufferedReader reader = Files.newBufferedReader(path, charset)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException x) {
            throw new NoSuchFileException(path.toString());
        }
    }

    public FileReader(String str)  throws NoSuchFileException {
        Path path = Paths.get(str);
        try (BufferedReader reader = Files.newBufferedReader(path, charset)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
            reader.close();
        } catch (IOException x) {
            throw new NoSuchFileException(path.toString());
        }
    }

    public List<String> getList() {
        return list;
    }
}

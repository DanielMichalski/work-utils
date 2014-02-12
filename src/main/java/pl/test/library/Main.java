package pl.test.library;

import javax.swing.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Author: Daniel
 */
public class Main {
    public static void main(String[] args) {
        Path path = Paths.get("test.txt");

        boolean exists = Files.exists(path);

        JOptionPane.showMessageDialog(null, "Czy plik istnieje? " + exists);
        JOptionPane.showMessageDialog(null, path.toFile().getAbsolutePath());
    }
}

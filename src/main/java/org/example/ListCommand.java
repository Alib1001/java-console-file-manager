package org.example;

import java.io.File;

import static org.example.ConsoleFileManager.currentDirectory;

public class ListCommand implements Command{
    @Override
    public void execute() {
        File[] files = currentDirectory.listFiles();
        for (File file : files) {
            System.out.println(file.getName());
        }
    }
}

package org.example;

import java.io.File;

import static org.example.ConsoleFileManager.currentDirectory;

public class ChangeDirectoryCommand implements Command{
    private String directory;

    public ChangeDirectoryCommand(String directory) {
        this.directory = directory;
    }

    @Override
    public void execute() {
        File newDirectory = new File(currentDirectory, directory);
        if (!newDirectory.exists()) {
            System.out.println("Ошибка: Каталог не найден.");
        } else if (!newDirectory.isDirectory()) {
            System.out.println("Ошибка: Это не каталог.");
        } else {
            currentDirectory = newDirectory;
        }
    }
}

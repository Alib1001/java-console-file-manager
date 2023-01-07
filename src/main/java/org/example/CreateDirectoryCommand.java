package org.example;

import java.io.File;

import static org.example.ConsoleFileManager.currentDirectory;

public class CreateDirectoryCommand implements Command{
    private String directory;
    public CreateDirectoryCommand(String directory) {
        this.directory = directory;
    }
    @Override
    public void execute() {
        File newDirectory = new File(currentDirectory, directory);
        if (newDirectory.exists()) {
            System.out.println("Ошибка: Каталог уже существует.");
        } else if (!newDirectory.mkdir()) {
            System.out.println("Ошибка: Неудалось создать каталог.");
        }
    }
}

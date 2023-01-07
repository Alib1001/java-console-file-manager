package org.example;

import java.io.File;
import java.io.IOException;

import static org.example.ConsoleFileManager.currentDirectory;

public class CreateFileCommand implements Command{
    private String file;
    public CreateFileCommand(String file) {
        this.file = file;
    }
    @Override
    public void execute() {
        File newFile = new File(currentDirectory, file);
        if (newFile.exists()) {
            System.out.println("Ошибка: Файл уже существует.");
        } else {
            try {
                if (newFile.createNewFile()) {
                    System.out.println("Файл создан.");
                } else {
                    System.out.println("Ошибка: Не удалось создать файл.");
                }
            } catch (IOException e) {
                System.out.println("Ошибка: Не удалось создать файл.");
            }
        }
    }
}

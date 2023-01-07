package org.example;

import java.io.File;

import static org.example.ConsoleFileManager.currentDirectory;

public class DeleteFileCommand implements Command{
    private String file;
    public DeleteFileCommand(String file) {
        this.file = file;
    }
    @Override
    public void execute() {
        File deleteFile = new File(currentDirectory, file);
        if (!deleteFile.exists()) {
            System.out.println("Ошибка: Файл не найден.");
        } else if (!deleteFile.delete())
        {
            System.out.println("Ошибка: Невозможео удалить файл.");
        }
    }
}

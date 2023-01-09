package org.example;

import java.util.Scanner;

import static org.example.ConsoleFileManager.currentDirectory;

public class ParseCommands {
    static Scanner scanner = new Scanner(System.in);
    static Command command;
    public void parseCommands(){
        while (true) {
            //Вывод текущей директории
            System.out.print(currentDirectory.getAbsolutePath() + "> ");

            //Чтение комманды
            String command = scanner.nextLine();
            String[] parts = command.split(" ");

            if (parts[0].equals("ls")) {
                listDirectory();
            } else if (parts[0].equals("cd")) {
                if (parts.length < 2) {
                    System.out.println("Ошибка: укажите каталог.");
                } else {
                    changeDirectory(parts[1]);
                }
            } else if (parts[0].equals("mkdir")) {
                if (parts.length < 2) {
                    System.out.println("Ошибка: укажите имя каталога.");
                } else {
                    createDirectory(parts[1]);
                }
            } else if (parts[0].equals("touch")) {
                if (parts.length < 2) {
                    System.out.println("Ошибка: укажите имя файла.");
                } else {
                    createFile(parts[1]);
                }
            } else if (parts[0].equals("rm")) {
                if (parts.length < 2) {
                    System.out.println("Ошибка: укажите имя файла.");
                } else {
                    deleteFile(parts[1]);
                }
            }
            else if (parts[0].equals("cp")) {
                if (parts.length < 2) {
                    System.out.println("Ошибка: укажите имя файла.");
                } else {
                    copyFile(parts[1],parts[2]);
                    System.out.println(parts[2]);
                }

            }

            else {
                System.out.println("Ошибка:Неверная комманда.");
            }
        }
    }
    private static void listDirectory() {
        command = new ListCommand();
        command.execute();
    }

    private static void changeDirectory(String directory) {
        command = new ChangeDirectoryCommand(directory);
        command.execute();
    }

    private static void createDirectory(String directory) {
        command = new CreateDirectoryCommand(directory);
        command.execute();
    }

    private static void createFile(String file) {
        command = new CreateFileCommand(file);
        command.execute();
    }
    private static void deleteFile(String file) {
        command = new DeleteFileCommand(file);
        command.execute();
    }
    private static void copyFile(String directoryFrom, String directoryTo) {
        command = new CopyFileCommand(directoryFrom,directoryTo);
        command.execute();
    }

}

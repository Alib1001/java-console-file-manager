package org.example;

import java.io.File;
public class ConsoleFileManager {
    public static File currentDirectory;
    static Command command;
    public static void main(String[] args) {
        currentDirectory = new File("/run");  //Начальный каталог
        ParseCommands parseCommands = new ParseCommands();
        parseCommands.parseCommands();
    }
}



package org.example;

import java.io.*;

import static org.example.ConsoleFileManager.currentDirectory;
public class CopyFileCommand extends Exception implements Command{
    String pathFrom;
    String pathTo;
    CopyFileCommand(String pathFrom, String pathTo){
        this.pathFrom = pathFrom;
        this.pathTo = pathTo;

    }

    @Override
    public void execute(){
        File source = new File(pathFrom);
        File destination = new File(pathTo);

        if (!source.exists() || !source.isDirectory()) {
            System.out.println("Копирование возможно только из родительской директории !");
            System.out.println("Папка не найдена");

            return;
        }

        if (!destination.exists()) {
            destination.mkdirs();
        }

        File[] files = source.listFiles();

        for (File file : files) {
            File destinationFile = new File(destination, file.getName());
            try {
                InputStream input = new FileInputStream(file);
                OutputStream output = new FileOutputStream(destinationFile);
                byte[] buffer = new byte[1024];
                int length;
                while ((length = input.read(buffer)) > 0) {
                    output.write(buffer, 0, length);
                }

                input.close();
                output.close();
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }

    }
}

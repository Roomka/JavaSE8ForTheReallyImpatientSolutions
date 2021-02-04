package chapter1;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class C1E2 {

    public static File[] listFilesLambda(String filePath) {
        File file = new File(filePath);

        return file.listFiles(currentFile -> file.isDirectory());
    }

    public static File[] listFilesMethoExpression(String filePath) {
        File file = new File(filePath);

        return file.listFiles(File::isDirectory);
    }


    /** Using the listFiles(FileFilter) and isDirectory methods of the java.io.File class,
     write a method that returns all subdirectories of a given directory. Use a
     lambda expression instead of a FileFilter object. Repeat with a method
     expression.
     * @param args
     */
    public static void main(String[] args) {
        String path = "C:\\";

        Arrays.asList(C1E2.listFilesLambda(path))
                .forEach(System.out::println);

        System.out.println("----------------------Method Expression Version---------------");

        Arrays.asList(C1E2.listFilesMethoExpression(path))
                .forEach(System.out::println);
    }
}

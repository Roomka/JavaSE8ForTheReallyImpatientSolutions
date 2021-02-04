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



    public static void main(String[] args) {
        String path = "C:\\";

        Arrays.asList(C1E2.listFilesLambda(path))
                .forEach(System.out::println);

        System.out.println("----------------------Method Expression Version---------------");

        Arrays.asList(C1E2.listFilesMethoExpression(path))
                .forEach(System.out::println);
    }
}

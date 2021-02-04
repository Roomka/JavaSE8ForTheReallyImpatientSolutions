package chapter1;

import java.io.File;
import java.io.FileFilter;

public class C1E2 {

    public static File[] listFilesLambda() {
        String path = "C:\\";

        File file = new File(path);

        return file.listFiles(currentFile -> file.isDirectory());
    }

    public static File[] listFilesMethoExpression() {
        String path = "C:\\";

        File file = new File(path);

        return file.listFiles(File::isDirectory);
    }



    public static void main(String[] args) {
        for (File f :C1E2.listFilesMethoExpression()) {
            System.out.println(f.getName());
        }
    }
}

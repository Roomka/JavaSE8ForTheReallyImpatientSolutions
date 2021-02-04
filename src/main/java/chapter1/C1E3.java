package chapter1;

import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.util.Arrays;

public class C1E3 {

    public static File[] getFilesOfExtensionLambda(String filePath, String fileExtension) {
        return new File(filePath).listFiles(
                currentFile -> FilenameUtils.getExtension
                        (currentFile.getAbsolutePath()).equalsIgnoreCase(fileExtension));
    }


    public static void main(String[] args) {
        String filePath = "C:\\Temp";
        String extension = "java";

        Arrays.asList(C1E3.getFilesOfExtensionLambda(filePath, extension))
                .forEach(System.out::println);
    }
}

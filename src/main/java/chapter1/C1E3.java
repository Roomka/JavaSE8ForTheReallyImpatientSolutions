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


    /** Using the list(FilenameFilter) method of the java.io.File class, write a method
     that returns all files in a given directory with a given extension. Use a lambda
     expression, not a FilenameFilter. Which variables from the enclosing scope does
     it capture?
     * @param args
     */
    public static void main(String[] args) {
        String filePath = "C:\\Temp";
        String extension = "java";

        Arrays.asList(C1E3.getFilesOfExtensionLambda(filePath, extension))
                .forEach(System.out::println);
    }
}

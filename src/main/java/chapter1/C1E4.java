package chapter1;

import java.io.File;
import java.util.Arrays;

public class C1E4 {

    public static void sortFiles(File[] files) {
        Arrays.sort(files, (file1, file2) -> {
           if (file1.isDirectory() &&  !file2.isDirectory()) {
               return -1;
           } else if (!file1.isDirectory() && file2.isDirectory()) {
               return 1;
           } else {
               return file1.getName().toLowerCase().compareTo(file2.getName().toLowerCase());
           }
        });
    }

    /** Given an array of File objects, sort it so that the directories come before the
     files, and within each group, elements are sorted by path name. Use a lambda
     expression, not a Comparator.
     * @param args
     */
    public static void main(String[] args) {
        File file = new File("C:\\Temp");

        File[] files = file.listFiles();
        C1E4.sortFiles(files);
        Arrays.asList(files).forEach(System.out::println);
    }

}

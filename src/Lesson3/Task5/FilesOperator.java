package Lesson3.Task5;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FilesOperator {
    public File[] printFoldersMember(String path) {
        File dir1 = new File(path);
        return dir1.listFiles();
    }

    public File[] reverse(File[] arr) {
        List<File> list = Arrays.asList(arr);
        Collections.reverse(list);
        return (File[]) list.toArray();
    }
}

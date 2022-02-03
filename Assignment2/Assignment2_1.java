package Assignment2;

import java.io.File;
import java.util.*;

public class Assignment2_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the folder path.");
        String folderPath = sc.next();
        System.out.println("Please enter the extension of the file.");
        String extension = sc.next();
        System.out.println("Please enter the isIncludeSubFolder or not.(true or false)");
        boolean isIncludeSubFolder = Boolean.parseBoolean(sc.next());
        Criteria criteria = new Criteria(folderPath, extension, isIncludeSubFolder);
        count(criteria);
    }

    public static void count(Criteria criteria) {
        int folderCnt = 0;
        int fileCnt = 0;
        File directory = new File(criteria.folderPath);
        for(File file : directory.listFiles()) {
            if(criteria.isIncludeSubFolder){
                System.out.println(file);
                if(file.isDirectory()){
                    File subdir = new File(file.getPath());
                    for(File file1 : subdir.listFiles()){
                        System.out.println(file1);
                        if(file1.isFile() && file1.getName().contains(criteria.extension)){
                            fileCnt++;
                        }
                        if(file1.isDirectory()){
                            folderCnt++;
                        }
                    }
                    folderCnt++;
                }
                if(file.isFile()){
                    fileCnt++;
                }
            }else {
                System.out.println(file);
                if (file.isDirectory()) {
                    folderCnt++;
                }
                if (file.isFile() && file.getName().contains(criteria.extension)) {
                    fileCnt++;
                }
            }
        }
        System.out.println("There are " + fileCnt + " files with extension " + criteria.extension + " and " + folderCnt + " folders inside folder " + criteria.folderPath);
    }

}

class Criteria {
    String folderPath;
    String extension;
    boolean isIncludeSubFolder;

    Criteria(String folderPath, String extension, boolean isIncludeSubFolder) {
        this.extension = extension;
        this.folderPath = folderPath;
        this.isIncludeSubFolder = isIncludeSubFolder;
    }

}

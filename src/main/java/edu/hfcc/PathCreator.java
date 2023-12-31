package edu.hfcc;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathCreator {

    public Path createPathToFile(String fileName, String directory) {

        Path overAllPath = Paths.get(fileName).toAbsolutePath();
        Path parentPath = overAllPath.getParent();
        String projectPath = parentPath.toString();
        String filePath = "/src/main/resources/"+directory+"/";

        return Paths.get(projectPath + filePath + fileName);
    }

    public Path createPathToFile(String fileName) {

        return createPathToFile(fileName, "");
    }
}

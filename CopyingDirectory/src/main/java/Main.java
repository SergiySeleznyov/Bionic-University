import com.copy.InputWork;
import com.copy.MyFileCopyVisitor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by c263 on 08.07.2015.
 */
public class Main {
    public static void main(String[] args){
        System.out.println("Copying directory...");
        System.out.println("Input path:");
        Path pathSource=InputWork.read();
        System.out.println(pathSource);
        System.out.println("Input destination path:");
        Path pathDestination=InputWork.read();
        try {
            Files.walkFileTree(pathSource, new MyFileCopyVisitor(pathSource, pathDestination));
            System.out.println("Files copied successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

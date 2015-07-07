import java.io.*;
import java.util.Scanner;

/**
 * Created by c263 on 07.07.2015.
 */
public class ClassIO {



    public static String read(String fileName)  {
        String s=null;
        File file=new File(fileName);
        try {
            Scanner scanner=new Scanner(file);
            while (scanner.hasNext()){
                s= scanner.next();
            }
        }
        catch (FileNotFoundException e){
           e.printStackTrace();
        }

        return s;

    }
}

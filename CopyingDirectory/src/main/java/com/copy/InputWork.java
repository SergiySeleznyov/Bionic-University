package com.copy;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Created by c263 on 08.07.2015.
 */
public class InputWork {

    public static Path read(){
        Scanner in=new Scanner(System.in);
        return Paths.get(in.next());
    }
}

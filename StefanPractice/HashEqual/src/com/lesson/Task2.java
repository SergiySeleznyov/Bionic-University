package com.lesson;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by c263 on 10.07.2015.
 */
public class Task2 {
    public static void main(String[] args){
        Set<String> setArgs = new TreeSet<>(Arrays.asList(args));

        System.out.println(setArgs);
    }
}

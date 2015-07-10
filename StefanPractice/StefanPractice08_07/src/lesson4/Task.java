package lesson4;

import java.util.*;

/**
 * Created by c263 on 08.07.2015.
 */
public class Task {
    public static void main(String[] args){
        List<String> sList=new ArrayList<>(Arrays.asList(9,3,5,4,2));
        Collections.sort(sList);
        System.out.println(sList);
    }

}

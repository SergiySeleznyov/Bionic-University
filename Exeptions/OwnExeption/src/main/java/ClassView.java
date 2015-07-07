/**
 * Created by c263 on 07.07.2015.
 */
public class ClassView {
    public static String view(){
        String s;
        try{
            ClassDao.check(ClassIO.read("test.txt"));
            s="Все ОК";
        }
        catch (MyException my){
           s="Должны быть только буквы!!!";
        }
        return s;
    }

    public static void watch(){
        System.out.println("Наш файл");
        System.out.println(ClassIO.read("test.txt"));
        System.out.println();
    }
}

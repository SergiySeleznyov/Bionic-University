/**
 * Created by c263 on 07.07.2015.
 */
public class ClassView {
    public static String view(){
        String s;
        try{
            ClassDao.check(ClassIO.read("test.txt"));
            s="��� ��";
        }
        catch (MyException my){
           s="������ ���� ������ �����!!!";
        }
        return s;
    }

    public static void watch(){
        System.out.println("��� ����");
        System.out.println(ClassIO.read("test.txt"));
        System.out.println();
    }
}

/**
 * Created by c263 on 07.07.2015.
 */
public class ClassDao {
    public static void check(String str) throws MyException{
        if(!str.matches("^\\D*$")){
//��������t
            throw new MyException("������� ����");
        }else{
//�� ��������
        }
    }
}

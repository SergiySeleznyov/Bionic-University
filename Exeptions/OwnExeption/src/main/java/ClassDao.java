/**
 * Created by c263 on 07.07.2015.
 */
public class ClassDao {
    public static void check(String str) throws MyException{
        if(!str.matches("^\\D*$")){
//содержитt
            throw new MyException("наличие цифр");
        }else{
//не содержит
        }
    }
}

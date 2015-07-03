package lesson2;

import java.util.Date;

/**
 * Created by c263 on 03.07.2015.
 */
public class OOPex {
    public static void main(String[] args) {
        User user=new User(1980,"Petia");
    }
}

    class User{
        private final int yearofBirth;
        private final char[] name;
        public int getAge() {
            return new Date().getYear()-yearofBirth;
        }

        public String getName() {
            return new String(name);
        }


        public User( int yearofBirth, String name) {
            this.yearofBirth=yearofBirth;
            this.name=name.toCharArray();
        }
    }



    final class Singletone{
        public static  final Singletone INSTANCE= new Singletone();
        private Singletone(){

        }
    }


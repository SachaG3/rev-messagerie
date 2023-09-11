package messagerie.run;

import messagerie.models.User;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProgTest {
    public static void main (String[] args){
        try{
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            User user = new User("Marie","Auguste",dateFormat.parse("03/11/2003"));
            System.out.println(user);
            System.out.println(user);

        } catch(Exception e){
            System.out.println("Age incorrect");
        }


    }
}

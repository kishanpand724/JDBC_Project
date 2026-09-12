
import java.sql.Connection;
import java.sql.DriverManager;


public class DB {

      public static void main(String[] args) {
        Connection con;

        try{
            con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/Demo",
                "postgres",
                "kp724"
            );
            System.out.println("Database Connected!");
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}

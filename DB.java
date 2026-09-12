
import java.sql.Connection;
import java.sql.DriverManager;


class DB {

      public static Connection getConnection(){
        Connection con = null;

        try{
            con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/Demo",
                "postgres",
                "kp724"
            );
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return con;
    }
}
class main{
    public static void main(String[] args) {
        Connection Conn = DB.getConnection();
        if(Conn != null){
            System.out.println("Connected");
        }
    }
}

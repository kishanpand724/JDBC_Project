
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


class DB {

      public static Connection getConnection(){
        Connection con = null;

        try{
            con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/Demo",
                "postgres",
                "kp724"
            );
            PreparedStatement ps = con.prepareStatement("insert into demo values(3,'Mahi',90);");
            ps.executeUpdate();
            ps.close();
            
        }catch(Exception e){
            e.printStackTrace();
        }
            return con;
            
    }
            
}
class main{
    public static void main(String[] args) {
        try{
        Connection Conn = DB.getConnection();
        if(Conn != null){
            System.out.println("Inserted");
            Conn.close();
        }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

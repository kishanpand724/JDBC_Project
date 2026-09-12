
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

class DB{
    public static Connection getConnection(){
        String url = "jdbc:postgresql://localhost:5432/Demo";
        String username = "postgres";
        String pwd = "kp724";
        Connection con = null;
        try{
            con = DriverManager.getConnection(url,username,pwd);
            PreparedStatement ps = con.prepareStatement("insert into demo values(?,?,?)");
            ps.setInt(1, 5);
            ps.setString(2, "Rohit");
            ps.setInt(3, 77);
            ps.executeUpdate();
            ps.setInt(1, 7);
            ps.setString(2, "Navin");
            ps.setInt(3, 46);
            ps.executeUpdate();
            ps.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return con;
    }
}
class Main{
    public static void main(String[] args) {
        Connection con = DB.getConnection();
        if(con != null){
            System.out.println("Connected");
        }
        try{
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
}

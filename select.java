
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

class DB{
    public static Connection getConnection(){
        String url = "jdbc:postgresql://localhost:5432/Demo";
        String username = "postgres";
        String pwd = "kp724";
        Connection con = null;
        try{
            con = DriverManager.getConnection(url,username,pwd);
//            PreparedStatement ps = con.prepareStatement("insert into demo values(?,?,?)");
//            ps.setInt(1, 5);
//            ps.setString(2, "Rohit");
//            ps.setInt(3, 77);
//            ps.executeUpdate();
//            ps.setInt(1, 7);
//            ps.setString(2, "Navin");
//            ps.setInt(3, 46);
//            ps.executeUpdate();
//            ps.close();
              

              PreparedStatement ps = con.prepareStatement("select * from demo where id = ?");
              
              for(int i=1; i<3; i++)
              {
              ps.setInt(1, i);
              ResultSet rs = ps.executeQuery();
              
              while(rs.next()){
                    System.out.println(rs.getInt(1));
                    System.out.println(rs.getString(2));
                    System.out.println(rs.getInt(3));
              }
              }
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

package CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

class crud {
    static Scanner sc = new Scanner(System.in);
    
//    Connection con = null;
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
    public static void insertUser(Connection cd){
        PreparedStatement ps;
        try{
            ps = cd.prepareStatement("select id from demo where id = ?;");
            System.out.println("Enter id");
            int cid = sc.nextInt();
            ps.setInt(1, cid);
            ResultSet rs = ps.executeQuery();
            
            
            if(rs.next()){
                System.out.println("User Id exists...");
                rs.close();
                ps.close();
            }
            else{      
                rs.close();
                ps.close();
                ps = cd.prepareStatement("insert into demo values(?,?,?)");
//                System.out.println("Enter Id: ");
//                int id = sc.nextInt();
                System.out.println("Enter name: ");
                String name = sc.next();
                System.out.println("Enter marks: ");
                int marks = sc.nextInt();
                ps.setInt(1, cid);
                ps.setString(2, name);
                ps.setInt(3, marks);              
                int status = ps.executeUpdate();
                if(status > 0)
                    System.out.println("Inserted");
                else
                    System.out.println("Not executed");
                ps.close();     
            }  
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void readUser(int id,Connection cd){
        PreparedStatement ps;
        try{
            ps = cd.prepareStatement("select * from demo where id = ?;");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                
                System.out.println(rs.getInt(1));
                System.out.println(rs.getString(2));
                System.out.println(rs.getInt(3));

                
            }
            else{
                System.out.println("Id not exits");
            }
            rs.close();
            ps.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
 
    
    public static void updateUser(Connection cd){
        PreparedStatement ps;
        try{
            ps = cd.prepareStatement("update demo set marks = ? where id = ?;");
            System.out.println("Enter Id: ");
            int id = sc.nextInt();
            System.out.println("Enter marks: ");
            int marks = sc.nextInt();
            ps.setInt(1, marks);
            ps.setInt(2, id);
            int status = ps.executeUpdate();
            if(status > 0)
                System.out.println("updtaed");
            else
                System.out.println("id not found");
            ps.close();       
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    public static void deleteUser(Connection cd){
        PreparedStatement ps;
        try{
            ps = cd.prepareStatement("delete from demo where id = ?;");
            System.out.println("Enter Id: ");
            int id = sc.nextInt();
            ps.setInt(1, id);
            int status = ps.executeUpdate();
            if(status > 0)
                System.out.println("Deleted");
            else
                System.out.println("id not found");
            ps.close();       
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
class main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Connection cd = crud.getConnection();
        int op;
        
        do{
            System.out.println("Enter number for Operation");
            System.out.println("1. insert");
            System.out.println("2. read");
            System.out.println("3. update");
            System.out.println("4. delete");
            System.out.println("5. exit");

            op = sc.nextInt();


            switch(op){
                case 1:
                    crud.insertUser(cd);
                    break;
                case 2:
                    System.out.println("Enter Id: ");
                    int x = sc.nextInt();
                    crud.readUser(x,cd);
                    break;
                case 3:
                    crud.updateUser(cd);
                    break;
                case 4:
                    crud.deleteUser(cd);
                    break;
                case 5:
                    System.out.println("Exiting....");
                    break;
                default:
                    System.out.println("Enter valid number between 1 - 5");

            } 
        }while(op != 5);
            
        
        
       
        
        try{
            cd.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
}

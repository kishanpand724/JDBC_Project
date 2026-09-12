package CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

class crud {
    static Scanner sc = new Scanner(System.in);
    static PreparedStatement ps;
    static Connection con = null;
    public static Connection getConnection(){
        
        
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
    public static void insertUser(){
        try{
            ps = con.prepareStatement("insert into demo values(?,?,?)");
            System.out.println("Enter Id: ");
            int id = sc.nextInt();
            System.out.println("Enter name: ");
            String name = sc.next();
            System.out.println("Enter marks: ");
            int marks = sc.nextInt();
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setInt(3, marks);
            ps.executeUpdate();
            ps.close();       
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void readUser(int id){
        try{
            ps = con.prepareStatement("select * from demo where id = ?;");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                System.out.println(rs.getInt(1));
                System.out.println(rs.getString(2));
                System.out.println(rs.getInt(3));
                
            }
            rs.close();
            ps.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
 
    
    public static void updateUser(){
        try{
            ps = con.prepareStatement("update demo set marks = ? where id = ?;");
            System.out.println("Enter Id: ");
            int id = sc.nextInt();
            System.out.println("Enter marks: ");
            int marks = sc.nextInt();
            ps.setInt(1, marks);
            ps.setInt(2, id);
            ps.executeUpdate();
            ps.close();       
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    public static void deleteUser(){
        try{
            ps = con.prepareStatement("delete from demo where id = ?;");
            System.out.println("Enter Id: ");
            int id = sc.nextInt();
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();       
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
class main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Connection con = crud.getConnection();
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
                    crud.insertUser();
                    break;
                case 2:
                    System.out.println("Enter Id: ");
                    int x = sc.nextInt();
                    crud.readUser(x);
                    break;
                case 3:
                    crud.updateUser();
                    break;
                case 4:
                    crud.deleteUser();
                    break;
                case 5:
                    System.out.println("Exiting....");
                    break;
                default:
                    System.out.println("Enter valid number between 1 - 5");

            } 
        }while(op != 5);
            
        
        
       
        
        try{
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
}

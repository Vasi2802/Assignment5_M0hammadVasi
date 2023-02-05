import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Scanner;

public class TestInsert{
    public static void main(String[] args) {
        String urlMYSQL="jdbc:mysql://localhost:3306/mydata";
        String username="root";
        String password="1234";
        Scanner scn=new Scanner(System.in);
        int ans;
        int count=0;

        //Connection con=DriverManager.getConnection(urlMYSQL,username,password);
        
       try{
        Connection conSQL=DriverManager.getConnection(urlMYSQL,username,password);
        System.out.println("Connection Successful");
        do
        {
            
            String name;
            int age;
            String address;
            int course_id;
            System.out.println("Enter Name of student : ");
            name=scn.next();
            System.out.println("Enter Age of student : ");
            age=scn.nextInt();
            System.out.println("Enter Address of student : ");
            address=scn.next();
            System.out.println("Enter COurse_id of student : ");
            course_id=scn.nextInt();

            String query="insert into student (name,age,address,course_id) values('"+name+"',"+age+",'"+address+"','"+course_id+"')";
        
            Statement stmt=conSQL.createStatement();
            int x=stmt.executeUpdate(query);
            count++;
            System.out.println(count+" insertion Successful");
            System.out.println("Do you want ot continue (1/0) : ");
            ans=scn.nextInt();
        }while(ans==1 && count<=5);
    
    }catch(SQLException e){
        System.out.println(e.getMessage());
       }
    }
    
}


import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
public class TestUpdate {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the name of  column you want to update among :name/age/address/course_id");
        String col=  scn.next();
        System.out.println("Enter the value you want to provide in that column : ");
        String value=scn.next();
        System.out.println("PLease enter the student id");
        int s_id=   scn.nextInt();
        String url = "jdbc:mysql://localhost:3306/mydata";
        String usern= "root";
        String pas = "1234";
        try{
          Connection con = DriverManager.getConnection(url,usern,pas);
          System.out.println("Connection Successfull");
          String qr= "update  student set  "+col+" = '"+value+"' where id = '"+s_id+"' ";
          Statement st = con.createStatement();
          int count =st.executeUpdate(qr);
          System.out.println(count + " record Updated");
          
        }catch(SQLException e){
      System.out.println(e.getMessage());
  }   
}
    
}

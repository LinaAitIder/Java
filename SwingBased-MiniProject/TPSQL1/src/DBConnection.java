import java.sql.*;
import javax.swing.table.DefaultTableModel;
public class DBConnection {
static Connection cn;
static Statement st;
static ResultSet rs;
static DefaultTableModel DT=new DefaultTableModel();
public static String f="";
static void connexion()
{
     try 
     {
             Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
             cn=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ESTL ;user= eleve ;password=123");
               st = cn.createStatement();    
                                     
     }catch (SQLException | ClassNotFoundException ex) 
     {
         System.out.print(ex.getMessage());
      }
}
    
}

package projeto;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory{
   static{
      try{
         Class.forName("com.mysql.cj.jdbc.Driver");
      } catch (ClassNotFoundException e){
         throw new RuntimeException(e);
      }
   }
   
   public static Connection getConnection(){
      try{
         return DriverManager.getConnection(
            "jdbc:mysql://localhost/projeto?user=root&password=Alunos&useTimezone=true&serverTimezone=UTC");
      } catch (SQLException e){
         e.printStackTrace();
      }
      return null;
  }

}
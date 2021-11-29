// 6) Once the queries are mastered, do all the things via Java using JDBC

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class GroupBy 
{
   public static void main( String args[] ) 
   {
      Connection c = null;
      Statement stmt = null;
      try {
         Class.forName("org.postgresql.Driver");
         c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/college","postgres", "root");
         c.setAutoCommit(false);

         stmt = c.createStatement();
         ResultSet rs = stmt.executeQuery("select branch.bname,count(*) from student,branch where student.branch_id = branch.bid group by branch.bname;");
         while (rs.next()) {
            String  bname = rs.getString("bname");
            int count  = rs.getInt("count");
            System.out.println( "BRANCH NAME = " + bname );
            System.out.println( "COUNT = " + count );
            System.out.println();
         }
         rs.close();
         stmt.close();
         c.close();
      } 
      catch (Exception e) {
         System.err.println(e.getClass().getName()+": "+ e.getMessage());
         
      }
   }
}
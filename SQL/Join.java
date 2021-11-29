// 6) Once the queries are mastered, do all the things via Java using JDBC

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Join 
{
   public static void main( String args[] ) 
   {
      Connection c = null;
      Statement stmt = null;
      try {
         Class.forName("org.postgresql.Driver");
         c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/college","postgres", "root");
         c.setAutoCommit(false);
         System.out.println("Connected to database successfully");

         stmt = c.createStatement();
         
         /*ResultSet rs = stmt.executeQuery("select student.id,student.name,branch.bid,branch.bname from student LEFT JOIN branch on student.branch_id=branch.bid");
         ResultSet rs = stmt.executeQuery("select student.id,student.name,branch.bid,branch.bname from student RIGHT JOIN branch on student.branch_id=branch.bid");
         ResultSet rs = stmt.executeQuery("select student.id,student.name,branch.bid,branch.bname from student FULL JOIN branch on student.branch_id=branch.bid");*/
         
         ResultSet rs = stmt.executeQuery("select student.id,student.name,branch.bid,branch.bname from student INNER JOIN branch on student.branch_id=branch.bid");
         while ( rs.next() ) {
            int id = rs.getInt("id");
            String  name = rs.getString("name");
            int bid = rs.getInt("bid");
            String  bname = rs.getString("bname");
            System.out.println( "ID = " + id );
            System.out.println( "NAME = " + name );
            System.out.println( "BRANCH ID = " + bid );
            System.out.println( "BRANCH NAME = " + bname );
            System.out.println();
         }
         rs.close();
         stmt.close();
         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
         System.exit(0);
      }
   }
}
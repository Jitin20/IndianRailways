/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testconn;
import java.sql.*;

/**
 *
 * @author sumitkgp
 */



//STEP 1. Import required packages


public class Testconn {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost:8080/database_schema";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "imtoocool007";
   
   public static void main(String[] args) {
   Connection conn = null;
   Statement stmt = null;
   try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      System.out.println("Creating statement...");
      stmt = conn.createStatement();
      String sql;
      sql = "INSERT INTO users values ('103','7815696ecbf1c96e6894b779456d330e','123','lol@chutiya.com','chutiyapur','lol');";
      int rs = stmt.executeUpdate(sql);

      //STEP 5: Extract data from result set
   /*  while(rs.next()){
         //Retrieve by column name
        
         String first = rs.getString("userid");
         String last = rs.getString("Passwd");

         //Display values
         System.out.print(", First: " + first);
         System.out.println(", Last: " + last);
      }*/
      //STEP 6: Clean-up environment
      //rs.close();
      stmt.close();
      conn.close();
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   
}//end main
}//end FirstExample
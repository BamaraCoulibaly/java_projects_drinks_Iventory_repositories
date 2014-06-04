
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bamaragcoulibaly
 */
public class createDB_runtime {
    int test=0;
    // check if tables does not exist 
     public static void main(String[] args) {
     Connection con = null;
        Statement st_CreateTable = null;
        Statement stmt_TableExistence = null;
        ResultSet rs = null;
        ResultSet rs1 = null;
        
        Statement st_DisplayTable = null;

        String url = "jdbc:derby:inventoryDB1;;user=APP";

        try {
           // System.gc();
            System.setProperty("derby.system.home", 
                    "/Users/bamaragcoulibaly/.netbeans-derby");
            con = DriverManager.getConnection(url);
            st_CreateTable = con.createStatement();
            String tableName = "XKCARS";
            String query = "select count(*) from  " + tableName;
           
            try {
      stmt_TableExistence = con.createStatement();
      rs = stmt_TableExistence.executeQuery(query);
      //System.out.println("Exist");;
      //table exist then do nothing or query table for testing 
      
    }
    catch (Exception e ) {
      // table does not exist so create one  
      //System.out.println("Not Exist");
        st_CreateTable.executeUpdate("CREATE TABLE XKCARS(ID INT PRIMARY KEY,"
                    + "NAME VARCHAR(30), PRICE INT)");
           st_CreateTable.executeUpdate("INSERT INTO XKCARS VALUES(1, 'Audi', 52642)");
            st_CreateTable.executeUpdate("INSERT INTO XKCARS VALUES(2, 'Mercedes', 57127)");
           st_CreateTable.executeUpdate("INSERT INTO XKCARS VALUES(3, 'Skoda', 9000)");
            st_CreateTable.executeUpdate("INSERT INTO XKCARS VALUES(4, 'Volvo', 29000)");
            st_CreateTable.executeUpdate("INSERT INTO XKCARS VALUES(5, 'Bentley', 350000)");
            st_CreateTable.executeUpdate("INSERT INTO XKCARS VALUES(6, 'Citroen', 21000)");
            st_CreateTable.executeUpdate("INSERT INTO XKCARS VALUES(7, 'Hummer', 41400)");
            st_CreateTable.executeUpdate("INSERT INTO XKCARS VALUES(8, 'Volkswagen', 21600)");
             rs1=st_DisplayTable.executeQuery("SELECT count(*) FROM APP.XKCARS");
             System.out.print(true);
    //        st.executeQuery("SELECT * FROM APP.XCARS");
            DriverManager.getConnection("jdbc:derby:;shutdown=true");     
        
    }
            
            
    
 } catch (SQLException ex) {
            
            Logger lgr = Logger.getLogger(createDB_runtime.class.getName());

            if (((ex.getErrorCode() == 50000)
                    && ("XJ015".equals(ex.getSQLState())))) {

                lgr.log(Level.INFO, "Derby shut down normally", ex);

            } else {

                lgr.log(Level.SEVERE, ex.getMessage(), ex);
            }

        } finally {

            try {

                if (st_DisplayTable != null) {
                    st_DisplayTable.close();
                }
                if (st_CreateTable != null) {
                    st_CreateTable.close();
                }
                if (stmt_TableExistence != null) {
                    stmt_TableExistence.close();
                }
                
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(createDB_runtime.class.getName());
                lgr.log(Level.WARNING, ex.getMessage(), ex);
            }
        }
    }
   
    }
    

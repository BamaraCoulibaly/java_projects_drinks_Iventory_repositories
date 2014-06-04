/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testapplication;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bamaragcoulibaly
 */
public class TestApplication {

 
    public static void main(String[] args) {
     Connection con = null;
        Statement st = null;

        String url = "jdbc:derby:inventoryDB1;;user=APP";

        try {
           // System.gc();
            System.setProperty("derby.system.home", 
                    "/Users/bamaragcoulibaly/.netbeans-derby");
            con = DriverManager.getConnection(url);
            st = con.createStatement();
            st.executeUpdate("CREATE TABLE XCARS(ID INT PRIMARY KEY,"
                    + "NAME VARCHAR(30), PRICE INT)");
            st.executeUpdate("INSERT INTO XCARS VALUES(1, 'Audi', 52642)");
            st.executeUpdate("INSERT INTO XCARS VALUES(2, 'Mercedes', 57127)");
            st.executeUpdate("INSERT INTO XCARS VALUES(3, 'Skoda', 9000)");
            st.executeUpdate("INSERT INTO XCARS VALUES(4, 'Volvo', 29000)");
            st.executeUpdate("INSERT INTO XCARS VALUES(5, 'Bentley', 350000)");
            st.executeUpdate("INSERT INTO XCARS VALUES(6, 'Citroen', 21000)");
            st.executeUpdate("INSERT INTO XCARS VALUES(7, 'Hummer', 41400)");
            st.executeUpdate("INSERT INTO XCARS VALUES(8, 'Volkswagen', 21600)");
            st.executeQuery("SELECT * FROM APP.XCARS");
            DriverManager.getConnection("jdbc:derby:;shutdown=true");

        } catch (SQLException ex) {
            
            Logger lgr = Logger.getLogger(TestApplication.class.getName());

            if (((ex.getErrorCode() == 50000)
                    && ("XJ015".equals(ex.getSQLState())))) {

                lgr.log(Level.INFO, "Derby shut down normally", ex);

            } else {

                lgr.log(Level.SEVERE, ex.getMessage(), ex);
            }

        } finally {

            try {

                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(TestApplication.class.getName());
                lgr.log(Level.WARNING, ex.getMessage(), ex);
            }
        }
    }
   
    }
    



 // System.setProperty("derby.system.home", "/Users/bamaragcoulibaly/.netbeans-derby");
   // String driver = "org.apache.derby.jdbc.EmbeddedDriver";
  //  String connectionURL = "jdbc:derby:APP;create=true";
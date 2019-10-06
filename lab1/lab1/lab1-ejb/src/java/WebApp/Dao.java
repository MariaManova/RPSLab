package WebApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import javax.annotation.Resource;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@Stateless
public class Dao implements java.io.Serializable {
   
    //@Resource(name = "java:module/baza")
    private static DataSource mybase;

    public Dao() {
    }
    
    public static Connection openConnection() throws SQLException {
        Connection con = null;
        try {
            InitialContext ctx = new InitialContext();
            mybase = (DataSource) ctx.lookup("jdbc/Baza");
            con = mybase.getConnection();
        } catch (SQLException ex) {
            throw new RuntimeException("Can't open connection", ex);
        } catch (NamingException ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
}

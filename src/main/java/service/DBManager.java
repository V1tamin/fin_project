package service;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Anton Lopatin on 28.05.2021
 */
public class DBManager {
    private static final Logger logger = LogManager.getLogger();

    private static DataSource dataSource;

    private DBManager() {
    }

    ///

    public static Connection getConnection() throws SQLException {
        if (dataSource == null) {
            try {
                System.out.println("DBManager.getConnection");
                Context initContext = new InitialContext();
                Context envContext = (Context) initContext.lookup("java:comp/env");
                dataSource = (DataSource) envContext.lookup("jdbc/Hotel");
            } catch (NamingException ex) {
                logger.log(Level.ERROR, ex);
                throw new RuntimeException(ex.getMessage());
            }
        }
        return dataSource.getConnection();
    }

    public static void close(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                logger.log(Level.ERROR, "Close_Connection: ", ex);
                throw new RuntimeException(ex.getMessage());
            }
        }
    }

    public static void rollback(Connection con) {
        if (con != null) {
            try {
                con.rollback();
            } catch (SQLException e) {
                logger.log(Level.ERROR, e.getMessage());
                throw new RuntimeException(e.getMessage());
            }
        }
    }
}

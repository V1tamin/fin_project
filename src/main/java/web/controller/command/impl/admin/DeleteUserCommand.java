package web.controller.command.impl.admin;

import dao.IAccountDAO;
import dao.impl.AccountDAO;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.DBManager;
import web.controller.command.Command;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import static constant.Constants.*;
import static constant.SQLConstants.DELETE_ACCOUNT_BY_ID;

/**
 * @author Anton Lopatin on 14.06.2021
 */
public class DeleteUserCommand implements Command {
    private static final Logger logger = LogManager.getLogger();
    private IAccountDAO accountDAO = new AccountDAO();

    @Override
    public Map<String, Object> execute(HttpServletRequest request, HttpServletResponse response) throws SQLException, NamingException {
        Map<String, Object> map = new HashMap<>();

        String id = (String) request.getParameter(ID);
        boolean t = deleteById(id);

        System.out.println("T: " + t);

        System.out.println("ID delete user: " + id);

        map.put(PAGE, ADMIN_PARLOR_JSP);
        map.put(PAGE, SHOW_ALL_CLIENTS_JSP);
        return map;
    }

    public boolean deleteById(String id) {
        Connection con = null;
        try {
            con = DBManager.getConnection();
            con.setAutoCommit(false);
            PreparedStatement preparedStatement = con.prepareStatement(DELETE_ACCOUNT_BY_ID);
            preparedStatement.setString(1, id);
            preparedStatement.execute();
            con.commit();
            return true;
        } catch (SQLException ex) {
            logger.log(Level.ERROR, ex);
        } finally {
            DBManager.close(con);
        }
        return false;
    }
}
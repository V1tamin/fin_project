package web.controller.command.impl.admin;

import dao.IAccountDAO;
import dao.ITableDAO;
import dao.impl.AccountDAO;
import dao.impl.TableDAOImpl;
import model.Account;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.DBManager;
import web.controller.command.Command;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static constant.Constants.*;
import static constant.Constants.LASTNAME;
import static constant.SQLConstants.SELECT_ALL_CLIENTS;

/**
 * @author Anton Lopatin on 20.06.2021
 */

public class ShowAllClientsCommand implements Command {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public Map<String, Object> execute(HttpServletRequest request, HttpServletResponse response) throws SQLException, NamingException {
        Map<String, Object> map = new HashMap<>();
        List<Account> clients = getClient();
        request.getSession().setAttribute("clients", clients);
        map.put(PAGE, SHOW_ALL_CLIENTS_JSP);
        map.put(CLIENTS, clients);
        return map;
    }

    public List<Account> getClient() throws SQLException {
        Connection con = null;
        List<Account> accounts = new ArrayList<>();
        try {
            con = DBManager.getConnection();
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_CLIENTS);
            while (resultSet.next()) {
                Account client = new Account();
                client.setId(resultSet.getString(ID));
                client.setFirstname(resultSet.getString(FIRSTNAME));
                client.setLastname(resultSet.getString(LASTNAME));
                client.setPatronymic(resultSet.getString(PATRONYMIC));
                client.setLogin(resultSet.getString(LOGIN));
                client.setPassword(resultSet.getString(PASSWORD));
                accounts.add(client);
            }
        } catch (SQLException ex) {
            logger.log(Level.ERROR, ex);
            throw ex;
        } finally {
            DBManager.close(con);
        }
        return accounts;
    }
}

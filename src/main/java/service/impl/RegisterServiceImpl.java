package service.impl;

import dao.IAccountDAO;
import dao.impl.AccountDAO;
import model.Account;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.DBManager;
import service.inter.RegisterService;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;

import static constant.SQLConstants.INSERT_NEW_USER;

/**
 * @author Anton Lopatin on 20.06.2021
 */
public class RegisterServiceImpl implements RegisterService {
    private static final Logger logger = LogManager.getLogger();

    private final IAccountDAO accountDAO = new AccountDAO();

    @Override
    public boolean register(Account client) throws SQLException {
        Connection con = null;
        try {
            con = DBManager.getConnection();
            con.setAutoCommit(false);

            if (client != null) {
                Optional<Account> account = accountDAO.findByName(client.getLogin());
                if (!account.isPresent()) {
                    PreparedStatement preparedStatement = con.prepareStatement(INSERT_NEW_USER);
                    preparedStatement.setString(1, null);
                    preparedStatement.setString(2, client.getLogin());
                    preparedStatement.setString(3, client.getPassword());
                    preparedStatement.setString(4, client.getFirstname());
                    preparedStatement.setString(5, client.getLastname());
                    preparedStatement.setString(6, client.getPatronymic());
                    preparedStatement.execute();
                    con.commit();
                }
            }
            return true;
        } catch (SQLException ex) {
            logger.log(Level.ERROR, ex);
            throw ex;
        } finally {
            DBManager.close(con);
        }
    }
}

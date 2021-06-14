package dao.impl.admin;

import dao.IAccountDAO;
import model.Account;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import static constant.Constants.*;
import static constant.SQLConstants.SELECT_ADMIN_BY_LOGIN;


/**
 * @author Anton Lopatin on 28.05.2021
 */
public class AdminAccountDAO implements IAccountDAO {
    private static final Logger logger = LogManager.getLogger();

    public Optional<Account> findByName(String login) {
        Connection con = null;
        Account acc = null;
        try {
            con = DBManager.getConnection();
            PreparedStatement st = con.prepareStatement(SELECT_ADMIN_BY_LOGIN);
            System.out.println("login: " + login);
            st.setString(1, login);
            acc = initAccount(st);
        } catch (SQLException e) {
            logger.log(Level.ERROR, e);
        } finally {
            DBManager.close(con);
        }
        return Optional.ofNullable(acc);
    }

    public Optional<Account> findById(String id) {
        return Optional.empty();
    }

    @Override
    public boolean deleteByName(String name) {
        return false;
    }

    @Override
    public boolean deleteById(String id) {
        return false;
    }

    private Account initAccount(PreparedStatement st) throws SQLException {
        ResultSet set = st.executeQuery();
        if (set.next()) {
            Account acc = new Account();
            acc.setId(set.getString(ID));
            acc.setLogin(set.getString(LOGIN));
            acc.setPassword(set.getString(PASSWORD));
            return acc;
        }
        return null;
    }
}

package dao.impl;

import dao.IAccountDAO;
import model.Account;
import model.Role;
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
import static constant.SQLConstants.SELECT_ACCOUNT_BY_ID;
import static constant.SQLConstants.SELECT_ACCOUNT_BY_LOGIN;


/**
 * @author Anton Lopatin on 28.05.2021
 */
public class AccountDAO implements IAccountDAO {
    private static final Logger logger = LogManager.getLogger();

    public Optional<Account> findByName(String name) {
        Connection con = null;
        Account acc = null;
        try {
            con = DBManager.getConnection();
            PreparedStatement st = con.prepareStatement(SELECT_ACCOUNT_BY_LOGIN);
            st.setString(1, name);
            acc = initAccount(st);
        } catch (SQLException e) {
            logger.log(Level.ERROR, e);
        } finally {
            DBManager.close(con);
        }
        return Optional.ofNullable(acc);
    }

    public Optional<Account> findById(String id) {
        Connection con = null;
        Account acc = null;
        try {
            con = DBManager.getConnection();
            PreparedStatement selectStatement = con.prepareStatement(SELECT_ACCOUNT_BY_ID);
            selectStatement.setString(1, id);
            acc = initAccount(selectStatement);
        } catch (SQLException e) {
            logger.log(Level.ERROR, e.getMessage());
        } finally {
            DBManager.close(con);
        }
        return Optional.ofNullable(acc);
    }

    private Account initAccount(PreparedStatement st) throws SQLException {
        ResultSet set = st.executeQuery();
        if (set.next()) {
            Account acc = new Account();
            acc.setId(set.getString(ID));
            acc.setLogin(set.getString(LOGIN));
            acc.setPassword(set.getString(PASSWORD));
            acc.setFirstname(set.getString(FIRSTNAME));
            acc.setLastname(set.getString(LASTNAME));
            acc.setPatronymic(set.getString(PATRONYMIC));

            return acc;
        }
        return null;
    }
}

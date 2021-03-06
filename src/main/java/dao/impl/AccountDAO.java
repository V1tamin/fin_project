package dao.impl;

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
import static constant.SQLConstants.*;


/**
 * @author Anton Lopatin on 20.06.2021
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

    @Override
    public boolean deleteByName(String name) {
        Connection con = null;
        try {
            con = DBManager.getConnection();
            PreparedStatement selectStatement = con.prepareStatement(DELETE_ACCOUNT_BY_LOGIN);
            selectStatement.setString(1, name);
            selectStatement.execute();
            return true;
        } catch (SQLException e) {
            logger.log(Level.ERROR, e.getMessage());
        } finally {
            DBManager.close(con);
        }
        return false;
    }

    @Override
    public boolean deleteById(String id) {
        Connection con = null;
        try {
            con = DBManager.getConnection();
            PreparedStatement selectStatement = con.prepareStatement(DELETE_ACCOUNT_BY_ID);
            System.out.println("?????????? ??????????: " + id);
            selectStatement.setString(1, id);
            selectStatement.execute();
            return true;
        } catch (SQLException e) {
            logger.log(Level.ERROR, e.getMessage());
        } finally {
            DBManager.close(con);
        }
        return false;
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

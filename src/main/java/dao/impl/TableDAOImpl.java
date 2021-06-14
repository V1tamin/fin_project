package dao.impl;

import model.Account;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.DBManager;
import dao.ITableDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static constant.Constants.*;
import static constant.SQLConstants.SELECT_ALL_CLIENTS;

/**
 * @author Anton Lopatin on 07.06.2021
 */
public class TableDAOImpl implements ITableDAO {
    private static final Logger logger = LogManager.getLogger();

    //Список апартаментов для отображения пользователю
    @Override
    public List<Account> getClientTable() throws SQLException {
        Connection con = null;
        List<Account> catalog = new ArrayList<>();
        try {
            con = DBManager.getConnection();
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_CLIENTS);//поменять запрос
            while (resultSet.next()) {
                Account client = new Account();
                client.setId(resultSet.getString(ID));
                client.setLogin(resultSet.getString(LOGIN));
                client.setPassword(resultSet.getString(PASSWORD));
                client.setFirstname(resultSet.getString(FIRSTNAME));
                client.setFirstname(resultSet.getString(LASTNAME));
                client.setPatronymic(resultSet.getString(PATRONYMIC));
                catalog.add(client);
            }
        } catch (SQLException ex) {
            logger.log(Level.ERROR, ex);
            throw ex;
        } finally {
            DBManager.close(con);
        }
        return catalog;
    }
}

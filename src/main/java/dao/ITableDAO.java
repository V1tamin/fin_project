package dao;

import model.Account;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Anton Lopatin on 19.06.2021
 */
public interface ITableDAO {
    List<Account> getClientTable() throws SQLException, NamingException;
}

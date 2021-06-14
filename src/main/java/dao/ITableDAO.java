package dao;

import model.Account;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Anton Lopatin on 07.06.2021
 */
public interface ITableDAO {
    List<Account> getClientTable() throws SQLException, NamingException;
    //ListWrapper getMasterTable(Account account, String date) throws SQLException, NamingException;
    //List<AdminTableItem> getAdminTable() throws SQLException, NamingException;
}

package service.inter;

import model.Account;

import javax.naming.NamingException;
import java.sql.SQLException;

/**
 * @author Anton Lopatin on 20.06.2021
 */
public interface RegisterService {
   boolean register(Account account)
            throws SQLException, NamingException;
}

package service.inter;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.Map;

/**
 * @author Anton Lopatin on 20.06.2021
 */
public interface LoginService {
    Map<String, Object> login(String login, String password)
            throws SQLException, NamingException;
}

package service.impl;

import dao.IAccountDAO;
import dao.ITableDAO;
import dao.impl.AccountDAO;
import dao.impl.TableDAOImpl;
import model.Account;
import service.inter.LoginService;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static constant.Constants.CATALOG;
import static constant.Constants.USER;

/**
 * @author Anton Lopatin on 05.06.2021
 */
public class LoginServiceImpl implements LoginService {
    private final IAccountDAO accountDao = new AccountDAO();
    private final ITableDAO tableDao = new TableDAOImpl();

    @Override
    public Map<String, Object> login(String login, String password) throws SQLException, NamingException {
        Optional<Account> account = accountDao.findByName(login);
        account = account.filter(account1 -> password.equals(account1.getPassword()));
        Map<String, Object> map = new HashMap<>();
        map.put(USER, account);
        Account user = account.orElse(null);
        System.out.println("LoginServiceImpl.login");
        if (user != null) {
            map.put(CATALOG, tableDao.getClientTable());
        }
        return map;
    }
}

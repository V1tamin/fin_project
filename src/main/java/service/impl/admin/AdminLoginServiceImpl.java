package service.impl.admin;

import dao.IAccountDAO;
import dao.ITableDAO;
import dao.impl.admin.AdminAccountDAO;
import dao.impl.admin.AdminTableDAOImpl;
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
 * @author Anton Lopatin on 08.06.2021
 */
public class AdminLoginServiceImpl implements LoginService {
    private final IAccountDAO accountDao = new AdminAccountDAO();
    private final ITableDAO tableDao = new AdminTableDAOImpl();

    @Override
    public Map<String, Object> login(String login, String password) throws SQLException, NamingException {
        Optional<Account> account = accountDao.findByName(login);
        System.out.println("account: " + account);
        account = account.filter(account1 -> password.equals(account1.getPassword()));
        Map<String, Object> map = new HashMap<>();
        map.put(USER, account);
        Account admin = account.orElse(null);
        System.out.println("AdminLoginServiceImpl.login");
        if (admin != null) {
            //map.put(CATALOG, tableDao.getClientTable());
            System.out.println("Admin auth!");
        }
        return map;
    }
}

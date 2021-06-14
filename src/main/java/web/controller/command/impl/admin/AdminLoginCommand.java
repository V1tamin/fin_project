package web.controller.command.impl.admin;


import model.Account;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.inter.LoginService;
import web.controller.command.Command;
import service.impl.admin.AdminLoginServiceImpl;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static constant.Constants.*;

/**
 * @author Anton Lopatin on 08.06.2021
 */
public class AdminLoginCommand implements Command {
    private static final Logger logger = LogManager.getLogger();

    private final LoginService loginService = new AdminLoginServiceImpl();

    @Override
    public Map<String, Object> execute(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> map = new HashMap<>();

        String username = request.getParameter(ADMIN_LOGIN);
        String password = request.getParameter(ADMIN_PASSWORD);

        System.out.println("admin login: " + username + " password: " + password);

        Map<String, Object> loginMap;
        try {
            loginMap = loginService.login(username, password);
            Optional<Account> account = (Optional<Account>) loginMap.get(USER);
            if (account.isPresent()) {
                initSession(request, map, loginMap, account.get());
                map.put(PAGE, ADMIN_PARLOR_JSP);
            } else {
                map.put(PAGE, ADMIN_AUTH_JSP);
                map.put(ERR_MESSAGE, ERROR_MESSAGE);
            }
        } catch (SQLException | NamingException ex) {
            logger.log(Level.ERROR, ex);
        }
        return map;
    }

    private void initSession(HttpServletRequest request, Map<String, Object> map, Map<String, Object> loginMap, Account account) {
        HttpSession session = request.getSession(true);
        session.setMaxInactiveInterval(-1);
        session.setAttribute(ADMIN, account);
        session.setAttribute("adminLoggedIn", true);
    }
}

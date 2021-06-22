package web.controller.command.impl;

import model.Account;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.impl.LoginServiceImpl;
import service.inter.LoginService;
import web.controller.command.Command;

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
 * @author Anton Lopatin on 20.06.2021
 */
public class LoginCommand implements Command {
    private static final Logger logger = LogManager.getLogger();

    private final LoginService loginService = new LoginServiceImpl();

    @Override
    public Map<String, Object> execute(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> map = new HashMap<>();

        String username = request.getParameter(LOGIN);
        String password = request.getParameter(PASSWORD);

        Map<String, Object> loginMap;
        try {
            loginMap = loginService.login(username, password);
            Optional<Account> account = (Optional<Account>) loginMap.get(USER);
            if (account.isPresent()) {
                initSession(request, account.get());
                map.put(PAGE, INDEX_JSP);
            } else {
                map.put(PAGE, LOGIN_JSP);
                map.put(ERR_MESSAGE, ERROR_MESSAGE);
            }
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
        return map;
    }

    private void initSession(HttpServletRequest request, Account account) {
        HttpSession session = request.getSession(true);
        session.setMaxInactiveInterval(-1);
        session.setAttribute(USER, account);
        session.setAttribute("userLoggedIn", true);
    }
}

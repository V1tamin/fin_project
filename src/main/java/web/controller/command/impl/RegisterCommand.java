package web.controller.command.impl;

import model.Account;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.impl.RegisterServiceImpl;
import service.inter.RegisterService;
import web.controller.command.Command;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import static constant.Constants.*;

/**
 * @author Anton Lopatin on 20.06.2021
 */
public class RegisterCommand implements Command {
    private static final Logger logger = LogManager.getLogger();

    private static final RegisterService registerService = new RegisterServiceImpl();

    @Override
    public Map<String, Object> execute(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> map = new HashMap<>();

        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String patronymic = request.getParameter("patronymic");
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        String confirmPassword = request.getParameter("confirmPassword");

        Account account = new Account();
        account.setFirstname(firstname);
        account.setLastname(lastname);
        account.setPatronymic(patronymic);
        account.setLogin(login);
        account.setPassword(password);

        try {
            if (registerService.register(account)) {
                initSession(request, map, account);
                map.put(PAGE, PERSONAL_ACC_JSP);
                return map;
            } else {
                map.put(PAGE, INDEX_JSP);
            }
        } catch (SQLException | NamingException ex) {
            logger.log(Level.ERROR, "RegisterService: ", ex);
            map.put(PAGE, REGISTER_JSP);
        }
        return map;
    }

    private void initSession(HttpServletRequest request, Map<String, Object> map/*, Map<String, Object> loginMap*/, Account account) {
        HttpSession session = request.getSession(true);
        session.setMaxInactiveInterval(-1);
        session.setAttribute(USER, account);
        session.setAttribute("userLoggedIn", true);
    }
}

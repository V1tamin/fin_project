package web.controller.command.impl.admin;

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
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import static constant.Constants.*;

/**
 * @author Anton Lopatin on 20.06.2021
 */
public class CreateNewUserCommand implements Command {
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

        Account account = new Account();
        account.setFirstname(firstname);
        account.setLastname(lastname);
        account.setPatronymic(patronymic);
        account.setLogin(login);
        account.setPassword(password);

        try {
            if (registerService.register(account)) {
                map.put(PAGE, SHOW_ALL_CLIENTS_JSP);
                return map;
            } else {
                map.put(PAGE, ADMIN_CREATE_NEW_USER_JSP);
            }
        } catch (SQLException | NamingException ex) {
            logger.log(Level.ERROR, "RegisterServiceAdmin: ", ex);
            map.put(PAGE, ADMIN_CREATE_NEW_USER_JSP);
        }
        return map;
    }
}

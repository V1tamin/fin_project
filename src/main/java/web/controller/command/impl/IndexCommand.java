package web.controller.command.impl;

import dao.IAccountDAO;
import dao.impl.AccountDAO;
import model.Account;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import web.controller.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static constant.Constants.*;

/**
 * @author Anton Lopatin on 20.06.2021
 */
public class IndexCommand implements Command {
    private static final Logger logger = LogManager.getLogger();
    private static final IAccountDAO accountDAO = new AccountDAO();

    @Override
    public Map<String, Object> execute(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> map = new HashMap<>();
        Account ac = (Account) request.getSession().getAttribute(USER);
        if (ac != null) {
            System.out.println("Session: " + request.getSession().getAttribute(USER));
            Optional<Account> authClient = accountDAO.findById(ac.getId());
            if (authClient.isPresent()) {
                System.out.println("auth user: " + authClient.get());
                request.getSession().setAttribute(USER, authClient);
            } else {
                request.getSession().setAttribute("guest", null);
            }
        }
        map.put(PAGE, INDEX_JSP);
        return map;
    }
}

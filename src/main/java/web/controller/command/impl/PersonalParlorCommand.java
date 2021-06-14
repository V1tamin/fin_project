package web.controller.command.impl;

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
 * @author Anton Lopatin on 07.06.2021
 */
public class PersonalParlorCommand implements Command {
    @Override
    public Map<String, Object> execute(HttpServletRequest request, HttpServletResponse response) throws SQLException, NamingException {
        Map<String, Object> map = new HashMap<>();
        System.out.println("PersonalParlorCommand.execute");
        HttpSession session = request.getSession();
        System.out.println(session.getAttribute(USER));
        map.put(PAGE, PERSONAL_ACC_JSP);
        return map;
    }
}

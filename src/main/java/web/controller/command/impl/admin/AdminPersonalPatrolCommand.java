package web.controller.command.impl.admin;

import web.controller.command.Command;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import static constant.Constants.*;

/**
 * @author Anton Lopatin on 14.06.2021
 */
public class AdminPersonalPatrolCommand implements Command {
    @Override
    public Map<String, Object> execute(HttpServletRequest request, HttpServletResponse response) throws SQLException, NamingException {
        System.out.println("AdminPersonalPatrolCommand.execute");
        Map<String, Object> map = new HashMap<>();
        map.put(PAGE, ADMIN_PARLOR_JSP);
        return map;
    }
}

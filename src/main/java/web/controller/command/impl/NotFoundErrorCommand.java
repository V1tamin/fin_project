package web.controller.command.impl;

import web.controller.command.Command;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import static constant.Constants.ERROR_NOT_FOUND_CONTENT;
import static constant.Constants.PAGE;

/**
 * @author Anton Lopatin on 03.06.2021
 */
public class NotFoundErrorCommand implements Command {
    @Override
    public Map<String, Object> execute(HttpServletRequest request, HttpServletResponse response) throws SQLException, NamingException {
        Map<String, Object> map = new HashMap<>();
        map.put(PAGE, ERROR_NOT_FOUND_CONTENT);
        return map;
    }
}

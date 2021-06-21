package web.controller.command.impl;

import web.controller.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

import static constant.Constants.INDEX_JSP;
import static constant.Constants.PAGE;

/**
 * @author Anton Lopatin on 20.06.2021
 */
public class LogOutCommand implements Command {
    @Override
    public Map<String, Object> execute(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> map = new HashMap<>();
        request.getSession().invalidate();
        map.put(PAGE, INDEX_JSP);
        return map;
    }
}

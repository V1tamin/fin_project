package web.controller.command.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import web.controller.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

import static constant.Constants.APARTMENTS_JSP;
import static constant.Constants.PAGE;

/**
 * @author Anton Lopatin on 03.06.2021
 */
public class ApartmentsCommand implements Command {
    private static final Logger logger = LogManager.getLogger();
    @Override
    public Map<String, Object> execute(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> map = new HashMap<>();
        map.put(PAGE, APARTMENTS_JSP);
        return map;
    }
}

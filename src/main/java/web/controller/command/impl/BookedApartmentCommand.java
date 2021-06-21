package web.controller.command.impl;

import web.controller.command.Command;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import static constant.Constants.PAGE;
import static constant.Constants.SELECT_TIME_BOOKING_APARTMENT_JSP;

/**
 * @author Anton Lopatin on 20.06.2021
 */
public class BookedApartmentCommand implements Command {
    @Override
    public Map<String, Object> execute(HttpServletRequest request, HttpServletResponse response) throws SQLException, NamingException {
        Map<String, Object> map = new HashMap<>();
        System.out.println("date: " + request.getAttribute("until_what_date"));
        map.put(PAGE, SELECT_TIME_BOOKING_APARTMENT_JSP);
        return map;
    }
}

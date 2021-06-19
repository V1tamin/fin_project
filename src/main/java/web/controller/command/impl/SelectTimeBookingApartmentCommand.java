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
 * @author Anton Lopatin on 19.06.2021
 */
public class SelectTimeBookingApartmentCommand implements Command {
    @Override
    public Map<String, Object> execute(HttpServletRequest request, HttpServletResponse response) throws SQLException, NamingException {
        Map<String, Object> map = new HashMap<>();
        try {
            Object auth = request.getSession(true).getAttribute("userLoggedIn");
            if (auth == null) {
                map.put(PAGE, LOGIN_JSP);
            } else {
                System.out.println("auth: " + auth);
                map.put(PAGE, SELECT_TIME_BOOKING_APARTMENT_JSP);
            }
        }catch (Exception ex) {
            System.err.println(ex);
            map.put(PAGE, LOGIN_JSP);
        }
        return map;
    }
}

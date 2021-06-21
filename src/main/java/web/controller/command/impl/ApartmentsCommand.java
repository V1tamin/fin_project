package web.controller.command.impl;

import dao.IApartmentDAO;
import dao.impl.ApartmentTableDAO;
import model.Apartment;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import web.controller.command.Command;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static constant.Constants.APARTMENTS_JSP;
import static constant.Constants.PAGE;

/**
 * @author Anton Lopatin on 20.06.2021
 */
public class ApartmentsCommand implements Command {
    private static final Logger logger = LogManager.getLogger();

    private IApartmentDAO apartmentDAO = new ApartmentTableDAO();
    private List<Apartment> apartments = new ArrayList<>();
    @Override
    public Map<String, Object> execute(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> map = new HashMap<>();
        try {
            apartments = apartmentDAO.getApartmentTable();
            request.getSession().setAttribute("apartments", apartments);
        } catch (SQLException | NamingException ex) {
            logger.log(Level.ERROR, ex);
        }
        map.put(PAGE, APARTMENTS_JSP);
        return map;
    }
}

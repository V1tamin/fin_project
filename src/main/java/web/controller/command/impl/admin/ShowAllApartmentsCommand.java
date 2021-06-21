package web.controller.command.impl.admin;

import model.Account;
import model.Apartment;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.DBManager;
import web.controller.command.Command;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static constant.Constants.*;
import static constant.SQLConstants.SELECT_ALL_APARTMENTS;
import static constant.SQLConstants.SELECT_ALL_CLIENTS;

/**
 * @author Anton Lopatin on 21.06.2021
 */
public class ShowAllApartmentsCommand implements Command {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public Map<String, Object> execute(HttpServletRequest request, HttpServletResponse response) throws SQLException, NamingException {
        Map<String, Object> map = new HashMap<>();
        List<Apartment> apartments = getApartments();
        request.getSession().setAttribute("apartments", apartments);
        map.put(PAGE, SHOW_ALL_APARTMENT_JSP);
        map.put(APARTMENTS, apartments);
        return map;
    }

    public List<Apartment> getApartments() throws SQLException {
        Connection con = null;
        List<Apartment> apartments = new ArrayList<>();
        try {
            con = DBManager.getConnection();
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_APARTMENTS);
            while (resultSet.next()) {
                Apartment apartment = new Apartment();
                apartment.setId(resultSet.getInt(ID));
                apartment.setApartmentStatusId(resultSet.getInt(APARTMENT_STATUS_ID));
                apartment.setPrice(resultSet.getString(APARTMENT_PRICE));
                apartment.setPlaces(resultSet.getInt(APARTMENT_PLACES));
                apartment.setRequestId(resultSet.getInt(APARTMENT_REQUEST_ID));
                apartment.setBookingId(resultSet.getInt(APARTMENT_BOOKING_ID));
                apartment.setDescription(resultSet.getString(APARTMENT_DESCRIPTION));
                apartment.setPhotoUrl(resultSet.getString(APARTMENT_PHOTO_URL));

                apartments.add(apartment);
            }
        } catch (SQLException ex) {
            logger.log(Level.ERROR, ex);
            throw ex;
        } finally {
            DBManager.close(con);
        }
        return apartments;
    }
}

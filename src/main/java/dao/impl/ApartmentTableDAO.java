package dao.impl;

import dao.IApartmentDAO;
import model.Apartment;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.DBManager;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static constant.Constants.*;
import static constant.SQLConstants.SELECT_ALL_APARTMENTS;

/**
 * @author Anton Lopatin on 14.06.2021
 */
public class ApartmentTableDAO implements IApartmentDAO {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public List<Apartment> getApartmentTable() throws SQLException, NamingException {
        Connection con = null;
        List<Apartment> catalog = new ArrayList<>();
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
                catalog.add(apartment);
            }
        }catch (SQLException ex) {
            logger.log(Level.ERROR, ex);
            throw ex;
        } finally {
            DBManager.close(con);
        }
        return catalog;
    }
}

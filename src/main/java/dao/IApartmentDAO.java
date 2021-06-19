package dao;

import model.Apartment;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Anton Lopatin on 19.06.2021
 */
public interface IApartmentDAO {
    List<Apartment> getApartmentTable() throws SQLException, NamingException;
}

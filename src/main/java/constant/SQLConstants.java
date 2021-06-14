package constant;

/**
 * @author Anton Lopatin on 28.05.2021
 */
public class SQLConstants {
    public static final String SELECT_ALL_CLIENTS = "SELECT *FROM client";

    public static final String SELECT_ACCOUNT_BY_LOGIN = "SELECT *FROM client WHERE login=?";
    public static final String SELECT_ADMIN_BY_LOGIN = "SELECT *FROM admin WHERE login=?";
    public static final String SELECT_MANAGER_BY_LOGIN = "SELECT *FROM manager WHERE login=?";
    public static final String SELECT_ACCOUNT_BY_ID = "SELECT *FROM client WHERE id=?";

    public static final String INSERT_NEW_USER = "INSERT INTO client(id,login,password,firstname,lastname,patronymic) " +
            "VALUE(?,?,?,?,?,?)";
}
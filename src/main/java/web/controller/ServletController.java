package web.controller;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import web.controller.command.*;
import web.controller.command.impl.*;
import web.controller.command.impl.admin.*;
import web.controller.command.impl.manager.ManagerLoginCommand;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import static constant.Constants.COMMAND;
import static constant.Constants.PAGE;

/**
 * @author Anton Lopatin on 25.05.2021
 */
@WebServlet(name = "controller", value = "/controller")
public class ServletController extends HttpServlet {
    private static final Logger logger = LogManager.getLogger();

    private Map<String, Command> commands;

    @Override
    public void init() {
        commands = new HashMap<>();
        commands.put("index", new IndexCommand());
        commands.put("login", new LoginCommand());
        commands.put("logout", new LogOutCommand());
        commands.put("reg", new RegisterCommand());
        commands.put("apartments", new ApartmentsCommand());
        commands.put("error", new NotFoundErrorCommand());
        commands.put("parlor", new PersonalParlorCommand());//change or remove because this command is not used
        commands.put("admin_auth", new AdminLoginCommand());
        commands.put("manager_auth", new ManagerLoginCommand());
        commands.put("all_clients", new ShowAllClientsCommand());
        commands.put("admin_patrol", new AdminPersonalPatrolCommand());
        commands.put("delete_user", new DeleteUserCommand());
        commands.put("create_new_user_admin", new CreateNewUserCommand());
        //commands.put("insert_user", new CreateNewUserCommand());
        commands.put("select_time_booked", new SelectTimeBookingApartmentCommand());
        commands.put("booked_apartment", new BookedApartmentCommand());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            process(request, response);
        } catch (SQLException | NamingException ex) {
            logger.log(Level.ERROR, ex);
            throw new RuntimeException();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            process(request, response);
        } catch (SQLException | NamingException ex) {
            logger.log(Level.ERROR, ex);
            throw new RuntimeException();
        }
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, NamingException {
        Command command = commands.get(request.getParameter(COMMAND));
        Map<String, Object> map = command.execute(request, response);
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            request.setAttribute(entry.getKey(), entry.getValue());
        }
        getServletContext().getRequestDispatcher((String) map.get(PAGE)).forward(request, response);
    }
}

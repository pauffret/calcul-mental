package controller;

import bo.Score;
import model.AccueilBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet( name = "accueilController", urlPatterns = {"/accueil"}, loadOnStartup = 1 )
public class AccueilController extends HttpServlet {

    private static final String PAGE_ACCUEIL_JSP = "/WEB-INF/jsp/accueil.jsp";
    private static final Logger LOGGER = Logger.getLogger( AccueilController.class.getName() );
    private int counter;

    public AccueilController() {
        LOGGER.log( Level.INFO, "Je suis dans le constructeur !" );
    }

    @Override
    public void init() throws ServletException {
        LOGGER.log( Level.INFO, "Je suis dans le init !" );
        super.init();
    }

    @Override
    public void destroy() {
        LOGGER.log( Level.INFO, "Je suis dans le destroy !" );
        super.destroy();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.log( Level.INFO, "Request : " + req);
        req.getRequestDispatcher(PAGE_ACCUEIL_JSP).forward(req, resp);
    }
}

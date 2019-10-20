package controller;

import bo.Score;
import model.AccueilBean;
import model.LoginBean;

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
    private static final String PAGE_GAME_JSP = "/game";
    private static final String PAGE_LOGIN_JSP ="/login";

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.log( Level.INFO, "Request : " + request);
        LoginBean model = new LoginBean();
        if(model.isConnected(request)) {
            AccueilBean accueilBean = new AccueilBean();
            accueilBean.getUsers();
            request.setAttribute("accueilBean", accueilBean);
            request.getRequestDispatcher(PAGE_ACCUEIL_JSP).forward(request, response);
            HttpSession session = request.getSession();
            session.setAttribute("nbQuestions",0);
            session.setAttribute("nbCorrect",0);
        }else {
            response.sendRedirect(request.getContextPath() + PAGE_LOGIN_JSP);
        }
    }
}

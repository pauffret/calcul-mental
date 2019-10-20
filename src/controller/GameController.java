package controller;

import model.LoginBean;
import bo.Game;
import model.GameBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet( name="GameController",urlPatterns = {"/game"} )
public class GameController extends HttpServlet {

    private static final String PAGE_GAME_JSP = "/WEB-INF/jsp/game.jsp";
    private static final String PAGE_LOGIN_JSP = "/login";
    private static final String PAGE_RESULTAT_JSP = "/resultat";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LoginBean model = new LoginBean();
        if(model.isConnected(request)){
            HttpSession session = request.getSession();
            if((int) session.getAttribute("nbQuestions") >= 10){
                response.sendRedirect(request.getContextPath() + PAGE_RESULTAT_JSP);
            }
            else {
                Game game = new Game();
                game.expression(1);
                request.setAttribute("game", game);
                session.setAttribute("pile", game.getPile());
                request.getRequestDispatcher(PAGE_GAME_JSP).forward(request, response);
            }
        }
        else {
            response.sendRedirect(request.getContextPath() + PAGE_LOGIN_JSP);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GameBean model = new GameBean();
        model.verifReponse(request);
        request.setAttribute("reponse", model);
        doGet(request, response);
    }

}

package model;

import bo.User;
import dal.DAOFactory;
import dal.UserDAOJDBC;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.Stack;

public class GameBean {

    private Double reponse;

    public GameBean() {}

    public void verifReponse(HttpServletRequest request){

        reponse = Double.valueOf(request.getParameter("response"));
        HttpSession session = request.getSession();
        Stack<Double> reponseTrue = (Stack<Double>) session.getAttribute("pile");
        // Vérif du résultat au centième près
        if (Math.abs(reponse - reponseTrue.pop()) < 0.01){
            session.setAttribute("nbBonneReponse", (int) session.getAttribute("nbBonneReponse") + 1);
        }
        session.setAttribute("questions", (int) session.getAttribute("questions") + 1);
    }

    public void verifBestScore(HttpServletRequest request){
        HttpSession session = request.getSession();
        UserDAOJDBC dao = (UserDAOJDBC) DAOFactory.getUserDAO();
        User user = (User) session.getAttribute("isConnected");
        if(user.getBestScore() < (int) session.getAttribute("nbCorrect")){
            try {
                GameBean gameBean = new GameBean();
                user.setBestScore((Integer) session.getAttribute("nbCorrect"));
                System.out.println("id user" + user.getIdUser());
                dao.update(user);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}

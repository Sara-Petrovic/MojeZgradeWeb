/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.njt.mojezgradeweb.action.registration;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import rs.fon.silab.njt.mojezgradeweb.action.AbstractAction;
import rs.fon.silab.njt.mojezgradeweb.constants.WebConstants;
import rs.fon.silab.njt.mojezgradeweb.domain.Upravnik;


/**
 *
 * @author Sara
 */
public class LoginAction extends AbstractAction {

    @Override
    public String execute(HttpServletRequest request) {
        //proveri da li korisnik postoji u sistemu(contextu)
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //validacija
        if (username.isEmpty() || password.isEmpty()) {
            request.setAttribute("errorMessage", "Username or password is empty!");
            return WebConstants.VIEW_LOGIN;
        }

        //proveri da li korisnik postoji
        List<Upravnik> users = (List<Upravnik>) request.getServletContext().getAttribute("users");
        Upravnik loginUser = users.stream().filter(user -> {
            return user.getEmail().equals(username) && user.getLozinka().equals(password);
        }).findFirst().orElse(null);
        
        if (loginUser == null) {
            request.setAttribute("errorMessage", "User does not exist!");
            return WebConstants.VIEW_LOGIN;
        }else{
            //stavi korisnika u sesiju da bi se video i na drugim stranicama
            HttpSession session = request.getSession(true);
            session.setAttribute("loginUser", loginUser);
                   
        }
        return WebConstants.VIEW_HOME;
    }

}

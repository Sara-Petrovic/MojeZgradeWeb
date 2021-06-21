/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.njt.mojezgradeweb.action;

import javax.servlet.http.HttpServletRequest;
import rs.fon.silab.njt.mojezgradeweb.action.registration.LoginAction;
import rs.fon.silab.njt.mojezgradeweb.action.registration.LogoutAction;
import rs.fon.silab.njt.mojezgradeweb.action.registration.RegistrationAddAction;
import rs.fon.silab.njt.mojezgradeweb.constants.WebConstants;


/**
 *
 * @author Sara
 */
public class ActionFactory {

    public static AbstractAction getAction(HttpServletRequest request) {
        AbstractAction action = null;
        String pathInfo = request.getPathInfo();
        switch (pathInfo) {
            case WebConstants.URL_REGISTRATION:
                action = new RegistrationAddAction();
                break;
            case WebConstants.URL_LOGIN_POST:
                action = new LoginAction();
                break;
            case WebConstants.URL_LOGOUT_POST:
                action = new LogoutAction();
                break;
            
            default:     
                ;
        }
        return action;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.njt.mojezgradeweb.action.registration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import rs.fon.silab.njt.mojezgradeweb.action.AbstractAction;
import rs.fon.silab.njt.mojezgradeweb.constants.WebConstants;


/**
 *
 * @author Sara
 */
public class LogoutAction extends AbstractAction{

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();//da obrisem ulogovane usere
        return WebConstants.VIEW_LOGIN;
    }
    
}

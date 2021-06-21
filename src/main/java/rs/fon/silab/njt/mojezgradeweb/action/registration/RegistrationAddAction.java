/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.njt.mojezgradeweb.action.registration;

import javax.servlet.http.HttpServletRequest;
import rs.fon.silab.njt.mojezgradeweb.action.AbstractAction;
import rs.fon.silab.njt.mojezgradeweb.constants.WebConstants;


/**
 *
 * @author Sara
 */
public class RegistrationAddAction extends AbstractAction{

    @Override
    public String execute(HttpServletRequest request) {
        //return "/WEB-INF/pages/register.jsp";
        return WebConstants.VIEW_ADD_REGISTRATION;
    }
    
}

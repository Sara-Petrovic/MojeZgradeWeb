/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.njt.mojezgradeweb.controller;

import javax.servlet.http.HttpServletRequest;
import rs.fon.silab.njt.mojezgradeweb.action.AbstractAction;
import rs.fon.silab.njt.mojezgradeweb.action.ActionFactory;


/**
 *
 * @author Sara
 */
public class ApplicationController {

    public String processRequest(HttpServletRequest request) {
        AbstractAction action= ActionFactory.getAction(request);
         System.err.println(action);
         return action.execute(request);
    }

}

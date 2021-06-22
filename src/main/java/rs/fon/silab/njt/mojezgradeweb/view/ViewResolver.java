/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.njt.mojezgradeweb.view;

import java.util.HashMap;
import java.util.Map;
import rs.fon.silab.njt.mojezgradeweb.constants.WebConstants;

/**
 *
 * @author Sara
 */
public class ViewResolver {
    private final Map<String,String> views;

    public ViewResolver() {
        this.views = new HashMap<>();
        views.put(WebConstants.VIEW_ADD_REGISTRATION, WebConstants.PAGE_ADD_REGISTRATION);
        views.put(WebConstants.VIEW_HOME, WebConstants.PAGE_HOME);
        views.put(WebConstants.VIEW_LOGIN, WebConstants.PAGE_LOGIN);
        views.put(WebConstants.VIEW_ALL_CITY, WebConstants.PAGE_HOME);
    }
    public String getPage(String view){//view je kljuc
        return views.get(view);
    }

    
    
}

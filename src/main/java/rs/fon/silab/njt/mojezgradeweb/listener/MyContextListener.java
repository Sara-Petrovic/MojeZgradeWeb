/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.njt.mojezgradeweb.listener;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import rs.fon.silab.njt.mojezgradeweb.domain.Upravnik;

/**
 * Web application lifecycle listener.
 *
 * @author korisnik
 */
@WebListener
public class MyContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("===================================================================================");
        List<Upravnik> users = new ArrayList<Upravnik>(){
                {
                    add(new Upravnik(1l, "admin", "admin", "admin", "admin"));
                }
        };
        sce.getServletContext().setAttribute("users", users);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        
    }
}

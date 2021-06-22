/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.njt.mojezgradeweb.frontcontroller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import rs.fon.silab.njt.mojezgradeweb.constants.WebConstants;
import rs.fon.silab.njt.mojezgradeweb.controller.ApplicationController;
import rs.fon.silab.njt.mojezgradeweb.view.ViewResolver;


/**
 *
 * @author Sara
 */
@WebServlet(name = "FrontController", urlPatterns = {"/application/*"})
public class FrontController extends HttpServlet {

    private ApplicationController applicationController;
    private ViewResolver viewResolver;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String view = WebConstants.VIEW_LOGIN; //ako nije autentifikovan dace mu stranicu za login

        if (authenticated(request)) {
            view = applicationController.processRequest(request);

        }
        String page = viewResolver.getPage(view);
        request.getRequestDispatcher(page).forward(request, response);

    }

    private boolean authenticated(HttpServletRequest request) {
        if (request.getPathInfo().equals(WebConstants.URL_LOGIN_POST)) {
            return true;
        }
        //todo register

        return request.getSession().getAttribute("loginUser") != null;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config); //To change body of generated methods, choose Tools | Templates.
        applicationController = new ApplicationController();
        viewResolver = new ViewResolver();
    }

}

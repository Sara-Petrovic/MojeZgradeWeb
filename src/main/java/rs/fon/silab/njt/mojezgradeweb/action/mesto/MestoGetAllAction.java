/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.njt.mojezgradeweb.action.mesto;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import rs.fon.silab.njt.mojezgradeweb.action.AbstractAction;
import rs.fon.silab.njt.mojezgradeweb.constants.WebConstants;
import rs.fon.silab.njt.mojezgradeweb.dao.impl.DbMestoDao;
import rs.fon.silab.njt.mojezgradeweb.dto.impl.MestoDto;
import rs.fon.silab.njt.mojezgradeweb.mapper.impl.MestoMapper;
import rs.fon.silab.njt.mojezgradeweb.service.impl.MestoService;

/**
 *
 * @author korisnik
 */
public class MestoGetAllAction extends AbstractAction{
    private final MestoService cityService;

    public MestoGetAllAction () {
        cityService = new MestoService(new DbMestoDao(), new MestoMapper());
    }
    
    @Override
    public String execute(HttpServletRequest request) {
        try {
            List<MestoDto> cities = cityService.getAll();
            request.setAttribute("cities", cities);
            return WebConstants.VIEW_ALL_CITY;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
}

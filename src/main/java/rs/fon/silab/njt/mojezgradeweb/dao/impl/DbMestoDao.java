/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.njt.mojezgradeweb.dao.impl;

import java.util.List;
import rs.fon.silab.njt.mojezgradeweb.dao.Dao;
import rs.fon.silab.njt.mojezgradeweb.domain.Mesto;
import rs.fon.silab.njt.mojezgradeweb.storage.MestoDbStorage;

/**
 *
 * @author Aleksandra Mišić
 */
public class DbMestoDao implements Dao<Mesto> {

    @Override
    public void save(Mesto city) throws Exception {
//        CityStorage.getInstance().getCities().add(city);

    }

    @Override
    public List<Mesto> getAll() throws Exception {
//        return CityStorage.getInstance().getCities();
        return MestoDbStorage.getInstance().getMesto();

    }

    @Override
    public List<Mesto> get(Mesto param) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void edit(Mesto param) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Mesto param) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

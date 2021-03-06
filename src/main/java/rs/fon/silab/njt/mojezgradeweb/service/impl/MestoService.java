/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.njt.mojezgradeweb.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import rs.fon.silab.njt.mojezgradeweb.dao.Dao;
import rs.fon.silab.njt.mojezgradeweb.dao.impl.DbMestoDao;
import rs.fon.silab.njt.mojezgradeweb.domain.Mesto;
import rs.fon.silab.njt.mojezgradeweb.dto.impl.MestoDto;
import rs.fon.silab.njt.mojezgradeweb.mapper.impl.MestoMapper;
import rs.fon.silab.njt.mojezgradeweb.service.Service;

/**
 *
 * @author Aleksandra Mišić
 */
public class MestoService implements Service<MestoDto>{

   private final Dao<Mesto> cityDao;
    private final MestoMapper cityMapper;

    public MestoService() {
        this.cityDao = new DbMestoDao();
        this.cityMapper = new MestoMapper();
    }


   
    
//     @Override
//    public List<CityDto> getAll() {
//        List<City> cities = cityDao.getAll();
//        return cities.stream().map(city->{
//            return cityMapper.toDto(city);
//        }).collect(Collectors.toList());
//    }

    @Override
    public List<MestoDto> getAll() throws Exception {
        List<Mesto> cities = cityDao.getAll();
        return cities.stream().map(city->{
            return cityMapper.toDto(city);
        }).collect(Collectors.toList());
    }

    @Override
    public List<MestoDto> get(MestoDto param) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(MestoDto param) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void edit(MestoDto param) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(MestoDto param) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


   
    
}

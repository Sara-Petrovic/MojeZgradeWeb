/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.njt.mojezgradeweb.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import rs.fon.silab.njt.mojezgradeweb.dao.Dao;
import rs.fon.silab.njt.mojezgradeweb.domain.Mesto;

/**
 *
 * @author korisnik
 */
@Repository
public class CityDaoJdbcTemplateImpl implements Dao<Mesto>{
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CityDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    @Override
    public void save(Mesto city) throws Exception {
        
        jdbcTemplate.update("INSERT INTO CITY VALUES (?,?,?)",
                            city.getMestoId(),
                            city.getPtt(),
                            city.getNaziv());
    }

    @Override
    public List<Mesto> getAll() throws Exception{
        String query = "SELECT * FROM mesto ORDER BY naziv";
        //return jdbcTemplate.query(query, new CityMapper());
        
        /*
        return jdbcTemplate.query(query, new RowMapper<City>() {
            @Override
            public City mapRow(ResultSet rs, int i) throws SQLException {
                return new City(rs.getLong("code"), rs.getString("name"));
            }
        });
        */
        
        return jdbcTemplate.query(query, (ResultSet rs, int i)->{
            System.out.println("Row number: " + i);
            return new Mesto(rs.getLong("mestoid"), rs.getString("ptt") , rs.getString("naziv"));
        });
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
    
    class CityMapper implements RowMapper<Mesto>{

        @Override
        public Mesto mapRow(ResultSet rs, int i) throws SQLException {
            System.out.println("Row number: " + i);
            return new Mesto(rs.getLong("mestoid"), rs.getString("ptt") , rs.getString("naziv"));
        }
        
    }
}

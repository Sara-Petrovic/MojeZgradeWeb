/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.njt.mojezgradeweb.dao;

import java.util.List;
import rs.fon.silab.njt.mojezgradeweb.domain.Entity;

/**
 *
 * @author korisnik
 * @param <T>
 */
public interface Dao<T extends Entity> {
    
   List<T> getAll() throws Exception;

    List<T> get(T param) throws Exception;

    void save(T param) throws Exception;

    void edit(T param) throws Exception;

    void delete(T param) throws Exception;
}

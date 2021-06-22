/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.njt.mojezgradeweb.mapper;

import rs.fon.silab.njt.mojezgradeweb.domain.Entity;
import rs.fon.silab.njt.mojezgradeweb.dto.Dto;


/**
 *
 * @author 
 */
public interface EntityDtoMapper<D extends Dto, E extends Entity> {
    D toDto(E entity);
    E toEntity(D dto);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.njt.mojezgradeweb.mapper.impl;

import rs.fon.silab.njt.mojezgradeweb.domain.Mesto;
import rs.fon.silab.njt.mojezgradeweb.dto.impl.MestoDto;
import rs.fon.silab.njt.mojezgradeweb.mapper.EntityDtoMapper;

/**
 *
 * @author Aleksandra Mišić
 */
public class MestoMapper implements EntityDtoMapper<MestoDto, Mesto>{
    
    @Override
    public MestoDto toDto(Mesto entity) {
        return new MestoDto(entity.getMestoId(), entity.getPtt(), entity.getNaziv());
    }

    @Override
    public Mesto toEntity(MestoDto dto) {
        return new Mesto(dto.getMestoId(),dto.getPtt(), dto.getNaziv());
    }
}

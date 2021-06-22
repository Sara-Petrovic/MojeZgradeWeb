/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.njt.mojezgradeweb.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import rs.fon.silab.njt.mojezgradeweb.dto.impl.MestoDto;

/**
 *
 * @author korisnik
 */
public class MestoDtoValidator implements Validator{

    @Override
    public boolean supports(Class<?> clazz) {
        return MestoDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        System.out.println("\n\n\n\n\n..................");
        MestoDto cityDto = (MestoDto) target;
        if (cityDto.getMestoId()==null){
            errors.rejectValue("code", "cityDto.code.null","Code is null!");
        }
        if (cityDto.getNaziv().isEmpty()){
              errors.rejectValue("name", "cityDto.name.isEmpty","Name is empty!");
        }
    }
    
}

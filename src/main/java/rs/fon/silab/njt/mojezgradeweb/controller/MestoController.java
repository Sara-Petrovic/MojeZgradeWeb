/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.njt.mojezgradeweb.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.DataBinder;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import rs.fon.silab.njt.mojezgradeweb.dto.impl.MestoDto;
import rs.fon.silab.njt.mojezgradeweb.service.impl.MestoService;
import rs.fon.silab.njt.mojezgradeweb.validator.MestoDtoValidator;

/**
 *
 * @author korisnik
 */
@Controller
@RequestMapping(path = "/city")
public class MestoController {

    private final MestoService cityService;

    @Autowired
    public MestoController(MestoService cityService) {
        this.cityService = cityService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getAll() {
        ModelAndView modelAndView = new ModelAndView("/city/city-list");
        try {
            List<MestoDto> cities = cityService.getAll();
            for (MestoDto city : cities) {
                System.out.println(city);
            }
            modelAndView.addObject("cities", cities);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return modelAndView;
    }

//
//    @RequestMapping(path = "/add", method = RequestMethod.GET)
//    public String addModel(@ModelAttribute("cityDto") CityDto cityDto) {
//        cityDto.setCode(0L);
//        cityDto.setName("N/A");
//        return "/city/city-add";
//    }
//
// 
//    @RequestMapping(path = "/save", method = RequestMethod.POST)
//    public ModelAndView saveObject(@Valid @ModelAttribute CityDto cityDto,
//             Errors errors,RedirectAttributes redirectAttributes) {
//        System.out.println("===================== save =========================");
//        ModelAndView modelAndView = new ModelAndView();
//        if (errors.hasErrors()){
//            modelAndView.setViewName("/city/city-add");
//            modelAndView.addObject("errorMessage", "Error in validation!");
//        }else{
//            //nije bilo gresaka kod validacije
//            try {
//                System.out.println(cityDto);
//                //sacuvaj grad
//                cityService.save(cityDto);
//                modelAndView.setViewName("redirect:/city");
//                redirectAttributes.addFlashAttribute("successMessage", "City is added!");
//            } catch (Exception e) {
//                e.printStackTrace();
//                modelAndView.setViewName("/city/city-add");
//                modelAndView.addObject("errorMessage", "Grad nije sacuvan. Proverite podatke!");
//            }
//        }
//        return modelAndView;
//    }
//    
    @InitBinder
    public void initBinder(WebDataBinder binder){
        if (binder.getTarget() instanceof MestoDto){
            binder.addValidators(new MestoDtoValidator());
        }
    }
}

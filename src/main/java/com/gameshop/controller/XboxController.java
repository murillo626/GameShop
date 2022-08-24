
package com.gameshop.controller;

import com.gameshop.Domain.Articulo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.gameshop.services.ArticuloService;

@Controller
@Slf4j
public class XboxController {
    
    @Autowired
    private ArticuloService Articuloservices;
    
    @GetMapping("/xbox")
    public String inicio(Model model) {       
        var articulos=Articuloservices.getArticulos();
        model.addAttribute("articulos",articulos);
        return "xbox";
    }
}

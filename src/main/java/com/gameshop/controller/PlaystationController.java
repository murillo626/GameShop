
package com.gameshop.controller;

import com.gameshop.services.Articulo_Services;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class PlaystationController {
    
    @Autowired
    private Articulo_Services Articuloservices;
    
    @GetMapping("/playstation")
    public String inicio(Model model){
        var articulos=Articuloservices.getArticulos();
        model.addAttribute("articulos",articulos);
        return "playstation";
    }
}

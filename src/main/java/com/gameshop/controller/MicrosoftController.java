
package com.gameshop.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.gameshop.services.ArticuloService;

@Controller
@Slf4j
public class MicrosoftController {
    @Autowired
    private ArticuloService Articuloservices;
    
    @GetMapping("/microsoft")
    public String inicio(Model model) {       
        var articulos=Articuloservices.getArticulos();
        model.addAttribute("articulos",articulos);
        return "/microsoft";
    }
}

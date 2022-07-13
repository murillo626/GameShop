
package com.gameshop.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class InfoController {
    
    @Autowired
    
    
    @GetMapping("/informacion")
    public String inicio() {       
        
        return "/informacion";
    }
}

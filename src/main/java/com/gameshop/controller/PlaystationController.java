
package com.gameshop.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class PlaystationController {
    
    @Autowired
    
    
    @GetMapping("/playstation")
    public String inicio() {       
        
        return "/playstation";
    }
}


package com.gameshop.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class XboxController {
    
    @Autowired
    
    
    @GetMapping("/xbox")
    public String inicio() {       
        
        return "/xbox";
    }
}

package com.gameshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
public class Indexej {
        @Autowired
    
    
    @GetMapping("/a")
    public String inicio() {       
        
        return "/redirect";
    }
}

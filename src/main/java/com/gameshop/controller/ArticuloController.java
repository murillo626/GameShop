package com.gameshop.controller;
import com.gameshop.Domain.Articulo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.gameshop.services.ArticuloService;
import com.gameshop.services.CategoriaService;

@Controller
@Slf4j
public class ArticuloController {

    @Autowired
    private ArticuloService Articuloservices;
    //El getmappig es para establecer una ruta del sitio
    @Autowired
    private CategoriaService CategoriaService;
    
    @GetMapping("/articulo/listado")
    public String inicio(Model model) {
        var articulos = Articuloservices.getArticulos();
        model.addAttribute("articulos", articulos);
        return "/articulo/listado";
    }

    @GetMapping("/articulo/nuevo")
    public String nuevoArticulo(Articulo articulo, Model model){
        var categorias = CategoriaService.getCategorias();
        model.addAttribute("categorias",categorias);
        return "/articulo/modificar";
    }

    @PostMapping("/articulo/guardar")
    public String guardarArticulo(Articulo articulo) {
        Articuloservices.save(articulo);
        return "redirect:/articulo/listado";
    }

    @GetMapping("/articulo/modificar/{id_Articulo}")
    public String modificarArticulo(Articulo articulo, Model model) {
        articulo = Articuloservices.getArticulo(articulo);
        model.addAttribute("articulo", articulo);
        var categorias = CategoriaService.getCategorias();
        model.addAttribute("categorias",categorias);
        return "/articulo/modificar";
    }

    @GetMapping("/articulo/eliminar/{id_Articulo}")
    public String eliminarArticulo(Articulo articulo) {
        Articuloservices.delete(articulo);
        return "redirect:/articulo/listado";
    }
}
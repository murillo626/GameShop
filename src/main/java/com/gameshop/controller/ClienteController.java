package com.gameshop.controller;
import com.gameshop.Domain.Cliente;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.gameshop.services.ClienteService;

@Controller
@Slf4j
public class ClienteController {

    @Autowired
    private ClienteService Clienteservices;
    //El getmappig es para establecer una ruta del sitio

    @GetMapping("/cliente/listado")
    public String inicio(Model model) {
        log.info("Estamos del lado de programacion");
        var clientes = Clienteservices.getClientes();
        model.addAttribute("clientes", clientes);
        return "/cliente/listado";
    }

    @GetMapping("/cliente/nuevo")
    public String inicio(Cliente cliente) {

        return "/cliente/modificar";
    }

    @PostMapping("/cliente/guardar")
    public String guardarCliente(Cliente cliente) {
        Clienteservices.save(cliente);
        return "redirect:/cliente/listado";
    }

    @GetMapping("/cliente/modificar/{id_cliente}")
    public String modificarCliente(Cliente cliente, Model model) {
        cliente = Clienteservices.getCliente(cliente);
        model.addAttribute("cliente", cliente);
        return "/cliente/modificar";
    }

    @GetMapping("/cliente/eliminar/{id_cliente}")
    public String eliminarCliente(Cliente cliente) {
        Clienteservices.delete(cliente);
        return "redirect:/cliente/listado";
    }
}
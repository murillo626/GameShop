package com.gameshop.services;
import com.gameshop.Domain.Cliente;
import java.util.List;

public interface Cliente_Services {
    public List<Cliente> getClientes();
    public void save(Cliente cliente);
    public void delete(Cliente cliente);
    public Cliente getCliente(Cliente cliente);
}


package com.gameshop.services;
import com.gameshop.Domain.Cliente;
import com.gameshop.Domain.Credito;
import com.gameshop.Dao.ClienteDao;
import com.gameshop.Dao.CreditoDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service //indica que clase sera de servicios
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteDao clienteDao;
    
    @Autowired
    private CreditoDao creditoDao;
    
    
    @Override
    @Transactional(readOnly = true)
    public List<Cliente> getClientes() {
        return (List<Cliente>)clienteDao.findAll();
    }

    @Override
    @Transactional
    public void save(Cliente cliente) {
        //Recupero el objeto credito que trae el cliente
        Credito credito=cliente.getCredito();
        //salvo el objeto credito en la base
        creditoDao.save(credito);
        cliente.setCredito(credito);
        clienteDao.save(cliente);
    }

    @Override
    @Transactional
    public void delete(Cliente cliente) {
        clienteDao.delete(cliente);
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente getCliente(Cliente cliente) {
       return clienteDao.findById(cliente.getId_cliente()).orElse(null);
    }
}


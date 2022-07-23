package com.gameshop.services;
import com.gameshop.Domain.Credito;
import com.gameshop.Dao.CreditoDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service //indica que clase sera de servicios
public class CreditoServiceImpl implements Credito_Services{

    @Autowired
    private CreditoDao creditoDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Credito> getCreditos() {
        return (List<Credito>)creditoDao.findAll();
    }

    @Override
    @Transactional
    public void save(Credito credito) {
        creditoDao.save(credito);
    }

    @Override
    @Transactional
    public void delete(Credito credito) {
        creditoDao.delete(credito);
    }

    @Override
    @Transactional(readOnly = true)
    public Credito getCredito(Credito credito) {
       return creditoDao.findById(credito.getId_credito()).orElse(null);
    }
}

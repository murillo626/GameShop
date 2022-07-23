package com.gameshop.services;
import com.gameshop.Domain.Categoria;
import com.gameshop.Dao.CategoriaDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service //indica que clase sera de servicios
public class CategoriaServiceImpl implements Categoria_Services{

    @Autowired
    private CategoriaDao categoriaDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Categoria> getCategorias() {
        return (List<Categoria>)categoriaDao.findAll();
    }

    @Override
    @Transactional
    public void save(Categoria categoria) {
        categoriaDao.save(categoria);
    }

    @Override
    @Transactional
    public void delete(Categoria categoria) {
        categoriaDao.delete(categoria);
    }

    @Override
    @Transactional(readOnly = true)
    public Categoria getCategoria(Categoria categoria) {
       return categoriaDao.findById(categoria.getId_Categoria()).orElse(null);
    }
}

package com.gameshop.services;
import com.gameshop.Domain.Articulo;
import com.gameshop.Dao.ArticuloDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service //indica que clase sera de servicios
public class ArticuloServiceImpl implements ArticuloService{

    @Autowired
    private ArticuloDao articuloDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Articulo> getArticulos() {
        return (List<Articulo>)articuloDao.findAll();
    }

    @Override
    @Transactional
    public void save(Articulo articulo) {
        articuloDao.save(articulo);
    }

    @Override
    @Transactional
    public void delete(Articulo articulo) {
        articuloDao.delete(articulo);
    }

    @Override
    @Transactional(readOnly = true)
    public Articulo getArticulo(Articulo articulo) {
       return articuloDao.findById(articulo.getId_Articulo()).orElse(null);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Articulo getRuta(Articulo articulo) {
        return articuloDao.findByRuta(articulo.getRuta());
    }
}
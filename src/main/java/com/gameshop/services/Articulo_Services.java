package com.gameshop.services;
import com.gameshop.Domain.Articulo;
import java.util.List;

public interface Articulo_Services {
    public List<Articulo> getArticulos();
    public void save(Articulo articulo);
    public void delete(Articulo articulo);
    public Articulo getArticulo(Articulo articulo);
    public Articulo getRuta(Articulo articulo);
}


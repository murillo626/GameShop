package com.gameshop.services;
import com.gameshop.Domain.Categoria;
import java.util.List;

public interface Categoria_Services {
    public List<Categoria> getCategorias();
    public void save(Categoria categoria);
    public void delete(Categoria categoria);
    public Categoria getCategoria(Categoria categoria);
}


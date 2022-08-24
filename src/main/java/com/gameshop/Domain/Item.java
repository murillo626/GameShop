package com.gameshop.Domain;

import lombok.Data;

@Data
public class Item extends Articulo{
    private int cantidad;

    public Item() {
    }

    public Item(Articulo articulo) {
        super.setId_Articulo(articulo.getId_Articulo());
        super.setId_Categoria(articulo.getId_Categoria());
        super.setDescripcion(articulo.getDescripcion());
        super.setDetalle(articulo.getDetalle());
        super.setPrecio(articulo.getPrecio());
        super.setExistencias(articulo.getExistencias());
        super.setActivo(articulo.isActivo());
        super.setRuta(articulo.getRuta());
        this.cantidad=0;
    }
    
}

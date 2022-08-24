package com.gameshop.services;
import com.gameshop.Domain.Item;
import java.util.ArrayList;
import java.util.List;

public interface Item_Services {
    public List<Item>listaIntems=new ArrayList<>();
    public List<Item> getItems();
    public void save(Item item);
    public void delete(Item item);
    public Item getItem(Item item);
    public void actualiza(Item item);
    public void facturar();
}


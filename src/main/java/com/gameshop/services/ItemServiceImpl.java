package com.gameshop.services;
import com.gameshop.Domain.Item;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service //indica que clase sera de servicios
public class ItemServiceImpl implements ItemService{

    @Override
    public List<Item> getItems() {
        return listaItems;
    }

    @Override
    public void save(Item item) {
        boolean existe = false;
        for(Item c : listaItems){
            if(Objects.equals(c.getId_Articulo(), item.getId_Articulo())){
                if(c.getCantidad()<item.getExistencias()){
                    c.setCantidad(c.getCantidad()+1);
                }
            }
            existe=true;
            break;
        }
        if(!existe){
            item.setCantidad(1);
            listaItems.add(item);
        }
    }

    @Override
    public void delete(Item item) {
       var posicion =-1;
       var existe = false;
       for(Item c : listaItems){
           ++posicion;
           if (Objects.equals(c.getId_Articulo(), item.getId_Articulo())) {
               existe = true;
               break;
           }
       }
        if (existe) {
            listaItems.remove(posicion);
            
        }
    }

    @Override
    public Item getItem(Item item) {
        for(Item c:listaItems){
            if (Objects.equals(c.getId_Articulo(), item.getId_Articulo())) {
                return c;
            }
        }
        return null;
    }


    @Override
    public void actualiza(Item item) {
        for (Item i : listaItems) {
            if(Objects.equals(i.getId_Articulo(), item.getId_Articulo())){
                i.setCantidad(item.getCantidad());
            break;
            }
        }
                
    }
    

    @Override
    public void facturar() {
        for(Item i : listaItems){
        
        }
        listaItems.clear();
    }
}
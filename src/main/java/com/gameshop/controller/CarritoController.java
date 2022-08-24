
import com.gameshop.Domain.Articulo;
import com.gameshop.Domain.Item;
import com.gameshop.services.Articulo_Services;
import com.gameshop.services.Item_Services;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@Slf4j
public class CarritoController {

    @Autowired
    private Item_Services ItemService;
    @Autowired
    private Articulo_Services ArticuloServise;
    
    @GetMapping("/carrito/listado")
    public String inicio(Model model){
        var items = ItemService.getItems();
        model.addAttribute("items",items);
        var carritoTotalVenta=0;
        for(Item i : items){
            carritoTotalVenta+=(i.getCantidad()*i.getPrecio());
        }
        model.addAttribute("carritoTotal",carritoTotalVenta);
        return "/carrito/listado";
    }
    @GetMapping("/carrito/agregar/(id_Articulo)")
    public ModelAndView agregarItem(Model model, Item item){
        Item item2 = ItemService.getItem(item);
        if(item2==null){
            Articulo articulo=ArticuloServise.getArticulo(item);
            item2 = new Item(articulo);
        }
        ItemService.save(item2);
        var lista=ItemService.getItems();
        var totalCarrito=0;
        var carritoTotalVenta=0;
        for(Item i:lista){
            totalCarrito+=i.getCantidad();
            carritoTotalVenta+=(i.getCantidad()*i.getPrecio());
        }
        model.addAttribute("listaItems",lista);
        model.addAttribute("listaTotal",totalCarrito);
        model.addAttribute("carritoTotal",carritoTotalVenta);
        return new ModelAndView("/carrito/fragmentoscarrito :: verCarrito");
    }
    @GetMapping("/carrito/modificar/(id_Articulo)")
    public String modificarItem(Item item, Model model){
        item = ItemService.getItem(item);
        model.addAttribute("item",item);
        return "/carrito/modificar";
    }
    @GetMapping("/carrito/eliminar/(id_Articulo)")
    public String eliminarItem(Item item){
        ItemService.delete(item);
        return "redirect:/carrito/listado";
    }
    @PostMapping("/carrito/guardar")
    public String guardarItem(Item item){
        ItemService.actualiza(item);
        return "redirect:/carrito/listado";
    }
    @GetMapping("/facturar/carrito")
    public String facturarCarrito(){
        ItemService.facturar();
        return "redirect:/";
    }
}
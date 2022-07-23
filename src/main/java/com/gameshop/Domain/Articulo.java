package com.gameshop.Domain;
import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;
@Data
//para los get and set
@Entity
@Table(name ="articulo")
public class Articulo implements Serializable{
    private static final long serialVersionUID=11;//para atributos autoimcrementables
    @Id//llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)//como se hace autoincremental
    @Column(name="id_Articulo")
    private Long id_Articulo;
    private Long id_Categoria;
    private String descripcion;
    private String detalle;
    private double precio;
    private int existencias;
    private boolean activo;
    public Articulo(){
    }

    public Articulo(Long id_Categoria, String descripcion, String detalle, double precio, int existencias, boolean activo) {
        this.id_Categoria = id_Categoria;
        this.descripcion = descripcion;
        this.detalle = detalle;
        this.precio = precio;
        this.existencias = existencias;
        this.activo = activo;
    }   
}
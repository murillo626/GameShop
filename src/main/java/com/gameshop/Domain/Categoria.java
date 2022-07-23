package com.gameshop.Domain;
import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data//para los get and set
@Entity
@Table(name ="categoria")
public class Categoria implements Serializable{
    private static final long serialVersionUID=11;//para atributos autoimcrementables
    @Id//llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)//como se hace autoincremental
    
    private Long id_Categoria;
    private String descripcion;
    private boolean activo;

    public Categoria(){
    }

    public Categoria(String descripcion, boolean activo) {
        this.descripcion = descripcion;
        this.activo = activo;
    }
}


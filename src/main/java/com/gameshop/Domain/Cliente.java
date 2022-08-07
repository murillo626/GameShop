package com.gameshop.Domain;
import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;
@Data//para los get and set
@Entity
@Table(name ="cliente")
public class Cliente implements Serializable{
    private static final long serialVersionUID=11;//para atributos autoimcrementables    
    @Id//llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)//como se hace autoincremental
    @Column(name="id_cliente")
    private Long id_cliente;
    String nombre;
    String apellidos;
    String correo;
    String telefono;
    @JoinColumn(name = "id_credito",referencedColumnName="id_credito")

    @ManyToOne
    private Credito credito;
    public Cliente(){
    }

    public Cliente(String nombre, String apellidos, String correo, String telefono) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
    }

    public Cliente(String nombre, String apellidos, String correo, String telefono, Credito credito) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
        this.credito = credito;
    }
}
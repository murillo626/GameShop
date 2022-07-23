package com.gameshop.Domain;
import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;
@Data//para los get and set
@Entity
@Table(name ="credito")
public class Credito implements Serializable{
    private static final long serialVersionUID=11;//para atributos autoimcrementables
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//como se hace autoincremental
    @Column(name="id_credito")
    private Long id_credito;

    private double limite;

    public Credito(){
    }

    public Credito(double limite) {
        this.limite=limite;
    }    
}    

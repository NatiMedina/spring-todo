package com.naty.todo.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "todo")
@ToString
@EqualsAndHashCode
@Getter
@Setter
public class Todo {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "estado")
    private String estado;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "creacion")
    private Date creacion;
    @Column(name = "vencimiento")
    private Date vencimiento;
    @Column(name = "modificacion")
    private Date modificacion;
    @Column(name = "id_autor")
    private Long idAutor;
    @Column(name = "prioridad")
    private String prioridad;
    @Column(name = "id_panel")
    private Long idPanel;

}

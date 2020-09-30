package com.example.demo.models.entities;


import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "person")
public class Employee {


    public Employee(String name){
        this.name = name;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(min = 3, max = 20)
    private String name;

    public Employee() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

}

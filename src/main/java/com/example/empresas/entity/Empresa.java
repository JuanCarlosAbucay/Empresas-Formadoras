package com.example.empresas.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
public class Empresa {
    @Id
    private long cif;

    @NotBlank(message="*Has de posar un nom")
    @Size(min=2, max=50)
    private String nom;
    @NotBlank(message="*Has de posar una direcció")
    @Size(min=2, max=50)
    private String direccion;
    @OneToMany(mappedBy = "empresa")
    private List<Alumne> alumnes;

    public long getCif() {
        return cif;
    }

    public void setCif(long cif) {
        this.cif = cif;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Alumne> getAlumnes() {
        return alumnes;
    }

    public void setAlumnes(List<Alumne> alumnes) {
        this.alumnes = alumnes;
    }
}


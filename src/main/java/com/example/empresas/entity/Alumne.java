package com.example.empresas.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Alumne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message="*Has de posar un nom")
    @Size(min=2, max=50)
    private String nom;
    @NotBlank(message="*Has de posar un cognom")
    @Size(min=2, max=50)
    private String cognom;
    @NotBlank(message="*Has de posar un cicle")
    @Size(min=2, max=50)
    private String cicle;
    @NotBlank(message="*Has de posar una modalitat")
    @Size(min=2, max=50)
    private String modalitat;
    @NotBlank(message="*Has de posar l'estat")
    @Size(min=2, max=50)
    private String estat;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognom() {
        return cognom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

    public String getCicle() {
        return cicle;
    }

    public void setCicle(String cicle) {
        this.cicle = cicle;
    }

    public String getModalitat() {
        return modalitat;
    }

    public void setModalitat(String modalitat) {
        this.modalitat = modalitat;
    }

    public String getEstat() {
        return estat;
    }

    public void setEstat(String estat) {
        this.estat = estat;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
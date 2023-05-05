package com.example.empresas.repositori;

import com.example.empresas.entity.Alumne;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "alumne", path="alumne")
public interface AlumnesRepositori extends JpaRepository<Alumne, Long> {
    @EntityGraph(attributePaths = {"empresa"})
    List<Alumne> findAll();
}
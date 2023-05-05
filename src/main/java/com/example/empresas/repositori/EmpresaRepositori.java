package com.example.empresas.repositori;

import com.example.empresas.entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "empresa", path = "empresa")
public interface EmpresaRepositori extends JpaRepository<Empresa, Long> {
}

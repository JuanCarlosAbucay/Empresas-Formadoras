package com.example.empresas.controller;

import com.example.empresas.entity.Empresa;
import com.example.empresas.repositori.AlumnesRepositori;
import com.example.empresas.repositori.EmpresaRepositori;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ControllerEmpresa {
    @Autowired
    AlumnesRepositori repositoriAlumnes;

    @Autowired
    EmpresaRepositori repositoriEmpresa;

    @GetMapping("/formEmpresa")
    public String formEmpresa(Model model) {
        model.addAttribute("empresa", new Empresa());
        return "empresa/formularioEmpresa";
    }

    @GetMapping("/empresa")
    public String llistarEmpresa(Model model){
        List<Empresa> empresas = repositoriEmpresa.findAll();
        model.addAttribute("empresas", empresas);
        return "empresa/listadoEmpresa";
    }

    @PostMapping("/formEmpresa")
    public String afegirEmpresa(@ModelAttribute("empresa") Empresa empresa, Errors errors) {
        if (errors.hasErrors()){
            return "empresa/listadoEmpresa";
        }
        repositoriEmpresa.save(empresa);
        return "redirect:/empresa";
    }
}

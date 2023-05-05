
package com.example.empresas.controller;
import com.example.empresas.entity.Alumne;
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
public class ControllerAlumne {
    @Autowired
    AlumnesRepositori repositoriAlumnes;
    @Autowired
    EmpresaRepositori repositoriEmpresa;

    @GetMapping
    public String llistarAlumnes(Model model){
        List<Alumne> alumnes = repositoriAlumnes.findAll();
        model.addAttribute("alumnes", alumnes);
        model.addAttribute("empresa", repositoriEmpresa.findAll());
        return "listadoAlumnos";
    }

    @GetMapping("/alumnes")
    public String displayAlumnes(Model model){
        List<Alumne> alumnes = repositoriAlumnes.findAll();
        model.addAttribute("alumnes", alumnes);
        model.addAttribute("empresa", repositoriEmpresa.findAll());
        return "alumnes/listadoAlumnos";
    }

    @GetMapping("/formAlumne")
    public String formAlumne(Model model) {
        model.addAttribute("alumne", new Alumne());
        model.addAttribute("empresa", repositoriEmpresa.findAll());
        return "alumnes/formularioAlumno";
    }

    @PostMapping("/formAlumne")
    public String afegirAlumne(@ModelAttribute("alumne") Alumne alumne, Errors errors) {
        if(errors.hasErrors()){
            return "alumnes/formularioAlumno";
        }
        repositoriAlumnes.save(alumne);
        return "redirect:/alumnes";
    }
}

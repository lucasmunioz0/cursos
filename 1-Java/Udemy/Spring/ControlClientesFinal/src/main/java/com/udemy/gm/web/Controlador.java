package com.udemy.gm.web;

import java.util.List;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import com.udemy.gm.domain.Persona;
import com.udemy.gm.services.IPersonaService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.security.core.userdetails.User;

@Controller
@Slf4j
public class Controlador {

    @Autowired
    private IPersonaService service;

    @GetMapping("/")
    public String inicio(Model model, @AuthenticationPrincipal User user) {
        List<Persona> personas = service.listarPersonas();
        Double saldoTotal = 0D;
        saldoTotal = personas.stream().map((persona) -> persona.getSaldo()).reduce(saldoTotal, (accumulator, _item) -> accumulator + _item);
        model.addAttribute("personas", personas);
        model.addAttribute("saldoTotal", saldoTotal);
        model.addAttribute("totalClientes", personas.size());
        return "index";
    }

    @GetMapping("/agregar")
    public String agregar(Persona persona) {
        return "modificar";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid Persona persona, Errors errores) {
        if (errores.hasErrors()) {
            return "modificar";
        }
        service.guardar(persona);
        return "redirect:/";
    }

    @GetMapping("/editar/{idPersona}")
    public String editar(Persona persona, Model model) {
        persona = service.getById(persona);
        model.addAttribute("persona", persona);
        return "modificar";
    }

    @GetMapping("/eliminar/{idPersona}")
    public String eliminar(Persona persona) {
        service.eliminar(persona);
        return "redirect:/";
    }

//    @GetMapping("/eliminar")
//    public String eliminar(Persona persona){
//        service.eliminar(persona);
//        return "redirect:/";
//    }
}

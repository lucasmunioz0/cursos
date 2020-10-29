package com.udemy.gm.web;

import com.udemy.gm.domain.Persona;
import com.udemy.gm.services.IPersonaService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class Controlador {
    @Autowired
    private IPersonaService service;
    
    @GetMapping("/")
    public String inicio(Model model) {
        List<Persona> personas = service.listarPersonas();
        model.addAttribute("personas", personas);
        log.info("Ejecutando controlador Spring MVC");
        return "index";
    }
}

package org.camisetas.camisetasapp.controllers;


import org.camisetas.camisetasapp.models.Camiseta;
import org.camisetas.camisetasapp.services.CamisetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CamisetaController {

    private final CamisetaService camisetaService;

    @Autowired
    public CamisetaController(CamisetaService camisetaService) {
        this.camisetaService = camisetaService;
    }
//operación read de CRUD
    @GetMapping("/camisetas")
    String listCamisetas(Model model) {
        List<Camiseta> camisetas = camisetaService.allCamisetas();
        model.addAttribute("name", "Camiseta list");
        model.addAttribute("camisetas", camisetas);
        return "camisetas/all";
    }
    @PostMapping("/new")
  String addCamiseta(@ModelAttribute Camiseta camiseta){
      camisetaService.save(camiseta);
      return "redirect:/camisetas";
    }
}

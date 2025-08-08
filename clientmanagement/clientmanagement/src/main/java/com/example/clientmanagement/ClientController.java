package com.example.clientmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClassRepository ClassRepository;

    @GetMapping
    public String listClients(Model model) {
        model.addAttribute("clients", ClassRepository.findAll());
        return "list_clients";
    }

    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("client", new Client());
        return "add_client";
    }

    @PostMapping
    public String saveClient(@ModelAttribute Client client) {
        ClassRepository.save(client);
        return "redirect:/clients";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Client client = ClassRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Invalid client Id:" + id));
        model.addAttribute("client", client);
        return "add_client";
    }

    @GetMapping("/delete/{id}")
    public String deleteClient(@PathVariable Long id) {
        ClassRepository.deleteById(id);
        return "redirect:/clients";
    }
}

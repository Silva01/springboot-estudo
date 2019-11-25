package com.example.demo.controller;

import com.example.demo.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("playlists")
public class PlaylistController {

    @Autowired
    private PlaylistService service;

    @GetMapping("/listar")
    public String listar(Model m) {
        m.addAttribute("playlists", service.recuperar());
        return "playlist/list";
    }

}

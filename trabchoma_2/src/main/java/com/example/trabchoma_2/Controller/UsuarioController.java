package com.example.trabchoma_2.Controller;

import com.example.trabchoma_2.Model.Usuario;
import com.example.trabchoma_2.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> findAll() {
        return usuarioService.findAll();
    }

    @PostMapping("/registrar")
    public String registrar(@RequestBody Usuario usuario) {
        return usuarioService.registrar(usuario);
    }

}
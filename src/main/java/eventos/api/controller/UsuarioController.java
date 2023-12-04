package eventos.api.controller;

import eventos.api.usuario.DadosCadastrarUsuario;
import eventos.api.usuario.DadosListarUsuario;
import eventos.api.usuario.Usuario;
import eventos.api.usuario.UsuarioService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService service;

    @GetMapping
    public List<DadosListarUsuario> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Optional<Usuario> listarId(@PathVariable Long id) {
        return service.listarId(id);
    }

    @PostMapping
    @Transactional
    public Usuario cadastrar(@RequestBody @Valid DadosCadastrarUsuario dados) {
        return service.cadastrar(dados);
    }
}

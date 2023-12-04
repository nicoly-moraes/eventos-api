package eventos.api.controller;

import eventos.api.setor.*;
import eventos.api.setor.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/setores")
public class SetorController {

    @Autowired
    private SetorService service;

    @GetMapping
    public List<DadosListarSetor> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Optional<Setor> listarId(@PathVariable Long id) {
        return service.listarId(id);
    }

    @PostMapping
    @Transactional
    public Setor cadastrar(@RequestBody @Valid DadosCadastrarSetor dados) {
        return service.cadastrar(dados);
    }

    @PutMapping("/{id}")
    @Transactional
    public Setor atualizar(@PathVariable Long id, @RequestBody @Valid DadosAtualizarSetor dados) {
        return service.atualizar(id, dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }
}

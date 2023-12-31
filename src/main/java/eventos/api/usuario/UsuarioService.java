package eventos.api.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<DadosListarUsuario> listar() {
        return usuarioRepository
                .findAll()
                .stream()
                .map(DadosListarUsuario::new)
                .toList();
    }

    public Optional<Usuario> listarId(Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario cadastrar(DadosCadastrarUsuario dados) {
        Usuario usuario = new Usuario(dados);
        return usuarioRepository.save(usuario);
    }
}


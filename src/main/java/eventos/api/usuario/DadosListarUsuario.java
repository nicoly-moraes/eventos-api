package eventos.api.usuario;

public record DadosListarUsuario(Long id, String nome, Long cpf, String email, String senha) {
    public DadosListarUsuario(Usuario usuario) {
        this(usuario.getId(), usuario.getNome(), usuario.getCpf(), usuario.getEmail(), usuario.getSenha());
    }
}

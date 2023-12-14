package eventos.api.usuario;

public record DadosListarUsuario(Long id, String nome, Long cpf) {
    public DadosListarUsuario(Usuario usuario) {
        this(usuario.getId(), usuario.getNome(), usuario.getCpf());
    }
}

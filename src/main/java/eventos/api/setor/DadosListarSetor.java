package eventos.api.setor;



public record DadosListarSetor(Long id, String nome) {

    public DadosListarSetor(Setor setor) {
        this(setor.getId(), setor.getNome());
    }
}

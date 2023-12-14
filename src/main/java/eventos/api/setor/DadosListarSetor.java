package eventos.api.setor;



public record DadosListarSetor(Long id, Long evento_id, String nome) {

    public DadosListarSetor(Setor setor) {
        this(setor.getId(), setor.getEvento_id(), setor.getNome());
    }
}

package eventos.api.ingresso;

public record DadosListarIngresso(Long id, Long setor_id, String nome, Double valor, int qtd_limite) {
    public DadosListarIngresso(Ingresso ingresso) {
        this(ingresso.getId(), ingresso.getSetor_id(), ingresso.getNome(), ingresso.getValor(), ingresso.getQtd_limite());
    }
}

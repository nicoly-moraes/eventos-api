package eventos.api.ingresso;

public record DadosListarIngresso(Long id, String nome, Double valor, int qtdLimite) {
    public DadosListarIngresso(Ingresso ingresso) {
        this(ingresso.getId(), ingresso.getNome(), ingresso.getValor(), ingresso.getQtdLimite());
    }
}

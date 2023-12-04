package eventos.api.pedido;

public record DadosListarPedido(Long id, String data, int status, int tipoPagamento) {
    public DadosListarPedido(Pedido pedido) {
        this(pedido.getId(), pedido.getData(), pedido.getStatus(), pedido.getTipoPagamento());
    }
}

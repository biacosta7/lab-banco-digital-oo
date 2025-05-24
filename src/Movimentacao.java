import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class Movimentacao {
    private UUID id;
    private BigDecimal valor;
    private LocalDateTime data;
    private IConta contaOrigem;
    private IConta contaDestino;
    private TipoOperacao tipoOperacao;

    protected Movimentacao(UUID id, BigDecimal valor, LocalDateTime data, IConta contaOrigem, IConta contaDestino, TipoOperacao tipoOperacao){
        this.id = id;
        this.valor = valor;
        this.data = data;
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;
        this.tipoOperacao = tipoOperacao;
    }

    protected Movimentacao(UUID id, BigDecimal valor, LocalDateTime data, TipoOperacao tipoOperacao){
        this.id = id;
        this.valor = valor;
        this.data = data;
        this.tipoOperacao = tipoOperacao;
    }

}

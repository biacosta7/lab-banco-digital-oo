import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
public abstract class Conta implements IConta {
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numero;
	protected BigDecimal saldo;
	protected Cliente cliente;
	protected List<Movimentacao> movimentacoes;

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.saldo = BigDecimal.ZERO;
		this.cliente = cliente;
		this.movimentacoes = new ArrayList<>();
	}

	@Override
	public void sacar(BigDecimal valor) {
		saldo = saldo.subtract(valor);
		Movimentacao novaMovimentacao = new Movimentacao(UUID.randomUUID(), valor, LocalDateTime.now(), TipoOperacao.SAQUE);
		movimentacoes.add(novaMovimentacao);
	}

	@Override
	public void depositar(BigDecimal valor) {
		saldo = saldo.add(valor);
		Movimentacao novaMovimentacao = new Movimentacao(UUID.randomUUID(), valor, LocalDateTime.now(), TipoOperacao.DEPOSITO);
		movimentacoes.add(novaMovimentacao);
	}

	@Override
	public void transferir(BigDecimal valor, IConta contaDestino) {
		this.sacar(valor);
		contaDestino.depositar(valor);
		Movimentacao novaMovimentacao = new Movimentacao(UUID.randomUUID(), valor, LocalDateTime.now(), this, contaDestino, TipoOperacao.TRANSFERENCIA);
		movimentacoes.add(novaMovimentacao);
	}

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}
}

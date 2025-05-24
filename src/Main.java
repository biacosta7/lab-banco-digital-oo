import java.math.BigDecimal;

public class Main {

	public static void main(String[] args) {
		Cliente venilton = new Cliente();
		venilton.setNome("Venilton");
		
		Conta cc = new ContaCorrente(venilton);
		Conta poupanca = new ContaPoupanca(venilton);

		cc.depositar(BigDecimal.valueOf(100));
		cc.transferir(BigDecimal.valueOf(100), poupanca);
		
		cc.imprimirExtrato();
		poupanca.imprimirExtrato();
	}

}

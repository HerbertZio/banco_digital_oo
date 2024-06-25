public class Main {

	public static void main(String[] args) {
		Banco banco = new Banco("Meu Banco");

		// Criando clientes
		Cliente João = new Cliente();
		João.setNome("João");

		// Adicionando clientes ao banco
		banco.adicionarCliente(João);

		// Criando contas para os clientes
		Conta ccVenilton = new ContaCorrente(João);
		Conta poupancaVenilton = new ContaPoupanca(João);
		Conta investimentoVenilton = new ContaInvestimento(João, 0.05);

		// Adicionando contas ao banco
		banco.adicionarConta(ccVenilton);
		banco.adicionarConta(poupancaVenilton);
		banco.adicionarConta(investimentoVenilton);

		// Realizando operações bancárias
		ccVenilton.depositar(1000);
		ccVenilton.sacar(300);
		ccVenilton.transferir(200, poupancaVenilton);

		poupancaVenilton.depositar(500);

		investimentoVenilton.depositar(10000);
		investimentoVenilton.sacar(2000);

		// Imprimindo extratos
		ccVenilton.imprimirExtrato();
		poupancaVenilton.imprimirExtrato();
		investimentoVenilton.imprimirExtrato();
	}
}

import java.util.ArrayList;
import java.util.List;

public abstract class Conta implements IConta {

	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;
	private List<String> historicoTransacoes;

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
		this.historicoTransacoes = new ArrayList<>();
	}

	@Override
	public void sacar(double valor) {
		if (saldo >= valor) {
			saldo -= valor;
			adicionarTransacao(String.format("Saque de %.2f", valor));
		} else {
			System.out.println("Saldo insuficiente.");
		}
	}

	@Override
	public void depositar(double valor) {
		saldo += valor;
		adicionarTransacao(String.format("Depósito de %.2f", valor));
	}

	@Override
	public void transferir(double valor, IConta contaDestino) {
		if (saldo >= valor) {
			this.sacar(valor);
			contaDestino.depositar(valor);
			adicionarTransacao(String.format("Transferência de %.2f para conta %d", valor, ((Conta) contaDestino).getNumero()));
			System.out.println("Transferência realizada com sucesso.");
		} else {
			System.out.println("Saldo insuficiente para transferência.");
		}
	}

	@Override
	public void imprimirExtrato() {
		System.out.println("=== Extrato ===");
		imprimirInfosComuns();
		imprimirHistoricoTransacoes();
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agência: %d", this.agencia));
		System.out.println(String.format("Número: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}

	protected void adicionarTransacao(String transacao) {
		historicoTransacoes.add(transacao);
	}

	protected void imprimirHistoricoTransacoes() {
		System.out.println("=== Histórico de Transações ===");
		for (String transacao : historicoTransacoes) {
			System.out.println(transacao);
		}
	}
}

import java.util.ArrayList;
import java.util.List;

public class Banco {

	private String nome;
	private List<Cliente> clientes;
	private List<Conta> contas;

	public Banco(String nome) {
		this.nome = nome;
		this.clientes = new ArrayList<>();
		this.contas = new ArrayList<>();
	}

	public void adicionarCliente(Cliente cliente) {
		clientes.add(cliente);
	}

	public void adicionarConta(Conta conta) {
		contas.add(conta);
	}

	public Cliente buscarClientePorNome(String nome) {
		for (Cliente cliente : clientes) {
			if (cliente.getNome().equals(nome)) {
				return cliente;
			}
		}
		return null;
	}

	public Conta buscarContaPorNumero(int numero) {
		for (Conta conta : contas) {
			if (conta.getNumero() == numero) {
				return conta;
			}
		}
		return null;
	}
}

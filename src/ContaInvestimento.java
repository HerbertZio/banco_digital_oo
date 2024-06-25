public class ContaInvestimento extends Conta {

    private double taxaRendimento; // Taxa de rendimento em decimal (ex: 0.05 para 5%)

    public ContaInvestimento(Cliente cliente, double taxaRendimento) {
        super(cliente);
        this.taxaRendimento = taxaRendimento;
    }

    @Override
    public void sacar(double valor) {
        // Implementação específica para conta de investimento, se necessário
        // Por exemplo, permitir sacar apenas após um período de carência
        if (saldo >= valor) {
            saldo -= valor;
            adicionarTransacao(String.format("Saque de %.2f da conta de investimento", valor));
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
        adicionarTransacao(String.format("Depósito de %.2f na conta de investimento", valor));
    }

    @Override
    public void transferir(double valor, IConta contaDestino) {
        if (saldo >= valor) {
            this.sacar(valor);
            contaDestino.depositar(valor);
            adicionarTransacao(String.format("Transferência de %.2f para conta de investimento %d", valor, ((Conta) contaDestino).getNumero()));
            System.out.println("Transferência realizada com sucesso.");
        } else {
            System.out.println("Saldo insuficiente para transferência.");
        }
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta de Investimento ===");
        imprimirInfosComuns();
        imprimirHistoricoTransacoes();
    }

    public double getTaxaRendimento() {
        return taxaRendimento;
    }

    public void setTaxaRendimento(double taxaRendimento) {
        this.taxaRendimento = taxaRendimento;
    }
}

import java.util.Scanner;
 
class Carro {
    private String modelo;
    private String marca;
    private double capacidadeTanque;
 
    public Carro(String modelo, String marca, double capacidadeTanque) {
        this.modelo = modelo;
        this.marca = marca;
        this.capacidadeTanque = capacidadeTanque;
    }
 
    public String getModelo() {
        return modelo;
    }
 
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
 
    public String getMarca() {
        return marca;
    }
 
    public void setMarca(String marca) {
        this.marca = marca;
    }
 
    public double getCapacidadeTanque() {
        return capacidadeTanque;
    }
 
    public void setCapacidadeTanque(double capacidadeTanque) {
        this.capacidadeTanque = capacidadeTanque;
    }
 
    public double calcularCustoEncherTanque(double precoGasolina) {
        return capacidadeTanque * precoGasolina;
    }
}
 
class ContaBancaria {
    private double saldo;
    private String titular;
 
    public ContaBancaria(String titular, double saldoInicial) {
        this.titular = titular;
        this.saldo = Math.max(saldoInicial, 0); // Garante saldo não negativo
    }
 
    public String getTitular() {
        return titular;
    }
 
    public double getSaldo() {
        return saldo;
    }
 
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito realizado! Novo saldo: " + saldo);
        } else {
            System.out.println("Valor inválido para depósito!");
        }
    }
 
    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque realizado! Novo saldo: " + saldo);
        } else {
            System.out.println("Saque não permitido. Verifique o saldo.");
        }
    }
}
 
class Produto {
    private String nome;
    private double preco;
    private int quantidadeEstoque;
 
    public Produto(String nome, double preco, int quantidadeEstoque) {
        this.nome = nome;
        setPreco(preco);
        setQuantidadeEstoque(quantidadeEstoque);
    }
 
    public String getNome() {
        return nome;
    }
 
    public void setNome(String nome) {
        this.nome = nome;
    }
 
    public double getPreco() {
        return preco;
    }
 
    public void setPreco(double preco) {
        if (preco >= 0) {
            this.preco = preco;
        } else {
            System.out.println("Erro: Preço não pode ser negativo.");
        }
    }
 
    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }
 
    public void setQuantidadeEstoque(int quantidadeEstoque) {
        if (quantidadeEstoque >= 0) {
            this.quantidadeEstoque = quantidadeEstoque;
        } else {
            System.out.println("Erro: Quantidade em estoque não pode ser negativa.");
        }
    }
}
 
public class Main {
    public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
 
      
        System.out.println("Digite o modelo do carro:");
        String modelo = scanner.nextLine();
        System.out.println("Digite a marca do carro:");
        String marca = scanner.nextLine();
        System.out.println("Digite a capacidade do tanque do carro:");
        double capacidadeTanque = scanner.nextDouble();
 
        Carro carro = new Carro(modelo, marca, capacidadeTanque);
        System.out.println("Digite o preço da gasolina:");
        double precoGasolina = scanner.nextDouble();
        System.out.println("O custo para encher o tanque é: R$" + carro.calcularCustoEncherTanque(precoGasolina));
 
        
        scanner.nextLine(); // Limpa o buffer
        System.out.println("\nDigite o nome do titular da conta:");
        String titular = scanner.nextLine();
        System.out.println("Digite o saldo inicial:");
        double saldoInicial = scanner.nextDouble();
 
        ContaBancaria conta = new ContaBancaria(titular, saldoInicial);
        System.out.println("Saldo atual: " + conta.getSaldo());
 
        System.out.println("Digite um valor para depositar:");
        double valorDeposito = scanner.nextDouble();
        conta.depositar(valorDeposito);
 
        System.out.println("Digite um valor para sacar:");
        double valorSaque = scanner.nextDouble();
        conta.sacar(valorSaque);
 
        scanner.nextLine(); // Limpa o buffer
        System.out.println("\nDigite o nome do produto:");
        String nomeProduto = scanner.nextLine();
        System.out.println("Digite o preço do produto:");
        double precoProduto = scanner.nextDouble();
        System.out.println("Digite a quantidade em estoque:");
        int quantidadeEstoque = scanner.nextInt();
 
        Produto produto = new Produto(nomeProduto, precoProduto, quantidadeEstoque);
        System.out.println("Produto criado: " + produto.getNome() + ", Preço: R$" + produto.getPreco() + ", Estoque: " + produto.getQuantidadeEstoque());
 
        scanner.close();
    }
}

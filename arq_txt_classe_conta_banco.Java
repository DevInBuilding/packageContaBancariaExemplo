package pacote.programa.banco.java;

public class ContaBanco {
	private long cpf;
	private int numConta;
	private int agConta;
	private double saldo = 999.90; //Saldo demonstrativo
	private double limite = 5000; //Limite demonstrativo
	private int senha = 123456; //Senha de 6 dígitos demonstrativa
	
	/* GETTERS AND SETTERS */
	public long getCpf() {
		return cpf;
	}
	public void setCpf(long cpf) {
		this.cpf = cpf;
	}
	
	public int getAgConta() {
		return agConta;
	}
	public void setAgConta(int agConta) {
		this.agConta = agConta;
	}
	
	public int getNumConta() {
		return numConta;
	}
	public void setNumConta(int numConta) {
		this.numConta = numConta;
	}
	
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public double getLimite() {
		return limite;
	}
	public void setLimite(double limite) {
		this.limite = limite;
	}

	public int getSenha() {
		return senha;
	}
	public void setSenha(int senha) {
		this.senha = senha;
	}
	
	/*      SAQUE       */
	public void sacar (double valorSaque) {
		this.saldo -= valorSaque;
	}
	
	/*     DEPÓSITO     */
	public void depositar (double valorDeposito) {
		this.saldo += valorDeposito;
	}
	
	/*   TRANSFERÊNCIA  */
	public void transferir (ContaBanco destino, double valorTransferencia) {
		this.saldo -= valorTransferencia;
		destino.saldo += valorTransferencia;
		
		System.out.print("\n***COMPROVANTE DE TRANSFERÊNCIA***");
		System.out.print("\nCPF    : " + destino.cpf + 
						 "\nAgência: " + destino.agConta + 
						 "\nConta  : " + destino.numConta + 
						 "\nValor  : R$ " + valorTransferencia + "\n\n");
	}
	
	/*  CONSULTAR SALDO */
	public void consultarSaldo() {
		System.out.println("\n\tSaldo disponível: R$ " + this.saldo);
	}
	
	/* IMPRIMINDO DADOS */
	@Override
	public String toString() {
		return "\n*******DADOS BANCÁRIOS******* " + 
				"\nCPF              : " + this.cpf + 
				"\nAgência          : " + this.agConta + 
				"\nConta            : " + this.numConta + 
				"\nSaldo disponível : R$ " + this.saldo + 
				"\nLimite disponível: R$ " + (this.limite - this.saldo) + "\n";
	}




}
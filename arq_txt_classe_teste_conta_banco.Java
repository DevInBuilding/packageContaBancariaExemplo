package pacote.programa.banco.java;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TestaContaBanco {
	public static void main (String[] args) {
		int senha, opcao, escolha;
		double valorSaque, valorDeposito, valorTransferencia;
		
		ContaBanco cb = new ContaBanco();
		ContaBanco destino = new ContaBanco();
		
		Scanner ler = new Scanner(System.in);
		
		try {
			//Entrada de dados
			do {
				System.out.print("CPF do titular da conta: ");
				cb.setCpf(ler.nextLong());
				
				System.out.print("Agência da conta bancária: ");
				cb.setAgConta(ler.nextInt());
				
				System.out.print("Número da conta bancária: ");
				cb.setNumConta(ler.nextInt());
				
				if(cb.getCpf() <= 0 || cb.getAgConta() <= 0 || cb.getNumConta() <= 0) {
					System.out.println("\nDado(s) inconsistente(s). Verifique-o(s) e tente novamete!\n");
				}
			}while(cb.getCpf() <= 0 || cb.getAgConta() <= 0 || cb.getNumConta() <= 0);
			
			//Senha
			do {
				System.out.print("Senha de 6 dígitos: ");
				senha = ler.nextInt();
				if(senha != cb.getSenha()) {
					System.out.println("\n\tSenha inválida! Tente novamente.\n");
				}
			}while(senha != cb.getSenha());
			
			//Imprimindo os dados da conta
			System.out.println(cb.toString());
			
			//Operações
			do {
				System.out.print("\nDeseja realizar alguma operação (1 - sim/ 2 - não)? ");
				escolha = ler.nextInt();
				if(escolha == 1) {
					System.out.println("\nQual operação deseja realizar (1 - saque/ 2 - depósito/ 3 - transferência/ 4 - consulta de saldo)? ");
					opcao = ler.nextInt();
					if(opcao == 1) {
						System.out.print("\nQuanto você quer sacar? R$ ");
						valorSaque = ler.nextDouble();
						if(valorSaque > 0 && valorSaque <= cb.getSaldo()) {
							do {
								System.out.print("\nDigite sua senha de 6 dígitos: ");
								senha = ler.nextInt();
								if(senha != cb.getSenha()) {
									System.out.println("\n\tSenha inválida! Tente novamente.\n");
								} else {
									System.out.print("\n\tSaque de R$ " + valorSaque + " autorizado.\n");
									cb.sacar(valorSaque);
								}
							}while(senha != cb.getSenha());
						} else if(valorSaque > cb.getSaldo()) {
							System.out.print("\n\tSaldo insuficiente!\n\n");
						} else {
							System.out.println("\n\tValor Inválido!\n");
						}
					} else if (opcao == 2) {
						System.out.print("\nQual será o valor do depósito? R$ ");
						valorDeposito = ler.nextDouble();
						if(valorDeposito > 0 && valorDeposito <= (cb.getLimite() - cb.getSaldo())) {
							System.out.print("\n\tDepósito de R$ " + valorDeposito + " realizado.\n");
							cb.depositar(valorDeposito);
						} else if(valorDeposito > (cb.getLimite() - cb.getSaldo())) {
							System.out.println("\n\tValor de depósito acima do limite de conta!\n");
						} else {
							System.out.println("\n\tValor Inválido!\n");
						}
					} else if (opcao == 3) {
						System.out.print("\nQual será o valor da transfência? R$ ");
						valorTransferencia = ler.nextDouble();
						if(valorTransferencia > 0 && valorTransferencia <= cb.getSaldo()) {
							System.out.print("\nDigite o CPF do destinatário: ");
							destino.setCpf(ler.nextLong());
							System.out.print("Agência do destinatário: ");
							destino.setAgConta(ler.nextInt());
							System.out.print("Conta do destinatário: ");
							destino.setNumConta(ler.nextInt());
							do {
								System.out.print("\nDigite sua senha de 6 dígitos: ");
								senha = ler.nextInt();
								if(senha != cb.getSenha()) {
									System.out.println("\n\tSenha inválida! Tente novamente.\n");
								} else {
									System.out.println("\n\tTransferência de R$ " + valorTransferencia + " realizada.\n");
									cb.transferir(destino, valorTransferencia);
								}
							}while(senha != cb.getSenha());
						} else if(valorTransferencia > cb.getSaldo()) {
							System.out.print("\n\tSaldo insuficiente!\n");
						} else {
							System.out.println("\n\tValor Inválido!\n");
						}
					} else if (opcao == 4) {
						cb.consultarSaldo();
					} else {
						System.out.println("\n\tOpção Inválida! Tente novamente.");
					}
				}
				else if(escolha == 2) {
					System.out.println("\n\tFoi bom ter você conosco!\n");
				}
			}while(escolha != 2);
		}
		
		catch(InputMismatchException inputMismatchException) {
			System.err.println("\nERRO: " + inputMismatchException);
		}
		
		finally {
			System.out.println("\nENCERRANDO O PROGRAMA...\n");
		}
	}
}
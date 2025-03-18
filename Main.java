import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArvoreBinariaBusca contatos = new ArvoreBinariaBusca();
		
		System.out.println("Bem vindo ao nosso gerenciador de contatos");
		System.out.println("Escolha a opção desejada");
		int opc = sc.nextInt();
	    try {
			opc = sc.nextInt();				
		} catch (Exception e) {
			sc.next().charAt(0);
			System.out.println("Carácter inválido, por favor, use um número.\nExcessão: " + e);
		}

		do {
			switch(opc){
				case 1: 
					System.out.println("Digite o novo contato");
					System.out.print("Nome: ");
					String nome = sc.nextLine();
					System.out.println("\nDigite o telefone (xxxxxxxxx): ");
					long tell = sc.nextLong();
					System.out.println("\nDigite o código do " + nome);
					int cod = sc.nextInt();	
					if(contatos.existe(cod)) {
						System.out.println("Código já existe. Escolha outra opção ou digite novamente");
						break;
					}else{
						contatos.inserir(cod, nome, tell);
					}
				break;
				case 2:
					System.out.println("Por favor, insíra o código do contato que quer encontrar:\n > ");
					cod = 0;
					try {
						cod = sc.nextInt();				
					} catch (Exception e) {
						sc.next().charAt(0);
						System.out.println("Código inválido, por favor, use uma entrada válida.\nExcessão: " + e);
						break;
					}
					contatos.buscar(cod);
				break;
				case 3:
				break;
				case 4:
					System.out.println("Por favor, insíra o código do contato que quer remover:\n > ");
					cod = 0;
					try {
						cod = sc.nextInt();				
					} catch (Exception e) {
						sc.next().charAt(0);
						System.out.println("Código inválido, por favor, use uma entrada válida.\nExcessão: " + e);
						break;
					}
					contatos.buscar(cod);
				break;
				case 5:
				break;
				case 6:
				break;
				case 7:
				break;
				default:
				break;
			}
			
		}while(opc != 7);
		
		sc.close();

	}

}

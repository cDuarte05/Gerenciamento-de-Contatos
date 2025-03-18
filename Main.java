import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArvoreBinariaBusca contatos = new ArvoreBinariaBusca();
		int opc = 0;

		do {
			System.out.println("Bem vindo ao nosso gerenciador de contatos");
			System.out.println("Escolha a opção desejada: ");
			System.out.println("Opção 1: Adicionar um novo contato");
			System.out.println("Opção 2: Pesquisar por um contato pelo código");
			System.out.println("Opção 3: Listar todos os contatos em ordem alfabética");
			System.out.println("Opção 4: Remover um contato por código");
			System.out.println("Opção 5: Importar CSV");
			System.out.println("Opção 6: Exibir estatísticas do sistema: ");
			System.out.println("Opção 7: Sair");
			try {
				opc = sc.nextInt();				
			} catch (Exception e) {
				sc.next().charAt(0);
				System.out.println("Carácter inválido, por favor, use um número.\nExcessão: " + e);
			} 
			switch(opc){
				case 1: 
					System.out.println("Digite o nome do novo contato: ");
					System.out.print("Nome: ");
					sc.nextLine();
					String nome = sc.nextLine();
					System.out.println("Digite o telefone (xxxxxxxxx): ");
					long tell = sc.nextLong();
					System.out.println("\nDigite o código do " + nome);
					int cod = sc.nextInt();	
					if(contatos.existe(cod)) {
						System.out.println("Código já existe. Escolha outra opção ou digite novamente");
						break;
					}else{
						contatos.inserir(cod, nome, tell);
						break;
					}
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

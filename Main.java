import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArvoreBinariaBusca contatos = new ArvoreBinariaBusca();
		int opc = 0;
		long tell = 0;
		int cod = 0;
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
					System.out.println("Digite o nome do novo contato:");
					System.out.print("Nome: ");
					sc.nextLine();
					String nome = sc.nextLine();
					System.out.println("\nDigite o telefone (xxxxxxxxx): ");
					try {
						tell = sc.nextLong();	
					} catch (Exception e) {
						sc.next().charAt(0);
						System.out.println("Carácter inválido, por favor, use um número.\nExcessão: " + e);
					}
					System.out.println("Digite o código do " + nome);
					try {
						cod = sc.nextInt();		
					} catch (Exception e) {
						sc.next().charAt(0);
						System.out.println("Carácter inválido, por favor, use um número.\nExcessão: " + e);
					}
					
					if(contatos.existe(cod)) {
						System.out.println("Código já existe. Escolha outra opção ou digite novamente");
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
					No buscado = contatos.buscar(cod);
					if (buscado == null) {
						System.out.println("Código não presente na árvore de contatos.");
					} else {
						System.out.println("Nome: " + buscado.nome);
						System.out.println("Telefone: " + buscado.tell);
						System.out.println("Código: " + buscado.cod);
					}
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
					contatos.remover(cod);
				break;
				case 5:
				break;
				case 6:
					System.out.println("Estátisticas da árvore");
					int numeroNos = 0;
					int alturaArvore = 0;
					int quantidadeFolhas = 0;
					
					numeroNos = contatos.contarNos();
					alturaArvore = contatos.calcularAlturaArvore();
					quantidadeFolhas = contatos.contarNos();
					System.out.println("Nuúmero de nós: " + numeroNos);
					System.out.println("Altura da árvore: "+ alturaArvore);
					System.out.println("Quantidade de folhas: "+ quantidadeFolhas);
				break;
				case 7:
					System.out.println("Finalizando...");
				break;
				default:
				break;
			}
			
		}while(opc != 7);
		
		sc.close();

	}

}
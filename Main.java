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
				break;
				case 2:
				break;
				case 3:
				break;
				case 4:
				break;
				case 5:
				break;
				case 6:
				break;
				default:
				break;
			}
			
		}while(opc != 6);
		
		sc.close();

	}

}

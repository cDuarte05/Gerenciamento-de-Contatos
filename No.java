
public class No {
    int cod;
    String nome;
    long tell;
    No esquerdo;
    No direito;

	public No(int cod, String nome, long tell) {
		this.cod = cod;
		this.nome = nome;
		this.tell = tell;
		this.esquerdo = null;
		this.direito = null;
	}

	public No (String nome) {
		this.nome = nome;
		this.esquerdo = null;
		this.direito = null;
	}
}
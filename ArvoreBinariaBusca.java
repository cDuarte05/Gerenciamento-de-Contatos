import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class ArvoreBinariaBusca {
    No raiz;

    public ArvoreBinariaBusca() {
        this.raiz = null;
    }

    public void inserir(int cod, String nome, long tell) {
        if (estaVazia()) {
            raiz = new No(cod, nome, tell);
            return;
        }

        No atual = raiz;
        No pai = null;

        // Percorre a árvore até encontrar a posição de inserção
        while (atual != null) {
            pai = atual;
            if (cod < atual.cod) {
                atual = atual.esquerdo;
            } else if (cod > atual.cod) {
                atual = atual.direito;
            } else {
                return; // Valor já existe, ignora
            }
        }

        // Após encontrar a posição (atual == null), insere o novo nó
        No novoNo = new No(cod, nome, tell);
        if (cod < pai.cod) {
            pai.esquerdo = novoNo;
        } else {
            pai.direito = novoNo;
        }
    }

    public void inserirTexto (String nome) {
        if (estaVazia()) {
            raiz = new No(nome);
            return;
        }

        No atual = raiz;
        No pai = null;

        // Percorre a árvore até encontrar a posição de inserção
        while (atual != null) {
            pai = atual;
            if (nome.compareToIgnoreCase(atual.nome) < 0) {
                atual = atual.esquerdo;
            } else if (nome.compareToIgnoreCase(atual.nome) > 0) {
                atual = atual.direito;
            } else {
                return; // Valor já existe, ignora
            }
        }

        // Após encontrar a posição (atual == null), insere o novo nó
        No novoNo = new No(nome);
        if (nome.compareToIgnoreCase(pai.nome) < 0) {
            pai.esquerdo = novoNo;
        } else {
            pai.direito = novoNo;
        }
    }

    public No buscar(int valorBuscado) {
        No atual = raiz;
        while (atual != null) {
            if (valorBuscado == atual.cod)
                return atual;
            else if (valorBuscado < atual.cod)
                atual = atual.esquerdo;
            else
                atual = atual.direito;
        }
        return null;
    }

    public boolean existe(int valor) {
        return (buscar(valor) != null);
    }

    public void remover(int valorRemover) {

        if (estaVazia()) {
            return;
        }

        No atual = raiz;
        No pai = null;

        // Encontrar o nó a ser removido e seu pai
        while (atual != null && atual.cod != valorRemover) {
            pai = atual;
            if (valorRemover < atual.cod) {
                atual = atual.esquerdo;
            } else {
                atual = atual.direito;
            }
        }

        // Se o nó não foi encontrado, retorna
        if (atual == null) {
            return;
        }

        // Caso 1 e 2: Nó sem filhos ou com apenas um filho
        if (atual.esquerdo == null || atual.direito == null) {
            No filho;
            if (atual.esquerdo != null) {
                filho = atual.esquerdo;
            } else {
                filho = atual.direito;
            }
            // Se o nó a ser removido é a raiz
            if (pai == null) {
                raiz = filho;
            } else {
                // Conecta o pai ao filho do nó removido
                if (atual == pai.esquerdo) {
                    pai.esquerdo = filho;
                } else {
                    pai.direito = filho;
                }
            }
        }
        // Caso 3: Nó com dois filhos
        else {
            // Encontrar o sucessor (menor valor da subárvore direita)
            No paiSucessor = atual;
            No sucessor = atual.direito;
            
            while (sucessor.esquerdo != null) {
                paiSucessor = sucessor;
                sucessor = sucessor.esquerdo;
            }

            // Copiar o valor do sucessor para o nó atual
            atual.cod = sucessor.cod;

            // Remover o sucessor (que tem no máximo um filho direito)
            if (paiSucessor == atual) {
                paiSucessor.direito = sucessor.direito;
            } else {
                paiSucessor.esquerdo = sucessor.direito;
            }
        }
    }

    public void removerTexto(String nomeRemover) {

        if (estaVazia()) {
            return;
        }

        No atual = raiz;
        No pai = null;

        // Encontrar o nó a ser removido e seu pai
        while (atual != null && atual.nome != nomeRemover) {
            pai = atual;
            if (nomeRemover.compareToIgnoreCase(atual.nome) < 0) {
                atual = atual.esquerdo;
            } else {
                atual = atual.direito;
            }
        }

        // Se o nó não foi encontrado, retorna
        if (atual == null) {
            return;
        }

        // Caso 1 e 2: Nó sem filhos ou com apenas um filho
        if (atual.esquerdo == null || atual.direito == null) {
            No filho;
            if (atual.esquerdo != null) {
                filho = atual.esquerdo;
            } else {
                filho = atual.direito;
            }
            // Se o nó a ser removido é a raiz
            if (pai == null) {
                raiz = filho;
            } else {
                // Conecta o pai ao filho do nó removido
                if (atual == pai.esquerdo) {
                    pai.esquerdo = filho;
                } else {
                    pai.direito = filho;
                }
            }
        }
        // Caso 3: Nó com dois filhos
        else {
            // Encontrar o sucessor (menor valor da subárvore direita)
            No paiSucessor = atual;
            No sucessor = atual.direito;
            
            while (sucessor.esquerdo != null) {
                paiSucessor = sucessor;
                sucessor = sucessor.esquerdo;
            }

            // Copiar o valor do sucessor para o nó atual
            atual.cod = sucessor.cod;

            // Remover o sucessor (que tem no máximo um filho direito)
            if (paiSucessor == atual) {
                paiSucessor.direito = sucessor.direito;
            } else {
                paiSucessor.esquerdo = sucessor.direito;
            }
        }
    }

    public boolean estaVazia() {
        return raiz == null;
    }

    public int contarNos() {
        return contarNosRecursivo(raiz);
    }
 
    private int contarNosRecursivo(No atual) {
        if (atual == null) {
            return 0;
        }
        return 1 + contarNosRecursivo(atual.esquerdo) + contarNosRecursivo(atual.direito);
    }

    int contador;
    
    public int contarFolhas(){
        contador = 0;
        contarQuantitadeFolhas(raiz);
        return contador;
    } 
    private void contarQuantitadeFolhas(No atual){
        if(atual == null){
            return;
        }
        contarQuantitadeFolhas(atual.esquerdo);               
        contarQuantitadeFolhas(atual.direito);
        if(atual.esquerdo == null && atual.direito == null){
            contador++;
        }
    }
    

    public int calcularAlturaArvore() {
        return calcularAlturaRecursivo(raiz);
    }

    private int calcularAlturaRecursivo(No atual) {
        if (atual == null) {
            return -1;
        }
        int alturaEsquerda = calcularAlturaRecursivo(atual.esquerdo);
        int alturaDireita = calcularAlturaRecursivo(atual.direito);
        return 1 + Math.max(alturaEsquerda, alturaDireita);
    }



    public int calcularAlturaNo(int valor) {
        No no = buscar(valor);
        if (no == null) {
            return -1;
        }
        return calcularAlturaRecursivo(no);
    }

    public int calcularProfundidadeArvore() {
        return calcularAlturaArvore();
    }

    public int calcularProfundidadeNo(int valor) {
        return calcularProfundidadeRecursivo(raiz, valor, 0);
    }

    private int calcularProfundidadeRecursivo(No atual, int valor, int profundidade) {
        if (atual == null) {
            return -1;
        }
        if (atual.cod == valor) {
            return profundidade;
        }
        if (valor < atual.cod) {
            return calcularProfundidadeRecursivo(atual.esquerdo, valor, profundidade + 1);
        }
        return calcularProfundidadeRecursivo(atual.direito, valor, profundidade + 1);
    }

    public String imprimirPreOrdem() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        
        imprimirPreOrdemRecursivo(raiz, sb);
        
        if (sb.length() > 1) {
            sb.delete(sb.length() - 2, sb.length()); // Remove a última vírgula e espaço
        }
        sb.append("]");
        return sb.toString();
    }

    private void imprimirPreOrdemRecursivo(No atual, StringBuilder sb) {
        if (atual != null) {
            sb.append(atual.cod).append(", ");
            imprimirPreOrdemRecursivo(atual.esquerdo, sb);
            imprimirPreOrdemRecursivo(atual.direito, sb);
        }
    }

    public String imprimirPosOrdem() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        
        imprimirPosOrdemRecursivo(raiz, sb);
        
        if (sb.length() > 1) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append("]");
        return sb.toString();
    }

    private void imprimirPosOrdemRecursivo(No atual, StringBuilder sb) {
        if (atual != null) {
            imprimirPosOrdemRecursivo(atual.esquerdo, sb);
            imprimirPosOrdemRecursivo(atual.direito, sb);
            sb.append(atual.cod).append(", ");
        }
    }

    public String imprimirInOrdem() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        
        imprimirInOrdemRecursivo(raiz, sb);
        
        if (sb.length() > 1) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append("]");
        return sb.toString();
    }

    private void imprimirInOrdemRecursivo(No atual, StringBuilder sb) {
        if (atual != null) {
            imprimirInOrdemRecursivo(atual.esquerdo, sb);
            sb.append(atual.cod).append(", ");
            imprimirInOrdemRecursivo(atual.direito, sb);
        }
    }

    public String imprimirInOrdemNomes() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        
        imprimirInOrdemRecursivoNomes(raiz, sb);
        
        if (sb.length() > 1) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append("]");
        return sb.toString();
    }

    private void imprimirInOrdemRecursivoNomes(No atual, StringBuilder sb) {
        if (atual != null) {
            imprimirInOrdemRecursivoNomes(atual.esquerdo, sb);
            sb.append(atual.nome).append(", ");
            imprimirInOrdemRecursivoNomes(atual.direito, sb);
        }
    }

    public void imprimirArvoreTexto() {
        if (estaVazia()) {
            System.out.println("Árvore vazia");
        } else {
            imprimirArvoreTextoRecursivo(raiz);
        }
    }

    private void imprimirArvoreTextoRecursivo(No atual) {
        if (atual == null) {
            return;
        }
        imprimirArvoreTextoRecursivo(atual.direito);
        System.out.println(atual.cod + " - " + atual.nome + " - " + atual.tell);
        imprimirArvoreTextoRecursivo(atual.esquerdo);

    }

    //CSV árvore contatos
    public void importarCSV(String caminhoArquivo,ArvoreBinariaBusca nomes) {
        try  {
            Reader reader = new InputStreamReader(new FileInputStream(caminhoArquivo), "UTF-8");
            BufferedReader br = new BufferedReader(reader);
            String linha;
            br.readLine(); // Pula o cabeçalho do CSV
    
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");
                if (dados.length == 3) {
                    int cod = Integer.parseInt(dados[0].trim());
                    String nome = dados[1].trim();
                    long tell = Long.parseLong(dados[2].trim());
                    inserir(cod, nome, tell);
                    nomes.inserirTexto(nome);
                }
            }
    
            System.out.println("Importação concluída com sucesso!");
            br.close();
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Erro ao converter os dados do arquivo: " + e.getMessage());
        }
    }

}

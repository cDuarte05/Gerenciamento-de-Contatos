import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArvoreBinariaBuscaTeste {
    private ArvoreBinariaBusca arvore;

    @Before
    public void configurar() {
        arvore = new ArvoreBinariaBusca();
    }

    @Test
    public void testarEstaVaziaArvoreNova() {
        assertTrue(arvore.estaVazia());
    }

    @Test
    public void testarImprimirArvoreTexto() {
        arvore.inserir(15,"Nome1",123);
        arvore.inserir(16,"Nome2",123);
        arvore.inserir(20,"Nome3",123);
        arvore.inserir(23,"Nome4",123);
        arvore.inserir(18,"Nome5",123);
        arvore.inserir(5,"Nome6",123);
        arvore.inserir(3,"Nome7",123);
        arvore.inserir(12,"Nome8",123);
        arvore.inserir(13,"Nome9",123);
        arvore.inserir(10,"Nome10",123);
        arvore.inserir(6,"Nome11",123);
        arvore.inserir(7,"Nome12",123);
        arvore.imprimirArvoreTexto();
    }

    @Test
    public void testarEstaVaziaAposInsercao() {
        arvore.inserir(10,"Nome",123);
        assertFalse(arvore.estaVazia());
    }

    @Test
    public void testarEstaVaziaAposRemocaoUnicoNo() {
        arvore.inserir(10,"Nome",123);
        arvore.remover(10);
        assertTrue(arvore.estaVazia());
    }

    @Test
    public void testarInserirEBuscarUnicoNo() {
        arvore.inserir(5,"Nome",123);
        assertTrue(arvore.existe(5));
        assertFalse(arvore.existe(10));
    }

    @Test
    public void testarInserirEBuscarMultiplosNos() {
        arvore.inserir(5,"Nome1",123);
        arvore.inserir(3,"Nome2",123);
        arvore.inserir(7,"Nome3",123);
        assertTrue(arvore.existe(5));
        assertTrue(arvore.existe(3));
        assertTrue(arvore.existe(7));
        assertFalse(arvore.existe(4));
    }

    @Test
    public void testarInserirDuplicado() {
        arvore.inserir(5,"Nome",123);
        arvore.inserir(5,"Nome",123); // Não deve alterar a arvore
        assertEquals(1, arvore.contarNos());
        assertTrue(arvore.existe(5));
    }

    @Test
    public void testarBuscarEmArvoreVazia() {
        assertFalse(arvore.existe(1));
    }

    @Test
    public void testarRemoverNoFolha() {
        arvore.inserir(5,"Nome1",123);
        arvore.inserir(3,"Nome2",123);
        arvore.remover(3);
        assertTrue(arvore.existe(5));
        assertFalse(arvore.existe(3));
        assertEquals(1, arvore.contarNos());
    }

    @Test
    public void testarRemoverNoComUmFilho() {
        arvore.inserir(5,"Nome1",123);
        arvore.inserir(3,"Nome2",123);
        arvore.inserir(4,"Nome3",123);
        arvore.remover(3);
        assertTrue(arvore.existe(5));
        assertTrue(arvore.existe(4));
        assertFalse(arvore.existe(3));
        assertEquals(2, arvore.contarNos());
    }

    @Test
    public void testarRemoverNoComDoisFilhos() {
        arvore.inserir(5,"Nome1",123);
        arvore.inserir(3,"Nome2",123);
        arvore.inserir(7,"Nome3",123);
        arvore.inserir(6,"Nome4",123);
        arvore.inserir(8,"Nome5",123);
        arvore.remover(7);
        assertTrue(arvore.existe(5));
        assertTrue(arvore.existe(3));
        assertTrue(arvore.existe(6));
        assertTrue(arvore.existe(8));
        assertFalse(arvore.existe(7));
        assertEquals(4, arvore.contarNos());
    }

    @Test
    public void testarRemoverNoComDoisFilhosSlide() {
        arvore.inserir(15,"Nome1",123);
        arvore.inserir(16,"Nome2",123);
        arvore.inserir(20,"Nome3",123);
        arvore.inserir(23,"Nome4",123);
        arvore.inserir(18,"Nome5",123);
        arvore.inserir(5,"Nome6",123);
        arvore.inserir(3,"Nome7",123);
        arvore.inserir(12,"Nome8",123);
        arvore.inserir(13,"Nome9",123);
        arvore.inserir(10,"Nome10",123);
        arvore.inserir(6,"Nome11",123);
        arvore.inserir(7,"Nome12",123);

        arvore.remover(5);
        assertFalse(arvore.existe(5));
        assertTrue(arvore.existe(6));
        assertTrue(arvore.existe(7));
        assertEquals(11, arvore.contarNos());
        assertEquals(6, arvore.raiz.esquerdo.cod);
    }

    @Test
    public void testarRemoverRaizUnica() {
        arvore.inserir(5,"Nome",123);
        arvore.remover(5);
        assertFalse(arvore.existe(5));
        assertEquals(0, arvore.contarNos());
    }

    @Test
    public void testarRemoverNaoExistente() {
        arvore.inserir(5,"Nome",123);
        arvore.remover(10);
        assertTrue(arvore.existe(5));
        assertEquals(1, arvore.contarNos());
    }

    @Test
    public void testarContarNosArvoreVazia() {
        assertEquals(0, arvore.contarNos());
    }

    @Test
    public void testarContarNosUmNo() {
        arvore.inserir(5,"Nome",123);
        assertEquals(1, arvore.contarNos());
    }

    @Test
    public void testarContarNosArvoreGrande() {
        arvore.inserir(10,"Nome1",123);
        arvore.inserir(5,"Nome2",123);
        arvore.inserir(15,"Nome3",123);
        arvore.inserir(3,"Nome4",123);
        arvore.inserir(7,"Nome5",123);
        assertEquals(5, arvore.contarNos());
    }

    @Test
    public void testarCalcularAlturaArvoreVazia() {
        assertEquals(-1, arvore.calcularAlturaArvore());
    }

    @Test
    public void testarCalcularAlturaArvoreUmNo() {
        arvore.inserir(5,"Nome",123);
        assertEquals(0, arvore.calcularAlturaArvore());
    }

    @Test
    public void testarCalcularAlturaArvoreBalanceada() {
        arvore.inserir(5,"Nome1",123);
        arvore.inserir(3,"Nome2",123);
        arvore.inserir(7,"Nome3",123);
        assertEquals(1, arvore.calcularAlturaArvore());
    }

    @Test
    public void testarCalcularAlturaArvoreDesbalanceada() {
        arvore.inserir(10,"Nome1",123);
        arvore.inserir(5,"Nome2",123);
        arvore.inserir(3,"Nome3",123);
        arvore.inserir(1,"Nome4",123);
        assertEquals(3, arvore.calcularAlturaArvore());
    }

    @Test
    public void testarCalcularAlturaNoInexistente() {
        assertEquals(-1, arvore.calcularAlturaNo(5));
    }

    @Test
    public void testarCalcularAlturaNoRaiz() {
        arvore.inserir(5,"Nome1",123);
        arvore.inserir(3,"Nome2",123);
        arvore.inserir(7,"Nome3",123);
        assertEquals(1, arvore.calcularAlturaNo(5));
    }

    @Test
    public void testarCalcularAlturaNoFolha() {
        arvore.inserir(5,"Nome1",123);
        arvore.inserir(3,"Nome2",123);
        assertEquals(0, arvore.calcularAlturaNo(3));
    }

    @Test
    public void testarCalcularAlturaNoIntermediario() {
        arvore.inserir(10,"Nome1",123);
        arvore.inserir(5,"Nome2",123);
        arvore.inserir(3,"Nome3",123);
        arvore.inserir(7,"Nome4",123);
        assertEquals(1, arvore.calcularAlturaNo(5));
    }

    @Test
    public void testarCalcularProfundidadeArvoreVazia() {
        assertEquals(-1, arvore.calcularProfundidadeArvore());
    }

    @Test
    public void testarCalcularProfundidadeArvoreUmNo() {
        arvore.inserir(5,"Nome",123);
        assertEquals(0, arvore.calcularProfundidadeArvore());
    }

    @Test
    public void testarCalcularProfundidadeArvoreDesbalanceada() {
        arvore.inserir(10,"Nome1",123);
        arvore.inserir(5,"Nome2",123);
        arvore.inserir(3,"Nome3",123);
        arvore.inserir(1,"Nome4",123);
        assertEquals(3, arvore.calcularProfundidadeArvore());
    }

    @Test
    public void testarCalcularProfundidadeNoInexistente() {
        assertEquals(-1, arvore.calcularProfundidadeNo(5));
    }

    @Test
    public void testarCalcularProfundidadeNoRaiz() {
        arvore.inserir(5,"Nome",123);
        assertEquals(0, arvore.calcularProfundidadeNo(5));
    }

    @Test
    public void testarCalcularProfundidadeNoFolha() {
        arvore.inserir(5,"Nome1",123);
        arvore.inserir(3,"Nome2",123);
        arvore.inserir(1,"Nome3",123);
        assertEquals(2, arvore.calcularProfundidadeNo(1));
    }

    @Test
    public void testarCalcularProfundidadeNoIntermediario() {
        arvore.inserir(10,"Nome1",123);
        arvore.inserir(5,"Nome2",123);
        arvore.inserir(3,"Nome3",123);
        assertEquals(1, arvore.calcularProfundidadeNo(5));
    }

    @Test
    public void testarImprimirPreOrdemArvoreVazia() {
        assertEquals("[]", arvore.imprimirPreOrdem());
    }

    @Test
    public void testarImprimirPreOrdemUmNo() {
        arvore.inserir(10,"Nome",123);
        assertEquals("[10]", arvore.imprimirPreOrdem());
    }

    @Test
    public void testarImprimirPreOrdem() {
        arvore.inserir(10,"Nome1",123);
        arvore.inserir(5,"Nome2",123);
        arvore.inserir(15,"Nome3",123);
        arvore.inserir(3,"Nome4",123);
        arvore.inserir(7,"Nome5",123);
        String esperado = "[10, 5, 3, 7, 15]";
        assertEquals(esperado, arvore.imprimirPreOrdem());
    }

    @Test
    public void testarImprimirPosOrdemArvoreVazia() {
        assertEquals("[]", arvore.imprimirPosOrdem());
    }

    @Test
    public void testarImprimirPosOrdemUmNo() {
        arvore.inserir(10,"Nome",123);
        assertEquals("[10]", arvore.imprimirPosOrdem());
    }

    @Test
    public void testarImprimirPosOrdem() {
        arvore.inserir(10,"Nome1",123);
        arvore.inserir(5,"Nome2",123);
        arvore.inserir(15,"Nome3",123);
        arvore.inserir(3,"Nome4",123);
        arvore.inserir(7,"Nome5",123);
        String esperado = "[3, 7, 5, 15, 10]";
        assertEquals(esperado, arvore.imprimirPosOrdem());
    }

    @Test
    public void testarImprimirInOrdemArvoreVazia() {
        assertEquals("[]", arvore.imprimirInOrdem());
    }

    @Test
    public void testarImprimirInOrdemUmNo() {
        arvore.inserir(10,"Nome",123);
        assertEquals("[10]", arvore.imprimirInOrdem());
    }

    @Test
    public void testarImprimirInOrdem() {
        arvore.inserir(10,"Nome1",123);
        arvore.inserir(5,"Nome2",123);
        arvore.inserir(15,"Nome3",123);
        arvore.inserir(3,"Nome4",123);
        arvore.inserir(7,"Nome5",123);
        String esperado = "[3, 5, 7, 10, 15]";
        assertEquals(esperado, arvore.imprimirInOrdem());
    }

    @Test
    public void testarInsercaoRemocaoComplexa() {
        arvore.inserir(50,"Nome1",123);
        arvore.inserir(30,"Nome2",123);
        arvore.inserir(70,"Nome3",123);
        arvore.inserir(20,"Nome4",123);
        arvore.inserir(40,"Nome5",123);
        arvore.inserir(60,"Nome6",123);
        arvore.inserir(80,"Nome7",123);
        arvore.remover(30);
        assertEquals(6, arvore.contarNos());
        assertFalse(arvore.existe(30));
        assertTrue(arvore.existe(40));
        assertEquals(2, arvore.calcularAlturaNo(50));
        assertEquals(1, arvore.calcularProfundidadeNo(70));
    }

    @Test
    public void testarArvoreComplexaAposRemocao() {
        arvore.inserir(10,"Nome1",123);
        arvore.inserir(5,"Nome2",123);
        arvore.inserir(15,"Nome3",123);
        arvore.inserir(3,"Nome4",123);
        arvore.inserir(1,"Nome5",123);
        arvore.remover(15);
        assertEquals(4, arvore.contarNos());
        assertEquals(3, arvore.calcularAlturaArvore());
        assertEquals(3, arvore.calcularProfundidadeNo(1));
    }

    @Test
    public void testarMultiplasRemocoes() {
        arvore.inserir(10,"Nome1",123);
        arvore.inserir(5,"Nome2",123);
        arvore.inserir(15,"Nome3",123);
        arvore.inserir(3,"Nome4",123);
        arvore.inserir(7,"Nome5",123);
        arvore.remover(5);
        arvore.remover(15);
        assertEquals(3, arvore.contarNos());
        assertTrue(arvore.existe(10));
        assertTrue(arvore.existe(3));
        assertTrue(arvore.existe(7));
        assertEquals(2, arvore.calcularAlturaArvore());
    }
    
    //Testes para as funções de para a árvore de nomes
    //Tem que copiar e adaptar testes de inserção, remoção, e print InOrdem
}
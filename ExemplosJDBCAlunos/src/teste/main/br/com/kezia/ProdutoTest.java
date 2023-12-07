package br.com.kezia;


import br.com.kezia.dao.IProdutoDAO;
import br.com.kezia.dao.ProdutoDAO;
import br.com.kezia.domain.Produto;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProdutoTest {

    @Test
    public void cadastrarTest() throws Exception {

        IProdutoDAO dao = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("01");
        produto.setNome("Bolsa");

        Integer qtd = dao.cadastrar(produto);
        assertTrue(qtd == 1);

        Produto produtoBD = dao.consultar(produto.getCodigo());
        assertNotNull(produtoBD);
        assertNotNull(produtoBD.getId());
        assertEquals(produto.getCodigo(), produtoBD.getCodigo());
        assertEquals(produto.getNome(), produtoBD.getNome());

        Integer qtdDel = dao.excluir(produtoBD);
        assertNotNull(qtdDel);
    }
}

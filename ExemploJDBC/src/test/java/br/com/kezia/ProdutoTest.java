package br.com.kezia;

import br.com.kezia.dao.generic.jdbc.dao.ClienteDAO;
import br.com.kezia.dao.generic.jdbc.dao.IClienteDAO;
import br.com.kezia.dao.generic.jdbc.dao.IProdutoDAO;
import br.com.kezia.dao.generic.jdbc.dao.ProdutoDAO;
import br.com.kezia.domain.Produto;
import br.com.kezia.domin.Cliente;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class ProdutoTest {

    private IProdutoDAO produtoDAO;


    @Test
    public void cadastrarTest() throws Exception {
        produtoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("10");
        produto.setNome("Rebeca Moraes");
        Integer countCad = produtoDAO.cadastrar(produto);
        assertTrue(countCad == 1);

        Produto produtoDB = produtoDAO.buscar("10");
        assertNotNull(produtoDB);
        assertEquals(produto.getCodigo(), produtoDB.getCodigo());
        assertEquals(produto.getNome(), produtoDB.getNome());

        Integer countDel = produtoDAO.excluir(produtoDB);
        assertTrue(countDel == 1);
    }

    @Test
    public void buscarTest() throws Exception {
        produtoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("10");
        produto.setNome("Rebeca Moraes");
        Integer countCad = produtoDAO.cadastrar(produto);
        assertTrue(countCad == 1);

        Produto produtoBD = produtoDAO.buscar("10");
        assertNotNull(produtoBD);
        assertEquals(produto.getCodigo(), produtoBD.getCodigo());
        assertEquals(produto.getNome(), produtoBD.getNome());

        Integer countDel = produtoDAO.excluir(produtoBD);
        assertTrue(countDel == 1);
    }

    @Test
    public void excluirTest() throws Exception {
        produtoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("10");
        produto.setNome("Rebeca Moraes");
        Integer countCad = produtoDAO.cadastrar(produto);
        assertTrue(countCad == 1);

        Produto produtoDB = produtoDAO.buscar("10");
        assertNotNull(produtoDB);
        assertEquals(produto.getCodigo(), produtoDB.getCodigo());
        assertEquals(produto.getNome(), produtoDB.getNome());

        Integer countDel = produtoDAO.excluir(produtoDB);
        assertTrue(countDel == 1);
    }

    @Test
    public void buscarTodosTest() throws Exception {
        produtoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("10");
        produto.setNome("");
        Integer countCad = produtoDAO.cadastrar(produto);
        assertTrue(countCad == 1);

        Produto produtos = new Produto();
        produtos.setCodigo("20");
        produtos.setNome("Teste");
        Integer countCad2 = produtoDAO.cadastrar(produtos);
        assertTrue(countCad2 == 1);

        List<Produto> list = produtoDAO.buscarTodos();
        assertNotNull(list);
        assertEquals(2, list.size());

        int countDel = 0;
        for (Produto cli : list) {
            produtoDAO.excluir(cli);
            countDel++;
        }
        assertEquals(list.size(), countDel);

        list = produtoDAO.buscarTodos();
        assertEquals(list.size(), 0);

    }

    @Test
    public void atualizarTest() throws Exception {
        produtoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("10");
        produto.setNome("");
        Integer countCad = produtoDAO.cadastrar(produto);
        assertTrue(countCad == 1);

        Produto produtoBD = produtoDAO.buscar("10");
        assertNotNull(produtoBD);
        assertEquals(produto.getCodigo(), produtoBD.getCodigo());
        assertEquals(produto.getNome(), produtoBD.getNome());

        produtoBD.setCodigo("20");
        produtoBD.setNome("Outro nome");
        Integer countUpdate = produtoDAO.atualizar(produtoBD);
        assertTrue(countUpdate == 1);

        Produto produtoBD1 = produtoDAO.buscar("10");
        assertNull(produtoBD1);

        Produto produtoBD2 = produtoDAO.buscar("20");
        assertNotNull(produtoBD2);
        assertEquals(produtoDAO.getId(), produtoBD2.getId());
        assertEquals(produtoDAO.getCodigo(), produtoBD2.getCodigo());
        assertEquals(produtoDAO.getNome(), produtoBD2.getNome());

        List<Produto> list = produtoDAO.buscarTodos();
        for (Produto cli : list) {
            produtoDAO.excluir(cli);
        }
    }
}

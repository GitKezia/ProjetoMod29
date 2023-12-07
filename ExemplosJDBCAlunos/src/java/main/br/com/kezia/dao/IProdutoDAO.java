package br.com.kezia.dao;


import br.com.kezia.domain.Produto;

public interface IProdutoDAO {
    public Integer cadastrar(Produto produto) throws Exception;

    public Produto consultar(String codigo) throws Exception;

    public Integer excluir(Produto produtoBD) throws Exception;

    Produto buscarTodos() throws Exception;

    Integer atualizar(Produto produto) throws Exception;


}

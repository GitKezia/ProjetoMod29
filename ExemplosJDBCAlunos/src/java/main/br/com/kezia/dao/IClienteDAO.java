/**
 * 
 */
package br.com.kezia.dao;

import br.com.kezia.domain.Cliente;

public interface IClienteDAO {

	
	public Integer cadastrar(Cliente cliente) throws Exception;

	public Cliente consultar(String codigo) throws Exception;

	public Integer excluir(Cliente clienteBD) throws Exception;

	Cliente buscarTodos() throws Exception;

	Integer atualizar(Cliente cliente) throws Exception;
}

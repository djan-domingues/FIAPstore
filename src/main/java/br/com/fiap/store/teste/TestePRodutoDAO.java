package br.com.fiap.store.teste;

import java.util.Calendar;
import java.util.List;

import br.com.fiap.store.bean.Produto;
import br.com.fiap.store.dao.ProdutoDAO;
import br.com.fiap.store.exception.DBException;
import br.com.fiap.store.factory.DAOFactory;

public class TestePRodutoDAO {

	public static void main(String[] args) {
		ProdutoDAO dao = DAOFactory.getProdutoDAO();
		
		//Cadastrar
		Produto produto = new Produto(0, "caderno", 20, Calendar.getInstance(), 100);
		
		try {
			dao.cadastrar(produto);
			System.out.println("Produto cadastrado.");
		} catch(DBException ex) {
			ex.printStackTrace();
		}
		
		//Buscar um produto pelo codigo e atualizar
		produto = dao.buscar(1);
		produto.setNome("caderno capa dura");
		produto.setValor(30);
		try {
			dao.atualizar(produto);
			System.out.println("Produto Atualizado.");
		} catch(DBException ex) {
			ex.printStackTrace();
		}
		
		//Listar os produtos
		List<Produto> lista = dao.listar();
		for(Produto item : lista) {
			System.out.println(item.getNome() + " " + item.getQuantidade() + " " + item.getValor());
		}
		
		//Remover
		try {
			dao.remover(1);
			System.out.println("Produto removido.");
		} catch (DBException ex) {
			ex.printStackTrace();
		}

	}

}

package br.com.healthtrack.teste;

import java.util.List;

import br.com.healthtrack.bean.CategoriaAlimentacao;
import br.com.healthtrack.dao.CategoriaAlimentacaoDAO;
import br.com.healthtrack.factory.DAOFactory;

public class CategoriaAlimentacaoDAOTeste {
	public static void main(String[] args) {
		CategoriaAlimentacaoDAO dao = DAOFactory.getCategoriaAlimentacaoDAO();
		
		List<CategoriaAlimentacao> lista = dao.listar();
		
		for (CategoriaAlimentacao categoriaAlimentacao : lista) {
			System.out.println(categoriaAlimentacao.getId() + " "+ categoriaAlimentacao.getNome() );
		}
	}
}

package br.com.healthtrack.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.healthtrack.bean.CategoriaAlimentacao;
import br.com.healthtrack.dao.CategoriaAlimentacaoDAO;
import br.com.healthtrack.singleton.ConnectionManager;

public class OracleCategoriaAlimentacaoDAO implements CategoriaAlimentacaoDAO {
	
	  private Connection conexao;
	  
	  @Override
	  public List<CategoriaAlimentacao> listar() {
	    List<CategoriaAlimentacao> lista = new ArrayList<CategoriaAlimentacao>();
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    
	    try {
		    conexao = ConnectionManager.getInstance().getConnection();
		    stmt = conexao.prepareStatement("SELECT * FROM T_SHT_CATEGORIA_ALIMENTACAO ORDER BY NM_CATEGORIA_ALIMENTACAO ASC");
		    rs = stmt.executeQuery();

	      while (rs.next()) {
	        int id = rs.getInt("CD_CATEGORIA_ALIMENTACAO");
	        String nome = rs.getString("NM_CATEGORIA_ALIMENTACAO");
	        CategoriaAlimentacao categoriaAlimentacao = new CategoriaAlimentacao(id,nome);
	        lista.add(categoriaAlimentacao);
	      }
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }finally {
	      try {
	        stmt.close();
	        rs.close();
	        conexao.close();
	      } catch (SQLException e) {
	        e.printStackTrace();
	      }
	    }
	    return lista;
	  }
}
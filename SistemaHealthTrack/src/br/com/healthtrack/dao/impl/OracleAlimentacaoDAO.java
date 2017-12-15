package br.com.healthtrack.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.healthtrack.bean.Alimentacao;
import br.com.healthtrack.dao.AlimentacaoDAO;
import br.com.healthtrack.bean.CategoriaAlimentacao;
import br.com.healthtrack.exception.DBException;
import br.com.healthtrack.singleton.ConnectionManager;

public class OracleAlimentacaoDAO implements AlimentacaoDAO {
	private Connection conexao;
	
	@Override
	public void cadastrar(Alimentacao alimentacao) throws DBException {

		PreparedStatement stmt = null;
		
		try{
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO T_SHT_ALIMENTACAO (CD_ALIMENTACAO, DT_DATA, NM_ALIMENTO, QT_QUANTIDADE, NUM_CALORIAS, CD_CATEGORIA_ALIMENTACAO) VALUES (SQ_T_SHT_ALIMENTACAO.NEXTVAL, ?, ?, ?, ?, ?)";
			
			stmt = conexao.prepareStatement(sql);
			java.sql.Date data = new java.sql.Date(alimentacao.getData().getTimeInMillis());
			stmt.setDate(1, data);
			stmt.setString(2, alimentacao.getNome());
			stmt.setInt(3, alimentacao.getQuantidade());
			stmt.setInt(4, alimentacao.getCalorias());
			stmt.setInt(5, alimentacao.getCategoriaAlimentacao().getId());
			
			stmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao cadastrar.");
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void atualizar(Alimentacao alimentacao) throws DBException {
		PreparedStatement stmt = null;
		
		try{
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE T_SHT_ALIMENTACAO SET DT_DATA = ?, NM_ALIMENTO = ?, QT_QUANTIDADE = ?, NUM_CALORIAS = ?, CD_CATEGORIA_ALIMENTACAO = ? WHERE CD_ALIMENTACAO = ?";
			
			stmt = conexao.prepareStatement(sql);
			java.sql.Date data = new java.sql.Date(alimentacao.getData().getTimeInMillis());
			stmt.setDate(1, data);
			stmt.setString(2, alimentacao.getNome());
			stmt.setInt(3, alimentacao.getQuantidade());
			stmt.setInt(4, alimentacao.getCalorias());
			stmt.setInt(5, alimentacao.getCategoriaAlimentacao().getId());
			stmt.setInt(6, alimentacao.getId());
			
			stmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao atualizar.");
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void remover(int id) throws DBException {
		PreparedStatement stmt = null;
		
		try{
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "DELETE FROM T_SHT_ALIMENTACAO WHERE CD_ALIMENTACAO = ?";
			
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, id);
			
			stmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
			throw new DBException("Erro ao remover.");
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public Alimentacao buscar(int id) {
		Alimentacao alimentacao = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
	  
		  try {
		    conexao = ConnectionManager.getInstance().getConnection();
		    
		    stmt = conexao.prepareStatement("SELECT * FROM T_SHT_ALIMENTACAO INNER JOIN T_SHT_CATEGORIA_ALIMENTACAO ON T_SHT_ALIMENTACAO.CD_CATEGORIA_ALIMENTACAO = T_SHT_CATEGORIA_ALIMENTACAO.CD_CATEGORIA_ALIMENTACAO WHERE T_SHT_ALIMENTACAO.CD_ALIMENTACAO = ?");
		    
		    stmt.setInt(1, id);
		    rs = stmt.executeQuery();
		    
		    if (rs.next()){
		    	
		      int idAlimemtacao = rs.getInt("CD_ALIMENTACAO");
		      
		      java.sql.Date data = rs.getDate("DT_DATA");
		      Calendar dataAlimentacao = Calendar.getInstance();
		      dataAlimentacao.setTimeInMillis(data.getTime());
		      
		      String nome = rs.getString("NM_ALIMENTO");
		      int quantidade = rs.getInt("QT_QUANTIDADE");
		      int calorias = rs.getInt("NUM_CALORIAS");

		      int idCategoriaAlimentacao = rs.getInt("CD_CATEGORIA_ALIMENTACAO");
		      String nomeCategoriaAlimentacao = rs.getString("NM_CATEGORIA_ALIMENTACAO");
	
		      alimentacao = new Alimentacao(idAlimemtacao, dataAlimentacao, nome, quantidade, calorias);
		      CategoriaAlimentacao categoriaAlimentacao = new CategoriaAlimentacao(idCategoriaAlimentacao, nomeCategoriaAlimentacao);
		      alimentacao.setCategoriaAlimentacao(categoriaAlimentacao);
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
		  return alimentacao;
	}

	@Override
	public List< Alimentacao> listar() {
		
	  List<Alimentacao> lista = new ArrayList<Alimentacao>();
	  PreparedStatement stmt = null;
	  ResultSet rs = null;
	  
	  try {
	    conexao = ConnectionManager.getInstance().getConnection();
	    stmt = conexao.prepareStatement("SELECT * FROM T_SHT_ALIMENTACAO INNER JOIN T_SHT_CATEGORIA_ALIMENTACAO ON T_SHT_ALIMENTACAO.CD_CATEGORIA_ALIMENTACAO = T_SHT_CATEGORIA_ALIMENTACAO.CD_CATEGORIA_ALIMENTACAO ORDER BY DT_DATA DESC");
	    rs = stmt.executeQuery();

	    while (rs.next()) {
	    	
	      int idAlimemtacao = rs.getInt("CD_ALIMENTACAO");
	      
	      java.sql.Date data = rs.getDate("DT_DATA");
	      Calendar dataAlimentacao = Calendar.getInstance();
	      dataAlimentacao.setTimeInMillis(data.getTime());
	      
	      String nome = rs.getString("NM_ALIMENTO");
	      int quantidade = rs.getInt("QT_QUANTIDADE");
	      int calorias = rs.getInt("NUM_CALORIAS");
	      
	      int idCategoriaAlimentacao = rs.getInt("CD_CATEGORIA_ALIMENTACAO");
	      String nomeCategoriaAlimentacao = rs.getString("NM_CATEGORIA_ALIMENTACAO");

	      Alimentacao alimentacao = new Alimentacao(idAlimemtacao, dataAlimentacao, nome, quantidade, calorias);
	      CategoriaAlimentacao categoriaAlimentacao = new CategoriaAlimentacao(idCategoriaAlimentacao, nomeCategoriaAlimentacao);
	      alimentacao.setCategoriaAlimentacao(categoriaAlimentacao);
	      lista.add(alimentacao);
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

package br.com.healthtrack.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.healthtrack.bean.Peso;
import br.com.healthtrack.dao.PesoDAO;
import br.com.healthtrack.exception.DBException;
import br.com.healthtrack.singleton.ConnectionManager;

public class OraclePesoDAO implements PesoDAO {

	private Connection conexao;
	
	@Override
	public void cadastrar(Peso peso) throws DBException {
		//para definir a query e os parâmetros que serão exercutados no banco de dados
		PreparedStatement stmt = null;
		
		try{
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO T_SHT_PESO (CD_PESO, DT_DATA, NUM_PESO) VALUES (SQ_T_SHT_PESO.NEXTVAL, ?, ?)";
			
			stmt = conexao.prepareStatement(sql);
			java.sql.Date data = new java.sql.Date(peso.getData().getTimeInMillis());
			stmt.setDate(1, data);
			stmt.setDouble(2, peso.getPeso());
			
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
	public void atualizar(Peso peso) throws DBException {
		PreparedStatement stmt = null;
		
		try{
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE T_SHT_PESO SET DT_DATA = ?, NUM_PESO = ? WHERE CD_PESO = ?";
			
			stmt = conexao.prepareStatement(sql);
			java.sql.Date data = new java.sql.Date(peso.getData().getTimeInMillis());
			stmt.setDate(1, data);
			stmt.setDouble(2, peso.getPeso());
			stmt.setInt(3, peso.getId());
			
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
			String sql = "DELETE FROM T_SHT_PESO WHERE CD_PESO = ?";
			
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
	public Peso buscar(int id) {
	  Peso peso = null;
	  PreparedStatement stmt = null;
	  ResultSet rs = null;
	  
	  try {
	    conexao = ConnectionManager.getInstance().getConnection();
	    
	    stmt = conexao.prepareStatement("SELECT * FROM T_SHT_PESO WHERE CD_PESO = ?");
	    
	    stmt.setInt(1, id);
	    rs = stmt.executeQuery();
	    
	    if (rs.next()){
	    	
	      int idPeso = rs.getInt("CD_PESO");
	      
	      java.sql.Date data = rs.getDate("DT_DATA");
	      Calendar dataPeso = Calendar.getInstance();
	      dataPeso.setTimeInMillis(data.getTime());
	      
	      double vlPeso = rs.getDouble("NUM_PESO");

	      peso = new Peso(idPeso, dataPeso, vlPeso);
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
	  return peso;
	}

	@Override
	public List< Peso> listar() {
		
	  List<Peso> lista = new ArrayList<Peso>();
	  PreparedStatement stmt = null;
	  ResultSet rs = null;
	  
	  try {
	    conexao = ConnectionManager.getInstance().getConnection();
	    stmt = conexao.prepareStatement("SELECT * FROM T_SHT_PESO ORDER BY DT_DATA DESC");
	    rs = stmt.executeQuery();

	    //Percorre todos os registros encontrados
	    while (rs.next()) {
	    	
	      int id = rs.getInt("CD_PESO");
	      
	      java.sql.Date data = rs.getDate("DT_DATA");
	      Calendar dataPeso = Calendar.getInstance();
	      dataPeso.setTimeInMillis(data.getTime());
	      
	      double vlPeso = rs.getDouble("NUM_PESO");
	        
	      Peso peso = new Peso(id, dataPeso, vlPeso);
	      lista.add(peso);
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

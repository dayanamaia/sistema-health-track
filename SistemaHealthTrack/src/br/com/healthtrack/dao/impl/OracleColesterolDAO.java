package br.com.healthtrack.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.healthtrack.bean.Colesterol;
import br.com.healthtrack.dao.ColesterolDAO;
import br.com.healthtrack.exception.DBException;
import br.com.healthtrack.singleton.ConnectionManager;

public class OracleColesterolDAO implements ColesterolDAO {
	private Connection conexao;
	
	@Override
	public void cadastrar(Colesterol colesterol) throws DBException {

		PreparedStatement stmt = null;
		
		try{
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO T_SHT_COLESTEROL (CD_COLESTEROL, DT_DATA, NUM_COLESTEROL_TOTAL, NUM_TRIGLICERIDES, NUM_LDL, NUM_HDL, OBS_OBSERVACAO) VALUES (SQ_T_SHT_COLESTEROL.NEXTVAL, ?, ?, ?, ?, ?, ?)";
			
			stmt = conexao.prepareStatement(sql);
			java.sql.Date data = new java.sql.Date(colesterol.getData().getTimeInMillis());
			stmt.setDate(1, data);
			stmt.setInt(2, colesterol.getColesterolTotal());
			stmt.setInt(3, colesterol.getTriglicerides());
			stmt.setInt(4, colesterol.getLdl());
			stmt.setInt(5, colesterol.getHdl());
			stmt.setString(6, colesterol.getObservacao());
			
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
	public void atualizar(Colesterol colesterol) throws DBException {
		PreparedStatement stmt = null;
		
		try{
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE T_SHT_COLESTEROL SET DT_DATA = ?, NUM_COLESTEROL_TOTAL = ?, NUM_TRIGLICERIDES = ?, NUM_LDL = ?, NUM_HDL = ?, OBS_OBSERVACAO = ? WHERE CD_COLESTEROL = ?";
			
			stmt = conexao.prepareStatement(sql);
			java.sql.Date data = new java.sql.Date(colesterol.getData().getTimeInMillis());
			stmt.setDate(1, data);
			stmt.setInt(2, colesterol.getColesterolTotal());
			stmt.setInt(3, colesterol.getTriglicerides());
			stmt.setInt(4, colesterol.getLdl());
			stmt.setInt(5, colesterol.getHdl());
			stmt.setString(6, colesterol.getObservacao());
			stmt.setInt(7, colesterol.getId());
			
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
			String sql = "DELETE FROM T_SHT_COLESTEROL WHERE CD_COLESTEROL = ?";
			
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
	public Colesterol buscar(int id) {
		Colesterol colesterol = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
	  
		  try {
		    conexao = ConnectionManager.getInstance().getConnection();
		    
		    stmt = conexao.prepareStatement("SELECT * FROM T_SHT_COLESTEROL WHERE CD_COLESTEROL = ?");
		    
		    stmt.setInt(1, id);
		    rs = stmt.executeQuery();
		    
		    if (rs.next()){
		    	
		      int idColesterol = rs.getInt("CD_COLESTEROL");
		      
		      java.sql.Date data = rs.getDate("DT_DATA");
		      Calendar dataColesterol = Calendar.getInstance();
		      dataColesterol.setTimeInMillis(data.getTime());
		      
		      int colesterolTotal = rs.getInt("NUM_COLESTEROL_TOTAL");
		      int triglicerides = rs.getInt("NUM_TRIGLICERIDES");
		      int ldl = rs.getInt("NUM_LDL");
		      int hdl = rs.getInt("NUM_HDL");
		      String observacao = rs.getString("OBS_OBSERVACAO");
	
		      colesterol = new Colesterol(idColesterol, dataColesterol, colesterolTotal, triglicerides, ldl, hdl, observacao);
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
		  return colesterol;
	}

	@Override
	public List< Colesterol> listar() {
		
	  List<Colesterol> lista = new ArrayList<Colesterol>();
	  PreparedStatement stmt = null;
	  ResultSet rs = null;
	  
	  try {
	    conexao = ConnectionManager.getInstance().getConnection();
	    stmt = conexao.prepareStatement("SELECT * FROM T_SHT_COLESTEROL ORDER BY DT_DATA DESC");
	    rs = stmt.executeQuery();

	    while (rs.next()) {
	    	
	      int idColesterol = rs.getInt("CD_COLESTEROL");
	      
	      java.sql.Date data = rs.getDate("DT_DATA");
	      Calendar dataColesterol = Calendar.getInstance();
	      dataColesterol.setTimeInMillis(data.getTime());
	      
	      int colesterolTotal = rs.getInt("NUM_COLESTEROL_TOTAL");
	      int triglicerides = rs.getInt("NUM_TRIGLICERIDES");
	      int ldl = rs.getInt("NUM_LDL");
	      int hdl = rs.getInt("NUM_HDL");
	      String observacao = rs.getString("OBS_OBSERVACAO");

	      Colesterol colesterol = new Colesterol(idColesterol, dataColesterol, colesterolTotal, triglicerides, ldl, hdl, observacao);
	      lista.add(colesterol);
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

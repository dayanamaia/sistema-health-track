package br.com.healthtrack.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.healthtrack.bean.PressaoArterial;
import br.com.healthtrack.dao.PressaoArterialDAO;
import br.com.healthtrack.exception.DBException;
import br.com.healthtrack.singleton.ConnectionManager;

public class OraclePressaoArterialDAO implements PressaoArterialDAO {
	private Connection conexao;
	
	@Override
	public void cadastrar(PressaoArterial presaoArterial) throws DBException {

		PreparedStatement stmt = null;
		
		try{
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO T_SHT_PRESSAO_ARTERIAL (CD_PRESSOA_ARTERIAL, DT_DATA, NUM_SISTOTICA_MAIOR, NUM_DIASTOTICA_MENOR, OBS_OBSERVACAO) VALUES (SQ_T_SHT_PRESSAO_ARTERIAL.NEXTVAL, ?, ?, ?, ?)";
			
			stmt = conexao.prepareStatement(sql);
			java.sql.Date data = new java.sql.Date(presaoArterial.getData().getTimeInMillis());
			stmt.setDate(1, data);
			stmt.setInt(2, presaoArterial.getSistoticaMaior());
			stmt.setInt(3, presaoArterial.getDiastoticaMenor());
			stmt.setString(4, presaoArterial.getObservacao());
			
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
	public void atualizar(PressaoArterial presaoArterial) throws DBException {
		PreparedStatement stmt = null;
		
		try{
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE T_SHT_PRESSAO_ARTERIAL SET DT_DATA = ?, NUM_SISTOTICA_MAIOR = ?, NUM_DIASTOTICA_MENOR = ?, OBS_OBSERVACAO = ? WHERE CD_PRESSOA_ARTERIAL = ?";
			
			stmt = conexao.prepareStatement(sql);
			java.sql.Date data = new java.sql.Date(presaoArterial.getData().getTimeInMillis());
			stmt.setDate(1, data);
			stmt.setInt(2, presaoArterial.getSistoticaMaior());
			stmt.setInt(3, presaoArterial.getDiastoticaMenor());
			stmt.setString(4, presaoArterial.getObservacao());
			stmt.setInt(5, presaoArterial.getId());
			
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
			String sql = "DELETE FROM T_SHT_PRESSAO_ARTERIAL WHERE CD_PRESSOA_ARTERIAL = ?";
			
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
	public PressaoArterial buscar(int id) {
		PressaoArterial presaoArterial = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
	  
		  try {
		    conexao = ConnectionManager.getInstance().getConnection();
		    
		    stmt = conexao.prepareStatement("SELECT * FROM T_SHT_PRESSAO_ARTERIAL WHERE CD_PRESSOA_ARTERIAL = ?");
		    
		    stmt.setInt(1, id);
		    rs = stmt.executeQuery();
		    
		    if (rs.next()){
		    	
		      int idPressaoArterial = rs.getInt("CD_PRESSOA_ARTERIAL");
		      
		      java.sql.Date data = rs.getDate("DT_DATA");
		      Calendar dataPressaoArterial = Calendar.getInstance();
		      dataPressaoArterial.setTimeInMillis(data.getTime());
		      
		      int sistoticaMaior = rs.getInt("NUM_SISTOTICA_MAIOR");
		      int diastoticaMenor = rs.getInt("NUM_DIASTOTICA_MENOR");
		      String observacao = rs.getString("OBS_OBSERVACAO");
	
		      presaoArterial = new PressaoArterial(idPressaoArterial, dataPressaoArterial, sistoticaMaior, diastoticaMenor, observacao);
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
		  return presaoArterial;
	}

	@Override
	public List< PressaoArterial> listar() {
		
	  List<PressaoArterial> lista = new ArrayList<PressaoArterial>();
	  PreparedStatement stmt = null;
	  ResultSet rs = null;
	  
	  try {
	    conexao = ConnectionManager.getInstance().getConnection();
	    stmt = conexao.prepareStatement("SELECT * FROM T_SHT_PRESSAO_ARTERIAL ORDER BY DT_DATA DESC");
	    rs = stmt.executeQuery();

	    while (rs.next()) {
	    	
	      int idPressaoArterial = rs.getInt("CD_PRESSOA_ARTERIAL");
	      
	      java.sql.Date data = rs.getDate("DT_DATA");
	      Calendar dataPressaoArterial = Calendar.getInstance();
	      dataPressaoArterial.setTimeInMillis(data.getTime());
	      
	      int sistoticaMaior = rs.getInt("NUM_SISTOTICA_MAIOR");
	      int diastoticaMenor = rs.getInt("NUM_DIASTOTICA_MENOR");
	      String observacao = rs.getString("OBS_OBSERVACAO");

	      PressaoArterial presaoArterial = new PressaoArterial(idPressaoArterial, dataPressaoArterial, sistoticaMaior, diastoticaMenor, observacao);
	      lista.add(presaoArterial);
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

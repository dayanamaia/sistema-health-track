package br.com.healthtrack.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.Calendar;


import br.com.healthtrack.bean.Usuario;
import br.com.healthtrack.dao.UsuarioDAO;
import br.com.healthtrack.singleton.ConnectionManager;

public class OracleUsuarioDAO implements UsuarioDAO{
	
	private Connection conexao;

	@Override
	public boolean validarUsuario(Usuario usuario) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
		  conexao = ConnectionManager.getInstance().getConnection();
		  stmt = conexao.prepareStatement("SELECT * FROM T_SHT_USUARIO WHERE DS_EMAIL = ? AND DS_SENHA = ?");
		      stmt.setString(1, usuario.getEmail());
		      stmt.setString(2, usuario.getSenha());
		      rs = stmt.executeQuery();	      
		      
		      if (rs.next()){
		        return true;
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
		    return false;
	  }
	
	@Override
	public Usuario buscar(String email) {
	  Usuario usuario = null;
	  PreparedStatement stmt = null;
	  ResultSet rs = null;
	  
	  try {
	    conexao = ConnectionManager.getInstance().getConnection();
	    
	    stmt = conexao.prepareStatement("SELECT * FROM T_SHT_USUARIO WHERE DS_EMAIL = ?");
	    
	    stmt.setString(1, email);
	    rs = stmt.executeQuery();
	    
	    if (rs.next()){
	    	
	      int idUsuario = rs.getInt("CD_USUARIO");
	      String nome = rs.getString("NM_NOME");
	      int altura = rs.getInt("NUM_ALTURA");	      
	      
	      usuario = new Usuario(idUsuario, nome, altura);
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
	  return usuario;
	}
}

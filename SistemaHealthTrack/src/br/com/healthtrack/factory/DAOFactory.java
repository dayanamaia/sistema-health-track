package br.com.healthtrack.factory;

import br.com.healthtrack.dao.PesoDAO;
import br.com.healthtrack.dao.impl.OraclePesoDAO;

import br.com.healthtrack.dao.UsuarioDAO;
import br.com.healthtrack.dao.impl.OracleUsuarioDAO;

import br.com.healthtrack.dao.PressaoArterialDAO;
import br.com.healthtrack.dao.impl.OraclePressaoArterialDAO;

import br.com.healthtrack.dao.ColesterolDAO;
import br.com.healthtrack.dao.impl.OracleColesterolDAO;

import br.com.healthtrack.dao.AlimentacaoDAO;
import br.com.healthtrack.dao.impl.OracleAlimentacaoDAO;

import br.com.healthtrack.dao.CategoriaAlimentacaoDAO;
import br.com.healthtrack.dao.impl.OracleCategoriaAlimentacaoDAO;

public class DAOFactory {

	public static PesoDAO getPesoDAO() {
		return new OraclePesoDAO();
	}
	
	public static UsuarioDAO getUsuarioDAO() {
		return new OracleUsuarioDAO();
	}
	
	public static PressaoArterialDAO getPressaoArterialDAO() {
		return new OraclePressaoArterialDAO();
	}
	
	public static AlimentacaoDAO getAlimentacaoDAO() {
		return new OracleAlimentacaoDAO();
	}
	
	public static CategoriaAlimentacaoDAO getCategoriaAlimentacaoDAO() {
		return new OracleCategoriaAlimentacaoDAO();
	}
	
	public static ColesterolDAO getColesterolDAO() {
		return new OracleColesterolDAO();
	}
}

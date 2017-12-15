package br.com.healthtrack.dao;

import java.util.List;

import br.com.healthtrack.bean.Colesterol;
import br.com.healthtrack.exception.DBException;

public interface ColesterolDAO {
	void cadastrar(Colesterol colesterol) throws DBException;
	void atualizar(Colesterol colesterol) throws DBException;
	void remover(int id) throws DBException;
	Colesterol buscar(int id);
	List<Colesterol> listar();
}

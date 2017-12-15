package br.com.healthtrack.dao;

import java.util.List;

import br.com.healthtrack.bean.PressaoArterial;
import br.com.healthtrack.exception.DBException;

public interface PressaoArterialDAO {
	void cadastrar(PressaoArterial presaoArterial) throws DBException;
	void atualizar(PressaoArterial presaoArterial) throws DBException;
	void remover(int id) throws DBException;
	PressaoArterial buscar(int id);
	List<PressaoArterial> listar();
}

package br.com.healthtrack.dao;

import java.util.List;

import br.com.healthtrack.bean.Alimentacao;
import br.com.healthtrack.exception.DBException;

public interface AlimentacaoDAO {
	void cadastrar(Alimentacao alimentacao) throws DBException;
	void atualizar(Alimentacao alimentacao) throws DBException;
	void remover(int id) throws DBException;
	Alimentacao buscar(int id);
	List<Alimentacao> listar();
}

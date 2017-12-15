package br.com.healthtrack.dao;

import br.com.healthtrack.bean.Usuario;

public interface UsuarioDAO {
	boolean validarUsuario(Usuario usuario);
	Usuario buscar(String email);
}

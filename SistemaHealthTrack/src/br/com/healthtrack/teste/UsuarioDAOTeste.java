package br.com.healthtrack.teste;

import br.com.healthtrack.bean.Usuario;
import br.com.healthtrack.dao.UsuarioDAO;
//import br.com.healthtrack.exception.DBException;
import br.com.healthtrack.factory.DAOFactory;

public class UsuarioDAOTeste {
	public static void main(String[] args) {
		UsuarioDAO dao = DAOFactory.getUsuarioDAO();
		String email = "dayanamaia.developer@gmail.com";
		String senha = "732002cec7aeb7987bde842b9e00ee3b";
		
		Usuario usuario = new Usuario(email, senha);
		System.out.println(usuario.getSenha());
		System.out.println(dao.validarUsuario(usuario));
		if(dao.validarUsuario(usuario)) {
			System.out.println(email);
		}
	}
}

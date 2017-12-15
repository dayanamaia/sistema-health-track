package br.com.healthtrack.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.healthtrack.bean.Usuario;
//import br.com.healthtrack.bo.EmailBO;
import br.com.healthtrack.dao.UsuarioDAO;
//import br.com.healthtrack.exception.EmailException;
import br.com.healthtrack.factory.DAOFactory;


@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UsuarioDAO dao;
	//private EmailBO bo;
       

    public HomeServlet() {
        dao = DAOFactory.getUsuarioDAO();
        //bo = new EmailBO();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	  HttpSession session = request.getSession();
    	  session.invalidate();
    	  request.getRequestDispatcher("home.jsp").forward(request, response);
    	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String email = request.getParameter("email");
	    String senha = request.getParameter("password");
	    
	    Usuario usuario = new Usuario(email, senha);
	    
	    if (dao.validarUsuario(usuario)) {
	        HttpSession session = request.getSession();
	        Usuario user = dao.buscar(email);
	        String nome = user.getNome();
	        int altura = user.getAltura();
	        
	        session.setAttribute("userNome", nome);
	        session.setAttribute("userAltura", altura);

//	        String mensagem = "Um login foi realizado";
//	        
//	        try {
//	          bo.enviarEmail(email, "Login Realizado", mensagem);
//	        } catch (EmailException e) {
//	          e.printStackTrace();
//	        }
	        request.getRequestDispatcher("dashboard.jsp").forward(request, response);
	        
	      }else {
	        request.setAttribute("erro", "Usuário e/ou senha inválidos");
	        request.getRequestDispatcher("home.jsp").forward(request, response);
	      }
	}

}

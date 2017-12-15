package br.com.healthtrack.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.healthtrack.bean.Alimentacao;
import br.com.healthtrack.bean.CategoriaAlimentacao;
import br.com.healthtrack.dao.AlimentacaoDAO;
import br.com.healthtrack.dao.CategoriaAlimentacaoDAO;
import br.com.healthtrack.exception.DBException;
import br.com.healthtrack.factory.DAOFactory;


@WebServlet("/alimentacao")
public class AlimentacaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AlimentacaoDAO dao;
	private CategoriaAlimentacaoDAO categoriaAlimentacaoDAO;
       
	@Override
	public void init() throws ServletException {
		super.init();
		dao = DAOFactory.getAlimentacaoDAO();
		categoriaAlimentacaoDAO = DAOFactory.getCategoriaAlimentacaoDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String acao = request.getParameter("acao");
		
		switch(acao) {
		case "cadastrar":
			cadastrar(request, response);
			break;
		case "editar":
			editar(request, response);
			break;
		case "excluir":
			excluir(request, response);
			break;
		}
	}

	private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try{
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Calendar data = Calendar.getInstance();
			data.setTime(format.parse(request.getParameter("date")));
			
			String nome = request.getParameter("name-food");
			int quantidade = Integer.parseInt(request.getParameter("qtd-food"));
			int calorias = Integer.parseInt(request.getParameter("calorie"));
		    int idCategoriaAlimentacao = Integer.parseInt(request.getParameter("type_food"));

		    CategoriaAlimentacao categoriaAlimentacao = new CategoriaAlimentacao();
		    categoriaAlimentacao.setId(idCategoriaAlimentacao);
			
			Alimentacao alimentacao = new Alimentacao(0, data, nome, quantidade, calorias);
			alimentacao.setCategoriaAlimentacao(categoriaAlimentacao);
			dao.cadastrar(alimentacao);
			
			request.setAttribute("msg", "Pressao Arterial cadastrada!");
		} catch(DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao cadastrar");
	    } catch(Exception e){
	    	e.printStackTrace();
	    	request.setAttribute("erro","Por favor, valide os dados");
	    }
		formAlimentacaoCadastrar(request, response);
	}
	
	private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try{
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Calendar data = Calendar.getInstance();
			data.setTime(format.parse(request.getParameter("date")));
			
			String nome = request.getParameter("name-food");
			int quantidade = Integer.parseInt(request.getParameter("qtd-food"));
			int calorias = Integer.parseInt(request.getParameter("calorie"));
			
			Alimentacao alimentacao = new Alimentacao(0, data, nome, quantidade, calorias);
			dao.atualizar(alimentacao);
			
			request.setAttribute("msg", "Pressao Arterial atualizada!");
		} catch(DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao atualizar");
	    } catch(Exception e){
	    	e.printStackTrace();
	    	request.setAttribute("erro","Por favor, valide os dados");
	    }
		listar(request, response);
	}

	private void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int id = Integer.parseInt(request.getParameter("id"));
		try{			
			dao.remover(id);
			request.setAttribute("msg", "Produto atualizado!");
		} catch(DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao atualizar");
	    }
		listar(request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  String acao = request.getParameter("acao");
	    
	  switch (acao) {
	  case "listar":
	    listar(request, response);
	    break;
	  case "form-alimentacao-editar":
		 formAlimentacaoEditar(request, response);
	  	break;
	  case "form-alimentacao-cadastrar":
		  formAlimentacaoCadastrar(request, response);
	  } 
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Alimentacao> lista = dao.listar();
	    request.setAttribute("alimentacao", lista);
	    request.getRequestDispatcher("alimentacao.jsp").forward(request, response);
	}
	
	private void formAlimentacaoEditar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Alimentacao alimentacao = dao.buscar(id);
	    request.setAttribute("alimentacao", alimentacao);
	    request.getRequestDispatcher("form-alimentacao-editar.jsp").forward(request, response);
	}
	
	private void formAlimentacaoCadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<CategoriaAlimentacao> lista = categoriaAlimentacaoDAO.listar();
	    request.setAttribute("categoriaAlimentacao", lista);
	    request.getRequestDispatcher("form-alimentacao.jsp").forward(request, response);
	}

}

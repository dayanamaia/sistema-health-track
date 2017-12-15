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

import br.com.healthtrack.bean.Peso;
import br.com.healthtrack.dao.PesoDAO;
import br.com.healthtrack.exception.DBException;
import br.com.healthtrack.factory.DAOFactory;


@WebServlet("/peso")
public class PesoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PesoDAO dao;
       
	@Override
	public void init() throws ServletException {
		super.init();
		dao = DAOFactory.getPesoDAO();
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
			double valPeso = Double.parseDouble(request.getParameter("weight"));
			
			Peso peso = new Peso(0, data, valPeso);
			dao.cadastrar(peso);
			
			request.setAttribute("msg", "Produto cadastrado!");
		} catch(DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao cadastrar");
	    } catch(Exception e){
	    	e.printStackTrace();
	    	request.setAttribute("erro","Por favor, valide os dados");
	    }
		request.getRequestDispatcher("peso.jsp").forward(request, response);
	}
	
	private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try{
			int id = Integer.parseInt(request.getParameter("id"));
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Calendar data = Calendar.getInstance();
			data.setTime(format.parse(request.getParameter("date")));
			double valPeso = Double.parseDouble(request.getParameter("weight"));
			
			Peso peso = new Peso(id, data, valPeso);
			dao.atualizar(peso);
			
			request.setAttribute("msg", "Produto atualizado!");
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
	  case "form-peso-editar":
	    formPesoEditar(request, response);
	  } 
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Peso> lista = dao.listar();
	    request.setAttribute("peso", lista);
	    request.getRequestDispatcher("peso.jsp").forward(request, response);
	}
	
	private void formPesoEditar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
	    Peso peso = dao.buscar(id);
	    request.setAttribute("peso", peso);
	    request.getRequestDispatcher("form-peso-editar.jsp").forward(request, response);
	}

}

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

import br.com.healthtrack.bean.Colesterol;
import br.com.healthtrack.dao.ColesterolDAO;
import br.com.healthtrack.exception.DBException;
import br.com.healthtrack.factory.DAOFactory;


@WebServlet("/colesterol")
public class ColesterolServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ColesterolDAO dao;
       
	@Override
	public void init() throws ServletException {
		super.init();
		dao = DAOFactory.getColesterolDAO();
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
			
			int colesterolTotal = Integer.parseInt(request.getParameter("total-cholesterol"));
			int triglicerides = Integer.parseInt(request.getParameter("triglicerides"));
			int ldl = Integer.parseInt(request.getParameter("ldl"));
			int hdl = Integer.parseInt(request.getParameter("hdl"));
			String observacao = request.getParameter("obs");
			
			Colesterol colesterol = new Colesterol(0, data, colesterolTotal, triglicerides, ldl, hdl, observacao);
			dao.cadastrar(colesterol);
			
			request.setAttribute("msg", "Pressao Arterial cadastrada!");
		} catch(DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao cadastrar");
	    } catch(Exception e){
	    	e.printStackTrace();
	    	request.setAttribute("erro","Por favor, valide os dados");
	    }
		request.getRequestDispatcher("colesterol.jsp").forward(request, response);
	}
	
	private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try{
			int id = Integer.parseInt(request.getParameter("id"));
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Calendar data = Calendar.getInstance();
			data.setTime(format.parse(request.getParameter("date")));
			int colesterolTotal = Integer.parseInt(request.getParameter("total-cholesterol"));
			int triglicerides = Integer.parseInt(request.getParameter("triglicerides"));
			int ldl = Integer.parseInt(request.getParameter("ldl"));
			int hdl = Integer.parseInt(request.getParameter("hdl"));
			String observacao = request.getParameter("obs");
			
			Colesterol colesterol = new Colesterol(id, data, colesterolTotal, triglicerides, ldl, hdl, observacao);
			dao.atualizar(colesterol);
			
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
	  case "form-colesterol-editar":
		  formColesterolEditar(request, response);
	  } 
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Colesterol> lista = dao.listar();
	    request.setAttribute("colesterol", lista);
	    request.getRequestDispatcher("colesterol.jsp").forward(request, response);
	}
	
	private void formColesterolEditar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
	    Colesterol colesterol = dao.buscar(id);
	    request.setAttribute("colesterol", colesterol);
	    request.getRequestDispatcher("form-colesterol-editar.jsp").forward(request, response);
	}

}

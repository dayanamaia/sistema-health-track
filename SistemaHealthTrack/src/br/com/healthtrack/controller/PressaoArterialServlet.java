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

import br.com.healthtrack.bean.PressaoArterial;
import br.com.healthtrack.dao.PressaoArterialDAO;
import br.com.healthtrack.exception.DBException;
import br.com.healthtrack.factory.DAOFactory;


@WebServlet("/pressao-arterial")
public class PressaoArterialServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PressaoArterialDAO dao;
       
	@Override
	public void init() throws ServletException {
		super.init();
		dao = DAOFactory.getPressaoArterialDAO();
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
			
			int sistoticaMaior = Integer.parseInt(request.getParameter("sistotica_maior"));
			int diastoticaMenor = Integer.parseInt(request.getParameter("diastotica_menor"));
			String observacao = request.getParameter("obs");
			
			PressaoArterial pressaoArterial = new PressaoArterial(0, data, sistoticaMaior, diastoticaMenor, observacao);
			dao.cadastrar(pressaoArterial);
			
			request.setAttribute("msg", "Pressao Arterial cadastrada!");
		} catch(DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao cadastrar");
	    } catch(Exception e){
	    	e.printStackTrace();
	    	request.setAttribute("erro","Por favor, valide os dados");
	    }
		request.getRequestDispatcher("pressao-arterial.jsp").forward(request, response);
	}
	
	private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try{
			int id = Integer.parseInt(request.getParameter("id"));
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Calendar data = Calendar.getInstance();
			data.setTime(format.parse(request.getParameter("date")));
			int sistoticaMaior = Integer.parseInt(request.getParameter("sistotica_maior"));
			int diastoticaMenor = Integer.parseInt(request.getParameter("diastotica_menor"));
			String observacao = request.getParameter("obs");
			
			PressaoArterial pressaoArterial = new PressaoArterial(id, data, sistoticaMaior, diastoticaMenor, observacao);
			dao.atualizar(pressaoArterial);
			
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
	  case "form-pressao-arterial-editar":
		  formPressaoEditar(request, response);
	  } 
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<PressaoArterial> lista = dao.listar();
	    request.setAttribute("pressao", lista);
	    request.getRequestDispatcher("pressao-arterial.jsp").forward(request, response);
	}
	
	private void formPressaoEditar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
	    PressaoArterial pressaoArterial = dao.buscar(id);
	    request.setAttribute("pressaoArterial", pressaoArterial);
	    request.getRequestDispatcher("form-pressao-arterial-editar.jsp").forward(request, response);
	}

}

package br.com.healthtrack.teste;

//import java.util.Calendar;
import java.util.List;

import br.com.healthtrack.bean.Peso;
import br.com.healthtrack.dao.PesoDAO;
//import br.com.healthtrack.exception.DBException;
import br.com.healthtrack.factory.DAOFactory;

public class PesoDAOTeste {
	public static void main(String[] args) {
		
		PesoDAO dao = DAOFactory.getPesoDAO();
		
//		//Cadastrar um peso - teste
//		Peso peso = new Peso(2, Calendar.getInstance(), 60);
//		try {
//			dao.cadastrar(peso);
//			System.out.println("Peso cadastrado.");
//		} catch (DBException e) {
//			e.printStackTrace();
//		}
//		
//		//Buscar um peso pelo id e atualizar
//		peso = dao.buscar(14);
//		peso.setData(Calendar.getInstance());
//		peso.setPeso(70);
//		try {
//			dao.atualizar(peso);
//			System.out.println("Peso atualizado.");
//		} catch(DBException e) {
//			e.printStackTrace();
//		}
		
		//Listar os pesos
		List<Peso> lista = dao.listar();
		if(lista.isEmpty()){
			System.out.print("vazia");
		} else {
			for(Peso item:lista) {
				System.out.println(item.getPeso());
			}	
		}
		
	    //Remover um peso
//	    try {
//	      dao.remover(12);
//	      System.out.println("Produto removido.");
//	    } catch (DBException e) {
//	      e.printStackTrace();
//	    } 
	}
}

//package br.com.healthtrack.teste;
//
//import java.util.Calendar;
////import java.util.List;
//
//import br.com.healthtrack.bean.PressaoArterial;
//import br.com.healthtrack.dao.PressaoArterialDAO;
//import br.com.healthtrack.exception.DBException;
//import br.com.healthtrack.factory.DAOFactory;
//
//public class PressaoArterialDAOTeste {
//	
//	public static void main(String[] args) {
//		PressaoArterialDAO dao = DAOFactory.getPressaoArterialDAO();
//		PressaoArterial pressaoArterial = new PressaoArterial(3, Calendar.getInstance(), 140, 200, "fsfsdfsdf");
//
//		pressaoArterial = dao.buscar(3);
//		pressaoArterial.setData(Calendar.getInstance());
//		pressaoArterial.setSistoticaMaior(888);
//		pressaoArterial.setDiastoticaMenor(666);
//		pressaoArterial.setObservacao("rrrrrr");
//		try {
//			dao.atualizar(pressaoArterial);
//			System.out.println("Pressao atualizada.");
//		} catch(DBException e) {
//			e.printStackTrace();
//		}
//	}
//}

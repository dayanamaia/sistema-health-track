package br.com.healthtrack.teste;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TesteConnection {

 public static void main(String[] args) {
	 try {
		 //Registra o Driver
		 Class.forName("oracle.jdbc.OracleDriver");

		 //Abre uma conexão
		 Connection conexao = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","oracle123");
      
		 System.out.println("Conectado!");
      
		 PreparedStatement stmt = conexao.prepareStatement("SELECT CD_CATEGORIA, DT_DATA_CRIACAO, NM_CATEGORIA FROM T_SHT_CAT_ATIVIDADE_FISICA WHERE NM_CATEGORIA = ?");
		 stmt.setString(1, "Skate");
		 ResultSet result = stmt.executeQuery();
	      
		  //Percorre todos os registros encontrados
		  while (result.next()){
			  //Recupera os valores de cada coluna
			  int id = result.getInt("CD_CATEGORIA");
			  //Exibe as informações do registro
			  System.out.print(id);
		  }
      
		  //Fecha a conexão
		  conexao.close();
		  
		  //Tratamento de erro  
		  } catch (SQLException e) {
		    System.err.println("Não foi possível conectar no Banco de Dados");
		    e.printStackTrace();
		  } catch (ClassNotFoundException e) {
		    System.err.println("O Driver JDBC não foi encontrado!");
		    e.printStackTrace();
		  }
	}
}




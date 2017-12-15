package br.com.healthtrack.singleton;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager {

  private static ConnectionManager connectionManager;

  private ConnectionManager() {
  }

  public static ConnectionManager getInstance() {
    if (connectionManager == null) {
      connectionManager = new ConnectionManager();
    }
    return connectionManager;
  }

  public Connection getConnection() {
    Connection connection = null;
    try {

      Class.forName("oracle.jdbc.driver.OracleDriver");

      connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","oracle123");
    } catch (Exception e) {
      e.printStackTrace();
    }
    return connection;
  }

}
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;




public class Conexion {

    private static Connection cn;
   public static Connection conectar() throws Exception {
        
        
        String driver = "oracle.jdbc.OracleDriver";
            String url = "jdbc:oracle:thin:@localhost:1521/XE";
            String user = "DBSOFTBLOOM";
            String pwd = "@abc123@";
        try {
            
       Class.forName(driver).newInstance();
            cn = DriverManager.getConnection(url, user, pwd);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {

        }
        return cn;
    }
      
    

    public void cerrar() throws SQLException {
        if (cn != null) {
            if (cn.isClosed() == false) {
                cn.close();
            }
        }
    }

    public static void main(String[] args) throws SQLException, Exception {
        Conexion dao = new Conexion();
        dao.conectar();
        if (dao.getCn() != null) {
            System.out.println("Conectado");
        }
    }

    public Connection getCn() {
        return cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }
}